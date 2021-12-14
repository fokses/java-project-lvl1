package hexlet.code.games;

import hexlet.code.Engine;

public class Progression extends Game {
    private static final int LENGTH_MIN = 5; //Длина прогрессии
    private static final int LENGTH_MAX = 15;
    private static final int STEP_MIN = 2; // Шаг прогрессии
    private static final int STEP_MAX = 11;
    private static final int START_MIN = 1; // Положение элемента
    private static final int START_MAX = 11;

    @Override
    public final void printMessageBefore() {
        System.out.println("What number is missing in the progression?");
    }

    @Override
    public final void round(String[] round) {
        int length = Engine.getRandomInt(LENGTH_MIN, LENGTH_MAX);
        int position = Engine.getRandomInt(1, length + 1);
        int start = Engine.getRandomInt(START_MIN, START_MAX);
        int step = Engine.getRandomInt(STEP_MIN, STEP_MAX);

        String question = "";
        String answer = "";

        for (int i = 1; i <= length; i++) {
            if (position == i) {
                question += "..";
                answer = String.valueOf(start);
            } else {
                question += start;
            }

            question += (i != length) ? " " : "";
            start += step;
        }

        round[0] = question;
        round[1] = answer;
    }

}
