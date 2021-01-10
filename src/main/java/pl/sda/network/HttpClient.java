package pl.sda.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

public enum HttpClient {
    INSTANCE;
    private final OkHttpClient client;

    HttpClient() {
        HttpLoggingInterceptor loggingInterceptor = createLoggingInterceptor();
        client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @NotNull
    private HttpLoggingInterceptor createLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    public OkHttpClient getClient() {
        return client;
    }
}
