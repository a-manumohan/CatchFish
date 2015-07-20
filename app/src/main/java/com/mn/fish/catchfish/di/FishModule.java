package com.mn.fish.catchfish.di;

import android.content.Context;

import com.mn.fish.catchfish.Constants;
import com.mn.fish.catchfish.network.FishService;
import com.mn.fish.catchfish.network.FishServiceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by manuMohan on 15/07/17.
 */
@Module
public class FishModule {
    private Context mContext;

    public FishModule(Context context) {
        mContext = context;
    }

    @Provides
    public Context provideApplicationContext() {
        return mContext;
    }

    @Provides
    public FishService provideFishService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL)
                .build();
        return restAdapter.create(FishService.class);
    }

    @Singleton
    @Provides
    public FishServiceManager provideFishServiceManager(FishService fishService) {
        return new FishServiceManager(fishService);
    }
}
