package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Store;

public class StoreDAO extends GenericDAO<Store> {

    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
