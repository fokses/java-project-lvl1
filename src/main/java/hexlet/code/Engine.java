package hexlet.code;

import java.util.Random;
import java.util.Scanner;
import java.lang.reflect.Method;

public class Engine {

    public static final int MIN_INT = 1; // getRandomInt()
    public static final int MAX_INT = 100; // getRandomInt()
    public static final int MAX_RETRIES = 3; //game rounds
    private static Random random = new Random();
    private static String playerName = "";

    public static void startGame(Class<?> game, Scanner sc)
        throws GameFlowException, ScannerException, WrongAnswerException {

        if (playerName.isEmpty()) {
            try {
                setName(sc);
            } catch (Exception e) {
                throw new ScannerException("Can't read the name!");
            }
        }

        try {
            Method printMessageBefore = game.getMethod("printMessageBefore");
            printMessageBefore.invoke(null);
        } catch (Exception e) {
            throw new GameFlowException(e.getMessage());
        }


        for (int i = 0; i < MAX_RETRIES; i++) {
            startGameRound(game, sc);
        }

        System.out.println(String.format("Congratulations, %s!", playerName));
    }

    private static void startGameRound(Class<?> game, Scanner sc)
        throws GameFlowException, ScannerException, WrongAnswerException {

        String[] round = getEmptyRound();
        Object[] args = {round};
        String answer;

        try {
            Method roundMethod = game.getDeclaredMethod("round", String[].class);
            roundMethod.invoke(null, args);
        } catch (Exception e) {
            throw new GameFlowException(e.getMessage());
        }

        String question = round[0];
        String correctAnswer = round[1];

        System.out.println(String.format("Question: %s", question));
        System.out.print("Your answer: ");

        try {
            answer = sc.next().trim();
        } catch (Exception e) {
            throw new ScannerException("Can't read your answer!");
        }

        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            printWrongAnswer(answer, correctAnswer);
            throw new WrongAnswerException("");
        }
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

    public static void setName(Scanner sc) throws ScannerException {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        try {
            if (sc.hasNext()) {
                playerName = sc.next();
                System.out.println("Hello, " + playerName + "!");
            }
        } catch (Exception e) {
            throw new ScannerException(e.getMessage());
        }

    }

    public static String getBoolString(boolean bool) {
        return (bool) ? "yes" : "no";
    }

    private static String[] getEmptyRound() {
        String[] round = new String[2]; //round[0] - question, round[1] - correct answer

        return round;
    }

    private static void printWrongAnswer(String wrongAnswer, String correctAnswer) {
        String wrongAnswerTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.";
        String wrongAnswerLetsTryAgain = "Let's try again, %s!";
        System.out.println(String.format(wrongAnswerTemplate, wrongAnswer, correctAnswer));
        System.out.println(String.format(wrongAnswerLetsTryAgain, playerName));
    }
}

class ScannerException extends Exception {
    public ScannerException(String message) {
        super(message);
    }
}

class WrongAnswerException extends Exception {
    public WrongAnswerException(String message) {
        super(message);
    }
}

class GameFlowException extends Exception {
    public GameFlowException(String message) {
        super(message);
    }
}
