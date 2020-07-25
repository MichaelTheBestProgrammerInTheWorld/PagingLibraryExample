package com.michaelmagdy.paginglibraryexample.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.michaelmagdy.paginglibraryexample.R;
import com.michaelmagdy.paginglibraryexample.model.Books;
import com.squareup.picasso.Picasso;

public class BooksPagedListAdapter extends PagedListAdapter<Books, BooksPagedListAdapter.BooksViewHolder> {


    protected BooksPagedListAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.books_list_item, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {

        Books book = getItem(position);
        if (book != null){

            holder.bookTitle.setText(book.getTitle());
            holder.bookIsbn.setText("ISBN : " + book.getIsbn13());
            holder.bookPrice.setText(book.getPrice());
            Picasso.get().load(book.getImage()).placeholder(R.drawable.loading)
                    .into(holder.bookImage);

        } else {
            Toast.makeText(holder.itemView.getContext(),
                    "Book is null", Toast.LENGTH_SHORT).show();
        }
    }

    private static DiffUtil.ItemCallback<Books> diffCallback =
            new DiffUtil.ItemCallback<Books>() {
                @Override
                public boolean areItemsTheSame(@NonNull Books oldItem, @NonNull Books newItem) {
                    return oldItem.getIsbn13() == newItem.getIsbn13();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Books oldItem, @NonNull Books newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class BooksViewHolder extends RecyclerView.ViewHolder {

        ImageView bookImage;
        TextView bookTitle, bookIsbn, bookPrice;

        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage = itemView.findViewById(R.id.book_image);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookIsbn = itemView.findViewById(R.id.book_isbn);
            bookPrice = itemView.findViewById(R.id.book_price);
        }
    }
}
