/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n===== QUAN LY SINH VIEN =====");
            System.out.println("1. Them sinh vien moi");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kien theo ten");
            System.out.println("4. Xoa theo MSSV");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");
            
            // Su dung try-catch de tranh loi khi nhap chu vao o so
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long chi nhap so tu 0 den 4!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhap MSSV: "); 
                    String id = sc.nextLine();
                    System.out.print("Nhap Ten: "); 
                    String name = sc.nextLine();
                    System.out.print("Nhap GPA: "); 
                    double gpa = Double.parseDouble(sc.nextLine());
                    
                    list.add(new Student(id, name, gpa));
                    System.out.println("Them thanh cong!");
                    break;
                    
                case 2:
                    System.out.println("\n--- DANH SACH SINH VIEN ---");
                    if (list.isEmpty()) {
                        System.out.println("Danh sach dang trong.");
                    } else {
                        for (Student s : list) {
                            System.out.println(s.toString());
                        }
                    }
                    break;
                    
                case 3:
                    System.out.print("Nhap ten can tim: ");
                    String findName = sc.nextLine();
                    System.out.println("Ket qua tim kiem:");
                    boolean found = false;
                    for (Student s : list) {
                        if (s.getName().toLowerCase().contains(findName.toLowerCase())) {
                            System.out.println(s);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Khong tim thay sinh vien nao.");
                    break;
                    
                case 4:
                    System.out.print("Nhap MSSV can xoa: ");
                    String deleteId = sc.nextLine();
                    boolean removed = list.removeIf(s -> s.getMssv().equalsIgnoreCase(deleteId));
                    if (removed) {
                        System.out.println("Da xoa sinh vien co MSSV: " + deleteId);
                    } else {
                        System.out.println("Khong tim thay MSSV nay de xoa.");
                    }
                    break;
                    
                case 0:
                    System.out.println("Tam biet!");
                    System.exit(0);
                    
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        }
    }
}
