package pl.sda.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

public enum OkHttp {
    INSTANCE;

    private final OkHttpClient client;

    OkHttp() {
        HttpLoggingInterceptor loggingIntercepor = createLoggingInterceptor();

        client = new OkHttpClient.Builder()
                .addInterceptor(loggingIntercepor)
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
