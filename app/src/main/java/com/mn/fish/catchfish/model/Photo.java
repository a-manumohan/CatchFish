package com.mn.fish.catchfish.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Photo implements Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("photo")
    private PhotoDetails details;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PhotoDetails getDetails() {
        return details;
    }

    public void setDetails(PhotoDetails details) {
        this.details = details;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeParcelable(this.details, 0);
    }

    public Photo() {
    }

    protected Photo(Parcel in) {
        this.id = in.readInt();
        this.details = in.readParcelable(PhotoDetails.class.getClassLoader());
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };
}
