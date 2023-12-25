package ua.ucu.edu.apps.task2.MailStrategies;

import ua.ucu.edu.apps.task2.Client;

public interface MailCode {
    String generateText(Client client);
    String getSubject();
}
