
package com.buvanaa.ruleexecutionverifier.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class RuleExecutionRepositoryTest {

    @Autowired
    private RuleExecutionRepository executionRepository;

    @Test
    void testFindLatestExecution() {

        Map<String, Object> execution =
                executionRepository.findLatestExecution(2242940, 576000);

        System.out.println("Execution details: " + execution);

        System.out.println(
                "Execution History ID: " + execution.get("execution_history_id"));

        System.out.println(
                "Execution Status: " + execution.get("status"));
    }
}
