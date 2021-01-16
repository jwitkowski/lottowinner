package pl.sda;


import pl.sda.model.Game;
import pl.sda.model.GameType;
import pl.sda.network.GameApi;
import pl.sda.network.LottoGameApi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;

public class App {

    public static void main(String[] args) throws IOException {
        LocalDateTime searchDate = LocalDateTime.of(2019, Month.JANUARY, 5, 0, 0);
        GameApi api = new LottoGameApi();
        Game game = api.getGameForDate(GameType.LOTTO, searchDate);

        System.out.println(game);
    }

}
