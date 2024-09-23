package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;


import BLL.BLLQuanLyDanhSach;
import BLL.TuanBLL;
import DTO.ChiTietChiTietHoaDon;
import DTO.GioHang;
import DTO.HoaDonVaGia;
import DTO.ThongTinChiTietHangHoa;
import GUI.ChiTietHoaDon;

public class MuaHangCTR extends JPanel {
    private JPanel banHang = new JPanel();
    private JScrollPane scrollPane;
    BLLQuanLyDanhSach ql = new BLLQuanLyDanhSach();
    TuanBLL bll = new TuanBLL();
    private String IDTaiKhoan;
    private JPanel tongTienpn = new JPanel(null);
    public MuaHangCTR(String tk)
    {
        setLayout(null);
        setSize(1200,900);
        setBackground(new Color(241, 255, 250));
        setIDTaiKhoan(tk);
        giaoDien();
    }
    public void setIDTaiKhoan(String iDTaiKhoan) {
        IDTaiKhoan = iDTaiKhoan;
    }
    public void giaoDien()
    {
        Vector<String> dsMaCoSo = ql.layDSMaCoSo();
        Vector<String> dsLoai = new Vector<>();
        dsLoai.add("Tất cả");
        dsLoai.add("Tạ");
        dsLoai.add("Máy chạy");
        dsLoai.add("Xà");
        dsLoai.add("Thực phẩm chức năng");
        removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        repaint(); // Vẽ lại JPanel
        setLayout(null);
        JLabel tieude = new JLabel("Mua hàng");
        tieude.setBounds(520, 20, 244, 40);
        tieude.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
        add(tieude);

        JPanel loc = new JPanel(null);
        loc.setBounds(0, 60, 1200, 100);
        loc.setBackground(Color.WHITE);

        int x = 50;
        JLabel tenHangHoalb = new JLabel("Tên hàng hóa: ");  
        tenHangHoalb.setBounds(x+20, 20, 150, 20); x+=150+10;
        tenHangHoalb.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField textTenHangHoa = new JTextField(); textTenHangHoa.setBounds(x, 20, 150, 20); x+=200;
        JLabel loailb = new JLabel("Loại hàng hóa: "); loailb.setBounds(x,20,150,20); x+=120;
        loailb.setFont(new Font("Arial", Font.BOLD, 17));
        @SuppressWarnings("rawtypes")
        JComboBox cbLoai = new JComboBox<>(dsLoai); cbLoai.setBounds(x, 20, 100, 20); x+=150;
        JLabel coSo = new JLabel("Tên cơ sở"); coSo.setBounds(x, 20, 100, 20); x+=110;
        coSo.setFont(new Font("Arial", Font.BOLD, 17));
        @SuppressWarnings("rawtypes")
        JComboBox cbCoSo = new JComboBox<>(dsMaCoSo); cbCoSo.setBounds(x,20,100,20);x+=150;
        cbCoSo.removeItemAt(0);
        
        JButton xemGioHang = new JButton("Xem giỏ hàng");
        xemGioHang.setBounds(700,55,150,40);
        xemGioHang.setBackground(Color.WHITE);
        xemGioHang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<GioHang> dsGioHang = new ArrayList<>();
                dsGioHang = bll.layDSGioHang(IDTaiKhoan);
                xemGioHang(dsGioHang);
            }
        });

        JButton xemHoaDon = new JButton("Xem hóa đơn");
        xemHoaDon.setBounds(900,55,150,40);
        xemHoaDon.setBackground(Color.WHITE);
        xemHoaDon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<HoaDonVaGia> ds = new ArrayList<>();
                ds = bll.layDSHoaDonCua(IDTaiKhoan);
                xemHoaDon(ds);
            }
        });
        loc.add(xemGioHang);
        loc.add(xemHoaDon);

        JButton timKiemBt = new JButton("Tìm kiếm");
        timKiemBt.setBounds(x,15,150,30);
        timKiemBt.setBackground(Color.WHITE);
        timKiemBt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String tenHangst = textTenHangHoa.getText();
                String tenCoSost = cbCoSo.getSelectedItem().toString();
                String loaist = cbLoai.getSelectedItem().toString();
                ArrayList<ThongTinChiTietHangHoa> ds2 = new ArrayList<>();
                TuanBLL bll = new TuanBLL();
                ds2 = bll.timDSHangBan(tenHangst, tenCoSost, loaist);
                xuatSanPham(ds2);
        	}
        });
        loc.add(timKiemBt);


        loc.add(tenHangHoalb);
        loc.add(textTenHangHoa);
        loc.add(loailb);
        loc.add(cbLoai);
        loc.add(coSo);
        loc.add(cbCoSo);
        add(loc);

        scrollPane = new JScrollPane(banHang);
        scrollPane.setBounds(0, 160, 1200, 760);
        add(scrollPane);

        ArrayList<ThongTinChiTietHangHoa> ds1 = new ArrayList<>();
        ds1 = ql.layDSBanHang(cbCoSo.getSelectedItem().toString());
        xuatSanPham(ds1);
    }
    public void xemHoaDon(ArrayList<HoaDonVaGia> ds)
    {
        banHang.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        banHang.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        banHang.repaint(); // Vẽ lại JPanel
        banHang.setLayout(null);
        int soLuong = ds.size();
        banHang.setPreferredSize(new Dimension(1150, soLuong * 90 + 100));
        int y = 30;
        for(int i=0;i<soLuong;i++)
        {
            int x = 200;
            JPanel hoaDonPn = new JPanel(null);
            hoaDonPn.setBounds(0, y, 1200, 60);
            JLabel maHoaDon = new JLabel(ds.get(i).getMaHoaDon());
            maHoaDon.setBounds(x, 0, 70, 60); x+=90;
            maHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
            hoaDonPn.add(maHoaDon);

            JLabel ngayXuat = new JLabel(ds.get(i).getNgayXuatHoaDon().toString());
            ngayXuat.setBounds(x, 0, 130, 60); x+=150;
            ngayXuat.setFont(new Font("Arial", Font.BOLD, 20));
            hoaDonPn.add(ngayXuat);

            JLabel trangThai = new JLabel(ds.get(i).getTrangThai().trim());
            trangThai.setBounds(x, 0, 150, 60); x+=170;
            trangThai.setFont(new Font("Arial", Font.BOLD, 20));
            hoaDonPn.add(trangThai);

            JLabel tongTien = new JLabel(String.valueOf(ds.get(i).getTongTien()/1000)+"K");
            tongTien.setBounds(x, 0, 250, 60); x+=270;
            tongTien.setFont(new Font("Arial", Font.BOLD, 20));
            hoaDonPn.add(tongTien);

            JButton xemChiTiet = new JButton("Xem chi tiết");
            xemChiTiet.setBackground(Color.WHITE);
            xemChiTiet.setBounds(x, 0, 250, 60); x+=270;
            xemChiTiet.setFont(new Font("Arial", Font.BOLD, 20));
            hoaDonPn.add(xemChiTiet);
            int index = i;
            xemChiTiet.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    String maHD = ds.get(index).getMaHoaDon();
                    ArrayList<ChiTietChiTietHoaDon> chiTietHoaDon = new ArrayList<>();
                    chiTietHoaDon = bll.layDSChiTietHoaDonCua(IDTaiKhoan, maHD);
                    new ChiTietHoaDon(chiTietHoaDon);
                }
            });

            y+=90;
            banHang.add(hoaDonPn);
        }
        scrollPane.setBounds(0, 160, 1200, 760);
    }
    public void xemGioHang(ArrayList<GioHang> dsGioHang)
    {
        banHang.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        banHang.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        banHang.repaint(); // Vẽ lại JPanel
        banHang.setLayout(null);
        int tongTien = 0;
        int soLuongGioHang = dsGioHang.size();
        banHang.setPreferredSize(new Dimension(1150, soLuongGioHang * 100 + 150));
        int y = 50;
        JLabel sttlb = new JLabel("STT"); sttlb.setBounds(20,0,40,40); banHang.add(sttlb);
        JLabel anh = new JLabel("Ảnh"); anh.setBounds(70,0,90,40); banHang.add(anh);
        JLabel tenlb = new JLabel("Tên"); tenlb.setBounds(200,0,350,40); banHang.add(tenlb);
        JLabel coSolb = new JLabel("Cơ sở");coSolb.setBounds(580,0,100,40); banHang.add(coSolb);
        JLabel soLuong = new JLabel("Số lượng");soLuong.setBounds(710,0,90,40); banHang.add(soLuong);
        JLabel gialb2 = new JLabel("Giá");gialb2.setBounds(810,0,150,40); banHang.add(gialb2);
        JLabel xoalb = new JLabel("Xóa");xoalb.setBounds(990,0,90,40); banHang.add(xoalb);
        sttlb.setFont(new Font("Arial", Font.BOLD, 20));
        anh.setFont(new Font("Arial", Font.BOLD, 20));
        tenlb.setFont(new Font("Arial", Font.BOLD, 20));
        coSolb.setFont(new Font("Arial", Font.BOLD, 20));
        soLuong.setFont(new Font("Arial", Font.BOLD, 20));
        gialb2.setFont(new Font("Arial", Font.BOLD, 20));
        xoalb.setFont(new Font("Arial", Font.BOLD, 20));
        for(int i=0;i<soLuongGioHang;i++)
        {
            int x = 30;
            JPanel pnGioHang = new JPanel(null);
            pnGioHang.setBounds(0, y, 1200, 90);

            JLabel stt = new JLabel(String.valueOf(i+1));
            stt.setBounds(x,20,30, 40); x+=40;
            pnGioHang.add(stt);
            stt.setFont(new Font("Arial", Font.BOLD, 20));

            ImageIcon anhHang = new ImageIcon(dsGioHang.get(i).getHinhAnh());
            Image chinhAnhThietBi = anhHang.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
            anhHang = new ImageIcon(chinhAnhThietBi);
            JLabel anhlb = new JLabel(anhHang);
            anhlb.setBounds(x, 0, 90, 90); x+=130;
            pnGioHang.add(anhlb);

            JLabel tenHanglb = new JLabel(dsGioHang.get(i).getTenHangHoa());
            tenHanglb.setBounds(x,20,350, 40); x+=380;
            tenHanglb.setFont(new Font("Arial", Font.BOLD, 20));
            pnGioHang.add(tenHanglb);

            JLabel maCoSo = new JLabel(dsGioHang.get(i).getMaCoSo());
            maCoSo.setBounds(x,20,100, 40); x+=130;
            maCoSo.setFont(new Font("Arial", Font.BOLD, 20));
            pnGioHang.add(maCoSo);

            JLabel soLuonglb = new JLabel(String.valueOf(dsGioHang.get(i).getSoLuong()));
            soLuonglb.setBounds(x,20,70, 40); x+=100;
            soLuonglb.setFont(new Font("Arial", Font.BOLD, 20));
            pnGioHang.add(soLuonglb);

            int gia = dsGioHang.get(i).getGia() * dsGioHang.get(i).getSoLuong();
            tongTien += gia;
            JLabel gialb = new JLabel(String.valueOf(gia / 1000) +"K");
            gialb.setBounds(x,20,150, 40); x+=180;
            gialb.setFont(new Font("Arial", Font.BOLD, 20));
            pnGioHang.add(gialb);

            ImageIcon thungRac = new ImageIcon("src/asset/img/icon/thung-rac.png");
            Image chinhThungRac = thungRac.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT);
            thungRac = new ImageIcon(chinhThungRac);
            JButton xoa = new JButton(thungRac);
            xoa.setBounds(x, 15, 70, 50);
            xoa.setBackground(Color.WHITE);
            int index = i;
            xoa.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    String s = bll.xoaGioHang(dsGioHang.get(index).getIDTaiKhoan(), dsGioHang.get(index).getMaHangHoa(),dsGioHang.get(index).getMaCoSo(),dsGioHang.get(index).getSoLuong());
                    JOptionPane.showMessageDialog(null,s);
                    ArrayList<GioHang> dsGioHang = new ArrayList<>();
                    dsGioHang = bll.layDSGioHang(IDTaiKhoan);
                    xemGioHang(dsGioHang);
                }
            });
            pnGioHang.add(xoa);
            banHang.add(pnGioHang);
            y+=100;
        }
        tongTienpn.removeAll();
        tongTienpn.revalidate();
        tongTienpn.repaint();
        tongTienpn.setBounds(0,755,1200,100);
        JLabel tongTienlb = new JLabel("Tổng: "+String.valueOf(tongTien/1000)+"K");
        tongTienlb.setBounds(600, 10, 200, 80);
        tongTienlb.setFont(new Font("Arial", Font.BOLD, 25));
        JButton thanhToanBt = new JButton("Thanh toán");
        thanhToanBt.setBounds(850, 10, 200, 80);
        thanhToanBt.setBackground(Color.WHITE);
        thanhToanBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String s;
                s = bll.thanhToan(IDTaiKhoan);
                JOptionPane.showMessageDialog(null,s);
                xemGioHang(new ArrayList<>());
            }
        });
        tongTienpn.add(tongTienlb);
        tongTienpn.add(thanhToanBt);
        add(tongTienpn);
        scrollPane.setBounds(0, 160, 1200, 600);
    }
    public void xuatSanPham(ArrayList<ThongTinChiTietHangHoa> ds) {
        banHang.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        banHang.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        banHang.repaint(); // Vẽ lại JPanel
        int soLuongHang = ds.size();
        banHang.setBackground(Color.WHITE);
        banHang.setPreferredSize(new Dimension(1200, (soLuongHang / 3 + 1) * 450 + 10));
        banHang.setLayout(null);

        int x = 50, y = -440;
        for (int i = 0; i < soLuongHang; i++) {
            if (i % 3 == 0) {
                x = 50;
                y += 450;
            }

            JPanel thongTinSanPham = new JPanel();
            thongTinSanPham.setBackground(Color.WHITE);
            thongTinSanPham.setBounds(x, y, 300, 400);
            thongTinSanPham.setLayout(null);
            thongTinSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JPanel anh = new JPanel(null);
            anh.setBounds(5, 5, 290, 300);
            ImageIcon anhThietBi = new ImageIcon(ds.get(i).getHinhAnh());
            Image chinhAnhThietBi = anhThietBi.getImage().getScaledInstance(290, 300, Image.SCALE_DEFAULT);
            anhThietBi = new ImageIcon(chinhAnhThietBi);
            JLabel labelAnhThietBi = new JLabel(anhThietBi);
            labelAnhThietBi.setBounds(0, 0, 290, 300);
            anh.add(labelAnhThietBi);

            JPanel tenhhpn = new JPanel();
            tenhhpn.setBounds(5, 295, 290, 20);
            JLabel tenlb = new JLabel(ds.get(i).tenHang);
            tenhhpn.setBackground(Color.WHITE);
            tenhhpn.add(tenlb);

            JPanel giahhpn = new JPanel();
            giahhpn.setBounds(5, 325, 290, 20);
            JLabel gialb = new JLabel(String.valueOf(ds.get(i).getGiaBan()));
            giahhpn.setBackground(Color.WHITE);
            giahhpn.add(gialb);

            thongTinSanPham.add(giahhpn);
            thongTinSanPham.add(tenhhpn);
            thongTinSanPham.add(anh);
            banHang.add(thongTinSanPham);

            x += 375;

            int index = i;
            thongTinSanPham.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    new ThongTinHangHoa(ds.get(index).getMaHangHoa(), ds.get(index).getCoSo(), ds.get(index).getHinhAnh(), ds.get(index).getSoLuong(),IDTaiKhoan);
                }
            });
        }

        scrollPane.setBounds(0, 160, 1200, 760);
        // Cập nhật lại scrollPane mà không cần tạo mới
        banHang.revalidate();
        banHang.repaint();
    }
}
