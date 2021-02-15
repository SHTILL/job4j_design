package ru.job4j.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CinemaTest {
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void getAllSessions() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D("Evening"));
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D("Evening"))));
    }

    @Test
    public void findByName() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D("Evening"));
        List<Session> sessions = cinema.find(session -> session.getName().equals("Evening"));
        assertThat(sessions, is(Arrays.asList(new Session3D("Evening"))));
    }

    @Test
    public void sessionIsNotFound() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D("Evening"));
        List<Session> sessions = cinema.find(session -> session.getName().equals("Morning"));
        assertTrue(sessions.isEmpty());
    }

    @Test
    public void sessionIsNotAdded() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> session.getName().equals("Morning"));
        assertTrue(sessions.isEmpty());
    }
}