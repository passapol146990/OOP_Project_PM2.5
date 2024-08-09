// หน้าสำหรับการทำงาน starting ระบบต่างๆ ฝนหลวง เปิดไฟล์
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import javax.swing.border.Border;

class PageStart extends JPanel{
    PageStart(App app){
        setLayout(null);
    }

    void setBodyStart(App app){
        DataBase db = new DataBase();
        ShowStatusArea showStatusArea = new ShowStatusArea(app);
        InputPeople inputPeople = new InputPeople(db);
        ShowDatas showDatas = new ShowDatas(app,showStatusArea);
        CPN_Navbar navbar = new CPN_Navbar(app,db,showDatas);
        db.setShowDatasClass(showDatas);
        showDatas.setDataBaseClass(db);
        app.setShowDatasClass(showDatas);//ให้ทำงานเมื่อมีการกดปุ่มที่ Start
        app.geShowDatas().setDatas();
        add(navbar);
        add(showDatas);
        add(showStatusArea);
        add(inputPeople);
    }
}

class ShowDatas extends JPanel{
    private boolean checkstateClickRain = false;
    public int chkstate = 0;
    private ShowStatusArea showStatusArea;
    private DataBase db;
    
    ShowDatas(App app){}
    void setClickRainStatus(boolean chk){
        this.checkstateClickRain = chk;
    }
    ShowDatas(App app, ShowStatusArea showStatusArea){
        this.showStatusArea = showStatusArea;
    }
    void setDataBaseClass(DataBase db){
        this.db = db;
    }
    void setDatas(){
        float[][] datas = this.db.getDatas();
        About_Methods methods = new About_Methods();
        removeAll();
        setBounds(10, 50, 980, 600);
        setBorder(new LineBorder(Color.BLACK));
        setLayout(new GridLayout(datas.length, datas[0].length));
        for(int i=0;i<datas.length;i++){
            JPanel rowDatas = new JPanel();
            rowDatas.setLayout(new GridLayout());
            for(int j=0;j<datas[i].length;j++){
                JButton button = new JButton();
                button.setBounds(0,0,50,50);
                button.setBackground(methods.getColor(methods.CaladerPerSen((float)datas[i][j])));
                button.putClientProperty("row",i);
                button.putClientProperty("col",j);
                button.putClientProperty("people",db.getRandomPeople());
                button.putClientProperty("persen",methods.CaladerPerSen((float)datas[i][j]));
                button.addActionListener(e->{
                    JButton sourceButton = (JButton) e.getSource();
                    int row = (int) sourceButton.getClientProperty("row");
                    int col = (int) sourceButton.getClientProperty("col");
                    // กดฝนหลวง
                    if(checkstateClickRain){
                        db.rainClick(row,col);
                        checkstateClickRain = false;
                    }else{
                        float persen = (float)sourceButton.getClientProperty("persen");
                        int people = (int)sourceButton.getClientProperty("people");
                        this.showStatusArea.set_status(persen,people,this.db,row,col);
                    }
                });
                rowDatas.add(button);
            }
            add(rowDatas);
        }
        revalidate();
        repaint();
    }
}

class ShowStatusArea extends JPanel{
    ShowStatusArea(App app){
        setBounds(1000, 50, 250, 500);
        setBorder(new LineBorder(Color.BLACK));
    }
    void set_status(float persen,int people,DataBase db,int row,int col){
        float[][] datas = db.getDatas();
        Border O = BorderFactory.createLineBorder(Color.BLACK,2);
        Border I = BorderFactory.createEmptyBorder(-2,0,0,-5);
        JPanel pic_of_feeling = new JPanel();
        pic_of_feeling.setLayout(new FlowLayout());
        pic_of_feeling.setBounds(1000,50 , 250, 250);
        //อธิบาย ค่าสี
        JPanel panel_guide = new JPanel(new FlowLayout(FlowLayout.TRAILING,5,5));
        panel_guide.setPreferredSize(new Dimension(230,180));
        panel_guide.setBackground(new Color(255,192,203));
        //panel guide เล็กแต่ละสี
        JPanel panel_guide_red = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_guide_red.setPreferredSize(new Dimension(220,29));
        panel_guide_red.setBackground(new Color(255,255,255));
        JPanel panel_guide_orange = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_guide_orange.setPreferredSize(new Dimension(220,29));
        panel_guide_orange.setBackground(new Color(255,255,255));
        JPanel panel_guide_yellow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_guide_yellow.setPreferredSize(new Dimension(220,29));
        panel_guide_yellow.setBackground(new Color(255,255,255));
        JPanel panel_guide_green = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_guide_green.setPreferredSize(new Dimension(220,29));
        panel_guide_green.setBackground(new Color(255,255,255));
        JPanel panel_guide_grey = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_guide_grey.setPreferredSize(new Dimension(220,29));
        panel_guide_grey.setBackground(new Color(255,255,255));
        // สี
        JPanel color_red = new JPanel();
        color_red.setPreferredSize(new Dimension(20,30));
        color_red.setBackground(new Color(178,0,0));
        JPanel color_orange = new JPanel();
        color_orange.setPreferredSize(new Dimension(20,30));
        color_orange.setBackground(new Color(255,61,0));
        JPanel color_yellow = new JPanel();
        color_yellow.setPreferredSize(new Dimension(20,30));
        color_yellow.setBackground(new Color(208,212,5));
        JPanel color_green = new JPanel();
        color_green.setPreferredSize(new Dimension(20,30));
        color_green.setBackground(new Color(0,178,28));
        JPanel color_grey = new JPanel();
        color_grey.setPreferredSize(new Dimension(20,30));
        color_grey.setBackground(new Color(192, 192, 192));
        // ข้อความ guide
        Font font_guide= new Font("Tahoma",Font.BOLD,15);
        JLabel label_text_red = new JLabel();
        label_text_red.setFont(font_guide);
        label_text_red.setText("มากกว่า 30%");
        JLabel label_text_orange = new JLabel();
        label_text_orange.setFont(font_guide);
        label_text_orange.setText("ตั้งแต่ 20-29%");
        JLabel label_text_yellow = new JLabel();
        label_text_yellow.setFont(font_guide);
        label_text_yellow.setText("ตั้งแต่ 10-19%");
        JLabel label_text_green = new JLabel();
        label_text_green.setFont(font_guide);
        label_text_green.setText("ตั้งแต่ 0-9%");
        JLabel label_text_grey = new JLabel();
        label_text_grey.setFont(font_guide);
        label_text_grey.setText("เป็นฝุ่นที่ติดลบ");
        
        // addเข้าpanel แต่ละสี
        panel_guide_red.add(color_red);
        panel_guide_red.add(label_text_red);
        panel_guide_orange.add(color_orange);
        panel_guide_orange.add(label_text_orange);
        panel_guide_yellow.add(color_yellow);
        panel_guide_yellow.add(label_text_yellow);
        panel_guide_green.add(color_green);
        panel_guide_green.add(label_text_green);
        panel_guide_grey.add(color_grey);
        panel_guide_grey.add(label_text_grey);
        // addเข้าpanel guide
        panel_guide.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel_guide.add(panel_guide_red);
        panel_guide.add(panel_guide_orange);
        panel_guide.add(panel_guide_yellow);
        panel_guide.add(panel_guide_green);
        panel_guide.add(panel_guide_grey);
        
        
        JPanel panel_text_feeling = new JPanel(new FlowLayout(FlowLayout.TRAILING,5,5));
        Font font_text= new Font("Tahoma",Font.BOLD,15);
        panel_text_feeling.setPreferredSize(new Dimension(250,120));
        panel_text_feeling.setLayout(new FlowLayout());
        panel_text_feeling.setBorder(BorderFactory.createCompoundBorder(O, I));
        panel_text_feeling.setBackground(getBackground());
        //ข้อความ
        JLabel label_text_feeling = new JLabel();
        label_text_feeling.setFont(font_text);
        //คำนวณค่าประชากร
        String formatted = String.format("%.2f", persen);
        int sick_people = (int)(people*persen)/100;
        int good_people = people-sick_people;
        float pm = (float)datas[row][col];
        label_text_feeling.setText("<html><div style='text-align: left;'>ปริมาณฝุ่น "+pm+ "<br>ประชากกรทั้งหมด"+people+" คน<br>ประชากรที่สุขภาพดี "+good_people+" คน<br>ประชากรที่ป่วย "+sick_people+" คน<br>ร้อยละคนป่วย "+formatted+"%</div></html>");
        label_text_feeling.setVerticalAlignment(JLabel.CENTER);
        label_text_feeling.setHorizontalAlignment(JLabel.LEFT);
        removeAll();
        if (persen >= 30 ){
            ImageIcon icon_sick = new ImageIcon("./image/sick.png");
            JLabel label_sick = new JLabel(new ImageIcon(icon_sick.getImage().getScaledInstance(150,150,icon_sick.getImage().SCALE_SMOOTH)));
            pic_of_feeling.add(label_sick);
        }else if (persen >= 20){
            ImageIcon icon_sad = new ImageIcon("./image/sad.png");
            JLabel label_sad = new JLabel(new ImageIcon(icon_sad.getImage().getScaledInstance(150,150,icon_sad.getImage().SCALE_SMOOTH)));
            pic_of_feeling.add(label_sad);
        }else if (persen >= 10){
            ImageIcon icon_normal = new ImageIcon("./image/normal.png");
            JLabel label_normal = new JLabel(new ImageIcon(icon_normal.getImage().getScaledInstance(150,150,icon_normal.getImage().SCALE_SMOOTH)));
            pic_of_feeling.add(label_normal);
        }else if (persen >= 0){
            ImageIcon icon_happy = new ImageIcon("./image/happy.png");
            JLabel label_happy = new JLabel(new ImageIcon(icon_happy.getImage().getScaledInstance(150,150,icon_happy.getImage().SCALE_SMOOTH)));
            pic_of_feeling.add(label_happy);
        }else{
            ImageIcon icon_nothing = new ImageIcon("./image/nothing.png");
            JLabel label_nothing= new JLabel(new ImageIcon(icon_nothing.getImage().getScaledInstance(150,150,icon_nothing.getImage().SCALE_SMOOTH)));
            pic_of_feeling.add(label_nothing);
            label_text_feeling.setText("<html><div style='text-align: left;'>ปริมาณฝุ่น "+0 + "<br>ประชากกรทั้งหมด"+0+" คน<br>ประชากรที่สุขภาพดี "+0+" คน<br>ประชากรที่ป่วย "+0+" คน<br>ร้อยละคนป่วย "+0+"%</div></html>");
        }
        panel_text_feeling.add(label_text_feeling);
        add(pic_of_feeling);
        add(panel_text_feeling);
        add(panel_guide);
        revalidate();
        repaint();
        
    }
}

class InputPeople extends JPanel{
    InputPeople(DataBase db){
        setBounds(1000, 570, 250, 100);
        setBorder(new LineBorder(Color.BLACK));
        setLayout(null);

        JLabel title = new JLabel("ประชากรระหว่าง");
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setBounds(50,0,250,30);
        add(title);

        JTextField inputMin = new JTextField(String.valueOf(db.getMinPeople()));
        inputMin.setBounds(10,40,100,25);
        add(inputMin);
        JLabel label = new JLabel(" - ");
        label.setBounds(115,40,100,25);
        add(label);
        JTextField inputMax = new JTextField(String.valueOf(db.getMaxPeople()));
        inputMax.setBounds(130,40,100,25);
        add(inputMax);
        CPN_ButtonPink save = new CPN_ButtonPink("save",new Color(254,169,169));
        save.setBounds(70,70,100,25);
        add(save);
        save.addActionListener(e->{
            db.setMinMaxPeople(Integer.parseInt(inputMin.getText()), Integer.parseInt(inputMax.getText()));
        });
        // save.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent event) {
        //     }
        // });
        // inputMax.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         String text = inputMin.getText();
        //         System.out.println(text);
        //  60       inputMin.setText("");
        //     }
        // });
    }
}

class About_Methods {
    Color getColor(float persen){
        if(persen>=30){
            return new Color(178,0,0);
        }else if(persen>=20){
            return new Color(255,61,0);
        }else if(persen>=10){
            return new Color(208,212,5);
        }
        else if (persen<0) {
            return new Color(192, 192, 192);
        }
        else{
            return new Color(0,178,28);
        }
    }
    float CaladerPerSen(float data){
        float persen = 0;
        if (data<0) {
            persen = -1;
        }
        else if(data<=50){
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
}