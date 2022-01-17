package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.Helper;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

import java.util.Scanner;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame(Scanner sc)
            throws ScannerException, WrongAnswerException {

        fillQuestions(Engine.MAX_RETRIES);
        Engine.processGame(DESCRIPTION, Game.getQuestions(), Game.getAnswers(), sc);
    }

    private static void fillQuestions(int numOfQuestions) {
        for (int i = 0; i < numOfQuestions; i++) {
            fillRound(i);
        }
    }

    private static void fillRound(int i) {
        int randomInt = Helper.getRandomInt();

        String question = Integer.toString(randomInt);
        String answer = Helper.getBoolString(randomInt % 2 == 0);

        Game.setRound(i, question, answer);
    }
}
