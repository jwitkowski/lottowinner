package pl.sda;


import pl.sda.input.DefaultTypeProvider;
import pl.sda.input.InputResult;
import pl.sda.input.MyScanner;
import pl.sda.input.UserInput;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        MyScanner scanner = new MyScanner();
        UserInput userInput = new UserInput(scanner, new DefaultTypeProvider(scanner));
        InputResult results = userInput.getInputResults();

        System.out.println(results.getNumbers());
    }

}
