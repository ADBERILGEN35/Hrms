package kodlamaio.Hrms.business.concretes;


import java.time.LocalDate;
import java.util.List;

import kodlamaio.Hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        super();
        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        curriculumVitae.setCreatedDate(LocalDate.now());
        curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult("CV Eklenmiştir.");
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<List<CurriculumVitae>>(curriculumVitaeDao.findAll(), "CV'ler listelendi");
    }

    @Override
    public DataResult<List<CurriculumVitae>> getByJobSeekerId(int id) {
        return new SuccessDataResult<List<CurriculumVitae>>(curriculumVitaeDao.getByJobSeeker_id(id),
                "Kullanıcıya Ait CV'ler Listelenmiştir.");
    }

}