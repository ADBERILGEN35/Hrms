package kodlamaio.Hrms.api.controllers;

import java.util.List;

import kodlamaio.Hrms.business.abstracts.JobSeekerEducationService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobSeekerEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jobSeeerEducations/")
public class JobSeekerEducationsController {

    private JobSeekerEducationService jobSeekerEducationService;

    @Autowired
    public JobSeekerEducationsController(JobSeekerEducationService jobSeekerEducationService) {
        super();
        this.jobSeekerEducationService = jobSeekerEducationService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobSeekerEducation jobSeekerEducation) {
        return jobSeekerEducationService.add(jobSeekerEducation);
    }

    @GetMapping("getByDateOfGraduationSorted")
    public DataResult<List<JobSeekerEducation>> getByDateOfGraduationSorted(@RequestParam int jobSeekerId) {
        return jobSeekerEducationService.getByDateOfGraduationSorted(jobSeekerId);
    }

}