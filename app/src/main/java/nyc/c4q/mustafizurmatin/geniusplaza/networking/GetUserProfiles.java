package nyc.c4q.mustafizurmatin.geniusplaza.networking;

import nyc.c4q.mustafizurmatin.geniusplaza.model.PostResponse;
import nyc.c4q.mustafizurmatin.geniusplaza.model.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Mustafizur Matin on 7/16/19.
 */

public interface GetUserProfiles {
    @GET("/api/users")
    Call<Response> getAllUsers();

    @POST("/api/users")
    @FormUrlEncoded
    Call<PostResponse> updatePost(@Field("name") String name,
                                  @Field("job") String job);
}
