package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

import java.util.Scanner;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame(String[][] rounds, String playerName, Scanner sc) throws Exception {
        Engine.processGame(DESCRIPTION, rounds[0], rounds[1], playerName, sc);
    }

    public static String[] getRound(int i) {
        String[] round = new String[2];

        int randomInt = Helper.getRandomInt();

        round[0] = Integer.toString(randomInt);
        round[1] = Helper.getBoolString(randomInt % 2 == 0);

        return round;
    }
}
