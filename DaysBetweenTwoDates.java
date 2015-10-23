/**
 * Write a program to calculate the difference between two dates in number of days. The dates are entered at two
 * consecutive lines in format day-month-year. Days are in range [1�31]. Months are in range [1�12]. Years are
 * in range [1900�2100].
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetweenTwoDates {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d-MM-yyyy");
        String startDateInput = input.nextLine();
        String endDataInput = input.nextLine();

        LocalDate startDate = LocalDate.parse(startDateInput, dateFormat);
        LocalDate endDate = LocalDate.parse(endDataInput, dateFormat);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println(days);
    }
}
