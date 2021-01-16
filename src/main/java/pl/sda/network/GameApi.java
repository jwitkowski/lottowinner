package pl.sda.network;

import pl.sda.model.Game;
import pl.sda.model.GameType;

import java.io.IOException;

public interface GameApi {

    Game getLastGame(GameType type) throws IOException;

    Game getFirstGame(GameType type) throws IOException;
}
