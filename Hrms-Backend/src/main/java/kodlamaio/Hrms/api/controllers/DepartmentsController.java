package kodlamaio.Hrms.api.controllers;

import java.util.List;

import kodlamaio.Hrms.business.abstracts.DepartmentService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentsController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<Department>> getAll(){
        return this.departmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
        return this.departmentService.add(department);
    }

}
