import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class App{
    public static void main(String[] args) {
        JFrame frame = new JFrame("PM2.5");
        frame.setLayout(new BorderLayout());
        frame.setBounds(0, 0, 1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MenuPage pagemenu = new MenuPage();
        frame.add(pagemenu);
        // Dimension size = new Dimension(300, 75);
        // Font font = new Font("Tahoma",Font.BOLD,100);
        // Font font1 = new Font("Tahoma",Font.BOLD,25);

        // JPanel panelMenu = new JPanel();
        // panelMenu.setLayout(new GridBagLayout());

        // GridBagConstraints gbc = new GridBagConstraints();
        // Label label = new Label("PM2.5");
        // label.setFont(font);
        // gbc.gridy = 0; 
        // panelMenu.add(label,gbc);
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.insets = new Insets(10, 0, 10, 0);

        // Button_1 btnStart = new Button_1("Start",21,85,21,85);
        // btnStart.setPreferredSize(size);
        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // btnStart.setFont(font1);
        // btnStart.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         panelMenu.setVisible(false);
        //     }
        // });
        // panelMenu.add(btnStart, gbc);
        
        // Button_1 button1 = new Button_1("Organizer",21,85,21,85);
        // button1.setPreferredSize(size);
        // gbc.gridx = 0;
        // gbc.gridy = 2;
        // button1.setFont(font1);
        // panelMenu.add(button1, gbc);
        
        // Button_1 button2 = new Button_1("Exit",21,85,21,85);
        // button2.setPreferredSize(size);
        // gbc.gridx = 0;
        // gbc.gridy = 3;
        // button2.setFont(font1);
        // panelMenu.add(button2, gbc);
        
        // panelMenu.setFont(font);

        // frame.add(panelMenu, BorderLayout.CENTER);
        // frame.setLocationRelativeTo(null);
        // button2.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }    
}