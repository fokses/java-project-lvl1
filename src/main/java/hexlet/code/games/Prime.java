package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Prime {

    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame(String[][] rounds, Scanner sc) throws Exception {
        Engine.processGame(DESCRIPTION, rounds, sc);
    }

    public static void setRound(String[][] rounds, int i) {
        int num = Helper.getRandomInt();

        rounds[0][i] = Integer.toString(num);
        rounds[1][i] = Helper.getBoolString(isPrime(num));

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
