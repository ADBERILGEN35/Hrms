package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.*;
import kodlamaio.Hrms.core.utilities.results.*;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.dtos.CandidateForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private NationalValidationService nationalValidationService;
    private UserService userService;
    private ActivationCodeService activationCodeService;
    private EmailService emailService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, NationalValidationService nationalValidationService, UserService userService, ActivationCodeService activationCodeService, EmailService emailService) {
        this.candidateDao = candidateDao;
        this.nationalValidationService = nationalValidationService;
        this.userService = userService;
        this.activationCodeService = activationCodeService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi");
    }

    @Override
    public DataResult<Candidate> getByNationalNumber(String nationalNumber) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalNumber(nationalNumber), "Listelendi");
    }

    @Override
    public DataResult<Candidate> getByEmail(String email) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email), "Listelendi");
    }

    @Override
    public Result add(CandidateForRegisterDto candidateDto) {
        if (!candidateDto.getPassword().equals(candidateDto.getRePassword())) {
            return new ErrorResult("Şifreler eşleşmiyor");
        }
        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateDto.getFirstName());
        candidate.setLastName(candidateDto.getLastName());
        candidate.setNationalNumber(candidateDto.getNationalNumber());
        candidate.setDateOfBirth(candidateDto.getBirthDate());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setPassword(candidateDto.getPassword());

        if (candidate.getPassword().length() <= 6) {
            return new ErrorResult("Şifre 6 karakterden uzun olmalıdır");
        } else if (!isEmailValid(candidate.getEmail())) {
            return new ErrorResult("Email geçerli formatta değil");
        } else if (getByNationalNumber(candidate.getNationalNumber()).getData() != null) {
            return new ErrorResult("Bu kimlik numarası zaten kayıtlı");
        } else if (userService.getByEmail(candidate.getEmail()).getData() != null) {
            return new ErrorResult("Bu email zaten kayıtlı");
        } else if (nationalValidationService.validate(candidate)) {
            candidate.setMailVerify(false);
            this.candidateDao.save(candidate);
            this.emailService.sendVerifyEmail(candidate, this.activationCodeService.createActivationCode(candidate));
            return new SuccessResult(candidate.getEmail() + " Adresine doğrulama kodu gönderildi");
        } else {
            return new ErrorResult("Kullanıcı kimlik bilgileri hatalı");
        }


    }

    private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }
}
