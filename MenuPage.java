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
    int save = 0;
    MenuPage(App app){
        setLayout(new GridBagLayout());
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
        btnExit.addActionListener(e -> System.exit(0));
        add(btnExit,position);

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                app.showPanel("start");
            }
        });
    }
}
