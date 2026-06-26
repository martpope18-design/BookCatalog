package com.example.bookcatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

// This adapter connects the book data to the ListView
public class BookAdapter extends BaseAdapter {

    private Context context;
    private List<Book> books;

    // Constructor
    public BookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size(); // How many items in the list
    }

    @Override
    public Object getItem(int position) {
        return books.get(position); // Get book at position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate (create) the layout for each row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_book, parent, false);
        }

        // Get the current book
        Book book = books.get(position);

        // Link views
        ImageView imgCover = convertView.findViewById(R.id.imgBookCover);
        TextView tvTitle = convertView.findViewById(R.id.tvListTitle);
        TextView tvAuthor = convertView.findViewById(R.id.tvListAuthor);
        TextView tvGenre = convertView.findViewById(R.id.tvListGenre);
        TextView tvDescription = convertView.findViewById(R.id.tvListDescription);

        // Set data
        imgCover.setImageResource(book.getImageResourceId());
        tvTitle.setText(book.getTitle());
        tvAuthor.setText("By " + book.getAuthor());
        tvGenre.setText(book.getGenre());
        
        // Show short description in the list
        if (tvDescription != null) {
            tvDescription.setText(book.getDescription());
        }

        return convertView;
    }
}