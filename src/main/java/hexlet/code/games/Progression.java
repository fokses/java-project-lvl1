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

    public static void startGame(String[][] rounds, Scanner sc) throws Exception {
        Engine.processGame(DESCRIPTION, rounds, sc);
    }

    public static void setRound(String[][] rounds, int i) {
        int position = Helper.getRandomInt(1, LENGTH + 1);
        int start = Helper.getRandomInt(START_MIN, START_MAX);
        int step = Helper.getRandomInt(STEP_MIN, STEP_MAX);

        rounds[0][i] = getQuestion(start, step, LENGTH, position - 1);
        rounds[1][i] = Integer.toString(start + step * (position - 1));
    }

    private static String getQuestion(int start, int step, int length, int position) {
        String question = "";

        Integer[] progression = getProgression(start, step, length);

        for (int i = 0; i < progression.length; i++) {
            question += (i == position) ? ".." : progression[i].toString();
            question += (i != progression.length - 1) ? " " : "";
        }

        return question;
    }

    private static Integer[] getProgression(int start, int step, int length) {
        Integer[] progression = new Integer[length];

        for (int i = 0; i < length; i++) {
            progression[i] = start;
            start += step;
        }

        return progression;
    }
}
