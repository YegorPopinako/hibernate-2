package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Rental;

public class RentalDAO extends GenericDAO<Rental> {

    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
}
