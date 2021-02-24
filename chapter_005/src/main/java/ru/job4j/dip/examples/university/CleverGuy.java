package ru.job4j.dip.examples.university;

public class CleverGuy extends Student {
    @Override
    public void takeCourse() {
    }

    @Override
    public void readBook() {
        this.knowledgeLevel++;
    }
}
