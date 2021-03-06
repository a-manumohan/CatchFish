package com.mn.fish.catchfish.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mn.fish.catchfish.R;
import com.mn.fish.catchfish.fragment.CatchDetailsFragment;
import com.mn.fish.catchfish.fragment.CatchesFragment;
import com.mn.fish.catchfish.model.Catch;


public class MainActivity extends AppCompatActivity implements
        CatchesFragment.OnFragmentInteractionListener,
        CatchDetailsFragment.OnFragmentInteractionListener {

    private static final String TAG_CATCHES_FRAGMENT = "catches_fragment";
    private static final String TAG_CATCH_DETAILS_FRAGMENT = "catch_details";

    private static final String ARG_CURRENT_FRAGMENT = "current_fragment";

    private String mCurrentFragmentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(ARG_CURRENT_FRAGMENT)) {
                mCurrentFragmentTag = savedInstanceState.getString(ARG_CURRENT_FRAGMENT);
            }
        }

        if (mCurrentFragmentTag == null || mCurrentFragmentTag.equals("")) {
            showCatchesFragment();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showCatchesFragment() {
        CatchesFragment catchesFragment = CatchesFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.child_container, catchesFragment, TAG_CATCHES_FRAGMENT)
                .commit();
        mCurrentFragmentTag = TAG_CATCHES_FRAGMENT;
    }

    @Override
    public void showCatchDetailsFragment(Catch mCatch) {
        CatchDetailsFragment catchDetailsFragment = CatchDetailsFragment.newInstance(mCatch);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.child_container, catchDetailsFragment, TAG_CATCH_DETAILS_FRAGMENT)
                .addToBackStack(null)
                .commit();
        mCurrentFragmentTag = TAG_CATCH_DETAILS_FRAGMENT;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_CURRENT_FRAGMENT, mCurrentFragmentTag);
    }
}
