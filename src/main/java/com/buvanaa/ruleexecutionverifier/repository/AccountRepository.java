
package com.buvanaa.ruleexecutionverifier.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> findAccountById(long accountId) {

        String sql = """
                SELECT ams_account_id, name, display_name
                FROM application.app_ams_account
                WHERE ams_account_id = ?
                """;

        return jdbcTemplate.queryForMap(sql, accountId);
    }
}
