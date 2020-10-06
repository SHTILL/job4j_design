package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgZipTest {
    @Test
    public void whenExample() {
        ArgZip args = new ArgZip(new String[] {"-d=c:\\project\\job4j\\", "-e=class", "-o=project.zip"});
        assertThat(args.directory(), is("c:\\project\\job4j\\"));
        assertThat(args.exclude(), is("class"));
        assertThat(args.output(), is("project.zip"));
    }
}