package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.ActivationCodeService;
import kodlamaio.Hrms.business.abstracts.CvService;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.ActivationCode;
import kodlamaio.Hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
public class ActivationCodeManager implements ActivationCodeService {

    private ActivationCodeDao activationCodeDao;
    private UserDao userDao;
    private CandidateDao candidateDao;
    private CvService cvService;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao, UserDao userDao, CandidateDao candidateDao, CvService cvService) {
        this.activationCodeDao = activationCodeDao;
        this.userDao = userDao;
        this.candidateDao = candidateDao;
        this.cvService = cvService;
    }

    @Override
    public ActivationCode getByCode(String code) {
        return this.activationCodeDao.findByCode(code);
    }

    String generatedCode = "";

    @Override
    public String createActivationCode(User user) {

        for (int i = 0; i == 0; i = 0) {
            generatedCode = rastgeleDegerSaglayici(16);

            if (getByCode(generatedCode) == null) {
                break;
            }
        }

        ActivationCode activationCode = new ActivationCode();
        activationCode.setUserId(user.getId());
        activationCode.setCode(generatedCode);

        activationCodeDao.save(activationCode);

        return generatedCode;
    }

    @Override
    public Result activateUser(String code) {

        if (activationCodeDao.findByCode(code) == null) {
            return new ErrorResult("Kod hatalı");
        }

        User user = userDao.findById(activationCodeDao.findByCode(code).getUserId()).orElseThrow();
        user.setMailVerify(true);
        userDao.save(user);

        ActivationCode activationCode = activationCodeDao.findByCode(code);
        activationCode.setVerifayed(true);
        activationCode.setVerifyDate(LocalDate.now());
        activationCodeDao.save(activationCode);

        if (candidateDao.existsById(user.getId())) {
            this.cvService.add(user.getId());
        }

        return new SuccessResult("Kullanıcı aktif edildi");
    }

    private final String nelerOlsun = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private SecureRandom karistirici = new SecureRandom();

    private String rastgeleDegerSaglayici(int uzunluk) {
        StringBuilder rastgeleDegerYapici = new StringBuilder(uzunluk);
        for (int i = 0; i < uzunluk; i++) {
            rastgeleDegerYapici.append(nelerOlsun.charAt(karistirici.nextInt(nelerOlsun.length())));
        }
        return rastgeleDegerYapici.toString();
    }


}
