package com.mn.fish.catchfish.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Method implements Parcelable{
    @SerializedName("localized_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public Method() {
    }

    protected Method(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<Method> CREATOR = new Creator<Method>() {
        public Method createFromParcel(Parcel source) {
            return new Method(source);
        }

        public Method[] newArray(int size) {
            return new Method[size];
        }
    };
}
