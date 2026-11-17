
package com.buvanaa.ruleexecutionverifier.dto;

public class RuleVerificationResult {

    private long ruleId;
    private String ruleType;
    private String accountName;
    private long executionHistoryId;
    private long total;
    private long successful;
    private long nonSuccessful;

    public RuleVerificationResult(long ruleId, String ruleType,
                                  String accountName, long executionHistoryId,
                                  long total, long successful, long nonSuccessful) {
        this.ruleId = ruleId;
        this.ruleType = ruleType;
        this.accountName = accountName;
        this.executionHistoryId = executionHistoryId;
        this.total = total;
        this.successful = successful;
        this.nonSuccessful = nonSuccessful;
    }

    public long getRuleId() {
        return ruleId;
    }

    public String getRuleType() {
        return ruleType;
    }

    public String getAccountName() {
        return accountName;
    }

    public long getExecutionHistoryId() {
        return executionHistoryId;
    }

    public long getTotal() {
        return total;
    }

    public long getSuccessful() {
        return successful;
    }

    public long getNonSuccessful() {
        return nonSuccessful;
    }
}
