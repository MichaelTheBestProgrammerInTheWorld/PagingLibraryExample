package com.michaelmagdy.paginglibraryexample.model;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksDataSource extends PageKeyedDataSource<Integer, Books> {

    private static final int FIRST_PAGE = 1;
    //public static final String DUMMY_QUERY = "Java";
    private Query queryObj;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Books> callback) {

        queryObj = new Query();
        ApiClient.getApiClient().getApiInterface().getProgrammingBooks(queryObj.getSearchQuery(), FIRST_PAGE)
        .enqueue(new Callback<BooksApiResponse>() {
            @Override
            public void onResponse(Call<BooksApiResponse> call, Response<BooksApiResponse> response) {
                if (response.body() != null){
                    callback.onResult(response.body().getBooks(), null, FIRST_PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<BooksApiResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Books> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Books> callback) {

        ApiClient.getApiClient().getApiInterface().getProgrammingBooks(queryObj.getSearchQuery(), params.key)
                .enqueue(new Callback<BooksApiResponse>() {
                    @Override
                    public void onResponse(Call<BooksApiResponse> call, Response<BooksApiResponse> response) {

                        Integer key = params.key + 1;
                        if (response.body() != null){
                            callback.onResult(response.body().getBooks(), key);
                        } else {
                            //no more books to load
                        }
                    }

                    @Override
                    public void onFailure(Call<BooksApiResponse> call, Throwable t) {

                    }
                });
    }
}
