package com.izrik.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.izrik.index.books.Books;

public class ListChaptersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chapters);


        Intent intent = getIntent();
        Book book = Books.Gen;
        if (intent != null) {
            int bookIndex = intent.getIntExtra("bookIndex", 0);
            book = Books.AllBooks[bookIndex];
        }

        ArrayAdapter<Chapter> adapter = new ArrayAdapter<Chapter>(this, R.layout.chapter_list_entry, book.getChapters());
        GridView gridview = (GridView) findViewById(R.id.chapter_list);
        gridview.setAdapter(adapter);

    }
}
