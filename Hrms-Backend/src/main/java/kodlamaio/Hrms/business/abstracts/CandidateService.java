package kodlamaio.Hrms.business.abstracts;


import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.dtos.CandidateForRegisterDto;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();

    DataResult<Candidate> getByNationalNumber(String nationalNumber);

    DataResult<Candidate> getByEmail(String email);

    Result add(CandidateForRegisterDto candidateForRegisterDto);
}
