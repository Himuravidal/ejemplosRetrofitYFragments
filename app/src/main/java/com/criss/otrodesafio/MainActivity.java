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

    private TextView pregunta, categoria, dificultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Inicializo las vistas
        initializeViews();

        //Retrofit
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();

        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {


                categoria.setText(response.body().getResults().get(0).getQuestion());
                pregunta.setText(response.body().getResults().get(0).getCategory());


            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {

                Log.e("ERRORES", t.toString());

                Toast.makeText(MainActivity.this, "Algo fallo, intentelo despues", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initializeViews() {
        pregunta = findViewById(R.id.questions);
        categoria = findViewById(R.id.categoria);
        dificultad = findViewById(R.id.dificultad);
    }



}
