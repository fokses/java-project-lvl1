package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame() {
        String[][] rounds = new String[2][Engine.MAX_RETRIES];

        for (int i = 0; i < Engine.MAX_RETRIES; i++) {
            setRound(rounds, i);
        }

        Engine.processGame(DESCRIPTION, rounds);
    }

    public static void setRound(String[][] rounds, int i) {
        int randomInt = Helper.getRandomInt();

        rounds[0][i] = Integer.toString(randomInt);
        rounds[1][i] = Helper.getBoolString(randomInt % 2 == 0);
    }
}
