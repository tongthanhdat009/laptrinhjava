package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

import BLL.BLLNhapThietBi;
import BLL.BLLQuanLyDanhSach;
import BLL.BLLThongKeDT;
import BLL.BLLThongKeDonHang;
import DAL.DataCoSo;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.DTOThongKeDonHang;
import DTO.HoiVien;
import DTO.LoaiThietBi;
import DTO.ThietBiCoSo;

import java.util.ArrayList;
import java.util.Vector;


import java.awt.*;
import java.awt.event.*;
import java.sql.Date;


public class GUIAdmin{
    private static final String BORDER = null;
    private JFrame adminFrame = new JFrame("Quản lý SGU Gym");
    private final int width = 1600;
    private final int height = 900;
    //logo
    ImageIcon logo = new ImageIcon("src/asset/img/label/logo.png");
    ImageIcon logo1 = new ImageIcon("src/asset/img/label/logo1.png");
    
    //icon chức năng thống kê
    ImageIcon analyticsIcon = new ImageIcon("src/asset/img/icon/analytics-icon.png");
    Image scaleAnalyticsIcon = analyticsIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon chức năng danh sách
    ImageIcon checkListIcon = new ImageIcon("src/asset/img/icon/checklist-icon.png");
    Image scaleCheckListIcon = checkListIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon tiêu đề phụ chức năng
    ImageIcon managementIcon = new ImageIcon("src/asset/img/icon/project-management-icon.png");
    Image scaleManagementIcon = managementIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);

    ImageIcon upArrowIcon = new ImageIcon("src/asset/img/icon/up-Arrow-icon.png");
    Image scaleUpArrowIcon = upArrowIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    ImageIcon downArrowIcon = new ImageIcon("src/asset/img/icon/down-Arrow-icon.png");
    Image scaleDownArrowIcon = downArrowIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập thiết bị
    ImageIcon dumbbellIcon = new ImageIcon("src/asset/img/icon/dumbbell-icon.png");
    Image scaleDumbbellIcon = dumbbellIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập hàng hóa
    ImageIcon goodsIcon = new ImageIcon("src/asset/img/icon/goods-icon.png");
    Image scaleGoodsIcon = goodsIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);

    //icon chức năng nhập hàng hóa
    ImageIcon billIcon = new ImageIcon("src/asset/img/icon/bill-icon.png");
    Image scaleBillIcon = billIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    
    //icon chức năng thống kê doanh thu
    ImageIcon chartIcon = new ImageIcon("src/asset/img/icon/stonk-icon.jpg");
    Image scaleChartIcon = chartIcon.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
    //tạo viền cho panel
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    //main
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    
    //tiêu đề + logo
    JLabel leftLabel = new JLabel();
        
    //tiêu đề phụ
    JLabel subTitle = new JLabel("Chức năng");
    

    public GUIAdmin(){    
        //main frame
        adminFrame.setSize(width, height);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLayout(null);
        adminFrame.setIconImage(logo.getImage());

        //main
        mainPanel.setSize(new Dimension(width,height));
        mainPanel.setLayout(null);

        //left panel
        leftPanel.setBounds(0,0,(int)(width * 0.25),height);
        leftPanel.setBackground(new Color(179, 177, 173));
        leftPanel.setLayout(null);
        
        subTitle.setFont(new java.awt.Font("Times New Roman", 1, 35));
        subTitle.setIcon(new ImageIcon(scaleDownArrowIcon));
        
        leftLabel.setIcon(logo1);

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(179, 177, 173));
        logoPanel.setLayout(new BorderLayout());
        logoPanel.setBounds(0,0,(int)(width * 0.3)-10,240);
        logoPanel.add(leftLabel, BorderLayout.CENTER);
        logoPanel.add(subTitle,BorderLayout.SOUTH);
        leftPanel.add(logoPanel);
        
        //lựa chọn chức năng
        JPanel managementPanel = new JPanel();
        JPanel statisticsPanel = new JPanel();
        JPanel listPanel = new JPanel();
        JPanel nhapThietBiPanel = new JPanel();
        JPanel duyetDonHangPanel = new JPanel();
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
        
        //Chức năng thống kê doanh thu
        JLabel thongKeDoanhThuLabel = new JLabel("Thống kê doanh thu");
        thongKeDoanhThuLabel.setIcon(new ImageIcon(scaleChartIcon));

        // Chỉnh font chữ cho phần chọn chức năng
        statisticLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
        listLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
        nhapThietBiLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
        duyetDonHangLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
        thongKeDoanhThuLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));

        statisticsPanel.setBounds(30,5,320,55);
        statisticsPanel.setBackground(new Color(179, 177, 173));

        listPanel.setBounds(30,70,320,55);
        listPanel.setBackground(new Color(179, 177, 173));

        nhapThietBiPanel.setBounds(30,70*2,320,55);
        nhapThietBiPanel.setBackground(new Color(179, 177, 173));

        duyetDonHangPanel.setBounds(30,70*3,320,55);
        duyetDonHangPanel.setBackground(new Color(179, 177, 173));

        thongKeDoanhThuPanel.setBounds(30,70*4,320,55);
        thongKeDoanhThuPanel.setBackground(new Color(179, 177, 173));

        // thongKeDoanhThuPanel.setBorder(border);
        //Sử lý sự kiện khi chọn chức năng
        logoPanel.addMouseListener(new MouseListener(){
            private int clickCount = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                if (clickCount % 2 == 0) {
                    subTitle.setIcon(new ImageIcon(scaleDownArrowIcon));
                    managementPanel.setVisible(false);
                } else {
                    subTitle.setIcon(new ImageIcon(scaleUpArrowIcon));
                    managementPanel.setVisible(true);
                }
                clickCount++; 
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

        listPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
                rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
                rightPanel.repaint(); // Vẽ lại JPanel
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
                listPanel.setBackground(Color.WHITE);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                listPanel.setBackground(new Color(179, 177, 173));

            }
        });
        
        statisticsPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BLLThongKeDonHang bllThongKeDonHang = new BLLThongKeDonHang();
                ArrayList<DTOThongKeDonHang> ds = bllThongKeDonHang.layDSDLoc("NULL", "NULL", "2024-01-01", "2025-01-01");
                Vector<String> dsTenCoSo = new Vector<>();
                dsTenCoSo = bllThongKeDonHang.DSMaCoSo();
                thongKeTheoSoLuong(ds,dsTenCoSo,"Theo doanh thu");
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
                statisticsPanel.setBackground(Color.WHITE);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                statisticsPanel.setBackground(new Color(179, 177, 173));
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
                nhapThietBiPanel.setBackground(Color.WHITE);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                nhapThietBiPanel.setBackground(new Color(179, 177, 173));
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
                duyetDonHangPanel.setBackground(Color.WHITE);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                duyetDonHangPanel.setBackground(new Color(179, 177, 173));
            }
        });
        
        thongKeDoanhThuPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BLLThongKeDT bllThongKeDT = new BLLThongKeDT();
                thongKeDoanhThu(bllThongKeDT.layDSCoSo());
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
                thongKeDoanhThuPanel.setBackground(Color.WHITE);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                thongKeDoanhThuPanel.setBackground(new Color(179, 177, 173));
            }
        });
        // thêm đối tượng
        statisticsPanel.add(statisticLabel);        
        listPanel.add(listLabel);
        nhapThietBiPanel.add(nhapThietBiLabel);
        duyetDonHangPanel.add(duyetDonHangLabel);
        thongKeDoanhThuPanel.add(thongKeDoanhThuLabel);
        //bảng chọn chức năng
        managementPanel.setBackground(new Color(179, 177, 173));
        managementPanel.setLayout(null);
        managementPanel.setBounds(30,245,(int)(width * 0.22),height -  475);
        managementPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        managementPanel.add(listPanel);
        managementPanel.add(statisticsPanel);
        managementPanel.add(nhapThietBiPanel);
        managementPanel.add(duyetDonHangPanel);
        managementPanel.add(thongKeDoanhThuPanel);
        managementPanel.setVisible(false);
        leftPanel.add(managementPanel);

        //chức năng:
        //quản lý danh sách:
        //right panel
        rightPanel.setBounds((int)(width * 0.25),0,(int)(width * 0.75),height);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(border);

        //thêm đối tượng
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        adminFrame.add(mainPanel);

        adminFrame.setVisible(true);
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
                        @SuppressWarnings("rawtypes")
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
        rightPanel.setLayout(null);
        //tiêu đề bên phải 
        JLabel rightTitle = new JLabel("Quản lý danh sách");
        rightTitle.setFont(new Font("Times New Roman", 1, 35));
        rightTitle.setBounds(450, 0, 1000,60);        
        
        //Chọn bảng cần quản lý
        String[] tenDanhSach = {"Cơ sở", "Dịch vụ", "Hội viên", "Nhân viên", "Thiết bị", "Thiết bị cơ sở", "Hóa đơn","Hàng hóa cơ sở"};
        @SuppressWarnings("rawtypes")
        JComboBox danhSachBox = new JComboBox<String>(tenDanhSach);
        danhSachBox.setBounds(680,50,100,30);
        JLabel chonDanhSachLabel = new JLabel("Chọn danh sách: ");
        chonDanhSachLabel.setFont(new Font("Times New Roman", 1, 30));
        chonDanhSachLabel.setBounds(430, 50, 300,35);
        
        danhSachBox.addActionListener(new ActionListener() {
            //xóa những gì đã hiển thị của một danh sách
            public void xoaHienThi(JPanel rightPanel){
                int x = 6; // Thay thế ... bằng tọa độ x của điểm bạn muốn kiểm tra
                int y = 460; // Thay thế ... bằng tọa độ y của điểm bạn muốn kiểm tra
                int x1 = 6;
                int y1 = 176;

                Component component = rightPanel.getComponentAt(x, y);
                Component component1 = rightPanel.getComponentAt(x1, y1);
                Component[] btn = rightPanel.getComponents();
                if (component != null && component.isShowing()) {
                    // Component tại điểm đã cho tồn tại và đang được hiển thị
                    for(Component a : btn){
                        if(a instanceof JButton){
                            rightPanel.remove(a);
                        }
                    }
                    rightPanel.remove(component);
                    rightPanel.remove(component1);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                }
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("unchecked")
                JComboBox<String> comboBox = (JComboBox<String>) e.getSource(); // Lấy ra JComboBox đã được kích hoạt
                String selectedOption = (String) comboBox.getSelectedItem(); // Lấy ra mục đã chọn trong JComboBox
                JTable dataTable;
                JScrollPane scrollPane;
                JPanel bangChinhSua;
                
                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();

                ArrayList<String> tenCotHV = bllQuanLyDanhSach.layTenCotHoiVien();
                ArrayList<HoiVien> dsHV = bllQuanLyDanhSach.getDataHoiVien();

                ArrayList<String> tenCotCS = bllQuanLyDanhSach.layTenCotCoSo();
                DSCoSo dsCS =  bllQuanLyDanhSach.layDsCoSo();

                DSLoaiThietBi dsTB = bllQuanLyDanhSach.layDSLoaiThietBi();
                ArrayList<String> tenCotTB = bllQuanLyDanhSach.layTenCotThietBi();
                
                if (selectedOption.equals("Cơ sở")) {
                    xoaHienThi(rightPanel);
                    // tạo model bảng
                    DefaultTableModel csList = new DefaultTableModel();
                    for (int i = 0; i < tenCotCS.size(); i++) {
                        csList.addColumn(tenCotCS.get(i));
                    }
                    // Thêm dữ liệu vào bảng
                    for (int i = 0; i < dsCS.dsCoSo.size(); i++) {
                        csList.addRow(new Object[]{
                            dsCS.dsCoSo.get(i).getMaCoSo(),
                            dsCS.dsCoSo.get(i).getTenCoSo(),
                            dsCS.dsCoSo.get(i).getDiaChi(),
                            dsCS.dsCoSo.get(i).getThoiGianHoatDong(),
                            dsCS.dsCoSo.get(i).getSDT(),
                            dsCS.dsCoSo.get(i).getDoanhThu()
                        });
                    }
                    
                    //bảng hiện dòng thông tin được chọn
                    bangChinhSua = new JPanel();
                    for(int i=0;i<tenCotCS.size();i++){
                        bangChinhSua.setBounds(5,175,(int)(width*0.75)-30,270);
                        bangChinhSua.setLayout(new GridLayout(3,3,10,10));
                        TitledBorder titledBorder = BorderFactory.createTitledBorder("Thông tin chi tiết");
                        bangChinhSua.setBorder(titledBorder);
                        JPanel tempPanel = new JPanel();
                        
                        JTextField tempTF = new JTextField();
                        tempTF.setPreferredSize(new Dimension(150,20));
                        tempTF.setBounds(0,20,120,20);
                        tempTF.setName(tenCotCS.get(i));

                        JLabel tempLabel = new JLabel(tenCotCS.get(i));
                        tempLabel.setFont(new Font("Times New Roman", 1,20));
                        tempLabel.setPreferredSize(new Dimension(150,20));

                        if(i==0){
                            tempTF.setEditable(false);
                        }
                        tempPanel.add(tempLabel);
                        tempPanel.add(tempTF);
                        bangChinhSua.add(tempPanel);
                    }

                    rightPanel.add(bangChinhSua);
                    rightPanel.revalidate();
                    rightPanel.repaint();

                    dataTable = new JTable(csList);
                    dataTable.getTableHeader().setReorderingAllowed(false);
                    
                    scrollPane = new JScrollPane(dataTable);
                    scrollPane.setBounds(5,460,(int)(width*0.75)-20,400);
                    
                    //thêm nút chức năng
                    String[] cmtNut = {"add", "remove", "edit", "Search"};
                    String[] anhStrings = {
                        "src/asset/img/button/them-cs.png",
                        "src/asset/img/button/xoa-cs.png",
                        "src/asset/img/button/sua-cs.png",
                        "src/asset/img/button/tim-cs.png"
                    };
                    int a=355;
                    for(int i=0;i<cmtNut.length;i++){
                        JButton tempBtn = new JButton();
                        ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
                        Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(155, 57,Image.SCALE_DEFAULT);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.setBounds(a,110,155,57);
                        tempBtn.setIcon(new ImageIcon(scaleTempBtnImg));
                        tempBtn.setHorizontalAlignment(SwingConstants.CENTER);
                        tempBtn.setBorder(null);
                        tempBtn.addActionListener(new ActionListener() {
                            private int demLanNutTimKiem=0;
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(tempBtn.getActionCommand().equals(cmtNut[0])){ //thêm cơ sở
                                    boolean flag = true; // cờ hiệu gán giá trị cho mã hội viên
                                    ArrayList<String> thongTinMoi = new ArrayList<String>(); 
                                    Component[] components = bangChinhSua.getComponents();
                                    for (int i=0; i<components.length;i++) {
                                        if (components[i] instanceof JPanel) {
                                            JPanel tempPanel = (JPanel) components[i];
                                            Component[] smallComponents = tempPanel.getComponents();
                                            for (int j=0;j<smallComponents.length;j++) {
                                                if(smallComponents[j] instanceof JTextField){
                                                    JTextField textField = (JTextField) smallComponents[j];
                                                    String text = textField.getText().trim(); // Lấy text từ textField và loại bỏ khoảng trắng đầu cuối
                                                    if (flag && j == 1) {
                                                        int maxSTT = bllQuanLyDanhSach.kiemTraMaCoSo();
                                                        textField.setText(String.format("CS%03d", maxSTT));
                                                        thongTinMoi.add(textField.getText());
                                                        flag = false;
                                                    }
                                                    else if(bllQuanLyDanhSach.kiemTraDoanhThu(textField.getText())==-1 && j==1 && i==5){
                                                        JOptionPane.showMessageDialog(bangChinhSua, "Doanh thu phải là số và lớn hơn hoặc bằng 0", "Thông tin không hợp lệ", JOptionPane.WARNING_MESSAGE);
                                                        textField.requestFocus();
                                                        return; // Kết thúc sự kiện nếu có thông tin bị thiếu
                                                    }
                                                    else if (text.equals("")) {
                                                        JOptionPane.showMessageDialog(bangChinhSua, "Không được để trống thông tin!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
                                                        textField.requestFocus();
                                                        return; // Kết thúc sự kiện nếu có thông tin bị thiếu
                                                    } 
                                                    else {
                                                        thongTinMoi.add(text);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                     // Kiểm tra xem thongTinMoi có đủ 8 phần tử không trước khi thêm vào hvList
                                    if (thongTinMoi.size() >= 6) {
                                        csList.addRow(thongTinMoi.toArray());
                                        CoSo tempCS = new CoSo(thongTinMoi.get(0),
                                                                    thongTinMoi.get(1),
                                                                    thongTinMoi.get(2),
                                                                    thongTinMoi.get(3),
                                                                    thongTinMoi.get(4),
                                                                    Integer.parseInt(thongTinMoi.get(5)));
                                        if(bllQuanLyDanhSach.themCS(tempCS)){
                                            JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công!");
                                        }
                                        } else {
                                            JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[1])){ //xóa cơ sở
                                    int i=dataTable.getSelectedRow();
                                    if(i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        csList.removeRow(i);
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                        if(bllQuanLyDanhSach.xoaCS(textField.getText())){
                                                            textField.setText("");
                                                            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Xóa cơ sở", JOptionPane.INFORMATION_MESSAGE);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                            textField.setText("");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[2])){ // sửa thông tin cơ sở
                                    int i= dataTable.getSelectedRow();
                                    int j= 0;
                                    if (i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if (smallComponent instanceof JTextField) {
                                                        JTextField textField = (JTextField) smallComponent;
                                                        String text = textField.getText();
                                                        csList.setValueAt(text,i,j);
                                                        j++;
                                                    }
                                                }
                                            }
                                        }
                                        String sdtCS = (String) csList.getValueAt(i, 4);
                                        if(!bllQuanLyDanhSach.kiemTraSDT(sdtCS)){
                                            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else{
                                            CoSo tempCS = new CoSo((String)csList.getValueAt(i, 0),
                                                                        (String) csList.getValueAt(i, 1),
                                                                        (String) csList.getValueAt(i, 2),
                                                                        (String) csList.getValueAt(i, 3),
                                                                        (String) csList.getValueAt(i, 4),
                                                                        Integer.parseInt((String)csList.getValueAt(i, 5)));
                                            if(bllQuanLyDanhSach.suaThongTinCS(tempCS)){
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } 
                                    
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[3])){
                                    demLanNutTimKiem++;
                                    Component[] components = bangChinhSua.getComponents();
                                    JTextField textField;
                                    if(demLanNutTimKiem == 1){
                                        for (int i=0;i<components.length;i++) {
                                            if (components[i] instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) components[i];
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (int j=0;j<smallComponents.length;j++) {
                                                    if (smallComponents[j] instanceof JTextField) {
                                                        textField = (JTextField) smallComponents[j];
                                                        if(i==0 && j==1 && !textField.isEditable()){
                                                            textField.setEditable(true);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else if(demLanNutTimKiem == 2){
                                        JPanel tempPanel = (JPanel) components[0];
                                        Component[] smallComponents = tempPanel.getComponents();
                                        textField = (JTextField) smallComponents[1];
                                        int row =0;
                                        int column =0;
                                        if(bllQuanLyDanhSach.timKiemCS(textField.getText().toUpperCase())){
                                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm thành công","Tìm kiếm cơ sở", JOptionPane.INFORMATION_MESSAGE);
                                            for(int i=0; i<dsCS.dsCoSo.size();i++){
                                                if(textField.getText().toUpperCase().equals(dsCS.dsCoSo.get(i).getMaCoSo())){
                                                    dataTable.changeSelection(i,0,false,false);
                                                    break;
                                                }
                                            }
                                            textField.setEditable(false);
                                            demLanNutTimKiem=0;
                                            //hiển thị nội dung trong textField
                                            for (int j = 0; j < components.length; j++) {
                                                if (components[j] instanceof JPanel) {
                                                    JPanel panel = (JPanel) components[j];
                                                    Component[] smallComponents2 = panel.getComponents();
                                                    for (int i = 0; i < smallComponents2.length; i++) {
                                                        if (smallComponents2[i] instanceof JTextField) {
                                                            JTextField tempTF = (JTextField) smallComponents2[i];
                                                            if(column==5){
                                                                tempTF.setText(csList.getValueAt(row, column).toString());
                                                            }
                                                            else
                                                                tempTF.setText(((String) csList.getValueAt(row, column)).trim());
                                                        }
                                                    }
                                                    column++;
                                                }
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm không thành công","Tìm kiếm cơ sở", JOptionPane.ERROR_MESSAGE);
                                            demLanNutTimKiem=1;
                                            return;
                                        }
                                    }
                                }
                            }
                            
                        });
                        a+=175;
                        rightPanel.add(tempBtn);
                    }

                    rightPanel.add(scrollPane);

                    //xử lý sự kiện cho bảng
                    dataTable.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int i = dataTable.getSelectedRow();
                            if(i>=0){
                                Component[] components = bangChinhSua.getComponents();
                                int j=0;
                                for(Component a : components){
                                    if(a instanceof JPanel){
                                        JPanel tempPanel = (JPanel) a;
                                        Component[] smallComponents = tempPanel.getComponents();
                                        for(Component b : smallComponents){
                                            if(b instanceof JTextField){
                                                JTextField tempTF = (JTextField) b;
                                                tempTF.setText(csList.getValueAt(i, j).toString().trim());
                                                j++;
                                            }
                                        }
                                    }
                                }
                                bangChinhSua.revalidate();
                                bangChinhSua.repaint();
                            }
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        
                    });
                }
                else if(selectedOption.equals("Dịch vụ")){
                    xoaHienThi(rightPanel);

                }
                else if (selectedOption.equals("Hội viên")) {
                    xoaHienThi(rightPanel);
                    // tạo model bảng
                    DefaultTableModel hvList = new DefaultTableModel();
                    for (int i = 0; i < tenCotHV.size(); i++) {
                        hvList.addColumn(tenCotHV.get(i));
                    }
                    // Thêm dữ liệu vào bảng
                    for (int i = 0; i < dsHV.size(); i++) {
                        hvList.addRow(new Object[]{dsHV.get(i).getMaHoiVien(),
                            dsHV.get(i).getHoten(),
                            dsHV.get(i).getGioitinh(),
                            dsHV.get(i).getMail(),
                            dsHV.get(i).getTaiKhoanHoiVien(),
                            dsHV.get(i).getMatKhauHoiVien(),
                            dsHV.get(i).getNgaysinh(),
                            dsHV.get(i).getSdt()});
                    }
                    
                    //bảng hiện dòng thông tin được chọn
                    bangChinhSua = new JPanel();
                    for(int i=0;i<tenCotHV.size();i++){
                        bangChinhSua.setBounds(5,175,(int)(width*0.75)-30,270);
                        bangChinhSua.setLayout(new GridLayout(3,3,10,10));
                        TitledBorder titledBorder = BorderFactory.createTitledBorder("Thông tin chi tiết");
                        bangChinhSua.setBorder(titledBorder);
                        
                        JPanel tempPanel = new JPanel();
                        
                        JTextField tempTF = new JTextField();
                        tempTF.setPreferredSize(new Dimension(100,20));
                        tempTF.setBounds(0,20,120,20);
                        tempTF.setName(tenCotHV.get(i));

                        JLabel tempLabel = new JLabel(tenCotHV.get(i));
                        tempLabel.setFont(new Font("Times New Roman", 1,20));
                        tempLabel.setPreferredSize(new Dimension(120,20));

                        if(i==0){
                            tempTF.setEditable(false);
                        }
                        if(i==2){
                            Font font = new Font("Times New Roman", Font.BOLD, 20); // Thay đổi font và kích thước chữ ở đây
                            JRadioButton nam = new JRadioButton("Nam");
                            nam.setBounds(0,0,100,30);
                            JRadioButton nu = new JRadioButton("Nữ");
                            nu.setBounds(0,0,100,30);
                            ButtonGroup gioiTinh = new ButtonGroup();
                            nam.setFont(font);
                            nu.setFont(font);
                            gioiTinh.add(nam);
                            gioiTinh.add(nu);
                            tempPanel.add(nam);
                            tempPanel.add(nu);
                            bangChinhSua.add(tempPanel);
                            continue;
                        }
                        tempPanel.add(tempLabel);
                        tempPanel.add(tempTF);
                        bangChinhSua.add(tempPanel);
                    }

                    rightPanel.add(bangChinhSua);
                    rightPanel.revalidate();
                    rightPanel.repaint();

                    dataTable = new JTable(hvList);
                    dataTable.getTableHeader().setReorderingAllowed(false);
                    
                    scrollPane = new JScrollPane(dataTable);
                    scrollPane.setBounds(5,460,(int)(width*0.75)-20,400);

                    //nút chức năng
                    String[] cmtNut = {"add", "remove", "edit", "Search"};
                    String[] anhStrings = {
                        "src/asset/img/button/them-hv.png",
                        "src/asset/img/button/xoa-hv.png",
                        "src/asset/img/button/sua-hv.png",
                        "src/asset/img/button/tim-hv.png"
                    };
                    int a=345;
                    for(int i=0;i<cmtNut.length;i++){
                        JButton tempBtn = new JButton();
                        ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
                        Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(155, 57,Image.SCALE_DEFAULT);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.setBounds(a,110,155,57);
                        tempBtn.setIcon(new ImageIcon(scaleTempBtnImg));
                        tempBtn.setHorizontalAlignment(SwingConstants.CENTER);
                        tempBtn.setBorder(null);
                        tempBtn.addActionListener(new ActionListener() {
                            int demLanNutTimKiem=0;
                            public void actionPerformed(ActionEvent e) {
                                if (e.getActionCommand().equals(cmtNut[0])) { //THÊM HỘI VIÊN
                                    boolean flag = true; // cờ hiệu gán giá trị cho mã hội viên
                                    ArrayList<String> thongTinMoi = new ArrayList<String>(); 
                                    Component[] components = bangChinhSua.getComponents();
                                    for (int i=0; i<components.length;i++) {
                                        if (components[i] instanceof JPanel) {
                                            JPanel tempPanel = (JPanel) components[i];
                                            Component[] smallComponents = tempPanel.getComponents();
                                            for (int j=0;j<smallComponents.length;j++) {
                                                if(smallComponents[j] instanceof JTextField){
                                                    JTextField textField = (JTextField) smallComponents[j];
                                                    String text = textField.getText().trim(); // Lấy text từ textField và loại bỏ khoảng trắng đầu cuối
                                                    if (flag && j == 1) {
                                                        int maxSTT = bllQuanLyDanhSach.kiemTraMaHoiVien();
                                                        textField.setText(String.format("HV%03d", maxSTT));
                                                        thongTinMoi.add(textField.getText());
                                                        flag = false;
                                                    }
                                                    else if(i==7){
                                                        String hvSDT = textField.getText().trim();
                                                        if(!bllQuanLyDanhSach.kiemTraSDT(hvSDT)){
                                                                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);
                                                                return;
                                                        }
                                                        else{
                                                            thongTinMoi.add(hvSDT);
                                                        }
                                                    }
                                                    else if (text.equals("")) {
                                                        JOptionPane.showMessageDialog(bangChinhSua, "Không được để trống thông tin!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
                                                        return; // Kết thúc sự kiện nếu có thông tin bị thiếu
                                                    } 
                                                    else {
                                                        thongTinMoi.add(text);
                                                    }
                                                }
                                                else if(smallComponents[j] instanceof JRadioButton){
                                                    JRadioButton tempRB = (JRadioButton) smallComponents[j];
                                                    if(tempRB.isSelected()){
                                                        thongTinMoi.add(tempRB.getText());
                                                    }
                                                    else{
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                     // Kiểm tra xem thongTinMoi có đủ 8 phần tử không trước khi thêm vào hvList
                                    if (thongTinMoi.size() >= 8) {
                                        hvList.addRow(thongTinMoi.toArray());
                                        String dateString = thongTinMoi.get(6);
                                        String[] parts = dateString.split("-");
                                        int year = Integer.parseInt(parts[0]);
                                        int month = Integer.parseInt(parts[1]);
                                        int day = Integer.parseInt(parts[2]);

                                        @SuppressWarnings("deprecation")
                                        Date date = new Date(year - 1900, month - 1, day); // Tạo đối tượng Date từ năm, tháng và ngày

                                        HoiVien tempHV = new HoiVien(thongTinMoi.get(0),
                                                                    thongTinMoi.get(1),
                                                                    thongTinMoi.get(2),
                                                                    thongTinMoi.get(3),
                                                                    thongTinMoi.get(4),
                                                                    thongTinMoi.get(5),
                                                                    date,
                                                                    thongTinMoi.get(7));
                                        if(bllQuanLyDanhSach.themHV(tempHV)){
                                            JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công!");
                                        }
                                        } else {
                                            JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                                else if (e.getActionCommand().equals(cmtNut[1])) {//XÓA HỘI VIÊN
                                    int i=dataTable.getSelectedRow();
                                    if(i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        hvList.removeRow(i);
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                        if(bllQuanLyDanhSach.xoaHV(textField.getText())){
                                                            textField.setText("");
                                                            JOptionPane.showMessageDialog(null, "Xóa hội viên thành công", "Xóa hội viên", JOptionPane.INFORMATION_MESSAGE);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                            textField.setText("");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } 
                                else if (e.getActionCommand().equals(cmtNut[2])) {//SỬA THÔNG TIN HỘI VIÊN
                                    int i= dataTable.getSelectedRow();
                                    int j= 0;
                                    if (i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if (smallComponent instanceof JTextField) {
                                                        JTextField textField = (JTextField) smallComponent;
                                                        String text = textField.getText();
                                                        hvList.setValueAt(text,i,j);
                                                        j++;
                                                    }
                                                    else if(smallComponent instanceof JRadioButton){
                                                        JRadioButton tempRB = (JRadioButton)smallComponent;
                                                        if(tempRB.isSelected()){
                                                            hvList.setValueAt(tempRB.getText(), i, j);
                                                            j++;
                                                        }
                                                        else{
                                                            continue;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        String dateString = (String) hvList.getValueAt(i, 6);
                                        String[] parts = dateString.split("-");
                                        int year = Integer.parseInt(parts[0]);
                                        int month = Integer.parseInt(parts[1]);
                                        int day = Integer.parseInt(parts[2]);
                                        String matKhauHV = (String) hvList.getValueAt(i, 5);
                                        String sdtHV = (String) hvList.getValueAt(i, 7);
                                        if(!bllQuanLyDanhSach.kiemTraSDT(sdtHV)){
                                            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else if(matKhauHV.length()<6){
                                            JOptionPane.showMessageDialog(null, "Mật khẩu phải dài hơn 6 kí tự", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        else{
                                            @SuppressWarnings("deprecation")
                                            Date date = new Date(year - 1900, month - 1, day); // Tạo đối tượng Date từ năm, tháng và ngày
                                            HoiVien tempHV = new HoiVien((String)hvList.getValueAt(i, 0),
                                                                        (String) hvList.getValueAt(i, 1),
                                                                        (String) hvList.getValueAt(i, 2),
                                                                        (String) hvList.getValueAt(i, 3),
                                                                        (String) hvList.getValueAt(i, 4),
                                                                        (String) hvList.getValueAt(i, 5),
                                                                        date,
                                                                        (String) hvList.getValueAt(i, 7));
                                            if(bllQuanLyDanhSach.suaThongTinHV(tempHV)){
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } 
                                    
                                }
                                //tỉm kiếm hội viên
                                else if (e.getActionCommand().equals(cmtNut[3])) {
                                    demLanNutTimKiem++;
                                    Component[] components = bangChinhSua.getComponents();
                                    JTextField textField;
                                    if(demLanNutTimKiem == 1){
                                        for (int i=0;i<components.length;i++) {
                                            if (components[i] instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) components[i];
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (int j=0;j<smallComponents.length;j++) {
                                                    if (smallComponents[j] instanceof JTextField) {
                                                        textField = (JTextField) smallComponents[j];
                                                        if(i==0 && j==1 && !textField.isEditable()){
                                                            textField.setEditable(true);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else if(demLanNutTimKiem == 2){
                                        JPanel tempPanel = (JPanel) components[0];
                                        Component[] smallComponents = tempPanel.getComponents();
                                        textField = (JTextField) smallComponents[1];
                                        int row=0;
                                        int column=0;
                                        if(bllQuanLyDanhSach.timKiemHV(textField.getText().toUpperCase().trim())){
                                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm thành công","Tìm kiếm hội viên", JOptionPane.INFORMATION_MESSAGE);
                                            for(int i=0; i<dsHV.size();i++){
                                                if(textField.getText().toUpperCase().equals(dsHV.get(i).getMaHoiVien())){
                                                    dataTable.changeSelection(i,0,false,false);
                                                    break;
                                                }
                                            }
                                            row = dataTable.getSelectedRow();
                                        //hiển thị nội dung trong textField
                                        for (int j = 0; j < components.length; j++) {
                                            if (components[j] instanceof JPanel) {
                                                JPanel panel = (JPanel) components[j];
                                                Component[] smallComponents2 = panel.getComponents();
                                                for (int i = 0; i < smallComponents2.length; i++) {
                                                    if (smallComponents2[i] instanceof JTextField) {
                                                        JTextField tempTF = (JTextField) smallComponents2[i];
                                                        tempTF.setText(((String) hvList.getValueAt(row, column)).trim());
                                                    }
                                                }
                                                column++;
                                            }
                                        }
                                            textField.setEditable(false);
                                            demLanNutTimKiem=0;
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm không thành công","Tìm kiếm hội viên", JOptionPane.ERROR_MESSAGE);
                                            demLanNutTimKiem=1;
                                            return;
                                        }
                                    }
                                    
                                }
                            }
                        });
                        a+=175;
                        rightPanel.add(tempBtn);
                    }

                    rightPanel.add(scrollPane);
                    
                    //xử lý sự kiện cho bảng
                    dataTable.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int i = dataTable.getSelectedRow();
                            if(i>=0){
                                Component[] components = bangChinhSua.getComponents();
                                int j=0;
                                for(Component a : components){
                                    if(a instanceof JPanel){
                                        JPanel tempPanel = (JPanel) a;
                                        Component[] smallComponents = tempPanel.getComponents();
                                        for(Component b : smallComponents){
                                            if(b instanceof JTextField){
                                                JTextField tempTF = (JTextField) b;
                                                tempTF.setText(hvList.getValueAt(i, j).toString().trim());
                                                j++;
                                            }
                                            else if(b instanceof JRadioButton) { 
                                                JRadioButton tempRB = (JRadioButton) b;
                                                if(tempRB.getText().equals("Nam") && tempRB.getText().equals(hvList.getValueAt(i, j).toString().trim())){
                                                    tempRB.setSelected(true);
                                                    j++;
                                                    continue;
                                                }
                                                else if(tempRB.getText().equals("Nữ") && tempRB.getText().equals(hvList.getValueAt(i, j).toString().trim())){
                                                    tempRB.setSelected(true);
                                                    j++;
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }
                                bangChinhSua.revalidate();
                                bangChinhSua.repaint();
                            }
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        
                    });
                }
                else if (selectedOption.equals("Nhân viên")){
                    xoaHienThi(rightPanel);
                }
                else if(selectedOption.equals("Thiết bị")){
                    xoaHienThi(rightPanel);
                    // tạo model bảng
                    DefaultTableModel tbList = new DefaultTableModel();
                    for (int i = 0; i < tenCotTB.size(); i++) {
                        tbList.addColumn(tenCotTB.get(i));
                    }
                    // Thêm dữ liệu vào bảng
                    for (int i = 0; i < dsTB.dsThietBi.size(); i++) {
                        tbList.addRow(new Object[]{
                            dsTB.dsThietBi.get(i).getMaThietBi(),
                            dsTB.dsThietBi.get(i).getTenLoaiThietBi(),
                            dsTB.dsThietBi.get(i).getHinhAnh(),
                            dsTB.dsThietBi.get(i).getGiaThietBi(),
                            dsTB.dsThietBi.get(i).getNgayBaoHanh(),
                        });
                    }
                    
                    //bảng hiện dòng thông tin được chọn
                    bangChinhSua = new JPanel();
                    for(int i=0;i<tenCotTB.size();i++){
                        bangChinhSua.setBounds(5,175,(int)(width*0.75)-30,270);
                        bangChinhSua.setLayout(new GridLayout(3,3,10,10));
                        TitledBorder titledBorder = BorderFactory.createTitledBorder("Thông tin chi tiết");
                        bangChinhSua.setBorder(titledBorder);
                        
                        JPanel tempPanel = new JPanel();
                        
                        JTextField tempTF = new JTextField();
                        tempTF.setPreferredSize(new Dimension(150,20));
                        tempTF.setBounds(0,20,120,20);
                        tempTF.setName(tenCotTB.get(i));

                        JLabel tempLabel = new JLabel(tenCotTB.get(i));
                        tempLabel.setFont(new Font("Times New Roman", 1,20));
                        tempLabel.setPreferredSize(new Dimension(150,20));

                        if(i==0){
                            tempTF.setEditable(false);
                        }
                        tempPanel.add(tempLabel);
                        tempPanel.add(tempTF);
                        bangChinhSua.add(tempPanel);
                    }

                    rightPanel.add(bangChinhSua);
                    rightPanel.revalidate();
                    rightPanel.repaint();

                    dataTable = new JTable(tbList);
                    dataTable.getTableHeader().setReorderingAllowed(false);
                    
                    scrollPane = new JScrollPane(dataTable);
                    scrollPane.setBounds(5,460,(int)(width*0.75)-20,400);
                    
                    //thêm nút chức năng
                    String[] cmtNut = {"add", "remove", "edit", "Search"};
                    String[] anhStrings = {
                        "src/asset/img/button/them-tb.png",
                        "src/asset/img/button/xoa-tb.png",
                        "src/asset/img/button/sua-tb.png",
                        "src/asset/img/button/tim-tb.png"
                    };
                    int a=345;
                    for(int i=0;i<cmtNut.length;i++){
                        JButton tempBtn = new JButton();
                        ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
                        Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(155, 57,Image.SCALE_DEFAULT);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.setBounds(a,110,155,57);
                        tempBtn.setIcon(new ImageIcon(scaleTempBtnImg));
                        tempBtn.setHorizontalAlignment(SwingConstants.CENTER);
                        tempBtn.setBorder(null);
                        tempBtn.addActionListener(new ActionListener() {
                            private int demLanNutTimKiem=0;
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(tempBtn.getActionCommand().equals(cmtNut[0])){ //thêm thiết bị
                                    boolean flag = true; // cờ hiệu gán giá trị cho mã hội viên
                                    ArrayList<String> thongTinMoi = new ArrayList<String>(); 
                                    Component[] components = bangChinhSua.getComponents();
                                    for (int i=0; i<components.length;i++) {
                                        if (components[i] instanceof JPanel) {
                                            JPanel tempPanel = (JPanel) components[i];
                                            Component[] smallComponents = tempPanel.getComponents();
                                            for (int j=0;j<smallComponents.length;j++) {
                                                if(smallComponents[j] instanceof JTextField){
                                                    JTextField textField = (JTextField) smallComponents[j];
                                                    String text = textField.getText().trim(); // Lấy text từ textField và loại bỏ khoảng trắng đầu cuối
                                                    if (flag && j == 1) {
                                                        int maxSTT = bllQuanLyDanhSach.kiemTraMaThietBi();
                                                        textField.setText(String.format("TB%03d", maxSTT));
                                                        thongTinMoi.add(textField.getText());
                                                        flag = false;
                                                    }
                                                    else if(bllQuanLyDanhSach.kiemTraGiaThietBi(textField.getText())==-1 && j==0 && i==4){
                                                        JOptionPane.showMessageDialog(bangChinhSua, "Giá thiết bị phải là số và lớn hơn hoặc bằng 0", "Thông tin không hợp lệ", JOptionPane.WARNING_MESSAGE);
                                                        textField.requestFocus();
                                                        return; // Kết thúc sự kiện nếu có thông tin bị thiếu
                                                    }
                                                    else if (text.equals("")) {
                                                        JOptionPane.showMessageDialog(bangChinhSua, "Không được để trống thông tin!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
                                                        textField.requestFocus();
                                                        return; // Kết thúc sự kiện nếu có thông tin bị thiếu
                                                    } 
                                                    else {
                                                        thongTinMoi.add(text);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                     // Kiểm tra xem thongTinMoi có đủ 8 phần tử không trước khi thêm vào hvList
                                    if (thongTinMoi.size() >= 5) {
                                        tbList.addRow(thongTinMoi.toArray());
                                        LoaiThietBi tempTB = new LoaiThietBi(thongTinMoi.get(0),
                                                                    thongTinMoi.get(1),
                                                                    thongTinMoi.get(2),
                                                                    thongTinMoi.get(3),
                                                                    Integer.parseInt(thongTinMoi.get(4)));
                                        if(bllQuanLyDanhSach.themTB(tempTB)){
                                            JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công!");
                                        }
                                        } else {
                                            JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[1])){ //xóa thiết bị
                                    int i=dataTable.getSelectedRow();
                                    if(i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        tbList.removeRow(i);
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                        if(bllQuanLyDanhSach.xoaTB(textField.getText())){
                                                            textField.setText("");
                                                            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Xóa thiết bị", JOptionPane.INFORMATION_MESSAGE);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                            textField.setText("");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[2])){
                                    int i= dataTable.getSelectedRow();
                                    int j= 0;
                                    if (i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if (smallComponent instanceof JTextField) {
                                                        JTextField textField = (JTextField) smallComponent;
                                                        String text = textField.getText();
                                                        tbList.setValueAt(text,i,j);
                                                        j++;
                                                    }
                                                }
                                            }
                                        }
                                        String giaThietBi = (String) tbList.getValueAt(i, 3);
                                        if(bllQuanLyDanhSach.kiemTraGiaThietBi(giaThietBi)==-1){
                                            JOptionPane.showMessageDialog(null, "Giá thiết bị phải lớn hơn hoặc bằng 0", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else{
                                            LoaiThietBi tempTB = new LoaiThietBi((String)tbList.getValueAt(i,0),
                                                                    (String)tbList.getValueAt(i,1),
                                                                    (String)tbList.getValueAt(i,2),
                                                                    (String)tbList.getValueAt(i,3),
                                                                    Integer.parseInt((String)tbList.getValueAt(i,4)));
                                            if(bllQuanLyDanhSach.suaThongTinTB(tempTB)){
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    } 
                                    
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[3])){ //tìm kiếm thiết bị theo mã tron danh sách
                                    this.demLanNutTimKiem++;
                                    Component[] components = bangChinhSua.getComponents();
                                    JTextField textField;
                                    if(this.demLanNutTimKiem == 1){
                                        for (int i=0;i<components.length;i++) {
                                            if (components[i] instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) components[i];
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (int j=0;j<smallComponents.length;j++) {
                                                    if (smallComponents[j] instanceof JTextField) {
                                                        textField = (JTextField) smallComponents[j];
                                                        if(i==0 && j==1 && !textField.isEditable()){
                                                            textField.setEditable(true);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else if(this.demLanNutTimKiem == 2){
                                        JPanel tempPanel = (JPanel) components[0];
                                        Component[] smallComponents = tempPanel.getComponents();
                                        textField = (JTextField) smallComponents[1];
                                        int row =0;
                                        int column =0;
                                        if(bllQuanLyDanhSach.timKiemTheoMaTB(textField.getText().toUpperCase())){
                                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm thành công","Tìm kiếm thiết bị", JOptionPane.INFORMATION_MESSAGE);
                                            for(int i=0; i<dsTB.dsThietBi.size();i++){
                                                if(textField.getText().toUpperCase().equals(dsTB.dsThietBi.get(i).getMaThietBi())){
                                                    dataTable.changeSelection(i,0,false,false);
                                                    break;
                                                }
                                            }
                                            textField.setEditable(false);
                                            this.demLanNutTimKiem=0;
                                            //hiển thị nội dung trong textField
                                            for (int j = 0; j < components.length; j++) {
                                                if (components[j] instanceof JPanel) {
                                                    JPanel panel = (JPanel) components[j];
                                                    Component[] smallComponents2 = panel.getComponents();
                                                    for (int i = 0; i < smallComponents2.length; i++) {
                                                        if (smallComponents2[i] instanceof JTextField) {
                                                            JTextField tempTF = (JTextField) smallComponents2[i];
                                                            if(column==4){
                                                                tempTF.setText(tbList.getValueAt(row, column).toString());
                                                            }
                                                            else
                                                                tempTF.setText(((String) tbList.getValueAt(row, column)).trim());
                                                        }
                                                    }
                                                    column++;
                                                }
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm không thành công","Tìm kiếm thiết bị", JOptionPane.ERROR_MESSAGE);
                                            demLanNutTimKiem=1;
                                            return;
                                        }
                                    }
                                }
                            }
                            
                        });
                        a+=175;
                        rightPanel.add(tempBtn);
                    }
                    rightPanel.add(scrollPane);

                    //xử lý sự kiện cho bảng
                    dataTable.addMouseListener(new MouseListener() {
                        
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int i = dataTable.getSelectedRow();
                            if(i>=0){
                                Component[] components = bangChinhSua.getComponents();
                                int j=0;
                                for(Component a : components){
                                    if(a instanceof JPanel){
                                        JPanel tempPanel = (JPanel) a;
                                        Component[] smallComponents = tempPanel.getComponents();
                                        for(Component b : smallComponents){
                                            if(b instanceof JTextField){
                                                JTextField tempTF = (JTextField) b;
                                                tempTF.setText(tbList.getValueAt(i, j).toString().trim());
                                                j++;
                                            }
                                        }
                                    }
                                }
                                bangChinhSua.revalidate();
                                bangChinhSua.repaint();
                            }
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            // TODO Auto-generated method stub
                        }
                        
                    });
                }
                else if(selectedOption.equals("Thiết bị cơ sở")){
                    ArrayList<ThietBiCoSo> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDanhSachThietBiCoSo();
                    QuanLyBangThietBiCoSo(ds);
                }
                else if(selectedOption.equals("Hóa đơn")){
                    xoaHienThi(rightPanel);
                }
                else if(selectedOption.equals("Hàng hóa cơ sở")){
                    xoaHienThi(rightPanel);
                }
                // Thêm các xử lý khác nếu cần
            }
            public void QuanLyBangThietBiCoSo(ArrayList<ThietBiCoSo> ds)
            {
                xoaHienThi(rightPanel);
                JButton them = new JButton("Thêm");
                JButton xoa = new JButton("Xóa");
                JButton sua = new JButton("Sửa");
                JButton timKiem = new JButton("Tìm Kiếm");
                JPanel chucNang = new JPanel(new FlowLayout());
                chucNang.add(them);
                chucNang.add(xoa);
                chucNang.add(sua);
                chucNang.add(timKiem);
                chucNang.setBounds(5,120,rightPanel.getWidth()-5,35);
                rightPanel.add(chucNang);

                JLabel maThietBiCoSo = new JLabel("Mã Thiết Bị Cơ Sở: ");
                JTextField textMaThietBiCoSo = new JTextField();

                JLabel maThietBi = new JLabel("Mã Thiết Bị: ");
                JTextField textMaThietBi = new JTextField();

                JLabel maCoSo = new JLabel("Mã Cơ Sở: ");
                JTextField textMaCoSo = new JTextField();

                JLabel hanBaoHanh = new JLabel("Hạn Bảo Hành: ");
                JTextField textHanBaoHanh = new JTextField();
                
                JLabel ngayNhap = new JLabel("Ngày Nhập: ");
                JTextField textNgayNhap = new JTextField();

                int x = 10;
                maThietBiCoSo.setBounds(x, 170, 120, 30); x+=120;
                textMaThietBiCoSo.setBounds(x+10, 170, 100, 30); x+=110;
                maThietBi.setBounds(x+50, 170, 70, 30); x+=120;
                textMaThietBi.setBounds(x+10, 170, 100, 30); x+=110;
                maCoSo.setBounds(x+50, 170, 70, 30); x+=120;
                textMaCoSo.setBounds(x+10, 170, 100, 30); x+=110;
                ngayNhap.setBounds(x+50, 170, 70, 30); x+=120;
                textNgayNhap.setBounds(x+10,170,100,30); x+=110;
                hanBaoHanh.setBounds(x+50,170,90,30); x+=140;
                textHanBaoHanh.setBounds(x+10, 170, 100, 30);

                rightPanel.add(maThietBiCoSo);
                rightPanel.add(textMaThietBiCoSo);
                rightPanel.add(maThietBi);
                rightPanel.add(textMaThietBi);
                rightPanel.add(maCoSo);
                rightPanel.add(textMaCoSo);
                rightPanel.add(hanBaoHanh);
                rightPanel.add(textHanBaoHanh);
                rightPanel.add(ngayNhap);
                rightPanel.add(textNgayNhap);

                DefaultTableModel model = new DefaultTableModel();
                JTable bang = new JTable(); 

                model.addColumn("Mã Thiết Bị Cơ Sở");
                model.addColumn("Mã Cơ Sở");
                model.addColumn("Mã Thiết Bị");
                model.addColumn("Ngày Nhập");
                model.addColumn("Hạn Bảo Hành");


                model.setRowCount(0);
                for(int i = 0; i < ds.size(); i++) {
                    model.addRow(new Object[] {
                        ds.get(i).getMaThietBiCoSo(),ds.get(i).getMaCoSo(),ds.get(i).getMaThietBi(),ds.get(i).getNgayNhap(),ds.get(i).getHanBaoHanh() 
                    });
                }
                bang.setModel(model);
                bang.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e)
                    {
                        int i = bang.getSelectedRow();
                        if(i>=0)
                        {
                            textMaThietBiCoSo.setText(model.getValueAt(i, 0).toString());
                            textMaCoSo.setText(model.getValueAt(i, 1).toString());
                            textMaThietBi.setText(model.getValueAt(i, 2).toString());
                            textNgayNhap.setText(model.getValueAt(i, 3).toString());
                            textHanBaoHanh.setText(model.getValueAt(i, 4).toString());
                        }
                    }
                });
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(!textMaThietBiCoSo.getText().equals("") || !textHanBaoHanh.getText().equals("")) 
                        JOptionPane.showMessageDialog(rightPanel, "Không cần nhập mã thiết bị cơ sở và hạn bảo hành");
                        else 
                        {
                            if(textMaCoSo.getText().equals("")||textMaThietBi.getText().equals("")||textNgayNhap.getText().equals("")) 
                            JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                            else 
                            {   
                                LocalDate lDateNgayNhap = LocalDate.parse(textNgayNhap.getText());
                                Date ngayNhap = Date.valueOf(lDateNgayNhap);

                                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                                String ma = bllQuanLyDanhSach.layMaThietBiCoSo();
                                Date hanBaoHanh = bllQuanLyDanhSach.layHanBaoHanh(textMaThietBi.getText(), ngayNhap);
                                String s = bllQuanLyDanhSach.themThietBiCoSo(ma,textMaCoSo.getText(),textMaThietBi.getText(),ngayNhap,hanBaoHanh);
                                if(s.equals("ThanhCong"))
                                {
                                    model.addRow(new Object[]{
                                        ma,textMaCoSo.getText(),textMaThietBi.getText(),ngayNhap,hanBaoHanh
                                    });
                                    textMaThietBiCoSo.setText(ma);
                                    textHanBaoHanh.setText(String.valueOf(hanBaoHanh));
                                }
                                else JOptionPane.showMessageDialog(rightPanel, s);
                            }
                        }

                    }
                });
                xoa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(textMaThietBiCoSo.getText().equals("")) JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã thiết bị cơ sở");
                        else
                        {
                            BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                            if(bllQuanLyDanhSach.xoaThietBiCoSO(textMaThietBiCoSo.getText()))
                            {
                                for(int i=0;i<model.getRowCount();i++)
                                if(model.getValueAt(i, 0).equals(textMaThietBiCoSo.getText())) model.removeRow(i);
                            }
                            else JOptionPane.showMessageDialog(rightPanel, "Mã thiết bị cơ sở không tồn tại");
                        } 
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(textMaThietBiCoSo.getText().equals("")
                            ||textMaCoSo.getText().equals("")
                            ||textMaThietBi.getText().equals("")
                            ||textNgayNhap.getText().equals("")
                            ||textHanBaoHanh.getText().equals("")
                            ) JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                        else
                        {
                            LocalDate ngayNhap = LocalDate.parse(textNgayNhap.getText());
                            LocalDate hanBaoHanh = LocalDate.parse(textHanBaoHanh.getText());
                            BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                            String s = bllQuanLyDanhSach.suaThietBiCoSo(textMaThietBiCoSo.getText(), textMaCoSo.getText(), textMaThietBi.getText(), Date.valueOf(ngayNhap), Date.valueOf(hanBaoHanh));
                            if(s.equals("ThanhCong"))
                            {
                                for(int i=0;i<model.getRowCount();i++)
                                if(model.getValueAt(i,0).equals(textMaThietBiCoSo.getText())) 
                                {
                                    model.setValueAt(textMaCoSo.getText(),i,1);
                                    model.setValueAt(textMaThietBi.getText(),i,2);
                                    model.setValueAt(textNgayNhap.getText(),i,3);
                                    model.setValueAt(textHanBaoHanh.getText(),i,4);
                                }
                            }
                            else JOptionPane.showMessageDialog(rightPanel, s);
                        }
                    }
                });
                timKiem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        model.setRowCount(0);
                        if(textMaThietBiCoSo.getText().equals(""))
                        for(int i = 0; i < ds.size(); i++) {
                            model.addRow(new Object[] {
                                ds.get(i).getMaThietBiCoSo(),ds.get(i).getMaCoSo(),ds.get(i).getMaThietBi(),ds.get(i).getNgayNhap(),ds.get(i).getHanBaoHanh() 
                            });
                        }
                        else
                        {
                            BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                            ArrayList<ThietBiCoSo> ds2 = new ArrayList<>();
                            ds2 = bllQuanLyDanhSach.timKiemThietBiCoSo(textMaThietBiCoSo.getText());
                            for(int i = 0; i < ds2.size(); i++) {
                                model.addRow(new Object[] {
                                    ds2.get(i).getMaThietBiCoSo(),ds2.get(i).getMaCoSo(),ds2.get(i).getMaThietBi(),ds2.get(i).getNgayNhap(),ds2.get(i).getHanBaoHanh() 
                                });
                            }
                        }

                    }
                });
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(bang);
                scrollPane.setBounds(5, 230, rightPanel.getWidth()-20, rightPanel.getHeight()-300);
                rightPanel.add(scrollPane);
            }
        });
        rightPanel.add(rightTitle);
        rightPanel.add(chonDanhSachLabel);
        rightPanel.add(danhSachBox);
    }
    
    public void thongKeDoanhThu(DSCoSo CoSods)
    {
        rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        rightPanel.repaint(); // Vẽ lại JPanel
        rightPanel.setLayout(null);

        JPanel canGiua = new JPanel(new FlowLayout());
        canGiua.setBounds(5,5,rightPanel.getWidth(),55);
        canGiua.setBackground(Color.yellow);
        JLabel titleNhapThietBi = new JLabel("Thống kê kinh doanh");
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
        timkiem.setBounds(320, 15, 45, 29);
        timkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String tenCoSo = nhapTen.getText();
                BLLThongKeDT bllThongKeDT = new BLLThongKeDT();
                thongKeDoanhThu(bllThongKeDT.timKiemCoSo(tenCoSo));
            }
        });
        filter.add(timTheoTen);
        filter.add(nhapTen);
        filter.add(timkiem);
        rightPanel.add(filter);

        int chieuDocPanel = CoSods.dsCoSo.size()*100;
        int chieuNgangPanel = rightPanel.getWidth() - 250;
        int max = 0;
        for(int i=0;i<CoSods.dsCoSo.size();i++)
        {
            if(CoSods.dsCoSo.get(i).getDoanhThu() > max) max = CoSods.dsCoSo.get(i).getDoanhThu();
        }
        double tiLe;
        if(max != 0) tiLe = (double)chieuNgangPanel / max;
        else tiLe = 0;
        int y = 0;
        JPanel thongKe = new JPanel(null);
        thongKe.setPreferredSize(new Dimension(rightPanel.getWidth() - 10, chieuDocPanel));
        for(CoSo a : CoSods.dsCoSo)
        {
            JPanel JPanelThongke1CoSo = new JPanel(null);
            JPanelThongke1CoSo.setBounds(0, y, rightPanel.getWidth(), 50);
            JLabel labelTenCoSo = new JLabel(a.getTenCoSo());
            labelTenCoSo.setBounds(0,0,100,50);
            JLabel doanhThuCot = new JLabel();
            doanhThuCot.setBounds(100,0,(int)(tiLe*a.getDoanhThu()),50);
            doanhThuCot.setBackground(Color.BLUE);
            doanhThuCot.setOpaque(true); // Thêm dòng này để cho phép vẽ nền màu
            JLabel doanhThu = new JLabel(String.valueOf(a.getDoanhThu())+" đ");
            doanhThu.setBounds(doanhThuCot.getWidth()+labelTenCoSo.getWidth()+10, 0, 100, 50);
            JPanelThongke1CoSo.add(labelTenCoSo);
            JPanelThongke1CoSo.add(doanhThuCot);
            JPanelThongke1CoSo.add(doanhThu);
            thongKe.add(JPanelThongke1CoSo);
            y=y+100;
        }   
        JScrollPane cuon = new JScrollPane(thongKe);
        cuon.setBounds(2,150,rightPanel.getWidth() - 10,700);
        cuon.setPreferredSize(new Dimension(rightPanel.getWidth() - 10,700));
        rightPanel.add(cuon);
    }
    public void thongKeTheoSoLuong(ArrayList<DTOThongKeDonHang> ds, Vector<String> dsTenCoSo, String luaChon)
    {
        rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        rightPanel.repaint(); // Vẽ lại JPanel
        rightPanel.setLayout(null);

        JPanel canGiua = new JPanel(new FlowLayout());
        canGiua.setBounds(5,5,rightPanel.getWidth(),55);
        canGiua.setBackground(Color.yellow);
        JLabel titleNhapThietBi = new JLabel("Thống kê Đơn hàng");
        titleNhapThietBi.setFont(new Font("Times New Roman",1,40));

        canGiua.add(titleNhapThietBi);
        rightPanel.add(canGiua);

        JPanel filter = new JPanel(null);
        filter.setBounds(5,70,rightPanel.getWidth(),55);
        JLabel timTheoTen = new JLabel("Tên sản phẩm");
        timTheoTen.setBounds(10, 15, 100, 30);
        JTextField tenSanPham = new JTextField();
        tenSanPham.setBounds(105, 15, 125, 30);

        JLabel labelDSCoSo = new JLabel("Chọn cơ sở");
        labelDSCoSo.setBounds(250, 15, 75, 30);
        @SuppressWarnings("rawtypes")
        JComboBox comboBoxTenCoSo = new JComboBox<>(dsTenCoSo);
        comboBoxTenCoSo.setBounds(330, 15, 150, 30);
        JLabel labelLoai = new JLabel("Loại");
        labelLoai.setBounds(500, 15, 25, 30);
        String[] loai = {"Theo doanh thu","Theo số lượng"};
        @SuppressWarnings("rawtypes")
        JComboBox comboBoxLoai = new JComboBox<>(loai);
        comboBoxLoai.setBounds(535, 15, 150, 30);

        Vector<String> year = new Vector<>();
        Vector<String> month = new Vector<>();
        Vector<String> day = new Vector<>();
        for(int i = 1990 ; i <= 2100;i++)
        year.add(String.valueOf(i));
        year.add(0,"YY");
        for(int i = 1 ; i <= 12;i++)
        month.add(String.valueOf(i));
        month.add(0,"MM");
        for(int i = 1 ; i <= 31;i++)
        day.add(String.valueOf(i));
        day.add(0,"DD");

        @SuppressWarnings("rawtypes")
        JComboBox dayStart = new JComboBox<>(day);
        @SuppressWarnings("rawtypes")
        JComboBox monthStart = new JComboBox<>(month);
        @SuppressWarnings("rawtypes")
        JComboBox yearStart = new JComboBox<>(year);
        dayStart.setBounds(695, 15, 45, 30);
        monthStart.setBounds(740, 15, 45, 30);
        yearStart.setBounds(785, 15, 45, 30);
        filter.add(dayStart);
        filter.add(monthStart);
        filter.add(yearStart);

        JLabel to = new JLabel("đến");
        to.setBounds(835, 15, 25, 30);
        filter.add(to);

        @SuppressWarnings("rawtypes")
        JComboBox dayEnd = new JComboBox<>(day);
        @SuppressWarnings("rawtypes")
        JComboBox monthEnd = new JComboBox<>(month);
        @SuppressWarnings("rawtypes")
        JComboBox yearEnd = new JComboBox<>(year);
        dayEnd.setBounds(865, 15, 45, 30);
        monthEnd.setBounds(910, 15, 45, 30);
        yearEnd.setBounds(945, 15, 45, 30);
        filter.add(dayEnd);
        filter.add(monthEnd);
        filter.add(yearEnd);

        JButton timkiem = new JButton("Tìm kiếm");
        timkiem.setBounds(1000, 15, 100, 29);
        System.out.println(rightPanel.getWidth());
        filter.add(timTheoTen);
        filter.add(tenSanPham);
        filter.add(timkiem);
        filter.add(labelDSCoSo);
        filter.add(comboBoxTenCoSo);
        filter.add(labelLoai);
        filter.add(comboBoxLoai);
        rightPanel.add(filter);

        int chieuNgang = rightPanel.getWidth() - 550;
        int chieuDoc = ds.size() * 75;
        JPanel thongKe = new JPanel(null);
        timkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String tenHang = tenSanPham.getText();
                String tenCoSo = comboBoxTenCoSo.getSelectedItem().toString();
                String d1 = dayStart.getSelectedItem().toString();
                String m1 = monthStart.getSelectedItem().toString();
                String y1 = yearStart.getSelectedItem().toString();
                String d2 = dayEnd.getSelectedItem().toString();
                String m2 = monthEnd.getSelectedItem().toString();
                String y2 = yearEnd.getSelectedItem().toString();

                boolean flag = true;
                if(tenHang.equals("")) tenHang = "NULL";
                if(tenCoSo.equals("Tất cả cơ sở")) tenCoSo = "NULL";
                String date1 = new String();
                if(d1.equals("DD")&&m1.equals("MM")&&y1.equals("YY")) date1 ="1990-01-01";
                else if(!d1.equals("DD")&&!m1.equals("MM")&&!y1.equals("YY")) date1 = y1+"-"+m1+"-"+d1;
                else 
                {
                    JOptionPane.showMessageDialog(rightPanel,"Sai ngày bắt đầu");
                    flag = false;
                }
                String date2 = new String();
                if(d2.equals("DD")&&m2.equals("MM")&&y2.equals("YY")) date2 = "2025-01-01";
                else if(!d2.equals("DD")&&!m2.equals("MM")&&!y2.equals("YY")) date2 = y2+"-"+m2+"-"+d2;
                else 
                {
                    JOptionPane.showMessageDialog(rightPanel,"Sai ngày kết thúc");
                    flag = false;
                }

                if(flag == true)
                {
                    BLLThongKeDonHang bllThongKeDonHang = new BLLThongKeDonHang();
                    ArrayList<DTOThongKeDonHang> dtoThongKeDonHang = bllThongKeDonHang.layDSDLoc(tenHang, tenCoSo, date1, date2);
                    thongKeTheoSoLuong(dtoThongKeDonHang,dsTenCoSo,comboBoxLoai.getSelectedItem().toString());                    
                }
            }
        });
        if(luaChon.equals("Theo doanh thu"))
        {
            int max = 0;
            for(DTOThongKeDonHang dtoThongKeDonHang : ds)
            if(max<dtoThongKeDonHang.getDoanhThu()) max = dtoThongKeDonHang.getDoanhThu();
            double tiLe ;
            if(max != 0) tiLe = chieuNgang * 1.0 / max;
            else tiLe = 0;
            int y = 0;
            thongKe.setPreferredSize(new Dimension((int) (max * tiLe) + 450, chieuDoc));
            for(int i=0;i<ds.size();i++)
            {
                JPanel thongKe1MonHang = new JPanel(null);
                thongKe1MonHang.setBounds(0, y, 1000, 75);
                JLabel tenHang = new JLabel(ds.get(i).getTenHangHoa());
                tenHang.setBounds(0, 0, 250, 30);
                JLabel cot = new JLabel();
                cot.setBounds(255, 0, (int) (ds.get(i).getDoanhThu()*tiLe) , 30);
                cot.setOpaque(true); // Thêm dòng này để cho phép vẽ nền màu
                cot.setBackground(Color.BLUE);
                JLabel doanhThu = new JLabel(String.valueOf(ds.get(i).getDoanhThu()) + " đ");
                doanhThu.setBounds(cot.getWidth()+tenHang.getWidth()+10,0,200,30);

                thongKe1MonHang.add(tenHang);
                thongKe1MonHang.add(cot);
                thongKe1MonHang.add(doanhThu);
                thongKe.add(thongKe1MonHang);
                y+=75;
            }
            JScrollPane jScrollPane = new JScrollPane(thongKe);
            jScrollPane.setBounds(2, 150, rightPanel.getWidth() - 20, 700);
            rightPanel.add(jScrollPane);
        }
        else
        {
            int max = 0;
            for(DTOThongKeDonHang dtoThongKeDonHang : ds)
            if(max<dtoThongKeDonHang.getSoLuong()) max = dtoThongKeDonHang.getSoLuong();
            double tiLe ;
            if(max != 0) tiLe = chieuNgang * 1.0 / max;
            else tiLe = 0;
            int y = 0;
            thongKe.setPreferredSize(new Dimension((int) (max * tiLe) + 450, chieuDoc));
            for(int i=0;i<ds.size();i++)
            {
                JPanel thongKe1MonHang = new JPanel(null);
                thongKe1MonHang.setBounds(0, y, 1000, 75);
                JLabel tenHang = new JLabel(ds.get(i).getTenHangHoa());
                tenHang.setBounds(0, 0, 250, 30);
                JLabel cot = new JLabel();
                cot.setBounds(255, 0, (int) (ds.get(i).getSoLuong()*tiLe) , 30);
                cot.setOpaque(true); // Thêm dòng này để cho phép vẽ nền màu
                cot.setBackground(Color.BLUE);
                JLabel doanhThu = new JLabel(String.valueOf(ds.get(i).getSoLuong()));
                doanhThu.setBounds(cot.getWidth()+tenHang.getWidth()+10,0,200,30);

                thongKe1MonHang.add(tenHang);
                thongKe1MonHang.add(cot);
                thongKe1MonHang.add(doanhThu);
                thongKe.add(thongKe1MonHang);
                y+=75;
            }
            JScrollPane jScrollPane = new JScrollPane(thongKe);
            jScrollPane.setBounds(2, 150, rightPanel.getWidth() - 20, 700);
            rightPanel.add(jScrollPane);
        }
        
    }
    public static void main(String[] args){
        new GUIAdmin();
    }
    
}