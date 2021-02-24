package ru.job4j.dip.examples.university;

public class UniversityNonDip {
    private Student enroll(String type) {
        return switch (type) {
            case "cleaver" -> new CleverGuy();
            case "smart" -> new SmartGuy();
            default -> null;
        };
    }

    public Student teachEngineer(String who) {
        Student s = this.enroll(who);
        for (int i = 0; i < 100; i++) {
            s.takeCourse();
        }
        return s;
    }

    public Student teachProfessor(String who) {
        Student s = this.enroll(who);
        for (int i = 0; i < 100; i++) {
            s.readBook();
        }
        return s;
    }
}
