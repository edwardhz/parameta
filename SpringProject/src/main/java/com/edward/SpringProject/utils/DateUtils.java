package com.edward.SpringProject.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateStr, formatter);
    }

    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static String calculateDurationFromNow(LocalDate date) {
        Period period = Period.between(date, LocalDate.now());
        return period.getYears() + " años, " + period.getMonths() + " meses, " + period.getDays() + " días";
    }
}