package hexlet.code;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Engine {

    public static final int MIN_INT = 1; // getRandomInt()
    public static final int MAX_INT = 100; // getRandomInt()
    public static final int MAX_RETRIES = 3; //game rounds

    public static void processGame(String description, String[][] roundsOfGame) {

        String playerName = "";
        Scanner sc = new Scanner(System.in);

        try {
            playerName = getPlayerName(sc);
        } catch (Exception e) {
            System.out.println("Error getting name:");
            System.out.println(e.getMessage());
            return;
        }

        if (roundsOfGame == null) { //set name and exit
            return;
        }

        String[] questions = roundsOfGame[0];
        String[] answers = roundsOfGame[1];
        boolean getWrongAnswer = false;

        if (!description.isEmpty()) {
            System.out.println(description);
        }

        for (int i = 0; i < MAX_RETRIES; i++) {
            getWrongAnswer = !processGameRound(questions[i], answers[i], playerName, sc);
            if (getWrongAnswer) {
                break;
            }
        }

        if (!getWrongAnswer) {
            System.out.printf("Congratulations, %s!\n", playerName);
        }
    }

    private static boolean processGameRound(String question, String correctAnswer, String playerName, Scanner sc) {

        String answer = "";
        System.out.printf("Question: %s\n", question);
        System.out.print("Your answer: ");

        try {
            answer = sc.next().trim();
        } catch (IllegalStateException | NoSuchElementException e) { //user wrong input
            System.out.println("There was an error during read the input");
            System.out.println(e.getMessage());
        }

        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            printWrongAnswer(answer, correctAnswer, playerName);
            return false;
        }
    }

    private static String getPlayerName(Scanner sc) throws Exception {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        String playerName = sc.next();

        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }

    private static void printWrongAnswer(String wrongAnswer, String correctAnswer, String playerName) {
        String wrongAnswerTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.\n";
        String wrongAnswerLetsTryAgain = "Let's try again, %s!\n";
        System.out.printf(wrongAnswerTemplate, wrongAnswer, correctAnswer);
        System.out.printf(wrongAnswerLetsTryAgain, playerName);
    }
}
