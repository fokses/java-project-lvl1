package hexlet.code.games;

import hexlet.code.Engine;

public class Even extends Game {
    public final void printMessageBefore() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    public final void round(String[] round) {
        Integer randomInt = Engine.getRandomInt();
        boolean even = randomInt % 2 == 0;

        round[0] = randomInt.toString();
        round[1] = getBoolString(even);
    }

    private String getBoolString(boolean bool) {
        return (bool) ? "yes" : "no";
    }
}
