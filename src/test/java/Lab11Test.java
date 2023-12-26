import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ua.ucu.edu.apps.task1.Gender;
import ua.ucu.edu.apps.task1.Student;
import ua.ucu.edu.apps.task1.User;
import ua.ucu.edu.apps.task2.Client;
import ua.ucu.edu.apps.task2.MailBox;
import ua.ucu.edu.apps.task2.MailInfo;
import ua.ucu.edu.apps.task2.MailStrategies.BirthdayCode;
import ua.ucu.edu.apps.task2.MailStrategies.GiftCode;
import ua.ucu.edu.apps.task2.MailStrategies.NewsletterCode;
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
    void testTask2() {
		MailBox mailBox = new MailBox("kretsula.pn@ucu.edu.ua", "Ksusha");

        Client client1 = new Client("Killua", 11, "kretsula.pn@ucu.edu.ua",
                                    ua.ucu.edu.apps.task2.Gender.MALE);
        Client client2 = new Client("Gon", 11, "kretsula.pn@ucu.edu.ua",
                                    ua.ucu.edu.apps.task2.Gender.MALE);

        MailInfo mailInfoclient1 = new MailInfo(client1, new NewsletterCode("New updates!", "- Exclusive Hunter Tips: ...\nGear Reviews: ..."));
        MailInfo mailInfo1client2 = new MailInfo(client2, new BirthdayCode("Happy Birthday!"));
        MailInfo mailInfo2client2 = new MailInfo(client2, new GiftCode("New gifts for you!",
            "- Adventure Gear Package: Receive high-quality gear for your next exciting adventure.\n" +
            "- Auction House Invitation: Entry to a secret auction house where Hunters trade rare artifacts, magical items, and unique Hunter tools.\n" +
            "- Eclusive Training Session: A unique opportunity for personalized growth."));

        mailBox.addMailInfo(mailInfoclient1);
        mailBox.addMailInfo(mailInfo1client2);
        mailBox.addMailInfo(mailInfo2client2);

        assertEquals(client1.getId(), 0);
        assertEquals(client2.getId(), 1);

        assertEquals(mailBox.getMailInfos().size(), 3);
    }

    @Test
    void testTask3() {
		ProxyImage myImage = new ProxyImage("src/main/java/ua/ucu/edu/apps/task3/japan_fuji.jpg");
        assertEquals(myImage.getRealImage(), null);
        assertTrue(myImage instanceof MyImage);
    }

}
