package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

import java.util.Scanner;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame(String[][] rounds, Scanner sc) throws Exception {
        Engine.processGame(DESCRIPTION, rounds, sc);
    }

    public static void setRound(String[][] rounds, int i) {
        int randomInt = Helper.getRandomInt();

        rounds[0][i] = Integer.toString(randomInt);
        rounds[1][i] = Helper.getBoolString(randomInt % 2 == 0);
    }
}
