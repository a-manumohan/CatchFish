package com.mn.fish.catchfish.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Species implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("species")
    private String species;

    @SerializedName("status")
    private String status;

    @SerializedName("image")
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.species);
        dest.writeString(this.status);
        dest.writeString(this.image);
    }

    public Species() {
    }

    protected Species(Parcel in) {
        this.name = in.readString();
        this.species = in.readString();
        this.status = in.readString();
        this.image = in.readString();
    }

    public static final Creator<Species> CREATOR = new Creator<Species>() {
        public Species createFromParcel(Parcel source) {
            return new Species(source);
        }

        public Species[] newArray(int size) {
            return new Species[size];
        }
    };
}
