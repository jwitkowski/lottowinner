package pl.sda;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.sda.model.IssData;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://api.open-notify.org/iss-now.json")
                .build();

        Response response = client.newCall(request).execute();
        String stringresposne = response.body().string();

        IssData dataFromBackend =  gson.fromJson(stringresposne, IssData.class);

        System.out.println(dataFromBackend);
    }

}
