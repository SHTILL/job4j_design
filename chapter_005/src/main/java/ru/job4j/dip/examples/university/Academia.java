package ru.job4j.dip.examples.university;

public class Academia extends UniversityDip {
    @Override
    protected Student enroll() {
        return new CleverGuy();
    }
}
