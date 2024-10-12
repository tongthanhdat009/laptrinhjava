package GUI.CONTROLLER;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLLQuanLyDanhSach;
import DTO.dichVu;
import GUI.renderer;

import java.util.ArrayList;


import java.awt.*;
import java.awt.event.*;

public class QuanLyBangDichVuCTR {
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm
	String jtf_madv;
	public QuanLyBangDichVuCTR() {
		
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
	public void QuanLyBangDichVu(ArrayList<dichVu> ds, JPanel rightPanel) {
    	xoaHienThi(rightPanel);
    	
    	Font f = new Font("Times New Roman",Font.BOLD,17);
    	JButton them = new JButton();
        ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/dv-them.png");
        Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        them.setPreferredSize(new Dimension (130,35));
        them.setIcon(new ImageIcon(scaleThemBtnImg));
        them.setHorizontalAlignment(SwingConstants.CENTER);
        them.setBorder(null);

    	JButton xoa  = new JButton();
        xoa.setPreferredSize(new Dimension (110,35));
        ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/dv-xoa.png");
        Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        xoa.setPreferredSize(new Dimension (130,35));
        xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
        xoa.setHorizontalAlignment(SwingConstants.CENTER);
        xoa.setBorder(null);

    	JButton sua = new JButton();
        sua.setPreferredSize(new Dimension (110,35));
        ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/dv-sua.png");
        Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        sua.setPreferredSize(new Dimension (130,35));
        sua.setIcon(new ImageIcon(scaleSuaBtnImg));
        sua.setHorizontalAlignment(SwingConstants.CENTER);
        sua.setBorder(null);

    	JButton timkiem = new JButton();
        timkiem.setPreferredSize(new Dimension (110,35));
        timkiem.setPreferredSize(new Dimension (110,35));
        ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/dv-tim.png");
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
    	chucnang.setBounds(5,100,rightPanel.getWidth()-5,38);
        chucnang.setBackground(Color.WHITE);
        rightPanel.add(chucnang);
        
        JLabel jlb_madv = new JLabel("Mã dịch vụ: ");
        jlb_madv.setFont(f);
        
        JLabel jlb_tendv = new JLabel("Tên dịch vụ: ");
        JTextField jtf_tendv = new JTextField();
        jlb_tendv.setFont(f);
        
        JLabel jlb_giadv = new JLabel("Giá dịch vụ: ");
        JTextField jtf_giadv = new JTextField();
        jlb_giadv.setFont(f);
        
        JLabel jlb_thoigian = new JLabel("Thời gian dịch vụ: ");
        JTextField jtf_thoigian = new JTextField();
        jlb_thoigian.setFont(f);
        
        JLabel jlb_mota = new JLabel("Mô tả dịch vụ: ");
        JTextField jtf_mota = new JTextField();
        jlb_mota.setFont(f);
        
        JLabel jlb_img = new JLabel("Nguồn hình ảnh: ");
        JTextField jtf_img = new JTextField();
        jlb_img.setFont(f);
        
        JPanel nhapLieu = new JPanel(null);
        nhapLieu.setBounds(2, 175, rightPanel.getWidth()-20, 175);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        nhapLieu.setBorder(titledBorder);
        nhapLieu.setBackground(new Color(119, 230, 163));

        jlb_madv.setBounds(10, 40, 120, 30);
        jlb_tendv.setBounds(410,40,120,30);
        jtf_tendv.setBounds(550,40,150,30);
        jlb_giadv.setBounds(810,40,120,30);
        jtf_giadv.setBounds(950,40,150,30);
        
        jlb_thoigian.setBounds(10, 120, 150, 30);
        jtf_thoigian.setBounds(150, 120, 150, 30);
        jlb_mota.setBounds(410,120,150,30);
        jtf_mota.setBounds(550,120,150,30);
        jlb_img.setBounds(810,120,150,30);
        jtf_img.setBounds(950,120,150,30);
        
        nhapLieu.add(jlb_tendv);
        nhapLieu.add(jtf_tendv);
        nhapLieu.add(jlb_giadv);
        nhapLieu.add(jtf_giadv);
        nhapLieu.add(jlb_thoigian);
        nhapLieu.add(jtf_thoigian);
        nhapLieu.add(jlb_mota);
        nhapLieu.add(jtf_mota);
        nhapLieu.add(jlb_img);
        nhapLieu.add(jtf_img);
        rightPanel.add(nhapLieu);
        
        DefaultTableModel model = new DefaultTableModel();
        JTable bang = new JTable();
        model.addColumn("Mã dịch vụ");
        model.addColumn("Tên dịch vụ");
        model.addColumn("Giá dịch vụ");
        model.addColumn("Thời gian dịch vụ");
        model.addColumn("Mô tả dịch vụ");
        model.addColumn("Hình ảnh");
        model.setRowCount(0);
        for(int i = 0; i < ds.size();i++) {
        	model.addRow(new Object[] {
        			ds.get(i).getMaDichVu().trim(),
        			ds.get(i).getTenDichVu().trim(),
        			ds.get(i).getGiaDichVu(),
        			ds.get(i).getThoiGian(),
        			ds.get(i).getMoTa().trim(),
        			ds.get(i).getHinhAnh().trim() 
        	});
        }
        bang.setModel(model);
        bang.getTableHeader().setReorderingAllowed(false);
        bang.setFont(new Font("Times New Roman", Font.BOLD, 14));
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
					jtf_madv = model.getValueAt(i, 0).toString().trim();
					jtf_tendv.setText(model.getValueAt(i, 1).toString().trim());
					jtf_giadv.setText(model.getValueAt(i, 2).toString().trim());
					jtf_thoigian.setText(model.getValueAt(i, 3).toString().trim());
					jtf_mota.setText(model.getValueAt(i, 4).toString().trim());
					jtf_img.setText(model.getValueAt(i, 5).toString().trim());
				}
			}
		});
        them.addActionListener(new ActionListener() {
			
			// @Override
			// public void actionPerformed(ActionEvent e) {
			// 	if(jtf_madv.getText().trim().equals("") || jtf_tendv.getText().trim().equals("") || jtf_giadv.getText().trim().equals("") ||
			// 		jtf_thoigian.getText().trim().equals("") || jtf_mota.getText().trim().equals("") || jtf_img.getText().trim().equals("")) {
			// 		JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống","Error",JOptionPane.ERROR_MESSAGE);
			// 		return;
			// 	}
			// 	else {
			// 		BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
			// 		String madv = jtf_madv.getText().trim();
			// 		String tendv = jtf_tendv.getText().trim();
			// 		long giadv = Long.parseLong(jtf_giadv.getText().trim());
			// 		int thoigian = Integer.parseInt(jtf_thoigian.getText().trim());
			// 		String mota = jtf_mota.getText().trim();
			// 		String hinhanh = jtf_img.getText().trim();
			// 		dichVu dv = new dichVu(madv, tendv, giadv, thoigian, mota, hinhanh);
			// 		if(bllqlds.themDV(dv) == true) {
			// 			model.addRow(new Object[] {madv, tendv, giadv, thoigian, mota, hinhanh});
			// 			JOptionPane.showMessageDialog(rightPanel, "Thêm dịch vụ thành công","Success",JOptionPane.INFORMATION_MESSAGE);
						
			// 		}
					
			// 		jtf_madv.setText("");jtf_tendv.setText("");jtf_giadv.setText("");
			// 		jtf_thoigian.setText("");jtf_mota.setText("");jtf_img.setText("");
			// 	}
				
			// }
            @Override
			public void actionPerformed(ActionEvent e) {
				if(jtf_tendv.getText().trim().equals("") || jtf_giadv.getText().trim().equals("") ||
					jtf_thoigian.getText().trim().equals("") || jtf_mota.getText().trim().equals("") || jtf_img.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					if(!(jtf_img.getText().substring(jtf_img.getText().length() - 4).equals(".png")||jtf_img.getText().substring(jtf_img.getText().length() - 4).equals(".jpg")))
					{
						JOptionPane.showMessageDialog(null, "Sai định dạng ảnh");
						return;
					}
					if(jtf_tendv.getText().length()>20) {
						JOptionPane.showMessageDialog(null, "Tên dịch vụ phải <= 30 ký tự");
						return;
					}
					String regexInt = "^[1-9]\\d*$";
                    if(!jtf_giadv.getText().matches(regexInt)) {
                        JOptionPane.showMessageDialog(null, "Giá phải là số dương");
                        return;
                    }
					if(!jtf_thoigian.getText().matches(regexInt)) {
                        JOptionPane.showMessageDialog(null, "Thời gian phải là số dương");
                        return;
                    }
					if(jtf_thoigian.getText().length() > 5)
					{
						JOptionPane.showMessageDialog(null, "Thời gian phải < 100000 ngày");
                        return;
					}
					if(jtf_mota.getText().length()>300) {
						JOptionPane.showMessageDialog(null, "Tên dịch vụ phải <= 300 ký tự");
						return;
					}
					
					BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
					String madv = bllqlds.layMaDichVuchuaTonTai();
					String tendv = jtf_tendv.getText().trim();
					long giadv = Long.parseLong(jtf_giadv.getText().trim());
					int thoigian = Integer.parseInt(jtf_thoigian.getText().trim());
					String mota = jtf_mota.getText().trim();
					String hinhanh = jtf_img.getText().trim();
					dichVu dv = new dichVu(madv, tendv, giadv, thoigian, mota, hinhanh);
					String s = bllqlds.themDV(dv);
					if(s.equals("Thành công")) {
						model.addRow(new Object[] {madv, tendv, giadv, thoigian, mota, hinhanh});
						JOptionPane.showMessageDialog(rightPanel, "Thêm dịch vụ thành công","Success",JOptionPane.INFORMATION_MESSAGE);
						
					}
					else JOptionPane.showMessageDialog(rightPanel,s,"Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
        xoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
					if(bllqlds.xoaDV(jtf_madv)) {
						for(int i = 0;i < model.getRowCount(); i++) {
							if(model.getValueAt(i, 0).equals(jtf_madv)) {
								model.removeRow(i);
								JOptionPane.showMessageDialog(rightPanel, "Xóa dịch vụ thành công","Success",JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(rightPanel, "Mã dịch vụ không tồn tại","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
			}
		});
        sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtf_tendv.getText().trim().equals("") || jtf_giadv.getText().trim().equals("") ||
						jtf_thoigian.getText().trim().equals("") || jtf_mota.getText().trim().equals("") || jtf_img.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(rightPanel, "Thông tin không được để trống","Error",JOptionPane.ERROR_MESSAGE);
						return;
				}
				else {
					if(!(jtf_img.getText().substring(jtf_img.getText().length() - 4).equals(".png")||jtf_img.getText().substring(jtf_img.getText().length() - 4).equals(".jpg")))
					{
						JOptionPane.showMessageDialog(null, "Sai định dạng ảnh");
						return;
					}
					if(jtf_tendv.getText().length()>20) {
						JOptionPane.showMessageDialog(null, "Tên dịch vụ phải <= 30 ký tự");
						return;
					}
					String regexInt = "^[1-9]\\d*$";
                    if(!jtf_giadv.getText().matches(regexInt)) {
                        JOptionPane.showMessageDialog(null, "Giá phải là số dương");
                        return;
                    }
					if(!jtf_thoigian.getText().matches(regexInt)) {
                        JOptionPane.showMessageDialog(null, "Thời gian phải là số dương");
                        return;
                    }
					if(jtf_thoigian.getText().length() > 5)
					{
						JOptionPane.showMessageDialog(null, "Thời gian phải < 100000 ngày");
                        return;
					}
					if(jtf_mota.getText().length()>300) {
						JOptionPane.showMessageDialog(null, "Tên dịch vụ phải <= 300 ký tự");
						return;
					}
					BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
					String tendv = jtf_tendv.getText().trim();
					long giadv = Long.parseLong(jtf_giadv.getText().trim());
					int thoigian = Integer.parseInt(jtf_thoigian.getText().trim());
					String mota = jtf_mota.getText().trim();
					String hinhanh = jtf_img.getText().trim();
					dichVu dv = new dichVu(jtf_madv, tendv, giadv, thoigian, mota, hinhanh);
					String s = bllqlds.suaDV(dv);
					if(s.equals("Thành công")) {
						JOptionPane.showMessageDialog(rightPanel, "Sửa dịch vụ thành công","Success",JOptionPane.INFORMATION_MESSAGE);
						for(int i = 0;i < model.getRowCount();i++) {
							if(model.getValueAt(i,0).equals(jtf_madv)) {
								model.setValueAt(tendv, i, 1);
								model.setValueAt(giadv, i, 2);
								model.setValueAt(thoigian, i, 3);
								model.setValueAt(mota, i, 4);
								model.setValueAt(hinhanh, i, 5);
								break;
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(rightPanel, s,"Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
        timkiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				String ten = jtf_tendv.getText();
				String gia = jtf_giadv.getText();
				if(ten.equals("")&&gia.equals("")) {
					for(int i = 0; i < ds.size();i++) {
						model.addRow(new Object[] {
							ds.get(i).getMaDichVu(),ds.get(i).getTenDichVu(),ds.get(i).getGiaDichVu(),
							ds.get(i).getThoiGian(),ds.get(i).getMoTa(),ds.get(i).getHinhAnh()
						});
					}
				}
				else {
					BLLQuanLyDanhSach bllqlds = new BLLQuanLyDanhSach();
					ArrayList<dichVu> ds = bllqlds.timKiemDV(ten,gia);
					for(dichVu dv : ds) {
						model.addRow(new Object[] {
							dv.getMaDichVu(),dv.getTenDichVu(),dv.getGiaDichVu(),
							dv.getThoiGian(),dv.getMoTa(),dv.getHinhAnh()
						});
					}
				}
			}
		});
        renderer rd = new renderer();
        bang.getColumnModel().getColumn(5).setCellRenderer(rd);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(bang);
        bang.setRowHeight(100);
        scrollPane.setBounds(5, 350, rightPanel.getWidth()-5, rightPanel.getHeight()-390);
        rightPanel.add(scrollPane);
    }
}
