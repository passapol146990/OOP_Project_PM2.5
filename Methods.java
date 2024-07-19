// import java.awt.*;
// import javax.swing.*;
// public class GUI_setData extends JFrame{
//         public static void main(String[] args) {
//             JFrame frame = new JFrame("start");
//             frame.setLayout(null);
//             frame.setBounds(10, 10, 1280, 720);
//             JButton button = new JButton();
//             frame.add(button);
//             frame.setVisible(true);
//             frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         }
// }

// public class GUI_setData extends JFrame {

//     public GUI_setData() {
//         // ตั้งค่าหน้าต่างหลัก
//         setTitle("start");
//         setLayout(null);
//         setBounds(10, 10, 1280, 720);
//         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//         // สร้าง JTabbedPane
//         JTabbedPane tabbedPane = new JTabbedPane();
//         tabbedPane.setBounds(0, 0, 1280, 100);

//         // สร้าง JPanel สำหรับปุ่มกลับหน้าหลัก
//         JPanel mainPanel = new JPanel();
//         mainPanel.setLayout(null);
//         JButton mainButton = new JButton("Back");
//         mainButton.setBounds(10, 10, 200, 30);
//         mainPanel.add(mainButton);
//         tabbedPane.addTab("menu", mainPanel);

//         // สร้าง JPanel สำหรับปุ่มเปิดไฟล์
//         JPanel openFilePanel = new JPanel();
//         openFilePanel.setLayout(null);
//         JButton openFileButton = new JButton("openfile .txt");
//         openFileButton.setBounds(10, 10, 200, 30);
//         openFilePanel.add(openFileButton);
//         tabbedPane.addTab("open file", openFilePanel);

//         // เพิ่ม JTabbedPane ลงใน JFrame
//         add(tabbedPane);

//         // สร้าง JTextArea สำหรับแสดงข้อมูลจากไฟล์
//         JTextArea textArea = new JTextArea();
//         textArea.setBounds(0, 100, 1280, 620);
//         add(textArea);

//         // ตั้งค่า ActionListener สำหรับปุ่มเปิดไฟล์
        // openFileButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         JFileChooser fileChooser = new JFileChooser();
        //         int result = fileChooser.showOpenDialog(null);
        //         if (result == JFileChooser.APPROVE_OPTION) {
        //             File selectedFile = fileChooser.getSelectedFile();
        //             try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
        //                 String line;
        //                 StringBuilder content = new StringBuilder();
        //                 while ((line = reader.readLine()) != null) {
        //                     content.append(line).append("\n");
        //                 }
        //                 textArea.setText(content.toString());
        //             } catch (IOException ex) {
        //                 ex.printStackTrace();
        //             }
        //         }
        //     }
        // });
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             GUI_setData frame = new GUI_setData();
//             frame.setVisible(true);
//         });
//     }
// }

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
class GUI_setData extends JFrame{
    static ArrayList <ArrayList<Float>> datas = new ArrayList<ArrayList<Float>>();
    public static void main(String[] args) {
        try {
            Scanner readFile = new Scanner(new File("./pm2.5.txt"));
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
        // System.out.println(datas);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setTitle("set Data");
            frame.setLayout(null);
            frame.setBounds(50,50, 1280,720);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //สำหรับปิด หน้าต่างแล้วจะปิดการทำงานของโปรแกรมไปเลย
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./bg.jpg"));
    
            JPanel panelDatas = new JPanel();
            panelDatas.setBounds(10, 50, 980, 600);
            // panelDatas.setBackground(new Color(0, 255, 50));
            panelDatas.setBorder(new LineBorder(Color.BLACK));
            panelDatas.setLayout(new GridLayout(datas.size(),datas.get(0).size()));
            Methods methods = new Methods();
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
                    rowDatas.add(button);
                }
                panelDatas.add(rowDatas);
            }
            frame.add(panelDatas);
            frame.setVisible(true);
        });
    }
}
public class Methods {
    Methods methods = new Methods();
    void setDatas(ArrayList<ArrayList<Float>>datas,JPanel panelDatas){
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
        if(x+1<=19) {
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