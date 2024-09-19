package GUI.CONTROLLER;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import BLL.TuanBLL;

public class ThongTinHangHoa extends JFrame {
    TuanBLL bll = new TuanBLL();
    public ThongTinHangHoa(String maHangHoa, String maCoSo,String anh, int soLuong, String tk)
    {
        super("Thông tin hàng hóa");
        setSize(650, 510);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        ImageIcon anhThietBi = new ImageIcon(anh);
        Image chinhAnhThietBi = anhThietBi.getImage().getScaledInstance(320, 360,Image.SCALE_DEFAULT);
        anhThietBi = new ImageIcon(chinhAnhThietBi);
        JLabel anhLb = new JLabel(anhThietBi); anhLb.setBounds(0, 0, 320, 360);
        add(anhLb);
        
        String thongTinst = bll.layThongTinChiTietHangHoa(maHangHoa, maCoSo);
        System.out.println(thongTinst);
        JPanel thongTinPn = new JPanel(null);
        thongTinPn.setBackground(Color.WHITE);
        thongTinPn.setBounds(320, 0, 320, 360);
        int index = thongTinst.indexOf('\n');
        String tenHang = thongTinst.substring(0, index);
        thongTinst = thongTinst.substring(index+1);
        int lastIndex = thongTinst.lastIndexOf('\n');
        String gia = thongTinst.substring(lastIndex+1);
        thongTinst = thongTinst.substring(0, lastIndex);

        JLabel tenLb = new JLabel(tenHang);
        tenLb.setBounds(10, 0, 300, 30);
        tenLb.setFont(new Font("Arial", Font.BOLD, 27));

        JLabel thongTinPhu = new JLabel("<html>" + thongTinst.replaceAll("\n", "<br>") + "</html>");
        thongTinPhu.setBounds(10,50, 300, 250);
        thongTinPhu.setFont(new Font("Arial", Font.BOLD, 17));
        thongTinPhu.setHorizontalAlignment(SwingConstants.LEFT);
        thongTinPhu.setVerticalAlignment(SwingConstants.TOP);

        JLabel gialb = new JLabel(gia);
        gialb.setBounds(10, 320, 300, 30);
        gialb.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel soLuonglb = new JLabel("Số lượng: "); soLuonglb.setBounds(80, 400, 120, 30);
        soLuonglb.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField soLuongtf = new JTextField(); soLuongtf.setBounds(200,400,30,30);

        JButton themVaoGio = new JButton("Thêm vào giỏ hàng");
        themVaoGio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(soLuongtf.getText().equals("")) JOptionPane.showMessageDialog(null, "Chưa nhập số lượng");
                else
                {
                    if(!soLuongtf.getText().matches("\\d{1,18}$")) JOptionPane.showMessageDialog(null, "Sai số lượng");
                    else 
                    {
                        int soLuongMua = Integer.parseInt(soLuongtf.getText());
                        String kq = bll.themVaoGioHang(maHangHoa,tk,maCoSo,soLuongMua);
                        JOptionPane.showMessageDialog(null, kq);
                    }
                }
            }
        });
        themVaoGio.setBounds(400,390,150,70);
        add(themVaoGio);
        add(soLuonglb);
        add(soLuongtf);
        thongTinPn.add(gialb);
        thongTinPn.add(tenLb);
        thongTinPn.add(thongTinPhu);
        add(thongTinPn);
        setVisible(true);
    }
}
