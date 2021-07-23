package kodlamaio.Hrms.business.abstracts;


import kodlamaio.Hrms.entities.concretes.Candidate;

public interface NationalValidationService {
    boolean validate(Candidate candidate);
}
