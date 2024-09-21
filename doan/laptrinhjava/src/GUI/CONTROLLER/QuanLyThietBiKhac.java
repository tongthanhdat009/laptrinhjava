package GUI.CONTROLLER;

import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import BLL.BLLNhapThietBi;
import BLL.BLLQuanLyDanhSach;
import DAL.DataCoSo;
import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.LoaiThietBi;
import DTO.Xa;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class QuanLyThietBiKhac extends JPanel {
	private JTextField IDGoodTF;
	private JTextField goodsNameTF;
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
                ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-hv.png");
                Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);

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
                tinhNang.setBounds(0,0,1190,100);
                add(tinhNang);
                tinhNang.add(them);
                tinhNang.add(sua);
                tinhNang.setBackground(new Color(241, 255, 250));
                
                JPanel thongTin = new JPanel();
                thongTin.setBorder(new LineBorder(new Color(0, 0, 0)));
                thongTin.setBackground(new Color(119, 230, 163));
                thongTin.setBounds(0, 100, 1190, 213);
                add(thongTin);
                thongTin.setLayout(null);
                
                IDGoodTF = new JTextField();
                IDGoodTF.setBounds(119, 117, 190, 36);
                thongTin.add(IDGoodTF);
                IDGoodTF.setColumns(10);
                
                goodsNameTF = new JTextField();
                goodsNameTF.setBounds(477, 117, 190, 36);
                thongTin.add(goodsNameTF);
                goodsNameTF.setColumns(10);
                
                textField_6 = new JTextField();
                textField_6.setBounds(764, 117, 190, 36);
                thongTin.add(textField_6);
                textField_6.setColumns(10);
                
                JLabel IDGoodsLB = new JLabel("Mã thiết bị:");
                IDGoodsLB.setLabelFor(IDGoodTF);
                IDGoodsLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                IDGoodsLB.setBounds(119, 79, 177, 27);
                thongTin.add(IDGoodsLB);
                
                JLabel goodsNameLB = new JLabel("Tên thiết bị:");
                goodsNameLB.setLabelFor(goodsNameTF);
                goodsNameLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                goodsNameLB.setBounds(477, 79, 190, 27);
                thongTin.add(goodsNameLB);
                
                JLabel picLB = new JLabel("Hình ảnh:");
                picLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                picLB.setBounds(764, 79, 190, 27);
                thongTin.add(picLB);

                JTable bangKhac = new JTable();
                bangKhac.setFont(new Font("Times New Roman", Font.BOLD, 15));
                bangKhac.getTableHeader().setReorderingAllowed(false);

				bangKhac.setBounds(10, 600, 1180, 700); // Đặt kích thước cho bảng
				
				// Tạo DefaultTableModel và thêm các cột
				DefaultTableModel modelKhac = new DefaultTableModel();
				modelKhac.addColumn("Mã thiết bị");
				modelKhac.addColumn("Tên thiết bị");
				modelKhac.addColumn("Hình ảnh");
				
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
				    });
				}
                    bangKhac.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int row = bangKhac.getSelectedRow();
                        if (row >= 0) {
                            IDGoodTF.setText(modelKhac.getValueAt(row, 0).toString().trim());
                            goodsNameTF.setText(modelKhac.getValueAt(row, 1).toString().trim());
                            textField_6.setText(modelKhac.getValueAt(row, 2).toString().trim());
                        }
                    }
                });
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (goodsNameTF.getText().equals("") || textField_3.getText().equals("") ||
                            textField_4.getText().equals("") || textField_6.getText().equals("")) 
                        {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                            return;
                        } 
                            // Kiểm tra nếu người dùng nhập mã thì cảnh báo
                        if (!IDGoodTF.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Không cần nhập mã");
                            return;
                        }

                        String maThietBi = "null";  // Đặt là null hoặc bỏ qua mã thiết bị
                        String ten = goodsNameTF.getText();
                        String hinhAnh = textField_6.getText();
                        String giaThietBi = textField_3.getText();
                        int ngayBaoHanh = Integer.parseInt(textField_4.getText());
                        String loai = "Khac"; // Hoặc giá trị mặc định

                        // Thêm thiết bị `ThietBiKhac` vào hệ thống
                        String kq = ql.themTB(new LoaiThietBi(maThietBi, ten, hinhAnh, giaThietBi, ngayBaoHanh, loai));
                        JOptionPane.showMessageDialog(null, kq);
                        BLLQuanLyDanhSach ql = new BLLQuanLyDanhSach();
                        modelKhac.setRowCount(0);
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
        		}
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (IDGoodTF.getText().equals("") || goodsNameTF.getText().equals("") || 
                            textField_3.getText().equals("") || textField_4.getText().equals("") || 
                            textField_6.getText().equals("")) 
                        {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                            return;
                        } 
                        else 
                        {
                            String maThietBi = IDGoodTF.getText();
                            String ten = goodsNameTF.getText();
                            String hinhAnh = textField_6.getText();
                            String giaThietBi = textField_3.getText();
                            int ngayBaoHanh = Integer.parseInt(textField_4.getText());
                            String loai = "Khac"; // Hoặc giá trị mặc định
                
                            // Sửa thiết bị `ThietBiKhac`
                            String kq = ql.suaThongTinTB(new LoaiThietBi(maThietBi, ten, hinhAnh, giaThietBi, ngayBaoHanh, loai));
                            JOptionPane.showMessageDialog(null, kq);
                        }
                        BLLQuanLyDanhSach ql = new BLLQuanLyDanhSach();
                        modelKhac.setRowCount(0);
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
                    }
                });
                                
                // Tạo JScrollPane để chứa bảng và cho phép cuộn
                JScrollPane scrollPaneKhac = new JScrollPane(bangKhac);
                scrollPaneKhac.setBounds(0, 320, 1183, 450); // Đặt kích thước cho JScrollPane

                // Thêm JScrollPane vào JPanel
                add(scrollPaneKhac);

    }
}
