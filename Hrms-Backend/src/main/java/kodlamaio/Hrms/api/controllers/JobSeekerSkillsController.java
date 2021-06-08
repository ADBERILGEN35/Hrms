package kodlamaio.Hrms.api.controllers;

import kodlamaio.Hrms.business.abstracts.JobSeekerSkillService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobSeekerSkill;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobSeekerSkills/")
public class JobSeekerSkillsController {

    private JobSeekerSkillService jobSeekerSkillService;

    public JobSeekerSkillsController(JobSeekerSkillService jobSeekerSkillService) {
        super();
        this.jobSeekerSkillService = jobSeekerSkillService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobSeekerSkill jobSeekerSkill) {
        return jobSeekerSkillService.add(jobSeekerSkill);
    }

}