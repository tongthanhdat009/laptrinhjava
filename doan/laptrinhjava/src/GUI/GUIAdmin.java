package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import BLL.BLLNhapThietBi;
import BLL.BLLQuanLyDanhSach;
import BLL.BLLThongKeDT;
import DAL.DataCoSo;
import DAL.DataHoiVien;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.HoiVien;
import DTO.LoaiThietBi;

import java.util.ArrayList;
import java.util.Vector;


import java.awt.*;
import java.awt.event.*;

public class GUIAdmin{
    private JFrame adminFrame = new JFrame("Quản lý SGU Gym");
    private final int width = 1600;
    private final int height = 900;
    //logo
    ImageIcon logo = new ImageIcon("src/asset/img/label/logo.png");
    ImageIcon logo1 = new ImageIcon("src/asset/img/label/logo1.png");
    
    //icon chức năng thống kê
    ImageIcon analyticsIcon = new ImageIcon("src/asset/img/icon/analytics-icon.png");
    Image scaleAnalyticsIcon = analyticsIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng danh sách
    ImageIcon checkListIcon = new ImageIcon("src/asset/img/icon/checklist-icon.png");
    Image scaleCheckListIcon = checkListIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon tiêu đề phụ chức năng
    ImageIcon managementIcon = new ImageIcon("src/asset/img/icon/project-management-icon.png");
    Image scaleManagementIcon = managementIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập thiết bị
    ImageIcon dumbbellIcon = new ImageIcon("src/asset/img/icon/dumbbell-icon.png");
    Image scaleDumbbellIcon = dumbbellIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng nhập hàng hóa
    ImageIcon goodsIcon = new ImageIcon("src/asset/img/icon/goods-icon.png");
    Image scaleGoodsIcon = goodsIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);

    //icon chức năng nhập hàng hóa
    ImageIcon billIcon = new ImageIcon("src/asset/img/icon/bill-icon.png");
    Image scaleBillIcon = billIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    
    //icon chức năng thống kê doanh thu
    ImageIcon chartIcon = new ImageIcon("src/asset/img/icon/stonk-icon.jpg");
    Image scaleChartIcon = chartIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
    //tạo viền cho panel
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    //main
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    
    //tiêu đề + logo
    JLabel leftLabel = new JLabel("Quản lý");
        
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
        statisticLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        listLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
        nhapThietBiLabel.setFont(new java.awt.Font("Times New Roman", 1, 40));
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

        thongKeDoanhThuPanel.setPreferredSize(new Dimension((int)(width * 0.3),55));
        thongKeDoanhThuPanel.setBackground(Color.MAGENTA);
        thongKeDoanhThuPanel.setBorder(border);
        //Sử lý sự kiện khi chọn chức năng
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
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        // thêm đối tượng
        statisticsPanel.add(statisticLabel);        
        listPanel.add(listLabel);
        nhapThietBiPanel.add(nhapThietBiLabel);
        duyetDonHangPanel.add(duyetDonHangLabel);
        thongKeDoanhThuPanel.add(thongKeDoanhThuLabel);
        //bảng chọn chức năng
        managementPanel.setPreferredSize(new Dimension((int)(width * 0.3),height - 250));
        managementPanel.setBackground(Color.WHITE);

        managementPanel.add(listPanel);
        managementPanel.add(statisticsPanel);
        managementPanel.add(nhapThietBiPanel);
        managementPanel.add(duyetDonHangPanel);
        managementPanel.add(thongKeDoanhThuPanel);

        leftPanel.add(managementPanel);

        //chức năng:
        //quản lý danh sách:
        //right panel
        rightPanel.setBounds((int)(width * 0.3),0,(int)(width * 0.7),height);
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
        rightTitle.setFont(new Font("Times New Roman", 1, 50));
        rightTitle.setBounds(400, 0, 1000,60);        
        
        //Chọn bảng cần quản lý
        String[] tenDanhSach = {"Cơ sở", "Dịch vụ", "Hội viên", "Nhân viên", "Thiết bị", "Thiết bị cơ sở", "Hóa đơn","Hàng hóa cơ sở"};
        @SuppressWarnings("rawtypes")
        JComboBox danhSachBox = new JComboBox<String>(tenDanhSach);
        danhSachBox.setBounds(600,70,100,50);
        JLabel chonDanhSachLabel = new JLabel("Chọn danh sách: ");
        chonDanhSachLabel.setFont(new Font("Times New Roman", 1, 30));
        chonDanhSachLabel.setBounds(350, 70, 300,35);
        
        danhSachBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("unchecked")
                JComboBox<String> comboBox = (JComboBox<String>) e.getSource(); // Lấy ra JComboBox đã được kích hoạt
                String selectedOption = (String) comboBox.getSelectedItem(); // Lấy ra mục đã chọn trong JComboBox
                JTable dataTable;
                JScrollPane scrollPane;
                JPanel bangChinhSua;
                
                BLLQuanLyDanhSach bllHoiVien = new BLLQuanLyDanhSach();

                ArrayList<String> tenCotHV = bllHoiVien.layTenCotHoiVien();
                ArrayList<HoiVien> dsHV = bllHoiVien.getDataHoiVien();

                if (selectedOption.equals("Cơ sở")) {
                    Container container = rightPanel; // Thay thế ... bằng container mà bạn muốn kiểm tra
                    int x = 6; // Thay thế ... bằng tọa độ x của điểm bạn muốn kiểm tra
                    int y = 460; // Thay thế ... bằng tọa độ y của điểm bạn muốn kiểm tra

                    Component component = container.getComponentAt(x, y);

                    if (component != null && component.isShowing()) {
                        // Component tại điểm đã cho tồn tại và đang được hiển thị
                        System.out.println("Component tồn tại tại điểm đã cho và đang được hiển thị.");
                        rightPanel.remove(component);
                        rightPanel.revalidate();
                        rightPanel.repaint();
                    } else {
                        // Không có component nào tại điểm đã cho hoặc component đó không được hiển thị
                        System.out.println("Da chon danh sach co so");
                    }
                }
                else if(selectedOption.equals("Dịch vụ")){
                    System.out.println("Da chon danh sach Dich vu");
                }
                else if (selectedOption.equals("Hội viên")) {
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
                        bangChinhSua.setBounds(5,175,(int)(width*0.7)-30,270);
                        bangChinhSua.setLayout(new GridLayout(3,3,10,10));
                        
                        JPanel tempPanel = new JPanel();
                        
                        JTextField tempTF = new JTextField();
                        tempTF.setPreferredSize(new Dimension(100,20));
                        tempTF.setBounds(0,20,100,20);

                        JLabel tempLabel = new JLabel(tenCotHV.get(i));
                        tempLabel.setFont(new Font("Times New Roman", 1,15));
                        tempLabel.setPreferredSize(new Dimension(100,20));

                        if(i==0 || i == 6){
                            tempTF.setEditable(false);
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
                    scrollPane.setBounds(5,460,(int)(width*0.7)-20,400);

                    //nút chức năng
                    String[] tenNut = {"Thêm", "Xóa", "Sửa", "Cập nhật"};
                    String[] cmtNut = {"add", "remove", "edit", "update"};
                    int a=320;
                    for(int i=0;i<tenNut.length;i++){
                        JButton tempBtn = new JButton(tenNut[i]);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (e.getActionCommand().equals(cmtNut[0])) {
                                    Component[] components = bangChinhSua.getComponents();
                                    for (int i=0; i<components.length;i++) {
                                        if (components[i] instanceof JPanel) {
                                            JPanel tempPanel = (JPanel) components[i];
                                            Component[] smallComponents = tempPanel.getComponents();
                                            if(i==6){
                                                // for (Component smallComponent : smallComponents) {
                                                //     if(smallComponent instanceof JTextField){
                                                //         JTextField textField = (JTextField) smallComponent;
                                                //         tempPanel.remove(textField);
                                                //         String[] maDV= {"DV001","DV002","DV003","DV004","DV005"};
                                                //         @SuppressWarnings("rawtypes")
                                                //         JComboBox maDVBox = new JComboBox<String>(maDV);
                                                //         maDVBox.setBounds(0,20,120,20);
                                                //         tempPanel.add(maDVBox);
                                                //         tempPanel.revalidate();
                                                //         tempPanel.repaint();
                                                //     }
                                                // }
                                            }
                                        }
                                    }
                                }
                                else if (e.getActionCommand().equals(cmtNut[1])) {
                                    int i=dataTable.getSelectedRow();
                                    if(i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        hvList.removeRow(i);
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel temPanel = (JPanel) component;
                                                Component[] smallComponents = temPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                        if(bllHoiVien.xoaHV(textField.getText())){
                                                            break;
                                                        }
                                                        else{
                                                            System.out.println(textField.getText());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } 
                                else if (e.getActionCommand().equals(cmtNut[2])) {
                                    int i= dataTable.getSelectedRow();
                                    int j= 0;
                                    if (i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel temPanel = (JPanel) component;
                                                Component[] smallComponents = temPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if (smallComponent instanceof JTextField) {
                                                        JTextField textField = (JTextField) smallComponent;
                                                        String text = textField.getText();
                                                        hvList.setValueAt(text,i,j);
                                                        j++;
                                                    }
                                                }
                                            }
                                        }
                                    } 
                                    
                                }
                                else if (e.getActionCommand().equals(cmtNut[3])) {
                                    
                                }
                        }
                    });
                    tempBtn.setBounds(a,145,100,20);
                    a+=140;
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
                                        bangChinhSua.remove(a);
                                        JPanel tempPanel = new JPanel();
                            
                                        JTextField tempTF = new JTextField();
                                        tempTF.setPreferredSize(new Dimension(100,20));
                                        tempTF.setBounds(0,20,100,20);
                                        tempTF.setText(hvList.getValueAt(i, j).toString().trim());
                                        if(j==0 || j==6){
                                            tempTF.setEditable(false);
                                        }
                                        
                                        JLabel tempLabel = new JLabel(tenCotHV.get(j));
                                        j++;
                                        tempLabel.setFont(new Font("Times New Roman", 1,15));
                                        tempLabel.setPreferredSize(new Dimension(100,20));
                                        
                                        tempPanel.add(tempLabel);
                                        tempPanel.add(tempTF);
                                        bangChinhSua.add(tempPanel);
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
                    System.out.println("Da chon danh sach nhan vien");
                }
                else if(selectedOption.equals("Thiết bị")){
                    System.out.println("Da chon danh sach thiet bi");
                }
                else if(selectedOption.equals("Thiết bị cơ sở")){
                    System.out.println("Da chon danh sach thiet bi co so");
                }
                else if(selectedOption.equals("Hóa đơn")){
                    System.out.println("Da chon danh sach hoa don");
                }
                else if(selectedOption.equals("Hàng hóa cơ sở")){
                    System.out.println("Da chon danh sach hang hoa co so");
                }
                // Thêm các xử lý khác nếu cần
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
        System.out.println(tiLe);
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
    public static void main(String[] args){
        new GUIAdmin();
    }
}