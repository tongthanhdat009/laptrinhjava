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
import DTO.DTOQuanLyThietBiCoSo;
import DTO.ThietBiCoSo;

public class QuanLyBangThietBiCoSoCTR {
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm
    public QuanLyBangThietBiCoSoCTR() {
    	
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
	public void QuanLyBangThietBiCoSo(ArrayList<DTOQuanLyThietBiCoSo> ds, JPanel rightPanel)
    {
        xoaHienThi(rightPanel);
    	// JButton them = new JButton();
        // ImageIcon themBtnImg = new ImageIcon("src/asset/img/button/them-tb.png");
        // Image scaleThemBtnImg = themBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        // them.setPreferredSize(new Dimension (130,35));
        // them.setIcon(new ImageIcon(scaleThemBtnImg));
        // them.setHorizontalAlignment(SwingConstants.CENTER);
        // them.setBorder(null);

    	JButton xoa  = new JButton();
        xoa.setPreferredSize(new Dimension (110,35));
        ImageIcon xoaBtnImg = new ImageIcon("src/asset/img/button/xoa-tb.png");
        Image scaleXoaBtnImg = xoaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        xoa.setPreferredSize(new Dimension (130,35));
        xoa.setIcon(new ImageIcon(scaleXoaBtnImg));
        xoa.setHorizontalAlignment(SwingConstants.CENTER);
        xoa.setBorder(null);

    	JButton sua = new JButton();
        sua.setPreferredSize(new Dimension (110,35));
        ImageIcon suaBtnImg = new ImageIcon("src/asset/img/button/sua-tb.png");
        Image scaleSuaBtnImg = suaBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        sua.setPreferredSize(new Dimension (130,35));
        sua.setIcon(new ImageIcon(scaleSuaBtnImg));
        sua.setHorizontalAlignment(SwingConstants.CENTER);
        sua.setBorder(null);

    	JButton timKiem = new JButton();
        timKiem.setPreferredSize(new Dimension (110,35));
        timKiem.setPreferredSize(new Dimension (110,35));
        ImageIcon timKiemBtnImg = new ImageIcon("src/asset/img/button/tim-tb.png");
        Image scaletimKiemBtnImg = timKiemBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
        timKiem.setPreferredSize(new Dimension (130,35));
        timKiem.setIcon(new ImageIcon(scaletimKiemBtnImg));
        timKiem.setHorizontalAlignment(SwingConstants.CENTER);
        timKiem.setBorder(null);

        JPanel chucNang = new JPanel(new FlowLayout());
        // chucNang.add(them);
        chucNang.add(xoa);
        chucNang.add(sua);
        chucNang.add(timKiem);
        chucNang.setBounds(5,100,rightPanel.getWidth()-5,38);
        chucNang.setBackground(Color.WHITE);
        rightPanel.add(chucNang);

        JLabel maThietBiCoSo = new JLabel("Mã Thiết Bị Cơ Sở: ");
        JTextField textMaThietBiCoSo = new JTextField();

        JLabel maThietBi = new JLabel("Mã Thiết Bị: ");
        JTextField textMaThietBi = new JTextField();

        JLabel maCoSo = new JLabel("Mã Cơ Sở: ");
        JTextField textMaCoSo = new JTextField();

        JLabel hanBaoHanh = new JLabel("Hạn Bảo Hành: ");
        JTextField textHanBaoHanh = new JTextField();
        
        JLabel ngayNhap = new JLabel("Ngày Nhập: ");
        JTextField textNgayNhap = new JTextField();

        int x = 5;
        JPanel nhapLieu = new JPanel(null);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        nhapLieu.setBounds(2, 150, rightPanel.getWidth()-19, 100);
        nhapLieu.setBackground(new Color(119, 230, 163));
        nhapLieu.setBorder(titledBorder);

        maThietBiCoSo.setBounds(x, 50, 120, 30); x+=120;
        textMaThietBiCoSo.setBounds(x+10, 50, 100, 30); x+=110;
        maThietBi.setBounds(x+50, 50, 70, 30); x+=120;
        textMaThietBi.setBounds(x+10, 50, 100, 30); x+=110;
        maCoSo.setBounds(x+50, 50, 70, 30); x+=120;
        textMaCoSo.setBounds(x+10, 50, 100, 30); x+=110;
        ngayNhap.setBounds(x+50, 50, 70, 30); x+=120;
        textNgayNhap.setBounds(x+10,50,100,30); x+=110;
        hanBaoHanh.setBounds(x+50,50,90,30); x+=140;
        textHanBaoHanh.setBounds(x+10, 50, 100, 30);

        nhapLieu.add(maThietBiCoSo);
        nhapLieu.add(textMaThietBiCoSo);
        nhapLieu.add(maThietBi);
        nhapLieu.add(textMaThietBi);
        nhapLieu.add(maCoSo);
        nhapLieu.add(textMaCoSo);
        nhapLieu.add(hanBaoHanh);
        nhapLieu.add(textHanBaoHanh);
        nhapLieu.add(ngayNhap);
        nhapLieu.add(textNgayNhap);

        rightPanel.add(nhapLieu);

        DefaultTableModel model = new DefaultTableModel();
        JTable bang = new JTable(); 
        bang.setFont(new Font("Times New Roman", Font.BOLD, 14));
        
        model.addColumn("Mã Thiết Bị Cơ Sở");
        model.addColumn("Mã Cơ Sở");
        model.addColumn("Mã Thiết Bị");
        model.addColumn("Tên thiết bị");
        model.addColumn("Loại");
        model.addColumn("Ngày Nhập");
        model.addColumn("Hạn Bảo Hành");


        model.setRowCount(0);
        for(int i = 0; i < ds.size(); i++) {
            model.addRow(new Object[] {
                ds.get(i).getMaThietBiCoSo(),ds.get(i).getMaCoSo(),ds.get(i).getMaThietBi(),ds.get(i).getTenThietBi(),ds.get(i).getLoaiThietBi(),ds.get(i).getNgayNhap(),ds.get(i).getHanBaoHanh() 
            });
        }
        
        bang.setModel(model);

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
                    textMaThietBiCoSo.setText(model.getValueAt(i, 0).toString());
                    textMaCoSo.setText(model.getValueAt(i, 1).toString());
                    textMaThietBi.setText(model.getValueAt(i, 2).toString());
                    textNgayNhap.setText(model.getValueAt(i, 5).toString());
                    textHanBaoHanh.setText(model.getValueAt(i, 6).toString());
                }
            }
        });
        // them.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e)
        //     {
        //         if(!textMaThietBiCoSo.getText().equals("") || !textHanBaoHanh.getText().equals("")) 
        //         JOptionPane.showMessageDialog(rightPanel, "Không cần nhập mã thiết bị cơ sở và hạn bảo hành");
        //         else 
        //         {
        //             if(textMaCoSo.getText().equals("")||textMaThietBi.getText().equals("")||textNgayNhap.getText().equals("")) 
        //             JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
        //             else 
        //             {   
        //                 LocalDate lDateNgayNhap = LocalDate.parse(textNgayNhap.getText());
        //                 Date ngayNhap = Date.valueOf(lDateNgayNhap);

        //                 BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
        //                 String ma = bllQuanLyDanhSach.layMaThietBiCoSo();
        //                 Date hanBaoHanh = bllQuanLyDanhSach.layHanBaoHanh(textMaThietBi.getText(), ngayNhap);
        //                 String s = bllQuanLyDanhSach.themThietBiCoSo(ma,textMaCoSo.getText(),textMaThietBi.getText(),ngayNhap,hanBaoHanh);
        //                 if(s.equals("ThanhCong"))
        //                 {
        //                     model.addRow(new Object[]{
        //                         ma,textMaCoSo.getText(),textMaThietBi.getText(),ngayNhap,hanBaoHanh
        //                     });
        //                     textMaThietBiCoSo.setText(ma);
        //                     textHanBaoHanh.setText(String.valueOf(hanBaoHanh));
        //                 }
        //                 else JOptionPane.showMessageDialog(rightPanel, s);
        //             }
        //         }

        //     }
        // });
        xoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(textMaThietBiCoSo.getText().equals("")) JOptionPane.showMessageDialog(rightPanel, "Vui lòng nhập mã thiết bị cơ sở");
                else
                {
                    BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                    if(bllQuanLyDanhSach.xoaThietBiCoSO(textMaThietBiCoSo.getText()))
                    {
                        for(int i=0;i<model.getRowCount();i++)
                        if(model.getValueAt(i, 0).equals(textMaThietBiCoSo.getText())) model.removeRow(i);
                    }
                    else JOptionPane.showMessageDialog(rightPanel, "Mã thiết bị cơ sở không tồn tại");
                } 
            }
        });
        sua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(textMaThietBiCoSo.getText().equals("")
                    ||textMaCoSo.getText().equals("")
                    ||textMaThietBi.getText().equals("")
                    ||textNgayNhap.getText().equals("")
                    ||textHanBaoHanh.getText().equals("")
                    ) JOptionPane.showMessageDialog(rightPanel, "Thiếu thông tin");
                else
                {
                    LocalDate ngayNhap = LocalDate.parse(textNgayNhap.getText());
                    LocalDate hanBaoHanh = LocalDate.parse(textHanBaoHanh.getText());
                    BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                    String s = bllQuanLyDanhSach.suaThietBiCoSo(textMaThietBiCoSo.getText(), textMaCoSo.getText(), textMaThietBi.getText(), Date.valueOf(ngayNhap), Date.valueOf(hanBaoHanh));
                    if(s.equals("ThanhCong"))
                    {
                        for(int i=0;i<model.getRowCount();i++)
                        if(model.getValueAt(i,0).equals(textMaThietBiCoSo.getText())) 
                        {
                            model.setValueAt(textMaCoSo.getText(),i,1);
                            model.setValueAt(textMaThietBi.getText(),i,2);
                            model.setValueAt(textNgayNhap.getText(),i,5);
                            model.setValueAt(textHanBaoHanh.getText(),i,6);
                        }
                    }
                    else JOptionPane.showMessageDialog(rightPanel, s);
                }
            }
        });
        timKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                model.setRowCount(0);
                if(textMaThietBiCoSo.getText().equals("")&&textMaCoSo.getText().equals(""))
                for(int i = 0; i < ds.size(); i++) {
                    model.addRow(new Object[] {
                        ds.get(i).getMaThietBiCoSo(),ds.get(i).getMaCoSo(),ds.get(i).getMaThietBi(),ds.get(i).getTenThietBi(),ds.get(i).getLoaiThietBi(),ds.get(i).getNgayNhap(),ds.get(i).getHanBaoHanh() 
                    });
                }
                else
                {
                    BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
                    ArrayList<DTOQuanLyThietBiCoSo> ds2 = new ArrayList<>();
                    ds2 = bllQuanLyDanhSach.timKiemThietBiCoSo(textMaThietBiCoSo.getText(),textMaCoSo.getText(),textMaThietBi.getText());
                    for(int i = 0; i < ds2.size(); i++) {
                        model.addRow(new Object[] {
                            ds2.get(i).getMaThietBiCoSo(),ds2.get(i).getMaCoSo(),ds2.get(i).getMaThietBi(),ds2.get(i).getTenThietBi(),ds2.get(i).getLoaiThietBi(),ds2.get(i).getNgayNhap(),ds2.get(i).getHanBaoHanh() 
                        });
                    }
                }

            }
        });
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(bang);
        scrollPane.setBounds(5, 260, rightPanel.getWidth()-20, rightPanel.getHeight()-300);
        rightPanel.add(scrollPane);
    }
}
