package pl.sda.input;

import pl.sda.model.GameType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput implements Input {

    private final MyScanner scanner;
    private final GameTypeProvider gameTypeProvider;

    public UserInput(MyScanner scanner, GameTypeProvider gameTypeProvider) {
        this.scanner = scanner;
        this.gameTypeProvider = gameTypeProvider;
    }

    @Override
    public InputResult getInputResults() {
        GameType gameType = gameTypeProvider.getGameType();
        List<Integer> userNumbers = new ArrayList<>();

        do {
            System.out.print("podaj liczbe nr " + (userNumbers.size() + 1) + ": ");

            String numAsString = scanner.next();
            int newNumber = 0;

            try {
                newNumber = Integer.parseInt(numAsString);
            } catch (NumberFormatException e) {
                System.out.println("Musisz podac liczbe");
                continue;
            }

            if (userNumbers.contains(newNumber)) {
                System.out.println("Już podałeś taką liczbę, podaj inną");
                continue;
            }

            if (newNumber > 0 && newNumber <= gameType.getRange()) {
                userNumbers.add(newNumber);
            } else {
                System.out.println("liczba: " + newNumber + " jest z poza zakresu 1-" + gameType.getRange());
            }
        } while (userNumbers.size() < gameType.getMaxNumberCount());

        return new InputResult(gameType, userNumbers);
    }
}
