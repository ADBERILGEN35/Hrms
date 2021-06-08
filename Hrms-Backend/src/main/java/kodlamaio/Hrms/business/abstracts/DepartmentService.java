package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Department;

import java.util.List;


public interface DepartmentService {
    public DataResult<List<Department>> getAll();
    public Result add(Department department);
}
