import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class StartPage extends JPanel{
    StartPage(App app){
        // setLayout(new GridLayout(3,1));
        setLayout(null);
        ShowDatas showDatas = new ShowDatas(app);
        ShowStatusArea showStatusArea = new ShowStatusArea(app);
        Navbar navbar = new Navbar(app,showDatas);
        // showDatas.readFile();
        // showDatas.setDatas();
        // showStatusArea.clickArea();
        add(navbar);
        add(showDatas);
        add(showStatusArea);
    }
}

class Navbar extends JPanel{
    Navbar(App app,ShowDatas showDatas){
        setBounds(-1, 0,1280,40);
        setBorder(new LineBorder(new Color(0,0,0)));
        setLayout(null);

        // JButton btnBack = new JButton("Back");
        ButtonPink btnBack = new ButtonPink("Back",1,1,1,1);
        btnBack.addActionListener(e->{app.showPanel("menu");});
        btnBack.setBounds(5,5,100,30);
        // btnBack.setCursor(new Cursor(JFrame.HAND_CURSOR));

        // JButton openFile = new JButton("open file");
        ButtonPink openFile = new ButtonPink("open file",1,1,1,1);
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
                    // JOptionPane.showMessageDialog(null, "Selected file: " + selectedFile.getAbsolutePath());
                    showDatas.readFile(selectedFile.getAbsolutePath());
                    showDatas.setDatas();
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
        ImageIcon iconRandomRaid = new ImageIcon("./image/randomrain.png");
        JButton RandomkRain = new JButton(new ImageIcon(iconRandomRaid.getImage().getScaledInstance(120,30,iconRandomRaid.getImage().SCALE_SMOOTH)));
        RandomkRain.setBounds(1100,5,120,30);
        //clickRain Action
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
}

class ShowDatas extends JPanel{
    public ArrayList <ArrayList<Float>> datas = new ArrayList<ArrayList<Float>>();
    public int chkstate = 0;
    ShowDatas(App app){}
    void setDatas(){
        About_Methods methods = new About_Methods();
        removeAll();
        setBounds(10, 50, 980, 600);
        setBorder(new LineBorder(Color.BLACK));
        setLayout(new GridLayout(this.datas.size(),this.datas.get(0).size()));
        for(int i=0;i<this.datas.size();i++){
            JPanel rowDatas = new JPanel();
            rowDatas.setLayout(new GridLayout());
            for(int j=0;j<this.datas.get(i).size();j++){
                JButton button = new JButton();
                button.setBounds(0,0,50,50);
                // button.setCursor(new Cursor(JFrame.HAND_CURSOR));
                button.setBackground(methods.getColor(methods.CaladerPerSen((float)this.datas.get(i).get(j))));
                button.putClientProperty("row",i);
                button.putClientProperty("col",j);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton sourceButton = (JButton) e.getSource();
                        int row = (int) sourceButton.getClientProperty("row");
                        int col = (int) sourceButton.getClientProperty("col");
                        if(chkstate == 101)
                        {
                            System.out.println(datas.get(row).get(col));
                            System.out.println(datas);
                        }
                        methods.add_score(datas,row,col);
                        // System.out.println(row+"_"+col);
                    }
                });
                rowDatas.add(button);
            }
            add(rowDatas);
        }
        revalidate();
        repaint();
    }
    void readFile(String path){
        try {
            // Scanner readFile = new Scanner(new File("./pm2.5.txt"));
            Scanner readFile = new Scanner(new File(path));
            while (readFile.hasNext()) {
                ArrayList <Float> datas_row = new ArrayList<Float>();
                for (String i:readFile.nextLine().split("\t")) {
                    float f=Float.parseFloat(i); 
                    datas_row.add(f);
                }
                datas.add(datas_row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ShowStatusArea extends JPanel{
    ShowStatusArea(App app){
        setBounds(1000, 50, 250, 600);
        setBorder(new LineBorder(Color.BLACK));

        ImageIcon icon_happy = new ImageIcon("./image/happy.png");
        JLabel label_happy = new JLabel(new ImageIcon(icon_happy.getImage().getScaledInstance(240,240,icon_happy.getImage().SCALE_SMOOTH)));
        ImageIcon icon_sad = new ImageIcon("./image/sad.png");
        
        JLabel label_sad = new JLabel(new ImageIcon(icon_sad.getImage().getScaledInstance(240,240,icon_sad.getImage().SCALE_SMOOTH)));
        ImageIcon icon_sick = new ImageIcon("./image/sick.png");
        
        JLabel label_sick = new JLabel(new ImageIcon(icon_sick.getImage().getScaledInstance(240,240,icon_sick.getImage().SCALE_SMOOTH)));
        ImageIcon icon_normal = new ImageIcon("./image/normal.png");
        
        JLabel label_normal = new JLabel(new ImageIcon(icon_normal.getImage().getScaledInstance(240,240,icon_normal.getImage().SCALE_SMOOTH)));
        add(label_normal);
        
        // importข้อความ
        Font font1= new Font("Tahoma",Font.BOLD,20);
        JLabel label_text_feeling = new JLabel("<html><div style='text-align: start;width:180px;'>Pm2.5 "+ 5 + "%<br>People"+100+"<br>Healthy population "+99+"<br>Sick population "+1+"<br>Percentage of sick people "+1+"%</div></html>");
      
        add(label_text_feeling);
    }
    void clickAreas(){
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
        add(pic_of_feeling);
        
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
        add(panel_text_feeling);
    }
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