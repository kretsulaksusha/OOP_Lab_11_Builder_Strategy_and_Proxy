package ua.ucu.edu.apps.task2;

import lombok.Getter;
import lombok.Setter;
import ua.ucu.edu.apps.task2.MailStrategies.MailCode;

@Getter @Setter
public class MailInfo {
    private Client client;
    private MailCode mailCode;

    public MailInfo(Client client, MailCode mailCode) {
        this.client = client;
        this.mailCode = mailCode;
    }

    public String generateText() {
        return mailCode.generateText(client);
    }
}
