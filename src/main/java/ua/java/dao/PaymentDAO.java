package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Payment;

public class PaymentDAO extends GenericDAO<Payment> {

    public PaymentDAO(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
