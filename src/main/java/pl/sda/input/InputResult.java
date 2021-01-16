package pl.sda.input;

import pl.sda.model.GameType;

import java.util.List;

public class InputResult {
    private final GameType type;
    private final List<Integer> numbers;

    public InputResult(GameType type, List<Integer> numbers) {
        this.type = type;
        this.numbers = numbers;
    }

    public GameType getType() {
        return type;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
