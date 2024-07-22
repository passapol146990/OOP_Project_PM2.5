import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

class organizer {
        public static void main(String[] args) {
        
        JFrame frame = new JFrame("GUI");
        Font font = new Font("Tahoma",Font.BOLD,55);
        ButtonPink button = new ButtonPink("Back",15,25,15,25);
        frame.setLayout(new BorderLayout());
        frame.setBounds(450, 300, 1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panel0 = new JPanel();   JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();   JPanel panel3 = new JPanel();
        panel0.setLayout(new GridBagLayout());
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel0.add(button,gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 0, 20, 25);
        JLabel label = new JLabel("Organizer",JLabel.CENTER);
        label.setFont(font);
        panel0.add(label,gbc);
        panel1.setLayout(new GridLayout());
        panel2.setLayout(new GridLayout());
        panel3.setLayout(new GridLayout());
        Border O = BorderFactory.createLineBorder(Color.BLACK,2);
        Border I = BorderFactory.createEmptyBorder(258,165,258 ,165);
        panel1.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel2.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel3.setBorder(BorderFactory.createCompoundBorder(O, I));
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel0.add(panel1,gbc);
        gbc.gridx = 1;
        panel0.add(panel2,gbc);
        gbc.gridx = 2;
        panel0.add(panel3,gbc);
        frame.add(panel0);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
