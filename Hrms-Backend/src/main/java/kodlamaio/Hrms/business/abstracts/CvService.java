package kodlamaio.Hrms.business.abstracts;


import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {
    public Result add(int candidateId);

    public DataResult<List<Cv>> getAll();

    public DataResult<Cv> getByCvId(int cvId);

    public DataResult<Cv> getByCandidateId(int candidateId);

    public Result updateGithub(String githublink, int cvId);

    public Result deleteGithub(int cvId);

    public Result updateLinkedin(String linkedinlink, int cvId);

    public Result deleteLinkedin(int cvId);

    public Result updateBiography(String biography, int cvId);

    public Result deleteBiography(int cvId);
}
