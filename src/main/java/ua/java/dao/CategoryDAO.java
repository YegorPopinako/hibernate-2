package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Category;

public class CategoryDAO extends GenericDAO<Category> {

    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
