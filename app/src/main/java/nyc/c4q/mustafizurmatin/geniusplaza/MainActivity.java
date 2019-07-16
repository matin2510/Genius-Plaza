package nyc.c4q.mustafizurmatin.geniusplaza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.mustafizurmatin.geniusplaza.adapter.UserAdpater;
import nyc.c4q.mustafizurmatin.geniusplaza.model.Response;
import nyc.c4q.mustafizurmatin.geniusplaza.model.Users;
import nyc.c4q.mustafizurmatin.geniusplaza.networking.GetUserProfiles;
import nyc.c4q.mustafizurmatin.geniusplaza.networking.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private UserAdpater myAdapter;
    private RecyclerView myRecyclerView;

    private List<Users> resultsList = new ArrayList<>();
    private static final String TAG = "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetUserProfiles service = RetrofitClient.getRetrofitInstance().create(GetUserProfiles.class);
        Call<List<Response>> call = service.getAllUsers();
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: ");
                    Response response1 = (Response) response.body();
                    resultsList = response1.getData();
                    myAdapter = new UserAdpater(resultsList);
                    myRecyclerView.setAdapter(myAdapter);
                } else {
                    Log.d(TAG, "on Response Error: " + response.errorBody().toString());
                }
            }
            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {

            }
        });
    }
 }