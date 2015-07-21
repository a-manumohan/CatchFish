package com.mn.fish.catchfish.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Bait implements Serializable {
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
}
