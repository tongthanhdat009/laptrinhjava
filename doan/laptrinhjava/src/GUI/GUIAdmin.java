package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;
import java.time.Year;

import BLL.BLLNhapThietBi;
import BLL.BLLQuanLyDanhSach;
import BLL.BLLThongKeDT;
import BLL.BLLThongKeDonHang;
import DAL.DataCoSo;
import DTO.ChiTietHoaDon;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.DTODuyetDonHang;
import DTO.DTOThongKeDonHang;
import DTO.HoaDon;
import DTO.HoiVien;
import DTO.HoiVienCoSo;
import DTO.LoaiThietBi;
import DTO.NhanVien;
import DTO.ThietBiCoSo;
import DTO.dichVu;
import DTO.dsHangHoa;
import DTO.dsHoiVien;
import DTO.hangHoa;
import DTO.hangHoaCoSo;
import GUI.CONTROLLER.QuanLyBangDichVuCTR;
import GUI.CONTROLLER.QuanLyBangNhanVienCTR;
import GUI.CONTROLLER.QuanLyBangThietBiCoSoCTR;
import GUI.CONTROLLER.QuanLyHoiVienCoSoCTR;
import GUI.CONTROLLER.chiTietHDCTR;
import GUI.CONTROLLER.coSoCTR;
import GUI.CONTROLLER.hangHoaCSCTR;
import GUI.CONTROLLER.hangHoaCTR;
import GUI.CONTROLLER.hoaDonCTR;
import GUI.CONTROLLER.hoiVienCTR;
import GUI.CONTROLLER.thietBiCTR;
import GUI.CONTROLLER.thongKe;

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
    Image scaleLogoIcon = logo.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
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

    //icon chức năng duyệt đơn hàng
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
    JLabel subTitle = new JLabel("Quản lý");
    JLabel subTitle2 = new JLabel("Thống kê");
    
    //dòng cuối leftPanel
    JLabel footerLeft = new JLabel("Designed By: SGU FITNESS CLUB");

    //font
    Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm

    //màu cho combobox
    ListCellRenderer<? super String> renderer = new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Đặt màu cho phần tử trong JComboBox
            if (isSelected) {
                component.setForeground(new Color(140, 82, 255)); // Màu chữ khi được chọn
                component.setBackground(Color.WHITE); // Màu nền khi được chọn
            } else {
                component.setForeground(Color.BLACK); // Màu chữ mặc định
                component.setBackground(Color.WHITE); // Màu nền mặc định
            }

            return component;
        }
    };
    
    // //màu cho bảng
    // DefaultTableCellRenderer rendererTable = new DefaultTableCellRenderer() {
    //     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    //         Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
    //         // Đặt màu cho các hàng chẵn và lẻ
    //         if (row % 2 == 0) {
    //             component.setBackground(Color.decode("#d2a5e8"));
    //         } else {
    //             component.setBackground(Color.white);
    //         }
            
    //         return component;
    //     }
    // };
    
    public GUIAdmin(){    
        //main frame
        adminFrame.setSize(width, height);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.getContentPane().setLayout(null);
        adminFrame.setIconImage(logo.getImage());

        //main
        mainPanel.setSize(new Dimension(width,height));
        mainPanel.setLayout(null);

        //left panel
        leftPanel.setBounds(0,0,(int)(width * 0.25),height);
        leftPanel.setBackground(new Color(0, 191, 99));
        leftPanel.setLayout(null);
        
        // subTitle.setFont(new java.awt.Font("Times New Roman", 1, 35));
        // subTitle2.setFont(new java.awt.Font("Times New Roman", 1, 35));
        footerLeft.setFont(new java.awt.Font("Times New Roman", 1, 20));
        footerLeft.setBounds(45,height-70,(int)(width * 30/100),20);

        leftLabel.setIcon(logo1);

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(0, 191, 99));
        logoPanel.setLayout(new BorderLayout());
        logoPanel.setBounds(75,0,(int)(width * 0.3)-10,240);
        logoPanel.add(leftLabel, BorderLayout.CENTER);
        
        leftPanel.add(logoPanel);
                
        //bảng chọn chức năng
        JPanel managementPanel = new JPanel();
        managementPanel.setBackground(new Color(10, 151, 178));
        managementPanel.setLayout(null);
        managementPanel.setBounds(25,245,352,371);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Chức năng");
        titledBorder.setTitleFont(italicBoldFont);
        managementPanel.setBorder(titledBorder);
        managementPanel.setBackground(new Color(0, 191, 99));
        
        managementPanel.add(subTitle);
        managementPanel.add(subTitle2);
        
        leftPanel.add(managementPanel);
        
        JButton listBTN = new JButton("Quản lý danh sách");
        listBTN.setSelectedIcon(null);
        listBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        listBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
                rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
                rightPanel.repaint(); // Vẽ lại JPanel
                xuLyDanhSach();
        	}
        });
        listBTN.setBounds(23, 38, 300, 50);
        listBTN.setFocusPainted(false);
        listBTN.setIcon(new ImageIcon(scaleCheckListIcon));

        managementPanel.add(listBTN);
        
        JButton billBTN = new JButton("Duyệt đơn hàng");
        billBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        billBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<HoaDon> ds = new ArrayList<>();
                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                ds = bllQuanLyDanhSach.layDSHoaDonChuaDuyet();
                XuLyDuyetDonHang(ds,bllQuanLyDanhSach);
        	}
        });
        billBTN.setBounds(23, 99, 300, 50);
        billBTN.setIcon(new ImageIcon(scaleBillIcon));
        billBTN.setFocusPainted(false);

        managementPanel.add(billBTN);
        
        JButton goodsBTN = new JButton("Nhập thiết bị");
        goodsBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        goodsBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		BLLNhapThietBi bllNhapThietBi = new BLLNhapThietBi();
                DSLoaiThietBi dsLoaiThietBi = new DSLoaiThietBi();
                dsLoaiThietBi = bllNhapThietBi.layDSLoaiThietBi();
                int soLuongLoaiThietBi = dsLoaiThietBi.dsThietBi.size();
                xuLyNhapHang(dsLoaiThietBi,soLuongLoaiThietBi);
        	}
        });
        goodsBTN.setBounds(23, 160, 300, 50);
        goodsBTN.setFocusPainted(false);
        goodsBTN.setIcon(new ImageIcon(scaleGoodsIcon));

        managementPanel.add(goodsBTN);
        
        JButton statBTN = new JButton("Thống kê đơn hàng");
        statBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        statBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		BLLThongKeDonHang bllThongKeDonHang = new BLLThongKeDonHang();
                ArrayList<DTOThongKeDonHang> ds = bllThongKeDonHang.layDSDLoc("NULL", "NULL", "2024-01-01", "2025-01-01");
                Vector<String> dsTenCoSo = new Vector<>();
                dsTenCoSo = bllThongKeDonHang.DSMaCoSo();
                thongKe TK = new thongKe();
                TK.thongKeTheoSoLuong(ds,dsTenCoSo,"Theo doanh thu",rightPanel );
        	}
        });
        statBTN.setBounds(23, 221, 300, 50);
        statBTN.setFocusPainted(false);
        statBTN.setIcon(new ImageIcon(scaleChartIcon));
        managementPanel.add(statBTN);
        
        JButton delegationBTN = new JButton("Phân quyền");
        delegationBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        delegationBTN.setBounds(23, 282, 300, 50);
        managementPanel.add(delegationBTN);
        
        leftPanel.add(footerLeft);
        //chức năng:
        //quản lý danh sách:
        //right panel
        rightPanel.setBounds((int)(width * 0.25),0,(int)(width * 0.75),height);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(border);
        //giới thiệu app
        JPanel introPn = new JPanel();
        introPn.setPreferredSize(new Dimension(rightPanel.getWidth()-300,700));
        introPn.setBackground(Color.white);
        // introPn.setLayout(null);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(scaleLogoIcon));
        // logo.setBounds((int)(rightPanel.getWidth()*50/100-300/2),0,300,300);
        // introParam.setBounds((int)(rightPanel.getWidth()*50/100-introParam.getWidth()/2),320,(int)(width*70/100),45);

        introPn.add(logo);
        rightPanel.add(introPn);
        //thêm đối tượng
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        adminFrame.getContentPane().add(mainPanel);

        adminFrame.setVisible(true);
    }
    
    public void XuLyDuyetDonHang(ArrayList<HoaDon> ds, BLLQuanLyDanhSach bllQuanLyDanhSach)
    {
        rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        rightPanel.repaint(); // Vẽ lại JPanel
        rightPanel.setLayout(null);
    
        JPanel canGiua = new JPanel(new FlowLayout());
        canGiua.setBounds(5,5,rightPanel.getWidth(),55);
        canGiua.setBackground(Color.WHITE);
        JLabel titleNhapThietBi = new JLabel("Duyệt Đơn Hàng");
        titleNhapThietBi.setFont(new Font("Times New Roman",1,40));

        canGiua.add(titleNhapThietBi);
        rightPanel.add(canGiua);

        JPanel nhapLieu = new JPanel(null);
        nhapLieu.setBounds(2, 60, rightPanel.getWidth()-20, 80);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        nhapLieu.setBorder(titledBorder);
        nhapLieu.setBackground(new Color(119, 230, 163));

        JLabel lbMaHV = new JLabel("Mã hội viên: ");
        JLabel lbMaCoSo = new JLabel("Mã cơ sở: ");
        JLabel lbMaHoaDon = new JLabel("Mã hóa đơn: ");
        JTextField tfMaHV = new JTextField();
        JTextField tfMaHoaDon = new JTextField();
        Vector<String> dsMaCoSo = new Vector<>();
        dsMaCoSo = bllQuanLyDanhSach.layDSMaCoSo();
        @SuppressWarnings("rawtypes")
        JComboBox cbMaCoSo = new JComboBox<>(dsMaCoSo);

        int x=150;
        lbMaHoaDon.setBounds(x,25,110,30); x+=100;
        lbMaHoaDon.setFont(new Font("Times New Roman",1,18));
        tfMaHoaDon.setBounds(x+10, 25, 100, 30); x+=130;
        lbMaHV.setBounds(x+50, 25, 110, 30); x+=150;
        lbMaHV.setFont(new Font("Times New Roman",1,18));
        tfMaHV.setBounds(x+10, 25, 100, 30); x+=130;
        lbMaCoSo.setBounds(x+50,25,110,30); x+=150;
        lbMaCoSo.setFont(new Font("Times New Roman",1,18));
        cbMaCoSo.setBounds(x+10, 25, 100, 30);
        cbMaCoSo.setBackground(Color.white);

        JButton timKiem = new JButton("Tìm kiếm");
        timKiem.setBackground(Color.WHITE);
        timKiem.setBounds(rightPanel.getWidth()-200, 25, 100, 30);
        timKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<HoaDon> dsTimKiem = new ArrayList<>();
                if(tfMaHoaDon.getText().equals("") && cbMaCoSo.getSelectedIndex()==0&&tfMaHV.getText().equals(""))
                dsTimKiem = bllQuanLyDanhSach.layDSHoaDonChuaDuyet();
                else dsTimKiem = bllQuanLyDanhSach.timKiemHoaDon2(tfMaHoaDon.getText(), cbMaCoSo.getSelectedItem().toString(), tfMaHV.getText());
                XuLyDuyetDonHang(dsTimKiem,bllQuanLyDanhSach);
            }
        });
        nhapLieu.add(lbMaHoaDon);
        nhapLieu.add(tfMaHoaDon);
        nhapLieu.add(lbMaHV);
        nhapLieu.add(tfMaHV);
        nhapLieu.add(lbMaCoSo);
        nhapLieu.add(cbMaCoSo);
        nhapLieu.add(timKiem);
        rightPanel.add(nhapLieu);

        JPanel main = new JPanel(null);
        main.setPreferredSize(new Dimension(rightPanel.getWidth()-45, ds.size()*60+5));
        int y=0;
        for(int i=0;i<ds.size();i++)
        {
            JPanel pnHoaDon = new JPanel(null);
            pnHoaDon.setBounds(0, y, rightPanel.getWidth()-28, 50);
            y+=60;
            x=10;
            String maHoaDon = ds.get(i).getMaHoaDon();
            JLabel lb2MaHoaDon = new JLabel("Hóa đơn: "+ ds.get(i).getMaHoaDon());
            lb2MaHoaDon.setFont(new Font("Times New Roman",1,20));
            lb2MaHoaDon.setBounds(x, 10, 150, 35); x+=150;
            JLabel lb2MaHoiVien = new JLabel("Hội viên: "+ds.get(i).getMaHoiVien());
            lb2MaHoiVien.setFont(new Font("Times New Roman",1,20));
            lb2MaHoiVien.setBounds(x+30, 10, 150, 35); x+=180;
            JLabel lb2MaCoSo = new JLabel("Cơ sở: "+ds.get(i).getMaCoSo());
            lb2MaCoSo.setFont(new Font("Times New Roman",1,20));
            lb2MaCoSo.setBounds(x+30, 10, 130, 35); x+=160;
            JLabel lb2Ngay = new JLabel("Ngày: "+ds.get(i).getNgayXuatHoaDon());
            lb2Ngay.setFont(new Font("Times New Roman",1,20));
            lb2Ngay.setBounds(x+30, 10, 150, 35); x+=180;
            JLabel lb2Tien = new JLabel("Tổng: "+ds.get(i).getTongTien());
            lb2Tien.setFont(new Font("Times New Roman",1,20));
            lb2Tien.setBounds(x+30, 10, 150, 35); x+=180;
            JButton btXemChiTiet = new JButton("Chi tiết");
            btXemChiTiet.setFont(new Font("Times New Roman",1,20));
            btXemChiTiet.setBounds(x+30, 10, 120, 35); x+=150;
            JButton btDuyet = new JButton("Duyệt");
            btDuyet.setFont(new Font("Times New Roman",1,20));
            btDuyet.setBounds(x+15, 10, 120, 35);
            btXemChiTiet.setBackground(Color.white);
            btDuyet.setBackground(Color.white);
            btXemChiTiet.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    ArrayList<DTODuyetDonHang> chiTietHoaDon = new ArrayList<>();
                    chiTietHoaDon = bllQuanLyDanhSach.dsDTODuyetDonHang(maHoaDon);
                    JPanel chiTiet = new JPanel(new GridLayout(chiTietHoaDon.size()+1,3));
                    chiTiet.add(new JLabel("Tên hàng"));
                    chiTiet.add(new JLabel("Số lượng"));
                    chiTiet.add(new JLabel("Giá tiền"));
                    chiTiet.setPreferredSize(new Dimension(500,20*chiTietHoaDon.size()+10));
                    for(int i=0;i<chiTietHoaDon.size();i++)
                    {
                        JLabel lbTenHang = new JLabel(chiTietHoaDon.get(i).getTenHangHoa());
                        JLabel lbSoLuong = new JLabel(String.valueOf(chiTietHoaDon.get(i).getSoLuong()));
                        JLabel lbGia = new JLabel(String.valueOf(chiTietHoaDon.get(i).getGiaTien()));
                        chiTiet.add(lbTenHang);
                        chiTiet.add(lbSoLuong);
                        chiTiet.add(lbGia);
                    }
                    JOptionPane.showMessageDialog(rightPanel, chiTiet);
                }
            });
            btDuyet.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(bllQuanLyDanhSach.duyetHoaDon(maHoaDon) == true) 
                    {
                        JOptionPane.showMessageDialog(rightPanel, "Duyệt thành công");
                        btDuyet.setText("Đã duyệt");
                        btDuyet.setEnabled(false);
                    }
                    else JOptionPane.showMessageDialog(rightPanel, "Thất bại");
                }
            });

            pnHoaDon.add(lb2MaHoaDon);
            pnHoaDon.add(lb2MaHoiVien);
            pnHoaDon.add(lb2MaCoSo);
            pnHoaDon.add(lb2Ngay);
            pnHoaDon.add(lb2Tien);
            pnHoaDon.add(btXemChiTiet);
            pnHoaDon.add(btDuyet);
            pnHoaDon.setBackground(Color.YELLOW);
            main.add(pnHoaDon);
        }
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(main);
        jScrollPane.setBounds(5, 150, rightPanel.getWidth()-20, 700);
        rightPanel.add(jScrollPane);
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
            filter.setBackground(Color.WHITE);
            JLabel timTheoTen = new JLabel("Tìm kiếm bằng tên:");
            timTheoTen.setBounds(10, 15, 160, 30);
            timTheoTen.setFont(new Font("Times New Roman",1,18));
            JTextField nhapTen = new JTextField();
            nhapTen.setBounds(200, 15, 175, 30);
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
            timkiem.setBounds(370, 15, 45, 29);
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
                Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                thongTinThietBi.setBorder(blackBorder);

                ImageIcon anhThietBi = new ImageIcon(thietBi.getHinhAnh());
                Image chinhAnhThietBi = anhThietBi.getImage().getScaledInstance(290, 250,Image.SCALE_DEFAULT);
                anhThietBi = new ImageIcon(chinhAnhThietBi);
                JLabel labelAnhThietBi = new JLabel(anhThietBi);
                labelAnhThietBi.setBounds(10, 5, 290, 250);
                thongTinThietBi.add(labelAnhThietBi);

                JPanel panelTenThietBi = new JPanel(new FlowLayout());
                JPanel panelGiaThietBi = new JPanel(new FlowLayout());
                panelTenThietBi.setBounds(10, 280, 290, 30);
                panelGiaThietBi.setBounds(10, 310, 290, 30);
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
    @SuppressWarnings("unchecked")
    private void xuLyDanhSach(){
        rightPanel.setLayout(null);
        //giới thiệu chức năng xử lý danh sách
        JLabel param = new JLabel("<html>Giới thiệu chức năng quản lý danh sách <br> Bao gồm các tác vụ thêm, xóa, sửa thông tin các danh sách: <br>- Cơ sở <br>- Dịch vụ<br>- Hội viên<br>- Nhân viên<br>- Thiết bị<br>- Thiết bị cơ sở <br>- Hóa đơn <br>- Chi tiết hóa đơn <br>- Hàng hóa <br>- Hội viên cơ sở <br>- Hàng hóa cơ sở <br>Chọn danh sách để bắt đầu thao tác</html>"); 

        param.setFont(new Font("Times New Roman",1,30));
        JPanel textPN = new JPanel();
        textPN.setBounds(100,150,(int)(width*70/100 - 100), height-300);
        textPN.setBackground(new Color(119, 230, 163));
        textPN.add(param);
        rightPanel.add(textPN);
        //tiêu đề bên phải 
        JLabel rightTitle = new JLabel("Quản lý danh sách");
        rightTitle.setFont(new Font("Times New Roman", 1, 35));
        rightTitle.setBounds(450, 0, 1000,60);        
        
        //Chọn bảng cần quản lý
        String[] tenDanhSach = {"Cơ sở", "Dịch vụ", "Hội viên", "Nhân viên", "Thiết bị", "Thiết bị cơ sở", "Hóa đơn","Chi tiết hóa đơn","Hàng hóa","Hàng hóa cơ sở","Hội viên cơ sở"};
        @SuppressWarnings("rawtypes")
        JComboBox danhSachBox = new JComboBox<String>(tenDanhSach);
        danhSachBox.setBounds(680,50,130,30);
        JLabel chonDanhSachLabel = new JLabel("Chọn danh sách: ");
        chonDanhSachLabel.setFont(new Font("Times New Roman", 1, 30));
        chonDanhSachLabel.setBounds(430, 50, 300,35);
        danhSachBox.setRenderer(renderer);
        danhSachBox.setBackground(Color.white);
        danhSachBox.addActionListener(new ActionListener() {
            //xóa những gì đã hiển thị của một danh sách
            public void xoaHienThi(JPanel rightPanel){
                Component[] components = rightPanel.getComponents();
                for(Component a : components){
                    if(!(a instanceof JLabel || a instanceof JComboBox)){
                        rightPanel.remove(a);
                    }
                }
                rightPanel.revalidate();
                rightPanel.repaint();
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> comboBox = (JComboBox<String>) e.getSource(); // Lấy ra JComboBox đã được kích hoạt
                String selectedOption = (String) comboBox.getSelectedItem(); // Lấy ra mục đã chọn trong JComboBox
                JTable dataTable = new JTable();
                JScrollPane scrollPane = new JScrollPane();
                JPanel bangChinhSua = new JPanel();
                
                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();

                ArrayList<String> tenCotHV = bllQuanLyDanhSach.layTenCotHoiVien();
                ArrayList<HoiVien> dsHV = bllQuanLyDanhSach.getDataHoiVien();

                ArrayList<String> tenCotCS = bllQuanLyDanhSach.layTenCotCoSo();
                DSCoSo dsCS =  bllQuanLyDanhSach.layDsCoSo();

                DSLoaiThietBi dsTB = bllQuanLyDanhSach.layDSLoaiThietBi();
                ArrayList<String> tenCotTB = bllQuanLyDanhSach.layTenCotThietBi();
                
                dsHangHoa dsHH = bllQuanLyDanhSach.layDsHangHoa();
                ArrayList<String> tenCotHH = bllQuanLyDanhSach.layTenCotHangHoa();

                if (selectedOption.equals("Cơ sở")) {
                	coSoCTR csCTR = new coSoCTR(rightPanel,tenCotCS,dsCS,bangChinhSua,dataTable,scrollPane,bllQuanLyDanhSach);
                	csCTR.update();
                }
                else if(selectedOption.equals("Dịch vụ")){
                    ArrayList<dichVu> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.getDataDichvu();
                    QuanLyBangDichVuCTR qlbdvCTR = new QuanLyBangDichVuCTR();
                    qlbdvCTR.QuanLyBangDichVu(ds, rightPanel);
                }
                else if (selectedOption.equals("Hội viên")) {
                    hoiVienCTR hvCTR = new hoiVienCTR(rightPanel,tenCotHV,dsHV,bangChinhSua,dataTable,scrollPane,bllQuanLyDanhSach);
                    hvCTR.update();
                }
                else if (selectedOption.equals("Nhân viên")){
                    ArrayList<NhanVien> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.getDataNhanVien();
                    QuanLyBangNhanVienCTR qlbnvCTR = new QuanLyBangNhanVienCTR();
                    qlbnvCTR.QuanLyBangNhanVien(ds, rightPanel, chonDanhSachLabel);
                }
                else if(selectedOption.equals("Thiết bị")){
                    thietBiCTR tbCTR = new thietBiCTR(rightPanel, tenCotTB, dsTB, bangChinhSua, dataTable, scrollPane, bllQuanLyDanhSach);
                    tbCTR.update();
                }
                else if(selectedOption.equals("Thiết bị cơ sở")){
                    ArrayList<ThietBiCoSo> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDanhSachThietBiCoSo();
                    QuanLyBangThietBiCoSoCTR qlbtbcsCTR = new QuanLyBangThietBiCoSoCTR();
                    qlbtbcsCTR.QuanLyBangThietBiCoSo(ds,rightPanel);
                }
                else if(selectedOption.equals("Hóa đơn")){
                    ArrayList<HoaDon> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSHoaDon();
                    Vector<String> dsCoSo = new Vector<>();
                    dsCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    hoaDonCTR hdCTR = new hoaDonCTR();
                    hdCTR.QuanLyHoaDon(ds, dsCoSo, rightPanel);
                }
                else if(selectedOption.equals("Chi tiết hóa đơn")){
                    ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSChiTietHoaDon();
                    chiTietHDCTR cthdCTR = new chiTietHDCTR();
                    cthdCTR.QuanLyChiTietHoaDon(ds,rightPanel);
                }
                else if(selectedOption.equals("Hàng hóa cơ sở")){
                    ArrayList<hangHoaCoSo> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSHangHoaCoSo();
                    Vector<String> dsMaCoSo = new Vector<>();
                    dsMaCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    hangHoaCSCTR hhcsCTR = new hangHoaCSCTR();
                    hhcsCTR.QuanLyHangHoaCoSo(ds,dsMaCoSo,rightPanel);
                }
                else if(selectedOption.equals("Hội viên cơ sở")){
                    ArrayList<HoiVienCoSo> ds = new ArrayList<>();
                    Vector<String> dsCoSo = new Vector<>();
                    dsCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    ds = bllQuanLyDanhSach.layDSHoiVienCoSo();
                    QuanLyHoiVienCoSoCTR qlhvcsCTR = new QuanLyHoiVienCoSoCTR();
                    qlhvcsCTR.QuanLyHoiVienCoSo(ds,dsCoSo,rightPanel);
                }
                else if(selectedOption.equals("Hàng hóa")){
                	hangHoaCTR hhCTR = new hangHoaCTR(rightPanel, tenCotHH, dsHH, bangChinhSua, dataTable, scrollPane, bllQuanLyDanhSach);
                	hhCTR.update();
                }
            }
           
        });
        
        rightPanel.add(rightTitle);
        rightPanel.add(chonDanhSachLabel);
        rightPanel.add(danhSachBox);
    }
    public static void main(String[] args){
        new GUIAdmin();
    }
}