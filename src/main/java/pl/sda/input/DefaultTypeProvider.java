package pl.sda.input;

import pl.sda.model.GameType;

public class DefaultTypeProvider implements GameTypeProvider {
    private final MyScanner scanner;

    public DefaultTypeProvider(MyScanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public GameType getGameType() {
        System.out.println("Prosze podaj gre ktora chcesz sprawdzic");
        System.out.print("[ ");

        for (GameType type : GameType.values()) {
            System.out.print(type.getName() + " ");
        }

        System.out.print("]\n");

        String gameTypeName = scanner.nextLine().trim();
        return GameType.getTypeByName(gameTypeName);
    }
}
