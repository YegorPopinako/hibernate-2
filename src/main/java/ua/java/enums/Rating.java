package ua.java.enums;

import lombok.Getter;

public enum Rating {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    @Getter
    private final String value;

    Rating(String value) {
        this.value = value;
    }
}
