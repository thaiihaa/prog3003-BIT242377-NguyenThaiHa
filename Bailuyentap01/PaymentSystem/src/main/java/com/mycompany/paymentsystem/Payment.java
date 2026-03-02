package com.mycompany.paymentsystem; // Tên package của bạn

/**
 * Interface chung cho tất cả các loại thanh toán.
 * Giúp Factory có thể trả về một kiểu dữ liệu thống nhất.
 */
public interface Payment {
    // Phương thức bắt buộc mọi lớp con phải có
    void processPayment(double amount);
}
