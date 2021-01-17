package pl.sda;


import pl.sda.checker.NumberChecker;
import pl.sda.input.DefaultTypeProvider;
import pl.sda.input.InputResult;
import pl.sda.input.MyScanner;
import pl.sda.input.UserInput;
import pl.sda.model.Game;
import pl.sda.network.GameApi;
import pl.sda.network.LottoGameApi;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        MyScanner scanner = new MyScanner();
        UserInput userInput = new UserInput(scanner, new DefaultTypeProvider(scanner));
        GameApi gameApi = new LottoGameApi();
        NumberChecker checker = new NumberChecker();

        InputResult results = userInput.getInputResults();
        Game game = gameApi.getLastGame(results.getType());
        List<Integer> hitNumbers = checker.check(results.getNumbers(), game.getNumbers());

        System.out.println(hitNumbers);
    }

}
