import java.awt.*;
import javax.swing.*;
public class menu extends JFrame{
        public static void main(String[] args) {
            JFrame frame = new JFrame("GUI");
            frame.setLayout(null);
            frame.setBounds(450, 300, 1280, 720);
            JButton button = new JButton();
            frame.add(button);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
}