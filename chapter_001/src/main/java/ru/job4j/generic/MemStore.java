package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    private int getIndex(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndex(id);
        if (index < 0) {
            return false;
        }
        mem.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndex(id);
        if (index < 0) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        for (T item: mem) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
