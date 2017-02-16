package com.izrik.index;


public class Reference {
    public Reference(final Book book, final Chapter chapter, final Verse verse) {

        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        if (chapter == null && verse != null) {
            throw new IllegalArgumentException("verse must be null when chapter is null");
        }
        if (chapter != null && !book.getChapters().contains(chapter)) {
            throw new IllegalArgumentException("chapter not part of book");
        }
        if (verse != null && !chapter.getVerses().contains(verse)) {
            throw new IllegalArgumentException("verse not part of chapter");
        }

        Book = book;
        Chapter = chapter;
        Verse = verse;
    }

    public final Book Book;
    public final Chapter Chapter;
    public final Verse Verse;


    public String toString() {
        return
                (Book != null ? Book.getShortName() + " " : "") +
                        (Chapter != null ? Integer.toString(Chapter.getChapterIndex(Book) + 1) : "") +
                        (Chapter != null && Verse != null ? ":" : "") +
                        (Verse != null ? Integer.toString(Verse.getVerseIndex(Chapter) + 1) : "");
    }

}