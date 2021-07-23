package kodlamaio.Hrms.business.abstracts;


import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();

    Result add(JobPosition jobPosition);

    DataResult<JobPosition> getByName(String name);
}
