package com.michaelmagdy.paginglibraryexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BooksApiResponse {


    @Expose
    @SerializedName("books")
    private List<Books> books;
    @Expose
    @SerializedName("page")
    private String page;
    @Expose
    @SerializedName("total")
    private String total;
    @Expose
    @SerializedName("error")
    private String error;

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
