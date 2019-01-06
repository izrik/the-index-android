package com.izrik.index;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.izrik.index.books.Books;

public class ListBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this, R.layout.book_list_entry, Books.AllBooks);
        ListView listView = (ListView)findViewById(R.id.book_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(getApplicationContext(), ListChaptersActivity.class);
                intent1.putExtra("bookIndex", position);
                startActivity(intent1);
            }
        });
    }
}
