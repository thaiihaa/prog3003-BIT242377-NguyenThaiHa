package bai04;

import javax.swing.*;
import java.awt.event.*;

public class NhietDoApp extends JFrame {

    private JTextField txtCelsius;
    private JButton btnConvert;
    private JLabel lblResult;

    public NhietDoApp() {

        setTitle("Chuyển đổi nhiệt độ");
        setSize(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Label nhập Celsius
        JLabel lblCelsius = new JLabel("Nhập độ C:");
        lblCelsius.setBounds(30,30,100,25);
        add(lblCelsius);

        // TextField nhập Celsius
        txtCelsius = new JTextField();
        txtCelsius.setBounds(120,30,150,25);
        add(txtCelsius);

        // Button chuyển đổi
        btnConvert = new JButton("Chuyển đổi");
        btnConvert.setBounds(100,70,120,30);
        add(btnConvert);

        // Label hiển thị kết quả
        lblResult = new JLabel("Kết quả: ");
        lblResult.setBounds(30,120,250,25);
        add(lblResult);

        // Sự kiện khi nhấn button
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    double c = Double.parseDouble(txtCelsius.getText());

                    double f = c * 9/5 + 32;

                    lblResult.setText("Kết quả: " + f + " °F");

                } catch(Exception ex) {

                    JOptionPane.showMessageDialog(null,"Vui lòng nhập số!");

                }

            }
        });
    }

    public static void main(String[] args) {

        new NhietDoApp().setVisible(true);

    }
}
