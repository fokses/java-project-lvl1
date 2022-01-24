package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;


import java.util.Scanner;

public class Calc {

    private static final String DESCRIPTION = "What is the result of the expression?";

    public static void startGame(String[][] rounds, String playerName, Scanner sc) throws Exception {
        Engine.processGame(DESCRIPTION, rounds[0], rounds[1], playerName, sc);
    }

    private static final char[] SIGNS = new char[] {'+', '-', '*'};

    public static String[] getRound(int i) {
        String[] round = new String[2];

        int firstNum = Helper.getRandomInt();
        int secondNum = Helper.getRandomInt();
        char sign = SIGNS[Helper.getRandomInt(0, SIGNS.length)];

        round[0] = String.format("%d %s %d", firstNum, sign, secondNum);
        round[1] = getCorrectAnswer(firstNum, secondNum, sign);

        return round;
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
