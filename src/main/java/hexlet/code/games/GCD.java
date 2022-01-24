package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

import java.util.Scanner;

import static java.lang.Math.abs;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void startGame(String[][] rounds, String playerName, Scanner sc) throws Exception {
        Engine.processGame(DESCRIPTION, rounds[0], rounds[1], playerName, sc);
    }

    public static String[] getRound(int i) {
        String[] round = new String[2];

        int firstNum = Helper.getRandomInt();
        int secondNum = Helper.getRandomInt();

        round[0] = String.format("%d %d", firstNum, secondNum);
        round[1] = getGCD(firstNum, secondNum).toString();

        return round;
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
