//Common methods used by some objects
package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import java.util.Random;

public class Helper {
    private static final Random RANDOM = new Random();

    public static int getRandomInt() {
        return getRandomInt(Engine.MIN_INT, Engine.MAX_INT);
    }

    public static int getRandomInt(int min, int max) {
        return min + RANDOM.nextInt(max - min);
    }

    public static String getBoolString(boolean bool) {
        return (bool) ? "yes" : "no";
    }

    public static String[][] getRounds(int numOfQuestions, String gameName) throws Exception {
        String[][] rounds = new String[2][numOfQuestions];

        for (int i = 0; i < numOfQuestions; i++) {
            switch (gameName) {
                case ("Even"):
                    Even.setRound(rounds, i);
                    break;
                case ("Calc"):
                    Calc.setRound(rounds, i);
                    break;
                case ("GCD"):
                    GCD.setRound(rounds, i);
                    break;
                case ("Prime"):
                    Prime.setRound(rounds, i);
                    break;
                case ("Progression"):
                    Progression.setRound(rounds, i);
                    break;
                default:
                    System.out.println("Game not found");
                    throw new RuntimeException();
            }
        }

        return rounds;
    }
}
