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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BLL.BLLQuanLyDanhSach;
import DTO.Xa;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;

public class QuanLyXa extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;

    public QuanLyXa() {
        setLayout(null);
        setSize(1200, 800);
        setBackground(Color.white);
        giaoDien();
    }

    public void giaoDien() {
        JButton them = new JButton();
        ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-hv.png");
        Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130, 35, Image.SCALE_DEFAULT);
        them.setPreferredSize(new Dimension(130, 35));
        them.setIcon(new ImageIcon(scaleThemBtnImg));
        them.setHorizontalAlignment(SwingConstants.CENTER);
        them.setBorder(null);

        JButton xoa = new JButton();
        xoa.setPreferredSize(new Dimension(110, 35));
        ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-hv.png");
        Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130, 35, Image.SCALE_DEFAULT);
        xoa.setPreferredSize(new Dimension(130, 35));
        xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
        xoa.setHorizontalAlignment(SwingConstants.CENTER);
        xoa.setBorder(null);

        JButton sua = new JButton();
        sua.setPreferredSize(new Dimension(110, 35));
        ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-hv.png");
        Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130, 35, Image.SCALE_DEFAULT);
        sua.setPreferredSize(new Dimension(130, 35));
        sua.setIcon(new ImageIcon(scaleSuaBtnImg));
        sua.setHorizontalAlignment(SwingConstants.CENTER);
        sua.setBorder(null);

        JPanel tinhNang = new JPanel();
        tinhNang.setLayout(new FlowLayout());
        tinhNang.setBounds(0, 0, 1200, 100);
        add(tinhNang);
        tinhNang.add(them);
        tinhNang.add(xoa);
        tinhNang.add(sua);
        tinhNang.setBackground(Color.white);

        JPanel thongTin = new JPanel();
        thongTin.setBounds(0, 100, 1200, 213);
        add(thongTin);
        thongTin.setLayout(null);

        // Initialize JTextFields
        textField = new JTextField();
        textField.setBounds(130, 30, 149, 36);
        thongTin.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(130, 80, 149, 36);
        thongTin.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(741, 80, 149, 36);
        thongTin.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(462, 30, 149, 36);
        thongTin.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(462, 80, 149, 36);
        thongTin.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(462, 130, 149, 36);
        thongTin.add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(130, 130, 149, 36);
        thongTin.add(textField_6);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setBounds(741, 30, 149, 36);
        thongTin.add(textField_7);
        textField_7.setColumns(10);

        textField_8 = new JTextField();
        textField_8.setBounds(741, 127, 149, 39);
        thongTin.add(textField_8);
        textField_8.setColumns(10);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(1018, 30, 149, 36);
        thongTin.add(textField_9);

        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(1018, 80, 149, 36);
        thongTin.add(textField_10);

        // Initialize JLabel
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
        lblNewLabel_3.setBounds(319, 28, 100, 36);
        thongTin.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Ngày bảo hành:");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_4.setBounds(319, 83, 144, 27);
        thongTin.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Loại xà:");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_5.setBounds(319, 128, 133, 36);
        thongTin.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Chất liệu:");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_6.setBounds(621, 28, 110, 36);
        thongTin.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Tải trọng:");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_7.setBounds(621, 78, 100, 36);
        thongTin.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Chiều dài:");
        lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_8.setBounds(621, 130, 110, 36);
        thongTin.add(lblNewLabel_8);

        JLabel lblNewLabel_8_1 = new JLabel("Đường kính:");
        lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_8_1.setBounds(900, 30, 110, 27);
        thongTin.add(lblNewLabel_8_1);

        JLabel lblNewLabel_8_2 = new JLabel("Chiều cao:");
        lblNewLabel_8_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_8_2.setBounds(900, 80, 110, 27);
        thongTin.add(lblNewLabel_8_2);

        // Initialize JTable and DefaultTableModel
        // Trong phương thức giaoDien
// Initialize JTable và DefaultTableModel
JTable bangXa = new JTable();

DefaultTableModel modelXa = new DefaultTableModel();
modelXa.addColumn("Mã thiết bị");
modelXa.addColumn("Tên thiết bị");
modelXa.addColumn("Hình ảnh");
modelXa.addColumn("Giá thiết bị");
modelXa.addColumn("Ngày bảo hành");
modelXa.addColumn("Loại xà");
modelXa.addColumn("Chất liệu");
modelXa.addColumn("Chiều dài");
modelXa.addColumn("Đường kính");
modelXa.addColumn("Chiều cao");
modelXa.addColumn("Tải trọng");

// Gán model cho JTable
bangXa.setModel(modelXa);

// Lấy danh sách Xa và thêm vào bảng
BLLQuanLyDanhSach ql = new BLLQuanLyDanhSach();
ArrayList<Xa> danhSachXa = ql.layDSXa(); // Giả sử bạn có lớp dataThietBi để lấy dữ liệu
for (Xa xa : danhSachXa) {
    modelXa.addRow(new Object[]{
        xa.getMaThietBi(),
        xa.getTenLoaiThietBi(),
        xa.getHinhAnh(),
        xa.getGiaThietBi(),
        xa.getNgayBaoHanh(),
        xa.getLoaiXa(),
        xa.getChatLieu(),
        xa.getChieuDai(),
        xa.getDuongKinh(),
        xa.getChieuCao(),
        xa.getTaiTrong()
    });
}

// Thêm MouseListener cho JTable
        bangXa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = bangXa.getSelectedRow();
                if (row >= 0) {
                    textField.setText(modelXa.getValueAt(row, 0).toString().trim());
                    textField_1.setText(modelXa.getValueAt(row, 1).toString().trim());
                    textField_2.setText(modelXa.getValueAt(row, 2).toString().trim());
                    textField_3.setText(modelXa.getValueAt(row, 3).toString().trim());
                    textField_4.setText(modelXa.getValueAt(row, 4).toString().trim());
                    textField_5.setText(modelXa.getValueAt(row, 5).toString().trim());
                    textField_6.setText(modelXa.getValueAt(row, 6).toString().trim());
                    textField_7.setText(modelXa.getValueAt(row, 7).toString().trim());
                    textField_8.setText(modelXa.getValueAt(row, 8).toString().trim());
                    textField_9.setText(modelXa.getValueAt(row, 9).toString().trim());
                    textField_10.setText(modelXa.getValueAt(row, 10).toString().trim());
                }
            }
        });
        them.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(textField_1.getText().equals("")||textField_1.getText().equals("")||textField_1.getText().equals("")||
                textField_1.getText().equals("")||textField_1.getText().equals("")||textField_1.getText().equals("")||textField_1.getText().equals("")||
                textField_1.getText().equals("")) 
                {
                    JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                    if(!textField_1.getText().equals("")) JOptionPane.showMessageDialog(null, "Không cần nhập mã");
                }
                else 
                {
                    String maThietBi = "null";
                    String ten = textField_1.getText();
                    String hinhAnh = textField_2.getText();
                    String giaThietBi = textField_3.getText();
                    int ngayBaoHanh = Integer.parseInt(textField_4.getText());
                    String loai = "Xa";
                    String loaiXa = textField_5.getText();
                    String chatLieu = textField_6.getText();
                    float chieuDai = Float.parseFloat(textField_7.getText());
                    float duongKinh = Float.parseFloat(textField_8.getText());
                    float chieuCao = Float.parseFloat(textField_9.getText());
                    float taiTrong = Float.parseFloat(textField_10.getText());
                    String kq = ql.themThietBiXa(new Xa(maThietBi, ten, hinhAnh, giaThietBi, ngayBaoHanh, loai, loaiXa, chatLieu, chieuDai, duongKinh, chieuCao, taiTrong));
                    JOptionPane.showMessageDialog(null,kq);
                }

            }
        });
        xoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(textField_1.getText().equals("")) JOptionPane.showMessageDialog(null, "Thiếu mã");
                else if(ql.xoaTB(textField.getText())) JOptionPane.showMessageDialog(null,"Thành công");
                else JOptionPane.showMessageDialog(null,"Mã không tồn tại");
            }
        });
        sua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(textField_1.getText().equals("")||textField_1.getText().equals("")||textField_1.getText().equals("")||
                textField_1.getText().equals("")||textField_1.getText().equals("")||textField_1.getText().equals("")||textField_1.getText().equals("")||
                textField_1.getText().equals("")) JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                else 
                {
                    String maThietBi = textField.getText();
                    String ten = textField_1.getText();
                    String hinhAnh = textField_2.getText();
                    String giaThietBi = textField_3.getText();
                    int ngayBaoHanh = Integer.parseInt(textField_4.getText());
                    String loai = "Xa";
                    String loaiXa = textField_5.getText();
                    String chatLieu = textField_6.getText();
                    float chieuDai = Float.parseFloat(textField_7.getText());
                    float duongKinh = Float.parseFloat(textField_8.getText());
                    float chieuCao = Float.parseFloat(textField_9.getText());
                    float taiTrong = Float.parseFloat(textField_10.getText());
                    String kq = ql.SuaXa(new Xa(maThietBi, ten, hinhAnh, giaThietBi, ngayBaoHanh, loai, loaiXa, chatLieu, chieuDai, duongKinh, chieuCao, taiTrong));
                    JOptionPane.showMessageDialog(null, kq);
                }
            }
        });

        // Tạo JScrollPane để chứa bảng và cho phép cuộn
        JScrollPane scrollPaneXa = new JScrollPane(bangXa);
        scrollPaneXa.setBounds(10, 320, 1180, 700); // Đặt kích thước cho JScrollPane

        // Thêm JScrollPane vào JPanel
        add(scrollPaneXa);
    }
}
