package ru.job4j.dip.examples.university;

public abstract class UniversityDip {
    public Student teachEngineer() {
        Student s = this.enroll();
        for (int i = 0; i < 100; i++) {
            s.takeCourse();
        }
        return s;
    }

    public Student teachProfessor() {
        Student s = this.enroll();
        for (int i = 0; i < 100; i++) {
            s.readBook();
        }
        return s;
    }

    protected abstract Student enroll();
}