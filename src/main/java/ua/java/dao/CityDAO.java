package ua.java.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.java.entity.City;

public class CityDAO extends GenericDAO<City> {

    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getbyName(String name) {
        Query<City> query = getCurrentSession().createQuery("from City c where c.city = :name", City.class)
                .setParameter("name", name)
                .setMaxResults(1);
        return query.getSingleResult();
    }
}
