package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Language;

public class LanguageDAO extends GenericDAO<Language> {

    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
