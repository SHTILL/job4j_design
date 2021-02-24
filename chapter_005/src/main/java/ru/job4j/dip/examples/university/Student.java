package ru.job4j.dip.examples.university;

public abstract class Student {
    protected int knowledgeLevel;
    protected int skillLevel;

    public abstract void takeCourse();
    public abstract void readBook();
}
