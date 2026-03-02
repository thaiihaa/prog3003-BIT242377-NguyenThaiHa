package com.mycompany.bankingsystemasync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankingServiceTest {

    @Test
    public void testFullTransactionSuccess() throws Exception {
        CompletableFuture<String> pipeline = BankingService.authenticate("NguyenVanA")
            .thenCompose(user -> BankingService.checkBalance(user))
            .thenCompose(balance -> BankingService.transferMoney(100.0));

        String result = pipeline.get();
        // Khop voi chuoi khong dau trong BankingService
        assertEquals("Giao dich thanh cong!", result);
    }

    @Test
    public void testAuthenticationFailure() {
        CompletableFuture<String> pipeline = BankingService.authenticate("unknown")
            .thenCompose(user -> BankingService.checkBalance(user))
            .thenCompose(balance -> BankingService.transferMoney(100.0));

        assertThrows(ExecutionException.class, () -> {
            pipeline.get();
        });
    }
}