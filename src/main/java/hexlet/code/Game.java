//Set and read questions and answers
package hexlet.code;

public class Game {
    private static String[] questions;
    private static String[] answers;

    static {
        questions = new String[Engine.MAX_RETRIES];
        answers = new String[Engine.MAX_RETRIES];
    }

    public static void setRound(int i, String question, String answer) {
        questions[i] = question;
        answers[i] = answer;
    }

    public static String[] getQuestions() {
        return questions;
    }

    public static String[] getAnswers() {
        return answers;
    }
}
