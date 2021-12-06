package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void printHello() {
        System.out.println("May I have your name?");
        Scanner sc = new Scanner(System.in);    

        if (sc.hasNext()) {
            System.out.println("Hello, " + sc.next());
        }
    }
}