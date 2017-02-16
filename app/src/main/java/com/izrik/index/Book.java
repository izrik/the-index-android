package com.izrik.index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {

    public Book(String name, String title, String shortName, Chapter... chapters) {
        _chapters = new ArrayList<Chapter>();
        this.setName(name);
        this.setTitle(title);
        this.setShortName(shortName);
        if (chapters != null) {
            Collections.addAll(this.getChapters(), chapters);
        }
    }

    private List<Chapter> _chapters;

    public List<Chapter> getChapters() {
        return _chapters;
    }

    private String _name;

    public String getName() {
        return _name;
    }

    public void setName(String value) {
        _name = value;
    }

    private String _title;

    public String getTitle() {
        return _title;
    }

    public void setTitle(String value) {
        _title = value;
    }

    private String _shortName;

    public String getShortName() {
        return _shortName;
    }

    public void setShortName(String value) {
        _shortName = value;
    }

//    private String _text;
//
//    public String getText() {
//        return _text;
//    }
//
//    public void setText(String value) {
//        _text = value;
//    }


//    private List<String> _paragraphs = new ArrayList<String>();
//
//    public List<String> getParagraphs() {
//        return _paragraphs;
//    }
//
//    private List<Word> _words = new ArrayList<Word>();
//
//    public List<Word> getWords() {
//        return _words;
//    }

    @Override
    public String toString() {
        return getName();
    }
}