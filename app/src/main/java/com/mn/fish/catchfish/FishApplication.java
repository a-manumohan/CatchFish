package com.mn.fish.catchfish;

import android.app.Application;

import com.mn.fish.catchfish.di.DaggerFishComponent;
import com.mn.fish.catchfish.di.FishComponent;
import com.mn.fish.catchfish.di.FishModule;

/**
 * Created by manuMohan on 15/07/17.
 */
public class FishApplication extends Application {
    private FishComponent mFishComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mFishComponent = DaggerFishComponent.builder().fishModule(new FishModule(this)).build();
    }

    public FishComponent getFishComponent(){
        return mFishComponent;
    }
}
