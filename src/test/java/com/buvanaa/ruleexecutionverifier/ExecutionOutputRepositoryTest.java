
package com.buvanaa.ruleexecutionverifier.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ExecutionOutputRepositoryTest {

    @Autowired
    private ExecutionOutputRepository executionOutputRepository;

    @Test
    void testFindStatusCounts() {

        List<Map<String, Object>> statusCounts =
                executionOutputRepository.findStatusCounts(13594657L);

        System.out.println("Output status counts: " + statusCounts);
    }
}
