package pl.sda.model;

import java.time.LocalDateTime;
import java.util.List;

public class Game {
    private final GameType type;
    private final LocalDateTime dateTime;
    private final List<Integer> numbers;

    public Game(GameType type, LocalDateTime dateTime, List<Integer> numbers) {
        this.type = type;
        this.dateTime = dateTime;
        this.numbers = numbers;
    }

    public GameType getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
