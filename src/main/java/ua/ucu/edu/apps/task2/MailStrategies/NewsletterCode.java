package ua.ucu.edu.apps.task2.MailStrategies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.ucu.edu.apps.task2.Client;

@AllArgsConstructor @Getter
public class NewsletterCode implements MailCode {
    private String subject;
    private String news;

    @Override
    public String generateText(Client client) {
        return "Dear " + client.getName() + ",\n\n" +
                "We are excited to introduce our latest updates!\n\n" +
                "Hunter's Newsletter Highlights:\n" +
                news +
                "\n\nHappy exploring!\n\n" +
                "Best wishes,\n" +
                "Hunter x Hunter";
    }
    
}
