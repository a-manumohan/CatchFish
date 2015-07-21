package com.mn.fish.catchfish.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by manuMohan on 15/07/21.
 */
public class PhotoSize implements Parcelable{
    @SerializedName("geometry")
    private String geometry;

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.geometry);
        dest.writeString(this.url);
    }

    public PhotoSize() {
    }

    protected PhotoSize(Parcel in) {
        this.geometry = in.readString();
        this.url = in.readString();
    }

    public static final Creator<PhotoSize> CREATOR = new Creator<PhotoSize>() {
        public PhotoSize createFromParcel(Parcel source) {
            return new PhotoSize(source);
        }

        public PhotoSize[] newArray(int size) {
            return new PhotoSize[size];
        }
    };
}
