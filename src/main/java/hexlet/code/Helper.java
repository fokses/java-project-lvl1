//Common methods used by some objects
package hexlet.code;

import java.util.Random;

public class Helper {
    private static final Random RANDOM = new Random();

    public static int getRandomInt() {
        return getRandomInt(Engine.MIN_INT, Engine.MAX_INT);
    }

    public static int getRandomInt(int min, int max) {
        return min + RANDOM.nextInt(max - min);
    }

    public static String getBoolString(boolean bool) {
        return (bool) ? "yes" : "no";
    }

}
