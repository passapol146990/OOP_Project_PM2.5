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
        Border I = BorderFactory.createEmptyBorder(0,0,0,0);
        panel1.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel2.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel3.setBorder(BorderFactory.createCompoundBorder(O, I));
        //importรูป พร้อมตั้งขนาด
        ImageIcon iconpic1 = new ImageIcon("./image/Phol.png");
        JLabel label_phol = new JLabel(new ImageIcon(iconpic1.getImage().getScaledInstance(300,250,iconpic1.getImage().SCALE_SMOOTH)));
        ImageIcon iconpic2 = new ImageIcon("./image/Poom.jpg");
        JLabel label_poom = new JLabel(new ImageIcon(iconpic2.getImage().getScaledInstance(300,250,iconpic2.getImage().SCALE_SMOOTH)));
        ImageIcon iconpic3 = new ImageIcon("./image/Nam.jpg");
        JLabel label_nam = new JLabel(new ImageIcon(iconpic3.getImage().getScaledInstance(300,250,iconpic3.getImage().SCALE_SMOOTH)));
        //แบ่ง panel พร้อม ยัดรูปใส่ panel 
        Font font_name = new Font("Tahoma",Font.BOLD,25);
        panel1.setLayout(new GridLayout(2,1));
        panel2.setLayout(new GridLayout(2,1));
        panel3.setLayout(new GridLayout(2,1));
        panel1.add(label_phol);
        panel2.add(label_poom);
        panel3.add(label_nam);
        
        // เขียนคำอธิบาย ชื่อ
        JLabel label_textname_phol = new JLabel();
        label_textname_phol.setFont(font_name);
        label_textname_phol.setText("<html><div style='text-align: center;'>Phol<br>66011212067<br>นายพัสพล สุทาธรรม</div></html>");
        label_textname_phol.setVerticalAlignment(JLabel.CENTER);
        label_textname_phol.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label_textname_phol);
        JLabel label_textname_poom = new JLabel();
        label_textname_poom.setFont(font_name);
        label_textname_poom.setText("<html><div style='text-align: center;'>Poom<br>66011212245<br>นายภานุมาศ สายธนู</div></html>");
        label_textname_poom.setVerticalAlignment(JLabel.CENTER);
        label_textname_poom.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(label_textname_poom);
        JLabel label_textname_nam = new JLabel();
        label_textname_nam.setFont(font_name);
        label_textname_nam.setText("<html><div style='text-align: center;'>Nam<br>66011212108<br>นายนิติภูมิ ดิบประโคน</div></html>");
        label_textname_nam.setVerticalAlignment(JLabel.CENTER);
        label_textname_nam.setHorizontalAlignment(JLabel.CENTER);
        panel3.add(label_textname_nam);

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
