package pl.sda.network;

import okhttp3.HttpUrl;
import okhttp3.Request;
import pl.sda.model.GameType;
import pl.sda.model.Order;

public class RequestBuilder {
    private final GameType gameType;
    private int page = 1;
    private int fetchCount = 10;
    private Order order = Order.DESC;

    public RequestBuilder(GameType gameType) {
        this.gameType = gameType;
    }

    public RequestBuilder page(int page) {
        this.page = page;
        return this;
    }

    public RequestBuilder fetchCount(int fetchCount) {
        this.fetchCount = fetchCount;
        return this;
    }

    public RequestBuilder order(Order order) {
        this.order = order;
        return this;
    }

    public Request build() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("www.lotto.pl")
                .addPathSegments("api/lotteries/draw-results/by-gametype")
                .addQueryParameter("game", gameType.getName())
                .addQueryParameter("index", String.valueOf(page))
                .addQueryParameter("size", String.valueOf(fetchCount))
                .addQueryParameter("sort", "drawDate")
                .addQueryParameter("order", order.name())
                .build();
        return new Request.Builder()
                .url(url)
                .build();
    }
}
