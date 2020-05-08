import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class CarteiroEmail {
    
public static void EnviarEmail (String quemEnvia, String quemRecebe,String assunto,String mensagem) {
      String host = "localhost";

      Properties properties = System.getProperties();
        properties.setProperty("mail.user", "luisviniciuscostasilva@gmail.com");
         properties.setProperty("mail.password", "luisviniciuscostasilva@gmail.com");
      
         properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(quemRecebe));
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(quemEnvia));
         message.setSubject(assunto);
         message.setText(mensagem);
         Transport.send(message);
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }   
}
}