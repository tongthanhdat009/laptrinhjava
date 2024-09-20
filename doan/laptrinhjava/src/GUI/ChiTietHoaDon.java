package GUI;
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;

import DTO.ChiTietChiTietHoaDon;
public class ChiTietHoaDon extends JFrame{
    public ChiTietHoaDon(ArrayList<ChiTietChiTietHoaDon> ds)
    {
        setLayout(null);
        setSize(650,500);
        setLocationRelativeTo(null);
        setBackground(new Color(241, 255, 250));
        JPanel noiDung = new JPanel(new GridLayout(0,4,10,10));
        noiDung.setPreferredSize(new Dimension(480, 30*ds.size()));
        JLabel thongTinNguoiMua = new JLabel(ds.get(0).getMaHoiVien()+":"+ds.get(0).getTenHoiVien());
        thongTinNguoiMua.setBounds(50, 0, 500, 30);
        thongTinNguoiMua.setFont(new Font("Arial", Font.BOLD, 20));
        add(thongTinNguoiMua);

        JLabel ten = new JLabel("Tên hàng");
        JLabel maCs = new JLabel("Mã cơ sở");
        JLabel SL = new JLabel("Số lượng");
        JLabel giaTien = new JLabel("Giá");
        ten.setFont(new Font("Arial", Font.BOLD, 14));
        maCs.setFont(new Font("Arial", Font.BOLD, 14));
        SL.setFont(new Font("Arial", Font.BOLD, 14));
        giaTien.setFont(new Font("Arial", Font.BOLD, 14));
        noiDung.add(ten);
        noiDung.add(maCs);
        noiDung.add(SL);
        noiDung.add(giaTien);
        int tongTien = 0;
        for(int i=0;i<ds.size();i++)
        {
            JLabel tenHang = new JLabel(ds.get(i).getTenHangHoa());
            JLabel coSo = new JLabel(ds.get(i).getMaCoSo());
            JLabel soLuong = new JLabel(String.valueOf(ds.get(i).getSoLuong()));
            JLabel gia = new JLabel(String.valueOf(ds.get(i).getGia()/1000)+"K");
            tenHang.setFont(new Font("Arial", Font.BOLD, 14));
            coSo.setFont(new Font("Arial", Font.BOLD, 14));
            soLuong.setFont(new Font("Arial", Font.BOLD, 14));
            gia.setFont(new Font("Arial", Font.BOLD, 14));
            noiDung.add(tenHang);
            noiDung.add(coSo);
            noiDung.add(soLuong);
            noiDung.add(gia);
            tongTien+=ds.get(i).getGia();
        }
        JScrollPane cuon = new JScrollPane(noiDung);
        int cao = 40*ds.size();
        if(cao >= 350) cao = 350;
        cuon.setBounds(0, 40, 650,cao);
        add(cuon);
        JLabel tongTienlb = new JLabel("Tổng: "+tongTien/1000 +"K");
        tongTienlb.setBounds(375, 370, 300, 30);
        tongTienlb.setFont(new Font("Arial", Font.BOLD, 20));
        add(tongTienlb);
        setVisible(true);
    }
}
