
package com.buvanaa.ruleexecutionverifier.controller;
import com.buvanaa.ruleexecutionverifier.dto.RuleVerificationResult;
import java.util.List;
import com.buvanaa.ruleexecutionverifier.service.RuleVerificationService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/rules")
public class RuleVerificationController {

    private final RuleVerificationService ruleVerificationService;

    public RuleVerificationController(
            RuleVerificationService ruleVerificationService) {

        this.ruleVerificationService = ruleVerificationService;
    }

    @PostMapping("/verify")
    public List<RuleVerificationResult> verifyLogs(@RequestBody String logs) {

        return ruleVerificationService.verifyLogs(logs);
    }
}
