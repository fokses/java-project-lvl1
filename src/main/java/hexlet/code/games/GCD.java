package hexlet.code.games;

import hexlet.code.Engine;
import static java.lang.Math.abs;

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
        round[1] = getGCD(firstNum, secondNum).toString();
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
