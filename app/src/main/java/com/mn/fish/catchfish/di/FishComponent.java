package com.mn.fish.catchfish.di;

import com.mn.fish.catchfish.fragment.CatchesFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by manuMohan on 15/07/17.
 */
@Singleton
@Component(modules = FishModule.class)
public interface FishComponent {
    void inject(CatchesFragment catchesFragment);
}
