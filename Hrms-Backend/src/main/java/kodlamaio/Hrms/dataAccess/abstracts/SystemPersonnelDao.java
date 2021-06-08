package kodlamaio.Hrms.dataAccess.abstracts;


import kodlamaio.Hrms.entities.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer> {

}
