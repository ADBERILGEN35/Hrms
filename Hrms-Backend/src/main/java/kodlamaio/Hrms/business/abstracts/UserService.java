package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.entities.concretes.User;
import kodlamaio.Hrms.entities.dtos.UserLoginDto;
import kodlamaio.Hrms.entities.dtos.UserLoginReturnDto;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

    DataResult<User> getByEmail(String email);

    DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto);
}
