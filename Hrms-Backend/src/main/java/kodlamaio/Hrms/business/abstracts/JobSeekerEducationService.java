package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobSeekerEducation;

import java.util.List;

public interface JobSeekerEducationService {

    Result add(JobSeekerEducation jobSeekerEducation);

    DataResult<List<JobSeekerEducation>> getByDateOfGraduationSorted(int jobSeekerId);

}