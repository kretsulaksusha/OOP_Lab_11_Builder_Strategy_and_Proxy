package ua.ucu.edu.apps.task1;

import java.util.ArrayList;
import java.util.List;

import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder @ToString(callSuper = true)
public class Student extends User {
    @Singular("mark")
    public List<Integer> grades;

    public void clearGrades() {
        this.grades = new ArrayList<Integer>();
    }
}
