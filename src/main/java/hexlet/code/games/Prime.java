package hexlet.code.games;

import hexlet.code.Engine;
import static java.lang.Math.abs;

public class Prime {

    public static void printMessageBefore() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public static void round(String[] round) {
        int num = Engine.getRandomInt();
        round[0] = String.valueOf(num);
        round[1] = Engine.getBoolString(isPrime(num));
    }

    public static boolean isPrime(int num) {
        final int startFrom = 3; //because linter complain of magic number
        num = abs(num);

        //0, 1, multiple 2 is not prime
        if (num == 0 || num == 1 || num % 2 == 0) {
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
