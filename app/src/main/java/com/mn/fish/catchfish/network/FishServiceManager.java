package com.mn.fish.catchfish.network;

import com.mn.fish.catchfish.model.Catch;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by manuMohan on 15/07/17.
 */
@Singleton
public class FishServiceManager {
    private FishService mFishService;
    private static final int LOW = 0;
    private static final int MEDIUM = 2;
    private static final int HIGH = 3;

    @Inject
    public FishServiceManager(FishService fishService) {
        mFishService = fishService;
    }

    public Observable<ArrayList<Catch>> getCatches(int pages) {
        Observable<ArrayList<Catch>> catchObservable;
        if (pages == 0 || pages == 1) {
            catchObservable = mFishService.getCatches(1, MEDIUM);
            return catchObservable;
        } else {
            catchObservable = mFishService.getCatches(pages, MEDIUM);
        }
        for (int i = pages - 1; i > 0; --i) {
            catchObservable = catchObservable.startWith(mFishService.getCatches(i, MEDIUM));
        }
        return catchObservable;
    }
}
