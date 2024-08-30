package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.FilmText;

public class FilmTextDAO extends GenericDAO<FilmText> {

    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
