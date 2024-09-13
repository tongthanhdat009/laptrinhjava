package GUI;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DTO.DTOTaiKhoan;

public class GUIUser extends JFrame {
	//logo
    ImageIcon logo = new ImageIcon("src/asset/img/label/logo.png");
    Image scaleLogoIcon = logo.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
    ImageIcon logo1 = new ImageIcon("src/asset/img/label/logo1.png");
	public GUIUser(DTOTaiKhoan tk) {
		this.setSize(1600, 900);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setIconImage(logo.getImage());
        this.setVisible(true);
	}
	public static void main(String[] args) {
		DTOTaiKhoan tKhoan = new DTOTaiKhoan("TK500", "TKHV500", "MKHV500", "Q0001");
        new GUIUser(tKhoan);
    }
}
