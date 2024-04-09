
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
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

public class GUISignup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField jtf_name;
	private JTextField jtf_email;
	private JTextField jtf_phone;
	private JTextField jtf_cccd;
	private JPasswordField jtf_pass;
	private JPasswordField jtf_comfirm;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private ButtonGroup btn_grp;
	private JComboBox cb_day,cb_month,cb_year;

	
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
		boolean isLeapYear  = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUISignup.this.setLocationRelativeTo(null);

		setBounds(100, 100, 825, 784);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/Kearone-Platecons-Adressbook-add-user.128.png"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel.setBounds(250, 3, 312, 128);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng kí");
		lblNewLabel_1.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/Administrator-icon.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(80, 130, 180, 48);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ Email");
		lblNewLabel_1_1.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/Mail-icon.png"));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(80, 200, 180, 42);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_2.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/phone-icon.png"));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(80, 270, 180, 42);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số căn cước công dân");
		lblNewLabel_1_3.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/id-card-icon.png"));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(80, 330, 259, 42);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mật khẩu");
		lblNewLabel_1_4.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/Dialog-Password-Lock-icon.png"));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(80, 520, 180, 47);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Xác thực mật khẩu");
		lblNewLabel_1_5.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/Status-dialog-password-icon.png"));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(80, 590, 236, 47);
		getContentPane().add(lblNewLabel_1_5);
		
		jtf_name = new JTextField();
		jtf_name.setBounds(430, 144, 264, 30);
		getContentPane().add(jtf_name);
		jtf_name.setColumns(10);
		
		jtf_email = new JTextField();
		jtf_email.setColumns(10);
		jtf_email.setBounds(430, 211, 264, 30);
		getContentPane().add(jtf_email);
		
		jtf_phone = new JTextField();
		jtf_phone.setColumns(10);
		jtf_phone.setBounds(430, 270, 264, 30);
		getContentPane().add(jtf_phone);
		
		jtf_cccd = new JTextField();
		jtf_cccd.setColumns(10);
		jtf_cccd.setBounds(430, 341, 264, 30);
		getContentPane().add(jtf_cccd);
		
		jtf_pass = new JPasswordField();
		jtf_pass.setColumns(10);
		jtf_pass.setBounds(430, 520, 264, 30);
		getContentPane().add(jtf_pass);
		
		jtf_comfirm = new JPasswordField();
		jtf_comfirm.setColumns(10);
		jtf_comfirm.setBounds(430, 590, 264, 30);
		getContentPane().add(jtf_comfirm);
		
		JButton btn_login = new JButton("Đăng nhập");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGUILogin login = new newGUILogin();
				login.setVisible(true);
				dispose();
			}
		});
		btn_login.setBackground(new Color(11, 244, 122));
		btn_login.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/Login-icon.png"));
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_login.setBounds(100, 670, 180, 70);
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
				if(jtf_name.getText().equals("") ||jtf_email.getText().equals("") || jtf_phone.getText().equals("") || jtf_cccd.getText().equals("") ||
	            		jtf_pass.getText().equals("") || jtf_comfirm.getText().equals("")) {
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
				//regex số điện thoại
				String regex_phone = "(0[3|5|7|8|9])+([0-9]{8})\\b";
				Pattern p_phone = Pattern.compile(regex_phone);
				Matcher m_phone = p_phone.matcher(jtf_phone.getText());
				if(!m_phone.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Số điện thoại không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				//regex căn cước công dân
				String regex_cccd= "\\d{9,12}";
				Pattern p_cccd = Pattern.compile(regex_cccd);
				Matcher m_cccd = p_cccd.matcher(jtf_cccd.getText());
				if(!m_cccd.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Số căn cước công dân không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
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
				if(!jtf_pass.getText().equals(jtf_comfirm.getText())) {
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
					gioitinh = "Nữ";
				}
				if(btn_grp.getSelection() == null) {
					JOptionPane.showMessageDialog(GUISignup.this, "Vui lòng chọn giớ tính","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
					try {
			            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            
			            
			            String dbUrl = "jdbc:sqlserver://MSI\\KHANGDAO:1433;DatabaseName=SIGNUP";
			            String username = "sa";	
			            String password = "1234";
			            
			            //Kiểm tra xem tên đăng kí có bị trùng trong database hay không
			            Connection con = DriverManager.getConnection(dbUrl, username, password);
			            System.out.println("Kết nối thành công");
			            
			            String checkSql = "SELECT * FROM ACCOUNT WHERE USERNAME = ?";
			            PreparedStatement checkStatement = con.prepareStatement(checkSql);
			            checkStatement.setString(1, jtf_name.getText());
			            ResultSet rs = checkStatement.executeQuery();
			            if (rs.next()) {
			                JOptionPane.showMessageDialog(GUISignup.this, "Tên đăng kí đã tồn tại, vui lòng chọn tên đăng kí khác", "Error", JOptionPane.ERROR_MESSAGE);
			                return; 
			            }
			            LocalDate birthDate = LocalDate.of(selectedYear, selectedMonth, selectedDay);
			            java.sql.Date sqlBirthDate = java.sql.Date.valueOf(birthDate);
			            String sql = "insert into ACCOUNT values (?,?,?,?,?,?,?,?)";
				        PreparedStatement ps = con.prepareStatement(sql);
				        ps.setString(1,jtf_name.getText());
				        ps.setString(2,jtf_email.getText());
				        ps.setString(3,jtf_phone.getText());
				        ps.setString(4,jtf_cccd.getText());	
				        ps.setString(5,jtf_pass.getText());
				        ps.setString(6,jtf_comfirm.getText());
				        ps.setString(7,gioitinh);
				        ps.setDate(8,sqlBirthDate);
				        int n = ps.executeUpdate();
				      if(n != 0) {
				            	JOptionPane.showMessageDialog(GUISignup.this, "Đăng kí thành công","Information",JOptionPane.INFORMATION_MESSAGE);
				      }
				            
			    
			            
			            
			        } catch (Exception e1) {
			            e1.printStackTrace();
			            
			        }

				
			}
		});
		btn_signup.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/add-user-icon.png"));
		btn_signup.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_signup.setBounds(472, 670, 180, 70);
		getContentPane().add(btn_signup);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Giới tính");
		lblNewLabel_1_3_1.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/sex-icon.png"));
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1.setBounds(80, 462, 122, 48);
		getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_3_1_1.setIcon(new ImageIcon("doan/src/laptrinhjava/src/asset/img/Calendar-icon.png"));
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1_1.setBounds(77, 394, 163, 48);
		getContentPane().add(lblNewLabel_1_3_1_1);
		
		String[] dayOptions = new String[31];
		for (int i = 0; i < 31; i++) {
		    dayOptions[i] = String.valueOf(i + 1);
		}
		cb_day = new JComboBox<>(dayOptions);
		cb_day.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_day.setBounds(250, 400, 89, 39);
		cb_day.setMaximumRowCount(5);
		getContentPane().add(cb_day);
		
//		JComboBox cb_month = new JComboBox();
//		cb_month.setModel(new DefaultComboBoxModel(new String[] {"Tháng", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
//		cb_month.setMaximumRowCount(5);
//		cb_month.setFont(new Font("Arial", Font.PLAIN, 20));
//		cb_month.setBounds(394, 400, 89, 39);
//		getContentPane().add(cb_month);
		
		String[] monthOptions = new String[]{"Tháng 1","Tháng 2","Tháng 3","Tháng 4","Tháng 5","Tháng 6","Tháng 7","Tháng 8","Tháng 9","Tháng 10","Tháng 11","Tháng 12"};
		cb_month = new JComboBox<String>(monthOptions);
		cb_month.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_month.setMaximumRowCount(5);
		cb_month.setBounds(394, 400, 104, 39);
		getContentPane().add(cb_month);
		
		String[] yearOptions = new String[120];
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 0; i < 120; i++) {
		    yearOptions[i] = String.valueOf(currentYear - i);
		}
		cb_year = new JComboBox<>(yearOptions);
		cb_year.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_year.setMaximumRowCount(5);
		cb_year.setBounds(539, 400, 89, 39);
		getContentPane().add(cb_year);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnNam.setBounds(292, 480, 115, 21);
		getContentPane().add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnNu.setBounds(472, 480, 115, 21);
		getContentPane().add(rdbtnNu);
		
		btn_grp = new ButtonGroup();
		btn_grp.add(rdbtnNam);
		btn_grp.add(rdbtnNu);
		
		setVisible(true);
	}
}
