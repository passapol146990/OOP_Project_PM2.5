import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

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
        gbc.insets = new Insets(0, 0, 0, 30);
        gbc.gridx = 0;
        panel1.setLayout(new GridLayout());
        panel2.setLayout(new GridLayout());
        panel3.setLayout(new GridLayout());
        Border O = BorderFactory.createLineBorder(Color.BLACK,2);
        Border I = BorderFactory.createEmptyBorder(257,165,257,165);
        panel1.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel2.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel3.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel0.add(panel1,gbc);
        gbc.gridx = 1;
        panel0.add(panel2,gbc);
        gbc.gridx = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel0.add(panel3,gbc);
        frame.add(panel0);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
