package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

import java.util.Scanner;

import static java.lang.Math.abs;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public final void startGame(Scanner sc) throws ScannerException, WrongAnswerException {
        Engine.processGame(DESCRIPTION, sc);
    }

    public final void fillRound(int i) {
        int firstNum = Engine.getRandomInt();
        int secondNum = Engine.getRandomInt();

        Engine.setQuestion(i, String.format("%d %d", firstNum, secondNum));
        Engine.setAnswer(i, getGCD(firstNum, secondNum).toString());
    }

    public static void fillQuestions(GCD game) {
        for (int i = 0; i < Engine.MAX_RETRIES; i++) {
            game.fillRound(i);
        }
    }

    public static Integer getGCD(int a, int b) {
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
