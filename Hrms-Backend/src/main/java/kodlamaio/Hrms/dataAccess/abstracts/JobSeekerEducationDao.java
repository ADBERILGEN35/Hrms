package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import kodlamaio.Hrms.entities.concretes.JobSeekerEducation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {

    List<JobSeekerEducation> getByCurriculumVitae_JobSeeker_id(int id);

    List<JobSeekerEducation> getByCurriculumVitae_JobSeeker_id(int id, Sort sort);

}
