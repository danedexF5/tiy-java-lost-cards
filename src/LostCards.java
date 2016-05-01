/**
 * You once had a nice deck of cards.
 *
 * The cards in the decal had the following values:
 *  Ace = 1
 *  2 = 2
 *  3 = 3
 *  ... etc ...
 *  10 = 10
 *  Jack = 11
 *  Queen = 12
 *  King = 13
 *
 * The symbols for the suits are:
 *
 *  Clubs = ♣
 *  Diamonds = ♢
 *  Hearts = ♡
 *  Spades = ♠
 *
 * Unfortunately you've lost the following cards:
 *  - King of Spades
 *  - All of the 3s except 3 of Diamonds
 *
 * All of the cards that are divisible by 3 and have a suit that is red have been torn.
 *
 * All of the face cards (ace, jack, queen, king) in the hearts and clubs suits have been water damaged.
 *
 * Any card whose value is the same as the number of letters in the card's suit (in plural form) is face down. All other
 * cards are face up. For example, the 6 of Hearts would be face down because "Hearts" is 6 letters long and the value
 * of the card is 6.
 *
 * Your task is to describe your deck of cards:
 *
 * Output the cards in ascending order by value, grouped by suit, in alphabetical order.
 *  - Ace of Clubs, 2 of clubs, 3 of clubs ... etc ... queen of spades, king of spades.
 *
 * For face cards output the first letter of the card. IE: A, J, Q, or K.
 *
 * For 10s output "t".
 *
 * For all other cards output the value of the card. IE: 2, 3, 4...., or 9.
 *
 * Cards in good shape are output like this: [A♢], [9♠], [t♣], etc.
 *
 * Cards that are torn are output like this: -A♢-, -9♠-, -t♣-, etc.
 *
 * Cards that are water damaged are output like this: ~A♢~, ~9♠~, ~t♣~ etc
 *
 * Cards that are torn AND water damaged are output like this: -~A♢~-, -~9♠~-, -~t♣~- etc
 *
 * Cards that are face down are output with asterisks instead of the card's value and suit. For example, [**], -**-, or ~**~.
 *
 * Output one card per line.
 *
 * Lastly, output the number of cards you have in your deck on its own line.
 *
 */
public class LostCards {
    public static String cardToString(int s, int n, boolean t, boolean w, boolean fD){
        String[] symbols = {"♣", "♢", "♡", "♠"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "t", "J", "Q", "K"};
        String result = "";

        if (fD) {
            result = "**";
        }
        else{
            result = (ranks[n - 1] + symbols[s - 1]);
        }
        if(w){
            result = "~" + result + "~";
        }
        if(t){
            result = "-" + result + "-";
        }
        if(!t && !w){
            result = "[" + result + "]";
        }

        return result;

    }

    public static void main(String[] args) {


        for (int suit = 1; suit <= 4; suit++) {

        for (int number = 1; number <= 13; number++) {
            boolean torn = false;
            boolean wet = false;
            boolean faceDown = false;


                if (number == 13 && suit == 4 || number == 3 && suit != 2) {
                    System.out.println("Card Missing");
                }

                if ((number == 11 || number == 12 || number == 13 || number == 1) && (suit == 1 || suit == 3)) {
                    wet = true;
                }

                if ((number % 3 == 0) && (suit == 2 || suit == 3)) {
                    torn = true;

                }

                if ((number == 5) &&  (suit == 1)) {
                    faceDown = true;
                }

                    if ((number == 8) &&  (suit == 2)) {
                        faceDown = true;
                    }

                        if ((number == 6) &&  (suit == 3)) {
                            faceDown = true;
                        }

                if ((number == 6) &&  (suit == 4)) {
                    faceDown = true;
                }

               /* if (number == 1){
                    System.out.println("A");
                }

            if (number == 10) {
                System.out.println("T");
            }

                if (number == 11) {
                    System.out.println("J");
                }

            if (number == 12) {
                System.out.println("Q");
            }

            if (number == 13) {
                System.out.println("K");
            }

            if ((number >= 2) && (number <= 9)) {
                System.out.println(number);
            }*/

            System.out.println(cardToString(suit, number, torn, wet, faceDown));


                }
            }


        }
    }


