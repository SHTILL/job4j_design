package ru.job4j.io;

public class SearchFactory {
    public static SearchMethod getSearch(String type, String searchString) {
        SearchMethod m = null;
        switch (type) {
            case "reg":
                m = new SearchRegExp(searchString);
                break;
            case "mask":
                m = new SearchExtension(searchString);
                break;
            case "name":
                m = new SearchFileName(searchString);
            default:
                break;
        }
        return m;
    }
}
