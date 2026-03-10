package bai01; // Ten package phai dung voi thu muc ban tao

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // Tao TreeSet
        TreeSet<String> names = new TreeSet<>();
        
        // Them phan tu
        names.add("John");
        names.add("Alice");
        names.add("Zack");
        names.add("Bob");

        // In danh sach (Maven se in ra cua so Output ben duoi)
        System.out.println("Danh sach: " + names);

        // Lay phan tu dau va cuoi
        System.out.println("Phan tu dau (Min): " + names.first());
        System.out.println("Phan tu cuoi (Max): " + names.last());
    }
}
