package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReportEmployeesGeneratorTest {
    @Test
    public void whenGenerated() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        Generator g = new SimpleGenerator();
        assertThat(g.produce("\"I am a ${name}, Who are ${subject}? \"", args), is("I am a Petr Arsentev, Who are you? "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongArgs() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        Generator g = new SimpleGenerator();
        g.produce("\"I am a ${name}, Who are ${subject}? \"", args);
    }
}