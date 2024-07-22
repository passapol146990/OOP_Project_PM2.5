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

import javax.swing.JLabel;
import javax.swing.JPanel;
public class MenuPage extends JPanel {
    MenuPage(){
        setLayout(new GridBagLayout());
        // setBackground(new Color(0,0,0));

        GridBagConstraints position = new GridBagConstraints();

        JLabel title = new JLabel("PM2.5");
        title.setFont(new Font("Tahoma",Font.BOLD,100));
        position.gridy = 0;
        add(title, position);
        
        position.fill = GridBagConstraints.HORIZONTAL;
        position.insets = new Insets(10, 0, 10, 0);
        ButtonPink btnStart = new ButtonPink("start",21,85,21,85);
        btnStart.setPreferredSize(new Dimension(300, 75));
        btnStart.setFont(new Font("Tahoma",Font.BOLD,25));
        position.gridx = 0;
        position.gridy = 1;
        add(btnStart,position);
        ButtonPink btnAbout = new ButtonPink("about",21,85,21,85);
        btnAbout.setPreferredSize(new Dimension(300, 75));
        btnAbout.setFont(new Font("Tahoma",Font.BOLD,25));
        position.gridx = 0;
        position.gridy = 2;
        add(btnAbout,position);
        ButtonPink btnExit = new ButtonPink("exit",21,85,21,85);
        btnExit.setPreferredSize(new Dimension(300, 75));
        btnExit.setFont(new Font("Tahoma",Font.BOLD,25));
        position.gridx = 0;
        position.gridy = 3;
        add(btnExit,position);


        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });

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
    }
}
