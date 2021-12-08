package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String printHello(Scanner sc) {
        String name = "";

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        if (sc.hasNext()) {
            name = sc.next();
            System.out.println("Hello, " + name);
        }

        return name;
    }
}
