package kodlamaio.Hrms.api.controllers;

import kodlamaio.Hrms.business.abstracts.ExperianceService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Experiance;
import kodlamaio.Hrms.entities.dtos.ExperianceForSetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiances")
@CrossOrigin
public class ExperiancesController {

    private ExperianceService experianceService;

    @Autowired
    public ExperiancesController(ExperianceService experianceService) {
        this.experianceService = experianceService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ExperianceForSetDto experianceForSetDto) {
        Result result = this.experianceService.add(experianceForSetDto);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int experianceId) {
        return this.experianceService.delete(experianceId);
    }

    @GetMapping("/getByCvId")
    public DataResult<List<Experiance>> getByCvId(@RequestParam int id) {
        return this.experianceService.getByCvId(id);
    }
}
