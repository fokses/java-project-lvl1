package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final int MIN_INT = 1; // getRandomInt()
    public static final int MAX_INT = 100; // getRandomInt()
    public static final int MAX_RETRIES = 3; //game rounds
    private static String[] questions;
    private static String[] answers;
    private static final Random RANDOM = new Random();
    private static String playerName = "";

    static {
        questions = new String[MAX_RETRIES];
        answers = new String[MAX_RETRIES];
    }

    public static void setQuestion(int i, String value) {
        questions[i] = value;
    }

    public static void setAnswer(int i, String value) {
        answers[i] = value;
    }

    public static void startGame(String gameName, Scanner sc)
            throws GameCreateException, ScannerException, WrongAnswerException {

        Object game = null;

        try {
            switch (gameName) {
                case ("Even"):
                    Even even = new Even();
                    even.fillQuestions(even);
                    even.startGame(sc);
                    break;
                case ("Calc"):
                    Calc calc = new Calc();
                    calc.fillQuestions(calc);
                    calc.startGame(sc);
                    break;
                case ("GCD"):
                    GCD gcd = new GCD();
                    gcd.fillQuestions(gcd);
                    gcd.startGame(sc);
                    break;
                case ("Prime"):
                    Prime prime = new Prime();
                    prime.fillQuestions(prime);
                    prime.startGame(sc);
                    break;
                case ("Progression"):
                    Progression progression = new Progression();
                    progression.fillQuestions(progression);
                    progression.startGame(sc);
                    break;
                default:
                    throw new GameCreateException("Game not found");
            }
        } catch (GameCreateException | ScannerException e) { //game flow error
            System.out.println("There was an error during execution the game");
            System.out.println(e.getMessage());
        } catch (WrongAnswerException e) { //user input wrong answer
            //without process
        } catch (Exception e) { //Something else
            System.out.println(e.getMessage());
        }
    }

    private static void fillQuestions(Even game) {
        for (int i = 0; i < Engine.MAX_RETRIES; i++) {
            game.fillRound(i);
        }
    }

    public static void processGame(String description, Scanner sc)
        throws ScannerException, WrongAnswerException {

        if (playerName.isEmpty()) {
            try {
                setName(sc);
            } catch (Exception e) {
                throw new ScannerException("Can't read the name!");
            }
        }

        if (!description.isEmpty()) {
            System.out.println(description);
        }

        for (int i = 0; i < MAX_RETRIES; i++) {
            processGameRound(questions[i], answers[i], sc);
        }

        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private static void processGameRound(String question, String correctAnswer, Scanner sc)
        throws ScannerException, WrongAnswerException {

        String answer;

        System.out.printf("Question: %s\n", question);
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

    public static int getRandomInt(int min, int max) {
        return min + RANDOM.nextInt(max - min);
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

    private static void printWrongAnswer(String wrongAnswer, String correctAnswer) {
        String wrongAnswerTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.\n";
        String wrongAnswerLetsTryAgain = "Let's try again, %s!\n";
        System.out.printf(wrongAnswerTemplate, wrongAnswer, correctAnswer);
        System.out.printf(wrongAnswerLetsTryAgain, playerName);
    }
}
