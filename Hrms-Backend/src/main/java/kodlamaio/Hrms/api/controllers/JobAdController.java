package kodlamaio.Hrms.api.controllers;

import kodlamaio.Hrms.business.abstracts.JobAdService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.entities.concretes.JobAd;
import kodlamaio.Hrms.entities.dtos.JobAdDto;
import kodlamaio.Hrms.entities.dtos.JobAdFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAd")
@CrossOrigin
public class JobAdController {

    private JobAdService jobAdService;

    @Autowired
    public JobAdController(JobAdService jobAdService) {
        this.jobAdService = jobAdService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAd>> getAll() {
        return this.jobAdService.getAll();
    }

    @GetMapping("/getByJobAdId")
    public DataResult<JobAd> getByJobAdId(@RequestParam int id) {
        JobAd jobAd = new JobAd();
        JobAd jobAdForSet = this.jobAdService.getByJobAdId(id).getData();
        if (jobAdForSet == null) {
            return new ErrorDataResult<JobAd>("Böyle bir ilan yok");
        }
        jobAd.setId(jobAdForSet.getId());
        jobAd.setEmployer(jobAdForSet.getEmployer());
        jobAd.setJobPosition(jobAdForSet.getJobPosition());
        jobAd.setDescription(jobAdForSet.getDescription());
        jobAd.setCity(jobAdForSet.getCity());
        jobAd.setMinSalary(jobAdForSet.getMinSalary());
        jobAd.setMaxSalary(jobAdForSet.getMaxSalary());
        jobAd.setOpenPositions(jobAdForSet.getOpenPositions());
        jobAd.setLastDate(jobAdForSet.getLastDate());
        jobAd.setActive(jobAdForSet.isActive());
        jobAd.setCreateDate(jobAdForSet.getCreateDate());
        jobAd.setWorkPlace(jobAdForSet.getWorkPlace());
        jobAd.setWorkTime(jobAdForSet.getWorkTime());
        jobAd.setConfirmed(jobAdForSet.isConfirmed());

        return new SuccessDataResult<JobAd>(jobAd, "Data listelendi");
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody JobAdDto jobAdDto) {
        Result result = this.jobAdService.create(jobAdDto);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/setPassive")
    public ResponseEntity<?> setPasssive(@RequestParam int jobAdId) {
        Result result = this.jobAdService.setPasssive(jobAdId);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/setActive")
    public ResponseEntity<?> setActiveAndConfirm(@RequestParam int jobAdId, @RequestParam int staffId) {
        Result result = this.jobAdService.setActiveAndConfirm(jobAdId, staffId);
        if (!result.isSuccess()) {
            ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getActiveAds")
    public DataResult<List<JobAd>> getActiveAds() {
        return this.jobAdService.getActiveAds();
    }

    @GetMapping("/getActivesOrderLastDate")
    public DataResult<List<JobAd>> getActivAndOrderLastDate() {
        return this.jobAdService.getActiveAndOrderLastDate();
    }

    @GetMapping("/getActiveAndCompanyId")
    public DataResult<List<JobAd>> getActiveAndCompanyId(@RequestParam int companyId) {
        return this.jobAdService.getActiveAndCompanyId(companyId);
    }

    @PostMapping("/getByActiveAndFilter")
    public Result getByActiveAndFilter(@RequestParam int pageNo, @RequestParam int pageSize, @RequestBody JobAdFilter jobAdFilter) {
        return jobAdService.getByIsActiveAndPageNumberAndFilter(pageNo, pageSize, jobAdFilter);
    }
}
