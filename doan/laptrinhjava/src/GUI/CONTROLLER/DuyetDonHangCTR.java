package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import BLL.TuanBLL;
import DTO.ChiTietChiTietHoaDon;
import DTO.HoaDon;
import DTO.HoaDonVaGia;
import GUI.ChiTietHoaDon;

public class DuyetDonHangCTR extends JPanel{
    private String maCoSo;
    private TuanBLL bll = new TuanBLL();
    public DuyetDonHangCTR(String maCoSo)
    {
        setLayout(null);
//        setSize(1200,900);
        setBackground(new Color(241, 255, 250));
        setMaCoSo(maCoSo);
        setBounds(0,0,1200,900);
        
        
//        giaoDien();
    }
    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }
    public void giaoDien(JPanel rightPanel)
    {
        
        ArrayList<HoaDonVaGia> ds = new ArrayList<>();
        ds = bll.layDSHDCuaCoSo(maCoSo, "Chưa duyệt");
        themDSHoaDon(ds, rightPanel);
    }
    public void themDSHoaDon(ArrayList<HoaDonVaGia> ds, JPanel rightPanel)
    {
        rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        rightPanel.repaint(); // Vẽ lại JPanel
        JLabel tieude = new JLabel("Duyệt đơn hàng");
        tieude.setBounds(520, 20, 244, 40);
        tieude.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));

     // Tạo JRadioButton cho "Chưa duyệt"
        JButton chuaDuyetBTN = new JButton("Chưa duyệt");
        chuaDuyetBTN.setBackground(new Color(241, 255, 250));
        chuaDuyetBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
        chuaDuyetBTN.setBounds(475, 69, 150, 23);
        chuaDuyetBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					ArrayList<HoaDonVaGia> ds = new ArrayList<>();
			        ds = bll.layDSHDCuaCoSo(maCoSo, "Chưa duyệt");
			        themDSHoaDon(ds, rightPanel);
			}
		});
        rightPanel.add(chuaDuyetBTN);

        // Tạo JRadioButton cho "Đã duyệt"
        JButton daDuyetBTN = new JButton("Đã duyệt");
        daDuyetBTN.setBackground(new Color(241, 255, 250));
        daDuyetBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
        daDuyetBTN.setBounds(675, 69, 150, 23);
        daDuyetBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					ArrayList<HoaDonVaGia> ds = new ArrayList<>();
			        ds = bll.layDSHDCuaCoSo(maCoSo, "Đã duyệt");
			        themDSHoaDon(ds, rightPanel);
			}
		});
        rightPanel.add(daDuyetBTN);

        // Tạo ButtonGroup và thêm cả hai JRadioButton vào group
        
        rightPanel.add(tieude);
        int soLuongHoaDon = ds.size();
        JPanel dsHoaDonpn = new JPanel(new GridLayout(soLuongHoaDon+1,7,10,10));
        JLabel maHoaDon2 = new JLabel("Mã hóa đơn");
        JLabel maHoiVien2 = new JLabel("Tài khoản hội viên");
        JLabel ngayXuatHoaDon2 = new JLabel("Ngày xuất hóa đơn");
        JLabel trangThai2 = new JLabel("Trạng thái");
        JLabel tongTien2 = new JLabel("Tổng");
        JLabel chitietHoaDon2 = new JLabel("Xem chi tiết");
        JLabel duyetBt2 = new JLabel("Duyệt");
        maHoaDon2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        maHoiVien2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        ngayXuatHoaDon2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        trangThai2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        tongTien2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        chitietHoaDon2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        duyetBt2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        dsHoaDonpn.add(maHoaDon2);
        dsHoaDonpn.add(maHoiVien2);
        dsHoaDonpn.add(ngayXuatHoaDon2);
        dsHoaDonpn.add(trangThai2);
        dsHoaDonpn.add(tongTien2);
        dsHoaDonpn.add(chitietHoaDon2);
        dsHoaDonpn.add(duyetBt2);
        for(int i=0;i<soLuongHoaDon;i++)
        {
            JLabel maHoaDon = new JLabel(ds.get(i).getMaHoaDon());
            JLabel maHoiVien = new JLabel(ds.get(i).getMaHoiVien());
            JLabel ngayXuatHoaDon = new JLabel(ds.get(i).getNgayXuatHoaDon().toString());
            JLabel trangThai = new JLabel(ds.get(i).getTrangThai());
            JLabel tongTien = new JLabel(String.valueOf(ds.get(i).getTongTien()/1000)+"K");
            JButton chitietHoaDon = new JButton("Xem chi tiết");
            JButton duyetBt = new JButton("Duyệt");
            if(ds.get(i).getTrangThai().equals("Đã duyệt")){
                duyetBt.setEnabled(false);
                duyetBt.setText("Đã duyệt");
            }
            chitietHoaDon.setBackground(Color.white);
            duyetBt.setBackground(Color.white);
            maHoaDon.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
            maHoiVien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
            ngayXuatHoaDon.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
            trangThai.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
            tongTien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
            chitietHoaDon.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
            duyetBt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
            dsHoaDonpn.add(maHoaDon);
            dsHoaDonpn.add(maHoiVien);
            dsHoaDonpn.add(ngayXuatHoaDon);
            dsHoaDonpn.add(trangThai);
            dsHoaDonpn.add(tongTien);
            dsHoaDonpn.add(chitietHoaDon);
            dsHoaDonpn.add(duyetBt);
            int index = i;
            chitietHoaDon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    ArrayList<ChiTietChiTietHoaDon> chiTietHoaDon = new ArrayList<>();
                    chiTietHoaDon = bll.layDSChiTietHoaDonCuaCoSo(ds.get(index).getMaHoiVien(), ds.get(index).getMaHoaDon(), maCoSo);
                    new ChiTietHoaDon(chiTietHoaDon);
                }
            });
            duyetBt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(bll.duyetHoaDonCuaCoSo(ds.get(index).getMaHoaDon(), maCoSo)) 
                    {
                        JOptionPane.showMessageDialog(null, "Thành công");
                        duyetBt.setText("Đã duyệt");
                        duyetBt.setEnabled(false);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Thất bại");
                    	return;
                    }
                }
            });
        }
        JScrollPane cuon = new JScrollPane(dsHoaDonpn);
        int cao = 60 * (soLuongHoaDon+1) ;
        if(cao > 750) cao = 750; 
        cuon.setBounds(0,150,1200,cao);
        rightPanel.add(cuon);
    }
    public static void main(String[] args)
    {
        new DuyetDonHangCTR("CS003");
    }
}
