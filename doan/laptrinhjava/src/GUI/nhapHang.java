package GUI;

import java.util.ArrayList;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import BLL.BLLChiTietDonNhap;
import BLL.BLLNhapHang;
import DTO.DTOTaiKhoan;
import DTO.DTOdonNhap;
import DTO.chiTietPhieuNhap;

public class nhapHang {
    private static Timer timer;
    JScrollPane scrollPane=new  JScrollPane();
    public void xulyNhapHang(DTOTaiKhoan tk,BLLNhapHang NhapHang, JPanel rightPanel, String coSoHienTai){
        ArrayList<DTOdonNhap> ds= NhapHang.getDonNhap(tk.getIDTaiKhoan(), coSoHienTai);
        BLLChiTietDonNhap chiTietDonNhap=new BLLChiTietDonNhap();
        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();
        rightPanel.setLayout(null);

        // Panel tiêu đề
        JPanel canGiua = new JPanel(null);
        canGiua.setBounds(5, 5, rightPanel.getWidth(), 55); 
        canGiua.setBackground(new Color(241, 255, 250));
        JLabel titleNhapThietBi = new JLabel("Nhập hàng");
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
        JLabel lbMaHV = new JLabel("Tên nhân viên: " + NhapHang.getTenNVbyMaTK(tk.getIDTaiKhoan()));
        JLabel lbMaCoSo = new JLabel("Tên cơ sở: " + coSoHienTai);
        int x = 50;
        lbMaHV.setBounds(x , 25, 300, 30);
        lbMaHV.setFont(new Font("Times New Roman", Font.BOLD, 18));
        x += 250;

        lbMaCoSo.setBounds(x + 100, 25, 220, 30);
        lbMaCoSo.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JButton newDonNhap = new JButton("Tạo đơn nhập");
        newDonNhap.setBackground(Color.WHITE);
        newDonNhap.setBounds(rightPanel.getWidth() - 250, 25, 150, 30);
        newDonNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNewDonNhapPanel(null, tk, NhapHang, chiTietDonNhap,rightPanel, coSoHienTai);
            }
        });

        // Thêm các thành phần vào panel nhập liệu
        nhapLieu.add(lbMaCoSo);
        nhapLieu.add(lbMaHV);
        nhapLieu.add(newDonNhap);
        rightPanel.add(nhapLieu);

        JLabel lb2MaDonNhap = new JLabel("Đơn Nhập");
        JLabel lb2MaNV = new JLabel("Nhân viên");
        JLabel lb2MaCoSo = new JLabel("Cơ sở");
        JLabel lb2Ngay = new JLabel("Ngày");
        JLabel lb2TongTien = new JLabel("Tổng tiền");
        JLabel lb2TinhNang = new JLabel("Các tính năng");
        JLabel lb2TinhTrang = new JLabel("Tình trạng");

        lb2MaDonNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2MaDonNhap.setBounds(10, 10, 150, 30);
        lb2MaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2MaNV.setBounds(150, 10, 150, 30);
        lb2MaCoSo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2MaCoSo.setBounds(330, 10, 150, 30);
        lb2Ngay.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2Ngay.setBounds(490, 10, 150, 30);
        lb2TongTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2TongTien.setBounds(650, 10, 150, 30);
        lb2TinhTrang.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2TinhTrang.setBounds(810, 10, 150, 30);
        lb2TinhNang.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lb2TinhNang.setBounds(950, 10, 150, 30);
        lb2TinhNang.setHorizontalAlignment(JLabel.CENTER);

        JPanel title = new JPanel(null);
        title.setBounds(5, 140, rightPanel.getWidth() - 20, 50);
        title.setBackground(new Color(46, 106, 216));
        title.add(lb2MaDonNhap);
        title.add(lb2MaNV);
        title.add(lb2MaCoSo);
        title.add(lb2Ngay);
        title.add(lb2TongTien);
        title.add(lb2TinhTrang);
        title.add(lb2TinhNang);
        rightPanel.add(title);
        addDonNhapToPanel(ds, tk,NhapHang,rightPanel,coSoHienTai);
    }
    public void addDonNhapToPanel(ArrayList<DTOdonNhap> ds, DTOTaiKhoan tk,BLLNhapHang NhapHang,JPanel rightPanel, String coSoHienTai) {
        JPanel main;

        main = new JPanel(null);
        scrollPane.setViewportView(main);
        scrollPane.setBounds(5, 190, rightPanel.getWidth() - 20, rightPanel.getHeight() - 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        rightPanel.add(scrollPane);
    
        // Xóa nội dung cũ của main
        main.removeAll();
        main.revalidate();
        main.repaint();
    
        int yPosition = 0; // Khởi tạo vị trí y ban đầu
        int rowHeight = 50; // Chiều cao của mỗi hàng (panel đơn nhập)
    
        for (DTOdonNhap donNhapItem : ds) {
            // Tạo panel cho mỗi đơn nhập
            JPanel pnDonNhap = new JPanel(null);
            pnDonNhap.setBackground(new Color(194, 232, 245));
            pnDonNhap.setBounds(0, yPosition, rightPanel.getWidth() - 40, rowHeight);
            yPosition += rowHeight;
    
            // Các thành phần trong mỗi đơn nhập
            JLabel lbMaDonNhap = new JLabel(donNhapItem.getMaPhieuNhap());
            lbMaDonNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbMaDonNhap.setBounds(10, 10, 150, 30);

            JLabel lbTenNV = new JLabel(donNhapItem.getHoTenNV());
            lbTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbTenNV.setBounds(150, 10, 150, 30);

            JLabel lbMaCoSo = new JLabel(donNhapItem.getTenCoSo());
            lbMaCoSo.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbMaCoSo.setBounds(330, 10, 150, 30);

            JLabel lbNgay = new JLabel(""+donNhapItem.getNgayNhap());
            lbNgay.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbNgay.setBounds(490, 10, 120, 30);

            @SuppressWarnings("deprecation")
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            String formattedTongTien = currencyFormatter.format(donNhapItem.getTongTien());

            // Thêm cột Tổng tiền với định dạng
            JLabel lbTongTien = new JLabel(formattedTongTien);
            lbTongTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbTongTien.setBounds(650, 10, 150, 30);

            JLabel lbTrangThai = new JLabel(donNhapItem.getTrangThai());
            lbTrangThai.setBounds(810, 10, 150, 30);
            lbTrangThai.setFont(new Font("Times New Roman", Font.BOLD, 20));
    
            // Tạo button Sửa
            JButton btnSua = new JButton("Xem");
            btnSua.setBounds(950, 10, 80, 30);
            btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
            btnSua.setBackground(Color.WHITE);
    
            // Tạo button Xóa
            JButton btnXoa = new JButton("Xóa");
            btnXoa.setBounds(1035, 10, 80, 30);
            btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
            btnXoa.setBackground(Color.WHITE);
            
            BLLChiTietDonNhap chiTietDonNhap=new BLLChiTietDonNhap();
            btnSua.addActionListener(e -> {
                showNewDonNhapPanel(donNhapItem, tk, NhapHang, chiTietDonNhap, rightPanel, coSoHienTai);
            });
    
            btnXoa.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(
                    null, 
                    "Bạn có chắc chắn muốn xóa phiếu nhập này?", 
                    "Xác nhận xóa", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );
            
                // Nếu người dùng chọn "Yes", thực hiện hành động xóa
                if (confirm == JOptionPane.YES_OPTION) {
                    boolean result = NhapHang.deletePhieuNhap(donNhapItem.getMaPhieuNhap());
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Phiếu nhập đã được xóa thành công.");
                        ds.remove(donNhapItem);
                        addDonNhapToPanel(ds, tk,NhapHang, rightPanel,coSoHienTai);
                    } else {
                        JOptionPane.showMessageDialog(null, "Không thể xóa phiếu nhập. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
    
            // Thêm các thành phần vào panel đơn nhập
            pnDonNhap.add(lbMaDonNhap);
            pnDonNhap.add(lbTenNV);
            pnDonNhap.add(lbMaCoSo);
            pnDonNhap.add(lbNgay);
            pnDonNhap.add(lbTongTien);
            pnDonNhap.add(lbTrangThai);
            pnDonNhap.add(btnSua); // Thêm nút Sửa
            pnDonNhap.add(btnXoa); // Thêm nút Xóa
    
            // Thêm panel đơn nhập vào panel chính
            main.add(pnDonNhap);
        }
        // Cập nhật kích thước của main để phù hợp với số lượng đơn nhập
        main.setPreferredSize(new Dimension(rightPanel.getWidth() - 40, yPosition));
        // Cập nhật lại giao diện sau khi thay đổi
        main.revalidate();
        main.repaint();
    }
    
    public void showNewDonNhapPanel(DTOdonNhap dtOdonNhap,DTOTaiKhoan tk,BLLNhapHang NhapHang, BLLChiTietDonNhap chiTietDonNhap, JPanel rightPanel, String coSoHienTai) {
        String maDonNhap;
        if (dtOdonNhap==null)
            maDonNhap=chiTietDonNhap.insertDonNhap(tk.getIDTaiKhoan());
        else    
            maDonNhap=dtOdonNhap.getMaPhieuNhap();
        JPanel newPanel = new JPanel(null);
        
        rightPanel.removeAll();

        chiTietDonNhap.getChiTietPhieuNhap(maDonNhap);
        ArrayList<chiTietPhieuNhap> ds=chiTietDonNhap.getChiTietPhieuNhap(maDonNhap);
        addChiTietDonNhapToPanel(ds, NhapHang, rightPanel);

        newPanel.setBounds(0, 0, rightPanel.getWidth(), rightPanel.getHeight());
        newPanel.setBackground(new Color(255, 255, 255));

        // Thêm tiêu đề
        JLabel title = new JLabel("Tạo Đơn Nhập Mới");
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        title.setBounds(10, 10, 400, 40);
        newPanel.add(title);

        // Panel tiêu đề
        JPanel canGiua = new JPanel(null);
        canGiua.setBounds(5, 5, rightPanel.getWidth(), 55); 
        canGiua.setBackground(new Color(241, 255, 250));
        canGiua.add(title);
        //btn quay lại
        JButton backButton = new JButton("Quay lại");
        backButton.setBounds(rightPanel.getWidth() - 200, 10, 120, 30);
        backButton.addActionListener(e -> {
            if(chiTietDonNhap.getChiTietPhieuNhap(maDonNhap).isEmpty()){
                NhapHang.deletePhieuNhap(maDonNhap);
            }
            xulyNhapHang(tk, NhapHang, rightPanel, coSoHienTai);
        });
        canGiua.add(backButton);
        rightPanel.add(canGiua);

        // Panel nhập liệu
        JPanel nhapLieu = new JPanel(null);
        nhapLieu.setBounds(2, 60, rightPanel.getWidth() - 20, 80);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder, "Nhập liệu");
        titledBorder.setTitleFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        nhapLieu.setBorder(titledBorder);
        nhapLieu.setBackground(new Color(119, 230, 163));

        ArrayList<String> danhSachHangHoaList = NhapHang.getDsHH();
        String[] danhSachHangHoa = danhSachHangHoaList.toArray(new String[0]);
        JComboBox<String> cbTenHangHoa = new JComboBox<>(danhSachHangHoa);
        cbTenHangHoa.setEditable(true);
        cbTenHangHoa.setSelectedItem("");
        
        JTextField textField = (JTextField) cbTenHangHoa.getEditor().getEditorComponent();
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                scheduleUpdate();
            }
        
            @Override
            public void removeUpdate(DocumentEvent e) {
                scheduleUpdate();
            }
        
            @Override
            public void changedUpdate(DocumentEvent e) {
                scheduleUpdate();
            }
        
            private void scheduleUpdate() {
                if (timer != null) {
                    timer.restart();
                } else {
                    timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            updateComboBox();
                            timer.stop();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        
            private void updateComboBox() {
                String typed = textField.getText();
                String selectedValue = typed;
        
                cbTenHangHoa.removeAllItems();
                for (String item : danhSachHangHoa) {
                    if (item.toLowerCase().startsWith(typed.toLowerCase())) {
                        cbTenHangHoa.addItem(item);
                    }
                }
        
                // Kiểm tra xem combo box có đang hiển thị trước khi gọi setPopupVisible
                if (cbTenHangHoa.isShowing()) {
                    cbTenHangHoa.setPopupVisible(cbTenHangHoa.getItemCount() > 0);
                }
                
                textField.setText(selectedValue);
            }
        });

        JButton btnNhapHang = new JButton("Nhập hàng");
        btnNhapHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maHH=chiTietDonNhap.getMaHH((String)cbTenHangHoa.getSelectedItem());
                if(!NhapHang.checkHangHoa(maDonNhap, maHH)){
                    chiTietDonNhap.addChiTietHoaDon( maDonNhap, maHH, 1, 20000);
                    addChiTietDonNhapToPanel(chiTietDonNhap.getChiTietPhieuNhap(maDonNhap), NhapHang, rightPanel);
                }else
                JOptionPane.showMessageDialog(null, (String)cbTenHangHoa.getSelectedItem()+" đã tồn tại.", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            }
        });

        JLabel lbTenHH = new JLabel("Tên hàng hóa: ");
        JLabel lbMaCoSo = new JLabel("Tên cơ sở: " + coSoHienTai);

        int x = 50;
        lbTenHH.setBounds(x, 25, 150, 30);
        lbTenHH.setFont(new Font("Times New Roman", Font.BOLD, 18));

        cbTenHangHoa.setBounds(x + 155, 25, 200, 30);
        cbTenHangHoa.setFont(new Font("Times New Roman", Font.BOLD, 18));

        btnNhapHang.setBounds(x + 400, 25, 150, 30);

        x=x+400;

        lbMaCoSo.setBounds(x + 200, 25, 220, 30);
        lbMaCoSo.setFont(new Font("Times New Roman", Font.BOLD, 18));

        nhapLieu.add(lbTenHH);
        nhapLieu.add(cbTenHangHoa);
        nhapLieu.add(lbMaCoSo);
        nhapLieu.add(btnNhapHang);
        newPanel.add(nhapLieu);

        // Tạo các JLabel
        JLabel lb2MaDonNhap = new JLabel("Mã hàng hóa");
        JLabel lb2MaNV = new JLabel("Tên Hàng hóa");
        JLabel lb2MaCoSo = new JLabel("Loại");
        JLabel lb2Ngay = new JLabel("Số lượng");
        JLabel lb2TongTien = new JLabel("Giá nhập");
        JLabel lb2TinhNang = new JLabel("Tính năng");

        // Cài đặt font cho các JLabel
        Font labelFont = new Font("Times New Roman", Font.BOLD, 20);
        lb2MaDonNhap.setFont(labelFont);
        lb2MaNV.setFont(labelFont);
        lb2MaCoSo.setFont(labelFont);
        lb2Ngay.setFont(labelFont);
        lb2TongTien.setFont(labelFont);
        lb2TinhNang.setFont(labelFont);

        // Vị trí cho từng JLabel
        lb2MaDonNhap.setBounds(10, 10, 150, 30);
        lb2MaNV.setBounds(160, 10, 150, 30);
        lb2MaCoSo.setBounds(330, 10, 150, 30);
        lb2Ngay.setBounds(500, 10, 150, 30);
        lb2TongTien.setBounds(600, 10, 150, 30);
        lb2TinhNang.setBounds(900, 10, 150, 30);

        // Tạo JPanel để chứa các JLabel
        JPanel title2 = new JPanel(null);
        title2.setBounds(5, 140, rightPanel.getWidth() - 20, 50);
        title2.setBackground(new Color(46, 106, 216));
        title2.add(lb2MaDonNhap);
        title2.add(lb2MaNV);
        title2.add(lb2MaCoSo);
        title2.add(lb2Ngay);
        title2.add(lb2TongTien);
        title2.add(lb2TinhNang);

        newPanel.add(title2);
        rightPanel.add(newPanel);
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    public void addChiTietDonNhapToPanel(ArrayList<chiTietPhieuNhap> ds, BLLNhapHang NhapHang,JPanel rightPanel) {
        BLLChiTietDonNhap chiTietDonNhap=new BLLChiTietDonNhap();
        JPanel main=new JPanel();
    
        main = new JPanel(null);
        scrollPane.setViewportView(main);
        scrollPane.setBounds(5, 190, rightPanel.getWidth() - 20, rightPanel.getHeight() - 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        rightPanel.add(scrollPane);
    
        main.removeAll();
        main.revalidate();
        main.repaint();
    
        int yPosition = 0;
        int rowHeight = 50;
    
        for (chiTietPhieuNhap donNhapItem : ds) {
            // Tạo panel cho mỗi chi tiết đơn nhập
            JPanel pnDonNhap = new JPanel(null);
            pnDonNhap.setBackground(new Color(194, 232, 245));
            pnDonNhap.setBounds(0, yPosition, rightPanel.getWidth() - 40, rowHeight);
            yPosition += rowHeight;
        
            // Các thành phần trong mỗi chi tiết đơn nhập
            JLabel lbMaDonNhap = new JLabel(donNhapItem.getMaPhieuNhap());
            lbMaDonNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbMaDonNhap.setBounds(10, 10, 150, 30);
        
            JLabel lbTenHH = new JLabel(chiTietDonNhap.getTenHH(donNhapItem.getMaHangHoa()));
            lbTenHH.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbTenHH.setBounds(160, 10, 150, 30);
        
            JLabel lbLoai = new JLabel(chiTietDonNhap.getLoaiHH(donNhapItem.getMaHangHoa())); 
            lbLoai.setFont(new Font("Times New Roman", Font.BOLD, 20));
            lbLoai.setBounds(330, 10, 150, 30);
        
            // Đổi JLabel số lượng thành JTextField để cho phép chỉnh sửa
            JTextField tfSoLuong = new JTextField(String.valueOf(donNhapItem.getSoLuong())); 
            tfSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 20));
            tfSoLuong.setBounds(500, 10, 80, 30);
        
            // Thêm JTextField cho giá tiền
            JTextField tfGiaNhap = new JTextField(String.valueOf(donNhapItem.getGiaTien())); 
            tfGiaNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
            tfGiaNhap.setBounds(600, 10, 100, 30);
        
            // Tạo button Xóa
            JButton btnXoa = new JButton("Xóa");
            btnXoa.setBounds(980, 10, 80, 30);
            btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
            btnXoa.setBackground(Color.WHITE);
            
            btnXoa.addActionListener(e -> {
                int response = JOptionPane.showConfirmDialog(null, 
                    "Bạn có chắc chắn muốn xóa chi tiết phiếu nhập này?", 
                    "Xác nhận xóa", 
                    JOptionPane.YES_NO_OPTION);
                
                if (response == JOptionPane.YES_OPTION) {
                    NhapHang.deleteChiTietPhieuNhap(donNhapItem.getMaPhieuNhap(), donNhapItem.getMaHangHoa());
                    addChiTietDonNhapToPanel(chiTietDonNhap.getChiTietPhieuNhap(ds.get(0).getMaPhieuNhap()), NhapHang, rightPanel);
                }
            });
        
            // Tạo button Cập nhật
            JButton btnCapNhat = new JButton("Cập nhật");
            btnCapNhat.setBounds(825, 10, 130, 30);
            btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 20));
            btnCapNhat.setBackground(Color.WHITE);
        
            String oldSoLuongText = tfSoLuong.getText();
            String oldGiaNhapText = tfGiaNhap.getText();
            btnCapNhat.addActionListener(e -> {
            
                String soLuongText = tfSoLuong.getText();
                String giaNhapText = tfGiaNhap.getText();
                int soLuong;
                int giaNhap;
                
                try {
                    soLuong = Integer.valueOf(soLuongText);
                    giaNhap = Integer.valueOf(giaNhapText);
            
                    if (soLuong <= 0) {
                        JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        tfSoLuong.setText(oldSoLuongText);
                        return;
                    }
                    if (giaNhap <= 0){
                        JOptionPane.showMessageDialog(null, "Giá nhập phải lớn hơn 0!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        tfGiaNhap.setText(oldGiaNhapText);
                        return;
                    }
            
                    NhapHang.updateGiavaSoLuong(donNhapItem.getMaPhieuNhap(), donNhapItem.getMaHangHoa(), soLuong, giaNhap);
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    // Hiển thị thông báo cảnh báo
                    JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    
                    // Đặt lại giá trị của JTextField
                    tfSoLuong.setText(String.valueOf(donNhapItem.getSoLuong()));
                    tfGiaNhap.setText(String.valueOf(donNhapItem.getGiaTien()));
                }
            });
        
            // Thêm các thành phần vào panel đơn nhập
            pnDonNhap.add(lbMaDonNhap);
            pnDonNhap.add(lbTenHH);
            pnDonNhap.add(lbLoai);
            pnDonNhap.add(tfSoLuong);
            pnDonNhap.add(tfGiaNhap);
            pnDonNhap.add(btnCapNhat); // Thêm nút Cập nhật
            pnDonNhap.add(btnXoa);
            main.add(pnDonNhap);
        }
        
        // Cập nhật chiều rộng của panel để khớp với tổng chiều rộng các thành phần
        main.setPreferredSize(new Dimension(rightPanel.getWidth() - 40, yPosition));
        main.revalidate();
        main.repaint();
    }
}