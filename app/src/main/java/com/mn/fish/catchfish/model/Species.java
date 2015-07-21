package com.mn.fish.catchfish.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Species implements Serializable {
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
}
