package pl.sda.input;

import pl.sda.model.GameType;

public class NumberValidatorMonolith {
    private final GameType gameType;
    private final Integer[] validNumbers;


    public NumberValidatorMonolith(GameType gameType) {
        this.gameType = gameType;
        this.validNumbers = new Integer[gameType.getMaxNumberCount()];
    }

    public void checkAndAdd(int position, String newNumberAsString) throws IllegalArgumentException {
        if (newNumberAsString == null || newNumberAsString.isEmpty()) {
            return;
        }
        int newNumber = tryParseString(newNumberAsString);
        checkAndAdd(position, newNumber);
    }

    private int tryParseString(String newNumberAsString) {
        try {
            return Integer.parseInt(newNumberAsString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("To nie jest Liczba");
        }
    }

    public void checkAndAdd(int position, int newNumber) throws IllegalArgumentException {
        checkIsAlreadyAdded(newNumber);
        checkIsOutOfRange(newNumber);
        validNumbers[position] = newNumber;
    }

    private void checkIsOutOfRange(int newNumber) {
        if (newNumber <= 0 || newNumber > gameType.getRange()) {
            throw new IllegalArgumentException("Liczba nie spelnia naszych zalozen");
        }
    }

    private void checkIsAlreadyAdded(int newNumber) {
        for (Integer number : validNumbers) {
            if (number != null && number == newNumber) {
                throw new IllegalArgumentException("ta liczba juz zostala dodana");
            }
        }
    }

    public void clear(int position){
        validNumbers[position] = null;
    }

    public Integer[] getValidNumbers() {
        return validNumbers;
    }

    public int size() {
        int size = 0;
        for (Integer num : validNumbers) {
            if (num != null) {
                size++;
            }
        }
        return size;
    }
}
