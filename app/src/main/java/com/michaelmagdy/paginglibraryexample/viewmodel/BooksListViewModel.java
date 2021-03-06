package com.michaelmagdy.paginglibraryexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.michaelmagdy.paginglibraryexample.model.Books;
import com.michaelmagdy.paginglibraryexample.model.BooksDataSourceFactory;
import com.michaelmagdy.paginglibraryexample.model.Query;

public class BooksListViewModel extends ViewModel {

    private LiveData<PagedList<Books>> booksPagedList;
    private LiveData<PageKeyedDataSource<Integer, Books>> liveDataSource;
    private Query queryObj;

    public BooksListViewModel() {

        BooksDataSourceFactory dataSourceFactory = new BooksDataSourceFactory();
        liveDataSource = dataSourceFactory.getBooksLiveData();
        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(5)
                .build();
        booksPagedList = new LivePagedListBuilder(dataSourceFactory, config)
                .build();
    }

    public LiveData<PagedList<Books>> getBooksPagedList() {
        return booksPagedList;
    }

    public void setSearchQuery(String searchQuery) {

        queryObj = new Query();
        queryObj.setSearchQuery(searchQuery);
    }
}
