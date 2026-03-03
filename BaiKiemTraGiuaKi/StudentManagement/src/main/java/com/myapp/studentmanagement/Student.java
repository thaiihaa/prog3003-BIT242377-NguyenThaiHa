package com.myapp.studentmanagement;


public class Student {
    private String id;
    private String name;
    private double gpa;

    // Constructor (Hàm khởi tạo)
    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    
    public String getID() { return id; }
    public String getName() { return name; }

    
    @Override
    public String toString() {
        return "MSSV: " + id + " | Ten: " + name + " | GPA: " + gpa;
    }
}