package com.mn.fish.catchfish.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mn.fish.catchfish.R;
import com.mn.fish.catchfish.model.Catch;
import com.mn.fish.catchfish.model.PhotoSize;
import com.squareup.picasso.Picasso;

import butterknife.Bind;


public class CatchDetailsFragment extends BaseFragment {
    private static final String ARG_CATCH = "arg_catch";

    private Catch mCatch;

    private OnFragmentInteractionListener mListener;

    @Bind(R.id.catch_title)
    TextView mCatchTitleTextView;

    @Bind(R.id.species_name)
    TextView mSpeciesNameTextView;

    @Bind(R.id.catch_image)
    ImageView mCatchImageView;

    @Bind(R.id.fish_species)
    TextView mFishSpeciesTextView;

    @Bind(R.id.fish_weight)
    TextView mFishWeightTextView;

    @Bind(R.id.length)
    TextView mFishLengthTextView;

    @Bind(R.id.angler)
    TextView mAnglerTextView;


    public static CatchDetailsFragment newInstance(Catch mCatch) {
        CatchDetailsFragment fragment = new CatchDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CATCH, mCatch);
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
            mCatch = getArguments().getParcelable(ARG_CATCH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catch_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        String title = mCatch.getSpecies().getName() + ", " + mCatch.getWeight() + " lb";
        mCatchTitleTextView.setText(title);

        mSpeciesNameTextView.setText(mCatch.getSpecies().getSpecies());

        if (mCatch.getPhotos() == null || mCatch.getPhotos().size() == 0) {
            Picasso.with(getActivity()).load(R.drawable.placeholder_fish).into(mCatchImageView);
        } else {
            int lastImageIndex = mCatch.getPhotos().get(0).getDetails().getPhotoSizes().size();
            PhotoSize largeImageSize = mCatch.getPhotos().get(0).getDetails().getPhotoSizes().get(lastImageIndex - 1);
            Picasso.with(getActivity()).load(largeImageSize.getUrl()).into(mCatchImageView);
        }

        mFishSpeciesTextView.setText(mCatch.getSpecies().getSpecies());
        mFishWeightTextView.setText(mCatch.getWeight() + " lb");
        mFishLengthTextView.setText(mCatch.getLength() + " ft");
        mAnglerTextView.setText(mCatch.getOwner().getNickname());
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
