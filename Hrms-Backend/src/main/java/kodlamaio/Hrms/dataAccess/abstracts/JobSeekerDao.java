package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
