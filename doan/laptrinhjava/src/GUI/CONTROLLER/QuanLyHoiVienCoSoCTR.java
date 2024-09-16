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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.microsoft.sqlserver.jdbc.dataclassification.Label;

import BLL.BLLQuanLyDanhSach;
import DTO.HoiVienCoSo;

public class QuanLyHoiVienCoSoCTR {
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm

	public QuanLyHoiVienCoSoCTR() {
		
	}
	//màu cho combobox
    ListCellRenderer<? super String> renderer = new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Đặt màu cho phần tử trong JComboBox
            if (isSelected) {
                component.setForeground(new Color(140, 82, 255)); // Màu chữ khi được chọn
                component.setBackground(Color.WHITE); // Màu nền khi được chọn
            } else {
                component.setForeground(Color.BLACK); // Màu chữ mặc định
                component.setBackground(Color.WHITE); // Màu nền mặc định
            }

            return component;
        }
    };
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
	public void QuanLyHoiVienCoSo(ArrayList<HoiVienCoSo> ds, Vector<String> dsCoSo, JPanel rightPanel)
    {
        xoaHienThi(rightPanel);
//        JLabel title = new JLabel("Quản lý hội viên cơ sở");
//    	title.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 35));
//    	title.setBounds(450, 0, 1000,60);   
//    	rightPanel.add(title);
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

    	JButton timKiem = new JButton();
        timKiem.setPreferredSize(new Dimension (110,35));
        timKiem.setPreferredSize(new Dimension (110,35));
        ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-hv.png");
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

        JLabel lbmaHoiVien = new JLabel("Mã hội viên: ");
        JTextField tfMaHoiVien = new JTextField();
        
        JLabel lbHoTen = new JLabel("Họ tên:");
        JTextField tfHoTen = new JTextField();
        
        JLabel lbMaCoSo = new JLabel("Mã Cơ Sở: ");
        @SuppressWarnings("rawtypes")
        JComboBox cbMaCoSo = new JComboBox<>(dsCoSo);
        cbMaCoSo.setRenderer(renderer);
        cbMaCoSo.setBackground(Color.WHITE);
        JLabel lbHanTap = new JLabel("Hạn tập: ");

        Vector<String> day = new Vector<>();
        Vector<String> month = new Vector<>();
        Vector<String> year = new Vector<>();
        for(int i=1;i<=31;i++)
        day.add(String.valueOf(i));
        day.add(0,"DD");
        for(int i=1;i<=12;i++)
        month.add(String.valueOf(i));
        month.add(0,"MM");
        for(int i=1990;i<=2100;i++)
        year.add(String.valueOf(i));
        year.add(0,"YYYY");
        
        @SuppressWarnings("rawtypes")
        JComboBox cbDay = new JComboBox<>(day);
        cbDay.setRenderer(renderer);
        cbDay.setBackground(Color.white);
        
        @SuppressWarnings("rawtypes")
        JComboBox cbMonth = new JComboBox<>(month);
        cbMonth.setRenderer(renderer);
        cbMonth.setBackground(Color.white);
        
        @SuppressWarnings("rawtypes")
        JComboBox cbYear = new JComboBox<>(year);
        cbYear.setRenderer(renderer);
        cbYear.setBackground(Color.white);

        JPanel nhapLieu = new JPanel(null);
        nhapLieu.setBounds(2, 150, rightPanel.getWidth()-20, 75);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        nhapLieu.setBackground(new Color(119, 230, 163));
        nhapLieu.setBorder(titledBorder);

        int x = 250;
        lbmaHoiVien.setBounds(x, 30, 80, 30); x+=80;
        tfMaHoiVien.setBounds(x+10, 30, 100, 30); x+=110;
        lbMaCoSo.setBounds(x+50, 30, 80, 30); x+=130;
        cbMaCoSo.setBounds(x+10, 30, 100, 30); x+=110;
        lbHanTap.setBounds(x+50, 30, 60, 30); x+=110;
        cbYear.setBounds(x+10, 30, 70, 30); x+=80;
        cbMonth.setBounds(x+5, 30, 50, 30); x+=55;
        cbDay.setBounds(x+5, 30, 50, 30);
        nhapLieu.add(lbmaHoiVien);
        nhapLieu.add(tfMaHoiVien);
        nhapLieu.add(lbMaCoSo);
        nhapLieu.add(cbMaCoSo);
        nhapLieu.add(lbHanTap);
        nhapLieu.add(cbYear);
        nhapLieu.add(cbMonth);
        nhapLieu.add(cbDay);
        rightPanel.add(nhapLieu);

        JTable bang = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        bang.setModel(model);
        bang.setFont(new Font("Times New Roman", Font.BOLD, 14));
        model.addColumn("Mã hội viên");
        model.addColumn("Mã cơ sở");
        model.addColumn("Hạn tập");
        for(int i=0;i<ds.size();i++)
        model.addRow(new Object[]{
            ds.get(i).getMaHoiVien(), ds.get(i).getMaCoSo(), ds.get(i).getHanTap()
        });
        bang.getTableHeader().setReorderingAllowed(false);
        // for (int i = 0; i < bang.getColumnCount(); i++) {
        //     bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
        // }
        bang.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                int i = bang.getSelectedRow();
                if(i>=0)
                {
                    tfMaHoiVien.setText(model.getValueAt(i, 0).toString());
                    cbMaCoSo.setSelectedItem(model.getValueAt(i, 1).toString());
                    LocalDate date = LocalDate.parse(model.getValueAt(i, 2).toString());
                    cbDay.setSelectedItem(Integer.toString(date.getDayOfMonth()));
                    cbMonth.setSelectedItem(Integer.toString(date.getMonthValue()));
                    cbYear.setSelectedItem(Integer.toString(date.getYear()));
                }
            }
        });
        bang.getTableHeader().setReorderingAllowed(false);
        // for (int i = 0; i < bang.getColumnCount(); i++) {
        //     bang.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
        // }
        BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
        them.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String maHoiVien = tfMaHoiVien.getText();
                String maCoSo = cbMaCoSo.getSelectedItem().toString();
                String dd = cbDay.getSelectedItem().toString();
                String mm = cbMonth.getSelectedItem().toString();
                String yyyy= cbYear.getSelectedItem().toString();
                if(maHoiVien.equals("")||maCoSo.equals("Chọn cơ sở")||dd.equals("DD")||mm.equals("MM")||yyyy.equals("YYYY"))
                JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                else 
                {
                    String sHanTap = yyyy+"-"+mm+"-"+dd;
                    Date hanTap = Date.valueOf(sHanTap);
                    String s = bllQuanLyDanhSach.themHoiVienCoSo(maHoiVien, maCoSo, hanTap);
                    if(s.equals("Thành công"))
                    model.addRow(new Object[]{maHoiVien,maCoSo,hanTap});
                    JOptionPane.showMessageDialog(rightPanel, s);
                }
            }
        });
        xoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String maHoiVien = tfMaHoiVien.getText();
                String maCoSo = cbMaCoSo.getSelectedItem().toString();
                if(maHoiVien.equals("")||maCoSo.equals("Chọn cơ sở")) JOptionPane.showMessageDialog(rightPanel, "Nhập mã hội viên và mã cơ sở");
                else
                {
                    String s = bllQuanLyDanhSach.xoaHoiVienCoSo(maHoiVien, maCoSo);
                    if(s.equals("Thành công"))
                    {
                        for(int i=0;i<model.getRowCount();i++)  
                        if(model.getValueAt(i, 0).equals(maHoiVien) && model.getValueAt(i, 1).equals(maCoSo))
                        {
                            model.removeRow(i);
                            break;
                        } 
                    }
                    JOptionPane.showMessageDialog(rightPanel, s);
                }
            }
        });
        sua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String maHoiVien = tfMaHoiVien.getText();
                String maCoSo = cbMaCoSo.getSelectedItem().toString();
                String dd = cbDay.getSelectedItem().toString();
                String mm = cbMonth.getSelectedItem().toString();
                String yyyy= cbYear.getSelectedItem().toString();
                if(maHoiVien.equals("")||maCoSo.equals("Chọn cơ sở")||dd.equals("DD")||mm.equals("MM")||yyyy.equals("YYYY"))
                JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                else 
                {
                    String sHanTap = yyyy+"-"+mm+"-"+dd;
                    Date hanTap = Date.valueOf(sHanTap);
                    String s = bllQuanLyDanhSach.suaHoiVienCoSo(maHoiVien, maCoSo, hanTap);
                    if(s.equals("Thành công"))
                    {
                        for(int i=0;i<model.getRowCount();i++)  
                        if(model.getValueAt(i, 0).equals(maHoiVien) && model.getValueAt(i, 1).equals(maCoSo))
                        {
                            model.setValueAt(hanTap, i, 2);
                            break;
                        } 
                    }
                    JOptionPane.showMessageDialog(rightPanel, s);
                }
            }
        });
        timKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String maHoiVien = tfMaHoiVien.getText();
                String maCoSo = cbMaCoSo.getSelectedItem().toString();
                model.setRowCount(0);
                if(maHoiVien.equals("")&&maCoSo.equals("Chọn cơ sở")) 
                {
                    for(int i=0;i<ds.size();i++)
                    model.addRow(new Object[]{ds.get(i).getMaHoiVien(),ds.get(i).getMaCoSo(),ds.get(i).getHanTap()});
                }
                else
                {
                    ArrayList<HoiVienCoSo> dsHoiVienCoSo = new ArrayList<>();
                    dsHoiVienCoSo = bllQuanLyDanhSach.timKiemHoiVienCoSo(maHoiVien, maCoSo);
                    for(int i=0;i<dsHoiVienCoSo.size();i++)
                    model.addRow(new Object[]{dsHoiVienCoSo.get(i).getMaHoiVien(),dsHoiVienCoSo.get(i).getMaCoSo(),dsHoiVienCoSo.get(i).getHanTap()});
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(bang);
        scrollPane.setBounds(5, 230, rightPanel.getWidth()-20, rightPanel.getHeight()-270);
        rightPanel.add(scrollPane);
    }
}
