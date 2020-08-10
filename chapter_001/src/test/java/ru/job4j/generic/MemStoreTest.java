package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    @Test
    public void whenFindById() {
        User u = new User("Vasya");
        MemStore<User> mem = new MemStore<>();
        mem.add(u);
        assertThat(mem.findById("Vasya"), is(u));
    }

    @Test
    public void whenReplace() {
        User old = new User("old");
        User newer = new User("newer");
        MemStore<User> mem = new MemStore<>();
        mem.add(old);
        assertTrue(mem.replace("old", newer));
        assertThat(mem.findById("newer"), is(newer));
        assertNull(mem.findById("old"));
    }

    @Test
    public void whenReplaceNotExisted() {
        User old = new User("old");
        User newer = new User("newer");
        MemStore<User> mem = new MemStore<>();
        mem.add(old);
        assertFalse(mem.replace("fake", newer));
    }

    @Test
    public void whenDelete() {
        User u = new User("Vasya");
        MemStore<User> mem = new MemStore<>();
        mem.add(u);
        assertTrue(mem.delete("Vasya"));
        assertNull(mem.findById("Vasya"));
    }

    @Test
    public void whenDeleteNotExisted() {
        User old = new User("old");
        MemStore<User> mem = new MemStore<>();
        mem.add(old);
        assertFalse(mem.delete("fake"));
    }
}