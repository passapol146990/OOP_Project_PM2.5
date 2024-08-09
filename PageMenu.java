// หน้าเมนู
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PageMenu extends JPanel {
    PageMenu(App app){
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();

        JLabel title = new JLabel("PM2.5");
        title.setFont(new Font("Tahoma",Font.BOLD,100));
        position.gridy = 0;
        add(title, position);
        
        position.fill = GridBagConstraints.HORIZONTAL;
        position.insets = new Insets(10, 0, 10, 0);

        CPN_ButtonPink btnStart = new CPN_ButtonPink("start",new Color(254,169,169));
        btnStart.setPreferredSize(new Dimension(300, 75));
        btnStart.setFont(new Font("Tahoma",Font.BOLD,25));
        position.gridx = 0;
        position.gridy = 1;
        add(btnStart,position);

        CPN_ButtonPink btnAbout = new CPN_ButtonPink("about",new Color(254,169,169));
        btnAbout.setPreferredSize(new Dimension(300, 75));
        btnAbout.setFont(new Font("Tahoma",Font.BOLD,25));
        position.gridx = 0;
        position.gridy = 2;
        add(btnAbout,position);

        CPN_ButtonPink btnExit = new CPN_ButtonPink("exit",new Color(254,169,169));
        btnExit.setPreferredSize(new Dimension(300, 75));
        btnExit.setFont(new Font("Tahoma",Font.BOLD,25));
        position.gridx = 0;
        position.gridy = 3;
        add(btnExit,position);
        
        btnExit.addActionListener(e -> {
            System.exit(0);
        });
        btnStart.addActionListener(e->{
            app.showPanel("start");
            app.getPageStart().setBodyStart(app);
        });
        btnAbout.addActionListener(e->{
            app.showPanel("about");
            app.getPageAbout().setPageabout(app);
        });
    }
}
