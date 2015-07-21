package com.mn.fish.catchfish.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Method implements Serializable{
    @SerializedName("localized_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
