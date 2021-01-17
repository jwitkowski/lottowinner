package pl.sda.network;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.sda.converters.GsonProvider;
import pl.sda.model.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class LottoGameApi implements GameApi {

    private final OkHttpClient client;
    private final Gson gson;
    private final PageProvider pageProvider;

    public LottoGameApi() {
        this.client = OkHttp.INSTANCE.getClient();
        this.gson = GsonProvider.SINGLETON.getGson();
        this.pageProvider = new PageProvider(LocalDateTime.now());
    }

    @Override
    public Game getGameForDate(GameType type, LocalDateTime date) throws IOException {
        int page = pageProvider.getPage(type, date);
        Request request = new RequestBuilder(type)
                .page(page)
                .fetchCount(1)
                .order(page < 0 ? Order.ASC : Order.DESC)
                .build();

        Response response = client.newCall(request).execute();
        String stringresposne = response.body().string();

        Games dataFromBackend = gson.fromJson(stringresposne, Games.class);
        Item firstElement = dataFromBackend.getItems().get(0);
        return new Game(firstElement.getGameType(), firstElement.getDrawDate(), firstElement.getResults().get(0).getNumbers());
    }

    @Override
    public Game getLastGame(GameType type) throws IOException {
        return getGameForOrder(type, Order.DESC);
    }

    @Override
    public Game getFirstGame(GameType type) throws IOException {
        return getGameForOrder(type, Order.ASC);
    }

    private Game getGameForOrder(GameType type, Order order) throws IOException {
        Request request = new RequestBuilder(type)
                .order(order)
                .build();

        Response response = client.newCall(request).execute();
        String stringresposne = response.body().string();

        Games dataFromBackend = gson.fromJson(stringresposne, Games.class);
        Item firstElement = dataFromBackend.getItems().get(0);
        return new Game(firstElement.getGameType(), firstElement.getDrawDate(), firstElement.getResults().get(0).getNumbers());
    }
}
