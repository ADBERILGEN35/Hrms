package kodlamaio.Hrms.business.abstracts;


import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Experiance;
import kodlamaio.Hrms.entities.dtos.ExperianceForSetDto;

import java.util.List;

public interface ExperianceService {
    Result add(ExperianceForSetDto experianceForSetDto);

    Result delete(int experianceId);

    DataResult<List<Experiance>> getByCvId(int id);
}
