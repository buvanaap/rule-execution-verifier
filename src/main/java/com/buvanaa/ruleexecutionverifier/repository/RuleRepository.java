
package com.buvanaa.ruleexecutionverifier.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RuleRepository {

    private final JdbcTemplate jdbcTemplate;

    public RuleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> findRuleById(long ruleId) {

        String sql = """
                SELECT
                    policy_rule_id,
                    name,
                    type,
                    sub_type,
                    account_id,
                    status
                FROM application.app_auto_policy_rule
                WHERE policy_rule_id = ?
                """;

        return jdbcTemplate.queryForMap(sql, ruleId);
    }
}
