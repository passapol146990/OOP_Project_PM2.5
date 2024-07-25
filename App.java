import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class App extends JFrame{
    private CardLayout cardLayout;
    private JPanel mainPanel;

    App(String title){
        cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);

        setTitle(title);
        setBounds(50,50,1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("./bg.jpg"));
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