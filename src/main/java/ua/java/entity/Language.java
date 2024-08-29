package ua.java.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "language", schema = "movie")
@Getter
@Setter
public class Language {

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;

    @Column(columnDefinition = "char")
    private String name;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
