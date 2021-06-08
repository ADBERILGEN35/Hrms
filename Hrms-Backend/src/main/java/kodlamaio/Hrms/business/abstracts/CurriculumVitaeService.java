package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

import java.util.List;

public interface CurriculumVitaeService {

    Result add(CurriculumVitae curriculumVitae);

    DataResult<List<CurriculumVitae>> getAll();

    DataResult<List<CurriculumVitae>> getByJobSeekerId(int id);

}