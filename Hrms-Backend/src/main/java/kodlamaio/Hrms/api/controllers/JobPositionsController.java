package kodlamaio.Hrms.api.controllers;

import java.util.List;

import kodlamaio.Hrms.business.abstracts.JobPositionService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        super();
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll() {
        return this.jobPositionService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.add(jobPosition);
    }
}
