package laptrinhjava.src;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
public class admin{
    private JFrame adminFrame = new JFrame("Quản lý SGU Gym");
    private final int width = 1600;
    private final int height = 900;
    //logo
    ImageIcon logo = new ImageIcon("doan/src/laptrinhjava/src/asset/img/logo.png");
    ImageIcon logo1 = new ImageIcon("doan/src/laptrinhjava/src/asset/img/logo1.png");
    
    //icon chức năng thống kê
    ImageIcon analyticsIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/analytics.png");
    Image scaleAnalyticsIcon = analyticsIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng danh sách
    ImageIcon checkListIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/checklist.png");
    Image scaleCheckListIcon = checkListIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon tiêu đề phụ chức năng
    ImageIcon managementIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/project-management.png");
    Image scaleManagementIcon = managementIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //tạo viền cho panel
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    //loading
    private JPanel loadingPanel = new JPanel();
    private JProgressBar pBar = new JProgressBar();
    private JLabel pBarLabel = new JLabel("Đang tải");
    private JLabel loadingLogo = new JLabel();

    //main
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    
    //tiêu đề + logo
    JLabel leftLabel = new JLabel("Quản lý");
        
    //tiêu đề phụ
    JLabel subTitle = new JLabel("Chức năng");

    //bảng dữ liệu
    private String[][] rows = {{"test1", "test2", "test3","test4", "test5", "test6","test4", "test5", "test6","test4", "test5", "test6"},
                              {"test4", "test5", "test6","test4", "test5", "test6","test4", "test5", "test6","test4", "test5", "test6"}
                             };
    private String[] columnns =   {"test7", "test8", "test9","test4", "test5", "test6","test4", "test5", "test6","test4", "test5", "test6"};

    private JTable dataTable = new JTable(rows,columnns);

    private JScrollPane scrollPane = new JScrollPane(dataTable);

    public admin(){
        //main frame
        adminFrame.setSize(width, height);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLayout(null);
        adminFrame.setIconImage(logo.getImage());

        //loading
        loadingPanel.setSize(new Dimension(width,height));
        loadingPanel.setLayout(null);
        loadingPanel.setBackground(Color.WHITE);
        
        loadingLogo.setIcon(logo);
        loadingLogo.setBounds(675,100,(int)(width * 0.3),250);

        pBarLabel.setBounds(width/2 - 50,350,300,50);
        pBarLabel.setFont(new java.awt.Font("Arial", 1, 25));
        
        pBar.setValue(0);
        pBar.setBounds(width/2 - 210,height/2 -25,420,50);
        pBar.setStringPainted(true);//thêm % cho thanh tiến trình

        loadingPanel.add(loadingLogo);
        loadingPanel.add(pBarLabel);
        loadingPanel.add(pBar);
        
        //main
        mainPanel.setSize(new Dimension(width,height));
        mainPanel.setLayout(null);

        //left panel
        leftPanel.setBounds(0,0,(int)(width * 0.3),height);
        leftPanel.setBackground(Color.WHITE);
        
        subTitle.setFont(new java.awt.Font("Times New Roman", 1, 30));
        subTitle.setIcon(new ImageIcon(scaleManagementIcon));
        
        leftLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        leftLabel.setIcon(logo1);

        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension((int)(width * 0.3)-10,240));
        logoPanel.setBackground(Color.WHITE);
        logoPanel.add(leftLabel);
        leftPanel.add(logoPanel);
        leftPanel.add(subTitle);
        
        //lựa chọn chức năng
        JPanel managementPanel = new JPanel();
        JPanel statisticsPanel = new JPanel();
        JPanel listPanel = new JPanel();

        //chức năng thống kê        
        JLabel statisticLabel = new JLabel("Thống kê đơn hàng");
        statisticLabel.setIcon(new ImageIcon(scaleAnalyticsIcon));
        
        //chức năng quản lý danh sách
        JLabel listLabel = new JLabel("Quản lý danh sách");
        listLabel.setIcon(new ImageIcon(scaleCheckListIcon));

        statisticLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        listLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));

        statisticsPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        statisticsPanel.setBackground(Color.BLUE);
        statisticsPanel.setBorder(border);


        listPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        listPanel.setBackground(Color.GREEN);
        listPanel.setBorder(border);

        statisticsPanel.add(statisticLabel);        
        listPanel.add(listLabel);

        managementPanel.setPreferredSize(new Dimension((int)(width * 0.3),height - 250));
        managementPanel.setBackground(Color.WHITE);
        managementPanel.add(listPanel);
        managementPanel.add(statisticsPanel);
        leftPanel.add(managementPanel);

        //right panel
        rightPanel.setBounds((int)(width * 0.3),0,(int)(width * 0.7),height);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(border);

        //tiêu đề bên phải
        JLabel rightTitle = new JLabel("Quản lý danh sách");
        rightTitle.setFont(new java.awt.Font("Times New Roman", 1, 40));

        JPanel rightTitlePanel = new JPanel();
        rightTitlePanel.setPreferredSize(new Dimension((int)((width * 0.697)),50));
        rightTitlePanel.setLocation((int)(width * 0.3),0);
        rightTitlePanel.setBackground(Color.YELLOW);

        rightTitlePanel.add(rightTitle);
        rightPanel.add(rightTitlePanel);

        //chức năng:
        //quản lý danh sách:
        
        // THÊM:
        // nhập hàng hóa
        // nhập thiết bị
        // duyệt đơn hàng

        //chọn danh sách
        JPanel chooseListPanel = new JPanel();
        chooseListPanel.setPreferredSize(new Dimension((int)((width * 0.697)),50));

        String[] list = {"Cơ sở", "Dịch vụ", "Hội viên", "Nhân viên", "Thiết bị", "Thiết bị cơ sở", "Hóa đơn","Duyệt Hóa Đơn","Nhập Hàng Hóa","Hàng Hóa Cơ Sở"};
        JComboBox chooseList = new JComboBox<String>(list);
        chooseList.setFont(new java.awt.Font("Arial", 1, 16));

        //Xử lý sự kiện         
        chooseList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(chooseList.getSelectedIndex()==0){ //bảng cơ sở
                    xuLyBangCoSo();
                }
                else if(chooseList.getSelectedIndex()==1){//Bảng dịch vụ
                    xuLyBangDichVu();
                }
                else if(chooseList.getSelectedIndex()==2){//Bảng hội viên
                    xuLyBangHoiVien();
                }
                else{
                    System.out.println(chooseList.getSelectedItem());
                }
            }
            
            //hàm xử lý bảng cơ sở
            private void xuLyBangCoSo(){

            }

            //hàm xử lý bảng dịch vụ
            private void xuLyBangDichVu(){

            }

            //hàm xử lý bảng hội viên
            private void xuLyBangHoiVien(){

            }
        });
        
        JLabel chooseListLabel = new JLabel("Chọn danh sách: ");
        chooseListLabel.setFont(new java.awt.Font("Arial", 1, 30));
        chooseListLabel.setIcon(new ImageIcon(scaleCheckListIcon));
        chooseListPanel.add(chooseListLabel);
        chooseListPanel.add(chooseList);

        rightPanel.add(chooseListPanel);

        //chỉnh sử thông tin
        JPanel infoDisplay = new JPanel();
        infoDisplay.setPreferredSize(new Dimension((int)(width * 0.697),200));
        
        JLabel infoLabel = new JLabel("Chỉnh sửa thông tin");
        infoLabel.setFont(new java.awt.Font("Arial", 1, 20));

        infoDisplay.add(infoLabel);
        rightPanel.add(infoDisplay);

        //nút chức năng
        JPanel btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension((int)(width * 0.697),40));
        
        JButton addBtn = new JButton("Thêm");
        JButton removeBtn = new JButton("Xóa");
        JButton editBtn = new JButton("Sửa");
        JButton updateBtn = new JButton("Cập nhật");
        
        addBtn.setPreferredSize(new Dimension(100,25));
        removeBtn.setPreferredSize(new Dimension(100,25));
        editBtn.setPreferredSize(new Dimension(100,25));
        updateBtn.setPreferredSize(new Dimension(100,25));

        btnPanel.add(addBtn);
        btnPanel.add(removeBtn);
        btnPanel.add(editBtn);
        btnPanel.add(updateBtn);
        
        rightPanel.add(btnPanel);

        //Bảng dữ liệu
        JPanel disDataPanel = new JPanel();
        disDataPanel.setPreferredSize(new Dimension((int)(width * 0.697),height - 400));
        
        rightPanel.add(disDataPanel);

        //thêm đối tượng
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        adminFrame.add(loadingPanel);
        adminFrame.setVisible(true);
        
        //hàm chạy load
        fill();
    }
    
    private void fill(){
        int count = 0;
        while(count<=100){
            pBar.setValue(count);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(count % 3 == 0){
                pBarLabel.setText("Đang tải.");
            }
            else if(count % 3 == 1){
                pBarLabel.setText("Đang tải..");
            }
            else{
                pBarLabel.setText("Đang tải...");
            }
            count+=2;
        }
        pBar.setString("Done!");
        loadingPanel.setVisible(false);
        pBarLabel.setVisible(false);
        adminFrame.add(mainPanel);
        // adminFrame.setJMenuBar(mbar);
    }
    public static void main(String[] args){
        new admin();
    }
}