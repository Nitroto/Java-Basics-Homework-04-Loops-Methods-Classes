import java.util.Scanner;

/**
 * Write a program to generate and print all 3-letter words consisting of given set of characters. For example if we
 * have the characters 'a' and 'b', all possible words will be "aaa", "aab", "aba", "abb", "baa", "bab", "bba" and "bbb".
 * The input characters are given as string at the first line of the input. Input characters are unique (there are no
 * repeating characters).
 */
public class Generate3LetterWords {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] characters = input.nextLine().toLowerCase().toCharArray();

        for (int firstCharacter = 0; firstCharacter < characters.length; firstCharacter++) {
            for (int secondCharacter = 0; secondCharacter < characters.length; secondCharacter++) {
                for (int thirdCharacter = 0; thirdCharacter < characters.length; thirdCharacter++) {
                    System.out.printf("%c%c%c ",characters[firstCharacter],characters[secondCharacter],characters[thirdCharacter]);
                }
            }
        }
    }
}
