import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ua.ucu.edu.apps.task1.Gender;
import ua.ucu.edu.apps.task1.Student;
import ua.ucu.edu.apps.task1.User;
import ua.ucu.edu.apps.task3.MyImage;
import ua.ucu.edu.apps.task3.ProxyImage;

import java.util.Arrays;

public class Lab11Test {
    
    @Test
    void testTask1() {
		Student student = Student.builder()
                        .name("Killua")
                        .gender(Gender.MALE)
                        .mark(33)
                        .grades(Arrays.asList(21, 21, 22))
                        .age(11)
                        .build();
        assertEquals(student.getName(), "Killua");
        assertTrue(student instanceof User);
        student.clearGrades();
        assertTrue(student.grades.isEmpty());
    }
    
    @Test
    void testTask3() {
		ProxyImage myImage = new ProxyImage("src/main/java/ua/ucu/edu/apps/task3/japan_fuji.jpg");
        assertEquals(myImage.getRealImage(), null);
        assertTrue(myImage instanceof MyImage);
    }

}
