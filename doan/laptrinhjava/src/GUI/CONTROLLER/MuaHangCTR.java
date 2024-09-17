package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;


import BLL.BLLQuanLyDanhSach;
import DTO.ThongTinChiTietHangHoa;

public class MuaHangCTR extends JPanel {
    public MuaHangCTR()
    {
        setLayout(null);
        setSize(1200,900);
        setBackground(new Color(241, 255, 250));
        giaoDien();
    }
    public void giaoDien()
    {
        BLLQuanLyDanhSach ql = new BLLQuanLyDanhSach();
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

        int x = 0;
        JLabel tenHangHoalb = new JLabel("Tên hàng hóa: ");  tenHangHoalb.setBounds(x+20, 20, 100, 20); x+=120+10;
        JTextField textTenHangHoa = new JTextField(); textTenHangHoa.setBounds(x, 20, 100, 20); x+=150;
        JLabel loailb = new JLabel("Loại hàng hóa: "); loailb.setBounds(x,20,100,20); x+=120;
        JComboBox cbLoai = new JComboBox<>(dsLoai); cbLoai.setBounds(x, 20, 100, 20); x+=150;
        JLabel coSo = new JLabel("Tên cơ sở"); coSo.setBounds(x, 20, 100, 20); x+=110;
        JComboBox cbCoSo = new JComboBox<>(dsMaCoSo); cbCoSo.setBounds(x,20,100,20);
        cbCoSo.removeItemAt(0);

        loc.add(tenHangHoalb);
        loc.add(textTenHangHoa);
        loc.add(loailb);
        loc.add(cbLoai);
        loc.add(coSo);
        loc.add(cbCoSo);
        add(loc);

        ArrayList<ThongTinChiTietHangHoa> ds = new ArrayList<>();
        ds = ql.layDSBanHang(cbCoSo.getSelectedItem().toString());
        xuatSanPham(ds);
    }
    public void xuatSanPham(ArrayList<ThongTinChiTietHangHoa> ds)
    {
        int soLuongHang = ds.size();
        JPanel banHang = new JPanel();
        banHang.setBackground(Color.WHITE);
        banHang.setPreferredSize(new Dimension(1200, (soLuongHang/3 + 1) * 450 + 10));
        banHang.setLayout(null);
        
        int x = 50, y = -440;
        for (int i = 0; i < soLuongHang; i++) {
            if(i%3==0)
            {
                x=50;
                y+=450;
            }
            JPanel thongTinSanPham = new JPanel();
            thongTinSanPham.setBackground(Color.WHITE);
            thongTinSanPham.setBounds(x, y, 300, 400);
            thongTinSanPham.setLayout(null);
            thongTinSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
    
            JPanel anh = new JPanel(null);
            anh.setBounds(5,5,290,300);
            ImageIcon anhThietBi = new ImageIcon(ds.get(i).getHinhAnh());
            Image chinhAnhThietBi = anhThietBi.getImage().getScaledInstance(290, 300,Image.SCALE_DEFAULT);
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
            giahhpn.setBounds(5, 295+30, 290, 20);
            JLabel gialb = new JLabel(String.valueOf(ds.get(i).getGiaBan()));
            giahhpn.setBackground(Color.WHITE);

            giahhpn.add(gialb);
            thongTinSanPham.add(giahhpn);
            tenhhpn.add(tenlb);
            thongTinSanPham.add(tenhhpn);
            thongTinSanPham.add(anh);
            banHang.add(thongTinSanPham);
            x+=375;
            int index = i;
            thongTinSanPham.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e)
                {
                    new ThongTinHangHoa(ds.get(index).getMaHangHoa(),ds.get(index).getCoSo(),ds.get(index).getHinhAnh(),ds.get(index).getSoLuong());
                }
            });
        }
        JScrollPane scrollPane = new JScrollPane(banHang);
        scrollPane.setBounds(0, 160, 1190, 760);
        add(scrollPane);
    }
}
