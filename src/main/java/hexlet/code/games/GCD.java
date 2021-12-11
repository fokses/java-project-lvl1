package hexlet.code.games;

import hexlet.code.Engine;
import java.lang.Math.*;

public class GCD extends Game {
    @Override
    public final void printMessageBefore() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    public final void round(String[] round) {
        int firstNum = Engine.getRandomInt();
        int secondNum = Engine.getRandomInt();

        round[0] = String.format("%d %d", firstNum, secondNum);
        round[1] = getGCP(firstNum, secondNum).toString();
    }

    public static Integer getGCP(int a, int b) {
        if (a == b) {
            return a;
        }

        a = Math.abs(a);
        b = Math.abs(b);
        int min = Math.min(a, b);

        if ((a == min && b % a == 0) || (b == min && a % b == 0)) {
            return min;
        }

        for (int i = min - 1; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        return 1;
    }
}
