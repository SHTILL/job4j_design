package ru.job4j.dip.examples.university;

public class SmartGuy extends Student {
    @Override
    public void takeCourse() {
        this.skillLevel++;
    }

    @Override
    public void readBook() {
    }
}
