package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Film;

public class FilmDAO extends GenericDAO<Film> {

    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
}
