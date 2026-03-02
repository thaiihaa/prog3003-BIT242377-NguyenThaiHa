package com.mycompany.bankingsystemasync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankingService {

    // Tao Thread Pool voi 3 luong de xu ly
    private static final ExecutorService transactionPool = Executors.newFixedThreadPool(3);

    // 1. Xac thuc khach hang
    public static CompletableFuture<String> authenticate(String user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] Dang xac thuc: " + user);
                TimeUnit.SECONDS.sleep(1); 
                if ("unknown".equalsIgnoreCase(user)) {
                    throw new RuntimeException("Khach hang khong ton tai!");
                }
                return user;
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, transactionPool);
    }

    // 2. Kiem tra so du
    public static CompletableFuture<Double> checkBalance(String user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] Kiem tra so du cho: " + user);
                TimeUnit.SECONDS.sleep(1);
                double balance = 500.0; 
                if (balance < 100.0) {
                    throw new RuntimeException("So du khong du!");
                }
                return balance;
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, transactionPool);
    }

    // 3. Thuc hien chuyen tien
    public static CompletableFuture<String> transferMoney(double amount) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] Dang chuyen khoan: $" + amount);
                TimeUnit.SECONDS.sleep(1);
                return "Giao dich thanh cong!";
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, transactionPool);
    }

    public static void main(String[] args) {
        TransactionRequest[] requests = {
            new TransactionRequest("NguyenVanA", 100.0, "Thanh toan hoa don"),
            new TransactionRequest("unknown", 50.0, "Giao dich thu loi"),
            new TransactionRequest("TranThiB", 200.0, "Chuyen tien cho ban")
        };

        System.out.println("=== BAT DAU XU LY GIAO DICH ===");

        for (TransactionRequest req : requests) {
            authenticate(req.getUser())
                .thenCompose(user -> checkBalance(user))
                .thenCompose(balance -> transferMoney(req.getAmount()))
                .handle((result, ex) -> {
                    if (ex != null) {
                        System.err.println(">> LOI [" + req.getUser() + "]: " + ex.getMessage());
                    } else {
                        System.out.println(">> XONG [" + req.getUser() + "]: " + result + " (" + req.getDescription() + ")");
                    }
                    return null;
                });
        }

        try { 
            transactionPool.awaitTermination(5, TimeUnit.SECONDS); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            transactionPool.shutdown();
        }
        
        System.out.println("=== HE THONG DUNG ===");
    }
}