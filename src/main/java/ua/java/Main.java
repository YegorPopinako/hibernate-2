package ua.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
import ua.java.entity.Actor;
import ua.java.entity.Address;
import ua.java.entity.Category;
import ua.java.entity.City;
import ua.java.entity.Customer;
import ua.java.entity.Film;
import ua.java.entity.FilmText;
import ua.java.entity.Inventory;
import ua.java.entity.Language;
import ua.java.entity.Payment;
import ua.java.entity.Rental;
import ua.java.entity.Staff;
import ua.java.entity.Store;
import ua.java.enums.Feature;
import ua.java.enums.Rating;
import ua.java.util.MySessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
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

    public Main(SessionFactory sessionFactory) {
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

    public static void main(String[] args) {
        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
        Main main = new Main(sessionFactory);
        main.newFilmReleased();
    }

    private void newFilmReleased() {
        try(Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction tr = session.beginTransaction();

            Language language = languageDAO.getItems(0, 20).stream().unordered().findAny().get();
            List<Category> categories = categoryDAO.getItems(0, 5);
            List<Actor> actors = actorDAO.getItems(0, 20);

            Film film = new Film();
            film.setActors(new HashSet<>(actors));
            film.setRating(Rating.G);
            film.setSpecialFeatures(Set.of(Feature.COMMENTARIES, Feature.DELETED_SCENES));
            film.setLength((short)120);
            film.setReplacementCost(BigDecimal.valueOf(19.99));
            film.setRentalRate(BigDecimal.valueOf(4.99));
            film.setDescription("Test description");
            film.setTitle("Test title");
            film.setRentalDuration((byte)3);
            film.setOriginalLanguage(language);
            film.setYear(Year.now());
            film.setCategories(new HashSet<>(categories));
            film.setLanguage(language);
            filmDAO.save(film);

            FilmText filmText = new FilmText();
            filmText.setFilm(film);
            filmText.setId(film.getId());
            filmText.setTitle("Test title");
            filmText.setDescription("Test description");
            filmTextDAO.save(filmText);
        }
    }

    private void customerRentInventoryToStore(Customer customer) {
        try(Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction tr = session.beginTransaction();

            Film film = filmDAO.getFirstAvailableFilmForRent();

            Store store = storeDAO.getItems(0, 1).get(0);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setInventory(inventory);
            rental.setCustomer(customer);
            rental.setStaff(staff);
            rental.setRentalDate(LocalDateTime.now());
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setRental(rental);
            payment.setStaff(staff);
            payment.setCustomer(customer);
            payment.setAmount(BigDecimal.valueOf(10.99));
            payment.setPaymentDate(LocalDateTime.now());
            paymentDAO.save(payment);

            tr.commit();
        }
    }

    private void customerReturnInventoryToStore() {
        try(Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction tr = session.beginTransaction();

            Rental rental = rentalDAO.retAnyUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());

            rentalDAO.save(rental);

            tr.commit();
        }
    }

    private Customer createCustomer() {
        try(Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction tr = session.beginTransaction();
            Store store = storeDAO.getItems(0, 1).get(0);
            City city = cityDAO.getbyName("Barcelona");

            Address address = new Address();
            address.setAddress("123 Main St");
            address.setCity(city);
            address.setPhone("555-555-5555");
            address.setDistrict("California");
            addressDAO.save(address);

            Customer customer = new Customer();
            customer.setIsActive(true);
            customer.setEmail("pBZwZ@example.com");
            customer.setAddress(address);
            customer.setStore(store);
            customer.setFirstName("John");
            customer.setLastName("Doe");
            customerDAO.save(customer);

            tr.commit();
            return customer;
        }
    }
}