package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    private static final int CODE_EXIT = 0;
    private static final int CODE_SETNAME = 1;
    private static final String[] GAMES = {"Even", "Calc", "GCD", "Progression", "Prime"};

    public static void main(String[] args) {
        printMenu();

        Scanner sc = new Scanner(System.in);
        int userChoice = getUserChoice(sc);

        switch (userChoice) {
            case (CODE_EXIT):
                return;
            case (CODE_SETNAME):
                Helper.printWelcome();
                String playerName = Helper.getPlayerName(sc);
                Helper.printGreeting(playerName);
                break;
            default:
                String gameName = getGameName(userChoice);
                startGame(gameName);
        }

        sc.close();
    }

    private static int getUserChoice(Scanner sc) {
        try {
            String chosenGame = sc.next();
            return Integer.parseInt(chosenGame);
        } catch (Exception e) {
            return -1;
        }
    }

    private static String getGameName(int chosenGame) {
        try {
            return App.GAMES[chosenGame - 2];
        } catch (Exception e) {
            return "";
        }
    }

    private static void startGame(String gameName) {
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

    private static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        for (int i = 0; i < GAMES.length; i++) {
            System.out.printf("%d - %s%n", i + 2, GAMES[i]);
        }

        System.out.println("0 - Exit");
    }
}
