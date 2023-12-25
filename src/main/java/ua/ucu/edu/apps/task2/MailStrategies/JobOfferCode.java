package ua.ucu.edu.apps.task2.MailStrategies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.ucu.edu.apps.task2.Client;

@AllArgsConstructor @Getter
public class JobOfferCode implements MailCode {
    private String subject;
    private String job;

    @Override
    public String generateText(Client client) {
        return "Dear " + client.getName() + ",\n\n" +
                "We are thrilled to extend a unique job offer to both of you.\n\n" +
                "Job Opportunity: " + job + ".\n\n" +
                "Should you have any questions or require further details, do not hesitate to reach out.\n\n" +
                "Best wishes,\n" +
                "Hunter x Hunter";
    }
    
}
