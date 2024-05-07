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
import DTO.hangHoa;
import DTO.hangHoaCoSo;

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
    //màu cho bảng
    DefaultTableCellRenderer rendererTable = new DefaultTableCellRenderer() {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Đặt màu cho các hàng chẵn và lẻ
            if (row % 2 == 0) {
                component.setBackground(Color.decode("#d2a5e8"));
            } else {
                component.setBackground(Color.white);
            }
            
            return component;
        }
    };
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
        
        //lựa chọn chức năng
        JPanel managementPanel = new JPanel();
        JPanel statisticsPanel = new JPanel();
        JPanel listPanel = new JPanel();
        JPanel nhapThietBiPanel = new JPanel();
        JPanel duyetDonHangPanel = new JPanel();
        // JPanel thongKeDoanhThuPanel = new JPanel();

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
        // JLabel thongKeDoanhThuLabel = new JLabel("Thống kê doanh thu");
        // thongKeDoanhThuLabel.setIcon(new ImageIcon(scaleChartIcon));

        // Chỉnh font chữ cho phần chọn chức năng
        statisticLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
        listLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
        nhapThietBiLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
        duyetDonHangLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));
        // thongKeDoanhThuLabel.setFont(new java.awt.Font("Times New Roman", 1, 30));

        // thongKeDoanhThuPanel.setBorder(border);
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
                listPanel.setBackground(new Color(140, 82, 255));
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                listPanel.setBackground(new Color(10, 151, 178));

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
                statisticsPanel.setBackground(new Color(140, 82, 255));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                statisticsPanel.setBackground(new Color(10, 151, 178));
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
                nhapThietBiPanel.setBackground(new Color(140, 82, 255));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                nhapThietBiPanel.setBackground(new Color(10, 151, 178));
            }
        });

        duyetDonHangPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<HoaDon> ds = new ArrayList<>();
                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                ds = bllQuanLyDanhSach.layDSHoaDonChuaDuyet();
                XuLyDuyetDonHang(ds,bllQuanLyDanhSach);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
                duyetDonHangPanel.setBackground(new Color(140, 82, 255));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                duyetDonHangPanel.setBackground(new Color(10, 151, 178));
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
        });
        
        // thongKeDoanhThuPanel.addMouseListener(new MouseListener() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         BLLThongKeDT bllThongKeDT = new BLLThongKeDT();
        //         thongKeDoanhThu(bllThongKeDT.layDSCoSo());
        //     }
        //     @Override
        //     public void mousePressed(MouseEvent e) {
        //     }
        
        //     @Override
        //     public void mouseReleased(MouseEvent e) {
        //     }
        
        //     @Override
        //     public void mouseEntered(MouseEvent e) {
        //         thongKeDoanhThuPanel.setBackground(new Color(140, 82, 255));
        //     }
            
        //     @Override
        //     public void mouseExited(MouseEvent e) {
        //         thongKeDoanhThuPanel.setBackground(new Color(10, 151, 178));
        //     }
        // });
       
        // thêm đối tượng
        statisticsPanel.add(statisticLabel);        
        listPanel.add(listLabel);
        nhapThietBiPanel.add(nhapThietBiLabel);
        duyetDonHangPanel.add(duyetDonHangLabel);
        // thongKeDoanhThuPanel.add(thongKeDoanhThuLabel);
        
        //bảng chọn chức năng
        managementPanel.setBackground(new Color(10, 151, 178));
        managementPanel.setLayout(null);
        managementPanel.setBounds(25,245,(int)(width * 0.22),height-520);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Chức năng");
        titledBorder.setTitleFont(italicBoldFont);
        managementPanel.setBorder(titledBorder);
        managementPanel.setBackground(new Color(0, 191, 99));

        listPanel.setBounds(15,40,320,60);
        listPanel.setBackground(new Color(10, 151, 178));
        
        duyetDonHangPanel.setBounds(15,120,320,60);
        duyetDonHangPanel.setBackground(new Color(10, 151, 178));
        
        nhapThietBiPanel.setBounds(15,200,320,60);
        nhapThietBiPanel.setBackground(new Color(10, 151, 178));
        
        statisticsPanel.setBounds(15,280,320,60);
        statisticsPanel.setBackground(new Color(10, 151, 178));

        // thongKeDoanhThuPanel.setBounds(15,360,320,60);
        // thongKeDoanhThuPanel.setBackground(new Color(10, 151, 178));
        
        managementPanel.add(listPanel);
        managementPanel.add(statisticsPanel);
        managementPanel.add(nhapThietBiPanel);
        managementPanel.add(duyetDonHangPanel);
        // managementPanel.add(thongKeDoanhThuPanel);
        managementPanel.add(subTitle);
        managementPanel.add(subTitle2);
        leftPanel.add(managementPanel);
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
        JLabel introParam = new JLabel("<html>Đề tài được thực hiện bởi: SGU FITNESS CLUB <br>Thành viên:<br>- Tống Thành Đạt MSSV:3122410077 <br>- Nguyễn Minh Tuấn MSSV: 3122560086 <br>- Đào Nhị Khang MSSV: 3122410168<html>");
        Font introFont = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35);
        introParam.setFont(introFont);
        // introParam.setBounds((int)(rightPanel.getWidth()*50/100-introParam.getWidth()/2),320,(int)(width*70/100),45);

        introPn.add(logo);
        introPn.add(introParam);
        rightPanel.add(introPn);
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
            private JTextField jtf_manv;
			private JTextField jtf_hoten;
			private ButtonGroup btngr;
			private JTextField jtf_date;
			private JTextField jtf_sdt;
			private JTextField jtf_cccd;
			private JTextField jtf_macoso;
			private JTextField jtf_vaitro;
			private JTextField jtf_luong;

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
                
                dsHangHoa dsHH = bllQuanLyDanhSach.layDsHangHoa();
                ArrayList<String> tenCotHH = bllQuanLyDanhSach.layTenCotHangHoa();

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
                    bangChinhSua.setBounds(5,175,(int)(width*0.75)-25,270);
                    bangChinhSua.setLayout(new GridLayout(3,3,10,10));
                    bangChinhSua.setBackground(new Color(119, 230, 163));
                    
                    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                    TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                    titledBorder.setTitleFont(italicBoldFont);
                    bangChinhSua.setBorder(titledBorder);

                    for(int i=0;i<tenCotCS.size();i++){
                        JPanel tempPanel = new JPanel();
                        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackBorder,tenCotCS.get(i));
                        titledBorder1.setTitleFont(titledBorder.getTitleFont().deriveFont(18f));
                        tempPanel.setBorder(titledBorder1);
                        tempPanel.setBackground(Color.white);

                        JTextField tempTF = new JTextField();
                        tempTF.setPreferredSize(new Dimension(200,20));
                        tempTF.setBounds(0,20,150,20);
                        tempTF.setName(tenCotCS.get(i));

                        if(i==0){
                            tempTF.setEditable(false);
                        }
                        tempPanel.add(tempTF);
                        bangChinhSua.add(tempPanel);
                    }

                    rightPanel.add(bangChinhSua);
                    rightPanel.revalidate();
                    rightPanel.repaint();

                    dataTable = new JTable(csList);
                    dataTable.getTableHeader().setReorderingAllowed(false);
                    for (int i = 0; i < dataTable.getColumnCount(); i++) {
                        dataTable.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                    }
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
                    int a=335;
                    for(int i=0;i<cmtNut.length;i++){
                        JButton tempBtn = new JButton();
                        ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
                        Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.setBounds(a,110,130,35);
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
                                                    if (flag && j == 0) {
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
                                                        if(i==0 && j==0 && !textField.isEditable()){
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
                                        textField = (JTextField) smallComponents[0];
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
                                            int row = dataTable.getSelectedRow();
                                            if(row != -1){
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
                    ArrayList<dichVu> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.getDataDichvu();
                    QuanLyBangDichVu(ds);
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
                            dsHV.get(i).getHoten().trim(),
                            dsHV.get(i).getGioitinh().trim(),
                            dsHV.get(i).getMail().trim(),
                            dsHV.get(i).getTaiKhoanHoiVien().trim(),
                            dsHV.get(i).getMatKhauHoiVien().trim(),
                            dsHV.get(i).getNgaysinh().trim(),
                            dsHV.get(i).getSdt().trim()});
                    }
                    
                    //bảng hiện dòng thông tin được chọn
                    bangChinhSua = new JPanel();
                    bangChinhSua.setBounds(5,175,(int)(width*0.75)-25,270);
                    bangChinhSua.setLayout(new GridLayout(3,3,10,10));
                    bangChinhSua.setBackground(new Color(119, 230, 163));
                    
                    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                    TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                    titledBorder.setTitleFont(italicBoldFont);
                    bangChinhSua.setBorder(titledBorder);


                    for(int i=0;i<tenCotHV.size();i++){
                        JPanel tempPanel = new JPanel();
                        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackBorder,tenCotHV.get(i));
                        titledBorder1.setTitleFont(titledBorder.getTitleFont().deriveFont(18f));
                        tempPanel.setBorder(titledBorder1);
                        tempPanel.setBackground(Color.white);

                        JTextField tempTF = new JTextField();
                        tempTF.setPreferredSize(new Dimension(200,20));
                        tempTF.setBounds(0,20,120,20);
                        tempTF.setName(tenCotHV.get(i));

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
                            nam.setBackground(Color.white);
                            nu.setBackground(Color.white);
                            gioiTinh.add(nam);
                            gioiTinh.add(nu);
                            tempPanel.add(nam);
                            tempPanel.add(nu);
                            bangChinhSua.add(tempPanel);
                            continue;
                        }
                        // tempPanel.add(tempLabel);
                        tempPanel.add(tempTF);
                        bangChinhSua.add(tempPanel);
                    }

                    rightPanel.add(bangChinhSua);
                    rightPanel.revalidate();
                    rightPanel.repaint();

                    dataTable = new JTable(hvList);
                    dataTable.getTableHeader().setReorderingAllowed(false);
                    for (int i = 0; i < dataTable.getColumnCount(); i++) {
                        dataTable.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                    }
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
                    int a=335;
                    for(int i=0;i<cmtNut.length;i++){
                        JButton tempBtn = new JButton();
                        ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
                        Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.setBounds(a,110,130,35);
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
                                                    if (flag && j == 0) {
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
                                                        if(i==0 && j==0 && !textField.isEditable()){
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
                                        textField = (JTextField) smallComponents[0];
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
                                                    if(smallComponents2[i] instanceof JRadioButton){
                                                        JRadioButton tempRdB = (JRadioButton) smallComponents2[i];
                                                        if (dataTable.getValueAt(row,2).equals(tempRdB.getText())) {
                                                            tempRdB.setSelected(true);
                                                        } 
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
                    ArrayList<NhanVien> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.getDataNhanVien();
                    QuanLyBangNhanVien(ds);
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
                            dsTB.dsThietBi.get(i).getMaThietBi().trim(),
                            dsTB.dsThietBi.get(i).getTenLoaiThietBi().trim(),
                            dsTB.dsThietBi.get(i).getHinhAnh().trim(),
                            dsTB.dsThietBi.get(i).getGiaThietBi().trim(),
                            dsTB.dsThietBi.get(i).getNgayBaoHanh(),
                        });
                    }
                    
                    //bảng hiện dòng thông tin được chọn
                    bangChinhSua = new JPanel();
                    bangChinhSua.setBounds(5,175,(int)(width*0.75)-25,270);
                    bangChinhSua.setLayout(new GridLayout(3,3,10,10));
                    bangChinhSua.setBackground(new Color(119, 230, 163));
                    
                    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                    TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                    titledBorder.setTitleFont(italicBoldFont);
                    bangChinhSua.setBorder(titledBorder);

                    for(int i=0;i<tenCotTB.size();i++){
                        JPanel tempPanel = new JPanel();
                        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackBorder,tenCotTB.get(i));
                        titledBorder1.setTitleFont(titledBorder.getTitleFont().deriveFont(18f));
                        tempPanel.setBorder(titledBorder1);
                        tempPanel.setBackground(Color.white);

                        JTextField tempTF = new JTextField();
                        tempTF.setPreferredSize(new Dimension(150,20));
                        tempTF.setBounds(0,20,120,20);
                        tempTF.setName(tenCotTB.get(i));

                        if(i==0){
                            tempTF.setEditable(false);
                        }
                        tempPanel.add(tempTF);
                        bangChinhSua.add(tempPanel);
                    }

                    rightPanel.add(bangChinhSua);
                    rightPanel.revalidate();
                    rightPanel.repaint();

                    dataTable = new JTable(tbList);
                    dataTable.getTableHeader().setReorderingAllowed(false);
                    for (int i = 0; i < dataTable.getColumnCount(); i++) {
                        dataTable.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                    }
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
                    int a=335;
                    for(int i=0;i<cmtNut.length;i++){
                        JButton tempBtn = new JButton();
                        ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
                        Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.setBounds(a,110,130,35);
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
                                                    if (flag && j == 0) {
                                                        int maxSTT = bllQuanLyDanhSach.kiemTraMaThietBi();
                                                        textField.setText(String.format("TB%03d", maxSTT));
                                                        thongTinMoi.add(textField.getText());
                                                        flag = false;
                                                    }
                                                    else if(!textField.getText().equals("") && bllQuanLyDanhSach.kiemTraGiaThietBi(text)==-1 && j==0 && i==3){
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
                                        if(Integer.parseInt(thongTinMoi.get(4))>0){
                                            if(bllQuanLyDanhSach.themTB(tempTB)){
                                                JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công!");
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(bangChinhSua, "Thêm không thành công!");
                                                return;
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(bangChinhSua, "Ngày bảo hành phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                            tbList.removeRow(dataTable.getRowCount()-1);
                                            return;
                                        }
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                        return;
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
                                else if(tempBtn.getActionCommand().equals(cmtNut[2])){ //sửa thông tin thiết bị
                                    int i= dataTable.getSelectedRow();
                                    int j= 0;
                                    if (i!=0){
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
                                        int ngayBaoHanh =Integer.parseInt((String)tbList.getValueAt(i, 4));
                                        if(bllQuanLyDanhSach.kiemTraGiaThietBi(giaThietBi)==-1){
                                            JOptionPane.showMessageDialog(null, "Giá thiết bị phải lớn hơn hoặc bằng 0", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        else if(bllQuanLyDanhSach.kiemNgayBaoHanh(ngayBaoHanh)==-1){
                                            JOptionPane.showMessageDialog(null, "Ngày bảo hành phải lớn hơn hoặc bằng 0", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        else{
                                            LoaiThietBi tempTB = new LoaiThietBi((String)tbList.getValueAt(i,0),
                                                                    (String)tbList.getValueAt(i,1),
                                                                    (String)tbList.getValueAt(i,2),
                                                                    (String)tbList.getValueAt(i,3),
                                                                    Integer.parseInt((String)tbList.getValueAt(i,4)));
                                            if(bllQuanLyDanhSach.suaThongTinTB(tempTB)){
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
                                                return;
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                                                return;
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
                                                        if(i==0 && j==0 && !textField.isEditable()){
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
                                        textField = (JTextField) smallComponents[0];
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
                                            int row = dataTable.getSelectedRow();
                                            if(row != -1){
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
                    ArrayList<HoaDon> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSHoaDon();
                    Vector<String> dsCoSo = new Vector<>();
                    dsCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    QuanLyHoaDon(ds, dsCoSo);
                }
                else if(selectedOption.equals("Chi tiết hóa đơn")){
                    ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSChiTietHoaDon();
                    QuanLyChiTietHoaDon(ds);
                }
                else if(selectedOption.equals("Hàng hóa cơ sở")){
                    ArrayList<hangHoaCoSo> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSHangHoaCoSo();
                    Vector<String> dsMaCoSo = new Vector<>();
                    dsMaCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    QuanLyHangHoaCoSo(ds,dsMaCoSo);
                }
                else if(selectedOption.equals("Hội viên cơ sở")){
                    ArrayList<HoiVienCoSo> ds = new ArrayList<>();
                    Vector<String> dsCoSo = new Vector<>();
                    dsCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    ds = bllQuanLyDanhSach.layDSHoiVienCoSo();
                    QuanLyHoiVienCoSo(ds,dsCoSo);
                }
                else if(selectedOption.equals("Hàng hóa")){
                    xoaHienThi(rightPanel);
                    // tạo model bảng
                    DefaultTableModel hhList = new DefaultTableModel();
                    for (int i = 0; i < tenCotHH.size(); i++) {
                        hhList.addColumn(tenCotHH.get(i));
                    }
                    // Thêm dữ liệu vào bảng
                    for (int i = 0; i < dsHH.dsHangHoa.size(); i++) {
                            hhList.addRow(new Object[]{
                            dsHH.dsHangHoa.get(i).getMaHangHoa().trim(),
                            dsHH.dsHangHoa.get(i).getLoaiHangHoa().trim(),
                            dsHH.dsHangHoa.get(i).getTenLoaiHangHoa().trim(),
                            dsHH.dsHangHoa.get(i).getHinhAnh().trim(),
                            dsHH.dsHangHoa.get(i).getGiaNhap(),
                            });
                    }
                    
                    //bảng hiện dòng thông tin được chọn
                    bangChinhSua = new JPanel();
                    bangChinhSua.setBounds(5,175,(int)(width*0.75)-25,270);
                    bangChinhSua.setLayout(new GridLayout(3,3,10,10));
                    bangChinhSua.setBackground(new Color(119, 230, 163));
                    
                    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                    TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                    titledBorder.setTitleFont(italicBoldFont);
                    bangChinhSua.setBorder(titledBorder);
                   
                    for(int i=0;i<tenCotHH.size();i++){
                        JPanel tempPanel = new JPanel();
                        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackBorder,tenCotHH.get(i));
                        titledBorder1.setTitleFont(titledBorder.getTitleFont().deriveFont(18f));
                        tempPanel.setBorder(titledBorder1);
                        tempPanel.setBackground(Color.white);

                        JTextField tempTF = new JTextField();
                        tempTF.setPreferredSize(new Dimension(200,20));
                        tempTF.setBounds(0,20,120,20);
                        tempTF.setName(tenCotHH.get(i));

                        if(i==0){
                            tempTF.setEditable(false);
                        }
                        if(i==1){
                            String[] tempStr = {"Dụng cụ", "Thực phẩm chức năng"};
                            @SuppressWarnings("rawtypes")
                            JComboBox tempCB = new JComboBox<String>(tempStr);
                            tempCB.setPreferredSize(new Dimension(150,30));
                            tempCB.setFont(new Font("Times New Roman",1,16)); 
                            tempCB.setRenderer(renderer);
                            tempCB.setBackground(Color.WHITE);

                            tempPanel.add(tempCB);
                            bangChinhSua.add(tempPanel);
                            continue;
                        }
                        // tempPanel.add(tempLabel);
                        tempPanel.add(tempTF);
                        bangChinhSua.add(tempPanel);
                    }

                    rightPanel.add(bangChinhSua);
                    rightPanel.revalidate();
                    rightPanel.repaint();

                    dataTable = new JTable(hhList);
                    dataTable.getTableHeader().setReorderingAllowed(false);
                    for (int i = 0; i < dataTable.getColumnCount(); i++) {
                        dataTable.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                    }
                    scrollPane = new JScrollPane(dataTable);
                    scrollPane.setBounds(5,460,(int)(width*0.75)-20,400);

                    //nút chức năng
                    String[] cmtNut = {"add", "remove", "edit", "Search"};
                    String[] anhStrings = {
                        "src/asset/img/button/hh-them.png",
                        "src/asset/img/button/hh-xoa.png",
                        "src/asset/img/button/hh-sua.png",
                        "src/asset/img/button/hh-tim.png"
                    };
                    int a=335;
                    for(int i=0;i<cmtNut.length;i++){
                        JButton tempBtn = new JButton();
                        ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
                        Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                        tempBtn.setActionCommand(cmtNut[i]);
                        tempBtn.setBounds(a,110,130,35);
                        tempBtn.setIcon(new ImageIcon(scaleTempBtnImg));
                        tempBtn.setHorizontalAlignment(SwingConstants.CENTER);
                        tempBtn.setBorder(null);
                        tempBtn.addActionListener(new ActionListener() {
                            private int demLanNutTimKiem=0;
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(tempBtn.getActionCommand().equals(cmtNut[0])){ //thêm hàng hóa
                                    boolean flag = true; // cờ hiệu gán giá trị cho mã hàng hóa
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
                                                    if (flag && j == 0) {
                                                        int maxSTT = bllQuanLyDanhSach.kiemTraMaHangHoa();
                                                        textField.setText(String.format("HH%03d", maxSTT));
                                                        thongTinMoi.add(textField.getText());
                                                        flag = false;
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
                                                if(smallComponents[j] instanceof JComboBox){
                                                    @SuppressWarnings("rawtypes")
                                                    JComboBox tempCB = (JComboBox) smallComponents[j];
                                                    thongTinMoi.add((String)tempCB.getSelectedItem());
                                                }
                                            }
                                        }
                                    }
                                     // Kiểm tra xem thongTinMoi có đủ 8 phần tử không trước khi thêm vào hvList
                                    if (thongTinMoi.size() >= 5) {
                                        hhList.addRow(thongTinMoi.toArray());
                                        try{
                                            hangHoa tempHH;
                                            tempHH = new hangHoa(thongTinMoi.get(0),
                                                                thongTinMoi.get(1),
                                                                thongTinMoi.get(2),
                                                                thongTinMoi.get(3),
                                                                Integer.parseInt(thongTinMoi.get(4)));
                                            if(bllQuanLyDanhSach.themHH(tempHH)){
                                                JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công!");
                                            }
                                        }
                                        catch(IllegalArgumentException ex){
                                            JOptionPane.showMessageDialog(bangChinhSua, ex.getMessage(), "Thông tin không hợp lệ", JOptionPane.ERROR_MESSAGE);
                                            hhList.removeRow(dataTable.getRowCount()-1);
                                            return;
                                        }
                                    } 
                                    else {
                                        JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[1])){ //xóa hàng hóa
                                    int i=dataTable.getSelectedRow();
                                    if(i>=0){
                                        Component[] components = bangChinhSua.getComponents();
                                        hhList.removeRow(i);
                                        for (Component component : components) {
                                            if (component instanceof JPanel) {
                                                JPanel tempPanel = (JPanel) component;
                                                Component[] smallComponents = tempPanel.getComponents();
                                                for (Component smallComponent : smallComponents) {
                                                    if(smallComponent instanceof JTextField){
                                                        JTextField textField = (JTextField) smallComponent;
                                                        if(bllQuanLyDanhSach.xoaHangHoa(textField.getText())){
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
                                                    if(smallComponent instanceof JComboBox){
                                                        @SuppressWarnings("rawtypes")
                                                        JComboBox tempCB = (JComboBox) smallComponent;
                                                        tempCB.setSelectedItem("Dụng cụ");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[2])){ //sửa thông tin hàng hóa
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
                                                        hhList.setValueAt(text,i,j);
                                                        j++;
                                                    }
                                                    if (smallComponent instanceof JComboBox) {
                                                        @SuppressWarnings("rawtypes")
                                                        JComboBox tempCB = (JComboBox) smallComponent;
                                                        String text = (String) tempCB.getSelectedItem();
                                                        hhList.setValueAt(text,i,j);
                                                        j++;
                                                    }
                                                }
                                            }
                                        }
                                        hangHoa tempTB;
                                        try{
                                            tempTB = new hangHoa((String)hhList.getValueAt(i,0),
                                                                    (String)hhList.getValueAt(i,1),
                                                                    (String)hhList.getValueAt(i,2),
                                                                    (String)hhList.getValueAt(i,3),
                                                                    Integer.parseInt((String)hhList.getValueAt(i, 4)));
                                            if(bllQuanLyDanhSach.suaThongTinHH(tempTB)){
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                        catch (IllegalArgumentException ex){
                                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } 
                                    
                                }
                                else if(tempBtn.getActionCommand().equals(cmtNut[3])){ //tìm kiếm hàng hóa theo mã tron danh sách
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
                                                        if(i==0 && j==0 && !textField.isEditable()){
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
                                        textField = (JTextField) smallComponents[0];
                                        int column =0;
                                        if(bllQuanLyDanhSach.timKiemTheoMaHH(textField.getText().toUpperCase())){
                                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm thành công","Tìm kiếm hàng hóa", JOptionPane.INFORMATION_MESSAGE);
                                            for(int i=0; i<dsHH.dsHangHoa.size();i++){
                                                if(textField.getText().toUpperCase().equals(dsHH.dsHangHoa.get(i).getMaHangHoa())){
                                                    dataTable.changeSelection(i,0,false,false);
                                                    break;
                                                }
                                            }
                                            textField.setEditable(false);
                                            this.demLanNutTimKiem=0;
                                            //hiển thị nội dung trong textField
                                            int row = dataTable.getSelectedRow();
                                            if(row != -1){
                                                for (int j = 0; j < components.length; j++) {
                                                    if (components[j] instanceof JPanel) {
                                                        JPanel panel = (JPanel) components[j];
                                                        Component[] smallComponents2 = panel.getComponents();
                                                        for (int i = 0; i < smallComponents2.length; i++) {
                                                            if (smallComponents2[i] instanceof JTextField) {
                                                                JTextField tempTF = (JTextField) smallComponents2[i];
                                                                if(column==4){
                                                                    tempTF.setText(hhList.getValueAt(row, column).toString());
                                                                }
                                                                else
                                                                    tempTF.setText(((String) hhList.getValueAt(row, column)).trim());
                                                            }
                                                            if (smallComponents2[i] instanceof JComboBox){
                                                                @SuppressWarnings("rawtypes")
                                                                JComboBox tempCB = (JComboBox) smallComponents2[i];
                                                                tempCB.setSelectedItem(hhList.getValueAt(row, column).toString());
                                                            }
                                                        }
                                                        column++;
                                                    }
                                                }
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm không thành công","Tìm kiếm hàng hóa", JOptionPane.ERROR_MESSAGE);
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
                                                tempTF.setText(hhList.getValueAt(i, j).toString().trim());
                                                j++;
                                            }
                                            if(b instanceof JComboBox){
                                                @SuppressWarnings("rawtypes")
                                                JComboBox tempCB = (JComboBox) b;
                                                tempCB.setSelectedItem(hhList.getValueAt(i, j).toString().trim());
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
            }
            public void QuanLyHangHoaCoSo(ArrayList<hangHoaCoSo> ds, Vector<String> dsMaCoSo)
            {
                xoaHienThi(rightPanel);
                Font f = new Font("Times New Roman",Font.BOLD,17);
            	JButton them = new JButton();
                ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/hh-them.png");
                Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                them.setPreferredSize(new Dimension (130,35));
                them.setIcon(new ImageIcon(scaleThemBtnImg));
                them.setHorizontalAlignment(SwingConstants.CENTER);
                them.setBorder(null);

            	JButton xoa  = new JButton();
                xoa.setPreferredSize(new Dimension (110,35));
                ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/hh-xoa.png");
                Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                xoa.setPreferredSize(new Dimension (130,35));
                xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
                xoa.setHorizontalAlignment(SwingConstants.CENTER);
                xoa.setBorder(null);

            	JButton sua = new JButton();
                sua.setPreferredSize(new Dimension (110,35));
                ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/hh-sua.png");
                Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                sua.setPreferredSize(new Dimension (130,35));
                sua.setIcon(new ImageIcon(scaleSuaBtnImg));
                sua.setHorizontalAlignment(SwingConstants.CENTER);
                sua.setBorder(null);

            	JButton timKiem = new JButton();
                timKiem.setPreferredSize(new Dimension (110,35));
                ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/hh-tim.png");
                Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                timKiem.setPreferredSize(new Dimension (130,35));
                timKiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
                timKiem.setHorizontalAlignment(SwingConstants.CENTER);
                timKiem.setBorder(null);

                JPanel chucNang = new JPanel(new FlowLayout());
                chucNang.add(them);
                chucNang.add(xoa);
                chucNang.add(sua);
                chucNang.add(timKiem);
                chucNang.setBounds(5,100,rightPanel.getWidth()-5,38);
                chucNang.setBackground(Color.WHITE);
                rightPanel.add(chucNang);

                JPanel nhapLieu = new JPanel(null);
                nhapLieu.setBounds(2, 150, rightPanel.getWidth()-20, 70);
                Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                titledBorder.setTitleFont(italicBoldFont);
                nhapLieu.setBackground(new Color(119, 230, 163));
                nhapLieu.setBorder(titledBorder);

                JLabel lbMaHangHoa = new JLabel("Mã hàng hóa: ");
                JLabel lbMaCoSo = new JLabel("Mã cơ sở: ");
                JLabel lbSoLuong = new JLabel("Số lượng: ");
                JTextField tfMaHangHoa = new JTextField();
                @SuppressWarnings("rawtypes")
                JComboBox cbMaCoSo = new JComboBox<>(dsMaCoSo);
                cbMaCoSo.setBackground(Color.WHITE);
                JTextField tfSoLuong = new JTextField();
                int x = 250;
                lbMaHangHoa.setBounds(x, 25, 80, 30); x+=80;
                tfMaHangHoa.setBounds(x+10, 25, 100, 30); x+=110;
                lbMaCoSo.setBounds(x+50, 25, 70, 30); x+=120;
                cbMaCoSo.setBounds(x+10, 25, 100, 30); x+=110;
                lbSoLuong.setBounds(x+50, 25, 70, 30); x+=120;
                tfSoLuong.setBounds(x+10, 25, 100, 30);
                nhapLieu.add(lbMaHangHoa);
                nhapLieu.add(tfMaHangHoa);
                nhapLieu.add(lbMaCoSo);
                nhapLieu.add(cbMaCoSo);
                nhapLieu.add(lbSoLuong);
                nhapLieu.add(tfSoLuong);
                rightPanel.add(nhapLieu);

                JTable bang = new JTable();
                DefaultTableModel model = new DefaultTableModel();
                bang.setModel(model);
                
                model.addColumn("Mã hàng hóa");
                model.addColumn("Mã cơ sở");
                model.addColumn("Số lượng");
                for (int i = 0; i < bang.getColumnCount(); i++) {
                    bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                }
                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                for(int i=0;i<ds.size();i++)
                model.addRow(new Object[]{ds.get(i).getMaHangHoa(),ds.get(i).getMaCoSo(),ds.get(i).getSoLuong()});
                bang.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e)
                    {
                        int i = bang.getSelectedRow();
                        if(i>=0)
                        {
                            tfMaHangHoa.setText(model.getValueAt(i, 0).toString());
                            cbMaCoSo.setSelectedItem(model.getValueAt(i, 1).toString());
                            tfSoLuong.setText(model.getValueAt(i, 2).toString());
                        }
                    }
                });
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(tfMaHangHoa.getText().equals("")||cbMaCoSo.getSelectedIndex() == 0||tfSoLuong.getText().equals(""))
                        JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                        else
                        {
                            String s = bllQuanLyDanhSach.themHangHoaCoSo(tfMaHangHoa.getText(), cbMaCoSo.getSelectedItem().toString(), Integer.parseInt(tfSoLuong.getText()));
                            JOptionPane.showMessageDialog(rightPanel, s);
                            if(s.equals("Thành công"))
                            model.addRow(new Object[]{tfMaHangHoa.getText(), cbMaCoSo.getSelectedItem().toString(), Integer.parseInt(tfSoLuong.getText())});
                        }
                    }
                });
                xoa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(tfMaHangHoa.getText().equals("")||cbMaCoSo.getSelectedIndex() == 0) JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã cơ sở và mã hàng hóa");
                        else
                        {
                            String s = bllQuanLyDanhSach.xoaHangHoaCoSo(cbMaCoSo.getSelectedItem().toString(), tfMaHangHoa.getText());
                            JOptionPane.showMessageDialog(rightPanel, s);
                            if(s.equals("Thành công"))
                            for(int i=0;i<model.getRowCount();i++)
                            if(model.getValueAt(i, 0).toString().equals(tfMaHangHoa.getText()) && model.getValueAt(i, 1).toString().equals(cbMaCoSo.getSelectedItem().toString()))
                            model.removeRow(i);
                        }
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(tfMaHangHoa.getText().equals("")||cbMaCoSo.getSelectedIndex() == 0||tfSoLuong.getText().equals(""))
                        JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                        else
                        {
                            String s = bllQuanLyDanhSach.suaHangHoaCoSo(cbMaCoSo.getSelectedItem().toString(), tfMaHangHoa.getText(), Integer.parseInt(tfSoLuong.getText()));
                            JOptionPane.showMessageDialog(rightPanel, s);
                            if(s.equals("Thành công"))
                            {
                                for(int i=0;i<model.getRowCount();i++)
                                if(model.getValueAt(i, 0).toString().equals(tfMaHangHoa.getText()) && model.getValueAt(i, 1).toString().equals(cbMaCoSo.getSelectedItem().toString()))
                                model.setValueAt(tfSoLuong.getText(), i, 2);
                            }
                        }
                    }
                });
                timKiem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        model.setRowCount(0);
                        if(tfMaHangHoa.getText().equals("")&&cbMaCoSo.getSelectedIndex()==0) 
                        {
                            for(int i=0;i<ds.size();i++)
                            model.addRow(new Object[]{ds.get(i).getMaHangHoa(),ds.get(i).getMaCoSo(),ds.get(i).getSoLuong()});
                        }
                        else
                        {
                            ArrayList<hangHoaCoSo> ds2 = new ArrayList<>();
                            ds2 = bllQuanLyDanhSach.timKiemHangHoaCoSo(cbMaCoSo.getSelectedItem().toString(), tfMaHangHoa.getText());
                            for(int i=0;i<ds2.size();i++)
                            model.addRow(new Object[]{ds2.get(i).getMaHangHoa(),ds2.get(i).getMaCoSo(),ds2.get(i).getSoLuong()});
                        }
                    }
                });
                JScrollPane scrollPane = new JScrollPane(bang);
                scrollPane.setBounds(5, 230, rightPanel.getWidth()-20, rightPanel.getHeight()-270);
                rightPanel.add(scrollPane);
            }
            public void QuanLyHoaDon(ArrayList<HoaDon> ds, Vector<String> dsMaCoSo)
            {
                xoaHienThi(rightPanel);
                Font f = new Font("Times New Roman",Font.BOLD,17);
            	JButton them = new JButton();
                ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-hd.png");
                Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                them.setPreferredSize(new Dimension (130,35));
                them.setIcon(new ImageIcon(scaleThemBtnImg));
                them.setHorizontalAlignment(SwingConstants.CENTER);
                them.setBorder(null);

            	JButton xoa  = new JButton();
                xoa.setPreferredSize(new Dimension (110,35));
                ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-hd.png");
                Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                xoa.setPreferredSize(new Dimension (130,35));
                xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
                xoa.setHorizontalAlignment(SwingConstants.CENTER);
                xoa.setBorder(null);

            	JButton sua = new JButton();
                sua.setPreferredSize(new Dimension (110,35));
                ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-hd.png");
                Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                sua.setPreferredSize(new Dimension (130,35));
                sua.setIcon(new ImageIcon(scaleSuaBtnImg));
                sua.setHorizontalAlignment(SwingConstants.CENTER);
                sua.setBorder(null);

            	JButton timKiem = new JButton();
                timKiem.setPreferredSize(new Dimension (110,35));
                ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-hd.png");
                Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                timKiem.setPreferredSize(new Dimension (130,35));
                timKiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
                timKiem.setHorizontalAlignment(SwingConstants.CENTER);
                timKiem.setBorder(null);

                JPanel chucNang = new JPanel(new FlowLayout());
                chucNang.add(them);
                chucNang.add(xoa);
                chucNang.add(sua);
                chucNang.add(timKiem);
                chucNang.setBounds(5,100,rightPanel.getWidth()-5,38);
                chucNang.setBackground(Color.WHITE);
                rightPanel.add(chucNang);

                JPanel nhapLieu = new JPanel(null);
                nhapLieu.setBounds(2, 150, rightPanel.getWidth()-20, 150);
                Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                titledBorder.setTitleFont(italicBoldFont);
                nhapLieu.setBackground(new Color(119, 230, 163));
                nhapLieu.setBorder(titledBorder);

                JLabel lbMaHoaDon = new JLabel("Mã hóa đơn: ");
                JLabel lbNgayXuatHoaDon = new JLabel("Ngày xuất hóa đơn: ");
                JLabel lbtongTien = new JLabel("Tổng tiền: ");
                JLabel lbMaHV = new JLabel("Mã hội viên: ");
                JLabel lbMaCoSO = new JLabel("Mã cơ sở: ");
                JLabel lbTrangThai = new JLabel("Trạng thái: ");
                JTextField tfMaHoaDon = new JTextField();
                JTextField tfNgayXuatHoaDon = new JTextField();
                JTextField tftongTien = new JTextField();
                JTextField tfMaHV = new JTextField();
                @SuppressWarnings("rawtypes")
                JComboBox cbMaCoSO = new JComboBox(dsMaCoSo);
                cbMaCoSO.setRenderer(renderer);
                cbMaCoSO.setBackground(Color.white);
                JTextField tfTrangThai = new JTextField();
                int x = 10;
                lbMaHoaDon.setBounds(x,40,80,30); x+=80;
                tfMaHoaDon.setBounds(x+10, 40, 100, 30); x+=105;
                lbNgayXuatHoaDon.setBounds(x+50, 40, 120, 30); x+=165;
                tfNgayXuatHoaDon.setBounds(x+10, 40, 100, 30); x+=105;
                lbtongTien.setBounds(x+50,40,70,30); x+=115;
                tftongTien.setBounds(x+10, 40, 100, 30); x+=105;
                lbMaHV.setBounds(x+50, 40, 80, 30); x+=125;
                tfMaHV.setBounds(x+10, 40, 100, 30); x+=105;
                lbMaCoSO.setBounds(x+50, 40, 70, 30); x+=115;
                cbMaCoSO.setBounds(x+10, 40, 100, 30); x+=105;
                lbTrangThai.setBounds(450, 100, 80, 35);
                JRadioButton daduyet = new JRadioButton("Đã duyệt");
                daduyet.setBounds(540, 100, 100, 35);
                daduyet.setBackground(new Color(119, 230, 163));
                JRadioButton chuaduyet = new JRadioButton("Chưa duyệt");
                chuaduyet.setBounds(650, 100, 100, 35);
                chuaduyet.setBackground(new Color(119, 230, 163));
                ButtonGroup bg = new ButtonGroup();
                bg.add(daduyet);
                bg.add(chuaduyet);

                nhapLieu.add(lbMaHoaDon);
                nhapLieu.add(tfMaHoaDon);
                nhapLieu.add(lbNgayXuatHoaDon);
                nhapLieu.add(tfNgayXuatHoaDon);
                nhapLieu.add(lbtongTien);
                nhapLieu.add(tftongTien);
                nhapLieu.add(lbMaHV);
                nhapLieu.add(tfMaHV);
                nhapLieu.add(lbMaCoSO);
                nhapLieu.add(cbMaCoSO);
                nhapLieu.add(lbTrangThai);
                nhapLieu.add(daduyet);
                nhapLieu.add(chuaduyet);
                rightPanel.add(nhapLieu);

                JTable bang = new JTable();
                DefaultTableModel model = new DefaultTableModel();
                bang.setModel(model);
                model.addColumn("Mã hóa đơn");
                model.addColumn("Ngày xuất hóa đơn");
                model.addColumn("Tổng tiền");
                model.addColumn("Mã hội viên");
                model.addColumn("Mã cơ sở");
                model.addColumn("Trạng thái");
                for(int i=0;i<ds.size();i++)
                {
                    String trangThai;
                    if(ds.get(i).getTrangThai().trim().equals("1")) trangThai = "Đã duyệt";
                    else trangThai = "Chưa duyệt";
                    model.addRow(new Object[]{ds.get(i).getMaHoaDon(),ds.get(i).getNgayXuatHoaDon(),ds.get(i).getTongTien(),ds.get(i).getMaHoiVien(),ds.get(i).getMaCoSo(),trangThai});
                }
                bang.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < bang.getColumnCount(); i++) {
                    bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                }

                bang.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e)
                    {
                        int i = bang.getSelectedRow();
                        if(i>=0)
                        {
                            tfMaHoaDon.setText(model.getValueAt(i, 0).toString());
                            tfNgayXuatHoaDon.setText(model.getValueAt(i, 1).toString());
                            tftongTien.setText(model.getValueAt(i, 2).toString());
                            tfMaHV.setText(model.getValueAt(i, 3).toString());
                            cbMaCoSO.setSelectedItem(model.getValueAt(i, 4).toString());
                            if(model.getValueAt(i, 5) == "Đã duyệt") daduyet.setSelected(true);
                            else chuaduyet.setSelected(true);
                        }
                    }
                });
                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(!tfMaHoaDon.getText().equals("")|| !tftongTien.getText().equals("")) JOptionPane.showMessageDialog(rightPanel, "Không cần nhập mã hóa đơn và tổng tiền");
                        if(tfMaHV.getText().equals("")||tfNgayXuatHoaDon.getText().equals("")||cbMaCoSO.getSelectedIndex() == 0 || (!daduyet.isSelected()&&!chuaduyet.isSelected()) ) JOptionPane.showMessageDialog(rightPanel, "Thiết thông tin");
                        String trangThai;
                        if(daduyet.isSelected()) trangThai = "1";
                        else trangThai = "0";
                        LocalDate localDate = LocalDate.parse(tfNgayXuatHoaDon.getText());
                        Date date = Date.valueOf(localDate);
                        String s;
                        String ma = bllQuanLyDanhSach.layMaHoaDon();
                        s = bllQuanLyDanhSach.themHoaDon(date, tfMaHV.getText(), cbMaCoSO.getSelectedItem().toString(), trangThai);
                        JOptionPane.showMessageDialog(rightPanel,s);
                        if(s.equals("Thành công")) 
                        {
                            tfMaHoaDon.setText(ma);
                            tftongTien.setText("0");
                            if(trangThai.equals("1")) model.addRow(new Object[]{ma,date,0,tfMaHV.getText(),cbMaCoSO.getSelectedItem().toString(),"Đã duyệt"});
                            else model.addRow(new Object[]{ma,date,0,tfMaHV.getText(),cbMaCoSO.getSelectedItem().toString(),"Chưa duyệt"});
                        }
                    }
                });
                xoa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(tfMaHoaDon.getText().equals("")) JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã hóa đơn");
                        else 
                        {
                            String s = bllQuanLyDanhSach.xoaHoaDon(tfMaHoaDon.getText());
                            JOptionPane.showMessageDialog(rightPanel,s);
                            if(s.equals("Thành công"))
                            {
                                for(int i=0;i<model.getRowCount();i++)  
                                if(model.getValueAt(i, 0).equals(tfMaHoaDon.getText()))
                                {
                                    model.removeRow(i);
                                    break;
                                } 
                            }
                        }
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if( tfMaHoaDon.getText().equals("") || 
                            tfMaHV.getText().equals("") ||
                            tfNgayXuatHoaDon.getText().equals("") ||
                            cbMaCoSO.getSelectedIndex() == 0 || 
                            (!daduyet.isSelected()&&!chuaduyet.isSelected())) JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                        else 
                        {
                            if(!tftongTien.getText().equals("")) JOptionPane.showMessageDialog(rightPanel, "Không cần nhập tổng tiền");
                            else 
                            {
                                String trangThai;
                                if(daduyet.isSelected()) trangThai = "1";
                                else trangThai = "0";
                                LocalDate localDate = LocalDate.parse(tfNgayXuatHoaDon.getText());
                                Date date = Date.valueOf(localDate);
                                String s = bllQuanLyDanhSach.suaHoaDon(tfMaHoaDon.getText(), date, tfMaHV.getText(), cbMaCoSO.getSelectedItem().toString(),trangThai);
                                JOptionPane.showMessageDialog(rightPanel, s);
                                if(s.equals("Thành công"))
                                {
                                    for(int i=0;i<model.getRowCount();i++)  
                                    if(model.getValueAt(i, 0).equals(tfMaHoaDon.getText()))
                                    {
                                        model.setValueAt(tfNgayXuatHoaDon.getText(), i, 1);
                                        model.setValueAt(tfMaHV.getText(), i, 3);
                                        model.setValueAt(cbMaCoSO.getSelectedItem().toString(), i, 4);
                                        if(trangThai.equals("1")) model.setValueAt("Đã duyệt", i, 5);
                                        else model.setValueAt("Chưa duyệt", i, 5);
                                        break;
                                    } 
                                }
                            }
                        }
                    }
                });
                timKiem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        model.setRowCount(0);
                        if(tfMaHoaDon.getText().equals("")) 
                        {
                            for(int i=0;i<ds.size();i++)
                            {
                                String trangThai;
                                if(ds.get(i).getTrangThai().trim().equals("1")) trangThai = "Đã duyệt";
                                else trangThai = "Chưa duyệt";
                                model.addRow(new Object[]{ds.get(i).getMaHoaDon(),ds.get(i).getNgayXuatHoaDon(),ds.get(i).getTongTien(),ds.get(i).getMaHoiVien(),ds.get(i).getMaCoSo(),trangThai});
                            }
                        }
                        else
                        {
                            ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
                            dsHoaDon = bllQuanLyDanhSach.timKiemHoaDon(tfMaHoaDon.getText());
                            for(int i=0;i<dsHoaDon.size();i++)
                            {
                                String trangThai;
                                if(dsHoaDon.get(i).getTrangThai().trim().equals("1")) trangThai = "Đã duyệt";
                                else trangThai = "Chưa duyệt";
                                model.addRow(new Object[]{dsHoaDon.get(i).getMaHoaDon(),dsHoaDon.get(i).getNgayXuatHoaDon(),dsHoaDon.get(i).getTongTien(),dsHoaDon.get(i).getMaHoiVien(),dsHoaDon.get(i).getMaCoSo(),trangThai});
                            }
                        }
                    }
                });
                JScrollPane scrollPane = new JScrollPane(bang);
                scrollPane.setBounds(5, 300, rightPanel.getWidth()-20, rightPanel.getHeight()-340);
                rightPanel.add(scrollPane);
            }
            public void QuanLyChiTietHoaDon(ArrayList<ChiTietHoaDon> ds)
            {
                xoaHienThi(rightPanel);
                Font f = new Font("Times New Roman",Font.BOLD,17);
            	JButton them = new JButton();
                ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-hd.png");
                Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                them.setPreferredSize(new Dimension (130,35));
                them.setIcon(new ImageIcon(scaleThemBtnImg));
                them.setHorizontalAlignment(SwingConstants.CENTER);
                them.setBorder(null);

            	JButton xoa  = new JButton();
                xoa.setPreferredSize(new Dimension (110,35));
                ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-hd.png");
                Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                xoa.setPreferredSize(new Dimension (130,35));
                xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
                xoa.setHorizontalAlignment(SwingConstants.CENTER);
                xoa.setBorder(null);

            	JButton sua = new JButton();
                sua.setPreferredSize(new Dimension (110,35));
                ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-hd.png");
                Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                sua.setPreferredSize(new Dimension (130,35));
                sua.setIcon(new ImageIcon(scaleSuaBtnImg));
                sua.setHorizontalAlignment(SwingConstants.CENTER);
                sua.setBorder(null);

            	JButton timKiem = new JButton();
                timKiem.setPreferredSize(new Dimension (110,35));
                ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-hd.png");
                Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                timKiem.setPreferredSize(new Dimension (130,35));
                timKiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
                timKiem.setHorizontalAlignment(SwingConstants.CENTER);
                timKiem.setBorder(null);

                JPanel chucNang = new JPanel(new FlowLayout());
                chucNang.add(them);
                chucNang.add(xoa);
                chucNang.add(sua);
                chucNang.add(timKiem);
                chucNang.setBounds(5,100,rightPanel.getWidth()-5,38);
                chucNang.setBackground(Color.WHITE);
                rightPanel.add(chucNang);

                JPanel nhapLieu = new JPanel(null);
                nhapLieu.setBounds(2, 150, rightPanel.getWidth()-20, 80);
                Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                titledBorder.setTitleFont(italicBoldFont);
                nhapLieu.setBackground(new Color(119, 230, 163));
                nhapLieu.setBorder(titledBorder);

                JLabel maHoaDon = new JLabel("Mã hóa đơn: ");
                JLabel maHangHoa = new JLabel("Mã hàng hóa: ");
                JLabel soLuong = new JLabel("Số lượng: ");
                JTextField tfMaHoaDon = new JTextField();
                JTextField tfMaHangHoa = new JTextField();
                JTextField tfSoLuong = new JTextField();
                int x=250;
                maHoaDon.setBounds(x, 30, 80, 30); x+=80;
                tfMaHoaDon.setBounds(x+10, 30, 100, 30); x+=110;
                maHangHoa.setBounds(x+50, 30, 80, 30); x+=130;
                tfMaHangHoa.setBounds(x+10, 30, 100, 30); x+=110;
                soLuong.setBounds(x+50, 30, 60, 30); x+=110;
                tfSoLuong.setBounds(x+10, 30, 100, 30); 

                nhapLieu.add(maHoaDon);
                nhapLieu.add(tfMaHoaDon);
                nhapLieu.add(maHangHoa);
                nhapLieu.add(tfMaHangHoa);
                nhapLieu.add(soLuong);
                nhapLieu.add(tfSoLuong);
                rightPanel.add(nhapLieu);

                JTable bang = new JTable();
                DefaultTableModel model = new DefaultTableModel();
                bang.setModel(model);
                model.addColumn("Mã hóa đơn");
                model.addColumn("Mã hàng hóa");
                model.addColumn("Số lượng");
                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                for(int i=0;i<ds.size();i++)
                model.addRow(new Object[]{ds.get(i).getMaHoaDon(), ds.get(i).getMaHangHoa(), ds.get(i).getSoLuong()});
                bang.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e)
                    {
                        int i = bang.getSelectedRow();
                        if(i>=0)
                        {
                            tfMaHoaDon.setText(model.getValueAt(i, 0).toString());
                            tfMaHangHoa.setText(model.getValueAt(i, 1).toString());
                            tfSoLuong.setText(model.getValueAt(i, 2).toString());
                        }
                    }
                });
                bang.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < bang.getColumnCount(); i++) {
                    bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                }
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(tfMaHangHoa.getText().equals("")||tfMaHoaDon.getText().equals("")||tfSoLuong.getText().equals(""))
                        JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập đủ thông tin");
                        String s = bllQuanLyDanhSach.themChiTietHoaDon(tfMaHoaDon.getText(),tfMaHangHoa.getText(),Integer.parseInt(tfSoLuong.getText()));
                        if(s.equals("Thành công"))
                        model.addRow(new Object[]{tfMaHangHoa.getText(),tfMaHoaDon.getText(),tfSoLuong.getText()});
                        JOptionPane.showMessageDialog(rightPanel, s);
                    }
                });
                xoa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(tfMaHangHoa.getText().equals("")||tfMaHoaDon.getText().equals(""))
                        JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã hàng hóa và mã hóa đơn");
                        String s = bllQuanLyDanhSach.xoaChiTietHoaDon(tfMaHoaDon.getText(),tfMaHangHoa.getText());
                        if(s.equals("Thành công"))
                        {
                            for(int i=0;i<model.getRowCount();i++)
                            {
                                if(model.getValueAt(i, 0).equals(tfMaHoaDon.getText()) && model.getValueAt(i, 1).equals(tfMaHangHoa.getText()))
                                {
                                    model.removeRow(i);
                                    break;
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(rightPanel, s);
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(tfMaHangHoa.getText().equals("")||tfMaHoaDon.getText().equals("")||tfSoLuong.getText().equals(""))
                        JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập đủ thông tin");
                        String s = bllQuanLyDanhSach.suaChiTietHoaDon(tfMaHoaDon.getText(), tfMaHangHoa.getText(), Integer.parseInt(tfSoLuong.getText()));
                        if(s.equals("Thành công"))
                        {
                            for(int i=0;i<model.getRowCount();i++)
                            {
                                if(model.getValueAt(i, 0).equals(tfMaHoaDon.getText()) && model.getValueAt(i, 1).equals(tfMaHangHoa.getText()))
                                model.setValueAt(tfSoLuong.getText(), i, 2);
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(rightPanel, s);
                    }
                });
                timKiem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        model.setRowCount(0);
                        if(tfMaHoaDon.getText().equals("")&&tfMaHangHoa.getText().equals("")) 
                        {
                            for(int i=0;i<ds.size();i++)
                            model.addRow(new Object[]{ds.get(i).getMaHoaDon(), ds.get(i).getMaHangHoa(), ds.get(i).getSoLuong()});
                        }
                        else
                        {
                            ArrayList<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<>();
                            dsChiTietHoaDon = bllQuanLyDanhSach.timKiemChiTietHoaDon(tfMaHoaDon.getText(), tfMaHangHoa.getText());
                            for(int i=0;i<dsChiTietHoaDon.size();i++)
                            model.addRow(new Object[]{dsChiTietHoaDon.get(i).getMaHoaDon(), dsChiTietHoaDon.get(i).getMaHangHoa(), dsChiTietHoaDon.get(i).getSoLuong()});
                        }
                    }
                });
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(bang);
                scrollPane.setBounds(5, 230, rightPanel.getWidth()-20, rightPanel.getHeight()-270);
                rightPanel.add(scrollPane);
            }
            public void QuanLyHoiVienCoSo(ArrayList<HoiVienCoSo> ds, Vector<String> dsCoSo)
            {
                xoaHienThi(rightPanel);
                Font f = new Font("Times New Roman",Font.BOLD,17);
            	JButton them = new JButton();
                ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-hv.png");
                Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                them.setPreferredSize(new Dimension (130,35));
                them.setIcon(new ImageIcon(scaleThemBtnImg));
                them.setHorizontalAlignment(SwingConstants.CENTER);
                them.setBorder(null);

            	JButton xoa  = new JButton();
                xoa.setPreferredSize(new Dimension (110,35));
                ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-hv.png");
                Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                xoa.setPreferredSize(new Dimension (130,35));
                xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
                xoa.setHorizontalAlignment(SwingConstants.CENTER);
                xoa.setBorder(null);

            	JButton sua = new JButton();
                sua.setPreferredSize(new Dimension (110,35));
                ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-hv.png");
                Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                sua.setPreferredSize(new Dimension (130,35));
                sua.setIcon(new ImageIcon(scaleSuaBtnImg));
                sua.setHorizontalAlignment(SwingConstants.CENTER);
                sua.setBorder(null);

            	JButton timKiem = new JButton();
                timKiem.setPreferredSize(new Dimension (110,35));
                timKiem.setPreferredSize(new Dimension (110,35));
                ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-hv.png");
                Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                timKiem.setPreferredSize(new Dimension (130,35));
                timKiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
                timKiem.setHorizontalAlignment(SwingConstants.CENTER);
                timKiem.setBorder(null);

                JPanel chucNang = new JPanel(new FlowLayout());
                chucNang.add(them);
                chucNang.add(xoa);
                chucNang.add(sua);
                chucNang.add(timKiem);
                chucNang.setBounds(5,100,rightPanel.getWidth()-5,38);
                chucNang.setBackground(Color.WHITE);
                rightPanel.add(chucNang);

                JLabel lbmaHoiVien = new JLabel("Mã hội viên: ");
                JTextField tfMaHoiVien = new JTextField();
                JLabel lbMaCoSo = new JLabel("Mã Cơ Sở: ");
                @SuppressWarnings("rawtypes")
                JComboBox cbMaCoSo = new JComboBox<>(dsCoSo);
                cbMaCoSo.setRenderer(renderer);
                cbMaCoSo.setBackground(Color.WHITE);
                JLabel lbHanTap = new JLabel("Hạn tập: ");

                Vector<String> day = new Vector<>();
                Vector<String> month = new Vector<>();
                Vector<String> year = new Vector<>();
                for(int i=1;i<=31;i++)
                day.add(String.valueOf(i));
                day.add(0,"DD");
                for(int i=1;i<=12;i++)
                month.add(String.valueOf(i));
                month.add(0,"MM");
                for(int i=1990;i<=2100;i++)
                year.add(String.valueOf(i));
                year.add(0,"YYYY");
                
                @SuppressWarnings("rawtypes")
                JComboBox cbDay = new JComboBox<>(day);
                cbDay.setRenderer(renderer);
                cbDay.setBackground(Color.white);
                
                @SuppressWarnings("rawtypes")
                JComboBox cbMonth = new JComboBox<>(month);
                cbMonth.setRenderer(renderer);
                cbMonth.setBackground(Color.white);
                
                @SuppressWarnings("rawtypes")
                JComboBox cbYear = new JComboBox<>(year);
                cbYear.setRenderer(renderer);
                cbYear.setBackground(Color.white);

                JPanel nhapLieu = new JPanel(null);
                nhapLieu.setBounds(2, 150, rightPanel.getWidth()-20, 75);
                Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                titledBorder.setTitleFont(italicBoldFont);
                nhapLieu.setBackground(new Color(119, 230, 163));
                nhapLieu.setBorder(titledBorder);

                int x = 250;
                lbmaHoiVien.setBounds(x, 30, 80, 30); x+=80;
                tfMaHoiVien.setBounds(x+10, 30, 100, 30); x+=110;
                lbMaCoSo.setBounds(x+50, 30, 80, 30); x+=130;
                cbMaCoSo.setBounds(x+10, 30, 100, 30); x+=110;
                lbHanTap.setBounds(x+50, 30, 60, 30); x+=110;
                cbYear.setBounds(x+10, 30, 70, 30); x+=80;
                cbMonth.setBounds(x+5, 30, 50, 30); x+=55;
                cbDay.setBounds(x+5, 30, 50, 30);
                nhapLieu.add(lbmaHoiVien);
                nhapLieu.add(tfMaHoiVien);
                nhapLieu.add(lbMaCoSo);
                nhapLieu.add(cbMaCoSo);
                nhapLieu.add(lbHanTap);
                nhapLieu.add(cbYear);
                nhapLieu.add(cbMonth);
                nhapLieu.add(cbDay);
                rightPanel.add(nhapLieu);

                JTable bang = new JTable();
                DefaultTableModel model = new DefaultTableModel();
                bang.setModel(model);
                model.addColumn("Mã hội viên");
                model.addColumn("Mã cơ sở");
                model.addColumn("Hạn tập");
                for(int i=0;i<ds.size();i++)
                model.addRow(new Object[]{
                    ds.get(i).getMaHoiVien(), ds.get(i).getMaCoSo(), ds.get(i).getHanTap()
                });
                bang.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < bang.getColumnCount(); i++) {
                    bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                }
                bang.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e)
                    {
                        int i = bang.getSelectedRow();
                        if(i>=0)
                        {
                            tfMaHoiVien.setText(model.getValueAt(i, 0).toString());
                            cbMaCoSo.setSelectedItem(model.getValueAt(i, 1).toString());
                            LocalDate date = LocalDate.parse(model.getValueAt(i, 2).toString());
                            cbDay.setSelectedItem(Integer.toString(date.getDayOfMonth()));
                            cbMonth.setSelectedItem(Integer.toString(date.getMonthValue()));
                            cbYear.setSelectedItem(Integer.toString(date.getYear()));
                        }
                    }
                });
                bang.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < bang.getColumnCount(); i++) {
                    bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                }
                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        String maHoiVien = tfMaHoiVien.getText();
                        String maCoSo = cbMaCoSo.getSelectedItem().toString();
                        String dd = cbDay.getSelectedItem().toString();
                        String mm = cbMonth.getSelectedItem().toString();
                        String yyyy= cbYear.getSelectedItem().toString();
                        if(maHoiVien.equals("")||maCoSo.equals("Chọn cơ sở")||dd.equals("DD")||mm.equals("MM")||yyyy.equals("YYYY"))
                        JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                        else 
                        {
                            String sHanTap = yyyy+"-"+mm+"-"+dd;
                            Date hanTap = Date.valueOf(sHanTap);
                            String s = bllQuanLyDanhSach.themHoiVienCoSo(maHoiVien, maCoSo, hanTap);
                            if(s.equals("Thành công"))
                            model.addRow(new Object[]{maHoiVien,maCoSo,hanTap});
                            JOptionPane.showMessageDialog(rightPanel, s);
                        }
                    }
                });
                xoa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        String maHoiVien = tfMaHoiVien.getText();
                        String maCoSo = cbMaCoSo.getSelectedItem().toString();
                        if(maHoiVien.equals("")||maCoSo.equals("Chọn cơ sở")) JOptionPane.showMessageDialog(rightPanel, "Nhập mã hội viên và mã cơ sở");
                        else
                        {
                            String s = bllQuanLyDanhSach.xoaHoiVienCoSo(maHoiVien, maCoSo);
                            if(s.equals("Thành công"))
                            {
                                for(int i=0;i<model.getRowCount();i++)  
                                if(model.getValueAt(i, 0).equals(maHoiVien) && model.getValueAt(i, 1).equals(maCoSo))
                                {
                                    model.removeRow(i);
                                    break;
                                } 
                            }
                            JOptionPane.showMessageDialog(rightPanel, s);
                        }
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        String maHoiVien = tfMaHoiVien.getText();
                        String maCoSo = cbMaCoSo.getSelectedItem().toString();
                        String dd = cbDay.getSelectedItem().toString();
                        String mm = cbMonth.getSelectedItem().toString();
                        String yyyy= cbYear.getSelectedItem().toString();
                        if(maHoiVien.equals("")||maCoSo.equals("Chọn cơ sở")||dd.equals("DD")||mm.equals("MM")||yyyy.equals("YYYY"))
                        JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                        else 
                        {
                            String sHanTap = yyyy+"-"+mm+"-"+dd;
                            Date hanTap = Date.valueOf(sHanTap);
                            String s = bllQuanLyDanhSach.suaHoiVienCoSo(maHoiVien, maCoSo, hanTap);
                            if(s.equals("Thành công"))
                            {
                                for(int i=0;i<model.getRowCount();i++)  
                                if(model.getValueAt(i, 0).equals(maHoiVien) && model.getValueAt(i, 1).equals(maCoSo))
                                {
                                    model.setValueAt(hanTap, i, 2);
                                    break;
                                } 
                            }
                            JOptionPane.showMessageDialog(rightPanel, s);
                        }
                    }
                });
                timKiem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        String maHoiVien = tfMaHoiVien.getText();
                        String maCoSo = cbMaCoSo.getSelectedItem().toString();
                        model.setRowCount(0);
                        if(maHoiVien.equals("")&&maCoSo.equals("Chọn cơ sở")) 
                        {
                            for(int i=0;i<ds.size();i++)
                            model.addRow(new Object[]{ds.get(i).getMaHoiVien(),ds.get(i).getMaCoSo(),ds.get(i).getHanTap()});
                        }
                        else
                        {
                            ArrayList<HoiVienCoSo> dsHoiVienCoSo = new ArrayList<>();
                            dsHoiVienCoSo = bllQuanLyDanhSach.timKiemHoiVienCoSo(maHoiVien, maCoSo);
                            for(int i=0;i<dsHoiVienCoSo.size();i++)
                            model.addRow(new Object[]{dsHoiVienCoSo.get(i).getMaHoiVien(),dsHoiVienCoSo.get(i).getMaCoSo(),dsHoiVienCoSo.get(i).getHanTap()});
                        }
                    }
                });
                
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(bang);
                scrollPane.setBounds(5, 230, rightPanel.getWidth()-20, rightPanel.getHeight()-270);
                rightPanel.add(scrollPane);
            }
            
            public void QuanLyBangThietBiCoSo(ArrayList<ThietBiCoSo> ds)
            {
                xoaHienThi(rightPanel);
                Font f = new Font("Times New Roman",Font.BOLD,17);
            	JButton them = new JButton();
                ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-tb.png");
                Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                them.setPreferredSize(new Dimension (130,35));
                them.setIcon(new ImageIcon(scaleThemBtnImg));
                them.setHorizontalAlignment(SwingConstants.CENTER);
                them.setBorder(null);

            	JButton xoa  = new JButton();
                xoa.setPreferredSize(new Dimension (110,35));
                ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-tb.png");
                Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                xoa.setPreferredSize(new Dimension (130,35));
                xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
                xoa.setHorizontalAlignment(SwingConstants.CENTER);
                xoa.setBorder(null);

            	JButton sua = new JButton();
                sua.setPreferredSize(new Dimension (110,35));
                ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-tb.png");
                Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                sua.setPreferredSize(new Dimension (130,35));
                sua.setIcon(new ImageIcon(scaleSuaBtnImg));
                sua.setHorizontalAlignment(SwingConstants.CENTER);
                sua.setBorder(null);

            	JButton timKiem = new JButton();
                timKiem.setPreferredSize(new Dimension (110,35));
                timKiem.setPreferredSize(new Dimension (110,35));
                ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-tb.png");
                Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                timKiem.setPreferredSize(new Dimension (130,35));
                timKiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
                timKiem.setHorizontalAlignment(SwingConstants.CENTER);
                timKiem.setBorder(null);

                JPanel chucNang = new JPanel(new FlowLayout());
                chucNang.add(them);
                chucNang.add(xoa);
                chucNang.add(sua);
                chucNang.add(timKiem);
                chucNang.setBounds(5,100,rightPanel.getWidth()-5,38);
                chucNang.setBackground(Color.WHITE);
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

                int x = 5;
                JPanel nhapLieu = new JPanel(null);
                Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                titledBorder.setTitleFont(italicBoldFont);
                nhapLieu.setBounds(2, 150, rightPanel.getWidth()-19, 100);
                nhapLieu.setBackground(new Color(119, 230, 163));
                nhapLieu.setBorder(titledBorder);

                maThietBiCoSo.setBounds(x, 50, 120, 30); x+=120;
                textMaThietBiCoSo.setBounds(x+10, 50, 100, 30); x+=110;
                maThietBi.setBounds(x+50, 50, 70, 30); x+=120;
                textMaThietBi.setBounds(x+10, 50, 100, 30); x+=110;
                maCoSo.setBounds(x+50, 50, 70, 30); x+=120;
                textMaCoSo.setBounds(x+10, 50, 100, 30); x+=110;
                ngayNhap.setBounds(x+50, 50, 70, 30); x+=120;
                textNgayNhap.setBounds(x+10,50,100,30); x+=110;
                hanBaoHanh.setBounds(x+50,50,90,30); x+=140;
                textHanBaoHanh.setBounds(x+10, 50, 100, 30);

                nhapLieu.add(maThietBiCoSo);
                nhapLieu.add(textMaThietBiCoSo);
                nhapLieu.add(maThietBi);
                nhapLieu.add(textMaThietBi);
                nhapLieu.add(maCoSo);
                nhapLieu.add(textMaCoSo);
                nhapLieu.add(hanBaoHanh);
                nhapLieu.add(textHanBaoHanh);
                nhapLieu.add(ngayNhap);
                nhapLieu.add(textNgayNhap);

                rightPanel.add(nhapLieu);

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

                bang.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < bang.getColumnCount(); i++) {
                    bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                }
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
                scrollPane.setBounds(5, 260, rightPanel.getWidth()-20, rightPanel.getHeight()-300);
                rightPanel.add(scrollPane);
            }
            public void QuanLyBangDichVu(ArrayList<dichVu> ds) {
            	xoaHienThi(rightPanel);
            	
            	Font f = new Font("Times New Roman",Font.BOLD,17);
            	JButton them = new JButton();
                ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/dv-them.png");
                Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                them.setPreferredSize(new Dimension (130,35));
                them.setIcon(new ImageIcon(scaleThemBtnImg));
                them.setHorizontalAlignment(SwingConstants.CENTER);
                them.setBorder(null);

            	JButton xoa  = new JButton();
                xoa.setPreferredSize(new Dimension (110,35));
                ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/dv-xoa.png");
                Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                xoa.setPreferredSize(new Dimension (130,35));
                xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
                xoa.setHorizontalAlignment(SwingConstants.CENTER);
                xoa.setBorder(null);

            	JButton sua = new JButton();
                sua.setPreferredSize(new Dimension (110,35));
                ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/dv-sua.png");
                Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                sua.setPreferredSize(new Dimension (130,35));
                sua.setIcon(new ImageIcon(scaleSuaBtnImg));
                sua.setHorizontalAlignment(SwingConstants.CENTER);
                sua.setBorder(null);

            	JButton timkiem = new JButton();
                timkiem.setPreferredSize(new Dimension (110,35));
                timkiem.setPreferredSize(new Dimension (110,35));
                ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/dv-tim.png");
                Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                timkiem.setPreferredSize(new Dimension (130,35));
                timkiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
                timkiem.setHorizontalAlignment(SwingConstants.CENTER);
                timkiem.setBorder(null);

            	JPanel chucnang = new JPanel(new FlowLayout());
            	chucnang.add(them);
            	chucnang.add(xoa);
            	chucnang.add(sua);
            	chucnang.add(timkiem);
            	chucnang.setBounds(5,100,rightPanel.getWidth()-5,38);
                chucnang.setBackground(Color.WHITE);
                rightPanel.add(chucnang);
                
                JLabel jlb_madv = new JLabel("Mã dịch vụ: ");
                JTextField jtf_madv = new JTextField();
                jlb_madv.setFont(f);
                
                JLabel jlb_tendv = new JLabel("Tên dịch vụ: ");
                JTextField jtf_tendv = new JTextField();
                jlb_tendv.setFont(f);
                
                JLabel jlb_giadv = new JLabel("Giá dịch vụ: ");
                JTextField jtf_giadv = new JTextField();
                jlb_giadv.setFont(f);
                
                JLabel jlb_thoigian = new JLabel("Thời gian dịch vụ: ");
                JTextField jtf_thoigian = new JTextField();
                jlb_thoigian.setFont(f);
                
                JLabel jlb_mota = new JLabel("Mô tả dịch vụ: ");
                JTextField jtf_mota = new JTextField();
                jlb_mota.setFont(f);
                
                JLabel jlb_img = new JLabel("Nguồn hình ảnh: ");
                JTextField jtf_img = new JTextField();
                jlb_img.setFont(f);
                
                JPanel nhapLieu = new JPanel(null);
                nhapLieu.setBounds(2, 175, rightPanel.getWidth()-20, 175);
                Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                titledBorder.setTitleFont(italicBoldFont);
                nhapLieu.setBorder(titledBorder);
                nhapLieu.setBackground(new Color(119, 230, 163));

                jlb_madv.setBounds(10, 40, 120, 30);
                jtf_madv.setBounds(150, 40, 150, 30);
                jlb_tendv.setBounds(410,40,120,30);
                jtf_tendv.setBounds(550,40,150,30);
                jlb_giadv.setBounds(810,40,120,30);
                jtf_giadv.setBounds(950,40,150,30);
                
                jlb_thoigian.setBounds(10, 120, 150, 30);
                jtf_thoigian.setBounds(150, 120, 150, 30);
                jlb_mota.setBounds(410,120,150,30);
                jtf_mota.setBounds(550,120,150,30);
                jlb_img.setBounds(810,120,150,30);
                jtf_img.setBounds(950,120,150,30);
                
                nhapLieu.add(jlb_madv);
                nhapLieu.add(jtf_madv);
                nhapLieu.add(jlb_tendv);
                nhapLieu.add(jtf_tendv);
                nhapLieu.add(jlb_giadv);
                nhapLieu.add(jtf_giadv);
                nhapLieu.add(jlb_thoigian);
                nhapLieu.add(jtf_thoigian);
                nhapLieu.add(jlb_mota);
                nhapLieu.add(jtf_mota);
                nhapLieu.add(jlb_img);
                nhapLieu.add(jtf_img);
                rightPanel.add(nhapLieu);
                
                DefaultTableModel model = new DefaultTableModel();
                JTable bang = new JTable();
                model.addColumn("Mã dịch vụ");
                model.addColumn("Tên dịch vụ");
                model.addColumn("Giá dịch vụ");
                model.addColumn("Thời gian dịch vụ");
                model.addColumn("Mô tả dịch vụ");
                model.addColumn("Hình ảnh");
                model.setRowCount(0);
                for(int i = 0; i < ds.size();i++) {
                	model.addRow(new Object[] {
                			ds.get(i).getMaDichVu().trim(),
                			ds.get(i).getTenDichVu().trim(),
                			ds.get(i).getGiaDichVu(),
                			ds.get(i).getThoiGian(),
                			ds.get(i).getMoTa().trim(),
                			ds.get(i).getHinhAnh().trim() 
                	});
                }
                bang.setModel(model);
                bang.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < bang.getColumnCount(); i++) {
                    bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                }
                bang.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						int i = bang.getSelectedRow();
						if(i >= 0) {
							jtf_madv.setText(model.getValueAt(i, 0).toString());
							jtf_tendv.setText(model.getValueAt(i, 1).toString());
							jtf_giadv.setText(model.getValueAt(i, 2).toString());
							jtf_thoigian.setText(model.getValueAt(i, 3).toString());
							jtf_mota.setText(model.getValueAt(i, 4).toString());
							jtf_img.setText(model.getValueAt(i, 5).toString());
						}
					}
				});
                them.addActionListener(new ActionListener() {
					
					// @Override
					// public void actionPerformed(ActionEvent e) {
					// 	if(jtf_madv.getText().trim().equals("") || jtf_tendv.getText().trim().equals("") || jtf_giadv.getText().trim().equals("") ||
					// 		jtf_thoigian.getText().trim().equals("") || jtf_mota.getText().trim().equals("") || jtf_img.getText().trim().equals("")) {
					// 		JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống","Error",JOptionPane.ERROR_MESSAGE);
					// 		return;
					// 	}
					// 	else {
					// 		BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
					// 		String madv = jtf_madv.getText().trim();
					// 		String tendv = jtf_tendv.getText().trim();
					// 		long giadv = Long.parseLong(jtf_giadv.getText().trim());
					// 		int thoigian = Integer.parseInt(jtf_thoigian.getText().trim());
					// 		String mota = jtf_mota.getText().trim();
					// 		String hinhanh = jtf_img.getText().trim();
					// 		dichVu dv = new dichVu(madv, tendv, giadv, thoigian, mota, hinhanh);
					// 		if(bllqlds.themDV(dv) == true) {
					// 			model.addRow(new Object[] {madv, tendv, giadv, thoigian, mota, hinhanh});
					// 			JOptionPane.showMessageDialog(rightPanel, "Thêm dịch vụ thành công","Success",JOptionPane.INFORMATION_MESSAGE);
								
					// 		}
							
					// 		jtf_madv.setText("");jtf_tendv.setText("");jtf_giadv.setText("");
					// 		jtf_thoigian.setText("");jtf_mota.setText("");jtf_img.setText("");
					// 	}
						
					// }
                    @Override
					public void actionPerformed(ActionEvent e) {
						if(jtf_tendv.getText().trim().equals("") || jtf_giadv.getText().trim().equals("") ||
							jtf_thoigian.getText().trim().equals("") || jtf_mota.getText().trim().equals("") || jtf_img.getText().trim().equals("")) {
							JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						else {
							BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
							String madv = bllqlds.layMaDichVuchuaTonTai();
							String tendv = jtf_tendv.getText().trim();
							long giadv = Long.parseLong(jtf_giadv.getText().trim());
							int thoigian = Integer.parseInt(jtf_thoigian.getText().trim());
							String mota = jtf_mota.getText().trim();
							String hinhanh = jtf_img.getText().trim();
							dichVu dv = new dichVu(madv, tendv, giadv, thoigian, mota, hinhanh);
							if(bllqlds.themDV(dv) == true) {
								model.addRow(new Object[] {madv, tendv, giadv, thoigian, mota, hinhanh});
								JOptionPane.showMessageDialog(rightPanel, "Thêm dịch vụ thành công","Success",JOptionPane.INFORMATION_MESSAGE);
								
							}
							
							jtf_madv.setText("");jtf_tendv.setText("");jtf_giadv.setText("");
							jtf_thoigian.setText("");jtf_mota.setText("");jtf_img.setText("");
						}
						
					}
				});
                xoa.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(jtf_madv.getText().equals("")) {
							JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã dịch vụ cần xóa","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						else {
							BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
							if(bllqlds.xoaDV(jtf_madv.getText())) {
								for(int i = 0;i < model.getRowCount(); i++) {
									if(model.getValueAt(i, 0).equals(jtf_madv.getText())) {
										model.removeRow(i);
										JOptionPane.showMessageDialog(rightPanel, "Xóa dịch vụ thành công","Success",JOptionPane.INFORMATION_MESSAGE);
										return;
									}
								}
							}
							else {
								JOptionPane.showMessageDialog(rightPanel, "Mã dịch vụ không tồn tại","Error",JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
				});
                sua.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(jtf_madv.getText().trim().equals("") || jtf_tendv.getText().trim().equals("") || jtf_giadv.getText().trim().equals("") ||
								jtf_thoigian.getText().trim().equals("") || jtf_mota.getText().trim().equals("") || jtf_img.getText().trim().equals("")) {
								JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống","Error",JOptionPane.ERROR_MESSAGE);
								return;
						}
						else {
							BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
							String madv = jtf_madv.getText().trim();
							String tendv = jtf_tendv.getText().trim();
							long giadv = Long.parseLong(jtf_giadv.getText().trim());
							int thoigian = Integer.parseInt(jtf_thoigian.getText().trim());
							String mota = jtf_mota.getText().trim();
							String hinhanh = jtf_img.getText().trim();
							dichVu dv = new dichVu(madv, tendv, giadv, thoigian, mota, hinhanh);
							if(bllqlds.suaDV(dv)==true) {
								JOptionPane.showMessageDialog(rightPanel, "Sửa dịch vụ thành công","Success",JOptionPane.INFORMATION_MESSAGE);
								for(int i = 0;i < model.getRowCount();i++) {
									if(model.getValueAt(i,0).equals(madv)) {
										model.setValueAt(tendv, i, 1);
										model.setValueAt(giadv, i, 2);
										model.setValueAt(thoigian, i, 3);
										model.setValueAt(mota, i, 4);
										model.setValueAt(hinhanh, i, 5);
										break;
									}
								}
							}
							else {
								JOptionPane.showMessageDialog(rightPanel, "Sửa dịch vụ thất bại","Error",JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
				});
                timkiem.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						String madv = jtf_madv.getText().trim();
						if(madv.isEmpty()) {
							for(int i = 0; i < ds.size();i++) {
								model.addRow(new Object[] {
									ds.get(i).getMaDichVu(),ds.get(i).getTenDichVu(),ds.get(i).getGiaDichVu(),
									ds.get(i).getThoiGian(),ds.get(i).getMoTa(),ds.get(i).getHinhAnh()
								});
							}
						}
						else {
							BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
							ArrayList<dichVu> ds = bllqlds.timKiemDV(madv);
							for(dichVu dv : ds) {
								model.addRow(new Object[] {
									dv.getMaDichVu(),dv.getTenDichVu(),dv.getGiaDichVu(),
									dv.getThoiGian(),dv.getMoTa(),dv.getHinhAnh()
								});
							}
						}
					}
				});
                renderer rd = new renderer();
                bang.getColumnModel().getColumn(5).setCellRenderer(rd);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(bang);
                bang.setRowHeight(100);
                scrollPane.setBounds(5, 350, rightPanel.getWidth()-5, rightPanel.getHeight()-390);
                rightPanel.add(scrollPane);
            }
          
            public void QuanLyBangNhanVien(ArrayList<NhanVien> ds) {
            	xoaHienThi(rightPanel);
            	
            	Font f = new Font("Times New Roman",Font.BOLD,17);
            	JButton them = new JButton();
                ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-hv.png");
                Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                them.setPreferredSize(new Dimension (130,35));
                them.setIcon(new ImageIcon(scaleThemBtnImg));
                them.setHorizontalAlignment(SwingConstants.CENTER);
                them.setBorder(null);

            	JButton xoa  = new JButton();
                xoa.setPreferredSize(new Dimension (110,35));
                ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-hv.png");
                Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                xoa.setPreferredSize(new Dimension (130,35));
                xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
                xoa.setHorizontalAlignment(SwingConstants.CENTER);
                xoa.setBorder(null);

            	JButton sua = new JButton();
                sua.setPreferredSize(new Dimension (110,35));
                ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-hv.png");
                Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                sua.setPreferredSize(new Dimension (130,35));
                sua.setIcon(new ImageIcon(scaleSuaBtnImg));
                sua.setHorizontalAlignment(SwingConstants.CENTER);
                sua.setBorder(null);

            	JButton timkiem = new JButton();
                timkiem.setPreferredSize(new Dimension (110,35));
                timkiem.setPreferredSize(new Dimension (110,35));
                ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-hv.png");
                Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
                timkiem.setPreferredSize(new Dimension (130,35));
                timkiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
                timkiem.setHorizontalAlignment(SwingConstants.CENTER);
                timkiem.setBorder(null);

            	JPanel chucnang = new JPanel(new FlowLayout());
            	chucnang.add(them);
            	chucnang.add(xoa);
            	chucnang.add(sua);
            	chucnang.add(timkiem);
            	chucnang.setBounds(5,100,rightPanel.getWidth()-5,40);
                chucnang.setBackground(Color.white);
                rightPanel.add(chucnang);
                
                JLabel jlb_manv = new JLabel("Mã nhân viên: ");
                jtf_manv = new JTextField();
                jlb_manv.setFont(f);
                
                JLabel jlb_hoten = new JLabel("Họ và tên: ");
                jtf_hoten = new JTextField();
                jlb_hoten.setFont(f);
                
                JLabel jlb_gioitinh = new JLabel("Giới tính: ");
                JRadioButton male = new JRadioButton("Nam");
                male.setBackground(new Color(119, 230, 163));
                JRadioButton female = new JRadioButton("Nữ");
                female.setBackground(new Color(119, 230, 163));
                jlb_gioitinh.setFont(f);
                male.setFont(f);
                female.setFont(f);
                btngr = new ButtonGroup();
                btngr.add(male);
                btngr.add(female);
                String gioitinh = "";
                if(male.isSelected()) {
					gioitinh = "Nam";
				}else if(female.isSelected()) {
					gioitinh = "Nữ";
				}
                
                JLabel jlb_date = new JLabel("Ngày sinh: ");
                jtf_date = new JTextField();
                jlb_date.setFont(f);
                
                
                JLabel jlb_sdt = new JLabel("Số điện thoại: ");
                jtf_sdt = new JTextField();
                jlb_sdt.setFont(f);
                
                JLabel jlb_cccd = new JLabel("Căn cước: ");
                jtf_cccd = new JTextField();
                jlb_cccd.setFont(f);
                
                JLabel jlb_macoso = new JLabel("Mã cơ sở: ");
                jtf_macoso = new JTextField();
                jlb_macoso.setFont(f);
                
                JLabel jlb_vaitro = new JLabel("Vai trò: ");
                jtf_vaitro = new JTextField();
                jlb_vaitro.setFont(f);
                
                JLabel jlb_luong = new JLabel("Lương: ");
                jtf_luong = new JTextField();
                jlb_luong.setFont(f);
                
                JPanel nhapLieu = new JPanel(null);
                nhapLieu.setBounds(2, 175, rightPanel.getWidth()-20, 175);
                Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
                titledBorder.setTitleFont(italicBoldFont);
                nhapLieu.setBorder(titledBorder);
                nhapLieu.setBackground(new Color(119, 230, 163));

                jlb_manv.setBounds(10, 50, 120, 30); 
                jtf_manv.setBounds(130, 50, 120, 30); 
                jlb_hoten.setBounds(280, 50, 120, 30); 
                jtf_hoten.setBounds(380, 50, 120, 30); 
                jlb_gioitinh.setBounds(530, 50, 90, 30);
                male.setBounds(630, 50, 70, 30); 
                female.setBounds(720, 50, 60, 30); 
                jlb_date.setBounds(790, 50, 90, 30); 
                jtf_date.setBounds(890,50,120,30); 
                
                jlb_sdt.setBounds(10,100,120,30); 
                jtf_sdt.setBounds(130, 100, 120, 30);
                jlb_cccd.setBounds(280,100,120,30);
                jtf_cccd.setBounds(380,100,120,30);
                jlb_macoso.setBounds(530,100,90,30);
                jtf_macoso.setBounds(630,100,120,30);
                jlb_vaitro.setBounds(790,100,90,30);
                jtf_vaitro.setBounds(890,100,120,30);
                
                jlb_luong.setBounds(10,140,90,30);
                jtf_luong.setBounds(130,140,120,30);
                
                nhapLieu.add(jlb_manv);
                nhapLieu.add(jtf_manv);
                nhapLieu.add(jlb_hoten);
                nhapLieu.add(jtf_hoten);
                nhapLieu.add(jlb_gioitinh);
                nhapLieu.add(male);
                nhapLieu.add(female);
                nhapLieu.add(jlb_date);
                nhapLieu.add(jtf_date);
                nhapLieu.add(jlb_sdt);
                nhapLieu.add(jtf_sdt);
                nhapLieu.add(jlb_cccd);
                nhapLieu.add(jtf_cccd);
                nhapLieu.add(jlb_macoso);
                nhapLieu.add(jtf_macoso);
                nhapLieu.add(jlb_vaitro);
                nhapLieu.add(jtf_vaitro);
                nhapLieu.add(jlb_luong);
                nhapLieu.add(jtf_luong);
                
                rightPanel.add(nhapLieu);
                
                DefaultTableModel model = new DefaultTableModel();
                JTable bang = new JTable();
                model.addColumn("Mã nhân viên");
                model.addColumn("Họ và tên");
                model.addColumn("Giới tính");
                model.addColumn("Ngày sinh");
                model.addColumn("Số điện thoại");
                model.addColumn("Số căn cước");
                model.addColumn("Mã cơ sở");
                model.addColumn("Vai trò");
                model.addColumn("Lương");
                
                model.setRowCount(0);
                for(int i = 0; i < ds.size();i++) {
                	model.addRow(new Object[] {
                		ds.get(i).getMaNhanVien(),ds.get(i).getHoten().trim(),ds.get(i).getGioitinh(),ds.get(i).getNgaysinh(),
                		ds.get(i).getSdt(),ds.get(i).getSocccd(),ds.get(i).getMacoso(),ds.get(i).getVaitro(),
                		ds.get(i).getLuong()
                	});
                }
                bang.setModel(model);
                bang.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < bang.getColumnCount(); i++) {
                    bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
                }
                bang.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int i = bang.getSelectedRow();
						if(i >= 0) {
							jtf_manv.setText(model.getValueAt(i, 0).toString().trim());
							jtf_hoten.setText(model.getValueAt(i, 1).toString().trim());
							String gioitinh = (model.getValueAt(i, 2).toString().trim());
							if(gioitinh.equals("Nam")) {
								male.setSelected(true);
							}else {
								female.setSelected(true);
							}
							jtf_date.setText(model.getValueAt(i, 3).toString().trim());
							jtf_sdt.setText(model.getValueAt(i, 4).toString().trim());
							jtf_cccd.setText(model.getValueAt(i, 5).toString().trim());
							jtf_macoso.setText(model.getValueAt(i, 6).toString().trim());
							jtf_vaitro.setText(model.getValueAt(i, 7).toString().trim());
							jtf_luong.setText(model.getValueAt(i, 8).toString().trim());
						}
					}
					
				});
                
                them.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    		String dateString = isValidDate(jtf_date.getText());
                            if (jtf_hoten.getText().trim().isEmpty() || btngr.getSelection() == null || jtf_date.getText().trim().isEmpty() || jtf_sdt.getText().trim().isEmpty() || jtf_cccd.getText().trim().isEmpty() || jtf_vaitro.getText().trim().isEmpty() || jtf_luong.getText().trim().isEmpty()) {
                                JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                               
                            } else if(!dateString.equals("Ngày sinh hợp lệ")) {
                            	JOptionPane.showMessageDialog(rightPanel, "Ngày sinh không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
                            	return;
                            }
                            else {
                            	try {
                            		// Xử lý thêm nhân viên vào cơ sở dữ liệu
                                    String[] parts = ((String) jtf_date.getText()).split("-");
                                    int year = Integer.parseInt(parts[0]);
                                    int month = Integer.parseInt(parts[1]);
                                    int day = Integer.parseInt(parts[2]);
                                    BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
                                    @SuppressWarnings("deprecation")
                                    Date date = new Date(year-1900,month,day-1);
                                    String ma = bllqlds.layMaNVchuaTonTai();
                                    String ten = jtf_hoten.getText().trim();
                                    String sdt = jtf_sdt.getText().trim();
                                    String cccd = jtf_cccd.getText().trim();
                                    String macoso = jtf_macoso.getText().trim();
                                    String gioitinh = male.isSelected() ? "Nam" : "Nữ";
                                    String vaitro = jtf_vaitro.getText().trim();
                                    int luong = Integer.parseInt(jtf_luong.getText());
                                    NhanVien nv = new NhanVien(ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, luong);
                                    if (bllqlds.themNV(nv) == true) {
                                        model.addRow(new Object[]{ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, luong});
                                        JOptionPane.showMessageDialog(rightPanel, "Thêm nhân viên thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else {
                                    	JOptionPane.showMessageDialog(rightPanel, "Thêm nhân viên thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    jtf_manv.setText("");jtf_hoten.setText("");jtf_sdt.setText("");jtf_cccd.setText("");
                                    jtf_macoso.setText("");btngr.clearSelection();jtf_vaitro.setText("");jtf_luong.setText("");
                                    jtf_date.setText("");
								} catch (Exception e2) {
									System.out.println(e2);
								}
                            }
                        
                    }
                });
                xoa.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(jtf_manv.getText().equals("")) {
							JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã nhân viên cần xóa","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						else {
							BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
							if(bllqlds.xoaNV(jtf_manv.getText())) {
								for(int i = 0;i < model.getRowCount(); i++) {
									if(model.getValueAt(i, 0).equals(jtf_manv.getText())) {
										model.removeRow(i);
										JOptionPane.showMessageDialog(rightPanel, "Xóa nhân viên thành công","Success",JOptionPane.INFORMATION_MESSAGE);
										return;
									}
								}
							}
							else {
								JOptionPane.showMessageDialog(rightPanel, "Mã nhân viên không tồn tại","Error",JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
				});
                sua.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(jtf_manv.getText().trim().equals("") || jtf_macoso.getText().trim().equals("") || jtf_hoten.getText().trim().isEmpty() || btngr.getSelection() == null || jtf_date.getText().trim().isEmpty() || jtf_sdt.getText().trim().isEmpty() || jtf_cccd.getText().trim().isEmpty() || jtf_vaitro.getText().trim().isEmpty() || jtf_luong.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						else {
							BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
                            String ngaysinh;
                            try{
                                ngaysinh = isValidDate(jtf_date.getText());
                                String[] parts = ((String) jtf_date.getText()).split("-");
                                int year = Integer.parseInt(parts[0]);
                                int month = Integer.parseInt(parts[1]);
                                int day = Integer.parseInt(parts[2]);
                                @SuppressWarnings("deprecation")
                                Date date = new Date(year - 1900, month, day - 1);
                                String ma = jtf_manv.getText().trim();
                                String ten = jtf_hoten.getText().trim();
                                String sdt = jtf_sdt.getText().trim();
                                String cccd = jtf_cccd.getText().trim();
                                String macoso = jtf_macoso.getText().trim();
                                String gioitinh = male.isSelected() ? "Nam" : "Nữ";
                                String vaitro = jtf_vaitro.getText().trim();
                                int luong = Integer.parseInt((String)jtf_luong.getText());
                                NhanVien nv = new NhanVien(ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, luong);
                                if(bllqlds.suaThongTinNV(nv)== true) {
                                    JOptionPane.showMessageDialog(rightPanel, "Sửa thông tin nhân viên thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    for(int i = 0;i < model.getRowCount();i++) {
                                        if(model.getValueAt(i, 0).equals(ma)) {
                                            model.setValueAt(ten, i, 1);
                                            model.setValueAt(gioitinh, i, 2);
                                            model.setValueAt(date, i, 3);
                                            model.setValueAt(sdt, i, 4);
                                            model.setValueAt(cccd, i, 5);
                                            model.setValueAt(macoso, i, 6);
                                            model.setValueAt(vaitro, i, 7);
                                            model.setValueAt(luong, i, 8);
                                            break;
                                        }
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(rightPanel, "Sửa thông tin nhân viên thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            catch(Exception ex){
                                JOptionPane.showMessageDialog(chonDanhSachLabel, ex.getMessage(),"Lỗi",JOptionPane.ERROR_MESSAGE);
                            }
                            
						}
					}
				});
                timkiem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
                        
                        String manv = jtf_manv.getText().trim(); // Lấy mã nhân viên cần tìm kiếm từ TextField
                        
                        // Kiểm tra xem mã nhân viên có rỗng không
                        if (manv.isEmpty()) {
                            // Nếu mã nhân viên rỗng, hiển thị tất cả các nhân viên trong danh sách
                            for (int i = 0; i < ds.size(); i++) {
                                model.addRow(new Object[] {
                                    ds.get(i).getMaNhanVien(), ds.get(i).getHoten(), ds.get(i).getGioitinh(),
                                    ds.get(i).getNgaysinh(), ds.get(i).getSdt(), ds.get(i).getSocccd(),
                                    ds.get(i).getMacoso(), ds.get(i).getVaitro(), ds.get(i).getLuong()
                                });
                            }
                        } else {
                            // Nếu mã nhân viên không rỗng, thực hiện tìm kiếm
                            BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
                            ArrayList<NhanVien> dsNhanVien = bllqlds.timKiemNV(manv);
                            
                            // Hiển thị kết quả tìm kiếm trên bảng
                            for (NhanVien nv : dsNhanVien) {
                                model.addRow(new Object[] {
                                    nv.getMaNhanVien(), nv.getHoten(), nv.getGioitinh(), nv.getNgaysinh(),
                                    nv.getSdt(), nv.getSocccd(), nv.getMacoso(), nv.getVaitro(), nv.getLuong()
                                });
                            }
                        }
                    }
                });

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(bang);
                scrollPane.setBounds(5, 350, rightPanel.getWidth()-20, rightPanel.getHeight()-390);
                rightPanel.add(scrollPane);
            }
            
            public String isValidDate(String inputdate) {
            	try {
                    String dateString = inputdate;
                    String[] parts = dateString.split("-");
                    int year = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int day = Integer.parseInt(parts[2]);
                    // @SuppressWarnings("deprecation")
                    // Date date = new Date(year - 1900, month - 1, day); // Tạo đối tượng Date từ năm, tháng và ngày
					boolean isLeapYear = Year.of(year).isLeap();
					int maxDayinMonth = 0;
						switch (month) {
						case 2:
							maxDayinMonth = isLeapYear ? 29 : 28;
							break;
						case 4,6,9,11:
							maxDayinMonth = 30;
							break;
						default:
							maxDayinMonth = 31;
						}
					
					if(day >= 1 && day <= maxDayinMonth) {
						return "Ngày sinh hợp lệ";
					}
					else {
						return "Ngày sinh không hợp lệ";
					}
				} catch (Exception e) {
					return "Ngày sinh không hợp lệ";
				}
            	
            }
        });
        
        rightPanel.add(rightTitle);
        rightPanel.add(chonDanhSachLabel);
        rightPanel.add(danhSachBox);
    }
    // public void thongKeDoanhThu(DSCoSo CoSods)
    // {
    //     rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
    //     rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
    //     rightPanel.repaint(); // Vẽ lại JPanel
    //     rightPanel.setLayout(null);

    //     JPanel canGiua = new JPanel(new FlowLayout());
    //     canGiua.setBounds(5,5,rightPanel.getWidth(),55);
    //     canGiua.setBackground(Color.yellow);
    //     JLabel titleNhapThietBi = new JLabel("Thống kê kinh doanh");
    //     titleNhapThietBi.setFont(new Font("Times New Roman",1,40));

    //     canGiua.add(titleNhapThietBi);
    //     rightPanel.add(canGiua);

    //     JPanel filter = new JPanel(null);
    //     filter.setBounds(5,70,rightPanel.getWidth(),55);
    //     JLabel timTheoTen = new JLabel("Tìm kiếm bằng tên");
    //     timTheoTen.setBounds(10, 15, 130, 30);
    //     JTextField nhapTen = new JTextField();
    //     nhapTen.setBounds(145, 15, 175, 30);
    //     JButton timkiem = new JButton(">");
    //     timkiem.setBounds(320, 15, 45, 29);
    //     timkiem.addActionListener(new ActionListener() {
    //         public void actionPerformed(ActionEvent e)
    //         {
    //             String tenCoSo = nhapTen.getText();
    //             BLLThongKeDT bllThongKeDT = new BLLThongKeDT();
    //             thongKeDoanhThu(bllThongKeDT.timKiemCoSo(tenCoSo));
    //         }
    //     });
    //     filter.add(timTheoTen);
    //     filter.add(nhapTen);
    //     filter.add(timkiem);
    //     rightPanel.add(filter);

    //     int chieuDocPanel = CoSods.dsCoSo.size()*100;
    //     int chieuNgangPanel = rightPanel.getWidth() - 250;
    //     int max = 0;
    //     for(int i=0;i<CoSods.dsCoSo.size();i++)
    //     {
    //         if(CoSods.dsCoSo.get(i).getDoanhThu() > max) max = CoSods.dsCoSo.get(i).getDoanhThu();
    //     }
    //     double tiLe;
    //     if(max != 0) tiLe = (double)chieuNgangPanel / max;
    //     else tiLe = 0;
    //     int y = 0;
    //     JPanel thongKe = new JPanel(null);
    //     thongKe.setPreferredSize(new Dimension(rightPanel.getWidth() - 10, chieuDocPanel));
    //     for(CoSo a : CoSods.dsCoSo)
    //     {
    //         JPanel JPanelThongke1CoSo = new JPanel(null);
    //         JPanelThongke1CoSo.setBounds(0, y, rightPanel.getWidth(), 50);
    //         JLabel labelTenCoSo = new JLabel(a.getTenCoSo());
    //         labelTenCoSo.setBounds(0,0,100,50);
    //         JLabel doanhThuCot = new JLabel();
    //         doanhThuCot.setBounds(100,0,(int)(tiLe*a.getDoanhThu()),50);
    //         doanhThuCot.setBackground(Color.BLUE);
    //         doanhThuCot.setOpaque(true); // Thêm dòng này để cho phép vẽ nền màu
    //         JLabel doanhThu = new JLabel(String.valueOf(a.getDoanhThu())+" đ");
    //         doanhThu.setBounds(doanhThuCot.getWidth()+labelTenCoSo.getWidth()+10, 0, 100, 50);
    //         JPanelThongke1CoSo.add(labelTenCoSo);
    //         JPanelThongke1CoSo.add(doanhThuCot);
    //         JPanelThongke1CoSo.add(doanhThu);
    //         thongKe.add(JPanelThongke1CoSo);
    //         y=y+100;
    //     }   
    //     JScrollPane cuon = new JScrollPane(thongKe);
    //     cuon.setBounds(2,150,rightPanel.getWidth() - 10,700);
    //     cuon.setPreferredSize(new Dimension(rightPanel.getWidth() - 10,700));
    //     rightPanel.add(cuon);
    // }
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
        JLabel timTheoTen = new JLabel("Tên sản phẩm:");
        timTheoTen.setBounds(10, 15, 100, 30);
        JTextField tenSanPham = new JTextField();
        tenSanPham.setBounds(105, 15, 125, 30);

        JLabel labelDSCoSo = new JLabel("Chọn cơ sở:");
        labelDSCoSo.setBounds(250, 15, 75, 30);
        @SuppressWarnings("rawtypes")
        JComboBox comboBoxTenCoSo = new JComboBox<>(dsTenCoSo);
        comboBoxTenCoSo.setBounds(330, 15, 120, 30);
        comboBoxTenCoSo.setBackground(Color.white);
        JLabel labelLoai = new JLabel("Loại:");
        labelLoai.setBounds(480, 15, 60, 30);
        String[] loai = {"Theo doanh thu","Theo số lượng"};
        @SuppressWarnings("rawtypes")
        JComboBox comboBoxLoai = new JComboBox<>(loai);
        comboBoxLoai.setBounds(535, 15, 150, 30);
        comboBoxLoai.setBackground(Color.white);

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
        dayStart.setBackground(Color.white);
        @SuppressWarnings("rawtypes")
        JComboBox monthStart = new JComboBox<>(month);
        monthStart.setBackground(Color.white);
        @SuppressWarnings("rawtypes")
        JComboBox yearStart = new JComboBox<>(year);
        yearStart.setBackground(Color.white);
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
        dayEnd.setBackground(Color.white);
        @SuppressWarnings("rawtypes")
        JComboBox monthEnd = new JComboBox<>(month);
        monthEnd.setBackground(Color.white);
        @SuppressWarnings("rawtypes")
        JComboBox yearEnd = new JComboBox<>(year);
        yearEnd.setBackground(Color.white);
        
        dayEnd.setBounds(865, 15, 45, 30);
        monthEnd.setBounds(910, 15, 45, 30);
        yearEnd.setBounds(955, 15, 45, 30);
        filter.add(dayEnd);
        filter.add(monthEnd);
        filter.add(yearEnd);

        JButton timkiem = new JButton("Tìm kiếm");
        timkiem.setBackground(Color.white);
        timkiem.setBounds(1050, 15, 100, 29);
        filter.add(timTheoTen);
        filter.add(tenSanPham);
        filter.add(timkiem);
        filter.add(labelDSCoSo);
        filter.add(comboBoxTenCoSo);
        filter.add(labelLoai);
        filter.add(comboBoxLoai);
        filter.setBackground(new Color(119, 230, 163));
        rightPanel.add(filter);

        int chieuNgang = rightPanel.getWidth() - 550;
        int chieuDoc = ds.size() * 75;
        JPanel thongKe = new JPanel(null);
        thongKe.setBackground(Color.WHITE);
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
                thongKe1MonHang.setBackground(Color.WHITE);
                thongKe1MonHang.setBounds(20, y, 1000, 75);
                JLabel tenHang = new JLabel(ds.get(i).getTenHangHoa());
                tenHang.setBounds(0, 0, 250, 30);
                tenHang.setFont(new Font("Times New Roman",1,13));
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
                thongKe1MonHang.setBackground(Color.WHITE);
                thongKe1MonHang.setBounds(20, y, 1000, 75);
                JLabel tenHang = new JLabel(ds.get(i).getTenHangHoa());
                tenHang.setBounds(0, 0, 250, 30);
                tenHang.setFont(new Font("Times New Roman",1,13));
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