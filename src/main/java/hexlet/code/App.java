package hexlet.code;

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
                    Engine.setName(sc);
                } catch (ScannerException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                if (chosenGame < 0 || chosenGame > App.NUMBER_OF_GAMES + 2) {
                    System.out.println("Wrong game choice");
                    return;
                }

                try {
                    Engine.startGame(App.GAMES[chosenGame - 2], sc);
                } catch (GameCreateException | ScannerException e) { //game flow error
                    System.out.println("There was an error during execution the game");
                    System.out.println(e.getMessage());
                } catch (WrongAnswerException e) { //user input wrong answer
                    //without process
                } catch (Exception e) { //Something else
                    System.out.println(e.getMessage());
                }
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

class GameCreateException extends Exception {
    GameCreateException(String message) {
        super(message);
    }
}
