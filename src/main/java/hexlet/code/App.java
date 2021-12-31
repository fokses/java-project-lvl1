package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static final String[] GAMES = {"Even", "Calc", "GCD", "Progression", "Prime"};
    public static final int NUMBER_OF_GAMES;

    static {
        NUMBER_OF_GAMES = GAMES.length;
    }

    public static void main(String[] args) {
        int choosedGame;

        Scanner sc = new Scanner(System.in);

        printListOfGames();

        System.out.print("Your choice: ");

        try {
            choosedGame = sc.nextInt();
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("You have to input numbers only!");
            } else {
                System.out.println(e.getMessage());
            }

            sc.close();
            return; //There is no reason to continue
        }

        Engine.processGameChoice(choosedGame, sc);

        sc.close();
    }

    private static void printListOfGames() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        for (int i = 0; i < GAMES.length; i++) {
            System.out.printf("%d - %s%n", i + 2, GAMES[i]);
        }

        System.out.println("0 - Exit");
    }
}

class GameCreateException extends Exception {
    GameCreateException(String message) {
        super(message);
    }
}
