package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;

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
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DTOQuyen;
import DTO.DTOTaiKhoan;
import DTO.NhanVien;

public class QuanLyBangNhanVienCTR {
	private JTextField jtf_manv;
	private JTextField jtf_hoten;
	private ButtonGroup btngr;
	private JTextField jtf_sdt;
	private JTextField jtf_cccd;
	private JTextField jtf_luong;
	private JTextField jtf_account;
	private JTextField jtf_password;
	private JTextField jtf_idAccount;

	private JComboBox<String> cbb_vaiTro;
	private JComboBox<String> cbb_CoSo; 
	private JComboBox<Integer> dayCBB;
	private JComboBox<Integer> monthCBB;
	private JComboBox<Integer> yearCBB;
	
	
	private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm

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
	public void QuanLyBangNhanVien(ArrayList<NhanVien> dsNV, ArrayList<DTOTaiKhoan> dsTKNV,ArrayList<DTOQuyen> dsQuyen, JPanel rightPanel) {
    	rightPanel.setBackground(new Color(241,255,250));
		BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
    	xoaHienThi(rightPanel);
    	JLabel title = new JLabel("Quản lý nhân viên");
    	title.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 35));
    	title.setBounds(450, 0, 1000,60);      
    	rightPanel.add(title);
    	Font f = new Font("Times New Roman",Font.BOLD,17);
    	JButton them = new JButton();
        ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-hv.png");
        Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        them.setPreferredSize(new Dimension (130,35));
        them.setIcon(new ImageIcon(scaleThemBtnImg));
        them.setHorizontalAlignment(SwingConstants.CENTER);
        them.setBorder(null);

    	JButton xoa  = new JButton();
        xoa.setPreferredSize(new Dimension (110,35));
        ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-hv.png");
        Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        xoa.setPreferredSize(new Dimension (130,35));
        xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
        xoa.setHorizontalAlignment(SwingConstants.CENTER);
        xoa.setBorder(null);

    	JButton sua = new JButton();
        sua.setPreferredSize(new Dimension (110,35));
        ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-hv.png");
        Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        sua.setPreferredSize(new Dimension (130,35));
        sua.setIcon(new ImageIcon(scaleSuaBtnImg));
        sua.setHorizontalAlignment(SwingConstants.CENTER);
        sua.setBorder(null);

    	JButton timkiem = new JButton();
        timkiem.setPreferredSize(new Dimension (110,35));
        timkiem.setPreferredSize(new Dimension (110,35));
        ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-hv.png");
        Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        timkiem.setPreferredSize(new Dimension (130,35));
        timkiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
        timkiem.setHorizontalAlignment(SwingConstants.CENTER);
        timkiem.setBorder(null);

    	JPanel chucnang = new JPanel(new FlowLayout());
    	chucnang.add(them);
    	chucnang.add(xoa);
    	chucnang.add(sua);
    	chucnang.add(timkiem);
    	chucnang.setBounds(5,100,rightPanel.getWidth()-5,40);
        chucnang.setBackground(new Color(241,255,250));
        rightPanel.add(chucnang);
        
        JLabel jlb_manv = new JLabel("Mã nhân viên: ");
        jtf_manv = new JTextField();
        jlb_manv.setFont(f);
        
        JLabel jlb_hoten = new JLabel("Họ và tên: ");
        jtf_hoten = new JTextField();
        jlb_hoten.setFont(f);
        
        JLabel jlb_gioitinh = new JLabel("Giới tính: ");
        JRadioButton male = new JRadioButton("Nam");
        male.setBackground(new Color(119, 230, 163));
        JRadioButton female = new JRadioButton("Nữ");
        female.setBackground(new Color(119, 230, 163));
        jlb_gioitinh.setFont(f);
        male.setFont(f);
        female.setFont(f);
        btngr = new ButtonGroup();
        btngr.add(male);
        btngr.add(female);
        
        JLabel jlb_account = new JLabel("Tài khoản:");
        jtf_account = new JTextField();
        jlb_account.setFont(f);
        
        JLabel jlb_password = new JLabel("Mật khẩu:");
        jtf_password = new JTextField();
        jlb_password.setFont(f);
        
        JLabel jlb_idAccount = new JLabel("ID Tài Khoản:");
        jtf_idAccount = new JTextField();
        jtf_idAccount.setEditable(false);
        jlb_idAccount.setFont(f);
        
        JLabel jlb_date = new JLabel("Ngày sinh: ");
        jlb_date.setFont(f);
        dayCBB = new JComboBox<Integer>();
        for(int day=1; day<=31 ;day++){
            dayCBB.addItem(day);
        }

        dayCBB.setFont(f);
        dayCBB.setBackground(Color.white);
        dayCBB.setName("Day");
        
        monthCBB = new JComboBox<Integer>();
        for(int month=1; month<=12 ;month++){
            monthCBB.addItem(month);
        }
        monthCBB.setFont(f);
        monthCBB.setBackground(Color.white);
        monthCBB.setName("Month");
        
        yearCBB = new JComboBox<Integer>();
        for(int year=2024;year>=1900;year--){
            yearCBB.addItem(year);
        }
        yearCBB.setFont(f);
        yearCBB.setBackground(Color.white);
        yearCBB.setName("Year");
        
     // Listener thay đổi tháng và năm để cập nhật ngày
        ActionListener updateDaysListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDays(dayCBB, monthCBB, yearCBB);
            }
        };
        monthCBB.addActionListener(updateDaysListener);
        yearCBB.addActionListener(updateDaysListener);
        
        JLabel jlb_sdt = new JLabel("Số điện thoại: ");
        jtf_sdt = new JTextField();
        jlb_sdt.setFont(f);
        
        JLabel jlb_cccd = new JLabel("Căn cước: ");
        jtf_cccd = new JTextField();
        jlb_cccd.setFont(f);
        
        JLabel jlb_macoso = new JLabel("Mã cơ sở: ");
        cbb_CoSo = new JComboBox<String>();
        DSCoSo dsCS = bllQuanLyDanhSach.layDsCoSo();
        cbb_CoSo.addItem("Cơ sở");
        for(CoSo cs: dsCS.dsCoSo) {
        	cbb_CoSo.addItem(cs.getMaCoSo());
        }
        jlb_macoso.setFont(f);
        
        JLabel jlb_vaitro = new JLabel("Vai trò: ");
        ArrayList<String> dsTenQuyen = bllQuanLyDanhSach.layDSTenQuyenNV();
        cbb_vaiTro = new JComboBox<>();
        cbb_vaiTro.addItem("Vai trò");
        for(String a : dsTenQuyen) {
        	cbb_vaiTro.addItem(a.trim());
        }
        jlb_vaitro.setFont(f);
        
        JLabel jlb_luong = new JLabel("Lương: ");
        jtf_luong = new JTextField();
        jlb_luong.setFont(f);
        
        
        
        JPanel nhapLieu = new JPanel(null);
        nhapLieu.setBounds(2, 175, rightPanel.getWidth()-20, 175);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        nhapLieu.setBorder(titledBorder);
        nhapLieu.setBackground(new Color(119, 230, 163));

        jlb_manv.setBounds(10, 50, 120, 30); 
        jtf_manv.setBounds(130, 50, 120, 30); 
        jlb_hoten.setBounds(280, 50, 120, 30); 
        jtf_hoten.setBounds(380, 50, 120, 30); 
        jlb_gioitinh.setBounds(530, 50, 90, 30);
        male.setBounds(630, 50, 70, 30); 
        female.setBounds(720, 50, 60, 30); 
        jlb_date.setBounds(790, 50, 90, 30); 
        dayCBB.setBounds(890,50,60,30);
        monthCBB.setBounds(990,50,75,30);
        yearCBB.setBounds(1090,50,75,30);
        
        jlb_sdt.setBounds(10,100,120,30); 
        jtf_sdt.setBounds(130, 100, 120, 30);
        jlb_cccd.setBounds(280,100,120,30);
        jtf_cccd.setBounds(380,100,120,30);
        jlb_macoso.setBounds(530,100,90,30);
        cbb_CoSo.setBounds(630,100,120,30);
        jlb_vaitro.setBounds(790,100,90,30);
        cbb_vaiTro.setBounds(890,100,120,30);
        
        jlb_luong.setBounds(10,140,90,30);
        jtf_luong.setBounds(130,140,120,30);
        jlb_account.setBounds(280,140,90,30);
        jtf_account.setBounds(380,140,120,30);
        jlb_password.setBounds(530,140,90,30);
        jtf_password.setBounds(630,140,120,30);
        jlb_idAccount.setBounds(790,140,120,30);
        jtf_idAccount.setBounds(890,140,120,30);
        
        nhapLieu.add(jlb_manv);
        nhapLieu.add(jtf_manv);
        nhapLieu.add(jlb_hoten);
        nhapLieu.add(jtf_hoten);
        nhapLieu.add(jlb_gioitinh);
        nhapLieu.add(male);
        nhapLieu.add(female);
        nhapLieu.add(jlb_date);
        nhapLieu.add(dayCBB);
        nhapLieu.add(monthCBB);
        nhapLieu.add(yearCBB);
        nhapLieu.add(jlb_sdt);
        nhapLieu.add(jtf_sdt);
        nhapLieu.add(jlb_cccd);
        nhapLieu.add(jtf_cccd);
        nhapLieu.add(jlb_macoso);
        nhapLieu.add(cbb_CoSo);
        nhapLieu.add(jlb_vaitro);
        nhapLieu.add(cbb_vaiTro);
        nhapLieu.add(jlb_luong);
        nhapLieu.add(jtf_luong);
        nhapLieu.add(jlb_account);
        nhapLieu.add(jtf_account);
        nhapLieu.add(jlb_password);
        nhapLieu.add(jtf_password);
        nhapLieu.add(jlb_idAccount);
        nhapLieu.add(jtf_idAccount);
        
        rightPanel.add(nhapLieu);
        
        DefaultTableModel model = new DefaultTableModel();
        JTable bang = new JTable();
        bang.setRowHeight(30);
        model.addColumn("Mã nhân viên");
        model.addColumn("Họ và tên");
        model.addColumn("Giới tính");
        model.addColumn("Ngày sinh");
        model.addColumn("Số điện thoại");
        model.addColumn("Số căn cước");
        model.addColumn("Mã cơ sở");
        model.addColumn("Vai trò");
        model.addColumn("Lương");
        model.addColumn("Tài khoản");
        model.addColumn("Mật khẩu");
        model.addColumn("ID Tài Khoản");
        
        model.setRowCount(0);
        System.out.println(dsNV.size() +" "+ dsQuyen.size());
        
        for(int i = 0; i < dsNV.size();i++) {
        	model.addRow(new Object[] {
    			dsNV.get(i).getMaNhanVien(),dsNV.get(i).getHoten().trim(),dsNV.get(i).getGioitinh(),dsNV.get(i).getNgaysinh(),
    			dsNV.get(i).getSdt(),dsNV.get(i).getSocccd(),dsNV.get(i).getMacoso(),dsQuyen.get(i).getTenQuyen().trim(),
    			dsNV.get(i).getLuong(),dsTKNV.get(i).getTaiKhoan(), dsTKNV.get(i).getMatKhau(),dsNV.get(i).getIDTaiKhoan()
        	});
        }
        bang.setModel(model);
        bang.getTableHeader().setReorderingAllowed(false);
        bang.setFont(new Font("Times New Roman", Font.BOLD, 14));
        bang.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = bang.getSelectedRow();
				if(i >= 0) {
					jtf_manv.setText(model.getValueAt(i, 0).toString().trim());
					jtf_hoten.setText(model.getValueAt(i, 1).toString().trim());
					String gioitinh = (model.getValueAt(i, 2).toString().trim());
					if(gioitinh.equals("Nam")) {
						male.setSelected(true);
					}else {
						female.setSelected(true);
					}
					 @SuppressWarnings("rawtypes")
                     String dateString = model.getValueAt(i,3).toString();
                     String[] parts = dateString.split("-");
                     int year = Integer.parseInt(parts[0]);
                     int month = Integer.parseInt(parts[1]);
                     int day = Integer.parseInt(parts[2]);
                     if("Day".equals(dayCBB.getName())){
                         dayCBB.setSelectedItem(day);
                     }

                     if ("Month".equals(monthCBB.getName())){
                         monthCBB.setSelectedItem(month);
                     }

                     if ("Year".equals(yearCBB.getName())){
                         yearCBB.setSelectedItem(year);
                     }
					jtf_sdt.setText(model.getValueAt(i, 4).toString().trim());
					jtf_cccd.setText(model.getValueAt(i, 5).toString().trim());
					cbb_CoSo.setSelectedItem(model.getValueAt(i, 6).toString().trim());
					cbb_vaiTro.setSelectedItem(model.getValueAt(i, 7).toString().trim());
					jtf_luong.setText(model.getValueAt(i, 8).toString().trim());
					jtf_account.setText(model.getValueAt(i, 9).toString().trim());
					jtf_password.setText(model.getValueAt(i, 10).toString().trim());
					jtf_idAccount.setText(model.getValueAt(i, 11).toString().trim());
				}
			}
			
		});
//        thêm nhân viên
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (jtf_password.getText().trim().isEmpty()
                    		||jtf_account.getText().trim().isEmpty()
                    		||jtf_hoten.getText().trim().isEmpty() 
                    		|| btngr.getSelection() == null 
                    		|| jtf_sdt.getText().trim().isEmpty() 
                    		|| jtf_cccd.getText().trim().isEmpty()
                    		|| jtf_luong.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                       
                    } 
                    else if(jtf_password.getText().length() < 6) {
                    	JOptionPane.showMessageDialog(rightPanel, "Mật khẩu phải từ 6 kí tự","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                    	try {
                    		// Xử lý thêm nhân viên vào cơ sở dữ liệu
                            
                            @SuppressWarnings("deprecation")
                            BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
                            Date date = new Date(2000,1,1);
                            String ma = bllqlds.layMaNVchuaTonTai();
                            String ten = jtf_hoten.getText().trim();
                            String sdt = jtf_sdt.getText().trim();
                            String cccd = jtf_cccd.getText().trim();
                            String gioitinh = male.isSelected() ? "Nam" : "Nữ";
                            String matKhau = jtf_password.getText().trim();
                            String taiKhoan = jtf_account.getText().trim();
                            String IDTaiKhoan = bllqlds.kiemTraMaTK().trim();
                            String vaitro = cbb_vaiTro.getSelectedItem().toString().trim();
                            if(vaitro.equals("Vai trò")) {
                                JOptionPane.showMessageDialog(rightPanel, "Vui lòng chọn vai trò của nhân viên", "Chọn vai trò nhân viên", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            String macoso = cbb_CoSo.getSelectedItem().toString().trim();
                            if(macoso.equals("Cơ sở")) {
                                JOptionPane.showMessageDialog(rightPanel, "Vui lòng chọn cơ sở làm việc của nhân viên", "Chọn vai trò nhân viên", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        	int year = Integer.parseInt(yearCBB.getSelectedItem().toString());
                            int month = Integer.parseInt(monthCBB.getSelectedItem().toString());
                            int day = Integer.parseInt(dayCBB.getSelectedItem().toString());
                            date = new Date(year-1900,month-1,day);
                            int luong = Integer.parseInt(jtf_luong.getText());
                            NhanVien nv = new NhanVien(ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, IDTaiKhoan, luong);
                            String IDQuyen = new String();
                            if(vaitro.equals("Nhân viên")) {
                            	IDQuyen = "Q0002";
                            }
                            else {
                            	IDQuyen = "Q0003";
                            }
                            DTOTaiKhoan tknv = new DTOTaiKhoan(bllqlds.kiemTraMaTK(),taiKhoan,matKhau,IDQuyen);
                            if (bllqlds.themTK(tknv) && bllqlds.themNV(nv) == true) {
                            	JOptionPane.showMessageDialog(rightPanel, "Thêm nhân viên thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                model.addRow(new Object[]{ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, luong, taiKhoan, matKhau, IDTaiKhoan});
                            }
                            else {
                            	JOptionPane.showMessageDialog(rightPanel, "Thêm nhân viên không thành công!", "Error", JOptionPane.ERROR_MESSAGE);
                            	return;
                            }
                            jtf_manv.setText("");jtf_hoten.setText("");jtf_sdt.setText("");jtf_cccd.setText("");
                            cbb_CoSo.setSelectedItem("Cơ sở");;btngr.clearSelection();cbb_vaiTro.setSelectedItem("Nhân viên");jtf_luong.setText("");
                            jtf_account.setText("");jtf_password.setText("");jtf_idAccount.setText("");
						} catch (Exception e2) {
							System.out.println(e2);
						}
                    }
                
            }
        });
        //xóa nhân viên
        xoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
				int i = bang.getSelectedRow();
				if(i>=0) {
					if(bllqlds.xoaNV(jtf_manv.getText()) && bllqlds.xoaTK(jtf_idAccount.getText())) {
						JOptionPane.showMessageDialog(rightPanel, "Xóa nhân viên thành công","Success",JOptionPane.INFORMATION_MESSAGE);
						jtf_manv.setText("");jtf_hoten.setText("");jtf_sdt.setText("");jtf_cccd.setText("");
                        cbb_CoSo.setSelectedItem("Cơ sở");;btngr.clearSelection();cbb_vaiTro.setSelectedItem("Nhân viên");jtf_luong.setText("");
                        jtf_account.setText("");jtf_password.setText("");jtf_idAccount.setText("");dayCBB.setSelectedItem(1);monthCBB.setSelectedItem(1);yearCBB.setSelectedItem(2000);
                        model.removeRow(i);
						return;
					}
					else {
						JOptionPane.showMessageDialog(rightPanel, "Xóa nhân viên không thành công","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else {
					JOptionPane.showMessageDialog(rightPanel, "Vui lòng chọn 1 dòng dữ liệu muốn xóa","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
        //sửa thông tin nhân viên
        sua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = bang.getSelectedRow();
				BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
                Date date;
                String maGoc = new String();
				if(i>=0) {
					maGoc = bang.getValueAt(i, 0).toString().trim();
					int year = Integer.parseInt(yearCBB.getSelectedItem().toString());
					int month = Integer.parseInt(monthCBB.getSelectedItem().toString());
					int day = Integer.parseInt(dayCBB.getSelectedItem().toString());
					date = new Date(year - 1900, month - 1, day);
					String ma = jtf_manv.getText().trim();
					String ten = jtf_hoten.getText().trim();
					String sdt = jtf_sdt.getText().trim();
					String cccd = jtf_cccd.getText().trim();
					String macoso = cbb_CoSo.getSelectedItem().toString();
					String gioitinh = male.isSelected() ? "Nam" : "Nữ";
					String vaitro = cbb_vaiTro.getSelectedItem().toString();
					String matKhau = jtf_password.getText().trim();
					System.out.println(matKhau);
					String taiKhoan = jtf_account.getText().trim();
					String IDTaiKhoan = jtf_idAccount.getText().trim();
                    String luong = (String)jtf_luong.getText();
                    int newLuong = 0;
                    String IDQuyen = new String();
                    if(vaitro.equals("Nhân viên")) {
                    	IDQuyen = "Q0002";
                    }
                    else {
                    	IDQuyen = "Q0003";
                    }
					if(!maGoc.equals(jtf_manv.getText())) {
						JOptionPane.showMessageDialog(rightPanel, "Không được sửa mã nhân viên","Sửa thông tin",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(!bllqlds.kiemTraSDT(sdt)) {
						JOptionPane.showMessageDialog(rightPanel, "Số điện thoại không hợp lệ","Sửa thông tin",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(matKhau.length() < 6) {
						JOptionPane.showMessageDialog(rightPanel, "Mật khẩu phải từ 6 kí tự trở lên","Sửa thông tin",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(bllqlds.kiemTraLuong(luong)==-1) {
						JOptionPane.showMessageDialog(rightPanel, "Lương không hợp lệ","Sửa thông tin",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						newLuong = Integer.parseInt(luong); 
					}
                    DTOTaiKhoan tknv = new DTOTaiKhoan(IDTaiKhoan,taiKhoan,matKhau,IDQuyen);
                    NhanVien nv = new NhanVien(ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, IDTaiKhoan, newLuong);
                    if(bllqlds.suaThongTinTK(tknv) && bllqlds.suaThongTinNV(nv) && bllqlds.ganLaiQuyenTK(IDTaiKhoan, IDQuyen) ) {
						JOptionPane.showMessageDialog(rightPanel, "Sửa thông tin thành công!","Sửa thông tin",JOptionPane.INFORMATION_MESSAGE);
						bang.setValueAt(ma, i, 0);
						bang.setValueAt(ten, i, 1);
						bang.setValueAt(gioitinh, i, 2);
						bang.setValueAt(date, i, 3);
						bang.setValueAt(sdt, i, 4);
						bang.setValueAt(cccd, i, 5);
						bang.setValueAt(macoso, i, 6);
						bang.setValueAt(vaitro, i, 7);
						bang.setValueAt(luong, i, 8);
						bang.setValueAt(taiKhoan, i, 9);
						bang.setValueAt(matKhau, i, 10);
						return;
                    }
                    else {
						JOptionPane.showMessageDialog(rightPanel, "Sửa thông tin không thành công!","Sửa thông tin",JOptionPane.INFORMATION_MESSAGE);
						return;
                    }
				}
				else {
                    JOptionPane.showMessageDialog(null, "Thiếu thông tin vui lòng chọn 1 dòng để sửa", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                    return;
                }
			}

		});
//        tìm kiếm nhân viên
        timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
				BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
				int year = Integer.parseInt(yearCBB.getSelectedItem().toString());
				int month = Integer.parseInt(monthCBB.getSelectedItem().toString());
				int day = Integer.parseInt(dayCBB.getSelectedItem().toString());
				Date date = new Date(year - 1900, month, day - 1);
				String ma = jtf_manv.getText().trim();
				String ten = jtf_hoten.getText().trim();
				String sdt = jtf_sdt.getText().trim();
				String cccd = jtf_cccd.getText().trim();
				String macoso = cbb_CoSo.getSelectedItem().toString();
				String gioitinh = new String();
				if(male.isSelected()) {
					gioitinh = male.getText();
				}
				if(female.isSelected()) {
					gioitinh = female.getText();
				}
				String vaitro = cbb_vaiTro.getSelectedItem().toString();
				String matKhau = jtf_password.getText().trim();
				String taiKhoan = jtf_account.getText().trim();
				String IDTaiKhoan = jtf_idAccount.getText().trim();
                String luong = (String)jtf_luong.getText();
                int newLuong = 0;
				if(bllqlds.kiemTraLuong(luong)==-1) {
					newLuong = 0; 
				}
                NhanVien nv = new NhanVien(ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, IDTaiKhoan, newLuong);
                ArrayList<NhanVien> dsNhanVien = bllqlds.timKiemNV(nv);
                ArrayList<DTOTaiKhoan> dsTKNV2 = bllqlds.timKiemTKNV(nv);
                if(bllqlds.timKiemNV(nv).size()!=0) {
                	JOptionPane.showMessageDialog(rightPanel, "Tìm kiếm thành công","Tìm kiếm thông tin",JOptionPane.INFORMATION_MESSAGE);
                	for (int i = 0; i < dsNhanVien.size(); i++) {
                		model.addRow(new Object[] {
                    			dsNhanVien.get(i).getMaNhanVien(),
                    			dsNhanVien.get(i).getHoten().trim(),
                    			dsNhanVien.get(i).getGioitinh(),
                    			dsNhanVien.get(i).getNgaysinh(),
                    			dsNhanVien.get(i).getSdt(),
                    			dsNhanVien.get(i).getSocccd(),
                    			dsNhanVien.get(i).getMacoso(),
                    			dsNhanVien.get(i).getVaitro().trim(),
                    			dsNhanVien.get(i).getLuong(),
                    			dsTKNV2.get(i).getTaiKhoan(),
                    			dsTKNV2.get(i).getMatKhau(),
                    			dsNhanVien.get(i).getIDTaiKhoan()
                        	});
                    }
                	return;
                }
                else {
                	JOptionPane.showMessageDialog(rightPanel, "Tìm kiếm không thành công vui lòng chọn thêm đầy đủ thông tin như giới tính, vai trò, cơ sở","Tìm kiếm thông tin",JOptionPane.ERROR_MESSAGE);
                	for(int i = 0; i < dsNV.size();i++) {
                    	model.addRow(new Object[] {
                			dsNV.get(i).getMaNhanVien(),dsNV.get(i).getHoten().trim(),dsNV.get(i).getGioitinh(),dsNV.get(i).getNgaysinh(),
                			dsNV.get(i).getSdt(),dsNV.get(i).getSocccd(),dsNV.get(i).getMacoso(),dsQuyen.get(i).getTenQuyen().trim(),
                			dsNV.get(i).getLuong(),dsTKNV.get(i).getTaiKhoan(), dsTKNV.get(i).getMatKhau(),dsNV.get(i).getIDTaiKhoan()
                    	});
                    }
                }
            }
        });
        

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(bang);
        scrollPane.setBounds(5, 350, rightPanel.getWidth()-20, rightPanel.getHeight()-390);
        rightPanel.add(scrollPane);
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
