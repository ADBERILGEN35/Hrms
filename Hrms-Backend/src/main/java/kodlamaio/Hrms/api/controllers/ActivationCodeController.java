package kodlamaio.Hrms.api.controllers;

import kodlamaio.Hrms.business.abstracts.ActivationCodeService;
import kodlamaio.Hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activationcode")
@CrossOrigin
public class ActivationCodeController {
    private ActivationCodeService activationCodeService;

    @Autowired
    public ActivationCodeController(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    @GetMapping("/active/{code}")
    public ResponseEntity<?> activateUser(@PathVariable String code) {
        Result result = this.activationCodeService.activateUser(code);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
