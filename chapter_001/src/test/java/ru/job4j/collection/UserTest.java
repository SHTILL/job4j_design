package ru.job4j.collection;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenEqualsAndHashCodeAreNotOverrided() {
        Map<User, String> m = new HashMap<>();
        Calendar c = Calendar.getInstance();

        c.set(Calendar.DAY_OF_MONTH, 28);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.YEAR, 1986);

        User u1 = new User("Vasya", 2, c);
        User u2 = new User("Vasya", 2, c);
        m.put(u1, "u1");
        m.put(u2, "u2");
        System.out.print(m);
    }
}