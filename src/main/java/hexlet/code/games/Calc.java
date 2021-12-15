package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    private static final int NUMBER_OF_SIGNS = 3;

    private static char[] signs;

    static {
        signs = new char[NUMBER_OF_SIGNS];
        signs[0] = '+';
        signs[1] = '-';
        signs[2] = '*';
    }

    public static void printMessageBefore() {
        System.out.println("What is the result of the expression?");
    }

    public static void round(String[] round) {
        int firstNum = Engine.getRandomInt();
        int secondNum = Engine.getRandomInt();
        char sign = signs[Engine.getRandomInt(0, NUMBER_OF_SIGNS)];

        round[0] = String.format("%d %s %d", firstNum, sign, secondNum);
        round[1] = getCorrectAnswer(firstNum, secondNum, sign);
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
