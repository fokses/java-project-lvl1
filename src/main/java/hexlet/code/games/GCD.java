package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;
import static java.lang.Math.abs;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] rounds = new String[2][Engine.MAX_RETRIES];

        for (int i = 0; i < Engine.MAX_RETRIES; i++) {
            setRound(rounds, i);
        }

        Engine.processGame(DESCRIPTION, rounds);
    }

    public static void setRound(String[][] rounds, int i) {
        int firstNum = Helper.getRandomInt();
        int secondNum = Helper.getRandomInt();

        rounds[0][i] = String.format("%d %d", firstNum, secondNum);
        rounds[1][i] = getGCD(firstNum, secondNum).toString();
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
