package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Prime extends Game {

    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    @Override
    public final void startGame(Scanner sc) throws ScannerException, WrongAnswerException {
        Engine.processGame(DESCRIPTION, sc);
    }

    @Override
    public final void fillRound(int i) {
        int num = Engine.getRandomInt();
        Engine.setQuestion(i, String.valueOf(num));
        Engine.setAnswer(i, Engine.getBoolString(isPrime(num)));
    }

    public static boolean isPrime(int num) {
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
