package com.example.bookcatalog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BookDetailActivity extends AppCompatActivity {

    private static final String TAG = "BookDetail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        // Link all views
        ImageView imgCover = findViewById(R.id.imgDetailCover);
        TextView tvTitle = findViewById(R.id.tvDetailTitle);
        TextView tvAuthor = findViewById(R.id.tvDetailAuthor);
        TextView tvGenre = findViewById(R.id.tvDetailGenre);
        TextView tvDescription = findViewById(R.id.tvDetailDescription);
        ImageButton btnBack = findViewById(R.id.btnBack);
        Button btnBackBottom = findViewById(R.id.btnBackBottom);
        Button btnShare = findViewById(R.id.btnShare);

        // Get data from Intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("TITLE");
            String author = intent.getStringExtra("AUTHOR");
            String genre = intent.getStringExtra("GENRE");
            String description = intent.getStringExtra("DESCRIPTION");
            int imageResId = intent.getIntExtra("IMAGE", R.drawable.book1_the_last_ember);

            // Set data to views
            if (tvTitle != null) tvTitle.setText(title != null ? title : "Unknown Title");
            if (tvAuthor != null) tvAuthor.setText("By " + (author != null ? author : "Unknown Author"));
            if (tvGenre != null) tvGenre.setText(genre != null ? genre : "General");
            if (imgCover != null) imgCover.setImageResource(imageResId);
            
            // Fix for missing description: ensure it's not null or empty
            if (tvDescription != null) {
                if (description != null && !description.isEmpty()) {
                    tvDescription.setText(description);
                } else {
                    tvDescription.setText("No description available for this book.");
                }
            }
            
            // Share button logic
            if (btnShare != null) {
                btnShare.setOnClickListener(v -> {
                    String shareText = "Check out \"" + title + "\" by " + author + "!";
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    startActivity(Intent.createChooser(shareIntent, "Share via"));
                });
            }
        }

        // Back button logic
        if (btnBack != null) btnBack.setOnClickListener(v -> finish());
        if (btnBackBottom != null) btnBackBottom.setOnClickListener(v -> finish());
    }
}