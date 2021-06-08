package kodlamaio.Hrms.api.controllers;

import java.util.List;

import kodlamaio.Hrms.business.abstracts.JobSeekerExperienceService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobSeekerExperience;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/jobExperiences/")
public class JobSeekerExperiencesController {

    private JobSeekerExperienceService jobSeekerExperienceService;

    public JobSeekerExperiencesController(JobSeekerExperienceService jobSeekerExperienceService) {
        super();
        this.jobSeekerExperienceService = jobSeekerExperienceService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobSeekerExperience jobSeekerExperience) {
        return jobSeekerExperienceService.add(jobSeekerExperience);
    }

    @GetMapping("getByDateOfFinishSorted")
    public DataResult<List<JobSeekerExperience>> getByDateOfFinishSorted(@RequestParam int jobSeekerId) {
        return jobSeekerExperienceService.getByDateOfFinishSorted(jobSeekerId);
    }

}