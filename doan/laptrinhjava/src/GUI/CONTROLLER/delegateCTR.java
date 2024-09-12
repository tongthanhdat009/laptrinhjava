package GUI.CONTROLLER;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class delegateCTR extends JPanel {
	private JPanel rightPanel;
	public delegateCTR(JPanel rightPanel) {
		this.rightPanel = rightPanel;
		this.setSize(1200,900);
		
		JLabel titleLB = new JLabel("Phân quyền");
		titleLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		add(titleLB);
	}
}
