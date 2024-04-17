package GUI;

import javax.swing.*;

import BLL.BLLDangNhap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogin extends JFrame implements ActionListener{
    JTextField username = new JTextField();
    JPasswordField pass = new JPasswordField();
    JButton go;
    public GUILogin() {
            setSize(1600, 900);
            setLocationRelativeTo(null);
            setLayout(null);
    
            Panel dangNhap = new Panel();
            dangNhap.setLayout(null);
            dangNhap.setBounds(0, 0, 400, 900);
            dangNhap.setBackground(Color.WHITE);
    
            ImageIcon logo = new ImageIcon("src/asset/img/label/logo.png");
            JLabel labelLogo = new JLabel(logo);
            labelLogo.setBounds(200 - logo.getIconWidth()/2 ,0,logo.getIconWidth(),logo.getIconHeight());
            dangNhap.add(labelLogo);
    
            JLabel tieuDe = new JLabel("ĐĂNG NHẬP");
            tieuDe.setFont(new Font("Arial",Font.BOLD, 27));
            tieuDe.setBounds(120, 200, 200, 100);
            dangNhap.add(tieuDe);
    
            JPanel nhapLieu = new JPanel(new GridLayout(4,1,0,0));
            nhapLieu.setBounds(40,280,320,150);
            nhapLieu.setBackground(Color.WHITE);

            username.setToolTipText("Tên đăng nhập");
            pass.setToolTipText("Mật khẩu");
            nhapLieu.add(new JLabel("Tên tài khoản"));
            nhapLieu.add(username);
            nhapLieu.add(new JLabel("Mật khẩu"));
            nhapLieu.add(pass);
            
            JPanel dangNhapKieuKhac = new JPanel(new GridLayout(1,4,10,0));
            dangNhapKieuKhac.setBounds(40,450,320,30);
            dangNhapKieuKhac.setBackground(Color.WHITE);
            ImageIcon imgFb = new ImageIcon("src/asset/img/icon/fb-icon.png");
            ImageIcon imgGg = new ImageIcon("src/asset/img/icon/gg-icon.png");
            ImageIcon imgIc = new ImageIcon("src/asset/img/icon/apple-icon.png");
            ImageIcon imgXb = new ImageIcon("src/asset/img/icon/xb-icon.png");
            JButton fb = new JButton(imgFb);
            fb.setBackground(Color.BLUE);
            JButton gg = new JButton(imgGg);
            gg.setBackground(Color.white);
            JButton ic = new JButton(imgIc);
            ic.setBackground(Color.black);
            JButton xb = new JButton(imgXb);
            xb.setBackground(new Color(0, 128, 0));
            fb.addActionListener(this);
            gg.addActionListener(this);
            ic.addActionListener(this);
            xb.addActionListener(this);
    
            dangNhapKieuKhac.add(fb);
            dangNhapKieuKhac.add(gg);
            dangNhapKieuKhac.add(ic);
            dangNhapKieuKhac.add(xb);
    
            dangNhap.add(nhapLieu);
            dangNhap.add(dangNhapKieuKhac);
    
            JButton dangKy = new JButton("ĐĂNG KÝ TÀI KHOẢN");
            dangKy.setBackground(Color.white);
            dangKy.setBounds(40, 500, 150, 30);
            dangKy.addActionListener(this);
            dangNhap.add(dangKy);
    
            ImageIcon backGround = new ImageIcon("src/asset/img/label/gym.jpg");
            JLabel imageBackground = new JLabel(backGround);
            imageBackground.setBounds(0, 0, backGround.getIconWidth(), backGround.getIconHeight());
    
            ImageIcon muiTenDi = new ImageIcon("src/asset/img/icon/muiten-icon.png");
            go = new JButton(muiTenDi);
            go.setBounds(200 - 75/2, 650, 80, 80);
            go.setBackground(Color.white);
            go.setBorder(null);
            go.addActionListener(this);
            dangNhap.add(go);
    
            Label title = new Label("PHÒNG GYM SGU");
            title.setFont(new Font("Arial",Font.BOLD,16));
            title.setBounds(127,800,200,30);
            dangNhap.add(title);
    
            JLabel moTa = new JLabel("Hãy chuẩn bị thay đổi cơ thể của bạn");
            moTa.setBounds(85,825,340,30);
            dangNhap.add(moTa);
    
            add(dangNhap);
            add(imageBackground);
    
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == go)
        {
            if(username.getText().isEmpty()||new String(pass.getPassword()).isEmpty()) JOptionPane.showMessageDialog(this, "Thiếu thông tin đăng nhập");
            else 
            {
                BLLDangNhap dangNhap = new BLLDangNhap();
                if(dangNhap.KiemTraDangNhap(username.getText(), new String(pass.getPassword())) == -2){
                    JOptionPane.showMessageDialog(this,"HỆ THỐNG ĐANG LỖI VUI LÒNG THỬ LẠI SAU");
                }
                else if(dangNhap.KiemTraDangNhap(username.getText(), new String(pass.getPassword())) == -1){
                    JOptionPane.showMessageDialog(this,"TÀI KHOẢN KHÔNG TỒN TẠI");
                }
                else if(dangNhap.KiemTraDangNhap(username.getText(), new String(pass.getPassword())) == 0){
                    JOptionPane.showMessageDialog(this,"Sai MẬT KHẨU");
                }
                else if(dangNhap.KiemTraDangNhap(username.getText(), new String(pass.getPassword())) == 1){
                    JOptionPane.showMessageDialog(this,"ĐĂNG NHẬP THÀNH CÔNG");
                }
                else if(dangNhap.KiemTraDangNhap(username.getText(), new String(pass.getPassword())) == 2){
                    new GUIAdmin();
                    dispose();
                }
            }
        }
        else if(e.getActionCommand().equals("ĐĂNG KÝ TÀI KHOẢN")){
            new GUISignup();
            dispose();
        }
        else JOptionPane.showMessageDialog(this,"Chưa năng hiện đang phát triển");
    }
    
    public static void main(String[] args) {
        new GUILogin();
    }
}
