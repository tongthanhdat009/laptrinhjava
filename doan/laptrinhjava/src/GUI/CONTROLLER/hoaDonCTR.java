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
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLLQuanLyDanhSach;
import DTO.HoaDon;

public class hoaDonCTR {
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm
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
	public void QuanLyHoaDon(ArrayList<HoaDon> ds, Vector<String> dsMaCoSo, JPanel rightPanel)
    {
        xoaHienThi(rightPanel);
		rightPanel.setBackground(new Color(241,255,250));
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
        nhapLieu.setBounds(2, 150, rightPanel.getWidth()-20, 150);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        nhapLieu.setBackground(new Color(119, 230, 163));
        nhapLieu.setBorder(titledBorder);

        JLabel lbMaHoaDon = new JLabel("Mã hóa đơn: ");
        JLabel lbNgayXuatHoaDon = new JLabel("Ngày xuất hóa đơn: ");
        JLabel lbtongTien = new JLabel("Tổng tiền: ");
        JLabel lbMaHV = new JLabel("Mã hội viên: ");
        JLabel lbMaCoSO = new JLabel("Mã cơ sở: ");
        JLabel lbTrangThai = new JLabel("Trạng thái: ");
        JTextField tfMaHoaDon = new JTextField();
        JTextField tfNgayXuatHoaDon = new JTextField();
        JTextField tftongTien = new JTextField();
        JTextField tfMaHV = new JTextField();
        @SuppressWarnings("rawtypes")
        JComboBox cbMaCoSO = new JComboBox(dsMaCoSo);
        cbMaCoSO.setRenderer(renderer);
        cbMaCoSO.setBackground(Color.white);
        JTextField tfTrangThai = new JTextField();
        int x = 10;
        lbMaHoaDon.setBounds(x,40,80,30); x+=80;
        tfMaHoaDon.setBounds(x+10, 40, 100, 30); x+=105;
        lbNgayXuatHoaDon.setBounds(x+50, 40, 120, 30); x+=165;
        tfNgayXuatHoaDon.setBounds(x+10, 40, 100, 30); x+=105;
        lbtongTien.setBounds(x+50,40,70,30); x+=115;
        tftongTien.setBounds(x+10, 40, 100, 30); x+=105;
        lbMaHV.setBounds(x+50, 40, 80, 30); x+=125;
        tfMaHV.setBounds(x+10, 40, 100, 30); x+=105;
        lbMaCoSO.setBounds(x+50, 40, 70, 30); x+=115;
        cbMaCoSO.setBounds(x+10, 40, 100, 30); x+=105;
        lbTrangThai.setBounds(450, 100, 80, 35);
        JRadioButton daduyet = new JRadioButton("Đã duyệt");
        daduyet.setBounds(540, 100, 100, 35);
        daduyet.setBackground(new Color(119, 230, 163));
        JRadioButton chuaduyet = new JRadioButton("Chưa duyệt");
        chuaduyet.setBounds(650, 100, 100, 35);
        chuaduyet.setBackground(new Color(119, 230, 163));
        ButtonGroup bg = new ButtonGroup();
        bg.add(daduyet);
        bg.add(chuaduyet);

        nhapLieu.add(lbMaHoaDon);
        nhapLieu.add(tfMaHoaDon);
        nhapLieu.add(lbNgayXuatHoaDon);
        nhapLieu.add(tfNgayXuatHoaDon);
        nhapLieu.add(lbtongTien);
        nhapLieu.add(tftongTien);
        nhapLieu.add(lbMaHV);
        nhapLieu.add(tfMaHV);
        nhapLieu.add(lbMaCoSO);
        nhapLieu.add(cbMaCoSO);
        nhapLieu.add(lbTrangThai);
        nhapLieu.add(daduyet);
        nhapLieu.add(chuaduyet);
        rightPanel.add(nhapLieu);

        JTable bang = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        bang.setModel(model);
        model.addColumn("Mã hóa đơn");
        model.addColumn("Ngày xuất hóa đơn");
        model.addColumn("Tổng tiền");
        model.addColumn("Mã hội viên");
        model.addColumn("Mã cơ sở");
        model.addColumn("Trạng thái");
        for(int i=0;i<ds.size();i++)
        {
            String trangThai;
            if(ds.get(i).getTrangThai().trim().equals("1")) trangThai = "Đã duyệt";
            else trangThai = "Chưa duyệt";
            model.addRow(new Object[]{ds.get(i).getMaHoaDon(),ds.get(i).getNgayXuatHoaDon(),ds.get(i).getTongTien(),ds.get(i).getMaHoiVien(),ds.get(i).getMaCoSo(),trangThai});
        }
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
                    tfMaHoaDon.setText(model.getValueAt(i, 0).toString());
                    tfNgayXuatHoaDon.setText(model.getValueAt(i, 1).toString());
                    tftongTien.setText(model.getValueAt(i, 2).toString());
                    tfMaHV.setText(model.getValueAt(i, 3).toString());
                    cbMaCoSO.setSelectedItem(model.getValueAt(i, 4).toString());
                    if(model.getValueAt(i, 5) == "Đã duyệt") daduyet.setSelected(true);
                    else chuaduyet.setSelected(true);
                }
            }
        });
        BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
        them.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(!tfMaHoaDon.getText().equals("")|| !tftongTien.getText().equals("")) JOptionPane.showMessageDialog(rightPanel, "Không cần nhập mã hóa đơn và tổng tiền");
                if(tfMaHV.getText().equals("")||tfNgayXuatHoaDon.getText().equals("")||cbMaCoSO.getSelectedIndex() == 0 || (!daduyet.isSelected()&&!chuaduyet.isSelected()) ) JOptionPane.showMessageDialog(rightPanel, "Thiết thông tin");
                String trangThai;
                if(daduyet.isSelected()) trangThai = "1";
                else trangThai = "0";
                LocalDate localDate = LocalDate.parse(tfNgayXuatHoaDon.getText());
                Date date = Date.valueOf(localDate);
                String s;
                String ma = bllQuanLyDanhSach.layMaHoaDon();
                s = bllQuanLyDanhSach.themHoaDon(date, tfMaHV.getText(), cbMaCoSO.getSelectedItem().toString(), trangThai);
                JOptionPane.showMessageDialog(rightPanel,s);
                if(s.equals("Thành công")) 
                {
                    tfMaHoaDon.setText(ma);
                    tftongTien.setText("0");
                    if(trangThai.equals("1")) model.addRow(new Object[]{ma,date,0,tfMaHV.getText(),cbMaCoSO.getSelectedItem().toString(),"Đã duyệt"});
                    else model.addRow(new Object[]{ma,date,0,tfMaHV.getText(),cbMaCoSO.getSelectedItem().toString(),"Chưa duyệt"});
                }
            }
        });
        xoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(tfMaHoaDon.getText().equals("")) JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã hóa đơn");
                else 
                {
                    String s = bllQuanLyDanhSach.xoaHoaDon(tfMaHoaDon.getText());
                    JOptionPane.showMessageDialog(rightPanel,s);
                    if(s.equals("Thành công"))
                    {
                        for(int i=0;i<model.getRowCount();i++)  
                        if(model.getValueAt(i, 0).equals(tfMaHoaDon.getText()))
                        {
                            model.removeRow(i);
                            break;
                        } 
                    }
                }
            }
        });
        sua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if( tfMaHoaDon.getText().equals("") || 
                    tfMaHV.getText().equals("") ||
                    tfNgayXuatHoaDon.getText().equals("") ||
                    cbMaCoSO.getSelectedIndex() == 0 || 
                    (!daduyet.isSelected()&&!chuaduyet.isSelected())) JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                else 
                {
                    if(!tftongTien.getText().equals("")) JOptionPane.showMessageDialog(rightPanel, "Không cần nhập tổng tiền");
                    else 
                    {
                        String trangThai;
                        if(daduyet.isSelected()) trangThai = "1";
                        else trangThai = "0";
                        LocalDate localDate = LocalDate.parse(tfNgayXuatHoaDon.getText());
                        Date date = Date.valueOf(localDate);
                        String s = bllQuanLyDanhSach.suaHoaDon(tfMaHoaDon.getText(), date, tfMaHV.getText(), cbMaCoSO.getSelectedItem().toString(),trangThai);
                        JOptionPane.showMessageDialog(rightPanel, s);
                        if(s.equals("Thành công"))
                        {
                            for(int i=0;i<model.getRowCount();i++)  
                            if(model.getValueAt(i, 0).equals(tfMaHoaDon.getText()))
                            {
                                model.setValueAt(tfNgayXuatHoaDon.getText(), i, 1);
                                model.setValueAt(tfMaHV.getText(), i, 3);
                                model.setValueAt(cbMaCoSO.getSelectedItem().toString(), i, 4);
                                if(trangThai.equals("1")) model.setValueAt("Đã duyệt", i, 5);
                                else model.setValueAt("Chưa duyệt", i, 5);
                                break;
                            } 
                        }
                    }
                }
            }
        });
        timKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                model.setRowCount(0);
                if(tfMaHoaDon.getText().equals("")) 
                {
                    for(int i=0;i<ds.size();i++)
                    {
                        String trangThai;
                        if(ds.get(i).getTrangThai().trim().equals("1")) trangThai = "Đã duyệt";
                        else trangThai = "Chưa duyệt";
                        model.addRow(new Object[]{ds.get(i).getMaHoaDon(),ds.get(i).getNgayXuatHoaDon(),ds.get(i).getTongTien(),ds.get(i).getMaHoiVien(),ds.get(i).getMaCoSo(),trangThai});
                    }
                }
                else
                {
                    ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
                    dsHoaDon = bllQuanLyDanhSach.timKiemHoaDon(tfMaHoaDon.getText());
                    for(int i=0;i<dsHoaDon.size();i++)
                    {
                        String trangThai;
                        if(dsHoaDon.get(i).getTrangThai().trim().equals("1")) trangThai = "Đã duyệt";
                        else trangThai = "Chưa duyệt";
                        model.addRow(new Object[]{dsHoaDon.get(i).getMaHoaDon(),dsHoaDon.get(i).getNgayXuatHoaDon(),dsHoaDon.get(i).getTongTien(),dsHoaDon.get(i).getMaHoiVien(),dsHoaDon.get(i).getMaCoSo(),trangThai});
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(bang);
        scrollPane.setBounds(5, 300, rightPanel.getWidth()-20, rightPanel.getHeight()-340);
        rightPanel.add(scrollPane);
    }
}
