package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.Helper;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Prime {

    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

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
        int num = Helper.getRandomInt();

        String question = Integer.toString(num);
        String answer = Helper.getBoolString(isPrime(num));

        Game.setRound(i, question, answer);
    }

    private static boolean isPrime(int num) {
        final int startFrom = 3; //because linter complain of magic number
        num = abs(num);

        //0, 1, multiple 2 is not prime
        if (num == 1 || num % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.floor(Math.sqrt(num));

        for (int i = startFrom; i < sqrt + 1; i = i + 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
