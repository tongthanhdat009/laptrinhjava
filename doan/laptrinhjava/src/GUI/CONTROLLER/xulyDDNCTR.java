package GUI.CONTROLLER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import BLL.BLLChiTietDonNhap;
import BLL.BLLDonNhap;
import BLL.BLLQuanLyDanhSach;
import DTO.DonNhap;
import DTO.chiTietPhieuNhap;

public class xulyDDNCTR {
    // Font
    Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30);

    public void XuLyDuyetDonNhap(ArrayList<DonNhap> ds, BLLDonNhap DonNhap, BLLQuanLyDanhSach qlDanhSach, JPanel rightPanel, String coSoHienTai) {
        rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        rightPanel.repaint(); // Vẽ lại JPanel
        rightPanel.setLayout(null); // Tắt layout manager để sử dụng setBounds

        // Panel tiêu đề
        JPanel canGiua = new JPanel(null);
        canGiua.setBounds(5, 5, rightPanel.getWidth(), 55); 
        canGiua.setBackground(new Color(241, 255, 250));
        JLabel titleNhapThietBi = new JLabel("Duyệt Đơn Nhập");
        titleNhapThietBi.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titleNhapThietBi.setBounds(10, 10, 400, 40); // Set vị trí và kích thước của JLabel trong JPanel
        canGiua.add(titleNhapThietBi);
        rightPanel.add(canGiua);

        // Panel nhập liệu
        JPanel nhapLieu = new JPanel(null);
        nhapLieu.setBounds(2, 60, rightPanel.getWidth() - 20, 80);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder, "Nhập liệu");
        titledBorder.setTitleFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        nhapLieu.setBorder(titledBorder);
        nhapLieu.setBackground(new Color(119, 230, 163));

        // Các thành phần trong panel nhập liệu
        JLabel lbMaHV = new JLabel("Tên nhân viên: ");
        JLabel lbMaCoSo = new JLabel("Tên cơ sở: " + coSoHienTai);
        JTextField tfMaHV = new JTextField();
        JTextField tfMaHoaDon = new JTextField();
        JLabel lbTrangThai = new JLabel("Trạng thái: ");
        String[] trangThaiOptions = {"Tất cả", "Đã duyệt", "Chưa duyệt"};
        JComboBox<String> cbTrangThai = new JComboBox<>(trangThaiOptions);

        // Vị trí các thành phần
        int x = 50;
        lbMaHV.setBounds(x + 50, 25, 180, 30);
        lbMaHV.setFont(new Font("Times New Roman", Font.BOLD, 18));
        tfMaHV.setBounds(x + 180, 25, 100, 30);
        x += 250;

        lbTrangThai.setBounds(x + 75, 25, 110, 30);
        lbTrangThai.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cbTrangThai.setBounds(x + 180, 25, 100, 30);
        x += 250;

        lbMaCoSo.setBounds(x + 100, 25, 220, 30);
        lbMaCoSo.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JButton timKiem = new JButton("Tìm kiếm");
        timKiem.setBackground(Color.WHITE);
        timKiem.setBounds(rightPanel.getWidth() - 200, 25, 100, 30);
        timKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tenNhanVien = tfMaHV.getText().trim();
                String trangThai = (String) cbTrangThai.getSelectedItem();
                ArrayList<DonNhap> dsSearch;

                if (trangThai.equals("Tất cả")) {
                    dsSearch = DonNhap.searchTheoTen(coSoHienTai, tenNhanVien);
                } 
                else {
                    dsSearch = DonNhap.searchTheoTenVaTrangThai(coSoHienTai, tenNhanVien, trangThai);
                }
                hienThiDonNhap(dsSearch, rightPanel, qlDanhSach, DonNhap,coSoHienTai);
            }
        });

        // Thêm các thành phần vào panel nhập liệu
        nhapLieu.add(tfMaHoaDon);
        nhapLieu.add(lbMaCoSo);
        nhapLieu.add(lbMaHV);
        nhapLieu.add(tfMaHV);
        nhapLieu.add(lbTrangThai);
        nhapLieu.add(cbTrangThai);
        nhapLieu.add(timKiem);
        rightPanel.add(nhapLieu);

        JLabel lb2MaDonNhap = new JLabel("Đơn Nhập");
        JLabel lb2MaNV = new JLabel("Nhân viên");
        JLabel lb2MaCoSo = new JLabel("Cơ sở");
        JLabel lb2Ngay = new JLabel("Ngày");
        JLabel lb2TinhNang = new JLabel("Các tính năng");
        JLabel lb2TongTien = new JLabel("Tổng tiền"); // Thêm cột Tổng tiền

        lb2MaDonNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2MaDonNhap.setBounds(10, 10, 150, 30); // Giảm kích thước
        lb2MaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2MaNV.setBounds(170, 10, 150, 30); // Giảm kích thước
        lb2MaCoSo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2MaCoSo.setBounds(330, 10, 150, 30); // Giảm kích thước
        lb2Ngay.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2Ngay.setBounds(490, 10, 150, 30); // Giảm kích thước
        lb2TongTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2TongTien.setBounds(650, 10, 150, 30); // Thêm mới
        lb2TinhNang.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2TinhNang.setBounds(810, 10, 150, 30); // Giảm kích thước và dời sang phải
        
        JPanel title = new JPanel(null);
        title.setBounds(5, 140, rightPanel.getWidth() - 20, 50);
        title.setBackground(new Color(46,106,216));
        title.add(lb2MaDonNhap);
        title.add(lb2MaNV);
        title.add(lb2MaCoSo);
        title.add(lb2Ngay);
        title.add(lb2TongTien); // Thêm vào panel
        title.add(lb2TinhNang);
        rightPanel.add(title);

        hienThiDonNhap(ds, rightPanel, qlDanhSach, DonNhap, coSoHienTai);
    }
    public void hienThiDonNhap(ArrayList<DonNhap> ds, JPanel rightPanel, BLLQuanLyDanhSach qlDanhSach, BLLDonNhap DonNhap,String maCoSo) {
        JScrollPane existingScrollPane = null;
        JPanel main;
    
        // Tìm JScrollPane hiện có trong rightPanel (nếu có)
        for (int i = 0; i < rightPanel.getComponentCount(); i++) {
            if (rightPanel.getComponent(i) instanceof JScrollPane) {
                existingScrollPane = (JScrollPane) rightPanel.getComponent(i);
                break;
            }
        }
    
        if (existingScrollPane == null) {
            // Nếu không có JScrollPane, tạo mới một JScrollPane và JPanel bên trong nó
            main = new JPanel(null); // Panel bên trong JScrollPane
            JScrollPane scrollPane = new JScrollPane(main);
            scrollPane.setBounds(5, 190, rightPanel.getWidth() - 20, rightPanel.getHeight() - 200); // Đặt kích thước cho JScrollPane
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            rightPanel.add(scrollPane);
    
            existingScrollPane = scrollPane;
        } else {
            // Lấy panel bên trong JScrollPane nếu nó đã tồn tại
            main = (JPanel) existingScrollPane.getViewport().getView();
        }
    
        // Xóa nội dung cũ của main
        main.removeAll();
        main.revalidate();
        main.repaint();
    
        int yPosition = 0; // Khởi tạo vị trí y ban đầu
        int rowHeight = 50; // Chiều cao của mỗi hàng (panel đơn nhập)
    
        for (int i = 0; i < ds.size(); i++) {
            // Tạo panel cho mỗi đơn nhập
            JPanel pnDonNhap = new JPanel(null);
            pnDonNhap.setBounds(0, yPosition, rightPanel.getWidth() - 80, rowHeight); // Set vị trí của panel
            yPosition += rowHeight + 5; // Cập nhật vị trí y cho dòng tiếp theo
            JButton btDuyet;
    
            // Kiểm tra trạng thái và thay đổi màu sắc, nút bấm
            if (ds.get(i).getTrangThai().trim().equals("Chưa duyệt")) {
            	pnDonNhap.setBackground(new Color(237, 27, 36));
                btDuyet = new JButton("Duyệt");
            } 
            else {
            	pnDonNhap.setBackground(new Color(35, 177, 77));
                btDuyet = new JButton("Đã Duyệt");
            }
    
            // Các thành phần trong mỗi đơn nhập
            JLabel lb2MaDonNhap = new JLabel(ds.get(i).getMaNhap());
            lb2MaDonNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lb2MaDonNhap.setBounds(10, 10, 150, 30);

            JLabel lb2MaNV = new JLabel(qlDanhSach.getTenNVbyId(ds.get(i).getMaNV()));
            lb2MaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lb2MaNV.setBounds(170, 10, 150, 30);

            JLabel lb2MaCoSo = new JLabel(qlDanhSach.getTenCoSobyId(ds.get(i).getMaNV()));
            lb2MaCoSo.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lb2MaCoSo.setBounds(330, 10, 150, 30);

            JLabel lb2Ngay = new JLabel("" + ds.get(i).getNgayNhap());
            lb2Ngay.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lb2Ngay.setBounds(490, 10, 120, 30);

            BLLChiTietDonNhap bllChiTietDonNhap=new BLLChiTietDonNhap();
            int tongTien=bllChiTietDonNhap.getTongTien(ds.get(i).getMaNhap());
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            String formattedTongTien = currencyFormatter.format(tongTien);

            // Thêm cột Tổng tiền với định dạng
            JLabel lb2TongTien = new JLabel(formattedTongTien);
            lb2TongTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lb2TongTien.setBounds(650, 10, 150, 30);
    
            JButton btXemChiTiet = new JButton("Chi tiết");
            btXemChiTiet.setBounds(810, 10, 150, 30);
            btXemChiTiet.setFont(new Font("Times New Roman", Font.BOLD, 20));
            btXemChiTiet.setBackground(Color.WHITE);

            JDialog dialog = new JDialog((Frame) null, null, true);
            dialog.setLayout(new BorderLayout());
            dialog.setPreferredSize(new Dimension(500, 400));
            
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Tắt thanh cuộn ngang
            
            dialog.getContentPane().add(scrollPane, BorderLayout.CENTER);
            
            // Tạo một JPanel để chứa các tiêu đề
            JPanel headerPanel = new JPanel();
            headerPanel.setLayout(new GridLayout(1, 4));

            // Thêm các tiêu đề
            JLabel lblTenSanPham = new JLabel("Tên sản phẩm");
            JLabel lblGiaNhap = new JLabel("Loại");
            JLabel lblSoLuong = new JLabel("VND/cái");
            JLabel lbChucNang = new JLabel("Số lượng");

            // Căn giữa nội dung của các tiêu đề
            lblTenSanPham.setHorizontalAlignment(SwingConstants.CENTER);
            lblGiaNhap.setHorizontalAlignment(SwingConstants.CENTER);
            lblSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
            lbChucNang.setHorizontalAlignment(SwingConstants.CENTER);

            // Thêm các tiêu đề vào headerPanel
            headerPanel.add(lblTenSanPham);
            headerPanel.add(lblGiaNhap);
            headerPanel.add(lblSoLuong);
            headerPanel.add(lbChucNang);

            // Thêm headerPanel vào panel chính
            headerPanel.setBackground(new Color(46,106,216));
            headerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            panel.add(headerPanel);
            String maDonNhap=ds.get(i).getMaNhap();
            btXemChiTiet.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialog.setTitle("Chi tiết đơn nhập "+maDonNhap);
                    dialog.setLocationRelativeTo(null);
                    panel.removeAll(); 
                    panel.add(headerPanel);
                    BLLChiTietDonNhap bllChiTietDonNhap = new BLLChiTietDonNhap();
                    ArrayList<chiTietPhieuNhap> dsChiTietPhieuNhap = bllChiTietDonNhap.getChiTietPhieuNhap(maDonNhap);
                
                    for (chiTietPhieuNhap chiTiet : dsChiTietPhieuNhap) {
                        JPanel itemPanel = new JPanel(new GridLayout(1, 4));
                        itemPanel.setBackground(new Color(194, 232, 245));
                        itemPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
                
                        JLabel lblTenSP = new JLabel(bllChiTietDonNhap.getTenHH(chiTiet.getMaHangHoa()));
                        DecimalFormat df = new DecimalFormat("#,##0");
                        JLabel lblGiaN = new JLabel(df.format(chiTiet.getGiaTien()));
                        JLabel lblSL = new JLabel(String.valueOf(chiTiet.getSoLuong()));
                        JLabel lbLoai = new JLabel(bllChiTietDonNhap.getLoaiHH(chiTiet.getMaHangHoa()));
                
                        lblTenSP.setHorizontalAlignment(SwingConstants.CENTER);
                        lblGiaN.setHorizontalAlignment(SwingConstants.CENTER);
                        lblSL.setHorizontalAlignment(SwingConstants.CENTER);
                        lbLoai.setHorizontalAlignment(SwingConstants.CENTER);

                        itemPanel.add(lblTenSP);
                        itemPanel.add(lbLoai);
                        itemPanel.add(lblGiaN);
                        itemPanel.add(lblSL);
                
                        panel.add(itemPanel); 
                    }
                
                    panel.revalidate();
                    panel.repaint();
                    dialog.pack(); 
                    dialog.setVisible(true);
                }
            });

            btDuyet.setBounds(960, 10, 150, 30);
            btDuyet.setFont(new Font("Times New Roman", Font.BOLD, 20));
            btDuyet.setBackground(Color.WHITE);
            String maPhieuNhap = ds.get(i).getMaNhap();
            btDuyet.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn duyệt đơn hàng này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        DonNhap.duyetDon(maPhieuNhap);
                        pnDonNhap.setBackground(new Color(35, 177, 77));
                        btDuyet.setEnabled(false);
                        BLLChiTietDonNhap bllChiTietDonNhap=new BLLChiTietDonNhap();
                        bllChiTietDonNhap.themHoacCapNhatHangHoa(maCoSo, maDonNhap);
                    }
                }
            });
    
            // Thêm các thành phần vào panel đơn nhập
            pnDonNhap.add(lb2MaDonNhap);
            pnDonNhap.add(lb2MaNV);
            pnDonNhap.add(lb2MaCoSo);
            pnDonNhap.add(lb2Ngay);
            pnDonNhap.add(lb2TongTien);
            pnDonNhap.add(btXemChiTiet);
            pnDonNhap.add(btDuyet);
    
            // Thêm panel đơn nhập vào panel chính
            main.add(pnDonNhap);
        }
    
        // Cập nhật kích thước của main để phù hợp với số lượng đơn nhập
        main.setPreferredSize(new Dimension(rightPanel.getWidth() - 80, yPosition));
    
        // Cập nhật lại giao diện sau khi thay đổi
        main.revalidate();
        main.repaint();
    }    
}