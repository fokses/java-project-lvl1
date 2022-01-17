package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.Helper;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;


import java.util.Scanner;

public class Calc {

    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final char[] SIGNS = new char[] {'+', '-', '*'};

    public static void startGame(Scanner sc) throws ScannerException, WrongAnswerException {
        fillQuestions(Engine.MAX_RETRIES);
        Engine.processGame(DESCRIPTION, Game.getQuestions(), Game.getAnswers(), sc);
    }

    public static void fillQuestions(int numOfQuestions) {
        for (int i = 0; i < numOfQuestions; i++) {
            fillRound(i);
        }
    }

    public static void fillRound(int i) {
        int firstNum = Helper.getRandomInt();
        int secondNum = Helper.getRandomInt();
        char sign = SIGNS[Helper.getRandomInt(0, SIGNS.length)];

        String question = String.format("%d %s %d", firstNum, sign, secondNum);
        String answer = getCorrectAnswer(firstNum, secondNum, sign);

        Game.setRound(i, question, answer);
    }

    private static String getCorrectAnswer(int firstNum, int secondNum, char sign) {
        int result = 0;

        switch (sign) {
            case ('+'):
                result = firstNum + secondNum;
                break;
            case ('-'):
                result = firstNum - secondNum;
                break;
            case ('*'):
                result = firstNum * secondNum;
                break;
            default:
                break;
        }

        return String.valueOf(result);
    }
}
