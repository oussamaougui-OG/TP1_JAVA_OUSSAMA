package Pres;

import IDao.IDao;
import metier.IMetier;

public class Presentation {

    public static void main(String[] args) throws Exception {

        // Chargement dynamique de la classe DaoImpl
        Class<?> daoClass = Class.forName("IDao.DaoImpl");

        // Création dynamique de l'objet Dao
        IDao dao = (IDao) daoClass.getDeclaredConstructor().newInstance();

        // Chargement dynamique de la classe MetierImpl
        Class<?> metierClass = Class.forName("metier.MetierImpl");

        // Création dynamique de l'objet Metier
        IMetier metier =
                (IMetier) metierClass.getDeclaredConstructor().newInstance();

        // Injection dynamique de Dao dans Metier
        metierClass
                .getMethod("setDao", IDao.class)
                .invoke(metier, dao);

        // Calcul
        System.out.println("Résultat = " + metier.calcul());
    }
}