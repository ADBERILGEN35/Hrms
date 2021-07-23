package kodlamaio.Hrms.business.abstracts;


import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAd;
import kodlamaio.Hrms.entities.dtos.JobAdDto;
import kodlamaio.Hrms.entities.dtos.JobAdFilter;

import java.util.List;
import java.util.List;

public interface JobAdService {
    Result create(JobAdDto jobAdDto);

    Result setPasssive(int jobAdId);

    Result setActiveAndConfirm(int jobAdId, int staffId);

    DataResult<List<JobAd>> getAll();

    DataResult<JobAd> getByJobAdId(int id);

    DataResult<List<JobAd>> getActiveAds();

    DataResult<List<JobAd>> getActiveAndOrderLastDate();

    DataResult<List<JobAd>> getActiveAndCompanyId(int id);

    DataResult<List<JobAd>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize, JobAdFilter jobAdFilter);
}
