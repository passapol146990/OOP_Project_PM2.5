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
//         openFileButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 JFileChooser fileChooser = new JFileChooser();
//                 int result = fileChooser.showOpenDialog(null);
//                 if (result == JFileChooser.APPROVE_OPTION) {
//                     File selectedFile = fileChooser.getSelectedFile();
//                     try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
//                         String line;
//                         StringBuilder content = new StringBuilder();
//                         while ((line = reader.readLine()) != null) {
//                             content.append(line).append("\n");
//                         }
//                         textArea.setText(content.toString());
//                     } catch (IOException ex) {
//                         ex.printStackTrace();
//                     }
//                 }
//             }
//         });
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
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * GUI_setData
 */
class GUI_setData extends JFrame{
    static ArrayList <ArrayList> datas = new ArrayList<ArrayList>();
    public GUI_setData(String title){
        setTitle(title);
        setBounds(50,50, 1280,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // try {
        //     Scanner rf = new Scanner(new File("./pm2.5.txt"));
        //     while (rf.hasNext()) {
        //         ArrayList <Float> datas_row = new ArrayList<Float>();
        //         for (String i:rf.nextLine().split("\t")) {
        //             float f=Float.parseFloat(i); 
        //             datas_row.add(f);
        //         }
        //         datas.add(datas_row);
        //     }
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        // // System.out.println(datas);
        // SwingUtilities.invokeLater(() -> {
        //     JFrame frame = new JFrame();
        //     frame.setTitle("set Data");
        //     frame.setLayout(null);
        //     frame.setBounds(50,50, 1280,720);
        //     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //สำหรับปิด หน้าต่างแล้วจะปิดการทำงานของโปรแกรมไปเลย
        //     frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./bg.jpg"));
    
        //     JPanel panelDatas = new JPanel();
        //     panelDatas.setBounds(10, 50, 980, 600);
        //     // panelDatas.setBackground(new Color(0, 255, 50));
        //     panelDatas.setBorder(new LineBorder(Color.BLACK));
        //     panelDatas.setLayout(new GridLayout(datas.size(),datas.get(0).size()));
        //     for(int i=0;i<datas.size();i++){
        //         JPanel rowDatas = new JPanel();
        //         rowDatas.setLayout(new GridLayout());
        //         for(int j=0;j<datas.get(i).size();j++){
        //             JButton button = new JButton();
        //             button.setBounds(0,0,50,50);
        //             button.setBackground(new Color(255,0,0));
        //             rowDatas.add(button);
        //         }
        //         panelDatas.add(rowDatas);
        //     }

        //     frame.add(panelDatas);
        //     frame.setVisible(true);
        // });
        Methods methods = new Methods();
        System.out.println(methods.CaladerPerSen(100));
    }
}
public class Methods {
    static Color getColor(int data){
        Color color = new Color(0,0,0);
          
        return color;
    }
    static float CaladerPerSen(float data){
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
}