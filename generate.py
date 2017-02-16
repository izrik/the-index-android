#!/usr/bin/env python

import json

with open('books.json') as f:
    books = json.load(f)

print('package com.izrik.index.books;')
print('')
print('import com.izrik.index.Book;')
print('import com.izrik.index.Chapter;')
print('import com.izrik.index.Verse;')
print('')
print('public class Books {')
nb = len(books)
for ib, book in enumerate(books):
    title = book['Title']
    name = book['Name']
    short_name = book['ShortName']
    if short_name.startswith('1') or short_name.startswith('2') or short_name.startswith('3'):
        short_name = '_' + short_name
    print('    public static final Book {} = Generate{}();'.format(short_name, short_name))
    print('    static Book Generate{}() {{'.format(short_name))
    print('        return new Book("{}", "{}", "{}",'.format(name, title, short_name))
    nch = len(book['Chapters'])
    for ic, ch in enumerate(book['Chapters']):
        last_ch = '),'
        if ic == nch-1:
            last_ch = ')'
        print('            new Chapter("{}",'.format(ch['Title']))
        nv = len(ch['Verses'])
        for iv, v in enumerate(ch['Verses']):
            comma = ','
            if iv == nv-1:
                comma = ''
            print('                new Verse({}_Fields.{}_{}_{}){}'.format(
            short_name, short_name, ic+1, iv+1, comma))
        print('            {}'.format(last_ch))
    print('        );')
    print('    }')
print('    public static final Book[] AllBooks = {')
for ib, book in enumerate(books):
    last_b = ','
    if ib == nb-1:
        last_b = ''
    short_name = book['ShortName']
    if short_name.startswith('1') or short_name.startswith('2') or short_name.startswith('3'):
        short_name = '_' + short_name
    print('        {}{}'.format(short_name, last_b))
print('    };')
print('}')
print('')
