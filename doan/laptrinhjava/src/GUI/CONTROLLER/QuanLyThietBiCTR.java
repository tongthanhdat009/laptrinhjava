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

import DTO.MayChay;
import javax.swing.border.LineBorder;


public class QuanLyThietBiCTR extends JPanel {
    public QuanLyThietBiCTR() {
        setLayout(null);
        setSize(1200,900);
        setBackground(new Color(241, 255, 250));
        GiaoDien();
    }
    public void GiaoDien() {
        removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
        revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
        repaint(); // Vẽ lại JPanel
        setLayout(null);
        JLabel tieude = new JLabel("Quản lý thiết bị");
        tieude.setBounds(490, 20, 244, 40);
        tieude.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
        add(tieude);

        JPanel noiDung = new JPanel(null);
        noiDung.setBackground(new Color(241, 255, 250));
        noiDung.setBounds(0,100,1200,800);
        add(noiDung);

        JPanel ta = new JPanel(null);
        ta.setBorder(new LineBorder(new Color(0, 0, 0)));
        ta.setBounds(50,0,525,300);
        ta.setBackground(new Color(118, 247, 191));
        JLabel talb = new JLabel("Tạ");
        talb.setForeground(new Color(235, 235, 235));
        talb.setFont(new Font("Times New Roman", Font.PLAIN, 200));
        talb.setBounds(288,66,237,234);
        ta.add(talb);
        noiDung.add(ta);
        
        ImageIcon taLogo = new ImageIcon("src/asset/img/icon/ta-logo.png");
        Image scaleTaLogoIcon = taLogo.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        JLabel logoTaLB = new JLabel("");
        logoTaLB.setBounds(0, 0, 246, 234);
        logoTaLB.setIcon(new ImageIcon(scaleTaLogoIcon));
        
        ta.add(logoTaLB);

        JPanel mayChay = new JPanel();
        mayChay.setBorder(new LineBorder(new Color(0, 0, 0)));
        mayChay.setBounds(625,0,525,300);
        mayChay.setBackground(new Color(145, 229, 229));
        noiDung.add(mayChay);
        mayChay.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Máy Chạy");
        lblNewLabel.setForeground(new Color(238, 238, 238));
        lblNewLabel.setBounds(108, 107, 429, 142);
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 75));
        mayChay.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src\\asset\\img\\icon\\MayChay-logo.png"));
        lblNewLabel_1.setBounds(118, 0, 407, 300);
        mayChay.add(lblNewLabel_1);

        JPanel xa = new JPanel();
        xa.setBorder(new LineBorder(new Color(0, 0, 0)));
        xa.setBounds(50,350,525,300);
        xa.setBackground(new Color(95, 221, 157));
        noiDung.add(xa);
        xa.setLayout(null);
        
        ImageIcon xaLogo = new ImageIcon("src/asset/img/icon/xa-logo.png");
        Image scaleXaLogoIcon = xaLogo.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        JLabel xaLB = new JLabel("Xà ");
        xaLB.setForeground(new Color(255, 255, 255));
        xaLB.setFont(new Font("Times New Roman", Font.PLAIN, 175));
        xaLB.setBounds(0, 0, 280, 133);
        xa.add(xaLB);
        
        JLabel hinhXaLB = new JLabel("");
        hinhXaLB.setBounds(245, 0, 280, 300);
        hinhXaLB.setIcon(new ImageIcon(scaleXaLogoIcon));
        xa.add(hinhXaLB);

        
        ImageIcon khacLogo = new ImageIcon("src/asset/img/icon/khac-logo.png");
        Image scaleKhacLogoIcon = khacLogo.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        JPanel khac = new JPanel();
        khac.setBorder(new LineBorder(new Color(0, 0, 0)));
        khac.setBounds(625,350,525,300);
        khac.setBackground(new Color(145, 249, 229));
        noiDung.add(khac);
        khac.setLayout(null);
        
        JLabel khacLogoLB = new JLabel("");
        khacLogoLB.setIcon(new ImageIcon("src\\asset\\img\\icon\\khac-logo.png"));
        khacLogoLB.setBounds(258, 0, 267, 300);
        khac.add(khacLogoLB);
        
        JLabel lblNewLabel_3 = new JLabel("Khác");
        lblNewLabel_3.setBounds(0, 150, 329, 150);
        khac.add(lblNewLabel_3);
        lblNewLabel_3.setForeground(new Color(240, 248, 255));
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 125));

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
        xa.addMouseListener(new MouseAdapter() {
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
                  QuanLyXa giaoDienXa = new QuanLyXa();
                  noiDung.add(giaoDienXa);
              }
          });
          mayChay.addMouseListener(new MouseAdapter() {
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
                  QuanLyMayChay giaoDienMayChay = new QuanLyMayChay();
                  noiDung.add(giaoDienMayChay);
              }
          });
          khac.addMouseListener(new MouseAdapter() {
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
                  QuanLyThietBiKhac giaoDienKhac = new QuanLyThietBiKhac();
                  noiDung.add(giaoDienKhac);
              }
          });
    }
}
