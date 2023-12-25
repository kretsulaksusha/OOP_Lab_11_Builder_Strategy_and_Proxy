package ua.ucu.edu.apps.task2.MailStrategies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.ucu.edu.apps.task2.Client;

@AllArgsConstructor @Getter
public class BirthdayCode implements MailCode {
    private String subject;

    @Override
    public String generateText(Client client) {
        return "Dear " + client.getName() + ",\n\n" +
                "Wishing you a fantastic birthday filled with joy and success! 🎈🥳 " +
                "Cheers to another year of collaboration and shared success!\n\n" +
                "Best wishes,\n" +
                "Hunter x Hunter";
    }
    
}
