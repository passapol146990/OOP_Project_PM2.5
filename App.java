import java.awt.BorderLayout;
import java.awt.CardLayout;
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
public class App extends JFrame{
    private CardLayout cardLayout;
    private JPanel mainPanel;

    App(String title){
        cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);

        setTitle(title);
        setBounds(50,50,1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(this.mainPanel);
        setVisible(true);
    }
    void addPanel(JPanel panel,String path){
        this.mainPanel.add(panel, path);
    }
    void showPanel(String path){
        this.cardLayout.show(this.mainPanel,path);
    }
}