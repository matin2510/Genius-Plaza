package nyc.c4q.mustafizurmatin.geniusplaza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import nyc.c4q.mustafizurmatin.geniusplaza.adapter.UserAdpater;
import nyc.c4q.mustafizurmatin.geniusplaza.model.PostResponse;
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
    private static final String TAG = "MainActivity";
    private  GetUserProfiles service;

    private EditText name;
    private EditText job;
    private Button post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.post_name);
        job = findViewById(R.id.post_job);
        post = findViewById(R.id.post);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty() && !job.getText().toString().isEmpty()){
                    sendPost(name.getText().toString(),job.getText().toString());
                    name.setText("");
                    job.setText("");
                }else
                    Toast.makeText(MainActivity.this,"Both fields required", Toast.LENGTH_LONG).show();
            }
        });
        myRecyclerView = findViewById(R.id.myRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        service = RetrofitClient.getRetrofitInstance().create(GetUserProfiles.class);
        getUsers();

        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setAdapter(myAdapter);
    }
    public void getUsers(){
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
        });}

        public void sendPost(String name, String job){
            Call<PostResponse> call1 = service.updatePost(name,job);
            call1.enqueue(new Callback<PostResponse>() {
                @Override
                public void onResponse(Call<PostResponse> call, retrofit2.Response<PostResponse> response) {
                    if (response.isSuccessful()){
                        Log.d(TAG, "onResponse:" + response.body().getName() + " " + response.body().getId());
                        Toast.makeText(MainActivity.this,response.body().getName() + " " + response.body().getId(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<PostResponse> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                }
            });
        }

 }