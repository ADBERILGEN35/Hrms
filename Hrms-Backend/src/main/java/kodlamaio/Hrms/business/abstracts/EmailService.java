package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.entities.concretes.User;

public interface EmailService {
    void sendVerifyEmail(User user, String code);
}
