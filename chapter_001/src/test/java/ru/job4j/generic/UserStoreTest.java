package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    @Test
    public void whenFindById() {
        User u = new User("Vasya");
        UserStore mem = new UserStore();
        mem.add(u);
        assertThat(mem.findById("Vasya"), is(u));
    }

    @Test
    public void whenReplace() {
        User old = new User("old");
        User newer = new User("newer");
        UserStore mem = new UserStore();
        mem.add(old);
        assertTrue(mem.replace("old", newer));
        assertThat(mem.findById("newer"), is(newer));
        assertNull(mem.findById("old"));
    }

    @Test
    public void whenReplaceNotExisted() {
        User old = new User("old");
        User newer = new User("newer");
        UserStore mem = new UserStore();
        mem.add(old);
        assertFalse(mem.replace("fake", newer));
    }

    @Test
    public void whenDelete() {
        User u = new User("Vasya");
        UserStore mem = new UserStore();
        mem.add(u);
        assertTrue(mem.delete("Vasya"));
        assertNull(mem.findById("Vasya"));
    }

    @Test
    public void whenDeleteNotExisted() {
        User old = new User("old");
        UserStore mem = new UserStore();
        mem.add(old);
        assertFalse(mem.delete("fake"));
    }
}