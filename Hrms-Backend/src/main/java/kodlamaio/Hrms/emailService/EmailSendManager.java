package kodlamaio.Hrms.emailService;

import org.springframework.stereotype.Service;

@Service
public class EmailSendManager {
    public void emailSending(String email) {
        System.out.println("Kayıt olduğunuz " + email + "' mail adresine doğrulama maili gönderilmiştir.");
    }
}
