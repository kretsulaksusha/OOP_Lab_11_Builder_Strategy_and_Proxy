package ua.ucu.edu.apps.task2;

import com.mailjet.client.errors.MailjetException;

import ua.ucu.edu.apps.task2.MailStrategies.BirthdayCode;
import ua.ucu.edu.apps.task2.MailStrategies.GiftCode;
import ua.ucu.edu.apps.task2.MailStrategies.NewsletterCode;

public class Main {
    public static void main(String[] args) throws MailjetException {
        MailBox mailBox = new MailBox("kretsula.pn@ucu.edu.ua", "Ksusha");

        Client client1 = new Client("Killua", 11, "kretsula.pn@ucu.edu.ua", Gender.MALE);
        Client client2 = new Client("Gon", 11, "kretsula.pn@ucu.edu.ua", Gender.MALE);

        MailInfo mailInfoclient1 = new MailInfo(client1, new NewsletterCode("New updates!", "- Exclusive Hunter Tips: ...\nGear Reviews: ..."));
        MailInfo mailInfo1client2 = new MailInfo(client2, new BirthdayCode("Happy Birthday!"));
        MailInfo mailInfo2client2 = new MailInfo(client2, new GiftCode("New gifts for you!",
            "- Adventure Gear Package: Receive high-quality gear for your next exciting adventure.\n" +
            "- Auction House Invitation: Entry to a secret auction house where Hunters trade rare artifacts, magical items, and unique Hunter tools.\n" +
            "- Eclusive Training Session: A unique opportunity for personalized growth."));

        mailBox.addMailInfo(mailInfoclient1);
        mailBox.addMailInfo(mailInfo1client2);
        mailBox.addMailInfo(mailInfo2client2);

        mailBox.sendAll();
    }
}
