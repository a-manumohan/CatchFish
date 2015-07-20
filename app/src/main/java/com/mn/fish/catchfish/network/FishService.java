package com.mn.fish.catchfish.network;

import com.mn.fish.catchfish.model.Catch;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by manuMohan on 15/07/17.
 */
public interface FishService {
    @GET("/catches")
    Observable<ArrayList<Catch>> getCatches(
            @Query("page") int page,
            @Query("verbosity") int verbosity
    );
}
