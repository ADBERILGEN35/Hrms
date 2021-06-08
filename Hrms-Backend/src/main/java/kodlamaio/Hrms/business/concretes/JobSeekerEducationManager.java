package kodlamaio.Hrms.business.concretes;

import java.util.List;

import kodlamaio.Hrms.business.abstracts.JobSeekerEducationService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobSeekerEducationDao;
import kodlamaio.Hrms.entities.concretes.JobSeekerEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {

    private JobSeekerEducationDao jobSeekerEducationDao;

    @Autowired
    public JobSeekerEducationManager(JobSeekerEducationDao jobSeekerEducationDao) {
        super();
        this.jobSeekerEducationDao = jobSeekerEducationDao;
    }

    @Override
    public Result add(JobSeekerEducation jobSeekerEducation) {
        jobSeekerEducationDao.save(jobSeekerEducation);
        return new SuccessResult("Eğitim Eklenmiştir.");
    }

    @Override
    public DataResult<List<JobSeekerEducation>> getByDateOfGraduationSorted(int jobSeekerId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        return new SuccessDataResult<List<JobSeekerEducation>>(
                jobSeekerEducationDao.getByCurriculumVitae_JobSeeker_id(jobSeekerId, sort));
    }

}