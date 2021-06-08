package kodlamaio.Hrms.api.controllers;

import java.util.List;

import kodlamaio.Hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.SystemPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/systempersonnel")
public class SystemPersonnelController {

    private SystemPersonnelService systemPersonnelService;

    @Autowired
    public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
        super();
        this.systemPersonnelService = systemPersonnelService;
    }

    @GetMapping("/getall")
    public DataResult<List<SystemPersonnel>> getAll() {
        return this.systemPersonnelService.getAll();
    }

    @PostMapping("/register")
    public Result add(@RequestBody SystemPersonnel systemPersonnel) {
        return this.systemPersonnelService.register(systemPersonnel);
    }
}
