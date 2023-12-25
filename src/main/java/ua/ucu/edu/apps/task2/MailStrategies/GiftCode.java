package ua.ucu.edu.apps.task2.MailStrategies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.ucu.edu.apps.task2.Client;

@AllArgsConstructor @Getter
public class GiftCode implements MailCode {
    private String subject;
    private String gifts;

    @Override
    public String generateText(Client client) {
        return "Dear " + client.getName() + ",\n\n" +
                "To celebrate our incredible partnership, we have a special gift for you! 🎁 " +
                "Choose from different options made just for you.\n\n" +
                gifts + "\n\n" +
                "Best wishes,\n" +
                "Hunter x Hunter";
    }
    
}
