package nyc.c4q.mustafizurmatin.geniusplaza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

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

    private ArrayList<Users> resultsList = new ArrayList<>();
    private static final String TAG = "ERROR";
    private  GetUserProfiles service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.myRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        service = RetrofitClient.getRetrofitInstance().create(GetUserProfiles.class);
        serviceCall();

        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setAdapter(myAdapter);
    }
    public void serviceCall(){
        Call<Response> call = service.getAllUsers();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: ");
                    Response response1 =  response.body();
                    resultsList = response1.getData();
                    Log.d(TAG, "onResponse: " + resultsList.size());
                    myAdapter = new UserAdpater(resultsList);
                    myRecyclerView.setAdapter(myAdapter);
                } else {
                    Log.d(TAG, "on Response Error: " + response.errorBody().toString());
                }
            }
            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
 }