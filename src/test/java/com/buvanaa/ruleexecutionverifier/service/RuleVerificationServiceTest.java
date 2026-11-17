
package com.buvanaa.ruleexecutionverifier.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RuleVerificationServiceTest {

    @Autowired
    private RuleVerificationService ruleVerificationService;
    @Test
    void testVerifyLogs() {

        String logs = """
            Executing Auto Pause/Enable rule
            A auto pause/enable rule will run now with ruleId: 2832290 for account : 4298730

            Executing Auto Pause/Enable rule
            A auto pause/enable rule will run now with ruleId: 2832290 for account : 4298730
            """;

        ruleVerificationService.verifyLogs(logs);
    }
}
