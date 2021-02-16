package ru.job4j.ocp;

public class TextEditor {
    public String edit(String cmd, String s1, String s2) {
        switch (cmd) {
            case "copy" :
                return s1;
            case "concat_end" :
                return s1 + s2;
            case "concat_beginning" :
                return s2 + s1;
            default:
                throw new IllegalStateException("Unexpected value: " + cmd);
        }
    }
}
