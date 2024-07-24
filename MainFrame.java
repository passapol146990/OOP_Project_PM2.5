import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // สร้างแผงหน้าเมนู
        JPanel menuPanel = new JPanel();
        menuPanel.add(new JLabel("Menu Page"));
        JButton goToAboutButton = new JButton("Go to About");
        JButton goToStartButton = new JButton("Go to Start");
        menuPanel.add(goToAboutButton);
        menuPanel.add(goToStartButton);

        // สร้างแผงหน้า about
        JPanel aboutPanel = new JPanel();
        aboutPanel.add(new JLabel("About Page"));
        JButton backToMenuButton1 = new JButton("Back to Menu");
        aboutPanel.add(backToMenuButton1);

        // สร้างแผงหน้า start
        JPanel startPanel = new JPanel();
        startPanel.add(new JLabel("Start Page"));
        JButton backToMenuButton2 = new JButton("Back to Menu");
        startPanel.add(backToMenuButton2);

        // เพิ่มแผงทั้งหมดลงใน mainPanel
        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(aboutPanel, "About");
        mainPanel.add(startPanel, "Start");

        // ตั้งค่า ActionListener สำหรับปุ่มแต่ละปุ่ม
        goToAboutButton.addActionListener(e -> cardLayout.show(mainPanel, "About"));
        goToStartButton.addActionListener(e -> cardLayout.show(mainPanel, "Start"));
        backToMenuButton1.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        backToMenuButton2.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));

        add(mainPanel);

        setTitle("CardLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
