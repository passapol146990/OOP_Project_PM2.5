import java.awt.*;
import java.util.concurrent.Flow;

import javax.swing.*;
public class menu{
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setLayout(new BorderLayout());
        frame.setBounds(450, 300, 1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Tahoma",Font.BOLD,100);
        Font font1 = new Font("Tahoma",Font.BOLD,25);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // ใช้ GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        Label label = new Label("PM2.5");
        label.setFont(font);
        gbc.gridy = 0; 
        panel.add(label,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0); // ช่องว่างระหว่างปุ่ม

        // สร้างปุ่มและเพิ่มลงใน JPanel
        Button_1 button0 = new Button_1("Start");
        button0.setPreferredSize(new Dimension(300, 75));
        gbc.gridx = 0;
        gbc.gridy = 1;
        button0.setFont(font1);
        panel.add(button0, gbc);

        Button_1 button1 = new Button_1("Organizer");
        button1.setPreferredSize(new Dimension(300, 75));
        gbc.gridx = 0;
        gbc.gridy = 2;
        button1.setFont(font1);
        panel.add(button1, gbc);

        Button_1 button2 = new Button_1("Exit");
        button2.setPreferredSize(new Dimension(300, 75));
        gbc.gridx = 0;
        gbc.gridy = 3;
        button2.setFont(font1);
        panel.add(button2, gbc);

        panel.setFont(font);
        // เพิ่ม panel ลงใน frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}