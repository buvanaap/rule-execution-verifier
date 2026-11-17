
package com.buvanaa.ruleexecutionverifier.service;

import com.buvanaa.ruleexecutionverifier.dto.RuleVerificationResult;
import java.util.ArrayList;
import java.util.List;
import com.buvanaa.ruleexecutionverifier.repository.AccountRepository;
import com.buvanaa.ruleexecutionverifier.repository.ExecutionHistoryRepository;
import com.buvanaa.ruleexecutionverifier.repository.ExecutionOutputRepository;
import com.buvanaa.ruleexecutionverifier.repository.RuleRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class RuleVerificationService {

    private final AccountRepository accountRepository;
    private final ExecutionHistoryRepository executionHistoryRepository;
    private final ExecutionOutputRepository executionOutputRepository;
    private final RuleRepository ruleRepository;

    public RuleVerificationService(
            AccountRepository accountRepository,
            ExecutionHistoryRepository executionHistoryRepository,
            ExecutionOutputRepository executionOutputRepository,
            RuleRepository ruleRepository) {

        this.accountRepository = accountRepository;
        this.executionHistoryRepository = executionHistoryRepository;
        this.executionOutputRepository = executionOutputRepository;
        this.ruleRepository = ruleRepository;


    }


    public RuleVerificationResult verifyRule(long ruleId, long accountId) {

        // 1. Get rule details
        var rule = ruleRepository.findRuleById(ruleId);

        // 2. Get account details
        var account = accountRepository.findAccountById(accountId);

        // 3. Get latest execution history
        var execution = executionHistoryRepository.findLatestExecution(
                ruleId, accountId
        );

        // 4. Get output status counts
        long executionHistoryId =
                ((Number) execution.get("execution_history_id")).longValue();

        var statusCounts =
                executionOutputRepository.findStatusCounts(executionHistoryId);

        long total = 0;
        long successful = 0;
        long nonSuccessful = 0;

        // 5. Calculate counts
        for (var count : statusCounts) {

            long countValue =
                    ((Number) count.get("total")).longValue();

            total += countValue;

            String status = String.valueOf(count.get("status"));

            if ("SUCCESS".equals(status)) {
                successful += countValue;
            } else {
                nonSuccessful += countValue;
            }
        }

        // 6. Print verification result
        System.out.println("\n========== RULE VERIFICATION ==========");
        System.out.println("Rule ID       : " + ruleId);
        System.out.println("Rule Type     : " + rule.get("sub_type"));
        System.out.println("Account Name  : " + account.get("display_name"));
        System.out.println("Execution ID  : " + executionHistoryId);
        System.out.println("Total         : " + total);
        System.out.println("Successful    : " + successful);
        System.out.println("Non-successful: " + nonSuccessful);
        System.out.println("=======================================");

        // 7. Return result
        return new RuleVerificationResult(
                ruleId,
                String.valueOf(rule.get("sub_type")),
                String.valueOf(account.get("display_name")),
                executionHistoryId,
                total,
                successful,
                nonSuccessful
        );
    }





        public List<RuleVerificationResult> verifyLogs(String logs) {

            List<RuleVerificationResult> results = new ArrayList<>();

        String regex = "ruleId:\\s*(\\d+)\\s+for account\\s*:\\s*(\\d+)";

        Pattern pattern = Pattern.compile(
                regex,
                Pattern.CASE_INSENSITIVE
        );

        Matcher matcher = pattern.matcher(logs);

        int count = 0;

        while (matcher.find()) {

            long ruleId = Long.parseLong(matcher.group(1));
            long accountId = Long.parseLong(matcher.group(2));

            System.out.println("\nProcessing Rule ID: " + ruleId);

            RuleVerificationResult result = verifyRule(ruleId, accountId);
            results.add(result);

            count++;
        }

        if (count == 0) {
            System.out.println("No valid rule logs found.");
        } else {
            System.out.println("\nTotal rules processed: " + count);
        }
            return results;
    }



}
