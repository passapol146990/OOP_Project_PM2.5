import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// คลาส RoundedButton ที่สืบทอดจาก JButton
class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setBackground(Color.CYAN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }

    @Override
    public void updateUI() {
        setUI(new BasicButtonUI());
    }
}

// คลาสหลักที่ใช้ RoundedButton
public class RoundedButtonExample extends JFrame {
    public RoundedButtonExample() {
        // ตั้งค่าเฟรมพื้นฐาน
        setTitle("Rounded Button Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // สร้าง JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // สร้างปุ่ม RoundedButton และเพิ่มลงใน JPanel
        RoundedButton roundedButton = new RoundedButton("Click Me!");
        roundedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button Clicked!");
            }
        });
        panel.add(roundedButton);

        // เพิ่ม JPanel ลงใน JFrame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RoundedButtonExample().setVisible(true);
            }
        });
    }
}
