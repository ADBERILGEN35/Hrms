package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.DepartmentService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio.Hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        super();
        this.departmentDao = departmentDao;
    }

    @Override
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(), "Departman Bilgileri Listelenmiştir..");
    }

    @Override
    public Result add(Department department) {
        this.departmentDao.save(department);
        return new SuccessResult("Yeni Departman Eklenmiştir.");
    }

}
