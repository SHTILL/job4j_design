package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        Config c = new Config("./data/pair_without_comment.properties");
        c.load();
        assertThat(
                c.value("name"),
                is("Petr")
        );
    }

    @Test
    public void whenMultiplePairs() {
        Config c = new Config("./data/pairs_multiple.properties");
        c.load();
        assertThat(
                c.value("name"),
                is("Petr")
        );
        assertThat(
                c.value("surname"),
                is("Arsentev")
        );
        assertThat(
                c.value("port"),
                is("8080")
        );
    }

    @Test
    public void whenPairComment() {
        Config c = new Config("./data/pair_with_comment.properties");
        c.load();
        assertNull(c.value("ip"));
    }

    @Test
    public void whenDoubleEqualSign() {
        Config c = new Config("./data/pair_double_equal_sign.properties");
        c.load();
        assertNull(c.value("port"));
    }
}