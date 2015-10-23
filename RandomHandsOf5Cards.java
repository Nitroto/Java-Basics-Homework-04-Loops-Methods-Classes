/**
 * Write a program to generate n random hands of 5 different cards form a standard suit of 52 cards.
 */
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class RandomHandsOf5Cards {
    private static Random randomizer = new Random();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] faces = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        char[] suits = new char[]{'\u2663', '\u2666', '\u2665', '\u2660'};

        int numberOfHands = input.nextInt();

        for (int i = 0; i < numberOfHands; i++) {
            // Store only unique elements
            HashSet<String> hand = new HashSet<>();

            // Generate 5 different cards
            while (hand.size() < 5) {
                String face = faces[randomizer.nextInt(13)];
                char suit = suits[randomizer.nextInt(4)];
                String card = String.format("%s%c", face, suit);
                hand.add(card);
            }

            for(String card: hand){
                System.out.printf("%s ", card);
            }
            System.out.println();
        }
    }
}
