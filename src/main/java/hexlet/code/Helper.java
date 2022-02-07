//Common methods used by some objects
package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Helper {
    private static final Random RANDOM = new Random();

    public static void printWelcome() {
        System.out.println("Welcome to the Brain Games!");
    }

    public static void printGreeting(String playerName) {
        if (playerName != null) {
            System.out.printf("Hello, %1!", playerName);
        }
    }

    public static String getPlayerName(Scanner sc) {
        System.out.println("May I have your name?");

        try {
            return sc.next();
        } catch (Exception e) {
            return null;
        }
    }

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
