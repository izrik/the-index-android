package com.izrik.index;

public class Verse {

    public Verse()
    {
        this("");
    }

    public Verse(String value) {
        setValue(value);
    }

    private Chapter _parentChapter = null;
    public Chapter getParentChapter() {
        return _parentChapter;
    }
    public void setParentChapter(Chapter value) {
        _parentChapter = value;
    }

    private String _value;
    public String getValue() {
        return _value;
    }
    public void setValue(String value) {
        this._value = value;
    }

//    public static Reference ToReference(Verse verse) {
//        return verse.ToReference();
//    }

//    public Reference ToReference() {
//        return new Reference(ParentChapter != null ? ParentChapter.ParentBook : null, ParentChapter, this);
//    }

    public int getVerseIndex(Chapter parentChapter) {
        if (parentChapter == null) throw new IllegalArgumentException("parentChapter cannot be null");
        if (!parentChapter.getVerses().contains(this)) throw new IllegalArgumentException("parentChapter does not contain this verse");

        return parentChapter.getVerses().indexOf(this);
    }
}