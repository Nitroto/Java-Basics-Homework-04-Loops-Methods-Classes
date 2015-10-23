/**
 * Write a program to generate and print all symmetric numbers in given range [start…end] (0 ? start ? end ? 999).
 * A number is symmetric if its digits are symmetric toward its middle. For example, the numbers 101, 33, 989 and 5
 * are symmetric, but 102, 34 and 997 are not symmetric.
 */

import java.util.Scanner;

public class SymmetricNumbersInRange {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();
        if (start < 0 || start > end || end > 999) {
            System.out.println("Values of start and end should be in range of 0 to 999");
        } else {
            boolean noSymmetricNumber = true;
            for (int i = start; i <= end; i++) {
                if (i < 10) {
                    System.out.print(i + " ");
                    noSymmetricNumber = false;
                }
                if (i < 100) {
                    if (i % 10 == i / 10) {
                        System.out.print(i + " ");
                        noSymmetricNumber = false;
                    }
                }
                if (i > 100) {
                    if (i % 10 == i / 100) {
                        System.out.print(i + " ");
                        noSymmetricNumber = false;
                    }
                }

            }
            if (noSymmetricNumber) {
                System.out.printf("There are no symmetric numbers in yor range [%d to %d].", start, end);
            }
        }
    }
}
