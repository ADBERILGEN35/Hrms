package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getJobAdvertisement();

    DataResult<List<JobAdvertisement>> getActiveJobAdvertisement();

    DataResult<List<JobAdvertisement>> getActiveJobAdvertisementForEmployer(String companyName);

    DataResult<List<JobAdvertisement>> findAllByIsActiveTrue();

    Result deactiveJobAdvertisement(int jobAdvertId);

    Result addJobAdvert(JobAdvertisement jobAdvert);
}

