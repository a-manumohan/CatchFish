package com.mn.fish.catchfish.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Catch implements Serializable{
    @SerializedName("id")
    private int id;

    @SerializedName("description")
    private String description;

    @SerializedName("caught_at_gmt")
    private String caughtAtGmt;

    @SerializedName("weight")
    private float weight;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("species")
    private Species species;

    @SerializedName("bait")
    private Bait bait;

    @SerializedName("method")
    private Method method;

    @SerializedName("photos")
    private ArrayList<Photo>photos;

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
}
