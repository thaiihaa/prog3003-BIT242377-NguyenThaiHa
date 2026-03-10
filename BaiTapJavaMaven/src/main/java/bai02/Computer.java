package bai02;

public class Computer {
    // 1. Cac thuoc tinh cua may tinh
    private String HDD;
    private String RAM;
    private boolean isBluetoothEnabled; // Thuoc tinh tuy chon (mac dinh la false)

    // 2. Private Constructor: Chi co lop Builder ben trong moi goi duoc
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Getter (khong can Setter vi Builder da lam nhiem vu khoi tao)
    @Override
    public String toString() {
        return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", Bluetooth=" + isBluetoothEnabled + "]";
    }

    // 3. Static Inner Class: ComputerBuilder
    public static class ComputerBuilder {
        // Cac thuoc tinh giong lop Computer
        private String HDD;
        private String RAM;
        private boolean isBluetoothEnabled;

        // Constructor cho cac thuoc tinh BAT BUOC
        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        // Phuong thuc thiet lap cho cac thuoc tinh TUY CHON
        // Tra ve chinh doi tuong Builder de co the goi lien tiep (Method Chaining)
        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Phuong thuc cuoi cung de tao ra doi tuong Computer that su
        public Computer build() {
            return new Computer(this);
        }
    }
}