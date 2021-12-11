package hexlet.code;

import java.util.Random;
import java.util.Scanner;

import hexlet.code.games.*;

public class Engine {

    public static final int MIN_INT = 1;
    public static final int MAX_INT = 100;
    public static final int MAX_RETRIES = 3;
    private static Random random = new Random();
    private static String playerName = "";

    public static boolean startGame(Game game, Scanner sc) {
        if (playerName.isEmpty()) {
            setName(sc);
        }

        game.printMessageBefore();
        for (int i = 0; i < MAX_RETRIES; i++) {
            String[] round = getEmptyRound();
            String answer;
            game.round(round);

            String question = round[0];
            String correctAnswer = round[1];

            System.out.println(String.format("Question: %s", question));
            System.out.print("Your answer: ");

            try {
                answer = sc.next().trim();
            } catch (Exception e) {
                game.printMessageAfterError();
                return false;
            }

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                printWrongAnswer(answer, correctAnswer);
                game.printMessageAfterError();
                return false;
            }
        }

        game.printMessageAfterSuccess();
        System.out.println(String.format("Congratulations, %s!", playerName));
        return true;
    }

    public static int getRandomInt() {
        return getRandomInt(MIN_INT, MAX_INT);
    }

    public static int getRandomInt(int max) {
        return getRandomInt(MIN_INT, max);
    }

    public static int getRandomInt(int min, int max) {
        return min + random.nextInt(max - min);
    }

    private static String[] getEmptyRound() {
        String[] round = new String[2];

        return round;
    }

    private static void printWrongAnswer(String wrongAnswer, String correctAnswer) {
        String wrongAnswerTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.";
        String wrongAnswerLetsTryAgain = "Let's try again, %s!";
        System.out.println(String.format(wrongAnswerTemplate, wrongAnswer, correctAnswer));
        System.out.println(String.format(wrongAnswerLetsTryAgain, playerName));
    }

    public static void setName(Scanner sc) {
        playerName = Cli.printHello(sc);
    }

}
