package com.myapp.studentmanagement;


public class Student {
    private String mssv;
    private String name;
    private double gpa;

    // Constructor (Hàm khởi tạo)
    public Student(String mssv, String name, double gpa) {
        this.mssv = mssv;
        this.name = name;
        this.gpa = gpa;
    }

    // Getter cho MSSV và Name để dùng khi tìm kiếm/xóa
    public String getMssv() { return mssv; }
    public String getName() { return name; }

    // Ghi đè toString để hiển thị đẹp hơn
    @Override
    public String toString() {
        return "MSSV: " + mssv + " | Tên: " + name + " | GPA: " + gpa;
    }
}