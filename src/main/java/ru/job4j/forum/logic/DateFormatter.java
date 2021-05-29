package ru.job4j.forum.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy, HH:mm"
    );

    public static String parse(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }

}
