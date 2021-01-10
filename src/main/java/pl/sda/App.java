package pl.sda;


import com.google.gson.*;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.sda.model.GameType;
import pl.sda.model.Games;
import pl.sda.model.Order;
import pl.sda.network.HttpClient;
import pl.sda.network.RequestBuilder;
import pl.sda.utils.GsonProvider;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        Gson gson = GsonProvider.SINGLETON.getGson();

        OkHttpClient client = HttpClient.INSTANCE.getClient();

        Request request = new RequestBuilder(GameType.LOTTO)
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
