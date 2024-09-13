package GUI.CONTROLLER;

import javax.swing.JPanel;
import javax.sound.midi.SysexMessage;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JScrollBar;

import BLL.BLLPhanQuyen;
import DTO.DTOChucNang;
import DTO.DTOQuyen;

public class delegateCTR extends JPanel {
	private static final long serialVersionUID = 1690072632460921663L;
	private BLLPhanQuyen bllPhanQuyen = new BLLPhanQuyen() ;
	private JPanel panelContainUser;
	private JPanel userPN;
	private JPanel functionPN;
	private JLabel userLB;
	private JLabel titleLB;
	private JLabel funtionLB;
	private JPanel funcContent;
	public delegateCTR(JPanel rightPanel) {
		setBackground(new Color(251, 255, 250));
		this.setSize(1200,900);
		setLayout(null);
		
		panelContainUser = new JPanel();
		panelContainUser.setBackground(new Color(150, 230, 179));
		panelContainUser.setBounds(49, 94, 256, 738);
		add(panelContainUser);
		panelContainUser.setLayout(null);
		
		JLabel userLB = new JLabel("Người dùng");
		userLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		userLB.setBounds(60, 11, 151, 58);
		panelContainUser.add(userLB);
		
		userPN = new JPanel();
		userPN.setBackground(new Color(204, 252, 203));
		userPN.setBounds(33, 68, 195, 659);
		panelContainUser.add(userPN);
		JLabel titleLB = new JLabel("Phân quyền");
		titleLB.setBounds(520, 5, 174, 42);
		titleLB.setBackground(new Color(251, 255, 250));
		titleLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));

		
		this.add(titleLB);
		
		functionPN = new JPanel();
		functionPN.setBackground(new Color(86, 130, 89));
		functionPN.setBounds(340, 94, 823, 738);
		add(functionPN);
		functionPN.setLayout(null);
		
		funtionLB = new JLabel("Chức năng");
		funtionLB.setForeground(new Color(255, 255, 255));
		funtionLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		funtionLB.setBounds(355, 11, 149, 52);
		functionPN.add(funtionLB);
		
		funcContent = new JPanel();
		funcContent.setBackground(new Color(204, 252, 203));
		funcContent.setBounds(44, 65, 740, 662);
		funcContent.setLayout(null);
		functionPN.add(funcContent);
		
		generateUser();
		userPN.setLayout(null);
		
		rightPanel.add(this);
	}
	
	public void generateUser() {
		ArrayList<DTOQuyen> dsQuyen = bllPhanQuyen.layDSNguoiDung();
		int x_BTN = 10;
		int y_BTN = 10;
		int width = 160;
		int height = 70;
		for(DTOQuyen quyen : dsQuyen) {
			JButton tempBTN = new JButton(quyen.getTenQuyen().trim());
			tempBTN.setBounds(x_BTN, y_BTN, width, height);
			tempBTN.setFocusPainted(false);
			tempBTN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			tempBTN.addActionListener(new ActionListener() {
				private String MaPhanQuyen;
	        	public void actionPerformed(ActionEvent e) {
	        		MaPhanQuyen = getIDQuyenFromBTN(dsQuyen, tempBTN);
	        		gernerateFunc(MaPhanQuyen);
	        	}
	        	public String getIDQuyenFromBTN(ArrayList<DTOQuyen> dsQuyen, JButton tempBTN) {
	        		String idQuyen = "";
	        		for(DTOQuyen quyen : dsQuyen) {
	        			if(quyen.getTenQuyen().trim().equals(tempBTN.getText().trim())) {
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
	public void gernerateFunc(String iDQuyen) {
		funcContent.removeAll();  // Xóa hết các thành phần trong panel
		funcContent.revalidate(); // Xác nhận lại bố cục mới (layout)
		funcContent.repaint();    // Vẽ lại panel
		ArrayList<DTOChucNang> dsChucNang = bllPhanQuyen.layDsCNTheoIDQuyen(iDQuyen);
		int x = 20;
		int y = 20;
		for(DTOChucNang chucNang : dsChucNang) {
			JPanel tempPanel = new JPanel();
			JLabel tempLabel = new JLabel();
			JCheckBox tempCheckBox = new JCheckBox();
			tempPanel.setBounds(x,y,680,50);
			funcContent.add(tempPanel);
			System.out.println("alo");
			y+=85;
		}
	}
}
