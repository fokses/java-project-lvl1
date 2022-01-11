package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

import java.util.Scanner;

public class Calc {

    private static final int NUMBER_OF_SIGNS = 3;
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final char[] SIGNS;

    static {
        SIGNS = new char[NUMBER_OF_SIGNS];
        SIGNS[0] = '+';
        SIGNS[1] = '-';
        SIGNS[2] = '*';
    }

    public final void fillRound(int i) {
        int firstNum = Engine.getRandomInt();
        int secondNum = Engine.getRandomInt();
        char sign = SIGNS[Engine.getRandomInt(0, NUMBER_OF_SIGNS)];

        Engine.setQuestion(i, String.format("%d %s %d", firstNum, sign, secondNum));
        Engine.setAnswer(i, getCorrectAnswer(firstNum, secondNum, sign));
    }

    public static void fillQuestions(Calc game) {
        for (int i = 0; i < Engine.MAX_RETRIES; i++) {
            game.fillRound(i);
        }
    }

    public final void startGame(Scanner sc) throws ScannerException, WrongAnswerException {
        Engine.processGame(DESCRIPTION, sc);
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
