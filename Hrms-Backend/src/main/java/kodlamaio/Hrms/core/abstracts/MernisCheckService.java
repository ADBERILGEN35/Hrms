package kodlamaio.Hrms.core.abstracts;

import kodlamaio.Hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;


@Service
public interface MernisCheckService {
    public boolean checkIfRealPerson(JobSeeker jobSeeker);
}
