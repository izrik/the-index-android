package com.izrik.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.izrik.index.books.Books;

public class ReadChapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_chapter);

        Intent intent = getIntent();
        Book book = Books.Gen;
        Chapter chapter = book.getChapters().get(0);
        if (intent != null) {
            int bookIndex = intent.getIntExtra("bookIndex", 0);
            book = Books.AllBooks[bookIndex];
            int chapterIndex = intent.getIntExtra("chapterIndex", 0);
            chapter = book.getChapters().get(chapterIndex);
        }

        ArrayAdapter<Verse> adapter = new ArrayAdapter<Verse>(this, R.layout.verse_list_entry, R.id.verse_content, chapter.getVerses());
        ListView listView = (ListView)findViewById(R.id.verse_list);
        listView.setAdapter(adapter);
    }
}
