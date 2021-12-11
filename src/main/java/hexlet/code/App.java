package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.*;

public class App {
    private static final String[] GAMES = {"Even", "Calc", "GCD"};
    private static final int NUMBER_OF_GAMES;

    static {
        NUMBER_OF_GAMES = GAMES.length;
    }

    public static void main(String[] args) {
        int choosedGame;
        Scanner sc = new Scanner(System.in);

        printListOfGames();

        try {
            choosedGame = sc.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR");
            sc.close();
            return;
        }

        processChoice(choosedGame, sc);

        sc.close();
    }

    private static void processChoice(int choosedGame, Scanner sc) {

        switch (choosedGame) {
            case (0):
                break;
            case (1):
                Engine.setName(sc);
                break;
            default:
                if (choosedGame - 2 <= NUMBER_OF_GAMES) {
                    startGame(choosedGame, sc);
                } else {
                    System.out.println("Wrong choice of game");
                }
        }
    }

    private static void startGame(int choosedGame, Scanner sc) {
        Game game = null;

        try {
            Class<?> gameClass = Class.forName("hexlet.code.games." + GAMES[choosedGame - 2]);
            game = (Game) gameClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        System.out.print("Your choice: ");
    }
}
