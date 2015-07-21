package com.mn.fish.catchfish.network;

import com.mn.fish.catchfish.BuildConfig;
import com.mn.fish.catchfish.model.Catch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import rx.Observable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by manuMohan on 15/07/21.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(emulateSdk = 21, constants = BuildConfig.class)
public class FishServiceManagerTest {
    @Mock
    FishService mFishService;

    FishServiceManager mFishServiceManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mFishServiceManager = new FishServiceManager(mFishService);
    }

    @Test
    public void getCatches() {
        ArrayList<Catch> catches = new ArrayList<>();
        when(mFishService.getCatches(anyInt(), eq(FishServiceManager.MEDIUM)))
                .thenReturn(Observable.just(catches));

        /**
         * Test for the number of pages returned
         */

        //Test for 0 or 1 page. both effectively returns 1 page

        int numberOfPages = 0;
        final int[] count = {0};
        mFishServiceManager.getCatches(numberOfPages).toBlocking().forEach(catches1 -> {
            if (catches1 != null)
                count[0]++;
        });
        assertEquals("Number of results doesn't match number of calls", 1, count[0]);

        numberOfPages = 1;
        count[0] = 0;
        mFishServiceManager.getCatches(numberOfPages).toBlocking().forEach(catches1 -> {
            if (catches1 != null)
                count[0]++;
        });
        assertEquals("Number of results doesn't match number of calls", numberOfPages, count[0]);

        //test for more than 1 page
        numberOfPages = 3;
        count[0] = 0;
        mFishServiceManager.getCatches(numberOfPages).toBlocking().forEach(catches1 -> {
            if (catches1 != null)
                count[0]++;
        });
        assertEquals("Number of results doesn't match number of calls", numberOfPages, count[0]);
    }
}
