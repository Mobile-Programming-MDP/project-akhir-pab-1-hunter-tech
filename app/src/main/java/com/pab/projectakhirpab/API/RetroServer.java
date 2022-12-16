package com.pab.projectakhirpab.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final  String baseURL = "https://638feb7e7642fef654d23bbd.mockapi.io/karakter/";
    private static Retrofit retro;

    public static Retrofit connectRetrofit(){
        if ((retro == null)){
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
