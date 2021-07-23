package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.concretes.JobAdActivation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdActivationDao extends JpaRepository<JobAdActivation,Integer> {
}
