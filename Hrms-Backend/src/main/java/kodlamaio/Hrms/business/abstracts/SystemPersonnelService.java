package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.SystemPersonnel;

import java.util.List;

public interface SystemPersonnelService {
    public DataResult<List<SystemPersonnel>> getAll();
    public Result register(SystemPersonnel systemPersonnel);
}
