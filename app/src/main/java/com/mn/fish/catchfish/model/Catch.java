package com.mn.fish.catchfish.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import auto.parcel.AutoParcel;

/**
 * Created by manuMohan on 15/07/19.
 */
@AutoParcel
public class Catch implements  Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("description")
    private String description;

    @SerializedName("caught_at_gmt")
    private String caughtAtGmt;

    @SerializedName("weight")
    private float weight;

    @SerializedName("length")
    private float length;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("species")
    private Species species;

    @SerializedName("bait")
    private Bait bait;

    @SerializedName("method")
    private Method method;

    @SerializedName("photos")
    private ArrayList<Photo> photos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaughtAtGmt() {
        return caughtAtGmt;
    }

    public void setCaughtAtGmt(String caughtAtGmt) {
        this.caughtAtGmt = caughtAtGmt;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Bait getBait() {
        return bait;
    }

    public void setBait(Bait bait) {
        this.bait = bait;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.description);
        dest.writeString(this.caughtAtGmt);
        dest.writeFloat(this.weight);
        dest.writeFloat(this.length);
        dest.writeParcelable(this.owner, 0);
        dest.writeParcelable(this.species, 0);
        dest.writeParcelable(this.bait, 0);
        dest.writeParcelable(this.method, 0);
        dest.writeTypedList(photos);
    }

    public Catch() {
    }

    protected Catch(Parcel in) {
        this.id = in.readInt();
        this.description = in.readString();
        this.caughtAtGmt = in.readString();
        this.weight = in.readFloat();
        this.length = in.readFloat();
        this.owner = in.readParcelable(Owner.class.getClassLoader());
        this.species = in.readParcelable(Species.class.getClassLoader());
        this.bait = in.readParcelable(Bait.class.getClassLoader());
        this.method = in.readParcelable(Method.class.getClassLoader());
        this.photos = in.createTypedArrayList(Photo.CREATOR);
    }

    public static final Creator<Catch> CREATOR = new Creator<Catch>() {
        public Catch createFromParcel(Parcel source) {
            return new Catch(source);
        }

        public Catch[] newArray(int size) {
            return new Catch[size];
        }
    };
}
