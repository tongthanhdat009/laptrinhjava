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

import DTO.MayChay;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

public class QuanLyMayChay extends JPanel {
	private String maThietBi;
	private JTextField goodsNameTF;
	private JTextField picTF;
	private JTextField congSuatTF;
	private JTextField speedMaxTF;
	private JTextField nsxTF;
	private JTextField kichThuocTF;

    public QuanLyMayChay()
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
                @SuppressWarnings("unused")
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
                
                goodsNameTF = new JTextField();
                goodsNameTF.setBounds(186, 80, 144, 36);
                thongTin.add(goodsNameTF);
                goodsNameTF.setColumns(10);
                
                picTF = new JTextField();
                picTF.setBounds(832, 33, 200, 36);
                thongTin.add(picTF);
                picTF.setColumns(10);
                
                
                congSuatTF = new JTextField();
                congSuatTF.setBounds(521, 33, 144, 36);
                thongTin.add(congSuatTF);
                congSuatTF.setColumns(10);
                
                speedMaxTF = new JTextField();
                speedMaxTF.setBounds(186, 130, 144, 36);
                thongTin.add(speedMaxTF);
                speedMaxTF.setColumns(10);
                
                nsxTF = new JTextField();
                nsxTF.setBounds(521, 80, 144, 36);
                thongTin.add(nsxTF);
                nsxTF.setColumns(10);
                
                JLabel IDGoodsLB = new JLabel("Mã hàng hóa:");
                IDGoodsLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                IDGoodsLB.setBounds(10, 39, 166, 27);
                // thongTin.add(IDGoodsLB);
                
                JLabel goodsNameLB = new JLabel("Tên hàng hóa:");
                goodsNameLB.setLabelFor(goodsNameTF);
                goodsNameLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                goodsNameLB.setBounds(10, 89, 166, 27);
                thongTin.add(goodsNameLB);
                
                JLabel speedMaxLB = new JLabel("Tốc độ tối đa:");
                speedMaxLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                speedMaxLB.setBounds(10, 139, 166, 27);
                thongTin.add(speedMaxLB);
                
                JLabel congSuatLB = new JLabel("Công suất:");
                congSuatLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                congSuatLB.setBounds(367, 41, 123, 28);
                thongTin.add(congSuatLB);
                
                JLabel nsxLB = new JLabel("Nhà sản xuất:");
                nsxLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                nsxLB.setBounds(367, 80, 149, 36);
                thongTin.add(nsxLB);
                
                JLabel picLB = new JLabel("Hình ảnh:");
                picLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                picLB.setBounds(699, 33, 123, 36);
                thongTin.add(picLB);
                
                JLabel kichThuocLB = new JLabel("Kích thước:");
                kichThuocLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
                kichThuocLB.setBounds(367, 139, 149, 27);
                thongTin.add(kichThuocLB);
                
                kichThuocTF = new JTextField();
                kichThuocTF.setBounds(521, 129, 144, 39);
                thongTin.add(kichThuocTF);
                kichThuocTF.setColumns(10);

                JTable bangMayChay = new JTable();
                bangMayChay.setBorder(new LineBorder(new Color(0, 0, 0)));
                bangMayChay.setBackground(new Color(255, 255, 255));
                bangMayChay.setFont(new Font("Times New Roman", Font.BOLD, 15));
                bangMayChay.getTableHeader().setReorderingAllowed(false);
                bangMayChay.setBounds(10, 600, 1180, 700); // Đặt kích thước cho bảng
                

                // Tạo DefaultTableModel và thêm các cột
                DefaultTableModel modelMayChay = new DefaultTableModel();
                modelMayChay.addColumn("Mã hàng hóa");
                modelMayChay.addColumn("Tên hàng hóa");
                modelMayChay.addColumn("Hình ảnh");
                modelMayChay.addColumn("Công suất");
                modelMayChay.addColumn("Tốc độ tối đa");
                modelMayChay.addColumn("Nhà sản xuất");
                modelMayChay.addColumn("Kích thước");
                

                // Gán model cho JTable
                bangMayChay.setModel(modelMayChay);
                // Lấy danh sách MayChay và thêm vào bảng
                BLLQuanLyDanhSach ql = new BLLQuanLyDanhSach();
                ArrayList<MayChay> danhSachMayChay = ql.layDSMayChay(); // Giả sử bạn có lớp dataThietBi để lấy dữ liệu
                for (MayChay mayChay : danhSachMayChay) {
                    modelMayChay.addRow(new Object[]{
                        mayChay.getMaHangHoa(),
                        mayChay.getTenLoaiHangHoa(),
                        mayChay.getHinhAnh(),
                        mayChay.getCongSuat(),
                        mayChay.getTocDoToiDa(),
                        mayChay.getNhaSanXuat(),
                        mayChay.getKichThuoc(),
                    });
                }

                bangMayChay.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        int row = bangMayChay.getSelectedRow();
                        if (row >= 0) {
                            maThietBi = modelMayChay.getValueAt(row, 0).toString().trim();
                            goodsNameTF.setText(modelMayChay.getValueAt(row, 1).toString().trim());
                            picTF.setText(modelMayChay.getValueAt(row, 2).toString().trim());
                            congSuatTF.setText(modelMayChay.getValueAt(row, 3).toString().trim());
                            speedMaxTF.setText(modelMayChay.getValueAt(row, 4).toString().trim());
                            nsxTF.setText(modelMayChay.getValueAt(row, 5).toString().trim());
                            kichThuocTF.setText(modelMayChay.getValueAt(row, 6).toString().trim());
                        }
                    }
                });
                them.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (goodsNameTF.getText().equals("") || picTF.getText().equals("") ||
                            congSuatTF.getText().equals("") || speedMaxTF.getText().equals("") ||
                            nsxTF.getText().equals("") || kichThuocTF.getText().equals("")) 
                        {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                            return;
                        } 
                        String regexInt = "^-?\\d+$";
                            if(!congSuatTF.getText().matches(regexInt)) {
                                JOptionPane.showMessageDialog(null, "Công suất phải là số");
                                return;
                            }
                            if(!speedMaxTF.getText().matches(regexInt)) {
                                JOptionPane.showMessageDialog(null, "Tốc độ tối đa phải là số");
                                return;
                            }
                        String regex = "\\d+x\\d+";
                        if(!kichThuocTF.getText().matches(regex)) {
                            JOptionPane.showMessageDialog(null, "Kích thước phải đúng định dạng [dài]x[rộng]");
                            return;
                        }
                        if(goodsNameTF.getText().length()>50) {
                            JOptionPane.showMessageDialog(null, "Tên phải <= 50 ký tự");
                            return;
                        }
                        if(nsxTF.getText().length()>50) {
                            JOptionPane.showMessageDialog(null, "Nhà sản xuất <= 50 ký tự");
                            return;
                        }
                        if(nsxTF.getText().length()>20) {
                            JOptionPane.showMessageDialog(null, "Kích thước <= 20 ký tự");
                            return;
                        }
                        if(!(picTF.getText().substring(picTF.getText().length() - 4).equals(".png")||picTF.getText().substring(picTF.getText().length() - 4).equals(".jpg")))
                        {
                            JOptionPane.showMessageDialog(null, "Sai định dạng ảnh");
                            return;
                        }
                        else 
                        {
                
                            String maThietBi = "null";  // Đặt là null hoặc bỏ qua mã thiết bị
                            String ten = goodsNameTF.getText();
                            String hinhAnh = picTF.getText();
                            int congSuat = Integer.parseInt(congSuatTF.getText());
                            int tocDoToiDa = Integer.parseInt(speedMaxTF.getText());
                            String nhaSanXuat = nsxTF.getText();
                            String kichThuoc = kichThuocTF.getText();
                
                            // Thêm thiết bị `MayChay` vào hệ thống
                            String kq = ql.themThietBiMayChay(new MayChay(maThietBi, "Máy chạy", ten, hinhAnh, congSuat, tocDoToiDa, nhaSanXuat, kichThuoc));
                            JOptionPane.showMessageDialog(null, kq);
                            modelMayChay.setRowCount(0);
                            ArrayList<MayChay> danhSachMayChay = ql.layDSMayChay(); // Giả sử bạn có lớp dataThietBi để lấy dữ liệu
                            for (MayChay mayChay : danhSachMayChay) {
                                modelMayChay.addRow(new Object[]{
                                		mayChay.getMaHangHoa(),
                                        mayChay.getTenLoaiHangHoa(),
                                        mayChay.getHinhAnh(),
                                        mayChay.getCongSuat(),
                                        mayChay.getTocDoToiDa(),
                                        mayChay.getNhaSanXuat(),
                                        mayChay.getKichThuoc(),
                    });
                }
                        }
                    }
                });
                sua.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (goodsNameTF.getText().equals("") || 
                            picTF.getText().equals("") ||  congSuatTF.getText().equals("") || 
                            speedMaxTF.getText().equals("") || nsxTF.getText().equals("") || kichThuocTF.getText().equals("")) 
                        {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
                            return;
                        } 
                        else 
                        {
                            String regexInt = "^-?\\d+$";
                            if(!congSuatTF.getText().matches(regexInt)) {
                                JOptionPane.showMessageDialog(null, "Công suất phải là số");
                                return;
                            }
                            if(!speedMaxTF.getText().matches(regexInt)) {
                                JOptionPane.showMessageDialog(null, "Tốc độ tối đa phải là số");
                                return;
                            }
                        String regex = "\\d+x\\d+";
                        if(!kichThuocTF.getText().matches(regex)) {
                            JOptionPane.showMessageDialog(null, "Kích thước phải đúng định dạng [dài]x[rộng]");
                            return;
                        }
                        if(goodsNameTF.getText().length()>50) {
                            JOptionPane.showMessageDialog(null, "Tên phải <= 50 ký tự");
                            return;
                        }
                        if(nsxTF.getText().length()>50) {
                            JOptionPane.showMessageDialog(null, "Nhà sản xuất <= 50 ký tự");
                            return;
                        }
                        if(nsxTF.getText().length()>20) {
                            JOptionPane.showMessageDialog(null, "Kích thước <= 20 ký tự");
                            return;
                        }
                        if(!(picTF.getText().substring(picTF.getText().length() - 4).equals(".png")||picTF.getText().substring(picTF.getText().length() - 4).equals(".jpg")))
                        {
                            JOptionPane.showMessageDialog(null, "Sai định dạng ảnh");
                            return;
                        }
                            String ten = goodsNameTF.getText();
                            String hinhAnh = picTF.getText();
                            int congSuat = Integer.parseInt(congSuatTF.getText());
                            int tocDoToiDa = Integer.parseInt(speedMaxTF.getText());
                            String nhaSanXuat = nsxTF.getText();
                            String kichThuoc = kichThuocTF.getText();
                
                            // Sửa thiết bị `MayChay`
                            String kq = ql.SuaMayChay(new MayChay(maThietBi, "Máy chạy", ten, hinhAnh,  congSuat, tocDoToiDa, nhaSanXuat, kichThuoc));
                            JOptionPane.showMessageDialog(null, kq);
                            modelMayChay.setRowCount(0);
                            ArrayList<MayChay> danhSachMayChay = ql.layDSMayChay(); // Giả sử bạn có lớp dataThietBi để lấy dữ liệu
                            for (MayChay mayChay : danhSachMayChay) {
                                modelMayChay.addRow(new Object[]{
                                		mayChay.getMaHangHoa(),
                                        mayChay.getTenLoaiHangHoa(),
                                        mayChay.getHinhAnh(),
                                        mayChay.getCongSuat(),
                                        mayChay.getTocDoToiDa(),
                                        mayChay.getNhaSanXuat(),
                                        mayChay.getKichThuoc(),
                                });
                            }
                        }
                    }
                });
                

                // Tạo JScrollPane để chứa bảng và cho phép cuộn
                JScrollPane scrollPaneMayChay = new JScrollPane(bangMayChay);
                scrollPaneMayChay.setBounds(0, 320, 1200, 700); // Đặt kích thước cho JScrollPane

                // Thêm JScrollPane vào JPanel
                add(scrollPaneMayChay);

    }
}
