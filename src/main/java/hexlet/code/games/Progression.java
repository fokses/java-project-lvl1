package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

import java.util.Scanner;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int LENGTH_MIN = 5; //Progression length
    private static final int LENGTH_MAX = 15;
    private static final int STEP_MIN = 2; // Progression step
    private static final int STEP_MAX = 11;
    private static final int START_MIN = 1; // Posision of element
    private static final int START_MAX = 11;
    private static final int LENGTH;

    static {
        LENGTH = Helper.getRandomInt(LENGTH_MIN, LENGTH_MAX);
    }

    public static void startGame(String[][] rounds, String playerName, Scanner sc) throws Exception {
        Engine.processGame(DESCRIPTION, rounds[0], rounds[1], playerName, sc);
    }

    public static String[] getRound(int i) {
        String[] round = new String[2];

        int position = Helper.getRandomInt(1, LENGTH + 1);
        int start = Helper.getRandomInt(START_MIN, START_MAX);
        int step = Helper.getRandomInt(STEP_MIN, STEP_MAX);

        round[0] = getQuestion(start, step, LENGTH, position);
        round[1] = Integer.toString(start + step * (position - 1));

        return round;
    }

    private static String getQuestion(int start, int step, int length, int position) {
        String question = "";

        for (int j = 1; j <= LENGTH; j++) {
            if (position == j) {
                question += "..";
            } else {
                question += start;
            }

            question += (j != LENGTH) ? " " : "";
            start += step;
        }

        return question;
    }
}
