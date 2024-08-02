// หน้าสำหรับการทำงาน starting ระบบต่างๆ ฝนหลวง เปิดไฟล์
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.border.Border;

class PageStart extends JPanel{
    PageStart(App app){
        setLayout(null);
        ShowDatas showDatas = new ShowDatas(app);
        ShowStatusArea showStatusArea = new ShowStatusArea(app);
        InputPeople inputPeople = new InputPeople();
        CPN_Navbar navbar = new CPN_Navbar(app,showDatas);
        add(navbar);
        add(showDatas);
        add(showStatusArea);
        add(inputPeople);
    }
}

class ShowDatas extends JPanel{
    public float[][] datas;//ArrayList <ArrayList<Float>> datas = new ArrayList<ArrayList<Float>>()
    public int chkstate = 0;
    ShowDatas(App app){}
    void setDatas(){
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
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton sourceButton = (JButton) e.getSource();
                        int row = (int) sourceButton.getClientProperty("row");
                        int col = (int) sourceButton.getClientProperty("col");
                        if(chkstate == 101)
                        {
                            System.out.println(datas[row][col]);
                            System.out.println(datas);
                        }
                        methods.add_score(datas,row,col);
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
            Scanner readFile = new Scanner(new File(path));
            //this.datas.clear();
            ArrayList<float[]> tempData = new ArrayList<>();
            while (readFile.hasNext()) {
                String[] line = readFile.nextLine().split("\t");
                float[] datas_row = new float[line.length];
                for (int i = 0; i < line.length; i++) {
                    datas_row[i] = Float.parseFloat(line[i]);
                }
                tempData.add(datas_row);
            }
            datas = tempData.toArray(new float[tempData.size()][]);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ShowStatusArea extends JPanel{
    ShowStatusArea(App app){
        setBounds(1000, 50, 250, 500);
        setBorder(new LineBorder(Color.BLACK));

        // ImageIcon icon_happy = new ImageIcon("./image/happy.png");
        // JLabel label_happy = new JLabel(new ImageIcon(icon_happy.getImage().getScaledInstance(240,240,icon_happy.getImage().SCALE_SMOOTH)));
        // ImageIcon icon_sad = new ImageIcon("./image/sad.png");
        
        // JLabel label_sad = new JLabel(new ImageIcon(icon_sad.getImage().getScaledInstance(240,240,icon_sad.getImage().SCALE_SMOOTH)));
        // ImageIcon icon_sick = new ImageIcon("./image/sick.png");
        
        // JLabel label_sick = new JLabel(new ImageIcon(icon_sick.getImage().getScaledInstance(240,240,icon_sick.getImage().SCALE_SMOOTH)));
        // ImageIcon icon_normal = new ImageIcon("./image/normal.png");
        
        // JLabel label_normal = new JLabel(new ImageIcon(icon_normal.getImage().getScaledInstance(240,240,icon_normal.getImage().SCALE_SMOOTH)));
        // add(label_normal);
        
        // // importข้อความ
        // Font font1= new Font("Tahoma",Font.BOLD,20);
        // JLabel label_text_feeling = new JLabel("<html><div style='text-align: start;width:180px;'>Pm2.5 "+ 5 + "%<br>People"+100+"<br>Healthy population "+99+"<br>Sick population "+1+"<br>Percentage of sick people "+1+"%</div></html>");
      
        // add(label_text_feeling);
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

class InputPeople extends JPanel{
    InputPeople(){
        setBounds(1000, 570, 250, 100);
        setBorder(new LineBorder(Color.BLACK));
        JLabel title = new JLabel("ประชากรระหว่าง");
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        add(title);

        JTextField inputMin = new JTextField();
        add(inputMin);
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