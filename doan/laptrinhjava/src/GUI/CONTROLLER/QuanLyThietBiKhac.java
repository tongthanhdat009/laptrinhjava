package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BLL.BLLQuanLyDanhSach;
import DTO.DSLoaiThietBi;
import DTO.LoaiThietBi;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class QuanLyThietBiKhac extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
    public QuanLyThietBiKhac()
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
                
                textField_3 = new JTextField();
                textField_3.setBounds(501, 30, 190, 36);
                thongTin.add(textField_3);
                textField_3.setColumns(10);
                
                textField_4 = new JTextField();
                textField_4.setBounds(501, 80, 190, 36);
                thongTin.add(textField_4);
                textField_4.setColumns(10);
                
                textField_6 = new JTextField();
                textField_6.setBounds(130, 130, 190, 36);
                thongTin.add(textField_6);
                textField_6.setColumns(10);
                
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

                JTable bangKhac = new JTable();
bangKhac.setBounds(10, 600, 1180, 700); // Đặt kích thước cho bảng

// Tạo DefaultTableModel và thêm các cột
DefaultTableModel modelKhac = new DefaultTableModel();
modelKhac.addColumn("Mã thiết bị");
modelKhac.addColumn("Tên loại thiết bị");
modelKhac.addColumn("Hình ảnh");
modelKhac.addColumn("Giá thiết bị");
modelKhac.addColumn("Ngày bảo hành");

// Gán model cho JTable
bangKhac.setModel(modelKhac);

// Lấy danh sách LoaiThietBi và thêm vào bảng
BLLQuanLyDanhSach ql = new BLLQuanLyDanhSach();
DSLoaiThietBi danhSachKhac = ql.layDSLoaiThietBi(); // Giả sử bạn có lớp dataThietBi để lấy dữ liệu
for (LoaiThietBi khac : danhSachKhac.dsThietBi) {
    modelKhac.addRow(new Object[]{
        khac.getMaThietBi(),
        khac.getTenLoaiThietBi(),
        khac.getHinhAnh(),
        khac.getGiaThietBi(),
        khac.getNgayBaoHanh(),
    });
}
bangKhac.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int row = bangKhac.getSelectedRow();
                        if (row >= 0) {
                            textField.setText(modelKhac.getValueAt(row, 0).toString().trim());
                            textField_1.setText(modelKhac.getValueAt(row, 1).toString().trim());
                            textField_3.setText(modelKhac.getValueAt(row, 3).toString().trim());
                            textField_4.setText(modelKhac.getValueAt(row, 4).toString().trim());       
                            textField_6.setText(modelKhac.getValueAt(row, 2).toString().trim());
                        }
                    }
                });
// Tạo JScrollPane để chứa bảng và cho phép cuộn
JScrollPane scrollPaneKhac = new JScrollPane(bangKhac);
scrollPaneKhac.setBounds(10, 320, 1180, 700); // Đặt kích thước cho JScrollPane

// Thêm JScrollPane vào JPanel
add(scrollPaneKhac);

    }
}
