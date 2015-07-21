package com.mn.fish.catchfish.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by manuMohan on 15/07/19.
 */
public class Photo implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("photo")
    private Details details;

    public class Details implements Serializable {
        @SerializedName("sizes")
        private ArrayList<Size> sizes;

        public class Size {
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
        }

        public ArrayList<Size> getSizes() {
            return sizes;
        }

        public void setSizes(ArrayList<Size> sizes) {
            this.sizes = sizes;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
