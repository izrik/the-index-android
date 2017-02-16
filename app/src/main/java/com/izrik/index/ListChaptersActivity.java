package com.izrik.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.izrik.index.books.Books;

public class ListChaptersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chapters);


        Intent intent = getIntent();
        int bookIndex = 0;
        Book book = Books.Gen;
        if (intent != null) {
            bookIndex = intent.getIntExtra("bookIndex", 0);
            book = Books.AllBooks[bookIndex];
        }

        ArrayAdapter<Chapter> adapter = new ArrayAdapter<Chapter>(this, R.layout.chapter_list_entry, book.getChapters());
        GridView gridview = (GridView) findViewById(R.id.chapter_list);
        gridview.setAdapter(adapter);

        final int finalBookIndex = bookIndex;
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(getApplicationContext(), ReadChapterActivity.class);
                intent1.putExtra("bookIndex", finalBookIndex);
                intent1.putExtra("chapterIndex", position);
                startActivity(intent1);
            }
        });

    }
}
