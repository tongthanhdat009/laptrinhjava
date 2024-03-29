
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class newGUILogin extends JFrame implements ActionListener{
    JTextField username = new JTextField();
    JPasswordField pass = new JPasswordField();
    JButton go;
    // String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=DAJAVA;encrypt=false";
    // String userName = "sa"; String password= "minhtuan123";
    // Connection con; 
    // Statement stmt;
    public newGUILogin() {
        try
        {
            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // con = DriverManager.getConnection(dbUrl, userName, password);
            // stmt = con.createStatement();

            setSize(1600, 900);
            setLocationRelativeTo(null);
            setLayout(null);
    
            Panel dangNhap = new Panel();
            dangNhap.setLayout(null);
            dangNhap.setBounds(0, 0, 400, 900);
            dangNhap.setBackground(Color.WHITE);
    
            ImageIcon logo = new ImageIcon("doan/src/laptrinhjava/src/asset/img/logo.png");
            JLabel labelLogo = new JLabel(logo);
            labelLogo.setBounds(200 - logo.getIconWidth()/2 ,0,logo.getIconWidth(),logo.getIconHeight());
            dangNhap.add(labelLogo);
    
            JLabel tieuDe = new JLabel("ĐĂNG NHẬP");
            tieuDe.setFont(new Font("Arial",Font.BOLD, 27));
            tieuDe.setBounds(120, 200, 200, 100);
            dangNhap.add(tieuDe);
    
            JPanel nhapLieu = new JPanel(new GridLayout(4,1,0,0));
            nhapLieu.setBounds(40,280,320,150);
    
            username.setToolTipText("Tên đăng nhập");
            pass.setToolTipText("Mật khẩu");
            nhapLieu.add(new JLabel("Tên tài khoản"));
            nhapLieu.add(username);
            nhapLieu.add(new JLabel("Mật khẩu"));
            nhapLieu.add(pass);
            
            JPanel dangNhapKieuKhac = new JPanel(new GridLayout(1,4,10,0));
            dangNhapKieuKhac.setBounds(40,450,320,30);
            ImageIcon imgFb = new ImageIcon("doan/src/laptrinhjava/src/asset/img/button fb.png");
            ImageIcon imgGg = new ImageIcon("doan/src/laptrinhjava/src/asset/img/button gg.png");
            ImageIcon imgIc = new ImageIcon("doan/src/laptrinhjava/src/asset/img/button ic.png");
            ImageIcon imgXb = new ImageIcon("doan/src/laptrinhjava/src/asset/img/button xb.png");
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
    
            ImageIcon backGround = new ImageIcon("doan/src/laptrinhjava/src/asset/img/gym.jpg");
            JLabel imageBackground = new JLabel(backGround);
            imageBackground.setBounds(0, 0, backGround.getIconWidth(), backGround.getIconHeight());
    
            ImageIcon muiTenDi = new ImageIcon("doan/src/laptrinhjava/src/asset/img/mui ten.png");
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
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        // if(e.getSource() == go)
        // {
        //     if(username.getText().isEmpty()||new String(pass.getPassword()).isEmpty()) JOptionPane.showMessageDialog(this, "Thiếu thông tin đăng nhập");
        //     else 
        //     {
        //         try
        //         {
        //             ResultSet rs = stmt.executeQuery("SELECT * FROM HOIVIEN WHERE TK ='" + username.getText() + "'");
        //             if(rs.next())
        //             {
        //                 if(rs.getString("MK").equals(new String(pass.getPassword()))) JOptionPane.showMessageDialog(this, "Đang chuyển vào GUI hội viên");
        //                 else JOptionPane.showMessageDialog(this, "Sai mật khẩu");
        //             }
        //             else JOptionPane.showMessageDialog(this, "Tên tài khoản không tồn tại");

        //         }catch(Exception ex)
        //         {
        //             System.out.println(ex);
        //         }
        //     }
        // }
        // else
        // {
        //     JOptionPane.showMessageDialog(this,"Chưa năng hiện đang phát triển");
        // }
    }
    public static void main(String[] args) {
        new newGUILogin();
    }
}
