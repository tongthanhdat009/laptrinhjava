package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import DTO.CoSo;
import DTO.DSCoSo;

public class coSoCTR {
    private final int width = 1600;
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm
    private JPanel rightPanel;
    private ArrayList<String> tenCotCS;
    private DSCoSo dsCS;
    private JPanel bangChinhSua;
    private JTable dataTable;
    private JScrollPane scrollPane;
    private BLLQuanLyDanhSach bllQuanLyDanhSach;
    
	public coSoCTR(JPanel rightPanel, ArrayList<String> tenCotCS, DSCoSo dsCS, JPanel bangChinhSua, JTable dataTable, JScrollPane scrollPane, BLLQuanLyDanhSach bllQuanLyDanhSach) {
		this.rightPanel=rightPanel;
	    this.tenCotCS=tenCotCS;
	    this.dsCS=dsCS;
	    this.bangChinhSua=bangChinhSua;
	    this.dataTable=dataTable;
	    this.scrollPane=scrollPane;
	    this.bllQuanLyDanhSach=bllQuanLyDanhSach;
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
	
	public void update() {
		xoaHienThi(rightPanel);
        // tạo model bảng
        DefaultTableModel csList = new DefaultTableModel();
        for (int i = 0; i < tenCotCS.size(); i++) {
            csList.addColumn(tenCotCS.get(i));
        }
        // Thêm dữ liệu vào bảng
        for (int i = 0; i < dsCS.dsCoSo.size(); i++) {
            csList.addRow(new Object[]{
                dsCS.dsCoSo.get(i).getMaCoSo(),
                dsCS.dsCoSo.get(i).getTenCoSo(),
                dsCS.dsCoSo.get(i).getDiaChi(),
                dsCS.dsCoSo.get(i).getThoiGianHoatDong(),
                dsCS.dsCoSo.get(i).getSDT(),
                dsCS.dsCoSo.get(i).getDoanhThu()
            });
        }
        
        //bảng hiện dòng thông tin được chọn
        bangChinhSua.setBounds(5,175,(int)(width*0.75)-25,270);
        bangChinhSua.setLayout(new GridLayout(3,3,10,10));
        bangChinhSua.setBackground(new Color(119, 230, 163));
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        bangChinhSua.setBorder(titledBorder);

        for(int i=0;i<tenCotCS.size();i++){
            JPanel tempPanel = new JPanel();
            TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackBorder,tenCotCS.get(i));
            titledBorder1.setTitleFont(titledBorder.getTitleFont().deriveFont(18f));
            tempPanel.setBorder(titledBorder1);
            tempPanel.setBackground(Color.white);

            JTextField tempTF = new JTextField();
            tempTF.setPreferredSize(new Dimension(200,20));
            tempTF.setBounds(0,20,150,20);
            tempTF.setName(tenCotCS.get(i));

            if(i == 5){
                tempTF.setEditable(false);
            }
            tempPanel.add(tempTF);
            bangChinhSua.add(tempPanel);
        }

        rightPanel.add(bangChinhSua);
        rightPanel.revalidate();
        rightPanel.repaint();

        dataTable = new JTable(csList);
        dataTable.getTableHeader().setReorderingAllowed(false);
        // for (int i = 0; i < dataTable.getColumnCount(); i++) {
        //     dataTable.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
        // }
        scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(5,460,(int)(width*0.75)-20,400);
        
        //thêm nút chức năng
        String[] cmtNut = {"add", "remove", "edit", "Search"};
        String[] anhStrings = {
            "src/asset/img/button/them-cs.png",
            "src/asset/img/button/xoa-cs.png",
            "src/asset/img/button/sua-cs.png",
            "src/asset/img/button/tim-cs.png"
        };
        int a=335;
        for(int i=0;i<cmtNut.length;i++){
            JButton tempBtn = new JButton();
            ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
            Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
            tempBtn.setActionCommand(cmtNut[i]);
            tempBtn.setBounds(a,110,130,35);
            tempBtn.setIcon(new ImageIcon(scaleTempBtnImg));
            tempBtn.setHorizontalAlignment(SwingConstants.CENTER);
            tempBtn.setBorder(null);
            tempBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(tempBtn.getActionCommand().equals(cmtNut[0])){ //thêm cơ sở
                        boolean flag = true; // cờ hiệu gán giá trị cho mã 
                        ArrayList<String> thongTinMoi = new ArrayList<String>(); 
                        Component[] components = bangChinhSua.getComponents();
                        for (int i=0; i<components.length;i++) {
                            if (components[i] instanceof JPanel) {
                                JPanel tempPanel = (JPanel) components[i];
                                Component[] smallComponents = tempPanel.getComponents();
                                for (int j=0;j<smallComponents.length;j++) {
                                    if(smallComponents[j] instanceof JTextField){
                                        JTextField textField = (JTextField) smallComponents[j];
                                        String text = textField.getText().trim(); // Lấy text từ textField và loại bỏ khoảng trắng đầu cuối
                                        if (flag && j == 0) {
                                            int maxSTT = bllQuanLyDanhSach.kiemTraMaCoSo();
                                            textField.setText(String.format("CS%03d", maxSTT));
                                            thongTinMoi.add(textField.getText());
                                            flag = false;
                                        }
                                        else if (text.equals("") && textField.isEditable()) {
                                            JOptionPane.showMessageDialog(bangChinhSua, "Không được để trống thông tin và không cần nhập mã cơ sở!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
                                            textField.requestFocus();
                                            return; // Kết thúc sự kiện nếu có thông tin bị thiếu
                                        } 
                                        else if (text.equals("") && !textField.isEditable()) {
                                        	thongTinMoi.add("0");
                                        } 
                                        else {
                                            thongTinMoi.add(text);
                                        }
                                    }
                                }
                            }
                        }
                        System.out.println(thongTinMoi);
                         // Kiểm tra xem thongTinMoi có đủ 6 phần tử không trước khi thêm vào hvList
                        if (thongTinMoi.size() >= 5) {
                            csList.addRow(thongTinMoi.toArray());
                            CoSo tempCS = new CoSo(thongTinMoi.get(0),
                                                        thongTinMoi.get(1),
                                                        thongTinMoi.get(2),
                                                        thongTinMoi.get(3),
                                                        thongTinMoi.get(4),
                                                        0);
                            if(bllQuanLyDanhSach.themCS(tempCS)){
                                JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if(tempBtn.getActionCommand().equals(cmtNut[1])){ //xóa cơ sở
                        int i=dataTable.getSelectedRow();
                        if(i>=0){
                            Component[] components = bangChinhSua.getComponents();
                            csList.removeRow(i);
                            for (Component component : components) {
                                if (component instanceof JPanel) {
                                    JPanel tempPanel = (JPanel) component;
                                    Component[] smallComponents = tempPanel.getComponents();
                                    for (Component smallComponent : smallComponents) {
                                        if(smallComponent instanceof JTextField){
                                            JTextField textField = (JTextField) smallComponent;
                                            if(bllQuanLyDanhSach.xoaCS(textField.getText())){
                                                textField.setText("");
                                                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Xóa cơ sở", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            for (Component component : components) {
                                if (component instanceof JPanel) {
                                    JPanel tempPanel = (JPanel) component;
                                    Component[] smallComponents = tempPanel.getComponents();
                                    for (Component smallComponent : smallComponents) {
                                        if(smallComponent instanceof JTextField){
                                            JTextField textField = (JTextField) smallComponent;
                                                textField.setText("");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(tempBtn.getActionCommand().equals(cmtNut[2])){ // sửa thông tin cơ sở
                        int i= dataTable.getSelectedRow();
                        ArrayList<String> thongTinMoi = new ArrayList<String>();
                        if (i>=0){
                        	String maGoc = csList.getValueAt(i, 0).toString();
                            Component[] components = bangChinhSua.getComponents();
                            for (Component component : components) {
                                if (component instanceof JPanel) {
                                    JPanel tempPanel = (JPanel) component;
                                    Component[] smallComponents = tempPanel.getComponents();
                                    for (Component smallComponent : smallComponents) {
                                        if (smallComponent instanceof JTextField) {
                                            JTextField textField = (JTextField) smallComponent;
                                            String text = textField.getText();
                                        	thongTinMoi.add(text);
                                        }
                                    }
                                }
                            }
                            
                            String sdtCS = thongTinMoi.get(4);
                            if(!bllQuanLyDanhSach.kiemTraSDT(sdtCS)){
                                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            System.out.println(maGoc);
                            if(!thongTinMoi.get(0).equals("") && thongTinMoi.get(0).equals(maGoc)) {
	                                CoSo tempCS = new CoSo(thongTinMoi.get(0),
	                                                            thongTinMoi.get(1),
	                                                            thongTinMoi.get(2),
	                                                            thongTinMoi.get(3),
	                                                            sdtCS,
	                                                            Integer.parseInt(thongTinMoi.get(5)));
	                                if(bllQuanLyDanhSach.suaThongTinCS(tempCS)){
	                                    JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
	                                    for (int j = 0; j <thongTinMoi.size();j++) {
	                                    	if(j==0) {
	                                    		csList.setValueAt(thongTinMoi.get(j).toUpperCase(), i, j);
	                                    	}
	                                    	else {
	                                    		csList.setValueAt(thongTinMoi.get(j), i, j);
	                                    	}
	                                    }
	                                }
	                                else{
	                                    JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công! Lưu ý: Không được sửa mã cơ sở", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
	                                }
	                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công! Lưu ý: Không được sửa mã cơ sở", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin vui lòng chọn 1 dòng để sửa", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if(tempBtn.getActionCommand().equals(cmtNut[3])){//tìm kiếm cơ sở
                    	ArrayList<String> thongTin = new ArrayList<String>();
                        Component[] components = bangChinhSua.getComponents();
                        for(Component component : components) {
                            if(component instanceof JPanel){
                                JPanel panel = (JPanel) component;
                                Component[] smallComponents = panel.getComponents();
                                for(Component smallComponent : smallComponents){
                                    if(smallComponent instanceof JTextField){
                                        JTextField textField = (JTextField) smallComponent;
                                        if(textField.getText().equals("")){
                                            thongTin.add("");                                                    
                                        }
                                        else{
                                            thongTin.add(textField.getText());
                                        }
                                    }
                                }
                            }
                        }
                        if(thongTin.size()>=5){
                        	int doanhThu = 0;
                        	try {
                    			doanhThu = Integer.parseInt(thongTin.get(5));
                        	}
                        	catch(NumberFormatException ex) {
                        		doanhThu = 0;
                        	}
                            CoSo tempCS = new CoSo(thongTin.get(0),
                                                        thongTin.get(1),
                                                        thongTin.get(2),
                                                        thongTin.get(3),
                                                        thongTin.get(4),
                                                        doanhThu);
                            System.out.println(bllQuanLyDanhSach.timKiemCS(tempCS).dsCoSo.size());
                            if(bllQuanLyDanhSach.timKiemCS(tempCS).dsCoSo.size() != 0 && bllQuanLyDanhSach.timKiemCS(tempCS).dsCoSo.size() != dsCS.dsCoSo.size()){
                                JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm thành công","Tìm kiếm cơ sở", JOptionPane.INFORMATION_MESSAGE);
                                DSCoSo dsCS2 = bllQuanLyDanhSach.timKiemCS(tempCS);
                                csList.setRowCount(0);
                                
                                for (int i = 0; i < dsCS2.dsCoSo.size(); i++) {
                                    csList.addRow(new Object[]{dsCS2.dsCoSo.get(i).getMaCoSo().trim(),
                                    		dsCS2.dsCoSo.get(i).getTenCoSo().trim(),
                                    		dsCS2.dsCoSo.get(i).getDiaChi().trim(),
                                    		dsCS2.dsCoSo.get(i).getThoiGianHoatDong().trim(),
                                    		dsCS2.dsCoSo.get(i).getSDT().trim(),
                                    		dsCS2.dsCoSo.get(i).getDoanhThu()});
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(bangChinhSua, "Vui lòng nhập thêm hoặc kiểm tra lại thông tin để có được kết quả tìm kiếm chính xác","Tìm kiếm cơ sở", JOptionPane.ERROR_MESSAGE);
                                csList.setRowCount(0);
                                for (int i = 0; i < dsCS.dsCoSo.size(); i++) {
                                    csList.addRow(new Object[]{dsCS.dsCoSo.get(i).getMaCoSo(),
                                		dsCS.dsCoSo.get(i).getTenCoSo().trim(),
                                		dsCS.dsCoSo.get(i).getDiaChi().trim(),
                                		dsCS.dsCoSo.get(i).getThoiGianHoatDong().trim(),
                                		dsCS.dsCoSo.get(i).getSDT().trim(),
                                		dsCS.dsCoSo.get(i).getDoanhThu()});
                                }
                            }
                        }
                    }
                }
                
            });
            a+=175;
            rightPanel.add(tempBtn);
        }

        rightPanel.add(scrollPane);

        //xử lý sự kiện cho bảng
        dataTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = dataTable.getSelectedRow();
                if(i>=0){
                    Component[] components = bangChinhSua.getComponents();
                    int j=0;
                    for(Component a : components){
                        if(a instanceof JPanel){
                            JPanel tempPanel = (JPanel) a;
                            Component[] smallComponents = tempPanel.getComponents();
                            for(Component b : smallComponents){
                                if(b instanceof JTextField){
                                    JTextField tempTF = (JTextField) b;
                                    tempTF.setText(csList.getValueAt(i, j).toString().trim());
                                    j++;
                                }
                            }
                        }
                    }
                    bangChinhSua.revalidate();
                    bangChinhSua.repaint();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            
        });
	}
}
