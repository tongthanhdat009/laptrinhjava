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
import DTO.NhanVien;

public class QuanLyBangNhanVienCTR {
	private JTextField jtf_manv;
	private JTextField jtf_hoten;
	private ButtonGroup btngr;
	private JTextField jtf_date;
	private JTextField jtf_sdt;
	private JTextField jtf_cccd;
	private JTextField jtf_macoso;
	private JTextField jtf_vaitro;
	private JTextField jtf_luong;
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
	public void QuanLyBangNhanVien(ArrayList<NhanVien> ds, JPanel rightPanel, JLabel chonDanhSachLabel) {
    	xoaHienThi(rightPanel);
    	
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
        chucnang.setBackground(Color.white);
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
        String gioitinh = "";
        if(male.isSelected()) {
			gioitinh = "Nam";
		}else if(female.isSelected()) {
			gioitinh = "Nữ";
		}
        
        JLabel jlb_date = new JLabel("Ngày sinh: ");
        jtf_date = new JTextField();
        jlb_date.setFont(f);
        
        
        JLabel jlb_sdt = new JLabel("Số điện thoại: ");
        jtf_sdt = new JTextField();
        jlb_sdt.setFont(f);
        
        JLabel jlb_cccd = new JLabel("Căn cước: ");
        jtf_cccd = new JTextField();
        jlb_cccd.setFont(f);
        
        JLabel jlb_macoso = new JLabel("Mã cơ sở: ");
        jtf_macoso = new JTextField();
        jlb_macoso.setFont(f);
        
        JLabel jlb_vaitro = new JLabel("Vai trò: ");
        jtf_vaitro = new JTextField();
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
        jtf_date.setBounds(890,50,120,30); 
        
        jlb_sdt.setBounds(10,100,120,30); 
        jtf_sdt.setBounds(130, 100, 120, 30);
        jlb_cccd.setBounds(280,100,120,30);
        jtf_cccd.setBounds(380,100,120,30);
        jlb_macoso.setBounds(530,100,90,30);
        jtf_macoso.setBounds(630,100,120,30);
        jlb_vaitro.setBounds(790,100,90,30);
        jtf_vaitro.setBounds(890,100,120,30);
        
        jlb_luong.setBounds(10,140,90,30);
        jtf_luong.setBounds(130,140,120,30);
        
        nhapLieu.add(jlb_manv);
        nhapLieu.add(jtf_manv);
        nhapLieu.add(jlb_hoten);
        nhapLieu.add(jtf_hoten);
        nhapLieu.add(jlb_gioitinh);
        nhapLieu.add(male);
        nhapLieu.add(female);
        nhapLieu.add(jlb_date);
        nhapLieu.add(jtf_date);
        nhapLieu.add(jlb_sdt);
        nhapLieu.add(jtf_sdt);
        nhapLieu.add(jlb_cccd);
        nhapLieu.add(jtf_cccd);
        nhapLieu.add(jlb_macoso);
        nhapLieu.add(jtf_macoso);
        nhapLieu.add(jlb_vaitro);
        nhapLieu.add(jtf_vaitro);
        nhapLieu.add(jlb_luong);
        nhapLieu.add(jtf_luong);
        
        rightPanel.add(nhapLieu);
        
        DefaultTableModel model = new DefaultTableModel();
        JTable bang = new JTable();
        model.addColumn("Mã nhân viên");
        model.addColumn("Họ và tên");
        model.addColumn("Giới tính");
        model.addColumn("Ngày sinh");
        model.addColumn("Số điện thoại");
        model.addColumn("Số căn cước");
        model.addColumn("Mã cơ sở");
        model.addColumn("Vai trò");
        model.addColumn("Lương");
        
        model.setRowCount(0);
        for(int i = 0; i < ds.size();i++) {
        	model.addRow(new Object[] {
        		ds.get(i).getMaNhanVien(),ds.get(i).getHoten().trim(),ds.get(i).getGioitinh(),ds.get(i).getNgaysinh(),
        		ds.get(i).getSdt(),ds.get(i).getSocccd(),ds.get(i).getMacoso(),ds.get(i).getVaitro(),
        		ds.get(i).getLuong()
        	});
        }
        bang.setModel(model);
        bang.getTableHeader().setReorderingAllowed(false);
        // for (int i = 0; i < bang.getColumnCount(); i++) {
        //     bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
        // }
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
					jtf_date.setText(model.getValueAt(i, 3).toString().trim());
					jtf_sdt.setText(model.getValueAt(i, 4).toString().trim());
					jtf_cccd.setText(model.getValueAt(i, 5).toString().trim());
					jtf_macoso.setText(model.getValueAt(i, 6).toString().trim());
					jtf_vaitro.setText(model.getValueAt(i, 7).toString().trim());
					jtf_luong.setText(model.getValueAt(i, 8).toString().trim());
				}
			}
			
		});
        
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		String dateString = isValidDate(jtf_date.getText());
                    if (jtf_hoten.getText().trim().isEmpty() || btngr.getSelection() == null || jtf_date.getText().trim().isEmpty() || jtf_sdt.getText().trim().isEmpty() || jtf_cccd.getText().trim().isEmpty() || jtf_vaitro.getText().trim().isEmpty() || jtf_luong.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                       
                    } else if(!dateString.equals("Ngày sinh hợp lệ")) {
                    	JOptionPane.showMessageDialog(rightPanel, "Ngày sinh không hợp lệ","Error",JOptionPane.ERROR_MESSAGE);
                    	return;
                    }
                    else {
                    	try {
                    		// Xử lý thêm nhân viên vào cơ sở dữ liệu
                            String[] parts = ((String) jtf_date.getText()).split("-");
                            int year = Integer.parseInt(parts[0]);
                            int month = Integer.parseInt(parts[1]);
                            int day = Integer.parseInt(parts[2]);
                            BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
                            @SuppressWarnings("deprecation")
                            Date date = new Date(year-1900,month,day-1);
                            String ma = bllqlds.layMaNVchuaTonTai();
                            String ten = jtf_hoten.getText().trim();
                            String sdt = jtf_sdt.getText().trim();
                            String cccd = jtf_cccd.getText().trim();
                            String macoso = jtf_macoso.getText().trim();
                            String gioitinh = male.isSelected() ? "Nam" : "Nữ";
                            String vaitro = jtf_vaitro.getText().trim();
                            int luong = Integer.parseInt(jtf_luong.getText());
                            NhanVien nv = new NhanVien(ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, luong);
                            if (bllqlds.themNV(nv) == true) {
                                model.addRow(new Object[]{ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, luong});
                                JOptionPane.showMessageDialog(rightPanel, "Thêm nhân viên thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {
                            	JOptionPane.showMessageDialog(rightPanel, "Thêm nhân viên thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            jtf_manv.setText("");jtf_hoten.setText("");jtf_sdt.setText("");jtf_cccd.setText("");
                            jtf_macoso.setText("");btngr.clearSelection();jtf_vaitro.setText("");jtf_luong.setText("");
                            jtf_date.setText("");
						} catch (Exception e2) {
							System.out.println(e2);
						}
                    }
                
            }
        });
        xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtf_manv.getText().equals("")) {
					JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã nhân viên cần xóa","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
					if(bllqlds.xoaNV(jtf_manv.getText())) {
						for(int i = 0;i < model.getRowCount(); i++) {
							if(model.getValueAt(i, 0).equals(jtf_manv.getText())) {
								model.removeRow(i);
								JOptionPane.showMessageDialog(rightPanel, "Xóa nhân viên thành công","Success",JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(rightPanel, "Mã nhân viên không tồn tại","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
        sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(jtf_manv.getText().trim().equals("") || jtf_macoso.getText().trim().equals("") || jtf_hoten.getText().trim().isEmpty() || btngr.getSelection() == null || jtf_date.getText().trim().isEmpty() || jtf_sdt.getText().trim().isEmpty() || jtf_cccd.getText().trim().isEmpty() || jtf_vaitro.getText().trim().isEmpty() || jtf_luong.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
                    String ngaysinh;
                    try{
                        ngaysinh = isValidDate(jtf_date.getText());
                        String[] parts = ((String) jtf_date.getText()).split("-");
                        int year = Integer.parseInt(parts[0]);
                        int month = Integer.parseInt(parts[1]);
                        int day = Integer.parseInt(parts[2]);
                        @SuppressWarnings("deprecation")
                        Date date = new Date(year - 1900, month, day - 1);
                        String ma = jtf_manv.getText().trim();
                        String ten = jtf_hoten.getText().trim();
                        String sdt = jtf_sdt.getText().trim();
                        String cccd = jtf_cccd.getText().trim();
                        String macoso = jtf_macoso.getText().trim();
                        String gioitinh = male.isSelected() ? "Nam" : "Nữ";
                        String vaitro = jtf_vaitro.getText().trim();
                        int luong = Integer.parseInt((String)jtf_luong.getText());
                        NhanVien nv = new NhanVien(ma, ten, gioitinh, date, sdt, cccd, macoso, vaitro, luong);
                        if(bllqlds.suaThongTinNV(nv)== true) {
                            JOptionPane.showMessageDialog(rightPanel, "Sửa thông tin nhân viên thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                            for(int i = 0;i < model.getRowCount();i++) {
                                if(model.getValueAt(i, 0).equals(ma)) {
                                    model.setValueAt(ten, i, 1);
                                    model.setValueAt(gioitinh, i, 2);
                                    model.setValueAt(date, i, 3);
                                    model.setValueAt(sdt, i, 4);
                                    model.setValueAt(cccd, i, 5);
                                    model.setValueAt(macoso, i, 6);
                                    model.setValueAt(vaitro, i, 7);
                                    model.setValueAt(luong, i, 8);
                                    break;
                                }
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(rightPanel, "Sửa thông tin nhân viên thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(chonDanhSachLabel, ex.getMessage(),"Lỗi",JOptionPane.ERROR_MESSAGE);
                    }
                    
				}
			}
		});
        timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
                
                String manv = jtf_manv.getText().trim(); // Lấy mã nhân viên cần tìm kiếm từ TextField
                
                // Kiểm tra xem mã nhân viên có rỗng không
                if (manv.isEmpty()) {
                    // Nếu mã nhân viên rỗng, hiển thị tất cả các nhân viên trong danh sách
                    for (int i = 0; i < ds.size(); i++) {
                        model.addRow(new Object[] {
                            ds.get(i).getMaNhanVien(), ds.get(i).getHoten(), ds.get(i).getGioitinh(),
                            ds.get(i).getNgaysinh(), ds.get(i).getSdt(), ds.get(i).getSocccd(),
                            ds.get(i).getMacoso(), ds.get(i).getVaitro(), ds.get(i).getLuong()
                        });
                    }
                } else {
                    // Nếu mã nhân viên không rỗng, thực hiện tìm kiếm
                    BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
                    ArrayList<NhanVien> dsNhanVien = bllqlds.timKiemNV(manv);
                    
                    // Hiển thị kết quả tìm kiếm trên bảng
                    for (NhanVien nv : dsNhanVien) {
                        model.addRow(new Object[] {
                            nv.getMaNhanVien(), nv.getHoten(), nv.getGioitinh(), nv.getNgaysinh(),
                            nv.getSdt(), nv.getSocccd(), nv.getMacoso(), nv.getVaitro(), nv.getLuong()
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
	public String isValidDate(String inputdate) {
    	try {
            String dateString = inputdate;
            String[] parts = dateString.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            // @SuppressWarnings("deprecation")
            // Date date = new Date(year - 1900, month - 1, day); // Tạo đối tượng Date từ năm, tháng và ngày
			boolean isLeapYear = Year.of(year).isLeap();
			int maxDayinMonth = 0;
				switch (month) {
				case 2:
					maxDayinMonth = isLeapYear ? 29 : 28;
					break;
				case 4,6,9,11:
					maxDayinMonth = 30;
					break;
				default:
					maxDayinMonth = 31;
				}
			
			if(day >= 1 && day <= maxDayinMonth) {
				return "Ngày sinh hợp lệ";
			}
			else {
				return "Ngày sinh không hợp lệ";
			}
		} catch (Exception e) {
			return "Ngày sinh không hợp lệ";
		}
    	
    }
}
