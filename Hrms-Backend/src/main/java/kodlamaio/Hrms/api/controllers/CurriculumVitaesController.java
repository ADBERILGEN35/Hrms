package kodlamaio.Hrms.api.controllers;

import kodlamaio.Hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/curriculumVitaes/")
public class CurriculumVitaesController {

    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        super();
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @PostMapping("add")
    public Result add(@RequestBody CurriculumVitae curriculumVitae) {
        return curriculumVitaeService.add(curriculumVitae);
    }

    @GetMapping("getAll")
    public Result getAll() {
        return curriculumVitaeService.getAll();
    }

    @GetMapping("getByJobSeekerId")
    public Result getByJobSeekerId(@RequestParam int getByJobSeekerId) {
        return curriculumVitaeService.getByJobSeekerId(getByJobSeekerId);
    }

}