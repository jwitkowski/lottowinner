package pl.sda.network;

import pl.sda.model.Game;
import pl.sda.model.GameType;

import java.io.IOException;
import java.time.LocalDateTime;

public interface GameApi {

    Game getGameForDate(GameType type, LocalDateTime date) throws IOException;

    Game getLastGame(GameType type) throws IOException;

    Game getFirstGame(GameType type) throws IOException;
}
