package kodlamaio.Hrms.core.concretes;

import kodlamaio.Hrms.core.abstracts.MernisCheckService;
import kodlamaio.Hrms.entities.concretes.JobSeeker;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Component
public class FakeMernisCheckService implements MernisCheckService {

    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) {
        return true;
    }

}

