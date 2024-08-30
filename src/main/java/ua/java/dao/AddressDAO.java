package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Address;

public class AddressDAO extends GenericDAO<Address> {

    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
