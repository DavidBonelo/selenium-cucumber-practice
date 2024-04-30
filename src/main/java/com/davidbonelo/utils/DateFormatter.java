package com.davidbonelo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatter {
    private DateFormatter() {
        throw new IllegalStateException("Utility Class");
    }

    public static LocalDate parseUSDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM,yyyy", Locale.ENGLISH);
        return LocalDate.parse(date, formatter);
    }
}
