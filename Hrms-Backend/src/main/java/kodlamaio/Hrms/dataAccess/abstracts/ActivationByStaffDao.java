package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.concretes.ActivationByStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationByStaffDao extends JpaRepository<ActivationByStaff, Integer> {
    ActivationByStaff findByEmployeId(int id);

}
