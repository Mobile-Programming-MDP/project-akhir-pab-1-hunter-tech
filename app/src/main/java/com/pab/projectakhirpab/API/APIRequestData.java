package com.pab.projectakhirpab.API;

import com.pab.projectakhirpab.Model.KarakterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("karakter")
    Call<List<KarakterModel>> ardGet();
}
