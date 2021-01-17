package pl.sda.input;

import pl.sda.model.GameType;

import java.util.ArrayList;
import java.util.List;

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
        NumberValidator numberValidator = new NumberValidator(gameType);
        List<Integer> myNumbers = new ArrayList<>();

        do {
            System.out.print("podaj liczbe nr " + (myNumbers.size() + 1) + ": ");

            String numAsString = scanner.next();
            int newNumber = 0;

            newNumber = numberValidator.isItANumber(newNumber, numAsString);

            if (myNumbers.contains(newNumber)) {
                System.out.println("taka licza juz zostala wprowadzona");
                continue;
            }

            if (numberValidator.isOutOfRange(newNumber)) {
                System.out.println("liczba jest z poza zakresu");
                continue;
            }

            myNumbers.add(newNumber);
        } while (myNumbers.size() < gameType.getMaxNumberCount());

        return new InputResult(gameType, myNumbers);
    }
}
