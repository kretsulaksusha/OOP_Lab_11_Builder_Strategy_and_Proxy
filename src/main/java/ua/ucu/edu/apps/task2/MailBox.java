package ua.ucu.edu.apps.task2;

import java.util.List;

import com.mailjet.client.errors.MailjetException;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Getter
public class MailBox {
    // the place where all the information to be sent is stored
    private List<MailInfo> mailInfos = new ArrayList<MailInfo>();
    private String senderEmail;
    private String senderName;

    public MailBox(String senderEmail, String senderName) {
        this.senderEmail = senderEmail;
        this.senderName = senderName;
    }

    public void addMailInfo(MailInfo mailInfo) {
        mailInfos.add(mailInfo);
    }

    public void sendAll() {
        MailSender mailSender = new MailSender(senderEmail, senderName);
        for (MailInfo mailInfo : mailInfos) {
            try {
                mailSender.sendMail(mailInfo);
            } catch (MailjetException e) {
                e.printStackTrace();
            }
        }
        mailInfos.clear();
        System.out.println("The message was sent successfully!");
    }
}
