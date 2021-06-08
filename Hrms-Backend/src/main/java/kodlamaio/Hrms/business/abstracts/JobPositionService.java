package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobPosition;

import java.util.List;


public interface JobPositionService {
    public List<JobPosition> getAll();
    public Result add(JobPosition jobPosition);
}
