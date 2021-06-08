package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.JobSeekerExperienceService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobSeekerExperienceDao;
import kodlamaio.Hrms.entities.concretes.JobSeekerExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Sort;


import java.util.List;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {

    private JobSeekerExperienceDao jobSeekerExperienceDao;

    @Autowired
    public JobSeekerExperienceManager(JobSeekerExperienceDao jobSeekerExperienceDao) {
        super();
        this.jobSeekerExperienceDao = jobSeekerExperienceDao;
    }

    @Override
    public Result add(JobSeekerExperience jobSeekerExperience) {
        jobSeekerExperienceDao.save(jobSeekerExperience);
        return new SuccessResult("Deneyim Eklenmiştir.");
    }

    @Override
    public DataResult<List<JobSeekerExperience>> getByDateOfFinishSorted(int jobSeekerId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        return new SuccessDataResult<List<JobSeekerExperience>>(
                jobSeekerExperienceDao.getByCurriculumVitae_JobSeeker_id(jobSeekerId, sort));
    }

}