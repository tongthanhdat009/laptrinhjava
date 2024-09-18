package GUI.CONTROLLER;


import javax.swing.JPanel;
import javax.swing.JPasswordField;

import BLL.BLLInformation;
import DTO.DTOQuyen;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class informationCTR extends JPanel{
	private static final long serialVersionUID = -7905422937456489628L;
	private BLLInformation bllInformation = new BLLInformation();
	private JPasswordField passwordTF;
	private ImageIcon noneAva = new ImageIcon("src/asset/img/avatar/jack.jpg");
    private Image scaleNoneAvaImage = noneAva.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
	public informationCTR(DTOTaiKhoan tk){
		this.setLayout(null);
		this.setBounds(0,0,1200,900);
		HoiVien thongTin = bllInformation.layThongTinNguoiDung(tk);

		//hiển thị tài khoản đăng nhập của hội viên
		JLabel accountLB = new JLabel("Tài khoản: "+tk.getTaiKhoan());
		accountLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		accountLB.setBounds(78, 469, 519, 35);
		add(accountLB);
		
		//hiển thị mật khẩu đăng nhập của hội viên
		JLabel passwordLB = new JLabel("Mật khẩu: ");
		passwordLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		passwordLB.setBounds(78, 515, 139, 50);
		add(passwordLB);
		
		//hiển thị tên hội viên
		JLabel userNameLB = new JLabel("Họ tên: "+thongTin.getHoten()+".");
		userNameLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		userNameLB.setBounds(506, 90, 485, 50);
		add(userNameLB);
		
		//hiển thị ngày sinh của hội viên
		JLabel birthLB = new JLabel("Ngày sinh:");
		birthLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		birthLB.setBounds(506, 150, 149, 50);
		add(birthLB);
		
		//hiển thị số điện thoại của hội viên
		JLabel phoneLB = new JLabel("Số điện thoại: "+thongTin.getSdt()+".");
		phoneLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		phoneLB.setBounds(506, 210, 343, 50);
		add(phoneLB);
		
		//hiển thị gmail của hội viên
		JLabel gmailLB = new JLabel("Gmail: "+thongTin.getMail()+".");
		gmailLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		gmailLB.setBounds(506, 270, 485, 50);
		add(gmailLB);
		
		//hiển thị ảnh logo góc phải
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(informationCTR.class.getResource("/asset/img/label/logo1.png")));
		lblNewLabel.setBounds(950, 647, 250, 279);
		add(lblNewLabel);
		
		//ngày tháng năm sinh
		JComboBox<Integer> dayCBB = new JComboBox<>();
		dayCBB.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dayCBB.setBounds(696, 150, 58, 42);
		add(dayCBB);
		
		JComboBox<Integer> monthCBB = new JComboBox<>();
		monthCBB.setFont(new Font("Times New Roman", Font.BOLD, 18));
		monthCBB.setBounds(793, 150, 58, 42);
		add(monthCBB);
		
		JComboBox<Integer> yearCBB = new JComboBox<>();
		yearCBB.setFont(new Font("Times New Roman", Font.BOLD, 18));
		yearCBB.setBounds(897, 150, 94, 42);
		add(yearCBB);
		
		for(int day=1; day<=31 ;day++){
            dayCBB.addItem(day);
        }

        dayCBB.setBackground(Color.white);
        dayCBB.setName("Day");
        
        for(int month=1; month<=12 ;month++){
            monthCBB.addItem(month);
        }
        monthCBB.setBackground(Color.white);
        monthCBB.setName("Month");

        for(int year=2024;year>=1900;year--){
            yearCBB.addItem(year);
        }
        yearCBB.setBackground(Color.white);
        yearCBB.setName("Year");
        yearCBB.setSelectedItem(2000);
        
        JLabel imgLB = new JLabel();
        imgLB.setBounds(78, 90, 250, 250);
        imgLB.setIcon(new ImageIcon(scaleNoneAvaImage));
        add(imgLB);
        
        //nút đổi ảnh đại diện
        JButton changeAvarBTN = new JButton("Đổi ảnh đại diện");
        changeAvarBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser imgChooser = new JFileChooser();
        	}
        });
        changeAvarBTN.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        changeAvarBTN.setBounds(78, 380, 234, 50);
        add(changeAvarBTN);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 1200, 62);
        add(titlePanel);
        JLabel title = new JLabel("Thông tin cá nhân");
        titlePanel.add(title);
        title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
        
        
        
        JPanel changePassPanel = new JPanel();
        changePassPanel.setBounds(227, 515, 403, 163);
        add(changePassPanel);
        changePassPanel.setLayout(null);
        
        passwordTF = new JPasswordField();
        passwordTF.setFont(new Font("Times New Roman", Font.BOLD, 23));
        passwordTF.setBounds(0, 0, 199, 50);
        changePassPanel.add(passwordTF);
        passwordTF.setColumns(10);
        passwordTF.setText(tk.getMatKhau().trim());
        passwordTF.setEchoChar('●');
        
//		hiển thị hoặc ẩn mật khẩu bằng checkBox
        JCheckBox showPassCheck = new JCheckBox("Hiển thị mật khẩu");
        showPassCheck.setBounds(0, 51, 160, 23);
        changePassPanel.add(showPassCheck);
        showPassCheck.setFont(new Font("Times New Roman", Font.BOLD, 15));
        showPassCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassCheck.isSelected()) {
                	passwordTF.setEchoChar((char) 0); // Hiện mật khẩu
                } else {
                	passwordTF.setEchoChar('●'); // Ẩn mật khẩu
                }
            }
        });
        
        //nút đổi mật khẩu
        JButton btnNewButton = new JButton("Đổi mật khẩu");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(209, 0, 186, 50);
        changePassPanel.add(btnNewButton);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
        
     // Listener thay đổi tháng và năm để cập nhật ngày
        ActionListener updateDaysListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDays(dayCBB, monthCBB, yearCBB);
            }
        };
        monthCBB.addActionListener(updateDaysListener);
        yearCBB.addActionListener(updateDaysListener);

	}
	
	private static void updateDays(JComboBox<Integer> dayCBB, JComboBox<Integer> monthCBB, JComboBox<Integer> yearCBB) {
        int selectedMonth = (int) monthCBB.getSelectedItem();
        int selectedYear = (int) yearCBB.getSelectedItem();

        // Lấy số ngày tối đa của tháng và năm đã chọn
        int maxDays = getDaysInMonth(selectedMonth, selectedYear);

        // Lưu lại ngày được chọn trước đó
        Integer selectedDay = (Integer) dayCBB.getSelectedItem();

        // Xóa tất cả các mục trong JComboBox của ngày
        dayCBB.removeAllItems();

        // Thêm lại các ngày dựa trên tháng và năm đã chọn
        for (int day = 1; day <= maxDays; day++) {
            dayCBB.addItem(day);
        }

        // Đặt lại ngày đã chọn trước đó nếu có thể
        if (selectedDay != null && selectedDay <= maxDays) {
            dayCBB.setSelectedItem(selectedDay);
        }
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30; // Các tháng 4, 6, 9, 11 có 30 ngày
            case 2:
                if (isLeapYear(year)) {
                    return 29; // Tháng 2 năm nhuận có 29 ngày
                } else {
                    return 28; // Tháng 2 năm thường có 28 ngày
                }
            default:
                return 31; // Các tháng còn lại có 31 ngày
        }
    }
       
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {
		new informationCTR(new DTOTaiKhoan("TK001","TKHV001", "MKHV001","Q0001"));
	}
}