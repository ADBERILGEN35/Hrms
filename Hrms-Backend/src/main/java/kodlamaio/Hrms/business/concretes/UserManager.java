package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.UserService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.dataAccess.abstracts.StaffDao;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.User;
import kodlamaio.Hrms.entities.dtos.UserLoginDto;
import kodlamaio.Hrms.entities.dtos.UserLoginReturnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private CandidateDao candidateDao;
    private EmployerDao employerDao;
    private StaffDao staffDao;

    @Autowired
    public UserManager(UserDao userDao, CandidateDao candidateDao, EmployerDao employerDao, StaffDao staffDao) {
        this.userDao = userDao;
        this.candidateDao = candidateDao;
        this.employerDao = employerDao;
        this.staffDao = staffDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Data listelendi");
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Listelendi");
    }

    @Override
    public DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto) {
        User user = this.userDao.findByEmail(userLoginDto.getEmail());
        if (user == null) {
            return new ErrorDataResult<UserLoginReturnDto>("Hatalı email girdiniz");
        } else if (!user.getPassword().equals(userLoginDto.getPassword())) {
            return new ErrorDataResult<UserLoginReturnDto>("Hatalı şifre girdiniz");
        }
        UserLoginReturnDto userLoginReturnDto = new UserLoginReturnDto();
        userLoginReturnDto.setId(user.getId());
        userLoginReturnDto.setEmail(user.getEmail());

        if (this.candidateDao.existsById(user.getId())) {
            userLoginReturnDto.setUserType(1);
            userLoginReturnDto.setName(this.candidateDao.findById(user.getId()).get().getFirstName() + " " + this.candidateDao.findById(user.getId()).get().getLastName());
        } else if (this.employerDao.existsById(user.getId())) {
            userLoginReturnDto.setUserType(2);
            userLoginReturnDto.setName(this.employerDao.findById(user.getId()).get().getCompanyName());
        } else if (this.staffDao.existsById(user.getId())) {
            userLoginReturnDto.setUserType(3);
            userLoginReturnDto.setName(this.staffDao.findById(user.getId()).get().getFirstName() + " " + this.staffDao.findById(user.getId()).get().getLastName());
        } else {
            return new ErrorDataResult<UserLoginReturnDto>("Bir hata oluştu");
        }

        return new SuccessDataResult<UserLoginReturnDto>(userLoginReturnDto, "Giriş yapıldı");
    }
}
