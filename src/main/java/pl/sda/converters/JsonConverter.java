package pl.sda.converters;

import com.google.gson.Gson;

public class JsonConverter implements Converter {
    private final Gson gson = GsonProvider.SINGLETON.getGson();

    @Override
    public <T> T convert(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, clazz);
    }
}
