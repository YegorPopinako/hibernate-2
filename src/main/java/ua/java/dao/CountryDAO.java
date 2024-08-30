package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Country;

public class CountryDAO extends GenericDAO<Country> {

    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}
