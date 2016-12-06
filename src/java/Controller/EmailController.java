/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author it353f608
 */
public class EmailController {
    
    public EmailController() {
    }
    
    String recipient;
    String subject;
    String body;
    
    public EmailController(String recipient, String subject, String body)
    {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }
    
    public String emailWinner(String email,double prizeAmt){

        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "ahinh@ilstu.edu";
        
        // Assuming you are sending email from this host
        String host = "outlook.office365.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ahinh@ilstu.edu", "46mr4bpbdaY");
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Congratulations, you have won this week!");
            
            
            
            
            // Send the actual HTML message, as big as you like
            message.setContent("<h1>You have been chosen as the winner for this weeks selections.</h1>"
                    + "<p>We get thousands of submissions a day, this is no small feat be proud and please accept this small token of our appreciation.<br>"
                    + "Enjoy the amount of $"+String.format("%.2f", prizeAmt)+".</p>",
                    "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return "success";
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return "failure";
    }
    public void emailReceipt(String email,int[] media_id, double[] price){

        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "ahinh@ilstu.edu";
        
        // Assuming you are sending email from this host
        String host = "outlook.office365.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ahinh@ilstu.edu", "46mr4bpbdaY");
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Purchase Receipt - Payment Confirmation");
            
            String out = "Artwork purchased: <br><ul>";
            double totalCost = 0;
            for(int i = 0; i < media_id.length; i++)
            {
                out+="<li>" +media_id[i]+" " + price[i] + "</ul>";
                totalCost += price[i];
            }
            out+="</ul>";
            
            // Send the actual HTML message, as big as you like
            message.setContent("<h1>Thank you, "+email+" for supporting your local artists!.</h1>"
                    + "<p>"+out+"<br>"
                    + "Total cost: $"+String.format("%.2f", totalCost)+".</p>",
                    "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    public void emailRoyalty(String email,double amount){

        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "ahinh@ilstu.edu";
        
        // Assuming you are sending email from this host
        String host = "outlook.office365.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ahinh@ilstu.edu", "46mr4bpbdaY");
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Royalty Payment Received!");
            
            
            
            
            // Send the actual HTML message, as big as you like
            message.setContent("<h1>You have received payment for one of your artworks!</h1>"
                    + "<p>Enjoy the amount of $"+String.format("%.2f", amount)+".</p>",
                    "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
