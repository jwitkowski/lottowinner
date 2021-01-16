package pl.sda.input;

import java.util.Scanner;

public class MyScanner {
    private final Scanner scanner;

    public MyScanner() {
        this.scanner = new Scanner(System.in);
    }

    public String next() {
        return scanner.next();
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}
