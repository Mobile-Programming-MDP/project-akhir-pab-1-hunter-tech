package com.pab.projectakhirpab.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.pab.projectakhirpab.R;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivImage;
    private TextView tvName, tvTentang;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivImage = findViewById(R.id.iv_image);
        tvName = findViewById(R.id.tv_name);
        tvTentang = findViewById(R.id.tv_tentang);

        Intent terima =getIntent();
        String name = terima.getStringExtra("varName");
        String tentang = terima.getStringExtra("varTentang");
        String image = terima.getStringExtra("varImage");
        getSupportActionBar().setTitle(name);

        tvName.setText(name);
        tvTentang.setText(tentang);
        Glide.with(DetailActivity.this)
                .load(image)
                .into(ivImage);
    }












}
