package ua.ucu.edu.apps.task2;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.transactional.SendContact;
import com.mailjet.client.transactional.SendEmailsRequest;
import com.mailjet.client.transactional.TrackOpens;
import com.mailjet.client.transactional.TransactionalEmail;
import com.mailjet.client.transactional.response.SendEmailsResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class MailSender {
    private String senderEmail;
    private String senderName;

    public void sendMail(MailInfo mailInfo) throws MailjetException {
        ClientOptions options = ClientOptions.builder()
            .apiKey("API_KEY")
            .apiSecretKey("API_SECRET_KEY")
            .build();
        
        MailjetClient client = new MailjetClient(options);

        TransactionalEmail message = TransactionalEmail
            .builder()
            .to(new SendContact(mailInfo.getClient().getEmail(), mailInfo.getClient().getName()))
            .from(new SendContact(senderEmail, senderName))
            .htmlPart(mailInfo.generateText())
            .subject(mailInfo.getMailCode().getSubject())
            .trackOpens(TrackOpens.ENABLED)
            .build();

        SendEmailsRequest request = SendEmailsRequest
            .builder()
            .message(message)
            .build();

        try {
            SendEmailsResponse response = request.sendWith(client);
        } catch (Exception e) {
            e.notify();
        }
    }
}
