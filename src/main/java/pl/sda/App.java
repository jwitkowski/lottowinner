package pl.sda;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.sda.converters.GsonProvider;
import pl.sda.model.GameType;
import pl.sda.model.Games;
import pl.sda.model.Order;
import pl.sda.network.OkHttp;
import pl.sda.network.RequestBuilder;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Gson gson = GsonProvider.SINGLETON.getGson();
        OkHttpClient client = OkHttp.INSTANCE.getClient();

        Request request = new RequestBuilder(GameType.SZYBKIE_600)
                .page(1)
                .fetchCount(10)
                .order(Order.ASC)
                .build();

        Response response = client.newCall(request).execute();
        String stringresposne = response.body().string();

        Games dataFromBackend = gson.fromJson(stringresposne, Games.class);

        System.out.println(dataFromBackend);
    }

}
