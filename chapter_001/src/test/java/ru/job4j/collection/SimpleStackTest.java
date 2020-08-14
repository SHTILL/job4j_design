package ru.job4j.collection;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    @Test
    public void whenPushThenPop() {
        SimpleStack<Character> s = new SimpleStack<>();
        s.push('1');
        assertThat(s.pop(), is('1'));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPopNotExisted() {
        SimpleStack<Character> s = new SimpleStack<>();
        s.push('1');
        s.push('2');
        s.pop();
        s.pop();
        s.pop();
    }

    @Test
    public void whenPushPopThenPushPop() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.pop(), is(1));
        stack.push(2);
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushPushThenPopPop() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }
}