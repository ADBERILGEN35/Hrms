package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import kodlamaio.Hrms.entities.concretes.JobSeekerExperience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {

    List<JobSeekerExperience> getByCurriculumVitae_JobSeeker_id(int id);

    List<JobSeekerExperience> getByCurriculumVitae_JobSeeker_id(int id, Sort sort);

}