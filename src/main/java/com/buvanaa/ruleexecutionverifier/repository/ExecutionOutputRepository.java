
package com.buvanaa.ruleexecutionverifier.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ExecutionOutputRepository {

    private final JdbcTemplate jdbcTemplate;

    public ExecutionOutputRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findStatusCounts(
            long executionHistoryId) {

        String sql = """
                SELECT
                    status,
                    COUNT(*) AS total
                FROM application.app_auto_policy_rule_execution_output
                WHERE execution_history_id = ?
                GROUP BY status
                ORDER BY status
                """;

        return jdbcTemplate.queryForList(sql, executionHistoryId);
    }
}
