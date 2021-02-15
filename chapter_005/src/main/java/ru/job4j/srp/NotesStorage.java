package ru.job4j.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NotesStorage {
    List<String> notes = new ArrayList<>();

    void addNote(String n) {
        notes.add(n);
    }

    public List<String> getNotes() {
        return notes;
    }

    public String getInAnotherLanguage(int idx, Locale l) {
        Translator t = new Translator();
        return t.translate(notes.get(idx), l);
    }
}
