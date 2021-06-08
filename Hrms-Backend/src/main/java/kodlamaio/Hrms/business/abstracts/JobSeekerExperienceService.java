package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobSeekerExperience;

import java.util.List;

public interface JobSeekerExperienceService {

    Result add(JobSeekerExperience jobSeekerExperience);

    DataResult<List<JobSeekerExperience>> getByDateOfFinishSorted(int jobSeekerId);

}