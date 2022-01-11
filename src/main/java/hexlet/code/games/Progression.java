package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

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
        LENGTH = Engine.getRandomInt(LENGTH_MIN, LENGTH_MAX);
    }

    public final void startGame(Scanner sc) throws ScannerException, WrongAnswerException {
        Engine.processGame(DESCRIPTION, sc);
    }

    public final void fillRound(int i) {
        int position = Engine.getRandomInt(1, LENGTH + 1);
        int start = Engine.getRandomInt(START_MIN, START_MAX);
        int step = Engine.getRandomInt(STEP_MIN, STEP_MAX);

        String question = "";
        String answer = "";

        for (int j = 1; j <= LENGTH; j++) {
            if (position == j) {
                question += "..";
                answer = String.valueOf(start);
            } else {
                question += start;
            }

            question += (j != LENGTH) ? " " : "";
            start += step;
        }

        Engine.setQuestion(i, question);
        Engine.setAnswer(i, answer);
    }

    public static void fillQuestions(Progression game) {
        for (int i = 0; i < Engine.MAX_RETRIES; i++) {
            game.fillRound(i);
        }
    }
}
