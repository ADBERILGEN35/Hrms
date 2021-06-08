package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    public Result login(String email, String password);
    public Result register(Employer employer);

    public List<Employer> getAll();
    public List<String> getAllEmails();
}
