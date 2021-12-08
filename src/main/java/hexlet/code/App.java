package hexlet.code;

import java.util.Scanner;

public class App {
    private static String name = "";
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

        startGame(choosedGame, sc);

        sc.close();
    }

    private static void startGame(int choosedGame, Scanner sc) {
        switch (choosedGame) {
            case (0):
                break;
            case (1):
                setName(sc);
                break;
            case (2):
                setNameIfEmpty(sc);
                if (Even.evenGame(sc)) {
                    System.out.println(String.format("Congratulations, %s!", name));
                }
                break;
            default:
                System.out.println("Wrong game");
                break;
        }
    }

    private static void setNameIfEmpty(Scanner sc) {
        if (name.isEmpty()) {
            setName(sc);
        }
    }

    private static void setName(Scanner sc) {
        name = Cli.printHello(sc);
    }

    private static void printListOfGames() {
        String[] games = getGames();
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        for (int i = 0; i < games.length; i++) {
            System.out.println(String.format("%d - %s", i + 2, games[i]));
        }

        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private static String[] getGames() {
        String[] games = new String[1];
        games[0] = "Even";

        return games;
    }
}
