package ru.job4j.ocp;

import java.util.List;

public class ProcessPersons {
    public void process(List<Person> persons) {
        for (Person p: persons) {
            if (p instanceof Teacher) {
                Teacher t = (Teacher) p;
                t.teach();
            }
            if (p instanceof Doctor)  {
                Doctor d = (Doctor) p;
                d.treat();
            }
        }
    }
}
