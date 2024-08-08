// หน้าสำหรับแสดงรายชื่อผู้พัฒนา
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PageAbout extends JPanel{
    PageAbout(App app){
        CPN_Navbar navbar = new CPN_Navbar(app,"ผู้พัฒนาโปรแกรม");
        BodyAbout bodyAbout = new BodyAbout();

        setLayout(null);
        add(navbar);
        add(bodyAbout);
    }
}

class BodyAbout extends JPanel{
    BodyAbout(){
        // setLayout(null);
        setLayout(new GridBagLayout());
        setBounds(0, 0, 1280, 720);
        
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();   
        JPanel panel3 = new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);

        Border O = BorderFactory.createLineBorder(Color.BLACK,2);
        Border I = BorderFactory.createEmptyBorder(0,0,0,0);
        panel1.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel2.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel3.setBorder(BorderFactory.createCompoundBorder(O, I));
        // //importรูป พร้อมตั้งขนาด
        ImageIcon iconpic1 = new ImageIcon("./image/Phol.png");
        JLabel label_phol = new JLabel(new ImageIcon(iconpic1.getImage().getScaledInstance(300,250,iconpic1.getImage().SCALE_SMOOTH)));
        ImageIcon iconpic2 = new ImageIcon("./image/Poom.jpg");
        JLabel label_poom = new JLabel(new ImageIcon(iconpic2.getImage().getScaledInstance(300,250,iconpic2.getImage().SCALE_SMOOTH)));
        ImageIcon iconpic3 = new ImageIcon("./image/Nam.jpg");
        JLabel label_nam = new JLabel(new ImageIcon(iconpic3.getImage().getScaledInstance(300,250,iconpic3.getImage().SCALE_SMOOTH)));
        // //แบ่ง panel พร้อม ยัดรูปใส่ panel 
        panel1.setLayout(new GridLayout(2,1));
        panel2.setLayout(new GridLayout(2,1));
        panel3.setLayout(new GridLayout(2,1));

        panel1.add(label_phol);
        panel2.add(label_poom);
        panel3.add(label_nam);
        
        // // เขียนคำอธิบาย ชื่อ
        Font font_name = new Font("Tahoma",Font.BOLD,25);
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
        add(panel1,gbc);
        gbc.gridx = 1;
        add(panel2,gbc);
        gbc.gridx = 2;
        add(panel3,gbc);
    }
}