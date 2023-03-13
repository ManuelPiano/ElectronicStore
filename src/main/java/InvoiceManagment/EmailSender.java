package InvoiceManagment;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import peopleManagment.Client;

public class EmailSender {
  private static final String SMTP_SERVER = "smtp.gmail.com";
  private static final String USERNAME = "manuelalvarado3113@gmail.com";
  private static final String PASSWORD = "vescyoxsciolrhtc";

  public void sendEmail(Client client, Invoice invoice) {
    try {
      Properties props = new Properties();
      props.put("mail.smtp.host", SMTP_SERVER);
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");

      Authenticator auth =
          new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(USERNAME, PASSWORD);
            }
          };

      Session session = Session.getInstance(props, auth);

      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(USERNAME));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(client.getEmail()));
      message.setSubject("Here is your invoice");

      Multipart multipart = new MimeMultipart();

      MimeBodyPart attachmentPart = new MimeBodyPart();
      attachmentPart.attachFile(invoice.getFile());

      multipart.addBodyPart(attachmentPart);
      message.setContent(multipart);
      session.setDebug(true);
      Transport.send(message);

      System.out.println("Email sent successfully to " + client.getEmail());
    } catch (MessagingException | IOException e) {
      System.err.println("Failed to send email: " + e.getMessage());
      System.out.println(
          "Email not sent. There was a problem with the email server. Please try again later.");
    }
  }
}
