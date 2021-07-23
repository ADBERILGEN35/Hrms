package kodlamaio.Hrms.business.concretes;

import kodlamaio.Hrms.business.abstracts.JobAdFavoritesService;
import kodlamaio.Hrms.core.utilities.results.*;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdDao;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdFavoritesDao;
import kodlamaio.Hrms.entities.concretes.JobAdFavorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdFavoritesManager implements JobAdFavoritesService {

    private JobAdFavoritesDao jobAdFavoritesDao;
    private CandidateDao candidateDao;
    private JobAdDao jobAdDao;

    @Autowired
    public JobAdFavoritesManager(JobAdFavoritesDao jobAdFavoritesDao, CandidateDao candidateDao, JobAdDao jobAdDao) {
        this.jobAdFavoritesDao = jobAdFavoritesDao;
        this.candidateDao = candidateDao;
        this.jobAdDao = jobAdDao;
    }

    @Override
    public DataResult<List<JobAdFavorites>> getByCandidateId(int candidateId) {
        if (!this.candidateDao.existsById(candidateId)) {
            return new ErrorDataResult<List<JobAdFavorites>>("Böyle bir kullanıcı yok");
        }
        return new SuccessDataResult<List<JobAdFavorites>>(this.jobAdFavoritesDao.findByCandidateId(candidateId), "Data listelendi");
    }

    @Override
    public Result addFavorite(int candidateId, int jobAdId) {

        if (!this.candidateDao.existsById(candidateId)) {
            return new ErrorResult("Böyle bir kullanıcı yok");
        } else if (!this.jobAdDao.existsById(jobAdId)) {
            return new ErrorResult("Böyle bir ilan yok");
        }

        JobAdFavorites jobAdFavorites = new JobAdFavorites();
        jobAdFavorites.setCandidate(this.candidateDao.findById(candidateId).get());
        jobAdFavorites.setJobAd(this.jobAdDao.findById(jobAdId).get());
        this.jobAdFavoritesDao.save(jobAdFavorites);
        return new SuccessResult("İlan facorilere eklendi");
    }
}
