package hexlet.code.games;

public abstract class Game extends Object {
    public void printMessageBefore() { }

    public abstract void round(String[] round);

    public void printMessageAfterSuccess() { }

    public void printMessageAfterError() { }

}
