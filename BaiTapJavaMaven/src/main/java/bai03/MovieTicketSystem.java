package bai03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MovieTicketSystem {

    public static void main(String[] args) {
        System.out.println("--- Bat dau he thong dat ve ---");

        // 1. Tac vu 1: Xac thuc thong tin khach hang (Bat dong bo)
        CompletableFuture<String> verifyUser = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Dang xac thuc khach hang... (ton 2 giay)");
                Thread.sleep(2000); // Gia lap thoi gian xu ly
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Khach hang: Nguyen Van A";
        });

        // 2. Tac vu 2: Xuat ve xem phim (Bat dong bo)
        CompletableFuture<String> issueTicket = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Dang khoi tao ve... (ton 3 giay)");
                Thread.sleep(3000); // Gia lap thoi gian xu ly
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Ve xem phim: AVATAR 2 - Ghe A10";
        });

        // 3. Ket hop 2 tac vu bang thenCombine()
        // thenCombine se doi ca 2 tac vu hoan thanh roi moi thuc thi lambda ben trong
        CompletableFuture<String> combinedResult = verifyUser.thenCombine(issueTicket, (userData, ticketData) -> {
            System.out.println("-> Dang ket hop thong tin...");
            return "XAC NHAN: " + userData + " da nhan " + ticketData;
        });

        // 4. In ket qua cuoi cung
        try {
            // Ham .get() se block luong main cho den khi moi thu xong xuoi
            String finalOutput = combinedResult.get();
            System.out.println("\n--- KET QUA CUOI CUNG ---");
            System.out.println(finalOutput);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("--- Ket thuc chuong trinh ---");
    }
}

