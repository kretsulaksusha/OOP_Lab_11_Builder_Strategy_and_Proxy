package ua.ucu.edu.apps.task2;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class MailSender {
    private String senderEmail;
    private String senderName;

    public void sendMail(MailInfo mailInfo) throws MailjetException {
      MailjetRequest request;
      MailjetResponse response;

      ClientOptions options = ClientOptions.builder()
            .apiKey("API_KEY")
            .apiSecretKey("API_SECRET_KEY")
            .build();
      
      MailjetClient client = new MailjetClient(options);

      request = new MailjetRequest(Emailv31.resource)
            .property(Emailv31.MESSAGES, new JSONArray()
                .put(new JSONObject()
                    .put(Emailv31.Message.FROM, new JSONObject()
                        .put("Email", senderEmail)
                        .put("Name", senderName))
                    .put(Emailv31.Message.TO, new JSONArray()
                        .put(new JSONObject()
                            .put("Email", mailInfo.getClient().getEmail())
                            .put("Name", mailInfo.getClient().getName())))
                    .put(Emailv31.Message.SUBJECT, mailInfo.getMailCode().getSubject())
                    .put(Emailv31.Message.TEXTPART, mailInfo.generateText())
                    .put(Emailv31.Message.HTMLPART, mailInfo.generateText())));
      response = client.post(request);
      System.out.println(response.getStatus());
      System.out.println(response.getData());
    }

}
