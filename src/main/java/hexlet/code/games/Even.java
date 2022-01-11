package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

import java.util.Scanner;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public final void startGame(Scanner sc)
            throws ScannerException, WrongAnswerException {

        Engine.processGame(DESCRIPTION, sc);
    }

    public static void fillQuestions(Even game) {
        for (int i = 0; i < Engine.MAX_RETRIES; i++) {
            game.fillRound(i);
        }
    }

    public final void fillRound(int i) {
        int randomInt = Engine.getRandomInt();

        Engine.setQuestion(i, Integer.toString(randomInt));
        Engine.setAnswer(i, Engine.getBoolString(randomInt % 2 == 0));
    }
}
