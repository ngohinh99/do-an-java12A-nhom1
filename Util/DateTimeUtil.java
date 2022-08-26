package Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate convertStringToLocalDate(String dateString){
        return LocalDate.parse(dateString, formatter);
    }
    public static String convertLocalDateToString(LocalDate date){
        return date.format(formatter);
    }
}
