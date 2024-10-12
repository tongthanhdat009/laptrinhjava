package GUI.CONTROLLER;

import javax.swing.*;
import javax.swing.border.LineBorder;

import BLL.BLLPhanQuyen;
import DTO.DTOChucNang;
import DTO.DTOPhanQuyen;
import DTO.DTOQuyen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class delegateCTR extends JPanel {
	private static final long serialVersionUID = 1690072632460921663L;
	private BLLPhanQuyen bllPhanQuyen = new BLLPhanQuyen();
	private JPanel panelContainUser;
	private JPanel userPN;
	private JPanel functionPN;
	private JLabel funtionLB;
	private JScrollPane scrollPane; // Add JScrollPane
	private JPanel funcContent;

	public delegateCTR(JPanel rightPanel) {
		setBackground(new Color(241,255,250));
		this.setSize(1200, 900);
		setLayout(null);

		panelContainUser = new JPanel();
		panelContainUser.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelContainUser.setBackground(new Color(150, 230, 179));
		panelContainUser.setBounds(49, 94, 256, 738);
		add(panelContainUser);
		panelContainUser.setLayout(null);

		JLabel userLB = new JLabel("Người dùng");
		userLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		userLB.setBounds(60, 11, 151, 58);
		panelContainUser.add(userLB);

		userPN = new JPanel();
		userPN.setBorder(new LineBorder(new Color(0, 0, 0)));
		userPN.setBackground(new Color(204, 252, 203));
		userPN.setBounds(33, 68, 195, 659);
		panelContainUser.add(userPN);

		functionPN = new JPanel();
		functionPN.setBorder(new LineBorder(new Color(0, 0, 0)));
		functionPN.setBackground(new Color(86, 130, 89));
		functionPN.setBounds(340, 94, 823, 738);
		add(functionPN);
		functionPN.setLayout(null);

		funtionLB = new JLabel("Chức năng");
		funtionLB.setForeground(new Color(255, 255, 255));
		funtionLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		funtionLB.setBounds(355, 11, 149, 52);
		functionPN.add(funtionLB);

		// Create funcContent panel
		funcContent = new JPanel();
		funcContent.setBackground(new Color(204, 252, 203));
		funcContent.setLayout(null); // Use absolute layout to position components

		// Wrap funcContent with a JScrollPane
		scrollPane = new JScrollPane(funcContent);
		scrollPane.setBounds(44, 65, 750, 600);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Set faster scrolling speed by increasing the unit increment (adjust this value as needed)
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Set the scrolling speed, higher values scroll faster
		
		functionPN.add(scrollPane); // Add JScrollPane to functionPN
		generateUser();
		userPN.setLayout(null);
		rightPanel.setBackground(new Color(241,255,250));
		rightPanel.add(this);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(204, 252, 203));
		titlePanel.setBounds(0, 0, 1200, 50);
		add(titlePanel);
				titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				JLabel titleLB_1 = new JLabel("Phân quyền");
				titlePanel.add(titleLB_1);
				titleLB_1.setBackground(new Color(251, 255, 250));
				titleLB_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
	}

	public void generateUser() {
		ArrayList<DTOQuyen> dsQuyen = bllPhanQuyen.layDSNguoiDung();
		int x_BTN = 10;
		int y_BTN = 10;
		int width = 160;
		int height = 70;
		for (DTOQuyen quyen : dsQuyen) {
			JButton tempBTN = new JButton(quyen.getTenQuyen().trim());
			tempBTN.setBounds(x_BTN, y_BTN, width, height);
			tempBTN.setFocusPainted(false);
			tempBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			tempBTN.addActionListener(new ActionListener() {
				private String MaPhanQuyen;

				public void actionPerformed(ActionEvent e) {
					MaPhanQuyen = getIDQuyenFromBTN(dsQuyen, tempBTN);
					generateFunc(MaPhanQuyen);
				}

				public String getIDQuyenFromBTN(ArrayList<DTOQuyen> dsQuyen, JButton tempBTN) {
					String idQuyen = "";
					for (DTOQuyen quyen : dsQuyen) {
						if (quyen.getTenQuyen().trim().equals(tempBTN.getText().trim())) {
							idQuyen = quyen.getIDQuyen();
							break;
						}
					}
					return idQuyen;
				}
			});
			userPN.add(tempBTN);
			y_BTN += 80;
		}

	}

	public void generateFunc(String iDQuyen) {
		funcContent.removeAll(); // Xóa hết các thành phần trong panel
		funcContent.revalidate(); // Xác nhận lại bố cục mới (layout)
		funcContent.repaint(); // Vẽ lại panel
		ArrayList<DTOChucNang> dsChucNangUser = bllPhanQuyen.layDsCNTheoIDQuyen(iDQuyen);
		ArrayList<DTOChucNang> dsChucNangUserChuCo = bllPhanQuyen.layDsCNChuaCoTheoIDQuyen(iDQuyen);
		int x = 20;
		int y = 20;
		for (DTOChucNang cNang :dsChucNangUser) {
			JPanel tempPanel = new JPanel();
			JLabel tempLabel = new JLabel();
			JCheckBox tempCheckBox = new JCheckBox();
			
			tempLabel.setBounds(0,0,650,50);
			tempLabel.setText(cNang.getTenChucNang().trim());
			tempLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			
			tempCheckBox.setBounds(650, 0, 50,50);
			tempCheckBox.setSelected(true);
			tempCheckBox.setName(cNang.getiDChucNang().trim());
			tempCheckBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!tempCheckBox.isSelected()) {
						int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm phân quyền cho chức năng này chứ?");
						if (result == JOptionPane.YES_OPTION) {
							DTOPhanQuyen pQuyen = new DTOPhanQuyen(iDQuyen, tempCheckBox.getName());
							if(bllPhanQuyen.xoaPhanQuyen(pQuyen)){
								JOptionPane.showMessageDialog(funcContent, "Thay đổi phân quyền thành công");
								generateFunc(iDQuyen);
								return;
							}else {
								JOptionPane.showMessageDialog(funcContent, "Thay đổi phân quyền không thành công!");
								return;
							}
						} else if (result == JOptionPane.NO_OPTION) {
							tempCheckBox.setSelected(true);
						    return;
						} else if (result == JOptionPane.CANCEL_OPTION) {
							tempCheckBox.setSelected(true);
							return;
						} else if (result == JOptionPane.CLOSED_OPTION) {
							tempCheckBox.setSelected(true);
							return;
						}
					}
					else {
						int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn bỏ phân quyền cho chức năng này chứ?");
						if (result == JOptionPane.YES_OPTION) {
							DTOPhanQuyen pQuyen = new DTOPhanQuyen(iDQuyen, tempCheckBox.getName());
							if(bllPhanQuyen.themPhanQuyen(pQuyen)){
								JOptionPane.showMessageDialog(funcContent, "Thay đổi phân quyền thành công");
								generateFunc(iDQuyen);
								return;
							}else {
								JOptionPane.showMessageDialog(funcContent, "Thay đổi phân quyền không thành công!");
								return;
							}
						} else if (result == JOptionPane.NO_OPTION) {
							tempCheckBox.setSelected(false);
						    return;
						} else if (result == JOptionPane.CANCEL_OPTION) {
							tempCheckBox.setSelected(false);
							return;
						} else if (result == JOptionPane.CLOSED_OPTION) {
							tempCheckBox.setSelected(false);
							return;
						}
					}
				}
			});
			
			tempPanel.setBounds(x, y, 680, 50);
			tempPanel.setLayout(null);
			tempPanel.setBackground(new Color(0, 168, 120));

			tempPanel.add(tempCheckBox);
			tempPanel.add(tempLabel);
			
			funcContent.add(tempPanel);
			y += 85;
		}
		for (DTOChucNang cNang : dsChucNangUserChuCo) {
			JPanel tempPanel = new JPanel();
			JLabel tempLabel = new JLabel();
			JCheckBox tempCheckBox = new JCheckBox();
			
			tempLabel.setBounds(0,0,650,50);
			tempLabel.setText(cNang.getTenChucNang().trim());
			tempLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			
			tempCheckBox.setBounds(650, 0, 50,50);
			tempCheckBox.setName(cNang.getiDChucNang().trim());
			tempCheckBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(tempCheckBox.isSelected()) {
						if(!(cNang.getTenChucNang().trim().equals("Mua hàng") || cNang.getTenChucNang().trim().equals("Thông tin cá nhân")) && iDQuyen.equals("Q0001")) {
							JOptionPane.showMessageDialog(funcContent, "Nhóm quyền này chỉ được mua hàng hoặc xem thông tin cá nhân");
							tempCheckBox.setSelected(false);
							return;
						}
						if (!iDQuyen.equals("Q0001")&& (cNang.getTenChucNang().trim().equals("Mua hàng")|| cNang.getTenChucNang().trim().equals("Thông tin cá nhân"))){
							JOptionPane.showMessageDialog(funcContent, "Nhóm quyền này không có quyền được mua hàng hoặc xem thông tin cá nhân");
							tempCheckBox.setSelected(false);
							return;
						}
						if (iDQuyen.equals("Q0002") && (cNang.getTenChucNang().trim().equals("Duyệt phiếu nhập"))){
							JOptionPane.showMessageDialog(null, "Nhóm quyền ngày không có quyền được có chức năng duyệt phiếu nhập");
							tempCheckBox.setSelected(false);
							return;
						}
						int result = JOptionPane.showConfirmDialog(funcContent, "Bạn có chắc muốn thêm phân quyền cho chức năng này chứ?");
						if (result == JOptionPane.YES_OPTION) {
							DTOPhanQuyen pQuyen = new DTOPhanQuyen(iDQuyen, tempCheckBox.getName());
							if(bllPhanQuyen.themPhanQuyen(pQuyen)){
								JOptionPane.showMessageDialog(funcContent, "Thay đổi phân quyền thành công");
								tempPanel.setBackground(new Color(0, 168, 120));
								generateFunc(iDQuyen);
								funcContent.revalidate(); // Xác nhận lại bố cục mới (layout)
								funcContent.repaint(); // Vẽ lại panel
								return;
							}else {
								JOptionPane.showMessageDialog(funcContent, "Thay đổi phân quyền không thành công!");
								return;
							}
						} else if (result == JOptionPane.NO_OPTION) {
							tempCheckBox.setSelected(false);
						    return;
						} else if (result == JOptionPane.CANCEL_OPTION) {
							tempCheckBox.setSelected(false);
							return;
						} else if (result == JOptionPane.CLOSED_OPTION) {
							tempCheckBox.setSelected(false);
							return;
						}
					}
					else {
						int result = JOptionPane.showConfirmDialog(funcContent, "Bạn có chắc muốn bỏ phân quyền cho chức năng này chứ?");

						if (result == JOptionPane.YES_OPTION) {
							DTOPhanQuyen pQuyen = new DTOPhanQuyen(iDQuyen, tempCheckBox.getName());
							if(bllPhanQuyen.xoaPhanQuyen(pQuyen)){
								JOptionPane.showMessageDialog(funcContent, "Thay đổi phân quyền thành công");
								generateFunc(iDQuyen);
								return;
							}else {
								JOptionPane.showMessageDialog(funcContent, "Thay đổi phân quyền không thành công!");
								return;
							}
						} else if (result == JOptionPane.NO_OPTION) {
							tempCheckBox.setSelected(true);
						    return;
						} else if (result == JOptionPane.CANCEL_OPTION) {
							tempCheckBox.setSelected(true);
							return;
						} else if (result == JOptionPane.CLOSED_OPTION) {
							tempCheckBox.setSelected(true);
							return;
						}
					}
				}
			});
			
			tempPanel.setBounds(x, y, 680, 50);
			tempPanel.setLayout(null);
			tempPanel.setBackground(new Color(254, 94, 65));
			
			tempPanel.add(tempLabel);
			tempPanel.add(tempCheckBox);
			
			funcContent.add(tempPanel);
			y += 85;
		}

		// Dynamically set the preferred size of funcContent based on added components
		funcContent.setPreferredSize(new Dimension(740, y));
		funcContent.revalidate(); // Refresh to apply new layout
	}
	
	public ArrayList<DTOChucNang> filterFunc(ArrayList<DTOChucNang> f1, ArrayList<DTOChucNang> f2) {
		// Chuyển array2 thành HashSet để tìm kiếm nhanh hơn
        Set<DTOChucNang> set2 = new HashSet<DTOChucNang>(f2);

        // Tạo danh sách kết quả để lưu phần tử không trùng
        ArrayList<DTOChucNang> result = new ArrayList<DTOChucNang>();

        // Duyệt qua các phần tử của array1
        for (DTOChucNang element : f1) {
            if (set2.contains(element)) {
                result.add(element);
            }
        }

        return result;
	}
}
