package com.pab.projectakhirpab.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pab.projectakhirpab.API.APIRequestData;
import com.pab.projectakhirpab.API.RetroServer;
import com.pab.projectakhirpab.Adapter.AdapterKarakter;
import com.pab.projectakhirpab.Model.KarakterModel;
import com.pab.projectakhirpab.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKarakter;
    private ProgressBar pbKarakter;
    private List<KarakterModel> listKarakter;
    private AdapterKarakter adapterKarakter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKarakter = findViewById(R.id.rv_karakter);
        pbKarakter = findViewById(R.id.pb_karakter);

        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvKarakter.setLayoutManager(linearLayoutManager);

        retrieveKarakter();
    }

    private void retrieveKarakter() {
        pbKarakter.setVisibility(View.VISIBLE);

        APIRequestData ardData = RetroServer.connectRetrofit().create(APIRequestData.class);
        Call<List<KarakterModel>> retrieveProcess = ardData.ardGet();

        retrieveProcess.enqueue(new Callback<List<KarakterModel>>() {
            @Override
            public void onResponse(Call<List<KarakterModel>> call, Response<List<KarakterModel>> response) {
                listKarakter = response.body();
                adapterKarakter = new AdapterKarakter(listKarakter);
                rvKarakter.setAdapter(adapterKarakter);

                pbKarakter.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<KarakterModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server : "+t.getMessage(),
                        Toast.LENGTH_SHORT).show();
                Log.d("CEK", t.getMessage());
                pbKarakter.setVisibility(View.INVISIBLE);

            }
        });
    }





























}