package ru.job4j.dip.examples.university;

public class AppliedScienceUniversity extends UniversityDip {
    @Override
    protected Student enroll() {
        return new SmartGuy();
    }
}
