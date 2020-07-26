package com.michaelmagdy.paginglibraryexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.michaelmagdy.paginglibraryexample.R;
import com.michaelmagdy.paginglibraryexample.model.Books;
import com.michaelmagdy.paginglibraryexample.viewmodel.BooksListViewModel;

public class BooksListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BooksListViewModel booksListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        BooksPagedListAdapter adapter = new BooksPagedListAdapter();

        booksListViewModel = ViewModelProviders.of(this).get(BooksListViewModel.class);
        booksListViewModel.getBooksPagedList().observe(this, new Observer<PagedList<Books>>() {
            @Override
            public void onChanged(PagedList<Books> books) {
                adapter.submitList(books);
            }
        });

        recyclerView.setAdapter(adapter);

    }
}
