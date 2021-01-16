package pl.sda;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.sda.checker.Checker;
import pl.sda.checker.NumberChecker;
import pl.sda.converters.GsonProvider;
import pl.sda.input.*;
import pl.sda.model.Games;
import pl.sda.network.OkHttp;
import pl.sda.network.RequestBuilder;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        MyScanner scanner = new MyScanner();
        GameTypeProvider gameTypeProvider = new DefaultTypeProvider(scanner);
        Input userInput = new UserInput(scanner, gameTypeProvider);
        InputResult inputResult = userInput.getInputResults();

        Gson gson = GsonProvider.SINGLETON.getGson();
        OkHttpClient client = OkHttp.INSTANCE.getClient();

        Request request = new RequestBuilder(inputResult.getType()).build();

        Response response = client.newCall(request).execute();
        String stringresposne = response.body().string();

        Games dataFromBackend = gson.fromJson(stringresposne, Games.class);
        List<Integer> wonNumbers = dataFromBackend.getItems().get(0).getResults().get(0).getNumbers();

        Checker numberChecker = new NumberChecker();
        numberChecker.check(inputResult.getNumbers(), wonNumbers);
    }

}
