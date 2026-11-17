package com.buvanaa.ruleexecutionverifier;

import com.buvanaa.ruleexecutionverifier.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Map;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testFindAccountById() {

        Map<String, Object> account =
                accountRepository.findAccountById(208330);

        System.out.println("Account details: " + account);
    }
}
