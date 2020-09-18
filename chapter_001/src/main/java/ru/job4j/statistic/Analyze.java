package ru.job4j.statistic;

import java.util.List;

public class Analyze {
    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int unchanged = 0;
        boolean found = false;
        for (User cur: current) {
            found = false;
            for (User prev: previous) {
                if (cur.id == prev.id) {
                    if (!cur.name.equals(prev.name)) {
                        info.changed++;
                    } else {
                        unchanged++;
                    }
                    found = true;
                }
            }
            if (!found) {
                info.added++;
            }
        }

        info.deleted = (previous.size() - current.size()) + info.added;
        return info;
    }

    public static class User {
        int id;
        String name;
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
