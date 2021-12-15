package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void printMessageBefore() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public static void round(String[] round) {
        Integer randomInt = Engine.getRandomInt();

        round[0] = randomInt.toString();
        round[1] = Engine.getBoolString(randomInt % 2 == 0);
    }
}
