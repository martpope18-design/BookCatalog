package com.example.bookcatalog;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

// Main screen - shows the list of all books
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        ListView listView = findViewById(R.id.listViewBooks);
        TextView tvBookCount = findViewById(R.id.tvBookCount);

        // Get all books from our data class
        List<Book> books = BookData.getBooks();

        // Update book count display
        tvBookCount.setText(books.size() + " Books Available");

        // Create adapter and set it to the ListView
        BookAdapter adapter = new BookAdapter(this, books);
        listView.setAdapter(adapter);

        // Load animation for list items
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        // When user clicks a book, open detail screen
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Book selectedBook = books.get(position);

            // Animate the clicked item
            view.startAnimation(fadeIn);

            // Create intent to open BookDetailActivity
            Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);

            // Pass book data to the detail screen
            intent.putExtra("TITLE", selectedBook.getTitle());
            intent.putExtra("AUTHOR", selectedBook.getAuthor());
            intent.putExtra("GENRE", selectedBook.getGenre());
            intent.putExtra("DESCRIPTION", selectedBook.getDescription());
            intent.putExtra("IMAGE", selectedBook.getImageResourceId());

            // Start the detail activity
            startActivity(intent);
        });
    }
}