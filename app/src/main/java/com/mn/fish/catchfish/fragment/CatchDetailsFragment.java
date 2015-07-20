package com.mn.fish.catchfish.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mn.fish.catchfish.R;
import com.mn.fish.catchfish.model.Catch;


public class CatchDetailsFragment extends BaseFragment {
    private static final String ARG_CATCH = "arg_catch";

    private Catch mCatch;

    private OnFragmentInteractionListener mListener;

    public static CatchDetailsFragment newInstance(Catch mCatch) {
        CatchDetailsFragment fragment = new CatchDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CATCH, mCatch);
        fragment.setArguments(args);
        return fragment;
    }

    public CatchDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCatch = (Catch) getArguments().getSerializable(ARG_CATCH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catch_details, container, false);
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

    public interface OnFragmentInteractionListener {
    }

}
