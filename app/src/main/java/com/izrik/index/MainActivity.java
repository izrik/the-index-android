package com.izrik.index;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.izrik.index.books.Books;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, R.layout.book_list_entry, Books.AllBooks);
        ListView listView = (ListView)findViewById(R.id.book_list);
        listView.setAdapter(adapter);
    }
}
