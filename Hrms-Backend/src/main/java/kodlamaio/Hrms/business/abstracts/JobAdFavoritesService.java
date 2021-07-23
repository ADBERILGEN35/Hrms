package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdFavorites;

import java.util.List;


public interface JobAdFavoritesService {
    public DataResult<List<JobAdFavorites>> getByCandidateId(int candidateId);

    public Result addFavorite(int candidateId, int jobAdId);
}
