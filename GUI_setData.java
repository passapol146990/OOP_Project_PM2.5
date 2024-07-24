import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI_setData extends JFrame{
    static int chkstate = 0;// bug to watch
    static ArrayList <ArrayList<Float>> datas = new ArrayList<ArrayList<Float>>();
    public static void main(String[] args) {
        About_Methods methods = new About_Methods();
        try {
            Scanner readFile = new Scanner(new File("./pm2.5.txt"));
            while (readFile.hasNext()) {
                ArrayList <Float> datas_row = new ArrayList<Float>
                ();
                for (String i:readFile.nextLine().split("\t")) {
                    float f=Float.parseFloat(i); 
                    datas_row.add(f);
                }
                datas.add(datas_row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // System.out.println(datas);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setTitle("set Data");
            frame.setLayout(null);
            frame.setBounds(50,50, 1280,720);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //สำหรับปิด หน้าต่างแล้วจะปิดการทำงานของโปรแกรมไปเลย
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./bg.jpg"));
            // importรูปผู้ป่วย

            JPanel pic_of_feeling = new JPanel();
            pic_of_feeling.setLayout(new FlowLayout());
            pic_of_feeling.setBounds(1000,50 , 250, 250);
            ImageIcon icon_happy = new ImageIcon("./image/happy.png");
            JLabel label_happy = new JLabel(new ImageIcon(icon_happy.getImage().getScaledInstance(240,240,icon_happy.getImage().SCALE_SMOOTH)));
            ImageIcon icon_sad = new ImageIcon("./image/sad.png");
            JLabel label_sad = new JLabel(new ImageIcon(icon_sad.getImage().getScaledInstance(240,240,icon_sad.getImage().SCALE_SMOOTH)));
            ImageIcon icon_sick = new ImageIcon("./image/sick.png");
            JLabel label_sick = new JLabel(new ImageIcon(icon_sick.getImage().getScaledInstance(240,240,icon_sick.getImage().SCALE_SMOOTH)));
            ImageIcon icon_normal = new ImageIcon("./image/normal.png");
            JLabel label_normal = new JLabel(new ImageIcon(icon_normal.getImage().getScaledInstance(240,240,icon_normal.getImage().SCALE_SMOOTH)));
            Border O = BorderFactory.createLineBorder(Color.BLACK,2);
            Border I = BorderFactory.createEmptyBorder(-2,0,0,0);
            pic_of_feeling.setBorder(BorderFactory.createCompoundBorder(O, I));
            pic_of_feeling.add(label_sick);
            frame.add(pic_of_feeling);
            
            // importข้อความ
            JPanel panel_text_feeling = new JPanel();
            Font font_text= new Font("Tahoma",Font.BOLD,20);
            panel_text_feeling.setBounds(1000,301 , 250, 350);
            panel_text_feeling.setLayout(new FlowLayout());
            panel_text_feeling.setBorder(BorderFactory.createCompoundBorder(O, I));
            JLabel label_text_feeling = new JLabel();
            label_text_feeling.setFont(font_text);
            label_text_feeling.setText("<html><div style='text-align: left;'>ปริมาณฝุ่น "+ 5 + "%<br>ประชากกรทั้งหมด"+100+" คน<br>ประชากรที่สุขภาพดี "+99+" คน<br>ประชากรที่ป่วย "+1+" คน<br>ร้อยละคนป่วย "+1+"%</div></html>");
            label_text_feeling.setVerticalAlignment(JLabel.CENTER);
            label_text_feeling.setHorizontalAlignment(JLabel.LEFT);
            panel_text_feeling.add(label_text_feeling);
            frame.add(panel_text_feeling);



            // navbar
            JPanel navbar = new JPanel();
            navbar.setBounds(-1, 0,1280,40);
            navbar.setBorder(new LineBorder(new Color(0,0,0)));
            navbar.setLayout(null);

            JButton btnBack = new JButton("Back");
            btnBack.setBounds(5,5,100,30);
            btnBack.setCursor(new Cursor(HAND_CURSOR));

            JButton openFile = new JButton("open file");
            openFile.setBounds(300,5,100,30);
            JButton saveFile = new JButton("save");
            saveFile.setBounds(410,5,100,30);
            JButton clearFile = new JButton("clear");
            clearFile.setBounds(520,5,100,30);

            ImageIcon iconRain = new ImageIcon("./image/rain.png");
            JButton clickRain = new JButton(new ImageIcon(iconRain.getImage().getScaledInstance(120,30,iconRain.getImage().SCALE_SMOOTH)));
            clickRain.setBounds(950,5,120,30);
            ImageIcon iconRandomRaid = new ImageIcon("./image/randomrain.png");
            JButton RandomkRain = new JButton(new ImageIcon(iconRandomRaid.getImage().getScaledInstance(120,30,iconRandomRaid.getImage().SCALE_SMOOTH)));
            RandomkRain.setBounds(1100,5,120,30);
            
            //clickRain Action
            clickRain.addActionListener(new ActionListener(){
                private int chk = 0;
                public void actionPerformed(ActionEvent cr)
                {
                    if(chk == 0)
                    {
                        chk = 1;
                        frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        chkstate = 101;
                    }
                    else
                    {
                        chk = 0;
                        frame.setCursor(Cursor.getDefaultCursor());
                        chkstate = 102;
                    }
                }
            });

            navbar.add(openFile);
            navbar.add(saveFile);
            navbar.add(clearFile);
            navbar.add(clickRain);
            navbar.add(RandomkRain);
            navbar.add(btnBack);
            // ข้อมูลด้านใน
            JPanel panelDatas = new JPanel();
            panelDatas.setBounds(10, 50, 980, 600);
            // panelDatas.setBackground(new Color(0, 255, 50));
            panelDatas.setBorder(new LineBorder(Color.BLACK));
            panelDatas.setLayout(new GridLayout(datas.size(),datas.get(0).size()));
            for(int i=0;i<datas.size();i++){
                JPanel rowDatas = new JPanel();
                rowDatas.setLayout(new GridLayout());
                for(int j=0;j<datas.get(i).size();j++){
                    JButton button = new JButton();
                    button.setBounds(0,0,50,50);
                    button.setCursor(new Cursor(HAND_CURSOR));
                    button.setBackground(methods.getColor(methods.CaladerPerSen((float)datas.get(i).get(j))));
                    button.putClientProperty("row",i);
                    button.putClientProperty("col",j);
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JButton sourceButton = (JButton) e.getSource();
                            int row = (int) sourceButton.getClientProperty("row");
                            int col = (int) sourceButton.getClientProperty("col");
                            if(chkstate == 101)
                            {
                                
                            }
                             //methods.add_score(datas,row,col);
                            // System.out.println(row+"_"+col);
                        }
                    });
                    rowDatas.add(button);
                }
                panelDatas.add(rowDatas);
            }
            frame.add(navbar);
            frame.add(panelDatas);
            frame.setVisible(true);
        });
    }//end of Main
}

class About_Methods {
    void setDatas(ArrayList<ArrayList<Float>>datas,JPanel panelDatas){
        About_Methods methods = new About_Methods();
        for(int i=0;i<datas.size();i++){
            JPanel rowDatas = new JPanel();
            rowDatas.setLayout(new GridLayout());
            for(int j=0;j<datas.get(i).size();j++){
                JButton button = new JButton();
                button.setBounds(0,0,50,50);
                button.setBackground(methods.getColor(methods.CaladerPerSen((float)datas.get(i).get(j))));
                button.putClientProperty("row",i);
                button.putClientProperty("col",j);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton sourceButton = (JButton) e.getSource();
                        int row = (int) sourceButton.getClientProperty("row");
                        int col = (int) sourceButton.getClientProperty("col");
                        // System.out.println(datas.get(row).get(col));
                        methods.add_score(datas,row,col);
                    }
                });
                // JButton clearButton = new JButton("Clear Panel");
                // clearButton.addActionListener(e -> {
                //     panelDatas.removeAll();  // Remove all components from the panel
                //     panelDatas.revalidate();  // Revalidate the panel to refresh the layout
                //     panelDatas.repaint();     // Repaint the panel to update the UI
                // });
                rowDatas.add(button);
            }
            panelDatas.add(rowDatas);
        }
    }
    
    Color getColor(float persen){
        if(persen>30){
            return new Color(178,0,0);
        }else if(persen>20){
            return new Color(255,61,0);
        }else if(persen>10){
            return new Color(208,212,5);
        }else{
            return new Color(0,178,28);
        }
    }
    float CaladerPerSen(float data){
        float persen = 0;
        if(data<=50){
            persen = (float)((float)(data-0)/(50-0))*(9-0)+0;
        }else if(data<=100){    
            persen = (float)((float)(data-51)/(100-51))*(19-10)+10;
        }else if(data<=150){    
            persen = (float)((float)(data-101)/(150-100))*(29-20)+20;
        }else{
            persen = (float)((float)(data-151)/(500-101))*(100-30)+30;
        }  
        return persen;
    }
    void add_score(ArrayList<ArrayList<Float>>datas,int x,int y){
        ArrayList<ArrayList<Float>>lists = new ArrayList<ArrayList<Float>>();
        // on data
        if (x-1>=0) {
            ArrayList<Float>on = new ArrayList<Float>();
            if (y-1>=0) {
                on.add((Float)datas.get(x-1).get(y-1));
            }
            on.add((Float)datas.get(x-1).get(y));
            if (y+1<=19) {
                on.add((Float)datas.get(x-1).get(y+1));
            }
            lists.add(on);
        }
        // center data
        ArrayList<Float>center = new ArrayList<Float>();
        if (y-1>=0) {
            center.add((Float)datas.get(x).get(y-1));
        }
        center.add((Float)datas.get(x).get(y));
        if (y+1<=19) {
            center.add((Float)datas.get(x).get(y+1));
        }
        lists.add(center);
        // under data
        if(x>=0 && x+1<=9) {
            ArrayList<Float>under = new ArrayList<Float>();
            if (y-1>=0) {
                under.add((Float)datas.get(x+1).get(y-1));
            }
            under.add((Float)datas.get(x+1).get(y));
            if (y+1<=19) {
                under.add((Float)datas.get(x+1).get(y+1));
            }
            lists.add(under);
        }
        for(ArrayList<Float>i : lists){
            System.out.println(i);
        }
    }
}