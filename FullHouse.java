/**
 * In most Poker games, the "full house" hand is defined as three cards of the same face + two cards of the same face,
 * other than the first, regardless of the card's suits. The cards faces are
 * "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" and "A".
 * The card suits are "♠", "♥", "♦" and "♣". .
 * Write a program to generate and print all full houses and print their number.
 */
public class FullHouse {

    public static void main(String[] args) {
        String[] faces = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        char[] suits = new char[]{'\u2663', '\u2666', '\u2665', '\u2660'};
        int fullHouseCaunter = 0;
        for (int firstSuit = 0; firstSuit < suits.length - 2; firstSuit++) {
            for (int secondSuit = firstSuit + 1; secondSuit < suits.length; secondSuit++) {
                for (int thirdSuit = secondSuit + 1; thirdSuit < suits.length; thirdSuit++) {
                    for (int fourthSuit = 0; fourthSuit < suits.length; fourthSuit++) {
                        for (int fifthSuit = fourthSuit + 1; fifthSuit < suits.length; fifthSuit++) {
                            for (int face3Cards = 0; face3Cards < faces.length; face3Cards++) {
                                for (int face2Cards = 0; face2Cards < faces.length; face2Cards++) {
                                    if (face3Cards != face2Cards) {
                                        String fullHouse = String.format("%1$s%3$c %1$s%4$c %1$s%5$c %2$s%6$c %2$s%7$c",
                                                faces[face3Cards], //1
                                                faces[face2Cards], //2
                                                suits[firstSuit], //3
                                                suits[secondSuit], //4
                                                suits[thirdSuit], //5
                                                suits[fourthSuit], //6
                                                suits[fifthSuit]); //7
                                        System.out.println(fullHouse);
                                        fullHouseCaunter++;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("%d full houses\n", fullHouseCaunter);
    }
}