package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import BLL.BLLDangKy;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class GUISignup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField jtf_user;
	private JTextField jtf_email;
	private JTextField jtf_phone;
	private JTextField jtf_mahv;
	private JPasswordField jtf_pass;
	private JPasswordField jtf_comfirm;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private ButtonGroup btn_grp;
	private JComboBox cb_day,cb_month,cb_year;
	private JTextField jtf_name;
	private BLLDangKy bllDangKy = new BLLDangKy();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISignup frame = new GUISignup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean isValidDate(int day,int month,int year) {
		boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
		int maxDayinMonth = 0;
		if(month == 2 && isLeapYear) {
			maxDayinMonth = 29;
		}
		else {
			switch (month) {
			case 1,3,5,7,8,10,12:
				maxDayinMonth = 31;
				break;
			case 4,6,9,11:
				maxDayinMonth = 30;
				break;
			default:
				return false;
			}
		}
		return day >= 1 && day <= maxDayinMonth;
	}

	public GUISignup() {
		setTitle("Đăng ký");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/asset/img/icon/Mayor-Gym-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUISignup.this.setLocationRelativeTo(null);

		setBounds(100, 100, 1129, 784);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setIcon(new ImageIcon("src/asset/img/icon/Kearone-Platecons-Adressbook-add-user.128.png"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel.setBounds(453, 10, 312, 128);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng kí");
		lblNewLabel_1.setIcon(new ImageIcon("src/asset/img/icon/Administrator-icon.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(80, 142, 180, 48);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ Email");
		lblNewLabel_1_1.setIcon(new ImageIcon("src/asset/img/icon/Mail-icon.png"));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(640, 142, 180, 42);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_2.setIcon(new ImageIcon("src/asset/img/icon/phone-icon.png"));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(292, 354, 180, 42);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã hội viên");
		lblNewLabel_1_3.setIcon(new ImageIcon("src/asset/img/icon/id-card-icon.png"));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(80, 259, 163, 42);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mật khẩu");
		lblNewLabel_1_4.setIcon(new ImageIcon("src/asset/img/icon/Dialog-Password-Lock-icon.png"));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(80, 592, 180, 47);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Xác thực mật khẩu");
		lblNewLabel_1_5.setIcon(new ImageIcon("src/asset/img/icon/Status-dialog-password-icon.png"));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(584, 592, 236, 47);
		getContentPane().add(lblNewLabel_1_5);
		
		jtf_user = new JTextField();
		jtf_user.setBounds(292, 156, 208, 30);
		getContentPane().add(jtf_user);
		jtf_user.setColumns(10);
		
		jtf_email = new JTextField();
		jtf_email.setColumns(10);
		jtf_email.setBounds(830, 156, 208, 30);
		getContentPane().add(jtf_email);
		
		jtf_phone = new JTextField();
		jtf_phone.setColumns(10);
		jtf_phone.setBounds(485, 353, 346, 30);
		getContentPane().add(jtf_phone);
		
		jtf_mahv = new JTextField();
		jtf_mahv.setColumns(10);
		jtf_mahv.setBounds(292, 259, 208, 30);
		getContentPane().add(jtf_mahv);
		
		jtf_pass = new JPasswordField();
		jtf_pass.setColumns(10);
		jtf_pass.setBounds(292, 605, 208, 30);
		getContentPane().add(jtf_pass);
		
		jtf_comfirm = new JPasswordField();
		jtf_comfirm.setColumns(10);
		jtf_comfirm.setBounds(830, 605, 208, 30);
		getContentPane().add(jtf_comfirm);
		
		JButton btn_login = new JButton("Đăng nhập");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUILogin login = new GUILogin();
				login.setVisible(true);
				dispose();
			}
		});
		btn_login.setBackground(new Color(11, 244, 122));
		btn_login.setIcon(new ImageIcon("src/asset/img/icon/Login-icon.png"));
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_login.setBounds(245, 670, 180, 70);
		getContentPane().add(btn_login);
		
		JButton btn_signup = new JButton("Đăng kí");
		btn_signup.setBackground(new Color(30, 210, 225));
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedDay = Integer.parseInt((String) cb_day.getSelectedItem());
		 		int selectedMonth = cb_month.getSelectedIndex() + 1;
				int selectedYear = Integer.parseInt((String) cb_year.getSelectedItem());
				int dk = JOptionPane.showConfirmDialog(GUISignup.this,"Bạn có muốn đăng kí","Comfirm", JOptionPane.YES_NO_OPTION);
				if(dk != JOptionPane.YES_OPTION) {
					return;
				}
				
				//Kiểm tra thông tin bị trống hay không
				if(jtf_user.getText().trim().equals("") ||jtf_email.getText().trim().equals("") || jtf_phone.getText().trim().equals("") || jtf_mahv.getText().trim().equals("") ||
	            	jtf_name.getText().trim().equals("") || jtf_pass.getText().trim().equals("") || jtf_comfirm.getText().trim().equals("")) {
	            	JOptionPane.showMessageDialog(GUISignup.this, "Thông tin không được để trống","Error",JOptionPane.ERROR_MESSAGE);
	            	return;
	            }
				//regex email
				String regex_email = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				Pattern p_email = Pattern.compile(regex_email);
				Matcher m_email = p_email.matcher(jtf_email.getText());
				if(!m_email.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Email không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//regex username
				String regex_username = "^(?=.*[a-zA-Z])(?=.*[0-9]).{5,}$";
				Pattern p_username = Pattern.compile(regex_username);
				Matcher m_username = p_email.matcher(jtf_user.getText());
				if(!m_username.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Tên đăng nhập không hợp lệ(phải trên 5 kí tự", "Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				//regex họ tên
				String regex_name = "^[a-zA-Z\\s]+$";
				Pattern p_name = Pattern.compile(regex_name);
				Matcher m_name = p_name.matcher(jtf_name.getText());
				if(!m_name.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Họ tên không đựa chứa kí tự đặc biệt","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				 
					
				//regex số điện thoại
				String regex_phone = "(0[3|5|7|8|9])+([0-9]{8})\\b";
				Pattern p_phone = Pattern.compile(regex_phone);
				Matcher m_phone = p_phone.matcher(jtf_phone.getText());
				if(!m_phone.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Số điện thoại không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//regex password
				String regex_pass = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$";
				Pattern p_pass = Pattern.compile(regex_pass);
				Matcher m_pass = p_pass.matcher(jtf_pass.getText());
				if(!m_pass.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Mật khẩu phải từ 6 kí tự trở lên(có kí "
							+ "tự số và chữ)","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				//xác thực mật khẩu
				if(!jtf_pass.getText().trim().equals(jtf_comfirm.getText())) {
					JOptionPane.showMessageDialog(GUISignup.this, "Xác thực mật khẩu không chính xác","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				//Kiểm tra ngày sinh hợp lệ
				if(!isValidDate(selectedDay, selectedMonth, selectedYear)) {
					JOptionPane.showMessageDialog(GUISignup.this, "Ngày sinh của bạn không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//Kiểm tra đã chọn giới tính hay chưa
				String gioitinh = "";
				if(rdbtnNam.isSelected()) {
					gioitinh = "Nam";
				}
				else if(rdbtnNu.isSelected()) {
					gioitinh = "Nu";
				}
				if(btn_grp.getSelection() == null) {
					JOptionPane.showMessageDialog(GUISignup.this, "Vui lòng chọn giới tính","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// try {
				// 	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					
					
				// 	String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=main";
				// 	String username = "sa";	
				// 	String password = "1234";
					
				// 	//Kiểm tra xem tên đăng kí có bị trùng trong database hay không
				// 	Connection con = DriverManager.getConnection(dbUrl, username, password);
				// 	System.out.println("Kết nối thành công");
					
				// 	String checkSql = "SELECT * FROM HoiVien WHERE MAHV = ?";
				// 	PreparedStatement checkStatement = con.prepareStatement(checkSql);
				// 	checkStatement.setString(1, jtf_mahv.getText());
				// 	ResultSet rs = checkStatement.executeQuery();
				// 	if (rs.next()) {
				// 		JOptionPane.showMessageDialog(GUISignup.this, "Mã hội viên đã tồn tại, vui lòng chọn mã hội viên khác", "Error", JOptionPane.ERROR_MESSAGE);
				// 		return; 
				// 	}
				// 	LocalDate birthDate = LocalDate.of(selectedYear, selectedMonth, selectedDay);
				// 	java.sql.Date sqlBirthDate = java.sql.Date.valueOf(birthDate);
				// 	String sql = "insert into HoiVien values (?,?,?,?,?,?,?,?)";
				// 	PreparedStatement ps = con.prepareStatement(sql);
				// 	ps.setString(1,jtf_mahv.getText());
				// 	ps.setString(2,jtf_name.getText());
				// 	ps.setString(3,gioitinh);
				// 	ps.setString(4,jtf_email.getText());	
				// 	ps.setString(5,jtf_user.getText());
				// 	ps.setString(6,jtf_pass.getText());
				// 	ps.setString(7,null);
				// 	ps.setDate(8,sqlBirthDate);	
				// 	int n = ps.executeUpdate();
				// 	if(n != 0) {
				// 			JOptionPane.showMessageDialog(GUISignup.this, "Đăng kí thành công","Information",JOptionPane.INFORMATION_MESSAGE);
				// 	}
					
				// } catch (Exception e1) {
				// 	System.out.println(e1);
				// }
				if(bllDangKy.hoiVienDangKy(jtf_mahv.getText(), jtf_name.getText(), gioitinh, jtf_email.getText(), jtf_user.getText(), jtf_pass.getText(), selectedYear, selectedMonth, selectedDay)){
					JOptionPane.showMessageDialog(null, "Đăng kí hội viên thành công");
				}
				else{
					JOptionPane.showMessageDialog(null, "Đăng kí hội viên không thành công");
				}
			}
		});
		btn_signup.setIcon(new ImageIcon("src/asset/img/icon/add-user-icon.png"));
		btn_signup.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_signup.setBounds(703, 670, 180, 70);
		getContentPane().add(btn_signup);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Giới tính");
		lblNewLabel_1_3_1.setIcon(new ImageIcon("src/asset/img/icon/sex-icon.png"));
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1.setBounds(292, 513, 122, 48);
		getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_3_1_1.setIcon(new ImageIcon("src/asset/img/icon/Calendar-icon.png"));
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1_1.setBounds(292, 430, 163, 48);
		getContentPane().add(lblNewLabel_1_3_1_1);
		
		String[] dayOptions = new String[31];
		for (int i = 0; i < 31; i++) {
		    dayOptions[i] = String.valueOf(i + 1);
		}
		cb_day = new JComboBox<>(dayOptions);
		cb_day.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_day.setBounds(474, 430, 89, 39);
		cb_day.setMaximumRowCount(5);
		getContentPane().add(cb_day);
		
		
		String[] monthOptions = new String[]{"Tháng 1","Tháng 2","Tháng 3","Tháng 4","Tháng 5","Tháng 6","Tháng 7","Tháng 8","Tháng 9","Tháng 10","Tháng 11","Tháng 12"};
		cb_month = new JComboBox<String>(monthOptions);
		cb_month.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_month.setMaximumRowCount(5);
		cb_month.setBounds(625, 430, 104, 39);
		getContentPane().add(cb_month);
		
		String[] yearOptions = new String[1000];
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 0; i < 1000; i++) {
		    yearOptions[i] = String.valueOf(currentYear - i);
		}
		cb_year = new JComboBox<>(yearOptions);
		cb_year.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_year.setMaximumRowCount(5);
		cb_year.setBounds(778, 430, 89, 39);
		getContentPane().add(cb_year);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnNam.setBounds(504, 531, 115, 21);
		getContentPane().add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnNu.setBounds(684, 531, 115, 21);
		getContentPane().add(rdbtnNu);
		
		btn_grp = new ButtonGroup();
		btn_grp.add(rdbtnNam);
		btn_grp.add(rdbtnNu);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Họ và tên");
		lblNewLabel_1_2_1.setIcon(new ImageIcon("src/asset/img/icon/User-icon.png"));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(630, 254, 190, 53);
		getContentPane().add(lblNewLabel_1_2_1);
		
		jtf_name = new JTextField();
		jtf_name.setColumns(10);
		jtf_name.setBounds(830, 259, 208, 30);
		getContentPane().add(jtf_name);
		
		setVisible(true);
	}
}
