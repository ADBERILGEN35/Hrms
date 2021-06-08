package kodlamaio.Hrms.api.controllers;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getJobAdvertisement")
    public DataResult<List<JobAdvertisement>> getJobAdvertisement() {
        return this.jobAdvertisementService.getJobAdvertisement();
    }
    @CrossOrigin
    @GetMapping("/getActiveJobAdvertisement")
    public DataResult<List<JobAdvertisement>> getActiveJobAdvertisement() {
        return this.jobAdvertisementService.getActiveJobAdvertisement();
    }

    @GetMapping("/getJobAdvertisementForCompanyName")
    public DataResult<List<JobAdvertisement>> getJobAdvertisementForCompanyName(String companyName) {
        return this.jobAdvertisementService.getActiveJobAdvertisementForEmployer(companyName);
    }

    @GetMapping("/getActiveJobAdvertisementSorted")
    public DataResult<List<JobAdvertisement>> findAllByIsActiveTrueSorted() {
        return this.jobAdvertisementService.findAllByIsActiveTrue();
    }

    @PostMapping("/addJobAdvertisement")
    public Result addJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.addJobAdvert(jobAdvertisement);
    }
}
