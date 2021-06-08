package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.JobPositionService;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.Hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public Result add(JobPosition jobPosition) {
        Result result = new ErrorResult("İş Pozisyonu Ekleme İşlemi Başarısızdır.!");
        if (positionIsItUsed(jobPosition.getName())) {
            this.jobPositionDao.save(jobPosition);
            result = new SuccessResult("İş Pozisyonu Ekleme İşlemi Başarılıdır.!");
        }
        return result;
    }

    public boolean positionIsItUsed(String positionName) {
        boolean result = true;
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getName() == positionName) {
                result = false;
            }
        }
        return result;
    }

}
