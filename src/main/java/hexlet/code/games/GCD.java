package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.Helper;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

import java.util.Scanner;

import static java.lang.Math.abs;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void startGame(Scanner sc) throws ScannerException, WrongAnswerException {
        fillQuestions(Engine.MAX_RETRIES);
        Engine.processGame(DESCRIPTION, Game.getQuestions(), Game.getAnswers(), sc);
    }

    private static void fillQuestions(int numOfQuestions) {
        for (int i = 0; i < numOfQuestions; i++) {
            fillRound(i);
        }
    }

    private static void fillRound(int i) {
        int firstNum = Helper.getRandomInt();
        int secondNum = Helper.getRandomInt();

        String question = String.format("%d %d", firstNum, secondNum);
        String answer = getGCD(firstNum, secondNum).toString();

        Game.setRound(i, question, answer);
    }

    private static Integer getGCD(int a, int b) {
        a = abs(a);
        b = abs(b);

        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return a + b;
    }
}
