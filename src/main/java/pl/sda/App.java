package pl.sda;


import pl.sda.checker.Checker;
import pl.sda.checker.NumberChecker;
import pl.sda.input.*;
import pl.sda.model.Game;
import pl.sda.network.GameApi;
import pl.sda.network.LottoGameApi;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        MyScanner scanner = new MyScanner();
        Input userInput = new UserInput(scanner, new DefaultTypeProvider(scanner));
        InputResult inputResult = userInput.getInputResults();

        GameApi api = new LottoGameApi();
        Game game = api.getLastGame(inputResult.getType());

        Checker numberChecker = new NumberChecker();
        numberChecker.check(inputResult.getNumbers(), game.getNumbers());
    }

}
