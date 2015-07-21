package com.mn.fish.catchfish.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by manuMohan on 15/07/21.
 */
public class PhotoDetails implements Parcelable {
    @SerializedName("sizes")
    private ArrayList<PhotoSize> photoSizes;


    public ArrayList<PhotoSize> getPhotoSizes() {
        return photoSizes;
    }

    public void setPhotoSizes(ArrayList<PhotoSize> photoSizes) {
        this.photoSizes = photoSizes;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(photoSizes);
    }

    public PhotoDetails() {
    }

    protected PhotoDetails(Parcel in) {
        this.photoSizes = in.createTypedArrayList(PhotoSize.CREATOR);
    }

    public static final Creator<PhotoDetails> CREATOR = new Creator<PhotoDetails>() {
        public PhotoDetails createFromParcel(Parcel source) {
            return new PhotoDetails(source);
        }

        public PhotoDetails[] newArray(int size) {
            return new PhotoDetails[size];
        }
    };
}
