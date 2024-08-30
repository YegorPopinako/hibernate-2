package ua.java.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import ua.java.dao.ActorDAO;
import ua.java.dao.AddressDAO;
import ua.java.dao.CategoryDAO;
import ua.java.dao.CityDAO;
import ua.java.dao.CountryDAO;
import ua.java.dao.CustomerDAO;
import ua.java.dao.FilmDAO;
import ua.java.dao.FilmTextDAO;
import ua.java.dao.InventoryDAO;
import ua.java.dao.LanguageDAO;
import ua.java.dao.PaymentDAO;
import ua.java.dao.RentalDAO;
import ua.java.dao.StaffDAO;
import ua.java.dao.StoreDAO;

@Getter
public class MovieInitializer {

    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;

    public MovieInitializer(SessionFactory sessionFactory) {
        this.actorDAO = new ActorDAO(sessionFactory);
        this.addressDAO = new AddressDAO(sessionFactory);
        this.categoryDAO = new CategoryDAO(sessionFactory);
        this.cityDAO = new CityDAO(sessionFactory);
        this.countryDAO = new CountryDAO(sessionFactory);
        this.customerDAO = new CustomerDAO(sessionFactory);
        this.filmDAO = new FilmDAO(sessionFactory);
        this.filmTextDAO = new FilmTextDAO(sessionFactory);
        this.inventoryDAO = new InventoryDAO(sessionFactory);
        this.languageDAO = new LanguageDAO(sessionFactory);
        this.paymentDAO = new PaymentDAO(sessionFactory);
        this.rentalDAO = new RentalDAO(sessionFactory);
        this.staffDAO = new StaffDAO(sessionFactory);
        this.storeDAO = new StoreDAO(sessionFactory);
    }

}

