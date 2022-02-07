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
    private static final int EVEN  = 2;
    private static final int CALC  = 3;
    private static final int GCD  = 4;
    private static final int PROGRESSION  = 5;
    private static final int PRIME  = 6;

    public static void main(String[] args) {
        printMenu();

        Scanner sc = new Scanner(System.in);
        int userChoice = getUserChoice(sc);

        switch (userChoice) {
            case (CODE_EXIT) -> {
                break;
            }
            case (CODE_SETNAME) -> printHelloAndExit(sc);
            case (EVEN) -> Even.startGame();
            case (CALC) -> Calc.startGame();
            case (GCD) -> hexlet.code.games.GCD.startGame();
            case (PROGRESSION) -> Progression.startGame();
            case (PRIME) -> Prime.startGame();
            default -> System.out.println("Wrong choice");
        }

        sc.close();
    }

    private static void printHelloAndExit(Scanner sc) {
        Helper.printWelcome();
        String playerName = Helper.getPlayerName(sc);
        Helper.printGreeting(playerName);
    }

    private static int getUserChoice(Scanner sc) {
        System.out.print("Your choice: ");

        try {
            String chosenGame = sc.next();
            return Integer.parseInt(chosenGame);
        } catch (Exception e) {
            return -1;
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
