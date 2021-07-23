package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.NationalValidationService;
import kodlamaio.Hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MernisManager implements NationalValidationService {


    @Override
    public boolean validate(Candidate candidate) {
        if(candidate.getNationalNumber().length()!=11){
            return false;
        }
        return true;
    }
}
