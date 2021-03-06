package dataAccess;

import dataAccess.interfaces.CountryDao;
import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by Arnaud on 13/02/2015.
 */
public class CountryJpaDao extends BaseJpa implements CountryDao {


    @Override
    public void create(Country obj) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(obj);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (t.isActive()) {
                t.rollback();
                em.close();
            }
        }
    }

    @Override
    public void update(Country obj) {

    }

    @Override
    public Country read(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Country> getCountries() {
        return null;
    }
}
