package GUI.CONTROLLER;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollBar;

public class delegateCTR extends JPanel {
	private JPanel rightPanel;
	public delegateCTR(JPanel rightPanel) {
		setBackground(new Color(251, 255, 250));
		this.rightPanel = rightPanel;
		this.setSize(1200,900);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(150, 230, 179));
		panel.setBounds(49, 94, 256, 738);
		add(panel);
		panel.setLayout(null);
		
		JLabel userLB = new JLabel("Người dùng");
		userLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		userLB.setBounds(60, 11, 151, 58);
		panel.add(userLB);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 68, 195, 659);
		panel.add(panel_1);
		JLabel titleLB = new JLabel("Phân quyền");
		titleLB.setBounds(520, 5, 174, 42);
		titleLB.setBackground(new Color(251, 255, 250));
		titleLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));

		
		this.add(titleLB);
		rightPanel.add(this);
		
		JPanel functionPN = new JPanel();
		functionPN.setBackground(new Color(86, 130, 89));
		functionPN.setBounds(340, 94, 823, 738);
		add(functionPN);
		functionPN.setLayout(null);
		
		JLabel funtionLB = new JLabel("Chức năng");
		funtionLB.setForeground(new Color(255, 255, 255));
		funtionLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		funtionLB.setBounds(355, 11, 149, 52);
		functionPN.add(funtionLB);
		
		JPanel funcContent = new JPanel();
		funcContent.setBackground(new Color(204, 252, 203));
		funcContent.setBounds(44, 65, 740, 662);
		functionPN.add(funcContent);
		funcContent.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(723, 0, 17, 662);
		funcContent.add(scrollBar);
	}
}
