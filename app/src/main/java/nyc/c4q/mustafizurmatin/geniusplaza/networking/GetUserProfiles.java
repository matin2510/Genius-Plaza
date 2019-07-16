package nyc.c4q.mustafizurmatin.geniusplaza.networking;

import java.util.List;

import nyc.c4q.mustafizurmatin.geniusplaza.model.Users;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 7/16/19.
 */

public interface GetUserProfiles {
    @GET("/users")
    Call<List<Users>> getAllUsers();
}
