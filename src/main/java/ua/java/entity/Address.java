package ua.java.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "address", schema = "movie")
@Getter
@Setter
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String address;

    private String address2;

    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "postal_code")
    private String postalCode;

    private String phone;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
