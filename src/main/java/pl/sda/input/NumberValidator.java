package pl.sda.input;

import pl.sda.model.GameType;

import java.util.List;

public class NumberValidator {
    private final GameType gameType;


    public NumberValidator(GameType gameType) {
        this.gameType = gameType;
    }

    public boolean isOutOfRange(int newNumber) {
        return newNumber <= 0 || newNumber > gameType.getRange();
    }


    public int isItANumber(int newNumber, String numAsString) {
        try {
            newNumber = Integer.parseInt(numAsString);
        } catch (NumberFormatException e) {
            System.out.println("to nie jest liczba");
        }

        return newNumber;
    }

    public void isThisNumberAlreadyInputed(List<Integer> myNumbers, int newNumber) {
        if (myNumbers.contains(newNumber)) {
            System.out.println("taka licza juz zostala wprowadzona");
        }
    }
}
