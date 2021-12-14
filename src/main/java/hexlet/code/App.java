package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;
import hexlet.code.games.*;

public class App {
    private static final String[] GAMES = {"Even", "Calc", "GCD", "Progression", "Prime"};
    private static final int NUMBER_OF_GAMES;

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

        try {
            processChoice(choosedGame, sc);
        } catch (GameFlowException | GameCreateException | ScannerException e) { //game flow error
            System.out.println("There was an error during execution the game");
            System.out.println(e.getMessage());
        } catch (WrongGameException e) { //game choice error
            System.out.println(e.getMessage());
        } catch (WrongAnswerException e) { //user input wrong answer
            //without process
        } catch (Exception e) { //Smth other
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    private static void processChoice(int choosedGame, Scanner sc)
        throws GameFlowException, GameCreateException, ScannerException, WrongAnswerException, WrongGameException {

        switch (choosedGame) {
            case (0):
                break;
            case (1):
                Engine.setName(sc);
                break;
            default:
                if (choosedGame >= 0 && choosedGame < NUMBER_OF_GAMES + 2) {
                    startGame(choosedGame, sc);
                } else {
                    throw new WrongGameException("Wrong game choice");
                }
        }
    }

    private static void startGame(int choosedGame, Scanner sc)
        throws GameFlowException, GameCreateException, ScannerException, WrongAnswerException {

        Game game = null;

        try {
            Class<?> gameClass = Class.forName("hexlet.code.games." + GAMES[choosedGame - 2]);
            game = (Game) gameClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new GameCreateException(e.getMessage());
        }

        if (game != null) {
            Engine.startGame(game, sc);
        }
    }

    private static void printListOfGames() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        for (int i = 0; i < GAMES.length; i++) {
            System.out.println(String.format("%d - %s", i + 2, GAMES[i]));
        }

        System.out.println("0 - Exit");
    }
}

class GameCreateException extends Exception {
    public GameCreateException(String message) {
        super(message);
    }
}

class WrongGameException extends Exception {
    public WrongGameException(String message) {
        super(message);
    }
}
