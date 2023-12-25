package ua.ucu.edu.apps.task1;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder @ToString @Getter
public class User {
    private String name;
    private int age;
    private Gender gender;
    private double weight;
    private double height;
}