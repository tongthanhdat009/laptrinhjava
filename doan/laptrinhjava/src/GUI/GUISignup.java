package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.filechooser.FileNameExtensionFilter;

import BLL.BLLDangKy;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class GUISignup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField accountNameTF;
	private JTextField emailTF;
	private JTextField phoneNumberTF;
	private JPasswordField passwordTF;
	private JPasswordField confirmPassTF;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private ButtonGroup btn_grp;
	@SuppressWarnings("rawtypes")
	private JComboBox cb_day,cb_month,cb_year;
	private JTextField userNameTF;
	private String anh = "src//asset//img//avatar//user.png";
	private BLLDangKy bllDangKy = new BLLDangKy();
	//ảnh khi chưa chọn ảnh đại diện
    ImageIcon noneAva = new ImageIcon("src//asset//img//avatar//user.png");
    Image scaleNoneAvaIcon = noneAva.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
    
    //logo
    ImageIcon logo = new ImageIcon("src/asset/img/label/logo.png");
    Image scaleLogoIcon = logo.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
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
//	public int layMaHoiVienChuaTonTai()
//    {
//        try {
//        	String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=main";
//            String username = "sa";	
//            String password = "1234";
//            con = DriverManager.getConnection(dbUrl, username, password);
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM HoiVien");
//            int max = 0;
//            while(rs.next())
//            {
//                String ma = rs.getString("MaHV");
//                ma = ma.substring(2);
//                if(max < Integer.parseInt(ma)) max = Integer.parseInt(ma);
//            }
//            return max;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
	public GUISignup() {
		setResizable(false);
		getContentPane().setBackground(new Color(241, 255, 250));
		getContentPane().setLayout(null);
		
		setTitle("Đăng ký");
		setIconImage(logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(1129, 784);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel accountNameLB = new JLabel("Tên tài khoản:");
		accountNameLB.setIcon(new ImageIcon("src//asset//img/icon//Administrator-icon.png"));
		accountNameLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		accountNameLB.setBounds(30, 160, 252, 48);
		getContentPane().add(accountNameLB);
		
		JLabel emailLB = new JLabel("Địa chỉ Email:");
		emailLB.setIcon(new ImageIcon("src//asset//img//icon//Mail-icon.png"));
		emailLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		emailLB.setBounds(640, 160, 225, 42);
		getContentPane().add(emailLB);
		
		JLabel phoneNumberLB = new JLabel("Số điện thoại:");
		phoneNumberLB.setIcon(new ImageIcon("src//asset//img//icon//phone-icon.png"));
		phoneNumberLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		phoneNumberLB.setBounds(640, 280, 225, 42);
		getContentPane().add(phoneNumberLB);
		
		JLabel passwordLB = new JLabel("Mật khẩu:");
		passwordLB.setIcon(new ImageIcon("src//asset//img//icon//Dialog-Password-Lock-icon.png"));
		passwordLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		passwordLB.setBounds(30, 220, 202, 47);
		getContentPane().add(passwordLB);
		
		JLabel confirmPassLB = new JLabel("Xác thực mật khẩu:");
		confirmPassLB.setIcon(new ImageIcon("src//asset//img//icon//Status-dialog-password-icon.png"));
		confirmPassLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		confirmPassLB.setBounds(30, 280, 281, 47);
		getContentPane().add(confirmPassLB);
		
		accountNameTF = new JTextField();
		accountNameTF.setBounds(292, 160, 208, 30);
		getContentPane().add(accountNameTF);
		accountNameTF.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(875, 160, 200, 30);
		getContentPane().add(emailTF);
		
		phoneNumberTF = new JTextField();
		phoneNumberTF.setColumns(10);
		phoneNumberTF.setBounds(875, 280, 200, 30);
		getContentPane().add(phoneNumberTF);
		
		passwordTF = new JPasswordField();
		passwordTF.setColumns(10);
		passwordTF.setBounds(292, 220, 208, 30);
		getContentPane().add(passwordTF);
		
		confirmPassTF = new JPasswordField();
		confirmPassTF.setColumns(10);
		confirmPassTF.setBounds(292, 280, 208, 30);
		getContentPane().add(confirmPassTF);
		
		JButton btn_login = new JButton("Đăng nhập");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUILogin login = new GUILogin();
				login.setVisible(true);
				dispose();
			}
		});
		
		btn_login.setBackground(new Color(11, 244, 122));
		btn_login.setIcon(new ImageIcon("src//asset//img//icon//Login-icon.png"));
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_login.setBounds(245, 670, 180, 70);
		getContentPane().add(btn_login);
		
		JLabel sexLB = new JLabel("Giới tính:");
		sexLB.setIcon(new ImageIcon("src//asset//img//icon//sex-icon.png"));
		sexLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		sexLB.setBounds(30, 400, 202, 48);
		getContentPane().add(sexLB);
		
		JLabel birthDateLB = new JLabel("Ngày sinh:");
		birthDateLB.setIcon(new ImageIcon("src//asset//img//icon//Calendar-icon.png"));
		birthDateLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		birthDateLB.setBounds(30, 340, 202, 48);
		getContentPane().add(birthDateLB);
		
		String[] dayOptions = new String[31];
		for (int i = 0; i < 31; i++) {
		    dayOptions[i] = String.valueOf(i + 1);
		}
		cb_day = new JComboBox<>(dayOptions);
		cb_day.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_day.setBounds(292, 340, 100, 40);
		cb_day.setMaximumRowCount(5);
		getContentPane().add(cb_day);
		
		
		String[] monthOptions = new String[]{"Tháng 1","Tháng 2","Tháng 3","Tháng 4","Tháng 5","Tháng 6","Tháng 7","Tháng 8","Tháng 9","Tháng 10","Tháng 11","Tháng 12"};
		cb_month = new JComboBox<String>(monthOptions);
		cb_month.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_month.setMaximumRowCount(5);
		cb_month.setBounds(409, 340, 100, 40);
		getContentPane().add(cb_month);
		
		String[] yearOptions = new String[1000];
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 0; i < 1000; i++) {
		    yearOptions[i] = String.valueOf(currentYear - i);
		}
		cb_year = new JComboBox<>(yearOptions);
		cb_year.setFont(new Font("Arial", Font.PLAIN, 20));
		cb_year.setMaximumRowCount(5);
		cb_year.setBounds(519, 340, 100, 40);
		getContentPane().add(cb_year);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(new Color(241, 255, 250));
		rdbtnNam.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rdbtnNam.setBounds(292, 414, 115, 21);
		getContentPane().add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(new Color(241, 255, 250));
		rdbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rdbtnNu.setBounds(409, 414, 115, 21);
		getContentPane().add(rdbtnNu);
		
		btn_grp = new ButtonGroup();
		btn_grp.add(rdbtnNam);
		btn_grp.add(rdbtnNu);
		
		JLabel userNameLB = new JLabel("Họ và tên:");
		userNameLB.setIcon(new ImageIcon("src/asset/img/icon/User-icon.png"));
		userNameLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		userNameLB.setBounds(640, 220, 225, 42);
		getContentPane().add(userNameLB);
		
		userNameTF = new JTextField();
		userNameTF.setColumns(10);
		userNameTF.setBounds(875, 220, 200, 30);
		getContentPane().add(userNameTF);
		
		JLabel showAvatarLB = new JLabel();
		showAvatarLB.setBounds(825, 380, 250, 250);
		showAvatarLB.setIcon(new ImageIcon(scaleNoneAvaIcon));
		getContentPane().add(showAvatarLB);
		
		JLabel avatarLB = new JLabel("Ảnh đại diện:");
		avatarLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		avatarLB.setBounds(601, 450, 175, 42);
		getContentPane().add(avatarLB);
		
		JButton chooseAvaBTN = new JButton("Chọn ảnh đại diện:");
		chooseAvaBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	    JFileChooser fileChooser = new JFileChooser();

        	    // Tạo bộ lọc chỉ nhận file ảnh (jpg, png, gif)
        	    FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
        	            "Hình ảnh (JPG, PNG, GIF)", "jpg", "png", "gif");

        	    // Thêm bộ lọc vào JFileChooser
        	    fileChooser.setFileFilter(imageFilter);

        	    // Loại bỏ tùy chọn "All Files"
        	    fileChooser.setAcceptAllFileFilterUsed(false);

        	    int result = fileChooser.showOpenDialog(null); // Mở hộp thoại chọn file

        	    if (result == JFileChooser.APPROVE_OPTION) {
        	        File selectedFile = fileChooser.getSelectedFile();
        	        // Tên file
        	        String fileName = selectedFile.getName();
        	        System.out.println("Tên file: " + fileName);

        	        // Thư mục đích (nơi file sẽ được sao chép tới)
        	        File destinationDir = new File("src//asset//img//avatar");

        	        // Kiểm tra thư mục đích có tồn tại không, nếu không thì tạo mới
        	        if (!destinationDir.exists()) {
        	            destinationDir.mkdirs();
        	        }

        	        // Đường dẫn đích (bao gồm tên tệp)
        	        Path destinationPath = destinationDir.toPath().resolve(fileName);

        	        // Nếu tệp đã tồn tại, thêm số vào tên tệp cho đến khi tìm được tên tệp mới không trùng
        	        int counter = 1;
        	        String newFileName = fileName;
        	        while (Files.exists(destinationPath)) {
        	            String fileNameWithoutExt = fileName.substring(0, fileName.lastIndexOf('.'));
        	            String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
        	            newFileName = fileNameWithoutExt + "_" + counter + fileExtension;
        	            destinationPath = destinationDir.toPath().resolve(newFileName);
        	            counter++;
        	        }

        	        try {
        	            // Sao chép tệp tới thư mục đích với tên mới nếu cần
        	            Files.copy(selectedFile.toPath(), destinationPath);
        	            System.out.println("Đã sao chép tệp tới: " + destinationPath);
        	            anh = destinationPath.toString();
        	            ImageIcon ava = new ImageIcon(anh);
        	            Image scaleAvaIcon = ava.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        	            showAvatarLB.setIcon(new ImageIcon(scaleAvaIcon));
        	            // Gọi phương thức thay đổi ảnh đại diện với đường dẫn mới
        	        } catch (IOException ioException) {
        	            ioException.printStackTrace();
        	            System.out.println("Sao chép tệp thất bại!");
        	        }
        	    }
        	}
		});
		
		chooseAvaBTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
		chooseAvaBTN.setBounds(555, 502, 260, 42);
		getContentPane().add(chooseAvaBTN);
		
		JButton btn_signup = new JButton("Đăng kí");
		btn_signup.setBackground(new Color(30, 210, 225));
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedDay = Integer.parseInt((String) cb_day.getSelectedItem());
				int selectedMonth = cb_month.getSelectedIndex() + 1;
				int selectedYear = Integer.parseInt((String) cb_year.getSelectedItem());
				//regex email
				String regex_email = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,7}$";
				Pattern p_email = Pattern.compile(regex_email);
				Matcher m_email = p_email.matcher(emailTF.getText());
				//regex số điện thoại
				String regex_phone = "(0[3|5|7|8|9])+([0-9]{8})\\b";
				Pattern p_phone = Pattern.compile(regex_phone);
				Matcher m_phone = p_phone.matcher(phoneNumberTF.getText());
				//regex password
				String regex_pass = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$";
				char[] pass = passwordTF.getPassword();
				String passString = new String(pass);
				Pattern p_pass = Pattern.compile(regex_pass);
				Matcher m_pass = p_pass.matcher(passString);
				
				char[] confirmPass = confirmPassTF.getPassword();
				String confirmPassString = new String(confirmPass);
				int dk = JOptionPane.showConfirmDialog(GUISignup.this,"Bạn có muốn đăng kí","Comfirm", JOptionPane.YES_NO_OPTION);
				if(dk != JOptionPane.YES_OPTION) {
					return;
				}
				
				//Kiểm tra thông tin bị trống hay không
				if(accountNameTF.getText().trim().equals("") ||emailTF.getText().trim().equals("") || phoneNumberTF.getText().trim().equals("") ||
	            	userNameTF.getText().trim().equals("") || passString.trim().equals("") || confirmPassString.trim().equals("")) {
	            	JOptionPane.showMessageDialog(GUISignup.this, "Thông tin không được để trống","Error",JOptionPane.ERROR_MESSAGE);
	            	return;
	            }
				else if(!m_email.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Email không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(!bllDangKy.kiemTraTenTK(accountNameTF.getText().trim())) {
					JOptionPane.showMessageDialog(GUISignup.this, "Tên tài khoản đã được sử dụng vui lòng thử lại!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				//regex username
//				String regex_username = "^(?=.*[a-zA-Z])(?=.*[0-9]).{5,}$";
//				Pattern p_username = Pattern.compile(regex_username);
//				Matcher m_username = p_email.matcher(jtf_user.getText());
//				if(!m_username.matches()) {
//					JOptionPane.showMessageDialog(GUISignup.this, "Tên đăng nhập không hợp lệ(phải trên 5 kí tự)", "Error",JOptionPane.ERROR_MESSAGE);
//					return;
//				}
				else if(!m_phone.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Số điện thoại không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(!m_pass.matches()) {
					JOptionPane.showMessageDialog(GUISignup.this, "Mật khẩu phải từ 6 kí tự trở lên(có kí "
							+ "tự số và chữ)","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				//xác thực mật khẩu
				else if(!passString.trim().equals(confirmPassString)) {
					JOptionPane.showMessageDialog(GUISignup.this, "Xác thực mật khẩu không chính xác","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				//Kiểm tra ngày sinh hợp lệ
				else if(!isValidDate(selectedDay, selectedMonth, selectedYear)) {
					JOptionPane.showMessageDialog(GUISignup.this, "Ngày sinh của bạn không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(currentYear - selectedYear < 18) {
					JOptionPane.showMessageDialog(GUISignup.this, "Bạn chưa đủ 18 tuổi vui lòng không đăng ký!","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(btn_grp.getSelection() == null) {
					JOptionPane.showMessageDialog(GUISignup.this, "Vui lòng chọn giớ tính","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					try {
						BLLDangKy blldk = new BLLDangKy();
						String maTaiKhoan = blldk.kiemTraMaTK();
						LocalDate birthDate = LocalDate.of(selectedYear, selectedMonth, selectedDay);
			            java.sql.Date sqlBirthDate = java.sql.Date.valueOf(birthDate);
			            String mahv = blldk.taoMaHoiVienMoi();
			            String hoten = userNameTF.getText().trim();
			            String gioitinh = rdbtnNam.isSelected() ? "Nam" : "Nữ";
			            String email = emailTF.getText().trim();
			            String tk = accountNameTF.getText().trim();;
			            String matkhau = passString.trim();
			            String sdt = phoneNumberTF.getText().trim();
			            HoiVien hv = new HoiVien(mahv, hoten, gioitinh, email, sqlBirthDate, sdt, maTaiKhoan, anh);
			            DTOTaiKhoan tKhoan = new DTOTaiKhoan(maTaiKhoan, tk, matkhau, "Q0001");
			            if(blldk.themTKhoan(tKhoan)&& blldk.KiemTraDangKy(hv)) {
			            	JOptionPane.showMessageDialog(GUISignup.this, "Đăng kí thành công","Đăng ký tài khoản",JOptionPane.INFORMATION_MESSAGE);
			            	new GUILogin();
			            	return;
			            }
					} catch (Exception e2) {
						System.out.println(e2);
					}
					
				}
//					try {
//			            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			            
//			            
//			            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=main";
//			            String username = "sa";	
//			            String password = "1234";
//			            
//			            //Kiểm tra xem tên đăng kí có bị trùng trong database hay không
//			            con = DriverManager.getConnection(dbUrl, username, password);
//			            System.out.println("Kết nối thành công");
//			            
//			            String checkSql = "SELECT * FROM HoiVien WHERE TaiKhoan = ?";
//			            PreparedStatement checkStatement = con.prepareStatement(checkSql);
//			            checkStatement.setString(1, jtf_user.getText());
//			            ResultSet rs = checkStatement.executeQuery();
//			            if (rs.next()) {
//			                JOptionPane.showMessageDialog(GUISignup.this, "Tên đăng kí đã tồn tại đã tồn tại, vui lòng chọn mã hội viên khác", "Error", JOptionPane.ERROR_MESSAGE);
//			                return; 
//			            }
//			            LocalDate birthDate = LocalDate.of(selectedYear, selectedMonth, selectedDay);
//			            java.sql.Date sqlBirthDate = java.sql.Date.valueOf(birthDate);
//			            String sql = "insert into HoiVien values (?,?,?,?,?,?,?,?)";
//				        PreparedStatement ps = con.prepareStatement(sql);
////				        ps.setString(1,this.);
//				        ps.setString(2,jtf_name.getText());
//				        ps.setString(3,gioitinh);
//				        ps.setString(4,jtf_email.getText());	
//				        ps.setString(5,jtf_user.getText());
//				        ps.setString(6,jtf_pass.getText());
//				        ps.setString(7,null);
//				        ps.setDate(8,sqlBirthDate);	
//				        int n = ps.executeUpdate();
//				        if(n != 0) {
//				            	JOptionPane.showMessageDialog(GUISignup.this, "Đăng kí thành công","Information",JOptionPane.INFORMATION_MESSAGE);
//				        }
//			            
//			        } catch (Exception e1) {
//			            System.out.println(e1);
//			            
//			        }

				
			}
		});
		btn_signup.setIcon(new ImageIcon("src//asset//img//icon//add-user-icon.png"));
		btn_signup.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_signup.setBounds(703, 670, 180, 70);
		getContentPane().add(btn_signup);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(204, 252, 203));
		panel.setBounds(0, 0, 1113, 154);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng ký");
		lblNewLabel.setBounds(353, -50, 388, 250);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(204, 252, 203));
		lblNewLabel.setIcon(new ImageIcon("src\\asset\\img\\label\\logo1.png"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		
		setVisible(true);
	}
}