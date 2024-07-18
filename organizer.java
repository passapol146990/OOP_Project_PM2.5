import java.awt.*;
import javax.swing.*;

class organizer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setLayout(new BorderLayout());
        frame.setBounds(450, 300, 1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel0.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        panel1.setLayout(new GridLayout());
        panel2.setLayout(new GridLayout());
        panel3.setLayout(new GridLayout());
        Button_1 button = new Button_1("Test");
        button.setSize(200,500);
        Button_1 button1 = new Button_1("Test");
        button.setSize(200,500);
        Button_1 button2 = new Button_1("Test");
        button.setSize(200,500);
        button1.setSize(200, 500);
        panel1.add(button);
        panel2.add(button1);
        panel3.add(button2);
        panel0.add(panel1,gbc);
        gbc.gridx = 1;
        panel0.add(panel2,gbc);
        gbc.gridx = 2;
        panel0.add(panel3,gbc);
        frame.add(panel0);
        frame.setVisible(true);
    }
}
