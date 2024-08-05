// แถบเมนูด้านบนของหน้า about, start
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
class CPN_Navbar extends JPanel{
    CPN_Navbar(App app,DataBase db,ShowDatas showDatas){
        setBounds(-1, 0,1280,40);
        setBorder(new LineBorder(new Color(0,0,0)));
        setLayout(null);
        CPN_ButtonPink btnBack = new CPN_ButtonPink("Back",new Color(254,169,169));
        btnBack.addActionListener(e->{app.showPanel("menu");});
        btnBack.setBounds(5,5,100,30);

        CPN_ButtonPink openFile = new CPN_ButtonPink("open file",new Color(254,169,169));
        openFile.setBounds(300,5,100,30);
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                // ตั้งค่า default path เริ่มต้นที่ ./
                fileChooser.setCurrentDirectory(new File("./"));

                // ตั้งค่า File Filter เพื่อให้เห็นเฉพาะไฟล์ .txt
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
                fileChooser.setFileFilter(filter);

                // เปิด File Chooser dialog
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    db.readFile(selectedFile.getAbsolutePath());
                    showDatas.setDatas(db);
                }
            }
        });


        // JButton saveFile = new JButton("save");
        // ButtonPink saveFile = new ButtonPink("save",1,1,1,1);
        // saveFile.setBounds(410,5,100,30);
        // JButton clearFile = new JButton("clear");
        // ButtonPink clearFile = new ButtonPink("clear",1,1,1,1);
        // clearFile.setBounds(520,5,100,30);

        ImageIcon iconRain = new ImageIcon("./image/rain.png");
        JButton clickRain = new JButton(new ImageIcon(iconRain.getImage().getScaledInstance(120,30,iconRain.getImage().SCALE_SMOOTH)));
        clickRain.setBounds(950,5,120,30);
        clickRain.setCursor(new Cursor(JFrame.HAND_CURSOR));
        clickRain.addActionListener(e->{
            showDatas.setClickRainStatus(true);
        });

        ImageIcon iconRandomRaid = new ImageIcon("./image/randomrain.png");
        JButton RandomkRain = new JButton(new ImageIcon(iconRandomRaid.getImage().getScaledInstance(120,30,iconRandomRaid.getImage().SCALE_SMOOTH)));
        RandomkRain.setBounds(1100,5,120,30);
        RandomkRain.setCursor(new Cursor(JFrame.HAND_CURSOR));
        RandomkRain.addActionListener(e->{
            db.randomRain();
            showDatas.setDatas(db);
        });
        
        clickRain.addActionListener(e->{
            showDatas.setClickRainStatus(true);
        });
        // clickRain.addActionListener(new ActionListener(){
        //     private int chk = 0;
        //     public void actionPerformed(ActionEvent cr)
        //     {
        //         if(chk == 0)
        //         {
        //             chk = 1;
        //             frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //             chkstate = 101;
        //         }
        //         else
        //         {
        //             chk = 0;
        //             frame.setCursor(Cursor.getDefaultCursor());
        //             chkstate = 102;
        //         }
        //     }
        // });

        add(openFile);
        // add(saveFile);
        // add(clearFile);
        add(clickRain);
        add(RandomkRain);
        add(btnBack);
    }
    
    CPN_Navbar(App app,String title){
        setBounds(-1, 0,1280,40);
        setBorder(new LineBorder(new Color(0,0,0)));
        setLayout(null);
        CPN_ButtonPink btnBack = new CPN_ButtonPink("Back",new Color(254,169,169));
        btnBack.addActionListener(e->{app.showPanel("menu");});
        btnBack.setBounds(5,5,100,30);

        JLabel label = new JLabel(title);
        label.setBounds(1200/2,5,100,30);

        add(btnBack);
        add(label);
    }
}
