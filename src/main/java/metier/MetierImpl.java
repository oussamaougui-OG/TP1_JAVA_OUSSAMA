package metier;

import IDao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao;

    @Override
    public double calcul() {
        return dao.getData() * 2;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
