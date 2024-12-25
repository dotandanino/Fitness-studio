package gym.management;

import gym.customers.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * we build this class in order to help us with all the function using dates and make the code "cleaner".
 */
public class Dates {
    /**
     * in use for print the clients age and make sure someone is 18 or older.
     * @param p-the person we want to calculate is age.
     * @return the age of the person
     */
    public static int ageCalculator(Person p) {
        LocalDate now = LocalDate.now();
        LocalDate birth = p.getDate();
        Period period = Period.between(birth, now);
        return (period.getYears());
    }

    /**
     * in use to cast the person birthdate from string to LocalDate. and for the notify function for date.
     * @param str-the string of the date
     * @return the date as LocalDate
     */
    public static LocalDate toLocal(String str){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(str,formatter);
    }

    /**
     * we need this function to cast the Session date from string to LocalDateTime.
     * @param str-the string of the date.
     * @return the date as LocalDateTime.
     */
    public static LocalDateTime toLocalTime(String str){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(str,formatter);
    }
}
