package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.JobSeekerSkillService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobSeekerSkillDao;
import kodlamaio.Hrms.entities.concretes.JobSeekerSkill;
import org.springframework.stereotype.Service;



@Service
public class JobSeekerSkillManager implements JobSeekerSkillService {

    private JobSeekerSkillDao jobSeekerSkillDao;

    public JobSeekerSkillManager(JobSeekerSkillDao jobSeekerSkillDao) {
        super();
        this.jobSeekerSkillDao = jobSeekerSkillDao;
    }

    @Override
    public Result add(JobSeekerSkill jobSeekerSkill) {
        jobSeekerSkillDao.save(jobSeekerSkill);
        return new SuccessResult("Yetenek Eklenmiştir.");
    }

}