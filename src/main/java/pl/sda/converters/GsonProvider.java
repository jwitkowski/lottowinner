package pl.sda.converters;

import com.google.gson.*;
import pl.sda.model.GameType;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum GsonProvider {
    SINGLETON;

    private final Gson gson;

    GsonProvider() {
        gson = new GsonBuilder()
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
    }

    public Gson getGson() {
        return gson;
    }
}
