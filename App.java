// class แม่ของโปรแกรมรับหน้าที่เปลี่ยนหน้าต่าง
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
public class App extends JFrame{
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ShowDatas showDatas;
    // คอนซักเตอร์ รับ titlez แสดงที่หัวโปรแกรม
    App(String title){
        cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);
        setTitle(title);
        setBounds(50,50,1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("./image/Icon.jpg"));
        add(this.mainPanel);
        setResizable(false);
        setVisible(true);
    }
    // เมธอดเพิ่มหน้าต่าง รับพารามิเตอร์ JPanel,ชื่อหน้าต่าง เพิ่มหน้าที่ต้องการเปลี่ยนและเส้นทางในการเปลี่ยนหน้าต่าง
    void addPanel(JPanel panel,String path){
        this.mainPanel.add(panel, path);
    }
    // เมธอดแสดงหน้าต่าง รับพารามิเตอร์ path(String) เพื่อเปลี่ยนหน้าต่างที่ต้องการ ตามที่เพิ่มเข้าไปในเมธอด addPenel
    void showPanel(String path){
        this.cardLayout.show(this.mainPanel,path);
    }
    void setShowDatasClass(ShowDatas showDatas){
        this.showDatas = showDatas;
    }
    ShowDatas geShowDatas(){
        return this.showDatas;
    }
}