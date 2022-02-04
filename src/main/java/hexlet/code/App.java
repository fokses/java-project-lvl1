package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final int CODE_EXIT = 0;
    private static final int CODE_SETNAME = 1;
    private static final String[] GAMES = {"Even", "Calc", "GCD", "Progression", "Prime"};
    public static final int NUMBER_OF_GAMES;

    static {
        NUMBER_OF_GAMES = GAMES.length;
    }

    public static void main(String[] args) {
        int chosenGame;

        Scanner sc = new Scanner(System.in);

        printListOfGames();

        System.out.print("Your choice: ");

        try {
            chosenGame = sc.nextInt();
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("You have to input numbers only!");
            } else {
                System.out.println(e.getMessage());
            }

            return; //There is no reason to continue
        }

        processGameChoice(chosenGame);
        sc.close();
    }

    private static void processGameChoice(int chosenGame) {

        switch (chosenGame) {
            case (CODE_EXIT):
                return;
            case (CODE_SETNAME):
                Engine.processGame("", null); //just say hello
                break;
            default:
                startGame(chosenGame);
        }
    }

    private static String getGameName(int chosenGame) {
        if (chosenGame < 0 || chosenGame > App.NUMBER_OF_GAMES + 2) {
            return "";
        }

        return App.GAMES[chosenGame - 2];
    }

    private static void startGame(int chosenGame) {
        String gameName = getGameName(chosenGame);

        switch (gameName) {
            case ("Even"):
                Even.startGame();
                break;
            case ("Calc"):
                Calc.startGame();
                break;
            case ("GCD"):
                GCD.startGame();
                break;
            case ("Prime"):
                Prime.startGame();
                break;
            case ("Progression"):
                Progression.startGame();
                break;
            default:
                System.out.println("Wrong game choice");
        }
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
