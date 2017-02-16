package com.izrik.index;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        ArrayAdapter<Verse> adapter = new VerseArrayAdapter(this, R.layout.verse_list_entry, chapter);
        ListView listView = (ListView)findViewById(R.id.verse_list);
        listView.setAdapter(adapter);
    }

    class VerseArrayAdapter extends ArrayAdapter<Verse> {
        public VerseArrayAdapter(@NonNull Context context, @LayoutRes int resource, Chapter chapter) {
            super(context, resource, R.id.verse_content, chapter.getVerses());
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            TextView verseNumberView = (TextView)view.findViewById(R.id.verse_number);
            verseNumberView.setText(Integer.toString(getItem(position).getVerseIndex()+1));
            return view;
        }
    }
}
