package com.buvanaa.ruleexecutionverifier.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ExecutionHistoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public ExecutionHistoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Map<String, Object> findLatestExecution(
            long ruleId, long accountId) {

        String sql = """
                SELECT execution_history_id,
                       policy_rule_id,
                       account_id,
                       execution_time,
                       status,
                       app_name
                FROM application.app_auto_policy_rule_execution_history
                WHERE policy_rule_id = ?
                  AND account_id = ?
                ORDER BY execution_history_id DESC
                LIMIT 1
                """;

        return jdbcTemplate.queryForMap(sql, ruleId, accountId);
    }
    // Keep the findLatestExecution() method here
}