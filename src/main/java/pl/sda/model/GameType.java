package pl.sda.model;

public enum GameType {
    LOTTO("Lotto", 6), MINI_LOTTO("MiniLotto", 5), KASKADA("Kaskada", 12), SZYBKIE_600("Szybkie600", 6);

    private final String name;
    private final int maxNumberCount;

    GameType(String name, int maxNumberCount) {
        this.name = name;
        this.maxNumberCount = maxNumberCount;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumberCount() {
        return maxNumberCount;
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
