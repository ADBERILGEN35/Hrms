package kodlamaio.Hrms.dataAccess.abstracts;

import kodlamaio.Hrms.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {

}