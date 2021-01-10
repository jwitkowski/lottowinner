package pl.sda;


import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.sda.model.GameType;
import pl.sda.model.Games;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {

    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

                    @Override
                    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        return LocalDateTime.parse(json.getAsString(), formatter);
                    }
                })
                .registerTypeAdapter(GameType.class, new JsonDeserializer<GameType>() {
                    @Override
                    public GameType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        return GameType.getTypeByName(json.getAsString());
                    }
                })
                .create();


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.lotto.pl/api/lotteries/draw-results/by-gametype?game=Szybkie600&index=1&size=150&sort=drawDate&order=DESC")
                .build();

        Response response = client.newCall(request).execute();
        String stringresposne = response.body().string();

        Games dataFromBackend = gson.fromJson(stringresposne, Games.class);

        System.out.println(dataFromBackend);
    }

}
