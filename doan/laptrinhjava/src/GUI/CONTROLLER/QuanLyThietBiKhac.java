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
                tinhNang.setBackground(new Color(241, 255, 250));
                
                JPanel thongTin = new JPanel();
                thongTin.setBorder(new LineBorder(new Color(0, 0, 0)));
                thongTin.setBackground(new Color(119, 230, 163));
                thongTin.setBounds(0, 100, 1200, 213);
                add(thongTin);
                thongTin.setLayout(null);
                
                textField = new JTextField();
                textField.setBounds(130, 30, 190, 36);
                thongTin.add(textField);
                textField.setColumns(10);
                
                textField_1 = new JTextField();
                textField_1.setBounds(130, 112, 190, 36);
                thongTin.add(textField_1);
                textField_1.setColumns(10);
                
                textField_3 = new JTextField();
                textField_3.setBounds(501, 30, 190, 36);
                thongTin.add(textField_3);
                textField_3.setColumns(10);
                
                textField_4 = new JTextField();
                textField_4.setBounds(501, 112, 190, 36);
                thongTin.add(textField_4);
                textField_4.setColumns(10);
                
                textField_6 = new JTextField();
                textField_6.setBounds(857, 30, 190, 36);
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
                lblNewLabel_1.setBounds(10, 115, 110, 27);
                thongTin.add(lblNewLabel_1);
                
                JLabel lblNewLabel_2 = new JLabel("Hình ảnh:");
                lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_2.setBounds(747, 33, 100, 27);
                thongTin.add(lblNewLabel_2);
                
                JLabel lblNewLabel_3 = new JLabel("Giá:");
                lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_3.setBounds(391, 30, 100, 36);
                thongTin.add(lblNewLabel_3);
                
                JLabel lblNewLabel_4 = new JLabel("Ngày bảo hành:");
                lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
                lblNewLabel_4.setBounds(357, 115, 144, 27);
                thongTin.add(lblNewLabel_4);
                
                JButton btnNewButton = new JButton("Nhập về cơ sở");
                btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
                btnNewButton.setBounds(857, 112, 190, 36);
                thongTin.add(btnNewButton);
                 btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        JPanel thongTinChiTiet = new JPanel(new GridLayout(5,1));
                        thongTinChiTiet.setPreferredSize(new Dimension(300,150));
                        JLabel ten = new JLabel("Tên: "+textField_1.getText());
                        System.out.print(textField_1.getText()+"hello");
                        JLabel ma = new JLabel("Mã thiết bị: "+textField.getText());
                        JLabel soNgayBaoHanh = new JLabel("Số ngày bảo hành: "+textField_4.getText());
                        
                        JPanel chonSoLuong = new JPanel(new GridLayout(1,2));
                        JLabel labelSoLuong = new JLabel("Số Lượng: ");
                        JTextField soLuong = new JTextField();
                        chonSoLuong.add(labelSoLuong);
                        chonSoLuong.add(soLuong);
                        thongTinChiTiet.add(ten);
                        thongTinChiTiet.add(ma);
                        thongTinChiTiet.add(soNgayBaoHanh);
                        thongTinChiTiet.add(chonSoLuong);
                        boolean flag = false;

                        DataCoSo dataCoSo = new DataCoSo();
                        DSCoSo dsCS = new DSCoSo();
                        dsCS = dataCoSo.layDSCoSo();
                        Vector<String> s = new Vector<>();
                        for(CoSo a : dsCS.dsCoSo)
                        {
                            s.add(a.getMaCoSo());
                        }
                        @SuppressWarnings("rawtypes")
                        JComboBox chonCoSo = new JComboBox<>(s);
                        JLabel labelCoSo = new JLabel("Chọn cơ sở: ");

                        JPanel panelChonCoSo = new JPanel(new GridLayout(1,2));
                        panelChonCoSo.add(labelCoSo);
                        panelChonCoSo.add(chonCoSo);

                        thongTinChiTiet.add(panelChonCoSo);

                        while(flag == false)
                        {
                            int qes = JOptionPane.showConfirmDialog(null, thongTinChiTiet,"Nhập thiết bị",JOptionPane.OK_OPTION);
                            if(qes == 0)
                            {
                                try {
                                    int sl = Integer.parseInt(soLuong.getText());
                                    if(sl > 0) 
                                    {
                                        BLLNhapThietBi bllNhapThietBi = new BLLNhapThietBi();
                                        bllNhapThietBi.nhapHangVeCoSo(textField.getText(),chonCoSo.getSelectedItem().toString(),sl,Integer.parseInt(textField_4.getText()));
                                        flag = true;
                                    }
                                    else JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0");
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Số lượng phải là số lớn hơn 0");
                                }
                            }
                            else flag = true;
                        }
                    }
                });

                JTable bangKhac = new JTable();
                bangKhac.setFont(new Font("Times New Roman", Font.BOLD, 15));
bangKhac.setBounds(10, 600, 1180, 700); // Đặt kích thước cho bảng

// Tạo DefaultTableModel và thêm các cột
DefaultTableModel modelKhac = new DefaultTableModel();
modelKhac.addColumn("Mã thiết bị");
modelKhac.addColumn("Tên thiết bị");
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
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (textField_1.getText().equals("") || textField_3.getText().equals("") ||
                            textField_4.getText().equals("") || textField_6.getText().equals("")) 
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
                xoa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (textField.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Thiếu mã");
                        } else {
                            boolean isSuccess = ql.xoaTB(textField.getText());
                            if (isSuccess) {
                                JOptionPane.showMessageDialog(null, "Xóa thành công");
                            } else {
                                JOptionPane.showMessageDialog(null, "Mã không tồn tại");
                                return; 
                            }
                        }
                        modelKhac.setRowCount(0);
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
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (textField.getText().equals("") || textField_1.getText().equals("") || 
                            textField_3.getText().equals("") || textField_4.getText().equals("") || 
                            textField_6.getText().equals("")) 
                        {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                            return;
                        } 
                        else 
                        {
                            String maThietBi = textField.getText();
                            String ten = textField_1.getText();
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
