package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
