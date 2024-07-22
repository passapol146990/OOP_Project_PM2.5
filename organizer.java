import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

class organizer {
        public static void main(String[] args) {
        
        JFrame frame = new JFrame("GUI");
        Font font = new Font("Tahoma",Font.BOLD,55);
        Button_1 button = new Button_1("Back",15,25,15,25);
        frame.setLayout(new BorderLayout());
        frame.setBounds(450, 300, 1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panel0 = new JPanel();   JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
        Border I = BorderFactory.createEmptyBorder(0,0,0,0);
        panel1.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel2.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel3.setBorder(BorderFactory.createCompoundBorder(O, I));
        
        ImageIcon iconpic1 = new ImageIcon("Phol.png");
        JLabel label_phol = new JLabel(new ImageIcon(iconpic1.getImage().getScaledInstance(300,400,iconpic1.getImage().SCALE_SMOOTH)));
        ImageIcon iconpic2 = new ImageIcon("Poom.jpg");
        JLabel label_poom = new JLabel(new ImageIcon(iconpic2.getImage().getScaledInstance(300,400,iconpic2.getImage().SCALE_SMOOTH)));
        ImageIcon iconpic3 = new ImageIcon("Nam.jpg");
        JLabel label_nam = new JLabel(new ImageIcon(iconpic3.getImage().getScaledInstance(300,400,iconpic3.getImage().SCALE_SMOOTH)));
        Font font_name = new Font("Tahoma",Font.BOLD,10);
        panel1.add(label_phol);
        panel2.add(label_poom);
        panel3.add(label_nam);
        // JLabel label_name_Phol = new JLabel("Phol");
        // label_name_Phol.setFont(font_name);
        // panel1.add(label_name_Phol);
        
        

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
