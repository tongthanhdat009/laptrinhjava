package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLLQuanLyDanhSach;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;
import GUI.renderer;

public class hoiVienCTR {
	private JPanel rightPanel;
	private ArrayList<String> tenCotHV;
	private JComboBox<Integer> dayCBB = new  JComboBox<>();
    @SuppressWarnings("unused")
    private JComboBox<Integer> monthCBB = new JComboBox<>();
    @SuppressWarnings("unused")
    private JComboBox<Integer> yearCBB = new JComboBox<>();
    private final int width = 1600;
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm
    private ArrayList<HoiVien> dsHV;
    private JPanel bangChinhSua;
    private JTable dataTable;
    private JScrollPane scrollPane;
    private BLLQuanLyDanhSach bllQuanLyDanhSach;

	public hoiVienCTR(JPanel rightPanel, ArrayList<String> tenCotHV, ArrayList<HoiVien> dsHV, JPanel bangChinhSua, JTable dataTable, JScrollPane scrollPane, BLLQuanLyDanhSach bllQuanLyDanhSach) {
		this.rightPanel = rightPanel;
		this.tenCotHV = tenCotHV;
		this.dsHV = dsHV;
		this.bangChinhSua = bangChinhSua;
		this.dataTable = dataTable;
		this.scrollPane = scrollPane;
		this.bllQuanLyDanhSach = bllQuanLyDanhSach;
	}
	
	public void xoaHienThi(JPanel rightPanel){
        Component[] components = rightPanel.getComponents();
        for(Component a : components){
            if(!(a instanceof JLabel || a instanceof JComboBox)){
                rightPanel.remove(a);
            }
        }
        rightPanel.revalidate();
        rightPanel.repaint();
    }
	
	public void update() {
		xoaHienThi(rightPanel);
		JLabel title = new JLabel("Quản lý hội viên");
    	title.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 35));
    	title.setBounds(450, 0, 1000,60);   
    	rightPanel.setBackground(new Color(241,255,250));
    	rightPanel.add(title);
		// lấy danh sách mã tài khoản
		ArrayList<DTOTaiKhoan> dsTK = bllQuanLyDanhSach.layDSTKHV(); 
		
        // tạo model bảng
        DefaultTableModel hvList = new DefaultTableModel();
        for (int i = 0; i < tenCotHV.size(); i++) {
            hvList.addColumn(tenCotHV.get(i));
        }
        System.out.println(dsTK.size() +" "+dsHV.size() );
        // Thêm dữ liệu vào bảng
        for (int i = 0; i < dsHV.size(); i++) {
            hvList.addRow(new Object[]{dsHV.get(i).getMaHoiVien(),
                dsHV.get(i).getHoten().trim(),
                dsHV.get(i).getGioitinh().trim(),
                dsHV.get(i).getMail().trim(),
                dsTK.get(i).getIDTaiKhoan().trim(),
                dsHV.get(i).getSdt().trim(),
                dsHV.get(i).getNgaysinh().trim(),
                dsTK.get(i).getTaiKhoan().trim(),
                dsTK.get(i).getMatKhau().trim(),
                dsHV.get(i).getAnh(),
                });
        }
        
        //bảng hiện dòng thông tin được chọn
        bangChinhSua.setBounds(5,175,(int)(width*0.75)-25,270);
        bangChinhSua.setLayout(new GridLayout(3,3,10,10));
        bangChinhSua.setBackground(new Color(119, 230, 163));
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        bangChinhSua.setBorder(titledBorder);


        for(int i=0;i<tenCotHV.size();i++){
            JPanel tempPanel = new JPanel();
            TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackBorder,tenCotHV.get(i));
            titledBorder1.setTitleFont(titledBorder.getTitleFont().deriveFont(18f));
            tempPanel.setBorder(titledBorder1);
            tempPanel.setBackground(Color.white);

            JTextField tempTF = new JTextField();
            tempTF.setPreferredSize(new Dimension(200,20));
            tempTF.setBounds(0,20,120,20);
            tempTF.setName(tenCotHV.get(i));
            if(i==2){
                Font font = new Font("Times New Roman", Font.BOLD, 20); // Thay đổi font và kích thước chữ ở đây
                JRadioButton nam = new JRadioButton("Nam");
                nam.setBounds(0,0,100,30);
                JRadioButton nu = new JRadioButton("Nữ");
                nu.setBounds(0,0,100,30);
                ButtonGroup gioiTinh = new ButtonGroup();
                nam.setFont(font);
                nu.setFont(font);
                nam.setBackground(Color.white);
                nu.setBackground(Color.white);
                gioiTinh.add(nam);
                gioiTinh.add(nu);
                tempPanel.add(nam);
                tempPanel.add(nu);
                bangChinhSua.add(tempPanel);
                continue;
            }
            else if(i==4) {
            	tempTF.setEditable(false);
            	tempPanel.add(tempTF);
                bangChinhSua.add(tempPanel);
            }
            else if(i==6){
                Font font = new Font("Times New Roman", Font.BOLD, 20); // Thay đổi font và kích thước chữ ở đây
                for(int day=1; day<=31 ;day++){
                    dayCBB.addItem(day);
                }

                dayCBB.setFont(font);
                dayCBB.setBackground(Color.white);
                dayCBB.setName("Day");
                
                JComboBox<Integer> monthCBB = new JComboBox<>();
                for(int month=1; month<=12 ;month++){
                    monthCBB.addItem(month);
                }
                monthCBB.setFont(font);
                monthCBB.setBackground(Color.white);
                monthCBB.setName("Month");

                JComboBox<Integer> yearCBB = new JComboBox<>();
                for(int year=2024;year>=1900;year--){
                    yearCBB.addItem(year);
                }
                yearCBB.setFont(font);
                yearCBB.setBackground(Color.white);
                yearCBB.setName("Year");
                yearCBB.setSelectedItem(2024);

                // Listener thay đổi tháng và năm để cập nhật ngày
                ActionListener updateDaysListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateDays(dayCBB, monthCBB, yearCBB);
                    }
                };
                monthCBB.addActionListener(updateDaysListener);
                yearCBB.addActionListener(updateDaysListener);

                tempPanel.add(dayCBB);
                tempPanel.add(monthCBB);
                tempPanel.add(yearCBB);

            }
            else if(i==9) {
            	tempTF.setEditable(false);
            	tempPanel.add(tempTF);
                bangChinhSua.add(tempPanel);
            }
            // tempPanel.add(tempLabel);
            else{
                tempPanel.add(tempTF);
            }
            bangChinhSua.add(tempPanel);
        }

        rightPanel.add(bangChinhSua);
        rightPanel.revalidate();
        rightPanel.repaint();

        dataTable = new JTable(hvList);
        dataTable.getTableHeader().setReorderingAllowed(false);
        dataTable.setFont(new Font("Times New Roman", 1, 15));
        dataTable.setRowHeight(20);
        scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(5,460,(int)(width*0.75)-20,400);
        dataTable.setRowHeight(100);
        
        renderer rd = new renderer();
        dataTable.getColumnModel().getColumn(9).setCellRenderer(rd);
        
        //nút chức năng
        String[] cmtNut = {"add", "edit", "Search","Reset"};
        String[] anhStrings = {
            "src/asset/img/button/them-hv.png",
            "src/asset/img/button/sua-hv.png",
            "src/asset/img/button/tim-hv.png",
            "src/asset/img/button/reset-hv.png"
        };
        int a=275;
        for(int i=0;i<cmtNut.length;i++){
            JButton tempBtn = new JButton();
            ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
            Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
            tempBtn.setActionCommand(cmtNut[i]);
            tempBtn.setBounds(a,110,130,35);
            tempBtn.setIcon(new ImageIcon(scaleTempBtnImg));
            tempBtn.setHorizontalAlignment(SwingConstants.CENTER);
            tempBtn.setBorder(null);
            tempBtn.addActionListener(new ActionListener() {
                @SuppressWarnings({ "deprecation", "unchecked" })
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equals(cmtNut[0])) { //THÊM HỘI VIÊN
                        boolean flag = true; // cờ hiệu gán giá trị cho mã hội viên
                        ArrayList<String> thongTinMoi = new ArrayList<String>(); 
                        int day=1, month=1, year=2000;
                        Component[] components = bangChinhSua.getComponents();
                        int countDate = 0;
                        for (int i=0; i<components.length;i++) {
                            if (components[i] instanceof JPanel) {
                                JPanel tempPanel = (JPanel) components[i];
                                Component[] smallComponents = tempPanel.getComponents();
                                for (int j=0;j<smallComponents.length;j++) {
                                    if(smallComponents[j] instanceof JTextField){
                                        JTextField textField = (JTextField) smallComponents[j];
                                        String text = textField.getText().trim(); // Lấy text từ textField và loại bỏ khoảng trắng đầu cuối
                                        if (flag && j == 0) {
                                            int maxSTT = bllQuanLyDanhSach.kiemTraMaHoiVien();
                                            textField.setText(String.format("HV%03d", maxSTT));
                                            thongTinMoi.add(textField.getText());
                                            flag = false;
                                        }
                                        else if(i==1) {
                                        	//regex họ tên có chứa kí tự unicode
                                        	String regex_userName = "^[\\p{L}\\p{M}']+(?:[\\s][\\p{L}\\p{M}']+)*$";
                            		        Pattern p_userName = Pattern.compile(regex_userName);
                            	            Matcher m_userName = p_userName.matcher(text);
                            	            if(!(text.length() > 0 && text.length()<=50)) {
                            	            	JOptionPane.showMessageDialog(null, "Tên hội viên dài từ 1 đến 50 kí tự", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);;
                            	            	return;
                            	            }
                            	            else if(!m_userName.matches()) {
                            	            	JOptionPane.showMessageDialog(null, "Tên hội viên không được chứa kí tự đặc biệt và số", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);;
                            	            	return;
                            	            }
                            	            else {
                            	            	thongTinMoi.add(text);
                            	            }
                                        }
                                        else if(i==3) {
                                        	//regex email
                            				String regex_email = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,7}$";
                            				Pattern p_email = Pattern.compile(regex_email);
                            				Matcher m_email = p_email.matcher(text);
                            				if (!(text.length() >= 1 && text.length() <= 345)) {
                            					JOptionPane.showMessageDialog(null, "Email dài từ 1 đến 345 kí tự", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);;
                            	            	return;
											}
                            				else if (!m_email.matches()) {
                            					JOptionPane.showMessageDialog(null, "Email không đúng định dạng", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);;
                            	            	return;
                            				}
                            				else {
                            	            	thongTinMoi.add(text);
                            				}
                                        }
                                        else if(i==4) {
                                        	textField.setText(bllQuanLyDanhSach.kiemTraMaTK());
                                            thongTinMoi.add(textField.getText());
                                        }
                                        else if (i==5){
                                            String hvSDT = textField.getText().trim();
                                            if(!bllQuanLyDanhSach.kiemTraSDT(hvSDT)){
                                                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);
                                                return;
                                            }
                                            else{
                                                thongTinMoi.add(hvSDT);
                                            }
                                        }
                                        else if (i==7) {
                                        	String tenTK = textField.getText().trim();
                                        	String regex_account = "^[a-zA-Z0-9]{5,20}$";
                            				Pattern p_account = Pattern.compile(regex_account);
                            				Matcher m_account = p_account.matcher(tenTK);
                                        	if(!bllQuanLyDanhSach.kiemTraTenTK(tenTK)){
                                        		JOptionPane.showMessageDialog(null, "Tài khoản không được trùng lập!", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        	}
                                        	else if(!m_account.matches()) {
                                        		JOptionPane.showMessageDialog(null, "Tài khoản không được chứa kí tự đặc biệt và phải dài từ 5 đến 20 kí tự!", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        	}
                                        	else {
                                        		thongTinMoi.add(tenTK);
                                        	}
                                        }
                                        else if(i==8) {
                                        	String matKhau = text;
                            				String regex_pass = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,20}$";
                                        	Pattern p_pass = Pattern.compile(regex_pass);
                            				Matcher m_pass = p_pass.matcher(matKhau);
                                        	if(!m_pass.matches()) {
                                                JOptionPane.showMessageDialog(null, "Mật khẩu phải dài hơn 6 kí tự bao gồm cả chữ và số!", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        	}
                                        	else{
                                                thongTinMoi.add(matKhau);
                                            }
                                        }
                                        else if(i == 9){
        									thongTinMoi.add("src/asset/img/avatar/user.png");
            							}
                                        else if (text.equals("")) {
                                            JOptionPane.showMessageDialog(bangChinhSua, "Không được để trống thông tin!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
                                            return; // Kết thúc sự kiện nếu có thông tin bị thiếu
                                        }
                                        else {
                                            thongTinMoi.add(text);
                                        }
                                    }
                                    else if(smallComponents[j] instanceof JRadioButton){
                                        JRadioButton tempRB = (JRadioButton) smallComponents[j];
                                        if(tempRB.isSelected()){
                                            thongTinMoi.add(tempRB.getText());
                                        }
                                        else{
                                            continue;
                                        }
                                    }
                                    else if(smallComponents[j] instanceof JComboBox){
                                        @SuppressWarnings("rawtypes")
                                        JComboBox cb = (JComboBox) smallComponents[j];
                                        if("Day".equals(cb.getName())){
                                            day = (int) cb.getSelectedItem();
                                            countDate++;
                                        }
                                        if("Month".equals(cb.getName())){
                                            month = (int) cb.getSelectedItem();
                                            countDate++;
                                        }
                                        if("Year".equals(cb.getName())){
                                            year = (int) cb.getSelectedItem();
                                            countDate++;
                                        }
                                        if(countDate ==3){
                                          //Kiểm tra 18 tuổi
                                            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                                    		int currentDay = Calendar.getInstance().get(Calendar.DATE);
                                    		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
                            				if (currentYear - year < 18) {
                            				    JOptionPane.showMessageDialog(null, "Tuổi của hội viên chưa đủ 18, vui lòng kiểm tra lại!", "Error", JOptionPane.ERROR_MESSAGE);
                            				    return;
                            				} 
                            				else if (currentYear - year == 18) {
                            				    // Kiểm tra tháng và ngày
                            				    if (currentMonth < month || (currentMonth == month && currentDay < day)) {
                            				    	System.out.println((currentDay) + " " + day);				    
                            				        JOptionPane.showMessageDialog(null, "Tuổi của hội viên chưa đủ 18, vui lòng kiểm tra lại!", "Error", JOptionPane.ERROR_MESSAGE);
                            				        return;
                            				    }
                            				}
                        					thongTinMoi.add(year+"-"+month+"-"+day);
                            				countDate=0;
                                        }
                                    }
                                }

                            }
                        }
                        System.out.println(thongTinMoi);
                        //  Kiểm tra xem thongTinMoi có đủ 6 phần tử không trước khi thêm vào hvList
                        if (thongTinMoi.size() >= 10) {
                            
                            Date date = new Date(year-1900, month-1, day); // Tạo đối tượng Date từ năm, tháng và ngày
                            
                            HoiVien tempHV = new HoiVien(thongTinMoi.get(0),
		                            thongTinMoi.get(1),
		                            thongTinMoi.get(2),
		                            thongTinMoi.get(3),
		                            date,
		                            thongTinMoi.get(5),
		                            thongTinMoi.get(4),
		                            thongTinMoi.get(9));
                            DTOTaiKhoan tempTK = new DTOTaiKhoan(thongTinMoi.get(4),
                            		thongTinMoi.get(7),
                            		thongTinMoi.get(8),
                            		"Q0001");
                            if(bllQuanLyDanhSach.themTK(tempTK)&&bllQuanLyDanhSach.themHV(tempHV)){
                                JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công hội viên và tài khoản thành công!");
                                hvList.addRow(thongTinMoi.toArray());
                            }
                            else {
                                JOptionPane.showMessageDialog(bangChinhSua, "Thêm không thành công!");
                                return;
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    else if (e.getActionCommand().equals(cmtNut[1])) {//SỬA THÔNG TIN HỘI VIÊN
                        int i= dataTable.getSelectedRow();
                        Date date;
                        ArrayList<String> thongTinMoi = new ArrayList<String>(); 
                        int day=1, year=2000, month=1;
                        String maGoc = new String();
                        String tenGoc = new String();
                        String taiKhoanGoc = new String();
                        String ngaySinhGoc = new String();
                        String gioiTinhGoc = new String();
                        if (i>=0){
                        	maGoc = hvList.getValueAt(i, 0).toString().trim();
                        	tenGoc = hvList.getValueAt(i, 1).toString();
                        	taiKhoanGoc = hvList.getValueAt(i, 7).toString().trim();
                        	ngaySinhGoc = hvList.getValueAt(i, 6).toString().trim();
                        	gioiTinhGoc = hvList.getValueAt(i, 2).toString().trim();
                        	System.out.println(taiKhoanGoc);
                            int countDate = 0;
                            Component[] components = bangChinhSua.getComponents();
                            for (Component component : components) {
                                if (component instanceof JPanel) {
                                    JPanel tempPanel = (JPanel) component;
                                    Component[] smallComponents = tempPanel.getComponents();
                                    for (Component smallComponent : smallComponents) {
                                        if (smallComponent instanceof JTextField) {
                                            JTextField textField = (JTextField) smallComponent;
                                            String text = textField.getText();
                                            thongTinMoi.add(text);
                                        }
                                        else if (smallComponent instanceof JComboBox) {
                                            @SuppressWarnings("rawtypes")
                                            JComboBox comboBox = (JComboBox) smallComponent;
                                            if(comboBox.getName().equals("Day")){
                                                day = (int) comboBox.getSelectedItem();
                                                countDate++;
                                            }

                                            if(comboBox.getName().equals("Month")){
                                                month = (int) comboBox.getSelectedItem();
                                                countDate++;
                                            }
                                            
                                            if(comboBox.getName().equals("Year")){
                                                year = (int) comboBox.getSelectedItem();
                                                countDate++;
                                            }
                                            if(countDate == 3){
//                                            	//Kiểm tra 18 tuổi
//                                                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//                                        		int currentDay = Calendar.getInstance().get(Calendar.DATE);
//                                        		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
//                                				if (currentYear - year < 18) {
//                                				    JOptionPane.showMessageDialog(null, "Tuổi của hội viên chưa đủ 18, vui lòng kiểm tra lại!", "Error", JOptionPane.ERROR_MESSAGE);
//                                				    return;
//                                				} 
//                                				else if (currentYear - year == 18) {
//                                				    // Kiểm tra tháng và ngày
//                                				    if (currentMonth < month || (currentMonth == month && currentDay < day)) {
//                                				    	System.out.println((currentDay) + " " + day);				    
//                                				        JOptionPane.showMessageDialog(null, "Tuổi của hội viên chưa đủ 18, vui lòng kiểm tra lại!", "Error", JOptionPane.ERROR_MESSAGE);
//                                				        return;
//                                				    }
//                                				}
                            					thongTinMoi.add(String.format("%d-%d-%d",year,month,day));
                                				countDate=0;
                                            }
                                        }
                                        else if(smallComponent instanceof JRadioButton){
                                            JRadioButton tempRB = (JRadioButton)smallComponent;
                                            if(tempRB.isSelected()){
                                                thongTinMoi.add(tempRB.getText().toString());
                                            }
                                            else{
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }
                            System.out.println(thongTinMoi +" "+ gioiTinhGoc);
                            if(!thongTinMoi.get(2).equals(gioiTinhGoc)) {
                            	JOptionPane.showMessageDialog(null, "Không được sửa giới tính hội viên","Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                            	return;
                            }
                            //thông báo không cho chỉnh ngày sinh hội viên
                            if(!ngaySinhGoc.equals(thongTinMoi.get(6))) {
                            	JOptionPane.showMessageDialog(null, "Không được sửa ngày sinh của hội viên vui lòng chỉnh lại đúng ngày!","Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                            	return;
                            }
                            
                            String matKhau = thongTinMoi.get(8).trim();
                            //regex mật khẩu
                            String regex_pass = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,20}$";
                            Pattern p_pass = Pattern.compile(regex_pass);
                            Matcher m_pass = p_pass.matcher(matKhau);
                            System.out.println(matKhau);
                            if(!m_pass.matches()){
                            	JOptionPane.showMessageDialog(null, "Mật khẩu phải dài từ 6 đến 20 kí tự bao gồm cả chữ và số!", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                            	return;
                            }
                            
                            //regex email
            				String regex_email = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,7}$";
            				Pattern p_email = Pattern.compile(regex_email);
            				Matcher m_email = p_email.matcher(thongTinMoi.get(3));
            				if (!(thongTinMoi.get(3).length() >= 1 && thongTinMoi.get(3).length() <= 345)) {
            					JOptionPane.showMessageDialog(null, "Email dài từ 1 đến 345 kí tự", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);;
            	            	return;
							}
            				else if (!m_email.matches()) {
            					JOptionPane.showMessageDialog(null, "Email không đúng định dạng", "Thêm hội viên", JOptionPane.ERROR_MESSAGE);;
            	            	return;
            				}

            				//kiểm tra số điện thoại
                            if(!bllQuanLyDanhSach.kiemTraSDT(thongTinMoi.get(5))){
                                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            //Không cho phép sửa họ tên của hội viên
                            if(!thongTinMoi.get(1).equals(tenGoc)) {
                                JOptionPane.showMessageDialog(null, "Không được sửa tên hội viên!", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            
                            //Không cho phép sửa tên tài khoản của hội viên
                            if(!thongTinMoi.get(7).equals(taiKhoanGoc)) {
                            	JOptionPane.showMessageDialog(null, "Không được sửa đổi tên tài khoản!", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            
                            //kiểm tra nếu mã gốc vẫn giống sau khi bấm sửa thì cho phép sửa thông tin của hội viên
                            if(!thongTinMoi.get(0).equals("") && thongTinMoi.get(0).equals(maGoc)) {
                                date = new Date(year - 1900, month - 1, day);
                                HoiVien tempHV = new HoiVien(thongTinMoi.get(0),
    		                            thongTinMoi.get(1),
    		                            thongTinMoi.get(2),
    		                            thongTinMoi.get(3),
    		                            date,
    		                            thongTinMoi.get(5),
    		                            thongTinMoi.get(4),
    		                            thongTinMoi.get(9));
                                DTOTaiKhoan tempTK = new DTOTaiKhoan(thongTinMoi.get(4),
                                		thongTinMoi.get(7),
                                		thongTinMoi.get(8),
                                		"Q0001");
                                if (bllQuanLyDanhSach.suaThongTinTK(tempTK)&&bllQuanLyDanhSach.suaThongTinHV(tempHV)) {
                                    JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin", JOptionPane.DEFAULT_OPTION);
                                    for (int j=0;j<thongTinMoi.size();j++) {
                                		hvList.setValueAt(thongTinMoi.get(j), i, j);
                                    } 
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Không được sửa mã hội viên", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        } 
                        else {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin vui lòng chọn 1 dòng để sửa", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    //tỉm kiếm hội viên
                    else if (e.getActionCommand().equals(cmtNut[2])) {
                        ArrayList<String> thongTin = new ArrayList<String>();
                        Component[] components = bangChinhSua.getComponents();
                        int day=1, month=1, year=2000;
                        // Date date = new Date(year-1900, month-1, day);
                        int dateCount = 0;
                        int gioiTinhTrong = 0;
                        for(Component component : components) {
                            if(component instanceof JPanel){
                                JPanel panel = (JPanel) component;
                                Component[] smallComponents = panel.getComponents();
                                for(Component smallComponent : smallComponents){
                                    if(smallComponent instanceof JTextField){
                                        JTextField textField = (JTextField) smallComponent;
                                        if(textField.getText().equals("")){
                                            thongTin.add("");                                                    
                                        }
                                        else{
                                            thongTin.add(textField.getText());
                                        }
                                    }
                                    if(smallComponent instanceof JRadioButton){
                                        JRadioButton tempRB = (JRadioButton)smallComponent;
                                        if(tempRB.isSelected()){
                                            thongTin.add(tempRB.getText().toString());
                                        }else {
                                        	gioiTinhTrong ++;
                                        }
                                        if(gioiTinhTrong == 2) {
                                        	thongTin.add("");
                                        }
                                    }
                                    if(smallComponent instanceof JComboBox){
                                        @SuppressWarnings("rawtypes")
                                        JComboBox comboBox = (JComboBox) smallComponent;
                                        if(smallComponent.getName().equals("Day")){
                                            day = (int) comboBox.getSelectedItem();                                              
                                            dateCount++;
                                        }
                                        if(smallComponent.getName().equals("Month")){
                                            month = (int) comboBox.getSelectedItem();
                                            dateCount++;
                                        }
                                        if(smallComponent.getName().equals("Year")){
                                            year = (int) comboBox.getSelectedItem();
                                            dateCount++;
                                        }
                                        if(dateCount == 3){
                                            thongTin.add(year+"-"+month+"-"+day);
                                            // date = new Date(year-1900, month-1, day);
                                        }
                                    }
                                }
                            }
                        }
                        if(bllQuanLyDanhSach.timKiemHoiVien(thongTin) != null) {
                        	Map<String, ArrayList<?>> testMap = bllQuanLyDanhSach.timKiemHoiVien(thongTin);
                        	ArrayList<HoiVien> dsHV = new ArrayList<HoiVien> ();
                        	ArrayList<DTOTaiKhoan> dsTK = new ArrayList<DTOTaiKhoan>();
                        	for (Entry<String, ArrayList<?>> entry : testMap.entrySet()) {
                        		String key = entry.getKey(); // Lấy khóa
                        		ArrayList<?> value = entry.getValue(); // Lấy giá trị
                        		if (key.equals("TaiKhoan")) {
                        			dsTK = (ArrayList<DTOTaiKhoan>) value;
                        		}
                        		else if(key.equals("HoiVien")){
                        			dsHV = (ArrayList<HoiVien>)value;
                        		}
                        	}
                        	hvList.setRowCount(0);
                        	for(int i=0;i<dsHV.size();i++) {
                        		hvList.addRow(new Object[]{dsHV.get(i).getMaHoiVien(),
                                        dsHV.get(i).getHoten().trim(),
                                        dsHV.get(i).getGioitinh().trim(),
                                        dsHV.get(i).getMail().trim(),
                                        dsTK.get(i).getIDTaiKhoan().trim(),
                                        dsHV.get(i).getSdt().trim(),
                                        dsHV.get(i).getNgaysinh().trim(),
                                        dsTK.get(i).getTaiKhoan().trim(),
                                        dsTK.get(i).getMatKhau().trim(),
                                        dsHV.get(i).getAnh(),
                                        });
                        	}
                        }
                        else {
                        	JOptionPane.showMessageDialog(null, "Không có kết quả cần tìm!", "Tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
                        	return;
                        }
                    }
		            else if (e.getActionCommand().equals(cmtNut[3])) {
		            	rightPanel.removeAll(); // Xóa tất cả các thành phần con khỏi JPanel
		                rightPanel.revalidate(); // Cập nhật lại JPanel để hiển thị thay đổi
		                rightPanel.repaint(); // Vẽ lại JPanel
		        		rightPanel.setLayout(null);
//		        		BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
//		        		ArrayList<HoiVienCoSo> ds = new ArrayList<>();
//		                Vector<String> dsCoSo = new Vector<>();
//		                dsCoSo = bllQuanLyDanhSach.layDSMaCoSo();
//		                ds = bllQuanLyDanhSach.layDSHoiVienCoSo();
//		                QuanLyHoiVienCoSoCTR qlhvcsCTR = new QuanLyHoiVienCoSoCTR();
//		                qlhvcsCTR.QuanLyHoiVienCoSo(ds,dsCoSo,rightPanel);
//		                
		                JTable dataTable = new JTable();
		                JScrollPane scrollPane = new JScrollPane();
		                JPanel bangChinhSua = new JPanel();
		                
		                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();

		                ArrayList<String> tenCotHV = new ArrayList<String>();
		                ArrayList<HoiVien> dsHV = bllQuanLyDanhSach.getDataHoiVien();
		                tenCotHV.add("Mã hội viên");
		                tenCotHV.add("Họ tên hội viên");
		                tenCotHV.add("Giới tính");
		                tenCotHV.add("Gmail");
		                tenCotHV.add("Mã Tài khoản");
		                tenCotHV.add("Số điện thoại");
		                tenCotHV.add("Ngày sinh");
		                tenCotHV.add("Tài khoản");
		                tenCotHV.add("Mật khẩu");
		                tenCotHV.add("Ảnh đại diện");
		                hoiVienCTR hvCTR = new hoiVienCTR(rightPanel,tenCotHV,dsHV,bangChinhSua,dataTable,scrollPane,bllQuanLyDanhSach);
		                hvCTR.update();
		            } 
                }
            });
            a+=175;
            rightPanel.add(tempBtn);
        }

        rightPanel.add(scrollPane);
        
        //xử lý sự kiện cho bảng
        dataTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = dataTable.getSelectedRow();
                if(i>=0){
                    Component[] components = bangChinhSua.getComponents();
                    int j=0;
                    for(Component a : components){
                        if(a instanceof JPanel){
                            JPanel tempPanel = (JPanel) a;
                            Component[] smallComponents = tempPanel.getComponents();
                            for(Component b : smallComponents){
                                if(b instanceof JTextField){
                                    JTextField tempTF = (JTextField) b;
                                    if(hvList.getValueAt(i, j)==null) {
                                        tempTF.setText("NULL");
                                    }
                                    else {
                                    	tempTF.setText(hvList.getValueAt(i, j).toString().trim());
									}
                                    
                                }
                                else if(b instanceof JRadioButton) { 
                                    JRadioButton tempRB = (JRadioButton) b;
                                    if(tempRB.getText().equals("Nam") && tempRB.getText().equals(hvList.getValueAt(i, j).toString().trim())){
                                        tempRB.setSelected(true);
                                        continue;
                                    }
                                    else if(tempRB.getText().equals("Nữ") && tempRB.getText().equals(hvList.getValueAt(i, j).toString().trim())){
                                        tempRB.setSelected(true);
                                        continue;
                                    }
                                }
                                else if(b instanceof JComboBox){
                                    @SuppressWarnings("rawtypes")
                                    JComboBox cb = (JComboBox) b;
                                    String dateString = hvList.getValueAt(i,6).toString();
                                    String[] parts = dateString.split("-");
                                    int year = Integer.parseInt(parts[0]);
                                    int month = Integer.parseInt(parts[1]);
                                    int day = Integer.parseInt(parts[2]);
                                    if("Day".equals(cb.getName())){
                                        cb.setSelectedItem(day);
                                    }

                                    if ("Month".equals(cb.getName())){
                                        cb.setSelectedItem(month);
                                    }

                                    if ("Year".equals(cb.getName())){
                                        cb.setSelectedItem(year);
                                    }
                                }
                                

                            }
                        j++;
                        }
                    }
                    bangChinhSua.revalidate();
                    bangChinhSua.repaint();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            
        });
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
}
