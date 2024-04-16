package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import BLL.BLLAdmin;
import BLL.BLLNhapThietBi;
import DAL.DataCoSo;
import DAL.DataHoiVien;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.HoiVien;
import DTO.LoaiThietBi;
import DTO.dsHoiVien;

import java.util.ArrayList;
import java.util.Vector;


import java.awt.*;
import java.awt.event.*;

public class GUIAdmin implements ActionListener{
    private JFrame adminFrame = new JFrame("Quản lý SGU Gym");
    private final int width = 1600;
    private final int height = 900;
    //logo
    ImageIcon logo = new ImageIcon("doan/src/laptrinhjava/src/asset/img/label/logo.png");
    ImageIcon logo1 = new ImageIcon("doan/src/laptrinhjava/src/asset/img/label/logo1.png");
    
    //icon chức năng thống kê
    ImageIcon analyticsIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/icon/analytics-icon.png");
    Image scaleAnalyticsIcon = analyticsIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng danh sách
    ImageIcon checkListIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/icon/checklist-icon.png");
    Image scaleCheckListIcon = checkListIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon tiêu đề phụ chức năng
    ImageIcon managementIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/icon/project-management-icon.png");
    Image scaleManagementIcon = managementIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập thiết bị
    ImageIcon dumbbellIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/icon/dumbbell-icon.png");
    Image scaleDumbbellIcon = dumbbellIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập hàng hóa
    ImageIcon goodsIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/icon/goods-icon.png");
    Image scaleGoodsIcon = goodsIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);

    //icon chức năng nhập hàng hóa
    ImageIcon billIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/icon/bill-icon.png");
    Image scaleBillIcon = billIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng thống kê doanh thu
    ImageIcon chartIcon = new ImageIcon("doan/src/laptrinhjava/src/asset/img/icon/stonk-icon.jpg");
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
    
    //BLLAdmin
    BLLAdmin bllAdmin = new BLLAdmin();

    public GUIAdmin(){    
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
                BLLNhapThietBi bllNhapThietBi = new BLLNhapThietBi();
                DSLoaiThietBi dsLoaiThietBi = new DSLoaiThietBi();
                dsLoaiThietBi = bllNhapThietBi.layDSLoaiThietBi();
                int soLuongLoaiThietBi = dsLoaiThietBi.dsThietBi.size();
                xuLyNhapHang(dsLoaiThietBi,soLuongLoaiThietBi);
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
                xuLyNhapHangHoa();
                
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
    public void xuLyNhapHang(DSLoaiThietBi dsLoaiThietBi, int soLuongLoaiThietBi)
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

            JPanel filter = new JPanel(null);
            filter.setBounds(5,70,rightPanel.getWidth(),55);
            JLabel timTheoTen = new JLabel("Tìm kiếm bằng tên");
            timTheoTen.setBounds(10, 15, 130, 30);
            JTextField nhapTen = new JTextField();
            nhapTen.setBounds(145, 15, 175, 30);
            JButton timkiem = new JButton(">");
            timkiem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    BLLNhapThietBi bllNhapThietBi = new BLLNhapThietBi();
                    DSLoaiThietBi ds = new DSLoaiThietBi();
                    ds = bllNhapThietBi.timKiem(nhapTen.getText());
                    int soLuongLoaiThietBi = ds.dsThietBi.size();
                    xuLyNhapHang(ds, soLuongLoaiThietBi);
                }
            });
            timkiem.setBounds(320, 15, 45, 29);
            filter.add(timTheoTen);
            filter.add(nhapTen);
            filter.add(timkiem);

            rightPanel.add(filter);

            int soHangHienThi;
            if(soLuongLoaiThietBi % 3 == 0) soHangHienThi =  soLuongLoaiThietBi / 3 ;
            else soHangHienThi = soLuongLoaiThietBi / 3 + 1;
            JPanel hienThiThietBi = new JPanel(new GridLayout(0,3,100,50));
            hienThiThietBi.setPreferredSize(new Dimension(rightPanel.getWidth()-50, 400*soHangHienThi));
            for (LoaiThietBi thietBi : dsLoaiThietBi.dsThietBi)
            {
                JPanel thongTinThietBi = new JPanel(null);
                thongTinThietBi.setBackground(Color.WHITE);

                ImageIcon anhThietBi = new ImageIcon(thietBi.getHinhAnh());
                Image chinhAnhThietBi = anhThietBi.getImage().getScaledInstance(300, 250,Image.SCALE_DEFAULT);
                anhThietBi = new ImageIcon(chinhAnhThietBi);
                JLabel labelAnhThietBi = new JLabel(anhThietBi);
                labelAnhThietBi.setBounds(0, 0, 300, 250);
                thongTinThietBi.add(labelAnhThietBi);

                JPanel panelTenThietBi = new JPanel(new FlowLayout());
                JPanel panelGiaThietBi = new JPanel(new FlowLayout());
                panelTenThietBi.setBounds(0, 280, 300, 30);
                panelGiaThietBi.setBounds(0, 310, 300, 30);
                panelTenThietBi.setBackground(Color.WHITE);
                panelGiaThietBi.setBackground(Color.WHITE);
                JLabel labelTenThietBi = new JLabel(thietBi.getTenLoaiThietBi().trim());
                JLabel labelGiaThietBi = new JLabel("Giá: "+thietBi.getGiaThietBi().trim());
                panelTenThietBi.add(labelTenThietBi);
                panelGiaThietBi.add(labelGiaThietBi);
                thongTinThietBi.add(panelTenThietBi);
                thongTinThietBi.add(panelGiaThietBi);

                thongTinThietBi.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JPanel thongTinChiTiet = new JPanel(new GridLayout(6,1));
                        thongTinChiTiet.setPreferredSize(new Dimension(300,150));
                        JLabel ten = new JLabel("Tên: "+thietBi.getTenLoaiThietBi());
                        JLabel ma = new JLabel("Mã Loại: "+thietBi.getMaThietBi());
                        JLabel gia = new JLabel("Giá: "+thietBi.getGiaThietBi());
                        JLabel soNgayBaoHanh = new JLabel("Số ngày bảo hành: "+thietBi.getNgayBaoHanh());
                        
                        JPanel chonSoLuong = new JPanel(new GridLayout(1,2));
                        JLabel labelSoLuong = new JLabel("Số Lượng: ");
                        JTextField soLuong = new JTextField();
                        chonSoLuong.add(labelSoLuong);
                        chonSoLuong.add(soLuong);
                        thongTinChiTiet.add(ten);
                        thongTinChiTiet.add(ma);
                        thongTinChiTiet.add(gia);
                        thongTinChiTiet.add(soNgayBaoHanh);
                        thongTinChiTiet.add(chonSoLuong);
                        boolean flag = false;

                        DataCoSo dataCoSo = new DataCoSo();
                        DSCoSo dsCS = new DSCoSo();
                        dsCS = dataCoSo.layDSCoSo();
                        Vector<String> s = new Vector<>();
                        for(CoSo a : dsCS.dsCoSo)
                        {
                            s.add(a.getMaCoSo());
                        }
                        JComboBox chonCoSo = new JComboBox<>(s);
                        JLabel labelCoSo = new JLabel("Chọn cơ sở: ");

                        JPanel panelChonCoSo = new JPanel(new GridLayout(1,2));
                        panelChonCoSo.add(labelCoSo);
                        panelChonCoSo.add(chonCoSo);

                        thongTinChiTiet.add(panelChonCoSo);

                        while(flag == false)
                        {
                            int qes = JOptionPane.showConfirmDialog(rightPanel, thongTinChiTiet,"Nhập thiết bị",JOptionPane.OK_OPTION);
                            if(qes == 0)
                            {
                                try {
                                    int sl = Integer.parseInt(soLuong.getText());
                                    if(sl > 0) 
                                    {
                                        BLLNhapThietBi bllNhapThietBi = new BLLNhapThietBi();
                                        bllNhapThietBi.nhapHangVeCoSo(thietBi.getMaThietBi(),chonCoSo.getSelectedItem().toString(),sl,thietBi.getNgayBaoHanh());
                                        flag = true;
                                    }
                                    else JOptionPane.showMessageDialog(rightPanel, "Số lượng phải lớn hơn 0");
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(rightPanel, "Số lượng phải là số lớn hơn 0");
                                }
                            }
                            else flag = true;
                        }
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
                hienThiThietBi.add(thongTinThietBi);
            }
            JScrollPane scrollPane = new JScrollPane(hienThiThietBi);
            if(soHangHienThi == 1) scrollPane.setBounds(5, 150, rightPanel.getWidth()-20,400);
            else scrollPane.setBounds(5, 150, rightPanel.getWidth()-20,700);
            rightPanel.add(scrollPane);
    }
    public void xuLyNhapHangHoa()
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

        JPanel filter = new JPanel(null);
        filter.setBounds(5,70,rightPanel.getWidth(),55);
        JLabel timTheoTen = new JLabel("Tìm kiếm bằng tên");
        timTheoTen.setBounds(10, 15, 130, 30);
        JTextField nhapTen = new JTextField();
        nhapTen.setBounds(145, 15, 175, 30);
        JButton timkiem = new JButton(">");
            // timkiem.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent e)
            //     {
            //         BLLNhapThietBi bllNhapThietBi = new BLLNhapThietBi();
            //         DSLoaiThietBi ds = new DSLoaiThietBi();
            //         ds = bllNhapThietBi.timKiem(nhapTen.getText());
            //         int soLuongLoaiThietBi = ds.dsThietBi.size();
            //         xuLyNhapHang(ds, soLuongLoaiThietBi);
            //     }
            // });
        timkiem.setBounds(320, 15, 45, 29);
        filter.add(timTheoTen);
        filter.add(nhapTen);
        filter.add(timkiem);

        rightPanel.add(filter);
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

        String[] list = {"Cơ sở", "Dịch vụ", "Hội viên", "Nhân viên", "Thiết bị", "Thiết bị cơ sở", "Hóa đơn","Hàng Hóa Cơ Sở"};
        JComboBox chooseList = new JComboBox<String>(list);
        chooseList.setFont(new java.awt.Font("Arial", 1, 16));

        //Xử lý sự kiện         
        chooseList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // if(chooseList.getSelectedIndex()==0){ //bảng cơ sở
                //     xuLyBangCoSo();
                // }
                // else if(chooseList.getSelectedIndex()==1){//Bảng dịch vụ
                //     xuLyBangDichVu();
                // }
                if(chooseList.getSelectedIndex()==2){//Bảng hội viên
                    hienThiThongTinHoiVien();
                }
                // else if(chooseList.getSelectedIndex()==3){//Bảng Nhân viên
                //     xuLyBangNhanVien();
                // }
                // else if(chooseList.getSelectedIndex()==4){//Bảng thiết bị
                //     xuLyBangThietBi();
                // }
                // else if(chooseList.getSelectedIndex()==5){//Bảng thiết bị ở một cơ sở
                //     xuLyBangThietBiCoSo();
                // }
                // else if(chooseList.getSelectedIndex()==6){//Bảng hóa đơn
                //     xuLyBangHoaDon();
                // }
                // else if(chooseList.getSelectedIndex()==7){//Bảng hàng hóa cơ sở
                //     xuLyBangHangHoaCoSo();
                // }
                // else{
                //     System.out.println(chooseList.getSelectedItem());
                // }
            }
            private void hienThiThongTinHoiVien(){
                //Bảng dữ liệu
                JPanel disDataPanel = new JPanel();
                disDataPanel.setLayout(null);
                disDataPanel.setPreferredSize(new Dimension((int)(width * 0.6),height - 400));
                DefaultTableModel hvList = new DefaultTableModel();
                JTable dataTable = new JTable(hvList);
                dataTable.setBounds(0,0,disDataPanel.getWidth(),disDataPanel.getHeight());

                ArrayList<String> tenCotHV = bllAdmin.layTenCotHoiVien();

                ArrayList<HoiVien> dsHV = bllAdmin.layDsHV();

                
                for(int i=0;i<tenCotHV.size();i++){
                    hvList.addColumn(tenCotHV.get(i));
                }

                for(int i=0;i<dsHV.size();i++){
                    hvList.addRow(new Object[]{ dsHV.get(i).getMaHoiVien(),
                                                 dsHV.get(i).getHoten(),
                                                 dsHV.get(i).getGioitinh(),
                                                 dsHV.get(i).getNgaysinh(),
                                                 dsHV.get(i).getSdt(),
                                                 dsHV.get(i).getMail(),
                                                 dsHV.get(i).getTaiKhoanHoiVien(),
                                                 dsHV.get(i).getMatKhauHoiVien()});
                }
                JScrollPane scrollPane = new JScrollPane(dataTable);
                scrollPane.setBounds(5,20,disDataPanel.getWidth()-300,disDataPanel.getHeight()-100);
                disDataPanel.add(dataTable);
                disDataPanel.add(scrollPane);
                rightPanel.add(disDataPanel);
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
        
        
    }
    public static void main(String[] args){
        new GUIAdmin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}