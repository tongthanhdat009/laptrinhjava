package laptrinhjava.src;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class admin implements ActionListener{
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
    
    //icon chức năng nhập thiết bị
    ImageIcon dumbbellIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/dumbbell-icon.png");
    Image scaleDumbbellIcon = dumbbellIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập hàng hóa
    ImageIcon goodsIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/goods-icon.png");
    Image scaleGoodsIcon = goodsIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);

    //icon chức năng nhập hàng hóa
    ImageIcon billIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/bill-icon.png");
    Image scaleBillIcon = billIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng thống kê doanh thu
    ImageIcon chartIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/stonk.jpg");
    Image scaleChartIcon = chartIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
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
        JPanel nhapThietBiPanel = new JPanel();
        JPanel duyetDonHangPanel = new JPanel();
        JPanel nhapHangHoaPanel = new JPanel();
        JPanel thongKeDoanhThuPanel = new JPanel();
        //chức năng thống kê        
        JLabel statisticLabel = new JLabel("Thống kê đơn hàng");
        statisticLabel.setIcon(new ImageIcon(scaleAnalyticsIcon));
        
        //chức năng quản lý danh sách
        JLabel listLabel = new JLabel("Quản lý danh sách");
        listLabel.setIcon(new ImageIcon(scaleCheckListIcon));

        //Chức năng nhập thiết bị
        JLabel nhapThietBiLabel = new JLabel("Nhập thiết bị");
        nhapThietBiLabel.setIcon(new ImageIcon(scaleDumbbellIcon));

        //chức năng duyệt đơn hàng
        JLabel duyetDonHangLabel = new JLabel("Duyệt đơn hàng");
        duyetDonHangLabel.setIcon(new ImageIcon(scaleBillIcon));
        
        //chức năng nhập hàng hóa
        JLabel nhapHangHoaLabel = new JLabel("Nhập hàng hóa");
        nhapHangHoaLabel.setIcon(new ImageIcon(scaleGoodsIcon));
        
        //Chức năng thống kê doanh thu
        JLabel thongKeDoanhThuLabel = new JLabel("Thống kê doanh thu");
        thongKeDoanhThuLabel.setIcon(new ImageIcon(scaleChartIcon));

        // Chỉnh font chữ cho phần chọn chức năng
        statisticLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        listLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        nhapThietBiLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        nhapHangHoaLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        duyetDonHangLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        thongKeDoanhThuLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));

        statisticsPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        statisticsPanel.setBackground(Color.BLUE);
        statisticsPanel.setBorder(border);

        listPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        listPanel.setBackground(Color.GREEN);
        listPanel.setBorder(border);

        nhapThietBiPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        nhapThietBiPanel.setBackground(Color.YELLOW);
        nhapThietBiPanel.setBorder(border);

        duyetDonHangPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        duyetDonHangPanel.setBackground(Color.RED);
        duyetDonHangPanel.setBorder(border);

        nhapHangHoaPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        nhapHangHoaPanel.setBackground(Color.CYAN);
        nhapHangHoaPanel.setBorder(border);

        thongKeDoanhThuPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        thongKeDoanhThuPanel.setBackground(Color.MAGENTA);
        thongKeDoanhThuPanel.setBorder(border);
        //Sử lý sự kiện khi chọn chức năng
        listPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyDanhSach();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        statisticsPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
                rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
                rightPanel.repaint(); // Vẽ lại JPanel
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
                // Không cần xử lý
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
                // Không cần xử lý
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
                // Không cần xử lý
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                // Không cần xử lý
            }
        });

        nhapThietBiPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyNhapHang();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        duyetDonHangPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
                rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
                rightPanel.repaint(); // Vẽ lại JPanel
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        nhapHangHoaPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
                rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
                rightPanel.repaint(); // Vẽ lại JPanel
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        thongKeDoanhThuPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
                rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
                rightPanel.repaint(); // Vẽ lại JPanel
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        // thêm đối tượng
        statisticsPanel.add(statisticLabel);        
        listPanel.add(listLabel);
        nhapThietBiPanel.add(nhapThietBiLabel);
        nhapHangHoaPanel.add(nhapHangHoaLabel);
        duyetDonHangPanel.add(duyetDonHangLabel);
        thongKeDoanhThuPanel.add(thongKeDoanhThuLabel);
        //bảng chọn chức năng
        managementPanel.setPreferredSize(new Dimension((int)(width * 0.3),height - 250));
        managementPanel.setBackground(Color.WHITE);

        managementPanel.add(listPanel);
        managementPanel.add(statisticsPanel);
        managementPanel.add(nhapThietBiPanel);
        managementPanel.add(nhapHangHoaPanel);
        managementPanel.add(duyetDonHangPanel);
        managementPanel.add(thongKeDoanhThuPanel);

        leftPanel.add(managementPanel);

        //chức năng:
        //quản lý danh sách:
        //right panel
        rightPanel.setBounds((int)(width * 0.3),0,(int)(width * 0.7),height);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(border);

        //Xử lý danh sách
        xuLyDanhSach();

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
    private void xuLyNhapHang()
    {
        try
        {
            rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
            rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
            rightPanel.repaint(); // Vẽ lại JPanel
            rightPanel.setLayout(null);
            
            JPanel canGiua = new JPanel(new FlowLayout());
            canGiua.setBounds(5,5,rightPanel.getWidth(),55);
            canGiua.setBackground(Color.yellow);
            JLabel titleNhapThietBi = new JLabel("Nhập thiết bị");
            titleNhapThietBi.setFont(new Font("Times New Roman",1,40));

            canGiua.add(titleNhapThietBi);
            rightPanel.add(canGiua);

            JPanel filler = new JPanel(null);
            filler.setBounds(5,70,rightPanel.getWidth(),55);
            JLabel timTheoTen = new JLabel("Tìm kiếm bằng tên");
            timTheoTen.setBounds(10, 15, 130, 30);
            JTextField nhapTen = new JTextField();
            nhapTen.setBounds(145, 15, 175, 30);
            JButton timkiem = new JButton(">");
            timkiem.setBounds(320, 15, 45, 29);
            filler.add(timTheoTen);
            filler.add(nhapTen);
            filler.add(timkiem);

            rightPanel.add(filler);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
            String userName = "sa"; String password= "123456";
            Connection con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();

            
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS sl FROM LoaiThietBi");
            rs.next();
            int soLuongLoaiThietBi = rs.getInt("sl");
            int soHangHienThi = soLuongLoaiThietBi / 3 + 1;
            JPanel hienThiThietBi = new JPanel(new GridLayout(soHangHienThi,3,30,30));
            rs = stmt.executeQuery("SELECT * FROM LoaiThietBi");
            while(rs.next())
            {
                JPanel thongTinThietBi = new JPanel(new BorderLayout());
                ImageIcon anhThietBi = new ImageIcon(rs.getString("HinhAnh"));
                Image chinhAnhThietBi = anhThietBi.getImage().getScaledInstance(330, 330,Image.SCALE_DEFAULT);
                anhThietBi = new ImageIcon(chinhAnhThietBi);
                String tenThietBi = rs.getString("MaThietBi");
                JLabel labelAnhThietBi = new JLabel(anhThietBi);
                JLabel labelTenThietBi = new JLabel(tenThietBi);
                thongTinThietBi.add(labelAnhThietBi,BorderLayout.CENTER);
                thongTinThietBi.add(labelTenThietBi,BorderLayout.SOUTH);
                hienThiThietBi.add(thongTinThietBi);

                thongTinThietBi.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JOptionPane.showMessageDialog(null, tenThietBi);
                    }
                
                    @Override
                    public void mousePressed(MouseEvent e) {
                        // Không cần xử lý
                    }
                
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        // Không cần xử lý
                    }
                
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        // Không cần xử lý
                    }
                
                    @Override
                    public void mouseExited(MouseEvent e) {
                        // Không cần xử lý
                    }
                });
            }   
            for(int i=0;i<soHangHienThi*3 - soLuongLoaiThietBi;i++)
            hienThiThietBi.add(new Label());
            JScrollPane scrollPane = new JScrollPane(hienThiThietBi);
            scrollPane.setBounds(5, 150, rightPanel.getWidth()-20,700);
            rightPanel.add(scrollPane);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void xuLyDanhSach(){
        rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        rightPanel.repaint(); // Vẽ lại JPanel
        //tiêu đề bên phải
        JLabel rightTitle = new JLabel("Quản lý danh sách");
        rightTitle.setFont(new java.awt.Font("Times New Roman", 1, 40));

        JPanel rightTitlePanel = new JPanel();
        rightTitlePanel.setPreferredSize(new Dimension((int)((width * 0.697)),50));
        rightTitlePanel.setLocation((int)(width * 0.3),0);
        rightTitlePanel.setBackground(Color.YELLOW);

        rightTitlePanel.add(rightTitle);
        rightPanel.add(rightTitlePanel);

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

        String[] btnName = {"Thêm", "Xóa", "Sửa", "Cập nhật"};
        String[] btnCommand = {"add", "delete", "edit", "update"};
        
        for(int i=0;i<btnName.length;i++){
            JButton temp = new JButton(btnName[i]);
            temp.setPreferredSize(new Dimension(100,25));
            temp.addActionListener(this);
            temp.setActionCommand(btnCommand[i]);
            btnPanel.add(temp);
        }
        
        rightPanel.add(btnPanel);
        
        //Bảng dữ liệu
        JPanel disDataPanel = new JPanel();
        disDataPanel.setPreferredSize(new Dimension((int)(width * 0.697),height - 400));
        
        rightPanel.add(disDataPanel);
    }
    public static void main(String[] args){
        new admin();
    }
}