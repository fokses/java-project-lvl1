package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;


import java.util.Scanner;

public class Calc {

    private static final String DESCRIPTION = "What is the result of the expression?";

    public static void startGame(String[][] rounds, Scanner sc) throws Exception {
        Engine.processGame(DESCRIPTION, rounds, sc);
    }

    private static final char[] SIGNS = new char[] {'+', '-', '*'};

    public static void setRound(String[][] rounds, int i) {
        int firstNum = Helper.getRandomInt();
        int secondNum = Helper.getRandomInt();
        char sign = SIGNS[Helper.getRandomInt(0, SIGNS.length)];

        rounds[0][i] = String.format("%d %s %d", firstNum, sign, secondNum);
        rounds[1][i] = getCorrectAnswer(firstNum, secondNum, sign);
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
