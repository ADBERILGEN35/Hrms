package kodlamaio.Hrms.business.concretes;


import kodlamaio.Hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.Hrms.core.utilities.results.*;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertsDao;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertsDao jobAdvertsDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertsDao jobAdvertsDao) {
        this.jobAdvertsDao = jobAdvertsDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getJobAdvertisement() {
        if ((long) this.jobAdvertsDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "Başarılı : Tüm İş İlanları Listelenmiştir.");
        }
        return new WarningDataResult<>(this.jobAdvertsDao.findAll(), "Hata : Herhangi Bir İş İlanı Bulunamamıştır!");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveJobAdvertisement() {
        if ((long) this.jobAdvertsDao.findAllByIsActiveTrue().size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.findAllByIsActiveTrue(),
                    "Başarılı : Aktif Tüm İş İlanları Listelenmiştir.");
        }
        return new WarningDataResult<>(
                this.jobAdvertsDao.findAllByIsActiveTrue(),
                "Hata : Aktif Bir İş İlanı Bulunamamıştır!");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementForEmployer(String companyName) {
        if ((long) this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName).size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(
                    companyName), "Başarılı : Şirket'e Ait Tüm İlanlar Listelenmiştir.");
        }

        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName),
                "Hata : Şirket'e Ait Herhangi Bir İlan Bulunamamıştır!");

    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByIsActiveTrue() {
        Sort sort = Sort.by(Sort.Direction.DESC, "airdate");
        if ((long) this.jobAdvertsDao.findAllByIsActiveTrue(sort).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                    "Başarılı : Aktif Tüm İş İlanları Yayınlanma Tarihine Göre Listelenmiştir.");
        }
        return new WarningDataResult<>(
                this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                "Hata : Aktif Şş İlanı Bulunamamıştır!");
    }


    @Override
    public Result deactiveJobAdvertisement(int jobAdvertId) {
        this.jobAdvertsDao.deactiveJobAdvert(jobAdvertId);
        return new SuccessResult("Başarılı : İlan Başarıyla İnaktif Edilmiştir.");
    }

    @Override
    public Result addJobAdvert(JobAdvertisement jobAdvert) {
        this.jobAdvertsDao.save(jobAdvert);
        return new SuccessResult("Başarılı : İlan Sisteme Eklenmiştir.");
    }
}

