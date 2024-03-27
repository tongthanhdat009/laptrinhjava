package laptrinhjava.src;

import javax.swing.*;
import java.awt.*;

public class admin{
    private JFrame adminFrame = new JFrame("Quản lý SGU Gym");
    private final int width = 1600;
    private final int height = 900;
    //loading
    private JPanel loadingPanel = new JPanel();
    private JProgressBar pBar = new JProgressBar();
    private JLabel pBarLabel = new JLabel("Loading");

    //main
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
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
        mainPanel.setLayout(null);
    
        //left panel
        leftPanel.setBounds(0,0,(int)(width * 0.3),height);
        leftPanel.setBackground(Color.RED);
    
        JLabel leftLabel = new JLabel("Quản lý");
        leftLabel.setFont(new java.awt.Font("Times New Roman", 1, 50));
        
        leftPanel.add(leftLabel);
        //right panel
        rightPanel.setBounds((int)(width * 0.3),0,(int)(width * 0.7),height);
        
        //thêm thuộc tính
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        // adminFrame.add(loadingPanel);
        adminFrame.add(mainPanel);
        adminFrame.setVisible(true);
        
        //hàm chạy load
        // fill();
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