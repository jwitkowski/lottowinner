package pl.sda.model;

public enum GameType {
    LOTTO("Lotto"), MINI_LOTTO("MiniLotto"), KASKADA("Kaskada"), SZYBKIE_600("Szybkie600");

    private final String name;

    GameType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static GameType getTypeByName(String searchingName) {
        for (GameType type : GameType.values()){
            if(type.getName().equals(searchingName)){
                return type;
            }
        }

        return LOTTO;
    }
}
