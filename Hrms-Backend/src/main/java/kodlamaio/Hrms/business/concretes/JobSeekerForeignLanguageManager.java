package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.JobSeekerForeignLanguageService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobSeekerForeignLanguageDao;
import kodlamaio.Hrms.entities.concretes.JobSeekerForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerForeignLanguageManager implements JobSeekerForeignLanguageService {

    private JobSeekerForeignLanguageDao jobSeekerForeignLanguageDao;

    @Autowired
    public JobSeekerForeignLanguageManager(JobSeekerForeignLanguageDao jobSeekerForeignLanguageDao) {
        super();
        this.jobSeekerForeignLanguageDao = jobSeekerForeignLanguageDao;
    }

    @Override
    public Result add(JobSeekerForeignLanguage jobSeekerForeignLanguage) {
        jobSeekerForeignLanguageDao.save(jobSeekerForeignLanguage);
        return new SuccessResult("Yabancı Dil Eklenmiştir.");
    }

}