package ua.java.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.java.entity.Rental;

public class RentalDAO extends GenericDAO<Rental> {

    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental retAnyUnreturnedRental() {
        Query<Rental> query = getCurrentSession().createQuery("from Rental r where r.returnDate is null", Rental.class)
                .setMaxResults(1);
        return query.getSingleResult();
    }
}
