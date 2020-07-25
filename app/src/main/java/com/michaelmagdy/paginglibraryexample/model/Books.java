package com.michaelmagdy.paginglibraryexample.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Books {
    @Expose
    @SerializedName("url")
    private String url;
    @Expose
    @SerializedName("image")
    private String image;
    @Expose
    @SerializedName("price")
    private String price;
    @Expose
    @SerializedName("isbn13")
    private String isbn13;
    @Expose
    @SerializedName("subtitle")
    private String subtitle;
    @Expose
    @SerializedName("title")
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
