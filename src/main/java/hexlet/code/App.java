package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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

            sc.close();
            return; //There is no reason to continue
        }

        processGameChoice(chosenGame, sc);

        sc.close();
    }

    private static void processGameChoice(int chosenGame, Scanner sc) {

        switch (chosenGame) {
            case (CODE_EXIT):
                break;
            case (CODE_SETNAME):
                try {
                    getName(sc);
                } catch (Exception e) {
                    System.out.println("Error while setting name: ");
                    System.out.println(e.getMessage());
                }
                break;
            default:
                if (chosenGame < 0 || chosenGame > App.NUMBER_OF_GAMES + 2) {
                    System.out.println("Wrong game choice");
                    return;
                }

                startGame(App.GAMES[chosenGame - 2], sc);
        }
    }

    private static void startGame(String gameName, Scanner sc) {
        try {
            String playerName = getName(sc);

            int maxRetries = Engine.MAX_RETRIES;

            String[][] rounds = Helper.getRounds(maxRetries, gameName);

            switch (gameName) {
                case ("Even"):
                    Even.startGame(rounds, playerName, sc);
                    break;
                case ("Calc"):
                    Calc.startGame(rounds, playerName, sc);
                    break;
                case ("GCD"):
                    GCD.startGame(rounds, playerName, sc);
                    break;
                case ("Prime"):
                    Prime.startGame(rounds, playerName, sc);
                    break;
                case ("Progression"):
                    Progression.startGame(rounds, playerName, sc);
                    break;
                default:
                    System.out.println("Game not found");
            }
        } catch (IllegalStateException | NoSuchElementException e) { //user wrong input
            System.out.println("There was an error during read the input");
            System.out.println(e.getMessage());
        } catch (RuntimeException e) { //wrong answer
            //without process
        } catch (Exception e) { //Something else
            System.out.println("There was an error during execution the game");
            System.out.println(e.getMessage());
        }
    }

    private static String getName(Scanner sc) throws Exception {
        String playerName;

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        playerName = sc.next();

        System.out.println("Hello, " + playerName + "!");
        return playerName;
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
