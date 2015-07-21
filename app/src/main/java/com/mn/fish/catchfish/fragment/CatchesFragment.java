package com.mn.fish.catchfish.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mn.fish.catchfish.FishApplication;
import com.mn.fish.catchfish.R;
import com.mn.fish.catchfish.adapter.CatchesAdapter;
import com.mn.fish.catchfish.model.Catch;
import com.mn.fish.catchfish.network.FishServiceManager;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class CatchesFragment extends BaseFragment {

    private static final String ARG_CATCHES = "arg_catches";

    private OnFragmentInteractionListener mListener;

    @Bind(R.id.refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.catches_grid)
    RecyclerView mCatchesRecyclerView;

    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    private CatchesAdapter mCatchesAdapter;
    private Subscription mSubscription;

    @Inject
    protected FishServiceManager mFishServiceManager;

    private ArrayList<Catch> mCatches;

    public static CatchesFragment newInstance() {
        return new CatchesFragment();
    }

    public CatchesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((FishApplication) getActivity().getApplication()).getFishComponent().inject(this);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(ARG_CATCHES)) {
                mCatches = savedInstanceState.getParcelableArrayList(ARG_CATCHES);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catches, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        if (mCatches == null || mCatches.size() == 0)
            fetchCatches();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    private void initViews() {
        mCatchesAdapter = new CatchesAdapter(this::showCatchDetailsFragment);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 7);
        mCatchesRecyclerView.setAdapter(mCatchesAdapter);
        mCatchesRecyclerView.setLayoutManager(gridLayoutManager);
        mCatchesAdapter.setCatches(mCatches);
        mCatchesAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setOnRefreshListener(this::fetchCatches);
    }

    private void showCatchDetailsFragment(Catch cCatch) {
        mListener.showCatchDetailsFragment(cCatch);
    }

    private void fetchCatches() {
        final ArrayList<Catch> newCatches = new ArrayList<>();
        mProgressBar.setVisibility(View.VISIBLE);
        mSubscription = mFishServiceManager.getCatches(6)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        newCatches::addAll,
                        throwable -> {
                            mProgressBar.setVisibility(View.INVISIBLE);
                            mSwipeRefreshLayout.setRefreshing(false);
                            showErrorMessage();
                        },
                        () -> {
                            mProgressBar.setVisibility(View.INVISIBLE);
                            if (mCatches == null)
                                mCatches = new ArrayList<>();
                            else
                                mCatches.clear();
                            mCatches.addAll(newCatches);
                            updateViews();
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                );
    }

    private void updateViews() {
        mCatchesAdapter.setCatches(mCatches);
        mCatchesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void showErrorMessage(){
        Toast.makeText(getActivity(), R.string.error_generic_refresh_feed,Toast.LENGTH_SHORT).show();
    }
    public interface OnFragmentInteractionListener {
        void showCatchDetailsFragment(Catch mCatch);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(ARG_CATCHES, mCatches);
    }
}
