package ua.java.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.java.entity.Film;

public class FilmDAO extends GenericDAO<Film> {

    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getFirstAvailableFilmForRent() {
        Query<Film> query = getCurrentSession().createQuery("from Film f where f.id not in " +
                "(select distinct film.id from Inventory)", Film.class)
                .setMaxResults(1);

        return query.getSingleResult();
    }
}
