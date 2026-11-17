
package com.buvanaa.ruleexecutionverifier.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class RuleRepositoryTest {

    @Autowired
    private RuleRepository ruleRepository;

    @Test
    void testFindRuleById() {

        Map<String, Object> rule =
                ruleRepository.findRuleById(2242940);

        System.out.println("Rule details: " + rule);

        System.out.println("Rule Type: " + rule.get("sub_type"));
    }
}
