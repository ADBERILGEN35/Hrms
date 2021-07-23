package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.EmailService;
import kodlamaio.Hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {
    private JavaMailSenderImpl emailSender;

    public EmailManager() {
        emailSender = new JavaMailSenderImpl();
    }


    @Override
    public void sendVerifyEmail(User user, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("HRMS Mail Dogrulama");
        message.setText("Hrms kayıt işleminizi tamamlamak için linke tıklayınız: localhost:8080/api/activationcode/active/" + code);
        message.setTo(user.getEmail());
        message.setFrom("deneme@gmail.com");


        emailSender.send(message);

    }
}
