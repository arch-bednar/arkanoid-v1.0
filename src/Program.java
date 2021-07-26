import arkanoid.*;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Program {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int)screenSize.getWidth();
                int height = (int)screenSize.getHeight();

                width = (int)(width*0.375);
                height = (int)(height*0.375);

                Window window = new Window();
                window.initTiles(600, 400);
                JFrame panel = new JFrame();
                panel.add(window);

                panel.setTitle("Test grafiki");
                //panel.setSize(width, height);
                panel.setSize(600, 400);
                panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                panel.setVisible(true);
            }
        });
    }
}
