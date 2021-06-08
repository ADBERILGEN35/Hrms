package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.concretes.JobSeekerForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerForeignLanguageDao extends JpaRepository<JobSeekerForeignLanguage, Integer> {

}