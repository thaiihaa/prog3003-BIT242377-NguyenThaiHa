package bai02;

public class Main {
    public static void main(String[] args) {
        // TH1: Tao may tinh co Bluetooth
        // Dung kieu goi lien tiep (Method Chaining)
        Computer pcCoBluetooth = new Computer.ComputerBuilder("500 GB", "16 GB")
                .setBluetoothEnabled(true)
                .build();

        // TH2: Tao may tinh khong co Bluetooth (bo qua buoc setBluetooth)
        Computer pcKhongBluetooth = new Computer.ComputerBuilder("1 TB", "8 GB")
                .build();

        // In ket qua
        System.out.println("May tinh 1: " + pcCoBluetooth);
        System.out.println("May tinh 2: " + pcKhongBluetooth);
    }
}
