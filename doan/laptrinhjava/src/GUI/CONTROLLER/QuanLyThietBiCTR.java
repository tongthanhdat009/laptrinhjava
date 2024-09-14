package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class QuanLyThietBiCTR extends JPanel {
    public QuanLyThietBiCTR() {
        setLayout(null);
        setSize(1200,900);
        setBackground(Color.white);
        GiaoDien();
    }
    public void GiaoDien() {
        removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        repaint(); // Vẽ lại JPanel
        setLayout(null);
        JLabel tieude = new JLabel("Quản lý thiết bị");
        tieude.setBounds(490, 20, 300, 40);
        tieude.setFont(new Font("Times New Roman",1,35));
        add(tieude);

        JPanel noiDung = new JPanel(null);
        noiDung.setBounds(0,100,1200,800);
        add(noiDung);

        JPanel ta = new JPanel(null);
        ta.setBounds(50,0,525,300);
        ta.setBackground(Color.BLUE);
        JLabel talb = new JLabel("Tạ");
        talb.setFont(new Font("Times New Roman",1,50));
        talb.setBounds(220,100,100,100);
        ta.add(talb);
        noiDung.add(ta);

        JPanel mayChay = new JPanel();
        mayChay.setBounds(625,0,525,300);
        mayChay.setBackground(Color.BLUE);
        noiDung.add(mayChay);

        JPanel xa = new JPanel();
        xa.setBounds(50,350,525,300);
        xa.setBackground(Color.BLUE);
        noiDung.add(xa);

        JPanel khac = new JPanel();
        khac.setBounds(625,350,525,300);
        khac.setBackground(Color.BLUE);
        noiDung.add(khac);

        ta.addMouseListener(new MouseAdapter() {
          @Override
            public void mouseClicked(MouseEvent e) {
                noiDung.removeAll();
                noiDung.revalidate(); // Cập nhật layout
                noiDung.repaint();    // Vẽ lại panel
                JButton back = new JButton("Quay lại");
                back.setBounds(0, 0, 100, 100);
                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        GiaoDien();
                    }
                });
                noiDung.add(back);
                QuanLyTa giaoDienTa = new QuanLyTa();
                noiDung.add(giaoDienTa);
            }
        });
    }
}
