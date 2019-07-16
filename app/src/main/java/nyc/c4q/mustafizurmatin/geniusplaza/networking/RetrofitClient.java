package nyc.c4q.mustafizurmatin.geniusplaza.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mustafizur Matin on 7/16/19.
 */

public class RetrofitClient {

    private static Retrofit retrofit;

    private static final String BASE_URL = "https://reqres.in";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
