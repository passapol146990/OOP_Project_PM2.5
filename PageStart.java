// หน้าสำหรับการทำงาน starting ระบบต่างๆ ฝนหลวง เปิดไฟล์
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.border.Border;

class PageStart extends JPanel{
    PageStart(App app){
        setLayout(null);
        DataBase db = new DataBase();
        ShowStatusArea showStatusArea = new ShowStatusArea(app);
        InputPeople inputPeople = new InputPeople(db);
        ShowDatas showDatas = new ShowDatas(app,showStatusArea);
        CPN_Navbar navbar = new CPN_Navbar(app,db,showDatas);
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
    public int all_people = 0;
    ShowDatas(App app){}
    void setClickRainStatus(boolean chk){
        this.checkstateClickRain = chk;
    }
    ShowDatas(App app, ShowStatusArea showStatusArea){
        this.showStatusArea = showStatusArea;
    }
    void setDatas(DataBase db){
        float[][] datas = db.getDatas();
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
                int random = db.getRandomPeople();
                button.putClientProperty("people",random);
                button.putClientProperty("persen",methods.CaladerPerSen((float)datas[i][j]));
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton sourceButton = (JButton) e.getSource();
                        int row = (int) sourceButton.getClientProperty("row");
                        int col = (int) sourceButton.getClientProperty("col");
                        int people_random = (int) sourceButton.getClientProperty("people");
                        
                        System.out.println(checkstateClickRain);;
                        if(checkstateClickRain){
                            // กดฝนหลวง
                            // db.rainClick(row,col);
                            // setDatas(db.getDatas());
                            checkstateClickRain = false;
                        }else{
                            // methods.add_score(datas,row,col);
                        }
                        // showStatusArea(sourceButton.getClientProperty("persen"));
                        
                        // if(chkstate == 101)
                        // {
                        //     System.out.println(datas.get(row).get(col));
                        //     System.out.println(datas);
                        // }
                        // methods.add_score(datas,row,col);
                        // show_status.clickAreas();
                        // repaint();
                    }
                });
                button.addActionListener(e->{
                    showStatusArea.set_status((float)((JButton)e.getSource()).getClientProperty("persen"),(int)((JButton)e.getSource()).getClientProperty("people"),db,(int)((JButton)e.getSource()).getClientProperty("row"),(int)((JButton)e.getSource()).getClientProperty("col"));
                    
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
    void set_status(float persen,int people,DataBase db,int row,int col)
    {
        float[][] datas = db.getDatas();
        JPanel pic_of_feeling = new JPanel();
        pic_of_feeling.setLayout(new FlowLayout());
        pic_of_feeling.setBounds(1000,50 , 250, 250);
        ImageIcon icon_happy = new ImageIcon("./image/happy.png");
        JLabel label_happy = new JLabel(new ImageIcon(icon_happy.getImage().getScaledInstance(200,200,icon_happy.getImage().SCALE_SMOOTH)));
        ImageIcon icon_sad = new ImageIcon("./image/sad.png");
        JLabel label_sad = new JLabel(new ImageIcon(icon_sad.getImage().getScaledInstance(200,200,icon_sad.getImage().SCALE_SMOOTH)));
        ImageIcon icon_sick = new ImageIcon("./image/sick.png");
        JLabel label_sick = new JLabel(new ImageIcon(icon_sick.getImage().getScaledInstance(200,200,icon_sick.getImage().SCALE_SMOOTH)));
        ImageIcon icon_normal = new ImageIcon("./image/normal.png");
        JLabel label_normal = new JLabel(new ImageIcon(icon_normal.getImage().getScaledInstance(200,200,icon_normal.getImage().SCALE_SMOOTH)));
        Border O = BorderFactory.createLineBorder(Color.BLACK,2);
        Border I = BorderFactory.createEmptyBorder(-2,0,0,0);
        
        // importข้อความ
        JPanel panel_text_feeling = new JPanel();
        Font font_text= new Font("Tahoma",Font.BOLD,18);
        panel_text_feeling.setBounds(1000,301 , 250, 350);
        panel_text_feeling.setLayout(new FlowLayout());
        panel_text_feeling.setBorder(BorderFactory.createCompoundBorder(O, I));
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
        
        panel_text_feeling.setBackground(getBackground());
        removeAll();
        if (persen >= 30 ) {
           
            pic_of_feeling.add(label_sick);
        }
        else if (persen >= 20 ) {
           
            pic_of_feeling.add(label_sad);
        }
        else if (persen >=10){
            pic_of_feeling.add(label_normal);
        }
        else if (persen >=0){
           
            pic_of_feeling.add(label_happy);
        }
        else{
            
            label_text_feeling.setText("<html><div style='text-align: left;'>ปริมาณฝุ่น "+0 + "<br>ประชากกรทั้งหมด"+0+" คน<br>ประชากรที่สุขภาพดี "+0+" คน<br>ประชากรที่ป่วย "+0+" คน<br>ร้อยละคนป่วย "+0+"%</div></html>");
        }
        panel_text_feeling.add(label_text_feeling);
        add(pic_of_feeling);
        add(panel_text_feeling);
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
    void setDatas(float[][] datas, JPanel panelDatas){
        About_Methods methods = new About_Methods();
        for(int i=0;i<datas.length;i++){
            JPanel rowDatas = new JPanel();
            rowDatas.setLayout(new GridLayout());
            for(int j=0;j<datas[i].length;j++){
                JButton button = new JButton();
                button.setBounds(0,0,50,50);
                button.setBackground(methods.getColor(methods.CaladerPerSen((float)datas[i][j])));
                button.putClientProperty("row",i);
                button.putClientProperty("col",j);
                button.putClientProperty("persen",methods.CaladerPerSen((float)datas[i][j]));
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton sourceButton = (JButton) e.getSource();
                        int row = (int) sourceButton.getClientProperty("row");
                        int col = (int) sourceButton.getClientProperty("col");
                        int persen = (int) sourceButton.getClientProperty("persen");
                        // System.out.println(datas.get(row).get(col));
                        System.out.println(persen);
                        // methods.add_score(datas,row,col);
                        
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
    void add_score(float[][] datas, int x, int y){
        int rows = datas.length;
        int cols = datas[0].length;
        int resultSize = 3; // Size of the result array
        float[][] result = new float[resultSize][resultSize];
    
        // Initialize result array with -1 or any placeholder
        for (int i = 0; i < resultSize; i++) {
            Arrays.fill(result[i], -1); // Use -1 to indicate empty values
        }
    
        // Fill the result array
        int resultRow = 0;
        // on data
        if (x - 1 >= 0) {
            int resultCol = 0;
            if (y - 1 >= 0) result[resultRow][resultCol++] = datas[x - 1][y - 1];
            result[resultRow][resultCol++] = datas[x - 1][y];
            if (y + 1 < cols) result[resultRow][resultCol] = datas[x - 1][y + 1];
            resultRow++;
        }
    
        // center data
        int centerRow = resultRow;
        int centerCol = 0;
        if (y - 1 >= 0) result[centerRow][centerCol++] = datas[x][y - 1];
        result[centerRow][centerCol++] = datas[x][y];
        if (y + 1 < cols) result[centerRow][centerCol] = datas[x][y + 1];
        resultRow++;
    
        // under data
        if (x + 1 < rows) {
            int underRow = resultRow;
            int underCol = 0;
            if (y - 1 >= 0) result[underRow][underCol++] = datas[x + 1][y - 1];
            result[underRow][underCol++] = datas[x + 1][y];
            if (y + 1 < cols) result[underRow][underCol] = datas[x + 1][y + 1];
        }
    
        // Print the result array, skipping -1 values
        for (float[] row : result) {
            boolean hasNonEmptyValue = false;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (float value : row) {
                if (value != -1) {
                    sb.append(value).append(" ");
                    hasNonEmptyValue = true;
                }
            }
            sb.append("]");
            if(hasNonEmptyValue)
            {
                System.out.println(sb.toString());
            }
        }
    }
    // void rainRoyal(ArrayList<ArrayList<Float>>datas,int x,int y){
    //     if (y-1>=0) {
    //             datas.get(x).set(y - 1, (float)datas.get(x).get(y - 1) - 1);
    //         }
    //         datas.get(x).set(y, (float)datas.get(x).get(y) - 1);
    //         if (y+1<=19) {
    //             datas.get(x).set(y + 1, (float)datas.get(x).get(y + 1) - 1);
    //         }
    //         // 
    //         if (x-1>=0) {
    //             if (y-1>=0) {
    //                 datas.get(x - 1).set(y - 1, (float)datas.get(x-1).get(y - 1) - 1);
    //             }
    //             datas.get(x-1).set(y, (float)datas.get(x-1).get(y) - 1);
    //             if (y+1<=19) {
    //                 datas.get(x-1).set(y + 1, (float)datas.get(x-1).get(y + 1) - 1);
    //             }
    //         }
    //         // 
    //         if(x+1<=19) {
    //             if (y-1>=0) {
    //                 datas.get(x+1).set(y - 1, (float)datas.get(x+1).get(y - 1) - 1);
    //             }
    //             datas.get(x+1).set(y, (float)datas.get(x+1).get(y) - 1);
    //             if (y+1<=19) {
    //                 datas.get(x+1).set(y + 1, (float)datas.get(x+1).get(y + 1) - 1);
    //             }
    //         }
    // }
}