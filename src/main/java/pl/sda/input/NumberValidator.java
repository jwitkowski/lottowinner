package pl.sda.input;

import pl.sda.model.GameType;

public class NumberValidator {
    private final GameType gameType;


    public NumberValidator(GameType gameType) {
        this.gameType = gameType;
    }

    public boolean isOutOfRange(int newNumber) {
        return newNumber <= 0 || newNumber > gameType.getRange();
    }
}
