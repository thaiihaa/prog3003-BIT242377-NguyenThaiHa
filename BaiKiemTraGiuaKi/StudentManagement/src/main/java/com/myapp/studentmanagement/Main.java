/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManager<Student> manager = new StudentManager<>();
        manager.add(new Student("001","Nguyen Thai Ha", 9.0));
        manager.add(new Student("002","Ta Gia Bao", 8.0));
        manager.add(new Student("003","Vu Tung Duong", 7.0));
        
        List<Student> studenList = manager.getAll();
        System.out.println("Danh sach sinh vien da co la:");
        for (Student student : studenList){
            System.out.println(student.toString());
        }
        
    }

}
