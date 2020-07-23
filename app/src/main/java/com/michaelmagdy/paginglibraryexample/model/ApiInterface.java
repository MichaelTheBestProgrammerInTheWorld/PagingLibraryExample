package com.michaelmagdy.paginglibraryexample.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search/{query}/{page}")
    Call<BooksApiResponse> getProgrammingBooks (
            @Path("query") String query,
            @Path("page") int page
    );
}
