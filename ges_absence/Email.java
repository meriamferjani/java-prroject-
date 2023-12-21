package ges_absence;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	 public void Send(String source, String destination, String corps) {
		    try {
		      String smtpServeur = "smtp.topnet.tn";
		      String obj = "MESSAGE D'ALERT POUR LE NOMBRE D'ABSENCES";
		      Properties pr = System.getProperties();
		      pr.put("mail.smtp.host", smtpServeur);
		      
		      Session s = Session.getDefaultInstance(pr);
		      
		      MimeMessage mimeMessage = new MimeMessage(s);
		      
		      mimeMessage.setFrom((Address)new InternetAddress(source));
		      mimeMessage.setRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse(destination, false));
		      
		      mimeMessage.setSubject(obj);
		      mimeMessage.setText(corps);
		      
		      Transport.send((Message)mimeMessage);
		      System.out.println(" envoi reussi");
		    } catch (MessagingException ex) {
		      System.out.println("probleme dans les adresse" + ex.getMessage());
		    } 
		  }
		  
		  public static void main(String[] args) {
		    Email email = new Email();
		    String src = "meriemferjani0@gmail.com";
		    String dest = "meriemferjani0@gmail.com";
		    String obj = "alert!";
		    String corps = "hello Etudiant";
		    email.Send(src, dest, corps);
		  }

}
