import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUILogin extends JFrame implements ActionListener{
    // private dsHoiVien dsHoiVien1 = new dsHoiVien();
    private JTextField tenTK = new JTextField();
    private JPasswordField mk = new JPasswordField();
    private ImageIcon icon = new ImageIcon("giphy.gif");
    public GUILogin()
    {
        // docDuLieu();
        setBounds(500,500,775,250);
        setLayout(new GridLayout(1,1,5,0));

        JPanel TTDN = new JPanel();
        TTDN.setLayout(new BorderLayout());
        JPanel header = new JPanel();
        header.setLayout(new FlowLayout());
        JLabel tieuDe = new JLabel("Đăng nhập");
        tieuDe.setFont(new Font("Arial",Font.BOLD,30));
        header.add(tieuDe);
        TTDN.add(header, BorderLayout.NORTH);

        JPanel TTDNMain = new JPanel();
        TTDNMain.setLayout(new GridLayout(2,2,0,10));
        tenTK.setPreferredSize(new Dimension(200,50));
        JLabel tenDangNhap = new JLabel("Tên đăng nhập:");
        tenDangNhap.setFont(new Font("Arial",Font.ITALIC,20));
        JLabel matKhau = new JLabel("Mật khẩu:");
        matKhau.setFont(new Font("Arial",Font.ITALIC,20));
        TTDNMain.add(tenDangNhap);
        TTDNMain.add(tenTK);
        TTDNMain.add(matKhau);
        TTDNMain.add(mk);
        TTDN.add(TTDNMain,BorderLayout.CENTER);

        JButton dangNhap = new JButton("Dang Nhap");
        JButton dangKy = new JButton("Dang ky");
        dangNhap.addActionListener(this);
        JPanel TTDNSub = new JPanel();
        TTDNSub.setLayout(new FlowLayout());
        TTDNSub.add(dangKy);
        TTDNSub.add(dangNhap);
        TTDN.add(TTDNSub,BorderLayout.SOUTH);

        JLabel anh = new JLabel();
        anh.setIcon(icon);

        add(TTDN);
        add(anh);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {

        if(e.getActionCommand().equals("Dang Nhap"))
        {
        //     boolean flag = false;
            String fieldTenDangNhap = tenTK.getText();
            String fieldMatKhau =String.valueOf(mk.getPassword()); 
            if(fieldMatKhau.isEmpty()||fieldTenDangNhap.isEmpty()) JOptionPane.showMessageDialog(null,"Thiếu thông tin đăng nhập");
        //     int i = 0;
        //     while(flag==false&&i<dsHoiVien1.dshv.size())
        //     {
        //         if(dsHoiVien1.dshv[i].getTaiKhoanHoiVien().equals(fieldTenDangNhap))
        //         {
        //             flag = true;
        //             if(dsHoiVien1.dshv[i].getMatKhauHoiVien.equals(fieldMatKhau))
        //             JOptionPane.showMessageDialog(null,"Đăng nhập thành công");
        //             else JOptionPane.showMessageDialog(null,"Sai mật khẩu");
        //         }
        //     }
        //     if(flag == false) JOptionPane.showMessageDialog(null,"Người dùng không tồn tại");
        }
    }
    // public void docDuLieu()
    // {
    //     dsHoiVien1.themHoiVien();
    //     dsHoiVien1.themHoiVien();
    // }
    public static void main(String[] args)
    {
        new GUILogin();
    }
}
