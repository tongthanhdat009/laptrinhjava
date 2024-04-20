package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.microsoft.sqlserver.jdbc.osgi.Activator;

import BLL.BLLNhapThietBi;
import BLL.BLLQuanLyDanhSach;
import BLL.BLLThongKeDT;
import BLL.BLLThongKeDonHang;
import DAL.DataCoSo;
import DAL.DataHoiVien;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.DTOThongKeDonHang;
import DTO.HoiVien;
import DTO.LoaiThietBi;
import DTO.dichVu;

import java.util.ArrayList;
import java.util.Vector;


import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
                        tempTF.setName(tenCotHV.get(i));

                        JLabel tempLabel = new JLabel(tenCotHV.get(i));
                        tempLabel.setFont(new Font("Times New Roman", 1,15));
                        tempLabel.setPreferredSize(new Dimension(100,20));

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

                    dataTable = new JTable(hvList);
                    dataTable.getTableHeader().setReorderingAllowed(false);
                    
                    scrollPane = new JScrollPane(dataTable);
                    scrollPane.setBounds(5,460,(int)(width*0.7)-20,400);

                    //nút chức năng
                    String[] tenNut = {"Thêm", "Xóa", "Sửa", "Tìm kiếm"};
                    String[] cmtNut = {"add", "remove", "edit", "Search"};
                    int a=320;
                    for(int i=0;i<tenNut.length;i++){
                        JButton tempBtn = new JButton(tenNut[i]);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.addActionListener(new ActionListener() {
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
                                                        int maxSTT = bllHoiVien.kiemTraMaHoiVien();
                                                        textField.setText(String.format("HV%03d", maxSTT));
                                                        thongTinMoi.add(textField.getText());
                                                        flag = false;
                                                    } 
                                                    else if (text.equals("")) {
                                                        JOptionPane.showMessageDialog(bangChinhSua, "Không được để trống thông tin!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
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
                                    if (thongTinMoi.size() >= 8) {
                                        hvList.addRow(thongTinMoi.toArray());
                                        String dateString = thongTinMoi.get(6);
                                        String[] parts = dateString.split("-");
                                        int year = Integer.parseInt(parts[0]);
                                        int month = Integer.parseInt(parts[1]);
                                        int day = Integer.parseInt(parts[2]);

                                        @SuppressWarnings("deprecation")
                                        Date date = new Date(year - 1900, month - 1, day); // Tạo đối tượng Date từ năm, tháng và ngày
                                        System.out.println(date);

                                        HoiVien tempHV = new HoiVien(thongTinMoi.get(0),
                                                                    thongTinMoi.get(1),
                                                                    thongTinMoi.get(2),
                                                                    thongTinMoi.get(3),
                                                                    thongTinMoi.get(4),
                                                                    thongTinMoi.get(5),
                                                                    date,
                                                                    thongTinMoi.get(7));
                                        if(bllHoiVien.themHV(tempHV)){
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
                                                JPanel temPanel = (JPanel) component;
                                                Component[] smallComponents = temPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                        if(bllHoiVien.xoaHV(textField.getText())){
                                                            textField.setText("");
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
                                else if (e.getActionCommand().equals(cmtNut[2])) {//SỬA THÔNG TIN HỘI VIÊN
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
                                        String dateString = (String) hvList.getValueAt(i, 6);
                                        String[] parts = dateString.split("-");
                                        int year = Integer.parseInt(parts[0]);
                                        int month = Integer.parseInt(parts[1]);
                                        int day = Integer.parseInt(parts[2]);
                                        String matKhauHV = (String) hvList.getValueAt(i, 5);
                                        if(matKhauHV.length()<6){
                                            JOptionPane.showMessageDialog(null, "Mật khẩu phải dài hơn 6 kí tự", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
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
                                            if(bllHoiVien.suaThongTinHV(tempHV)){
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
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
                                        if(j==0){
                                            tempTF.setEditable(false);
                                            tempTF.setName(tenCotHV.get(j));
                                        }
                                        else{
                                            tempTF.setName(tenCotHV.get(j));
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
        JComboBox comboBoxTenCoSo = new JComboBox<>(dsTenCoSo);
        comboBoxTenCoSo.setBounds(330, 15, 150, 30);
        JLabel labelLoai = new JLabel("Loại");
        labelLoai.setBounds(500, 15, 25, 30);
        String[] loai = {"Theo doanh thu","Theo số lượng"};
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

        JComboBox dayStart = new JComboBox<>(day);
        JComboBox monthStart = new JComboBox<>(month);
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

        JComboBox dayEnd = new JComboBox<>(day);
        JComboBox monthEnd = new JComboBox<>(month);
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