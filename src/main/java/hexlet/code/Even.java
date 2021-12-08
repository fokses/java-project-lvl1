package hexlet.code;

import java.util.Scanner;
import java.util.Random;


public class Even {

    static final int NUMBER_OF_ANSWERS = 3;
    static final int MAX_RANDOM_NUM = 100;

    public static boolean evenGame(Scanner sc) {
        boolean success = true;
        Random random = new Random();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < NUMBER_OF_ANSWERS; i++) {
            int randomInt = random.nextInt(MAX_RANDOM_NUM);
            boolean even = randomInt % 2 == 0;
            String answer = "";
            boolean evenAnswer;

            System.out.println(String.format("Question: %d", randomInt));
            System.out.print("Your answer: ");

            try {
                answer = sc.next().trim();
                evenAnswer = convertAnswerToBool(answer);
            } catch (Exception e) {
                printError(answer, getBoolString(even));
                return false;
            }

            if (even == evenAnswer) {
                System.out.println("Correct");
            } else {
                printError(answer, getBoolString(even));
                return false;
            }
        }

        return success;
    }

    private static String getBoolString(boolean bool) {
        return (bool) ? "yes" : "no";
    }

    private static boolean convertAnswerToBool(String answer) throws Exception {
        switch (answer) {
            case ("yes"):
                return true;
            case("no"):
                return false;
            default:
                throw new Exception("Can't parse input to boolean");
        }
    }

    private static void printError(String wrongAnswer, String correctAnswer) {
        String wrongAnswerTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.";
        System.out.println(String.format(wrongAnswerTemplate, wrongAnswer, correctAnswer));
    }
}
