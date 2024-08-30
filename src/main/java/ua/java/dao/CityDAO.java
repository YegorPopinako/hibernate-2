package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.City;

public class CityDAO extends GenericDAO<City> {

    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }
}
