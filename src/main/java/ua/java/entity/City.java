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
@Table(name = "city", schema = "movie")
@Getter
@Setter
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
