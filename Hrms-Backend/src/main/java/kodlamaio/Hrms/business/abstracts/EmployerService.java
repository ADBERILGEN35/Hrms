package kodlamaio.Hrms.business.abstracts;


import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.EmployerUpdate;
import kodlamaio.Hrms.entities.dtos.EmployerForRegisterDto;

import java.util.List;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();

    DataResult<Employer> getByEmail(String email);

    Result add(EmployerForRegisterDto employerDto);

    DataResult<Employer> getById(int id);

    Result update(EmployerUpdate employerUpdate);

    Result verifyUpdate(int employerUpdateId, int staffId);

}
