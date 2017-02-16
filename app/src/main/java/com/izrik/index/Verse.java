package com.izrik.index;

public class Verse {

    public Verse() {
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

    public static Reference ToReference(Verse verse) {
        return verse.ToReference();
    }

    public Reference ToReference() {
        return new Reference(getChapter() != null ? getChapter().getBook() : null, getChapter(), this);
    }

    private Chapter chapter;

    public Chapter getChapter() {
        return this.chapter;
    }

    public void setChapter(Chapter value) {
        this.chapter = value;
    }

    public int getVerseIndex() {
        if (getChapter() == null) throw new IllegalArgumentException("Chapter cannot be null");
        if (!getChapter().getVerses().contains(this))
            throw new IllegalArgumentException("Chapter does not contain this verse");

        return getChapter().getVerses().indexOf(this);
    }

    @Override
    public String toString() {
        return getValue();
    }
}