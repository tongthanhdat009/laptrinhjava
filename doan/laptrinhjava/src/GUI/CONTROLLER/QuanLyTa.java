package GUI.CONTROLLER;

import java.util.Vector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
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
import DTO.Ta;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

public class QuanLyTa extends JPanel {
	private JTextField IDGoodsTF;
	private JTextField goodsNameTF;
	private JTextField picTF;
	private JTextField weightTF;
	private JTextField materialTF;
	private JTextField colorTF;
    public QuanLyTa()
    {
        setLayout(null);
        setSize(1200,800);
        setBackground(new Color(241, 255, 250));
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
                tinhNang.setBounds(0,0,1200,100);
                add(tinhNang);
                tinhNang.add(them);
                tinhNang.add(sua);
                tinhNang.setBackground(new Color(241, 255, 250));
                
                JPanel thongTin = new JPanel();
                thongTin.setBorder(new LineBorder(new Color(0, 0, 0)));
                thongTin.setBackground(new Color(119, 230, 163));
                thongTin.setBounds(0, 100, 1200, 213);
                add(thongTin);
                thongTin.setLayout(null);
                
                IDGoodsTF = new JTextField();
                IDGoodsTF.setBounds(244, 30, 160, 36);
                thongTin.add(IDGoodsTF);
                IDGoodsTF.setColumns(10);
                
                goodsNameTF = new JTextField();
                goodsNameTF.setBounds(244, 77, 160, 36);
                thongTin.add(goodsNameTF);
                goodsNameTF.setColumns(10);
                
                picTF = new JTextField();
                picTF.setBounds(568, 130, 190, 36);
                thongTin.add(picTF);
                picTF.setColumns(10);
                
                weightTF = new JTextField();
                weightTF.setBounds(568, 30, 190, 36);
                thongTin.add(weightTF);
                weightTF.setColumns(10);
                
                materialTF = new JTextField();
                materialTF.setBounds(244, 124, 160, 36);
                thongTin.add(materialTF);
                materialTF.setColumns(10);
                
                colorTF = new JTextField();
                colorTF.setBounds(568, 80, 190, 36);
                thongTin.add(colorTF);
                colorTF.setColumns(10);
                
                JLabel IDGoodsLB = new JLabel("Mã hàng hóa:");
                IDGoodsLB.setLabelFor(IDGoodsTF);
                IDGoodsLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                IDGoodsLB.setBounds(10, 39, 160, 27);
                thongTin.add(IDGoodsLB);
                
                JLabel goodsNameLB = new JLabel("Tên hàng hóa:");
                goodsNameLB.setLabelFor(goodsNameTF);
                goodsNameLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                goodsNameLB.setBounds(10, 89, 224, 27);
                thongTin.add(goodsNameLB);
                
                JLabel picLB = new JLabel("Hình ảnh:");
                picLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                picLB.setBounds(435, 133, 123, 27);
                thongTin.add(picLB);
                
                JLabel weightLB = new JLabel("Khối lượng:");
                weightLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                weightLB.setBounds(435, 28, 133, 36);
                thongTin.add(weightLB);
                
                JLabel marterialLB = new JLabel("Chất liệu:");
                marterialLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                marterialLB.setBounds(10, 128, 160, 36);
                thongTin.add(marterialLB);
                
                JLabel colorLB = new JLabel("Màu sắc:");
                colorLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                colorLB.setBounds(435, 78, 100, 36);
                thongTin.add(colorLB);
                
                // Tạo JTable
                // Tạo JTable
                JTable bang = new JTable();
                bang.setFont(new Font("Times New Roman", Font.BOLD, 15));
                bang.setBounds(10, 600, 1180, 700); // Đặt kích thước cho bảng
                bang.getTableHeader().setReorderingAllowed(false);


                // Tạo DefaultTableModel và thêm các cột
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Mã hàng hóa");
                model.addColumn("Tên hàng hóa");
                model.addColumn("Hình ảnh");
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
                        ta.getMaHangHoa(),
                        ta.getLoaiHangHoa(),
                        ta.getHinhAnh(),
                        ta.getKhoiLuong(),
                        ta.getChatLieu(),
                        ta.getMauSac(),
                    });
                }

                bang.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                        int row = bang.getSelectedRow();
                        if (row >= 0) {
                            IDGoodsTF.setText(model.getValueAt(row, 0).toString().trim());
                            goodsNameTF.setText(model.getValueAt(row, 1).toString().trim());
                            picTF.setText(model.getValueAt(row, 2).toString().trim());
                            weightTF.setText(model.getValueAt(row, 3).toString().trim());
                            materialTF.setText(model.getValueAt(row, 4).toString().trim());
                            colorTF.setText(model.getValueAt(row, 5).toString().trim());
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
                        if (goodsNameTF.getText().equals("") || picTF.getText().equals("") ||
                            weightTF.getText().equals("") || materialTF.getText().equals("") || 
                            colorTF.getText().equals("")) 
                            {
                                JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                                return;
                            } 
                       
                            // Kiểm tra nếu người dùng nhập mã thì cảnh báo
                            if (!IDGoodsTF.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Không cần nhập mã");
                                return;
                            }


                            String maThietBi = "null";  // Đặt là null hoặc bỏ qua mã thiết bị
                            String ten = goodsNameTF.getText();
                            String hinhAnh = picTF.getText();
                            int khoiLuong = Integer.parseInt(weightTF.getText().trim());
                            String chatLieu = colorTF.getText();
                            String mauSac = materialTF.getText();

//                            String kq = ql.themThietBiTa(new Ta(maThietBi, ten, hinhAnh, giaThietBi, ngayBaoHanh, "Ta", khoiLuong, chatLieu, mauSac));
//                            JOptionPane.showMessageDialog(null, kq);
                            model.setRowCount(0);
                            ArrayList<Ta> danhSachTa = new ArrayList<>();
                            danhSachTa = ql.layDSTa();
                            for (Ta ta : danhSachTa) {
                                model.addRow(new Object[]{
                                		ta.getMaHangHoa(),
                                        ta.getLoaiHangHoa(),
                                        ta.getHinhAnh(),
                                        ta.getKhoiLuong(),
                                        ta.getChatLieu(),
                                        ta.getMauSac(),
                                });
                            }
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (IDGoodsTF.getText().equals("") || goodsNameTF.getText().equals("") || 
                            picTF.getText().equals("") ||
                            weightTF.getText().equals("") || 
                            materialTF.getText().equals("") || colorTF.getText().equals("")) 
                        {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                            return;
                        } 
                        else 
                        {
                            String maThietBi = IDGoodsTF.getText();
                            String ten = goodsNameTF.getText();
                            String hinhAnh = picTF.getText();
//                            String giaThietBi = textField_3.getText();
//                            int ngayBaoHanh = Integer.parseInt(textField_4.getText());
                            int khoiLuong = Integer.parseInt(weightTF.getText());
                            String chatLieu = materialTF.getText();
                            String mauSac = colorTF.getText();
                
                            // Sửa thiết bị `Ta`
//                            String kq = ql.SuaTa(new Ta(maThietBi, ten, hinhAnh, giaThietBi, ngayBaoHanh, "Ta", khoiLuong, chatLieu, mauSac));
//                            JOptionPane.showMessageDialog(null, kq);
                        }
                        model.setRowCount(0);
                        ArrayList<Ta> danhSachTa = new ArrayList<>();
                danhSachTa = ql.layDSTa();
                for (Ta ta : danhSachTa) {
                    model.addRow(new Object[]{
                    		ta.getMaHangHoa(),
                            ta.getLoaiHangHoa(),
                            ta.getHinhAnh(),
                            ta.getKhoiLuong(),
                            ta.getChatLieu(),
                            ta.getMauSac(),
                    });
                }
                    }
                });                
                
                

    }
}
