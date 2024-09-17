package GUI;

import javax.swing.*;
import javax.xml.crypto.Data;

import BLL.BLLDangNhap;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DTOTaiKhoan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUILogin extends JFrame implements ActionListener{
    JTextField username = new JTextField();
    JPasswordField pass = new JPasswordField();
    BLLDangNhap dangNhap = new BLLDangNhap();
    JButton go;
    public GUILogin() {
            setSize(1600, 900);
            setLocationRelativeTo(null);
            getContentPane().setLayout(null);
    
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
            dangNhapKieuKhac.setBounds(40,474,320,30);
            dangNhapKieuKhac.setBackground(Color.WHITE);
            ImageIcon imgFb = new ImageIcon("src/asset/img/icon/fb-icon.png");
            ImageIcon imgGg = new ImageIcon("src/asset/img/icon/gg-icon.png");
            ImageIcon imgIc = new ImageIcon("src/asset/img/icon/apple-icon.png");
            ImageIcon imgXb = new ImageIcon("src/asset/img/icon/xb-icon.png");
            JButton gg = new JButton(imgGg);
            gg.setBackground(Color.white);
            JButton ic = new JButton(imgIc);
            ic.setBackground(Color.black);
            JButton xb = new JButton(imgXb);
            xb.setBackground(new Color(0, 128, 0));
            gg.addActionListener(this);
            ic.addActionListener(this);
            xb.addActionListener(this);
            dangNhapKieuKhac.add(gg);
            JButton fb = new JButton(imgFb);
            dangNhapKieuKhac.add(fb);
            fb.setBackground(Color.BLUE);
            fb.addActionListener(this);
            dangNhapKieuKhac.add(ic);
            dangNhapKieuKhac.add(xb);
    
            dangNhap.add(nhapLieu);
            dangNhap.add(dangNhapKieuKhac);
    
            JButton dangKy = new JButton("ĐĂNG KÝ TÀI KHOẢN");
            dangKy.setBackground(Color.white);
            dangKy.setBounds(40, 441, 150, 22);
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
    
            getContentPane().add(dangNhap);
            getContentPane().add(imageBackground);
    
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
                String trangThaiDangNhap;
                trangThaiDangNhap = dangNhap.KiemTraDangNhap(username.getText(), new String(pass.getPassword()));
                if( trangThaiDangNhap.equals("Sai mật khẩu") ||
                    trangThaiDangNhap.equals("Tài khoản không tồn tại") ||
                    trangThaiDangNhap.equals("Lỗi mở database"))
                	{
                		JOptionPane.showMessageDialog(this,trangThaiDangNhap);
                		return;
                	}
                else {
                    String[] parts = trangThaiDangNhap.split(":");
                    DTOTaiKhoan tk = new DTOTaiKhoan(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
                    if(parts[3].trim().equals("Q0004")) { //mã quyền admin
                    	new GUIAdmin("Admin");
                    	dispose();
                    }
                    else if (parts[3].trim().equals("Q0001")){
//                    	tạo giao diện hội viên
                    	System.out.println("Đăng nhập thành công");
                    }
                    else {
//                    	if(dangNhap.kiemTraTaiKhoanCoSo(tk, trangThaiDangNhap))
                    	ArrayList<String> options = dangNhap.dsMaCS();
                        JComboBox<String> comboBox = new JComboBox<String>(options.toArray(new String[0]));

                        int result = JOptionPane.showConfirmDialog(null, comboBox, 
                                "Vui lòng chọn cơ sở", JOptionPane.OK_CANCEL_OPTION);

                        if (result == JOptionPane.OK_OPTION) {
                            String coSoDaChon = (String) comboBox.getSelectedItem();
                            if(dangNhap.kiemTraTaiKhoanCoSo(tk, coSoDaChon)) {
                            	JOptionPane.showMessageDialog(null, "Đăng nhập thành công!" + coSoDaChon);
    	                    	new GUIUser(tk,"text");
		                    	dispose();
                            	return;
                            }
                            else {
                            	JOptionPane.showMessageDialog(null, "Tài khoản của bạn không thuộc " + coSoDaChon);
                            	return;
                            }
                        }
                    }
                }
            }
        }
//        else if(e.getActionCommand().equals("ĐĂNG KÝ TÀI KHOẢN")){
//            new GUISignup();
//            dispose();
//        }
        else JOptionPane.showMessageDialog(this,"Chức năng hiện đang phát triển");
    }
    
    public static void main(String[] args) {
        new GUILogin();
    }
}
