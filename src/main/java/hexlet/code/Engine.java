package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int MIN_INT = 1; // getRandomInt()
    public static final int MAX_INT = 100; // getRandomInt()
    protected static final int MAX_RETRIES = 3; //game rounds

    public static void processGame(String description, String[] questions, String[] answers,
                                   String playerName, Scanner sc)
        throws Exception {

        if (!description.isEmpty()) {
            System.out.println(description);
        }

        for (int i = 0; i < MAX_RETRIES; i++) {
            processGameRound(questions[i], answers[i], playerName, sc);
        }

        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private static void processGameRound(String question, String correctAnswer, String playerName, Scanner sc)
        throws Exception {

        System.out.printf("Question: %s\n", question);
        System.out.print("Your answer: ");

        String answer = sc.next().trim();

        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            printWrongAnswer(answer, correctAnswer, playerName);
            throw new RuntimeException();
        }
    }

    private static void printWrongAnswer(String wrongAnswer, String correctAnswer, String playerName) {
        String wrongAnswerTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.\n";
        String wrongAnswerLetsTryAgain = "Let's try again, %s!\n";
        System.out.printf(wrongAnswerTemplate, wrongAnswer, correctAnswer);
        System.out.printf(wrongAnswerLetsTryAgain, playerName);
    }
}
