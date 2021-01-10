package pl.sda;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.sda.converters.GsonProvider;
import pl.sda.model.Games;
import pl.sda.network.OkHttp;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Gson gson = GsonProvider.SINGLETON.getGson();

        OkHttpClient client = OkHttp.INSTANCE.getClient();

        Request request = new Request.Builder()
                .url("https://www.lotto.pl/api/lotteries/draw-results/by-gametype?game=Lotto&index=1&size=2&sort=drawDate&order=DESC")
                .build();

        Response response = client.newCall(request).execute();
        String stringresposne = response.body().string();

        Games dataFromBackend = gson.fromJson(stringresposne, Games.class);

        System.out.println(dataFromBackend);
    }

}
