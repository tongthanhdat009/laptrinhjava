package laptrinhjava.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class admin{
    private JFrame adminFrame = new JFrame("Quản lý SGU Gym");
    private final int width = 1600;
    private final int height = 900;
    //logo
    ImageIcon logo = new ImageIcon("doan/src/laptrinhjava/src/asset/img/logo.png");
    ImageIcon logo1 = new ImageIcon("doan/src/laptrinhjava/src/asset/img/logo1.png");

    //loading
    private JPanel loadingPanel = new JPanel();
    private JProgressBar pBar = new JProgressBar();
    private JLabel pBarLabel = new JLabel("Loading");

    //main
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    
    // //menu bar
    // private JMenuBar mbar;
    // private JMenuItem loadItem;
    // private JMenuItem saveItem;
    // private JMenuItem exitItem;
    // private JMenu fileMenu;
    // private JMenu editMenu;
    // private JMenu helpMenu;

    public admin(){
        //main frame
        adminFrame.setSize(width, height);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLayout(null);
        adminFrame.getContentPane().setBackground(Color.WHITE);
        adminFrame.setIconImage(logo.getImage());

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

        // //menu bar
        // mbar = new JMenuBar();
        // mbar.setBounds(0,0,500,100);
        // fileMenu = new JMenu("file");
        // editMenu = new JMenu("edit");
        // helpMenu = new JMenu("help");
        // mbar.add(fileMenu);
        // mbar.add(editMenu);
        // mbar.add(helpMenu);

        // loadItem  =  new JMenuItem("Load");
        // saveItem  =  new JMenuItem("save");
        // exitItem  =  new JMenuItem("exit");

        // loadItem.addActionListener(this);
        // saveItem.addActionListener(this);
        // exitItem.addActionListener(this);

        // fileMenu.setMnemonic(KeyEvent.VK_F);//thêm sự kiện sử dụng phím tắt alt + F là load
        // editMenu.setMnemonic(KeyEvent.VK_E);//thêm sự kiện sử dụng phím tắt alt + E là save
        // helpMenu.setMnemonic(KeyEvent.VK_H);//thêm sự kiện sử dụng phím tắt alt + H là Exit
        // loadItem.setMnemonic(KeyEvent.VK_L);//thêm sự kiện sử dụng phím tắt L là load
        // saveItem.setMnemonic(KeyEvent.VK_S);//thêm sự kiện sử dụng phím tắt S là save
        // exitItem.setMnemonic(KeyEvent.VK_E);//thêm sự kiện sử dụng phím tắt E là Exit

        // fileMenu.add(loadItem);
        // fileMenu.add(saveItem);
        // fileMenu.add(exitItem);

        //left panel
        leftPanel.setBounds(0,0,(int)(width * 0.3),height);
        leftPanel.setBackground(Color.RED);

        //tiêu đề + logo
        JLabel leftLabel = new JLabel("Quản lý");
        JLabel subTitle = new JLabel("Chức năng");
        subTitle.setFont(new java.awt.Font("Times New Roman", 1, 30));
        leftLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        leftLabel.setIcon(logo1);

        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension((int)(width * 0.3),250));
        logoPanel.add(leftLabel);
        leftPanel.add(logoPanel);
        leftPanel.add(subTitle);
        
        //lựa chọn chức năng
        JPanel managementPanel = new JPanel();
        JPanel statisticsPanel = new JPanel();
        JPanel listPanel = new JPanel();
        
        JLabel statisticLabel = new JLabel("Thống kê đơn hàng");
        JLabel listLabel = new JLabel("Quản lý danh sách");

        statisticLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        listLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));

        statisticsPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        statisticsPanel.setBackground(Color.BLUE);

        listPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        listPanel.setBackground(Color.GREEN);

        statisticsPanel.add(statisticLabel);        
        listPanel.add(listLabel);

        managementPanel.setPreferredSize(new Dimension((int)(width * 0.3),height - 250));
        managementPanel.add(listPanel);
        managementPanel.add(statisticsPanel);
        leftPanel.add(managementPanel);

        //right panel
        rightPanel.setBounds((int)(width * 0.3),0,(int)(width * 0.7),height);
        
        //thêm đối tượng
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
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
        // adminFrame.setJMenuBar(mbar);
    }
    public static void main(String[] args){
        new admin();
    }
}