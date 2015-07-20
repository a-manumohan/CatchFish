package com.mn.fish.catchfish.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mn.fish.catchfish.R;
import com.mn.fish.catchfish.model.Catch;
import com.mn.fish.catchfish.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by manuMohan on 15/07/19.
 */
public class CatchesAdapter extends RecyclerView.Adapter<CatchesAdapter.CatchViewHolder> {
    private ArrayList<Catch> mCatches;
    private CatchesAdapterListener mCatchesAdapterListener;

    public CatchesAdapter(CatchesAdapterListener catchesAdapterListener) {
        mCatchesAdapterListener = catchesAdapterListener;
    }

    @Override
    public CatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catch, parent, false);
        return new CatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CatchViewHolder holder, int position) {
        holder.pos = position;
        Catch cCatch = mCatches.get(position);
        Photo.Details.Size thumbnailSize = null;
        if (cCatch.getPhotos() == null || cCatch.getPhotos().size() == 0) {
            Picasso.with(holder.catchThumbnail.getContext()).load(R.drawable.placeholder_fish).into(holder.catchThumbnail);
            return;
        }
        Photo photo = cCatch.getPhotos().get(0);
        for (Photo.Details.Size size : photo.getDetails().getSizes()) {
            if (size.getGeometry().equals("64x64#")) {
                thumbnailSize = size;
                break;
            }
        }
        if (thumbnailSize == null) {
            thumbnailSize = photo.getDetails().getSizes().get(0);
        }
        Picasso.with(holder.catchThumbnail.getContext()).load(thumbnailSize.getUrl()).into(holder.catchThumbnail);
    }

    @Override
    public int getItemCount() {
        return mCatches == null ? 0 : mCatches.size();
    }

    public class CatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.catch_thumbnail)
        ImageView catchThumbnail;

        int pos;

        public CatchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Catch cCatch = mCatches.get(pos);
            mCatchesAdapterListener.catchSelected(cCatch);
        }
    }

    public void setCatches(ArrayList<Catch> catches) {
        mCatches = catches;
    }

    public interface CatchesAdapterListener {
        void catchSelected(Catch cCatch);
    }
}
