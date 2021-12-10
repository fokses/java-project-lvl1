package hexlet.code.games;

import hexlet.code.Engine;

public class Calc extends Game {

    private static final  int NUMBER_OF_SIGNS = 3;

    private static char[] signs;

    {
        signs = new char[NUMBER_OF_SIGNS];
        signs[0] = '+';
        signs[1] = '-';
        signs[2] = '*';
    }

    @Override
    public final void printMessageBefore() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    public final void round(String[] round) {
        int firstNum = Engine.getRandomInt();
        int secondNum = Engine.getRandomInt();
        char sign = signs[Engine.getRandomInt(0, NUMBER_OF_SIGNS)];

        round[0] = String.format("%d %s %d", firstNum, sign, secondNum);
        round[1] = getCorrectAnswer(firstNum, secondNum, sign);
    }

    private String getCorrectAnswer(int firstNum, int secondNum, char sign) {
        Integer result = 0;

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

        return result.toString();
    }
}
