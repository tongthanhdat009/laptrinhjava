package GUI.CONTROLLER;


import javax.swing.JPanel;
import javax.swing.JPasswordField;

import BLL.BLLInformation;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.Color;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class informationCTR extends JPanel{
	private static final long serialVersionUID = -7905422937456489628L;
	private BLLInformation bllInformation = new BLLInformation();
	private JPasswordField passwordTF;
    private JPasswordField newPassInputTF;
    private JPasswordField confirmOldPassTF;
    private JPasswordField confirmNewPassTF;
	public informationCTR(DTOTaiKhoan tk){
		setBackground(new Color(241, 255, 250));
		this.setLayout(null);
		this.setBounds(0,0,1200,900);
		if(!tk.getIDQuyen().equals("Q0001")) {
			JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập vào tài khoản hội viên để xem chức năng này!","Sai tài khoản", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		HoiVien thongTin = bllInformation.layThongTinNguoiDung(tk);
		//render ảnh đại diện
		ImageIcon Ava = new ImageIcon(thongTin.getAnh().trim());
		Image scaleAvaImage = Ava.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);

		//hiển thị tài khoản đăng nhập của hội viên
		JLabel accountLB = new JLabel("Tài khoản: "+tk.getTaiKhoan());
		accountLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		accountLB.setBounds(506, 331, 519, 35);
		add(accountLB);
		
		//hiển thị tên hội viên
		JLabel userNameLB = new JLabel("Họ tên: "+thongTin.getHoten()+".");
		userNameLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		userNameLB.setBounds(506, 90, 485, 50);
		add(userNameLB);
		
		//ngày tháng năm sinh
		String dateString = thongTin.getNgaysinh();
		String[] parts = dateString.split("-");
		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);

		//hiển thị ngày sinh của hội viên
		JLabel birthLB = new JLabel("Ngày sinh: " + String.valueOf(day)+" /"+ String.valueOf(month)+" /"+ String.valueOf(year));
		birthLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		birthLB.setBounds(506, 150, 343, 50);
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
		lblNewLabel.setBounds(950, 665, 250, 224);
		add(lblNewLabel);
		
		//hiển thị ảnh đại diện
		JLabel avtLB = new JLabel("");
        avtLB.setBounds(78, 90, 250, 250);
        avtLB.setIcon(new ImageIcon(scaleAvaImage));
        add(avtLB);
        
        //nút đổi ảnh đại diện
        
        JButton changeAvarBTN = new JButton("Đổi ảnh đại diện");
        changeAvarBTN.addActionListener(new ActionListener() {
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

        	            // Gọi phương thức thay đổi ảnh đại diện với đường dẫn mới
        	            if (bllInformation.thayAnhDaiDien(tk, destinationPath)) {
        	                JOptionPane.showMessageDialog(null, "Đổi ảnh đại diện thành công","Đổi ảnh đại diện", JOptionPane.INFORMATION_MESSAGE);
        	                String anh = destinationPath.toString();
        	                //render ảnh đại diện
        	        		ImageIcon Ava = new ImageIcon(anh);
        	        		Image scaleAvaImage = Ava.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        	                avtLB.setIcon(new ImageIcon(scaleAvaImage));
        	            } else {
        	                JOptionPane.showMessageDialog(null, "Đổi ảnh đại diện không thành công","Đổi ảnh đại diện", JOptionPane.ERROR_MESSAGE);
        	                return;
        	            }
        	        } catch (IOException ioException) {
        	            ioException.printStackTrace();
        	            System.out.println("Sao chép tệp thất bại!");
        	        }
        	    }
        	}

        });
        changeAvarBTN.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        changeAvarBTN.setBounds(78, 380, 234, 50);
        add(changeAvarBTN);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(204, 252, 203));
        titlePanel.setBounds(0, 0, 1200, 50);
        add(titlePanel);
        JLabel title = new JLabel("Thông tin cá nhân");
        titlePanel.add(title);
        title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
        
        
        
        JPanel showPassPanel = new JPanel();
        showPassPanel.setBackground(new Color(241, 255, 250));
        showPassPanel.setBounds(506, 377, 535, 133);
        add(showPassPanel);
        showPassPanel.setLayout(null);
        
        passwordTF = new JPasswordField();
        passwordTF.setFont(new Font("Times New Roman", Font.BOLD, 23));
        passwordTF.setBounds(149, 0, 199, 50);
        showPassPanel.add(passwordTF);
        passwordTF.setColumns(10);
        passwordTF.setText(tk.getMatKhau().trim());
        passwordTF.setEchoChar('●');
        passwordTF.setEditable(false);
        
        //hiển thị mật khẩu đăng nhập của hội viên
        JLabel passwordLB = new JLabel("Mật khẩu: ");
        passwordLB.setBounds(0, -3, 139, 50);
        showPassPanel.add(passwordLB);
        passwordLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        JPanel changePassPanel = new JPanel();
        changePassPanel.setBackground(new Color(241, 255, 250));
        changePassPanel.setBounds(506, 377, 593, 250);
        add(changePassPanel);
        changePassPanel.setLayout(null);
        
        newPassInputTF = new JPasswordField();
        newPassInputTF.setFont(new Font("Times New Roman", Font.BOLD, 25));
        newPassInputTF.setText("");
        newPassInputTF.setBounds(365, 66, 200, 41);
        changePassPanel.add(newPassInputTF);
        newPassInputTF.setColumns(10);
        newPassInputTF.setText("");
        
        confirmOldPassTF = new JPasswordField();
        confirmOldPassTF.setFont(new Font("Times New Roman", Font.BOLD, 25));
        confirmOldPassTF.setBounds(365, 14, 200, 41);
        changePassPanel.add(confirmOldPassTF);
        confirmOldPassTF.setColumns(10);
        
        
        JLabel confirmOldPassLB = new JLabel("Xác nhận mật khẩu cũ:");
        confirmOldPassLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
        confirmOldPassLB.setBounds(10, 11, 296, 50);
        changePassPanel.add(confirmOldPassLB);
        
        JLabel newPassInputLB = new JLabel("Nhập mật khẩu mới:");
        newPassInputLB.setBounds(10, 66, 272, 50);
        changePassPanel.add(newPassInputLB);
        newPassInputLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        JLabel confirmNewPassLB = new JLabel("Xác nhận mật khẩu mới:");
        confirmNewPassLB.setBounds(10, 111, 345, 50);
        changePassPanel.add(confirmNewPassLB);
        confirmNewPassLB.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        confirmNewPassTF = new JPasswordField();
        confirmNewPassTF.setFont(new Font("Times New Roman", Font.BOLD, 25));
        confirmNewPassTF.setBounds(365, 118, 200, 41);
        confirmNewPassTF.setColumns(10);
        changePassPanel.add(confirmNewPassTF);
        
        JButton argreeBTN = new JButton("Xác nhận");
        argreeBTN.setBackground(new Color(0, 255, 128));
        argreeBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		char[] oldPass = confirmOldPassTF.getPassword();
        		String oldPass1 = new String(oldPass);
        		char[] newPass = newPassInputTF.getPassword();
        		String newPass1 = new String(newPass);
        		char[] confirmPass = confirmNewPassTF.getPassword();
        		String confirmPass1 = new String(confirmPass);
        		
        		if(tk.getMatKhau().trim().equals(oldPass1)) {
        			if(newPass1.equals(confirmPass1)) {
        				if(newPass1.length()<6) {
        					JOptionPane.showMessageDialog(null, "Mật khẩu phải từ 6 kí tự trở lên!","Sai điều kiện mật khẩu", JOptionPane.ERROR_MESSAGE);
        					return;
        				}
        				else if(bllInformation.doiMatKhauHoiVien(tk,newPass1)) {
        					JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thành công!","Đổi mật khẩu thành công", JOptionPane.INFORMATION_MESSAGE);
        					changePassPanel.setVisible(false);
                    		showPassPanel.setVisible(true);
        					return;
        				}
        			}
        			else {
        				JOptionPane.showMessageDialog(null, "Mật khẩu xác nhật không khớp!", "Sai điều kiện", JOptionPane.INFORMATION_MESSAGE);
        				return;
        			}
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ!", "Sai thông tin", JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        	}
        });
        argreeBTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
        argreeBTN.setBounds(373, 190, 150, 35);
        changePassPanel.add(argreeBTN);
        
        JButton degreeBTN = new JButton("Hủy");
        degreeBTN.setBackground(new Color(255, 0, 0));
        degreeBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int choose = JOptionPane.showConfirmDialog(null, "Có muốn hủy bỏ những thay đổi không?","Xác nhận thay đổi", JOptionPane.INFORMATION_MESSAGE);
        		if(choose == JOptionPane.YES_OPTION) {
        			changePassPanel.setVisible(false);
            		showPassPanel.setVisible(true);
        		}
        		else {
        			return;
        		}
        	}
        });
        
        degreeBTN.setFont(new Font("Times New Roman", Font.BOLD, 25));
        degreeBTN.setBounds(118, 190, 150, 35);
        changePassPanel.add(degreeBTN);
        
        
        
      //nút đổi mật khẩu
        JButton changePassBTN = new JButton("Đổi mật khẩu");
        changePassBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		changePassPanel.setVisible(true);
        		showPassPanel.setVisible(false);
        	}
        });
        changePassBTN.setBounds(0, 81, 186, 50);
        showPassPanel.add(changePassBTN);
        changePassBTN.setFont(new Font("Tahoma", Font.PLAIN, 23));
        

        
//		hiển thị hoặc ẩn mật khẩu bằng checkBox
        JCheckBox showPassCheckOnChange = new JCheckBox("Hiển thị mật khẩu");
        showPassCheckOnChange.setBounds(365, 160, 160, 23);
        showPassCheckOnChange.setFont(new Font("Times New Roman", Font.BOLD, 15));
        showPassCheckOnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassCheckOnChange.isSelected()) {
                		confirmOldPassTF.setEchoChar((char) 0);
                		confirmNewPassTF.setEchoChar((char) 0);
                		newPassInputTF.setEchoChar((char) 0);
                } 
                else {
                	confirmOldPassTF.setEchoChar('●');
            		confirmNewPassTF.setEchoChar('●');
            		newPassInputTF.setEchoChar('●');
                }
        	}
        });
        changePassPanel.add(showPassCheckOnChange);
        changePassPanel.setVisible(false);
        
	}
}