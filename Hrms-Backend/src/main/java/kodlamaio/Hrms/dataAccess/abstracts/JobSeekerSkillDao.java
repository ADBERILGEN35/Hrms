package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.concretes.JobSeekerSkill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerSkillDao extends JpaRepository<JobSeekerSkill, Integer> {

}