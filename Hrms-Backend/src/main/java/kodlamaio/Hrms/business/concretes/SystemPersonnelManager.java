package kodlamaio.Hrms.business.concretes;

import java.util.List;

import kodlamaio.Hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.SystemPersonnelDao;
import kodlamaio.Hrms.entities.concretes.SystemPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SystemPersonnelManager implements SystemPersonnelService {

    private SystemPersonnelDao systemPersonnelDao;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
        super();
        this.systemPersonnelDao = systemPersonnelDao;
    }

    @Override
    public DataResult<List<SystemPersonnel>> getAll() {
        return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(), "Çalışan Bilgileri Listelenmiştir.");
    }

    @Override
    public Result register(SystemPersonnel systemPersonnel) {
        this.systemPersonnelDao.save(systemPersonnel);
        return new SuccessResult("Personel Eklenmiştir.");
    }

}
