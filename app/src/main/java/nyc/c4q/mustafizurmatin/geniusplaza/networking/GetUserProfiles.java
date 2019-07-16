package nyc.c4q.mustafizurmatin.geniusplaza.networking;

import java.util.List;

import nyc.c4q.mustafizurmatin.geniusplaza.model.Response;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mustafizur Matin on 7/16/19.
 */

public interface GetUserProfiles {
    @GET("/api/users")
    Call<List<Response>> getAllUsers();
}
