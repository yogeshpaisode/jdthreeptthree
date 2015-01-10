package com.JD.Setting;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class SendAttachmentInEmail {

    public SendAttachmentInEmail(String sender, String password, String subject, String body, String filePath, String receiver) {
        // Recipient's email ID needs to be mentioned. sender, password, subject, body,filePath,receiver
        String to = receiver;
        // Sender's email ID needs to be mentioned
        String from = sender;
        final String username = sender;//change accordingly
        final String userPassword = password;//change accordingly
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, userPassword);
                    }
                });
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject(subject);
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Now set the actual message
            messageBodyPart.setText(body);
            // Create a multipar message
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = filePath;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            // Send the complete message parts
            message.setContent(multipart);
            // Send message
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "File Sent successfully....");
            com.JD.StaticData.Static_DATA.sendEmail_Form.reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Email Sending Fail,Please See Error Log Below");
            com.JD.StaticData.Static_DATA.error_TextPanel.setVisible(true);
        }
    }
}
