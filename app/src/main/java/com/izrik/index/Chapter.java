package com.izrik.index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.R.attr.value;

public class Chapter {

    public Chapter(String title, Verse... verses) {
        _verses = new ArrayList<Verse>();
        this.setTitle(title);
        if (verses != null) {
            Collections.addAll(this.getVerses(), verses);
            for (Verse ch : this.getVerses()) {
                ch.setChapter(this);
            }
        }

    }

    public Reference GetReference() {
        return new Reference(getBook(), this, null);
    }

    private Book book;

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book value) {
        this.book = value;
    }

    private String _title;

    public String getTitle() {
        return _title;
    }

    public void setTitle(String value) {
        _title = value;
    }

    private List<Verse> _verses;

    public List<Verse> getVerses() {
        return _verses;
    }

    public int getChapterIndex() {
        if (getBook() == null) throw new IllegalArgumentException("parentBook cannot be null");
        if (!getBook().getChapters().contains(this))
            throw new IllegalArgumentException("parentBook does not contain this chapter");

        return getBook().getChapters().indexOf(this);
    }

    @Override
    public String toString() {
        return Integer.toString(getChapterIndex() + 1);
    }
}