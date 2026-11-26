package com.example.diomedesapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search")
    Call<SearchResponse> searchTracks(
            @Query("term") String term,
            @Query("entity") String entity,
            @Query("limit") int limit
    );
}