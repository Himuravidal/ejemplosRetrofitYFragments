package com.criss.otrodesafio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.criss.otrodesafio.api.Api;
import com.criss.otrodesafio.api.RetrofitClient;
import com.criss.otrodesafio.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String primeraCosa, segundaCosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Retrofit
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();

        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                primeraCosa= response.body().getResults().get(0).getQuestion();
                segundaCosa= response.body().getResults().get(0).getCategory();
                initializeFragment(primeraCosa,segundaCosa);
            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Log.e("ERRORES", t.toString());
                Toast.makeText(MainActivity.this, "Algo fallo, intentelo despues", Toast.LENGTH_SHORT).show();
            }
        });


    }


    //Este método inicializa y añade un fragmento
    private void initializeFragment(String cosa1, String cosa2) {
        Log.e("ERROR", "SI_PASA");
        FirstFragment firstFragment = FirstFragment.newInstance(cosa1, cosa2);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, firstFragment, "FIRSTFRAGMENT")
                .commit();
    }







}
