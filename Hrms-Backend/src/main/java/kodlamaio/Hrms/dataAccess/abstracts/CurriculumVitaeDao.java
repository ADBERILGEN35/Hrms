package kodlamaio.Hrms.dataAccess.abstracts;


import java.util.List;

import kodlamaio.Hrms.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

    List<CurriculumVitae> getByJobSeeker_id(int id);

}