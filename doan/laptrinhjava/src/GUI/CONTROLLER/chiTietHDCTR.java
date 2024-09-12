package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLLQuanLyDanhSach;
import DTO.ChiTietHoaDon;

public class chiTietHDCTR {
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm

	public chiTietHDCTR() {
		
	}
	
	public void xoaHienThi(JPanel rightPanel){
        Component[] components = rightPanel.getComponents();
        for(Component a : components){
            if(!(a instanceof JLabel || a instanceof JComboBox)){
                rightPanel.remove(a);
            }
        }
        rightPanel.revalidate();
        rightPanel.repaint();
    }
	public void QuanLyChiTietHoaDon(ArrayList<ChiTietHoaDon> ds, JPanel rightPanel)
    {
        xoaHienThi(rightPanel);
    	JButton them = new JButton();
        ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-hd.png");
        Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        them.setPreferredSize(new Dimension (130,35));
        them.setIcon(new ImageIcon(scaleThemBtnImg));
        them.setHorizontalAlignment(SwingConstants.CENTER);
        them.setBorder(null);

    	JButton xoa  = new JButton();
        xoa.setPreferredSize(new Dimension (110,35));
        ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-hd.png");
        Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        xoa.setPreferredSize(new Dimension (130,35));
        xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
        xoa.setHorizontalAlignment(SwingConstants.CENTER);
        xoa.setBorder(null);

    	JButton sua = new JButton();
        sua.setPreferredSize(new Dimension (110,35));
        ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-hd.png");
        Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        sua.setPreferredSize(new Dimension (130,35));
        sua.setIcon(new ImageIcon(scaleSuaBtnImg));
        sua.setHorizontalAlignment(SwingConstants.CENTER);
        sua.setBorder(null);

    	JButton timKiem = new JButton();
        timKiem.setPreferredSize(new Dimension (110,35));
        ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-hd.png");
        Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        timKiem.setPreferredSize(new Dimension (130,35));
        timKiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
        timKiem.setHorizontalAlignment(SwingConstants.CENTER);
        timKiem.setBorder(null);

        JPanel chucNang = new JPanel(new FlowLayout());
        chucNang.add(them);
        chucNang.add(xoa);
        chucNang.add(sua);
        chucNang.add(timKiem);
        chucNang.setBounds(5,100,rightPanel.getWidth()-5,38);
        chucNang.setBackground(Color.WHITE);
        rightPanel.add(chucNang);

        JPanel nhapLieu = new JPanel(null);
        nhapLieu.setBounds(2, 150, rightPanel.getWidth()-20, 80);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        nhapLieu.setBackground(new Color(119, 230, 163));
        nhapLieu.setBorder(titledBorder);

        JLabel maHoaDon = new JLabel("Mã hóa đơn: ");
        JLabel maHangHoa = new JLabel("Mã hàng hóa: ");
        JLabel soLuong = new JLabel("Số lượng: ");
        JTextField tfMaHoaDon = new JTextField();
        JTextField tfMaHangHoa = new JTextField();
        JTextField tfSoLuong = new JTextField();
        int x=250;
        maHoaDon.setBounds(x, 30, 80, 30); x+=80;
        tfMaHoaDon.setBounds(x+10, 30, 100, 30); x+=110;
        maHangHoa.setBounds(x+50, 30, 80, 30); x+=130;
        tfMaHangHoa.setBounds(x+10, 30, 100, 30); x+=110;
        soLuong.setBounds(x+50, 30, 60, 30); x+=110;
        tfSoLuong.setBounds(x+10, 30, 100, 30); 

        nhapLieu.add(maHoaDon);
        nhapLieu.add(tfMaHoaDon);
        nhapLieu.add(maHangHoa);
        nhapLieu.add(tfMaHangHoa);
        nhapLieu.add(soLuong);
        nhapLieu.add(tfSoLuong);
        rightPanel.add(nhapLieu);

        JTable bang = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        bang.setModel(model);
        model.addColumn("Mã hóa đơn");
        model.addColumn("Mã hàng hóa");
        model.addColumn("Số lượng");
        BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
        for(int i=0;i<ds.size();i++)
        model.addRow(new Object[]{ds.get(i).getMaHoaDon(), ds.get(i).getMaHangHoa(), ds.get(i).getSoLuong()});
        bang.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                int i = bang.getSelectedRow();
                if(i>=0)
                {
                    tfMaHoaDon.setText(model.getValueAt(i, 0).toString());
                    tfMaHangHoa.setText(model.getValueAt(i, 1).toString());
                    tfSoLuong.setText(model.getValueAt(i, 2).toString());
                }
            }
        });
        bang.getTableHeader().setReorderingAllowed(false);
        // for (int i = 0; i < bang.getColumnCount(); i++) {
        //     bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
        // }
        them.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(tfMaHangHoa.getText().equals("")||tfMaHoaDon.getText().equals("")||tfSoLuong.getText().equals(""))
                JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập đủ thông tin");
                String s = bllQuanLyDanhSach.themChiTietHoaDon(tfMaHoaDon.getText(),tfMaHangHoa.getText(),Integer.parseInt(tfSoLuong.getText()));
                if(s.equals("Thành công"))
                model.addRow(new Object[]{tfMaHangHoa.getText(),tfMaHoaDon.getText(),tfSoLuong.getText()});
                JOptionPane.showMessageDialog(rightPanel, s);
            }
        });
        xoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(tfMaHangHoa.getText().equals("")||tfMaHoaDon.getText().equals(""))
                JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã hàng hóa và mã hóa đơn");
                String s = bllQuanLyDanhSach.xoaChiTietHoaDon(tfMaHoaDon.getText(),tfMaHangHoa.getText());
                if(s.equals("Thành công"))
                {
                    for(int i=0;i<model.getRowCount();i++)
                    {
                        if(model.getValueAt(i, 0).equals(tfMaHoaDon.getText()) && model.getValueAt(i, 1).equals(tfMaHangHoa.getText()))
                        {
                            model.removeRow(i);
                            break;
                        }
                    }
                }
                JOptionPane.showMessageDialog(rightPanel, s);
            }
        });
        sua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(tfMaHangHoa.getText().equals("")||tfMaHoaDon.getText().equals("")||tfSoLuong.getText().equals(""))
                JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập đủ thông tin");
                String s = bllQuanLyDanhSach.suaChiTietHoaDon(tfMaHoaDon.getText(), tfMaHangHoa.getText(), Integer.parseInt(tfSoLuong.getText()));
                if(s.equals("Thành công"))
                {
                    for(int i=0;i<model.getRowCount();i++)
                    {
                        if(model.getValueAt(i, 0).equals(tfMaHoaDon.getText()) && model.getValueAt(i, 1).equals(tfMaHangHoa.getText()))
                        model.setValueAt(tfSoLuong.getText(), i, 2);
                        break;
                    }
                }
                JOptionPane.showMessageDialog(rightPanel, s);
            }
        });
        timKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                model.setRowCount(0);
                if(tfMaHoaDon.getText().equals("")&&tfMaHangHoa.getText().equals("")) 
                {
                    for(int i=0;i<ds.size();i++)
                    model.addRow(new Object[]{ds.get(i).getMaHoaDon(), ds.get(i).getMaHangHoa(), ds.get(i).getSoLuong()});
                }
                else
                {
                    ArrayList<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<>();
                    dsChiTietHoaDon = bllQuanLyDanhSach.timKiemChiTietHoaDon(tfMaHoaDon.getText(), tfMaHangHoa.getText());
                    for(int i=0;i<dsChiTietHoaDon.size();i++)
                    model.addRow(new Object[]{dsChiTietHoaDon.get(i).getMaHoaDon(), dsChiTietHoaDon.get(i).getMaHangHoa(), dsChiTietHoaDon.get(i).getSoLuong()});
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(bang);
        scrollPane.setBounds(5, 230, rightPanel.getWidth()-20, rightPanel.getHeight()-270);
        rightPanel.add(scrollPane);
    }
}
