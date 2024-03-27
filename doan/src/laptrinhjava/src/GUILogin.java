import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class GUILogin extends JFrame implements ActionListener{
    private JTextField tenTK = new JTextField();
    private JPasswordField mk = new JPasswordField();

    ImageIcon icon = new ImageIcon("doan/src/laptrinhjava/src/asset/gif/login.gif");
    Image scaleImage = icon.getImage().getScaledInstance(775/2 + 5, 265,Image.SCALE_DEFAULT);

    String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=DAJAVA;encrypt=false";
    String username = "sa"; String password= "minhtuan123";
    Connection con; 
    Statement stmt;

    public GUILogin()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dbUrl, username, password);
            stmt = con.createStatement();
    
            // docDuLieu();
            setSize(new Dimension (775,300));
            setLocationRelativeTo(null);
            setLayout(new GridLayout(1,2,5,0));
    
            JPanel TTDN = new JPanel();
            TTDN.setLayout(new BorderLayout());
            
            JPanel header = new JPanel();
            header.setLayout(new FlowLayout());
    
            
            JLabel tieuDe = new JLabel("Đăng nhập");
            tieuDe.setFont(new Font("Arial",Font.BOLD,30));
            header.add(tieuDe);
            // header.setBackground(new Color(900));
            TTDN.add(header, BorderLayout.NORTH);
    
            JPanel TTDNMain = new JPanel();
            TTDNMain.setLayout(null);
    
            tenTK.setPreferredSize(new Dimension(175,30));
    
            JLabel tenDangNhap = new JLabel("Tên đăng nhập:");
            tenDangNhap.setFont(new Font("Arial",Font.ITALIC,20));
            tenDangNhap.setBounds(5,10,150,30);
            tenTK.setBounds(160,10,175,30);
    
            JLabel matKhau = new JLabel("Mật khẩu:");
            matKhau.setFont(new Font("Arial",Font.ITALIC,20));
            matKhau.setBounds(5,75,150,30);
            mk.setBounds(160,75,175,30);
            
            // TTDNMain.setBackground(new Color(900));
            TTDNMain.add(tenDangNhap);
            TTDNMain.add(tenTK);
            TTDNMain.add(matKhau);
            TTDNMain.add(mk);
            TTDN.add(TTDNMain,BorderLayout.CENTER);
    
            JButton dangNhap = new JButton("Dang Nhap");
            dangNhap.setPreferredSize(new Dimension(100,30));
            dangNhap.addActionListener(this);
            
            JButton dangKy = new JButton("Dang ky");
            dangKy.setPreferredSize(new Dimension(100,30));
    
            JPanel TTDNSub = new JPanel();
            TTDNSub.setLayout(new FlowLayout());
            TTDNSub.add(dangKy);
            TTDNSub.add(dangNhap);
            TTDN.add(TTDNSub,BorderLayout.SOUTH);
            // TTDNSub.setBackground(new Color(900));
    
            // JPanel anhPanel = new JPanel();
            JLabel anh = new JLabel();
            anh.setIcon(new ImageIcon(scaleImage));
            // anhPanel.add(anh);
            add(TTDN);
            add(anh);
    
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            // getContentPane().setBackground(new Color(900));
            setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dang Nhap"))
        {
            String fieldTenDangNhap = tenTK.getText();
            String fieldMatKhau =String.valueOf(mk.getPassword()); 
            if(fieldMatKhau.isEmpty()||fieldTenDangNhap.isEmpty()) JOptionPane.showMessageDialog(null,"Thiếu thông tin đăng nhập");
            else
            {
                try
                {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM HOIVIEN WHERE TK ='"+fieldTenDangNhap+"'");
                    if(rs.next())
                    {
                        if(rs.getString("MK").equals(fieldMatKhau)) JOptionPane.showMessageDialog(null,"CHUYỂN QUA GUI HỘI VIÊN LOAD 99%");
                        else JOptionPane.showMessageDialog(null,"SAI MẬT KHẨU");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"TK không tồn tại");
                    }
                }catch(Exception ex)
                {
                    System.out.println("hello");
                }
            }
        }
    }
    public static void main(String[] arg)
    {
        new GUILogin();
    }
}
