/**
 * Write a method to convert from degrees to radians. Write a method to convert from radians to degrees.
 * You are given a number n and n queries for conversion. Each conversion query will consist of a
 * number + space + measure. Measures are "deg" and "rad". Convert all radians to degrees and all degrees
 * to radians. Print the results as n lines, each holding a number + space + measure. Format all numbers
 * with 6 digit after the decimal point.
 */

import java.util.Locale;
import java.util.Scanner;

public class AngleUnitConverter {

    private static final double PI = Math.PI;

    public static void main(String[] args) {
        Locale englishLocale = new Locale("en", "US");
        Locale.setDefault(englishLocale);
        Scanner input = new Scanner(System.in);
        int numberOfAngles = input.nextInt();
        for (int i = 0; i < numberOfAngles; i++) {
            double angleToConvert = input.nextDouble();
            String unit = input.next().toLowerCase();
            double angleConverted = 0;
            String newUnit = "";
            switch (unit) {
                case "deg":
                    angleConverted = convertDegreesToRadians(angleToConvert);
                    newUnit = "rad";
                    System.out.printf("%.6f %s\n", angleConverted, newUnit);
                    break;
                case "rad":
                    angleConverted = convertRadiansToDegrees(angleToConvert);
                    newUnit = "deg";
                    System.out.printf("%.6f %s\n", angleConverted, newUnit);
                    break;
                default:
                    System.out.println("Invalid measurement unit!");
                    break;
            }
        }

    }

    public static double convertDegreesToRadians(double degrees) {
        double radians = degrees * PI / 180d;
        return radians;
    }

    public static double convertRadiansToDegrees(double radians) {
        double degrees = radians * 180d / PI;
        return degrees;
    }
}
