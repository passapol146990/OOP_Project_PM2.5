import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class Button_1 extends JButton{
    private Image backgroundImage;
    public Button_1(String text,int T,int L,int B,int R) {
        super(text);
        setContentAreaFilled(false);    
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(T, L,B, R));
        setBackground(new Color(254,169,169));
    }
    public Button_1(String text,Image image,int T,int L,int B,int R) {
        super(text);
        this.backgroundImage = image;
        setContentAreaFilled(false);    
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(T, L,B, R));
        setBackground(new Color(254,169,169));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        if(backgroundImage != null)
        {
            g2.drawImage(backgroundImage,0,0,getWidth(),getHeight(),this);
        }
        else{
        // วาดปุ่ม
        if (getModel().isArmed()) {
            g2.setColor(new Color(255,192,203));
        } else {
            g2.setColor(getBackground());
        }
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }
        //วาดขอบ
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

        g2.dispose();
        
        super.paintComponent(g);
    }
     @Override
    public void updateUI() {
        setUI(new BasicButtonUI());
    }
}
