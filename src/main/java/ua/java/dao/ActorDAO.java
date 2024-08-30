package ua.java.dao;

import org.hibernate.SessionFactory;
import ua.java.entity.Actor;

public class ActorDAO extends GenericDAO<Actor> {

    public ActorDAO(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}
