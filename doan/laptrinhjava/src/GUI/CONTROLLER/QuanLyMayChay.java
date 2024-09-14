package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class QuanLyMayChay extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
    public QuanLyMayChay()
    {
        setLayout(null);
        setSize(1200,800);
        setBackground(Color.white);
        giaoDien();
    }
    public void giaoDien()
    {
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

                JPanel tinhNang = new JPanel();
                tinhNang.setLayout(new FlowLayout());
                tinhNang.setBounds(0,0,1200,100);
                add(tinhNang);
                tinhNang.add(them);
                tinhNang.add(xoa);
                tinhNang.add(sua);
                tinhNang.setBackground(Color.white);
                
                JPanel thongTin = new JPanel();
                thongTin.setBounds(0, 100, 1200, 213);
                add(thongTin);
                thongTin.setLayout(null);
                
                textField = new JTextField();
                textField.setBounds(130, 30, 190, 36);
                thongTin.add(textField);
                textField.setColumns(10);
                
                textField_1 = new JTextField();
                textField_1.setBounds(130, 80, 190, 36);
                thongTin.add(textField_1);
                textField_1.setColumns(10);
                
                textField_2 = new JTextField();
                textField_2.setBounds(850, 80, 200, 36);
                thongTin.add(textField_2);
                textField_2.setColumns(10);
                
                textField_3 = new JTextField();
                textField_3.setBounds(501, 30, 190, 36);
                thongTin.add(textField_3);
                textField_3.setColumns(10);
                
                textField_4 = new JTextField();
                textField_4.setBounds(501, 80, 190, 36);
                thongTin.add(textField_4);
                textField_4.setColumns(10);
                
                textField_5 = new JTextField();
                textField_5.setBounds(501, 130, 190, 36);
                thongTin.add(textField_5);
                textField_5.setColumns(10);
                
                textField_6 = new JTextField();
                textField_6.setBounds(130, 130, 190, 36);
                thongTin.add(textField_6);
                textField_6.setColumns(10);
                
                textField_7 = new JTextField();
                textField_7.setBounds(850, 30, 200, 36);
                thongTin.add(textField_7);
                textField_7.setColumns(10);
                
                JLabel lblNewLabel = new JLabel("Mã thiết bị:");
                lblNewLabel.setLabelFor(textField);
                lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel.setBounds(10, 39, 100, 27);
                thongTin.add(lblNewLabel);
                
                JLabel lblNewLabel_1 = new JLabel("Tên thiết bị:");
                lblNewLabel_1.setLabelFor(textField_1);
                lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_1.setBounds(10, 89, 110, 27);
                thongTin.add(lblNewLabel_1);
                
                JLabel lblNewLabel_2 = new JLabel("Hình ảnh:");
                lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_2.setBounds(10, 139, 100, 27);
                thongTin.add(lblNewLabel_2);
                
                JLabel lblNewLabel_3 = new JLabel("Giá:");
                lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_3.setBounds(391, 30, 100, 36);
                thongTin.add(lblNewLabel_3);
                
                JLabel lblNewLabel_4 = new JLabel("Ngày bảo hành:");
                lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_4.setBounds(358, 89, 144, 27);
                thongTin.add(lblNewLabel_4);
                
                JLabel lblNewLabel_5 = new JLabel("New label");
                lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_5.setBounds(358, 139, 100, 14);
                thongTin.add(lblNewLabel_5);
                
                JLabel lblNewLabel_6 = new JLabel("New label");
                lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_6.setBounds(740, 41, 100, 14);
                thongTin.add(lblNewLabel_6);
                
                JLabel lblNewLabel_7 = new JLabel("New label");
                lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_7.setBounds(740, 91, 100, 14);
                thongTin.add(lblNewLabel_7);
                
                JLabel lblNewLabel_8 = new JLabel("New label");
                lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_8.setBounds(740, 139, 100, 14);
                thongTin.add(lblNewLabel_8);
                
                textField_8 = new JTextField();
                textField_8.setBounds(850, 127, 200, 39);
                thongTin.add(textField_8);
                textField_8.setColumns(10);
    }
}