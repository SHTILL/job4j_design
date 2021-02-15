package ru.job4j.srp;

public class BookReader {
    private String book;
    private int position;

    public BookReader(String book) {
        this.book = book;
    }

    public String nextPage() {
        position += 50;
        return book.substring(position);
    }

    public String previousPage() {
        position -= 50;
        return book.substring(position);
    }

    public boolean findTheWord(String word) {
        String[] words = book.split("\\W+?");
        for (String w: words) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
