package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Staff;

public class StaffDAO extends GenericDAO<Staff> {

    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}
