package ua.ucu.edu.apps.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = Student.builder()
                        .name("Killua")
                        .gender(Gender.MALE)
                        .mark(33)
                        .grades(Arrays.asList(21, 21, 22))
                        .age(11)
                        .build();
        System.out.println(user);
    }
}
