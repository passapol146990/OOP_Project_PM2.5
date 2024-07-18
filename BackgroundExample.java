import javax.swing.*;
import java.awt.*;

public class BackgroundExample extends JFrame {

    public BackgroundExample() {
        // โหลด GIF
        ImageIcon bg = new ImageIcon("./bg.jpg");

        // สร้าง JLabel ที่จะแสดง GIF
        JLabel gifLabel = new JLabel(bg);

        // ตั้งค่า layout เป็น BorderLayout
        setLayout(new BorderLayout());

        // เพิ่ม JLabel ที่แสดง GIF ลงไปใน JFrame
        add(gifLabel, BorderLayout.CENTER);

        // ตั้งค่าคุณสมบัติของ JFrame
        setSize(800, 600); // ขนาดของหน้าต่าง
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ปิดโปรแกรมเมื่อปิดหน้าต่าง
        setLocationRelativeTo(null); // ตั้งค่าให้หน้าต่างอยู่ตรงกลางจอ
    }

    public static void main(String[] args) {
        // สร้างและแสดง GUI ใน thread หลักของ Swing
        SwingUtilities.invokeLater(() -> {
            BackgroundExample frame = new BackgroundExample();
            frame.setVisible(true);
        });
    }
}
