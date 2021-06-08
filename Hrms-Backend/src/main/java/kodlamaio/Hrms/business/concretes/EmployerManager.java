package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.abstracts.EmailSendService;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailSendService emailSendService;
    private List<String> emails = new ArrayList<String>();

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailSendService emailSendService) {
        super();
        this.employerDao = employerDao;
        this.emailSendService = emailSendService;
    }

    @Override
    public Result login(String email, String password) {
        Result result = new ErrorResult("Giriş İşlemi Başarısızdır!");
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getEmail() == email && getAll().get(i).getPassword() == password) {
                result = new SuccessResult("Giriş İşlemi Başarılıdır!");
            }
        }
        return result;
    }

    @Override
    public Result register(Employer employer) {
        Result result = new ErrorResult("Kayıt Başarısızdır!");
        if (emailIsItUsed(employer.getEmail())) {
            emailSendService.emailSend(employer.getEmail());
            employer.setVerificationStatus(false); //default
            this.employerDao.save(employer);
            result = new SuccessResult("Kayıt Başarılıdır!");
        }
        return result;
    }

    @Override
    public List<Employer> getAll() {
        return this.employerDao.findAll();
    }

    @Override
    public List<String> getAllEmails() {
        for (int i = 0; i < getAll().size(); i++) {
            emails.add(getAll().get(i).getEmail());
        }
        return emails;
    }

    public boolean emailIsItUsed(String email) {
        boolean result = true;
        if (getAllEmails().contains(email)) {
            result = false;
        }
        return result;
    }

}

