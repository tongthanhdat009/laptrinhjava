import java.awt.*;
import javax.swing.*;

public class progressBar {
    JFrame frame = new JFrame();
    JProgressBar pBar = new JProgressBar();
    progressBar(){
        pBar.setValue(0);
        pBar.setBounds(0,0,420,50);
        pBar.setStringPainted(true);//thêm % cho thanh tiến trình


        frame.add(pBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        
        fill();
    }    
    public void fill(){
        int count = 0;
        while(count<=100){
            pBar.setValue(count);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            count++;
        }
        pBar.setString("Done!");
    }
}
