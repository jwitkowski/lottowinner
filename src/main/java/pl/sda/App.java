package pl.sda;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.sda.converters.GsonProvider;
import pl.sda.model.GameType;
import pl.sda.model.Games;
import pl.sda.network.OkHttp;
import pl.sda.network.RequestBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prosze podaj gre ktora chcesz sprawdzic");
        System.out.print("[ ");
        for (GameType type : GameType.values()) {
            System.out.print(type.getName() + " ");
        }
        System.out.print("]\n");

        String gameTypeName = scanner.nextLine();
        GameType gameType = GameType.getTypeByName(gameTypeName);
        int[] userNumbers = new int[gameType.getMaxNumberCount()];
        //Lotto
        //1,3,6,9,13,25
        int numCounter = 0;

        do {
            System.out.print("podaj liczbe nr " + (numCounter + 1) +": ");
            userNumbers[numCounter] = scanner.nextInt();
            numCounter++;
        } while (numCounter < gameType.getMaxNumberCount());


        Gson gson = GsonProvider.SINGLETON.getGson();
        OkHttpClient client = OkHttp.INSTANCE.getClient();

        Request request = new RequestBuilder(gameType).build();

        Response response = client.newCall(request).execute();
        String stringresposne = response.body().string();

        Games dataFromBackend = gson.fromJson(stringresposne, Games.class);
        List<Integer> wonNumbers = dataFromBackend.getItems().get(0).getResults().get(0).getNumbers();

        System.out.println("Gra: " + dataFromBackend.getItems().get(0).getGameType().getName());
        System.out.println("Data losowania: " + dataFromBackend.getItems().get(0).getDrawDate().toString());
        System.out.println(Arrays.toString(userNumbers));
        System.out.println(wonNumbers);

    }

}
