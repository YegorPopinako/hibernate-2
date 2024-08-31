package ua.java.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ua.java.enums.Rating;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        Rating[] values = Rating.values();
        for (Rating rating : values) {
            if (rating.getValue().equals(dbData)) {
                return rating;
            }
        }
        return null;
    }
}
