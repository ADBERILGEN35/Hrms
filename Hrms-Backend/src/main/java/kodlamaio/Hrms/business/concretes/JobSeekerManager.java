package kodlamaio.Hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import kodlamaio.Hrms.business.abstracts.JobSeekerService;
import kodlamaio.Hrms.core.abstracts.EmailCheckService;
import kodlamaio.Hrms.core.abstracts.EmailSendService;
import kodlamaio.Hrms.core.abstracts.MernisCheckService;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.Hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private EmailCheckService emailCheckService;
    private EmailSendService emailSendService;
    private MernisCheckService mernisCheckService;
    private List<String> emails = new ArrayList<>();
    private List<String> identificationNumbers = new ArrayList<>();

    @Autowired
    public JobSeekerManager(EmailCheckService emailCheckService, JobSeekerDao jobSeekerDao, EmailSendService emailSendService, MernisCheckService mernisCheckService) {
        super();
        this.emailCheckService = emailCheckService;
        this.jobSeekerDao = jobSeekerDao;
        this.emailSendService = emailSendService;
        this.mernisCheckService = mernisCheckService;
    }

    @Override
    public Result login(String email, String password) {
        Result result = new ErrorResult("Giriş Başarısızdır!");
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getEmail() == email && getAll().get(i).getPassword() == password) {
                result = new SuccessResult("Giriş Başarılıdır!");
            }
        }
        return result;
    }

    @Override
    public Result register(JobSeeker jobSeeker) {
        Result result = new ErrorResult("Kayıt İşlemi Başarısızdır!");
        if (emailCheckService.emailCheck(jobSeeker.getEmail())
                && emailIsItUsed(jobSeeker.getEmail())
                && identificationNumberIsItUsed(jobSeeker.getIdentificationNumber())
                && mernisCheckService.checkIfRealPerson(jobSeeker)) {
            emailSendService.emailSend(jobSeeker.getEmail());
            this.jobSeekerDao.save(jobSeeker);
            result = new SuccessResult("Kayıt İşlemi Başarılıdır.");
        }
        return result;
    }

    @Override
    public List<JobSeeker> getAll() {
        return this.jobSeekerDao.findAll();
    }

    @Override
    public List<String> getAllEmails() {
        for (int i = 0; i < getAll().size(); i++) {
            emails.add(getAll().get(i).getEmail());
        }
        return emails;
    }

    @Override
    public List<String> getAllIdentificationNumber() {
        for (int i = 0; i < getAll().size(); i++) {
            identificationNumbers.add(getAll().get(i).getIdentificationNumber());
        }
        return identificationNumbers;
    }

    public boolean emailIsItUsed(String email) {
        boolean result = true;
        if (getAllEmails().contains(email)) {
            result = false;
        }
        return result;
    }

    public boolean identificationNumberIsItUsed(String identificationNumber) {
        boolean result = true;
        if (getAllIdentificationNumber().contains(identificationNumber)) {
            result = false;
        }
        return result;
    }

}
