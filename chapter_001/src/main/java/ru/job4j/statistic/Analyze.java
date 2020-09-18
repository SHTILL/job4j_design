package ru.job4j.statistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyze {
    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();

        Map<Integer, String> prev = new HashMap<>();
        for (User u: previous) {
            prev.put(u.id, u.name);
        }
        for (User cur: current) {
            String prevName = prev.get(cur.id);
            if (prevName == null) {
                info.added++;
            } else {
                if (!cur.name.equals(prevName)) {
                    info.changed++;
                }
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
