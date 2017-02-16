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
        }

    }

//    public Reference GetReference()
//    {
//        return new Reference(ParentBook, this, null);
//        //return (ParentBook != null ? ParentBook.ShortName : "") + " " + ChapterNumber.ToString();
//    }

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

    public int getChapterIndex(Book parentBook) {
        if (parentBook == null) throw new IllegalArgumentException("parentBook cannot be null");
        if (!parentBook.getChapters().contains(this)) throw new IllegalArgumentException("parentBook does not contain this chapter");

        return parentBook.getChapters().indexOf(this);
    }
}