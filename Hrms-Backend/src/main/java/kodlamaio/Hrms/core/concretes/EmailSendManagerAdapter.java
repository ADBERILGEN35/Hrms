package kodlamaio.Hrms.core.concretes;

import kodlamaio.Hrms.core.abstracts.EmailSendService;
import kodlamaio.Hrms.emailService.EmailSendManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailSendManagerAdapter implements EmailSendService {

    private EmailSendManager emailSendManager;

    @Autowired
    public EmailSendManagerAdapter(EmailSendManager emailSendManager) {
        this.emailSendManager = emailSendManager;
    }

    @Override
    public void emailSend(String email) {
        emailSendManager.emailSending(email);
    }

}
