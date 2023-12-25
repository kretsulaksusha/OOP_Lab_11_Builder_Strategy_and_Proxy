package ua.ucu.edu.apps.task2;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Client {
    private int id;
    public static int instanceCount;
    @Setter
    private String name;
    @Setter
    private int age;
    @Setter
    private String email;
    @Setter
    private Gender gender;

    public Client(String name, int age, String email, Gender gender) {
        this.id = instanceCount++;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }
}
