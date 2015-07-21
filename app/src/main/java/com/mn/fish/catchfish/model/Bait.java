package com.mn.fish.catchfish.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Bait implements Parcelable {
    @SerializedName("name")
    private String name;

    @SerializedName("is_color")
    private boolean isColor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isColor() {
        return isColor;
    }

    public void setIsColor(boolean isColor) {
        this.isColor = isColor;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeByte(isColor ? (byte) 1 : (byte) 0);
    }

    public Bait() {
    }

    protected Bait(Parcel in) {
        this.name = in.readString();
        this.isColor = in.readByte() != 0;
    }

    public static final Creator<Bait> CREATOR = new Creator<Bait>() {
        public Bait createFromParcel(Parcel source) {
            return new Bait(source);
        }

        public Bait[] newArray(int size) {
            return new Bait[size];
        }
    };
}
