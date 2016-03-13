package dubinin.kickstarter.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by daniel on 3/8/16.
 */
@Component
@Scope("singleton")
public class MailService {

    @Autowired
    private MailSender mailSender;

    @Async
    public void send(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

}
