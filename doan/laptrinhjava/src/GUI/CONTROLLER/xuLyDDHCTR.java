package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import BLL.BLLQuanLyDanhSach;
import DTO.DTODuyetDonHang;
import DTO.HoaDon;

public class xuLyDDHCTR {
	//font
    Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm
	public void XuLyDuyetDonHang(ArrayList<HoaDon> ds, BLLQuanLyDanhSach bllQuanLyDanhSach, JPanel rightPanel)
    {
        rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        rightPanel.repaint(); // Vẽ lại JPanel
        rightPanel.setLayout(null);
    
        JPanel canGiua = new JPanel(new FlowLayout());
        canGiua.setBounds(5,5,rightPanel.getWidth(),55);
        canGiua.setBackground(new Color(241,255,250));
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
                XuLyDuyetDonHang(dsTimKiem,bllQuanLyDanhSach,rightPanel);
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
}
