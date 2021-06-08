package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobSeeker;

import java.util.List;


public interface JobSeekerService {
    public Result login(String email, String password);
    public Result register(JobSeeker jobSeeker);

    public List<JobSeeker> getAll();
    public List<String> getAllEmails();
    public List<String> getAllIdentificationNumber();
}
