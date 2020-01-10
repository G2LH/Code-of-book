package Singleton;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    String string;
    public MyFrame(String title) {
        setTitle(title);
        Moon moon = Moon.getMoon();  //得到单件类的唯一实例
        string = moon.show();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("宋体", Font.BOLD, 14));
        g.drawString(string, 5, 100);
    }
}
