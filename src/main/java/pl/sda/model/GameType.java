package pl.sda.model;

public enum GameType {
    LOTTO("Lotto", 6, 49),
    MINI_LOTTO("MiniLotto", 5, 42),
    KASKADA("Kaskada", 12, 24),
    SZYBKIE_600("Szybkie600", 6, 32);

    private final String name;
    private final int maxNumberCount;
    private final int range;

    GameType(String name, int maxNumberCount, int range) {
        this.name = name;
        this.maxNumberCount = maxNumberCount;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumberCount() {
        return maxNumberCount;
    }

    public int getRange() {
        return range;
    }

    public static GameType getTypeByName(String searchingName) {
        for (GameType type : GameType.values()) {
            if (type.getName().equalsIgnoreCase(searchingName)) {
                return type;
            }
        }

        return LOTTO;
    }
}
