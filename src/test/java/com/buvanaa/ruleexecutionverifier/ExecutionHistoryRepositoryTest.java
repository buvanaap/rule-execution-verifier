
package com.buvanaa.ruleexecutionverifier.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class ExecutionHistoryRepositoryTest {

    @Autowired
    private ExecutionHistoryRepository executionHistoryRepository;

    @Test
    void testFindLatestExecution() {

        Map<String, Object> execution =
                executionHistoryRepository.findLatestExecution(
                        2832290L, 4298730L
                );

        System.out.println("Latest execution details: " + execution);
    }
}
