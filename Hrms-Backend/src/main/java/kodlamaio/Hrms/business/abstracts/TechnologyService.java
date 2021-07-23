package kodlamaio.Hrms.business.abstracts;


import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Technology;
import kodlamaio.Hrms.entities.dtos.TechnologyForSerDto;

import java.util.List;

public interface TechnologyService {
    public Result addTechnology(TechnologyForSerDto technologyForSerDto);
    public Result deleteTechnology(int technologyId);
    public DataResult<List<Technology>> getByCvId(int cvId);
}
