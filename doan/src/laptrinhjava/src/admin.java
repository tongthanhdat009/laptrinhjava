package laptrinhjava.src;
import javax.swing.*;
import java.awt.*;

public class admin{
    private JFrame adminFrame = new JFrame("Quản lý SGU Gym");
    private final int width = 1280;
    private final int height = 720;
    private JLabel test = new JLabel("Bất ngờ chưa thằng Lồn");
    //loading
    private JPanel loadingPanel = new JPanel();
    private JProgressBar pBar = new JProgressBar();
    private JLabel pBarLabel = new JLabel("Loading");

    //main
    private JPanel mainPanel = new JPanel();

    public admin(){
        //main frame
        adminFrame.setSize(width, height);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLayout(null);
        adminFrame.getContentPane().setBackground(Color.WHITE);

        //loading
        loadingPanel.setSize(new Dimension(width,height));
        loadingPanel.setLayout(null);

        pBarLabel.setBounds(width/2 - 50,275,300,50);
        pBarLabel.setFont(new java.awt.Font("Arial", 1, 25));
        
        pBar.setValue(0);
        pBar.setBounds(width/2 - 210,height/2 -25,420,50);
        pBar.setStringPainted(true);//thêm % cho thanh tiến trình
        
        loadingPanel.add(pBarLabel);
        loadingPanel.add(pBar);
        
        //main
        mainPanel.setSize(new Dimension(width,height));
        test.setBounds(width/2 - 50,275,300,50);
        test.setFont(new java.awt.Font("Arial", 1, 25));
        mainPanel.setLayout(null);
        mainPanel.add(test);

        adminFrame.add(loadingPanel);
        adminFrame.add(mainPanel);
        adminFrame.setVisible(true);
        
        //hàm chạy load
        fill();
    }
    private void fill(){
        int count = 0;
        while(count<=100){
            pBar.setValue(count);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(count % 3 == 0){
                pBarLabel.setText("Loading.");
            }
            else if(count % 3 == 1){
                pBarLabel.setText("Loading..");
            }
            else{
                pBarLabel.setText("Loading...");
            }
            count+=2;
        }
        pBar.setString("Done!");
        loadingPanel.setVisible(false);
        pBarLabel.setVisible(false);
    }
    public static void main(String[] args){
        new admin();
    }
}