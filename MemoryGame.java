import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MemoryGame{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String[] cards = {"A", "A", "B", "B", "C", "C", "D", "D"};

        shuffle(cards);

        String[] board = new String[cards.length];
        Arrays.fill(board, " ");
        boolean[] flipped = new boolean[cards.length];

        int pairsFound = 0;

        System.out.println("Welcome to the Memory Game!");

        while (pairsFound < 4){

            printBoard(board);

            int first = getIndex(scanner, flipped, "Enter first card index:");
            board[first] = cards[first];
            flipped[first] = true;
            printBoard(board);

            int second = getIndex(scanner, flipped, "Enter second card index:");
            board[second] = cards[second];
            flipped[second] = true;
            printBoard(board);

            if (cards[first].equals(cards[second])){
                System.out.println("You found a pair!");
                pairsFound++;
            } else{
                System.out.println("Not a match!");
                board[first] = " ";
                board[second] = " ";
                flipped[first] = false;
                flipped[second] = false;
            }
        }

        System.out.println("Congratulations! You won the game!");
        scanner.close();
    }

    static void shuffle(String[] arr){
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(arr.length);
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static int getIndex(Scanner sc, boolean[] flipped, String msg){
        int index;
        while (true){
            System.out.println(msg);
            index = sc.nextInt();
            if (index < 0 || index >= flipped.length) {
                System.out.println("Invalid index!");
            } else if (flipped[index]) {
                System.out.println("Card already flipped!");
            } else {
                return index;
            }
        }
    }

    static void printBoard(String[] board){
        for (String s : board) {
            System.out.print("| " + s + " ");
        }
        System.out.println("|");
    }
}
