package ua.java;

import org.hibernate.SessionFactory;
import ua.java.util.MySessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    }
}