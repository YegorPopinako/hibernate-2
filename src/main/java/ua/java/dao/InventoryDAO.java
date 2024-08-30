package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Inventory;

public class InventoryDAO extends GenericDAO<Inventory> {

    public InventoryDAO(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}
