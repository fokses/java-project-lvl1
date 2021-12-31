package hexlet.code.games;

import hexlet.code.GameFlowException;
import hexlet.code.ScannerException;
import hexlet.code.WrongAnswerException;

import java.util.Scanner;

public abstract class Game {
    public abstract void startGame(Scanner sc)
            throws GameFlowException, ScannerException, WrongAnswerException;

    public abstract void fillRound(int i);
}
