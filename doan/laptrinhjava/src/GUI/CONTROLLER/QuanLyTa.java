package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BLL.BLLQuanLyDanhSach;
import DTO.Ta;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class QuanLyTa extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
    public QuanLyTa()
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
                lblNewLabel_2.setBounds(740, 83, 100, 27);
                thongTin.add(lblNewLabel_2);
                
                JLabel lblNewLabel_3 = new JLabel("Giá:");
                lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_3.setBounds(391, 30, 100, 36);
                thongTin.add(lblNewLabel_3);
                
                JLabel lblNewLabel_4 = new JLabel("Ngày bảo hành:");
                lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_4.setBounds(358, 89, 144, 27);
                thongTin.add(lblNewLabel_4);
                
                JLabel lblNewLabel_5 = new JLabel("Khối lượng:");
                lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_5.setBounds(358, 130, 133, 36);
                thongTin.add(lblNewLabel_5);
                
                JLabel lblNewLabel_6 = new JLabel("Chất liệu:");
                lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_6.setBounds(10, 128, 110, 36);
                thongTin.add(lblNewLabel_6);
                
                JLabel lblNewLabel_7 = new JLabel("Màu sắc:");
                lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_7.setBounds(746, 30, 100, 36);
                thongTin.add(lblNewLabel_7);
                
                JButton btnNewButton = new JButton("Nhập về cơ sở");
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
                btnNewButton.setBounds(850, 127, 200, 39);
                thongTin.add(btnNewButton);
                
                // Tạo JTable
                // Tạo JTable
                JTable bang = new JTable();
                bang.setBounds(10, 600, 1180, 700); // Đặt kích thước cho bảng

                // Tạo DefaultTableModel và thêm các cột
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Mã thiết bị");
                model.addColumn("Tên loại thiết bị");
                model.addColumn("Hình ảnh");
                model.addColumn("Giá thiết bị");
                model.addColumn("Ngày bảo hành");
                model.addColumn("Khối lượng");
                model.addColumn("Chất liệu");
                model.addColumn("Màu sắc");

                // Gán model cho JTable
                bang.setModel(model);

                // Lấy danh sách Ta và thêm vào bảng
                BLLQuanLyDanhSach ql = new BLLQuanLyDanhSach();
                ArrayList<Ta> danhSachTa = new ArrayList<>();
                danhSachTa = ql.layDSTa();
                for (Ta ta : danhSachTa) {
                    model.addRow(new Object[]{
                        ta.getMaThietBi(),
                        ta.getTenLoaiThietBi(),
                        ta.getHinhAnh(),
                        ta.getGiaThietBi(),
                        ta.getNgayBaoHanh(),
                        ta.getKhoiLuong(),
                        ta.getChatLieu(),
                        ta.getMauSac()
                    });
                }

                bang.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                        int row = bang.getSelectedRow();
                        if (row >= 0) {
                            textField.setText(model.getValueAt(row, 0).toString().trim());
                            textField_1.setText(model.getValueAt(row, 1).toString().trim());
                            textField_2.setText(model.getValueAt(row, 2).toString().trim());
                            textField_3.setText(model.getValueAt(row, 3).toString().trim());
                            textField_4.setText(model.getValueAt(row, 4).toString().trim());
                            textField_5.setText(model.getValueAt(row, 5).toString().trim());
                            textField_6.setText(model.getValueAt(row, 6).toString().trim());
                            textField_7.setText(model.getValueAt(row, 7).toString().trim());
                        }
                    }
                });
                // Tạo JScrollPane để chứa bảng và cho phép cuộn
                JScrollPane scrollPane = new JScrollPane(bang);
                scrollPane.setBounds(0, 320, 1200, 700); // Đặt kích thước cho JScrollPane

                // Thêm JScrollPane vào JPanel
                add(scrollPane);
                
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (textField_1.getText().equals("") || textField_2.getText().equals("") ||
                            textField_3.getText().equals("") || textField_4.getText().equals("") ||
                            textField_5.getText().equals("") || textField_6.getText().equals("") || 
                            textField_7.getText().equals("")) 
                            {
                                JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                                return;
                            } 
                       
                            // Kiểm tra nếu người dùng nhập mã thì cảnh báo
                            if (!textField.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Không cần nhập mã");
                                return;
                            }


                            String maThietBi = "null";  // Đặt là null hoặc bỏ qua mã thiết bị
                            String ten = textField_1.getText();
                            String hinhAnh = textField_2.getText();
                            String giaThietBi = textField_3.getText().trim();
                            int ngayBaoHanh = Integer.parseInt(textField_4.getText().trim());
                            int khoiLuong = Integer.parseInt(textField_5.getText().trim());
                            String chatLieu = textField_7.getText();
                            String mauSac = textField_6.getText();

                            String kq = ql.themThietBiTa(new Ta(maThietBi, ten, hinhAnh, giaThietBi, ngayBaoHanh, "Ta", khoiLuong, chatLieu, mauSac));
                            JOptionPane.showMessageDialog(null, kq);
                            model.setRowCount(0);
                            ArrayList<Ta> danhSachTa = new ArrayList<>();
                            danhSachTa = ql.layDSTa();
                            for (Ta ta : danhSachTa) {
                                model.addRow(new Object[]{
                                    ta.getMaThietBi(),
                                    ta.getTenLoaiThietBi(),
                                    ta.getHinhAnh(),
                                    ta.getGiaThietBi(),
                                    ta.getNgayBaoHanh(),
                                    ta.getKhoiLuong(),
                                    ta.getChatLieu(),
                                    ta.getMauSac()
                                });
                            }
                    }
                });
                xoa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (textField.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Thiếu mã");
                            return;
                        } else {
                            boolean isSuccess = ql.xoaTB(textField.getText());
                            if (isSuccess) {
                                JOptionPane.showMessageDialog(null, "Xóa thành công");
                            } else {
                                JOptionPane.showMessageDialog(null, "Mã không tồn tại");
                            }
                        }
                        model.setRowCount(0);
                        ArrayList<Ta> danhSachTa = new ArrayList<>();
                danhSachTa = ql.layDSTa();
                for (Ta ta : danhSachTa) {
                    model.addRow(new Object[]{
                        ta.getMaThietBi(),
                        ta.getTenLoaiThietBi(),
                        ta.getHinhAnh(),
                        ta.getGiaThietBi(),
                        ta.getNgayBaoHanh(),
                        ta.getKhoiLuong(),
                        ta.getChatLieu(),
                        ta.getMauSac()
                    });
                }
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (textField.getText().equals("") || textField_1.getText().equals("") || 
                            textField_2.getText().equals("") || textField_3.getText().equals("") || 
                            textField_4.getText().equals("") || textField_5.getText().equals("") || 
                            textField_6.getText().equals("") || textField_7.getText().equals("")) 
                        {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                            return;
                        } 
                        else 
                        {
                            String maThietBi = textField.getText();
                            String ten = textField_1.getText();
                            String hinhAnh = textField_2.getText();
                            String giaThietBi = textField_3.getText();
                            int ngayBaoHanh = Integer.parseInt(textField_4.getText());
                            int khoiLuong = Integer.parseInt(textField_5.getText());
                            String chatLieu = textField_6.getText();
                            String mauSac = textField_7.getText();
                
                            // Sửa thiết bị `Ta`
                            String kq = ql.SuaTa(new Ta(maThietBi, ten, hinhAnh, giaThietBi, ngayBaoHanh, "Ta", khoiLuong, chatLieu, mauSac));
                            JOptionPane.showMessageDialog(null, kq);
                        }
                        model.setRowCount(0);
                        ArrayList<Ta> danhSachTa = new ArrayList<>();
                danhSachTa = ql.layDSTa();
                for (Ta ta : danhSachTa) {
                    model.addRow(new Object[]{
                        ta.getMaThietBi(),
                        ta.getTenLoaiThietBi(),
                        ta.getHinhAnh(),
                        ta.getGiaThietBi(),
                        ta.getNgayBaoHanh(),
                        ta.getKhoiLuong(),
                        ta.getChatLieu(),
                        ta.getMauSac()
                    });
                }
                    }
                });                
                
                

    }
}
