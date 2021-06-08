package kodlamaio.Hrms.api.controllers;

import kodlamaio.Hrms.business.abstracts.JobSeekerForeignLanguageService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobSeekerForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jobSeekerForeignLanguages/")
public class JobSeekerForeignLanguagesController {

    private JobSeekerForeignLanguageService jobSeekerForeignLanguageService;

    @Autowired
    public JobSeekerForeignLanguagesController(JobSeekerForeignLanguageService jobSeekerForeignLanguageService) {
        super();
        this.jobSeekerForeignLanguageService = jobSeekerForeignLanguageService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobSeekerForeignLanguage jobSeekerForeignLanguage) {
        return jobSeekerForeignLanguageService.add(jobSeekerForeignLanguage);
    }

}