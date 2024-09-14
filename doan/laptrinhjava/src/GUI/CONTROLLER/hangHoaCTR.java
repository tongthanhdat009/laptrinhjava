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
import DTO.dsHangHoa;
import DTO.hangHoa;

public class hangHoaCTR {
	private final int width = 1600;
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm
    private JPanel rightPanel;
    private ArrayList<String> tenCotHH;
    private dsHangHoa dsHH;
    private JPanel bangChinhSua;
    private JTable dataTable;
    private JScrollPane scrollPane;
    private BLLQuanLyDanhSach bllQuanLyDanhSach;

    public hangHoaCTR(JPanel rightPanel, ArrayList<String> tenCotHH, dsHangHoa dsHH, JPanel bangChinhSua, JTable dataTable, JScrollPane scrollPane, BLLQuanLyDanhSach bllQuanLyDanhSach){
    	this.rightPanel=rightPanel;
	    this.tenCotHH=tenCotHH;
	    this.dsHH=dsHH;
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
		rightPanel.setBackground(new Color(241,255,250));
        // tạo model bảng
        DefaultTableModel hhList = new DefaultTableModel();
        for (int i = 0; i < tenCotHH.size(); i++) {
            hhList.addColumn(tenCotHH.get(i));
        }
        // Thêm dữ liệu vào bảng
        for (int i = 0; i < dsHH.dsHangHoa.size(); i++) {
                hhList.addRow(new Object[]{
                dsHH.dsHangHoa.get(i).getMaHangHoa().trim(),
                dsHH.dsHangHoa.get(i).getLoaiHangHoa().trim(),
                dsHH.dsHangHoa.get(i).getTenLoaiHangHoa().trim(),
                dsHH.dsHangHoa.get(i).getHinhAnh().trim(),
                dsHH.dsHangHoa.get(i).getGiaNhap(),
                });
        }
        
        //bảng hiện dòng thông tin được chọn
        bangChinhSua = new JPanel();
        bangChinhSua.setBounds(5,175,(int)(width*0.75)-25,270);
        bangChinhSua.setLayout(new GridLayout(3,3,10,10));
        bangChinhSua.setBackground(new Color(119, 230, 163));
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
        titledBorder.setTitleFont(italicBoldFont);
        bangChinhSua.setBorder(titledBorder);
       
        for(int i=0;i<tenCotHH.size();i++){
            JPanel tempPanel = new JPanel();
            TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackBorder,tenCotHH.get(i));
            titledBorder1.setTitleFont(titledBorder.getTitleFont().deriveFont(18f));
            tempPanel.setBorder(titledBorder1);
            tempPanel.setBackground(Color.white);

            JTextField tempTF = new JTextField();
            tempTF.setPreferredSize(new Dimension(200,20));
            tempTF.setBounds(0,20,120,20);
            tempTF.setName(tenCotHH.get(i));

            if(i==1){
                String[] tempStr = {"Dụng cụ", "Thực phẩm chức năng"};
                @SuppressWarnings("rawtypes")
                JComboBox tempCB = new JComboBox<String>(tempStr);
                tempCB.setPreferredSize(new Dimension(150,30));
                tempCB.setFont(new Font("Times New Roman",1,16)); 
//                tempCB.setRenderer(renderer);
                tempCB.setBackground(Color.WHITE);

                tempPanel.add(tempCB);
                bangChinhSua.add(tempPanel);
                continue;
            }
            // tempPanel.add(tempLabel);
            tempPanel.add(tempTF);
            bangChinhSua.add(tempPanel);
        }

        rightPanel.add(bangChinhSua);
        rightPanel.revalidate();
        rightPanel.repaint();

        dataTable = new JTable(hhList);
        dataTable.getTableHeader().setReorderingAllowed(false);
        // for (int i = 0; i < dataTable.getColumnCount(); i++) {
        //     dataTable.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
        // }
        scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(5,460,(int)(width*0.75)-20,400);

        //nút chức năng
        String[] cmtNut = {"add", "remove", "edit", "Search"};
        String[] anhStrings = {
            "src/asset/img/button/hh-them.png",
            "src/asset/img/button/hh-xoa.png",
            "src/asset/img/button/hh-sua.png",
            "src/asset/img/button/hh-tim.png"
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
                    if(tempBtn.getActionCommand().equals(cmtNut[0])){ //thêm hàng hóa
                        boolean flag = true; // cờ hiệu gán giá trị cho mã hàng hóa
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
                                            int maxSTT = bllQuanLyDanhSach.kiemTraMaHangHoa();
                                            textField.setText(String.format("HH%03d", maxSTT));
                                            thongTinMoi.add(textField.getText());
                                            flag = false;
                                        }
                                        else if(bllQuanLyDanhSach.kiemTraGiaNhapHangHoa(text)== -1 && components[4] == tempPanel) {
                                        	JOptionPane.showMessageDialog(null, "Giá nhập hàng hóa phải là số và lớn hơn 0", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                                        	return;
                                        }
                                        else if (text.equals("")) {
                                            JOptionPane.showMessageDialog(bangChinhSua, "Không được để trống thông tin!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
                                            textField.requestFocus();
                                            return; // Kết thúc sự kiện nếu có thông tin bị thiếu
                                        } 
                                        else {
                                            thongTinMoi.add(text);
                                        }
                                    }
                                    if(smallComponents[j] instanceof JComboBox){
                                        @SuppressWarnings("rawtypes")
                                        JComboBox tempCB = (JComboBox) smallComponents[j];
                                        thongTinMoi.add((String)tempCB.getSelectedItem());
                                    }
                                }
                            }
                        }
                         // Kiểm tra xem thongTinMoi có đủ 5 phần tử không trước khi thêm vào hhList
                        if (thongTinMoi.size() >= 5) {
                            try{
                                hangHoa tempHH;
                                tempHH = new hangHoa(thongTinMoi.get(0),
                                                    thongTinMoi.get(1),
                                                    thongTinMoi.get(2),
                                                    thongTinMoi.get(3),
                                                    Integer.parseInt(thongTinMoi.get(4)));
                                if(bllQuanLyDanhSach.themHH(tempHH)){
                                    JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công!");
                                    hhList.addRow(thongTinMoi.toArray());
                                }
                            }
                            catch(IllegalArgumentException ex){
                                JOptionPane.showMessageDialog(bangChinhSua, ex.getMessage(), "Thông tin không hợp lệ", JOptionPane.ERROR_MESSAGE);
                                hhList.removeRow(dataTable.getRowCount()-1);
                                return;
                            }
                        } 
                        else {
                            JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if(tempBtn.getActionCommand().equals(cmtNut[1])){ //xóa hàng hóa
                        int i=dataTable.getSelectedRow();
                        if(i>=0){
                            Component[] components = bangChinhSua.getComponents();
                            hhList.removeRow(i);
                            for (Component component : components) {
                                if (component instanceof JPanel) {
                                    JPanel tempPanel = (JPanel) component;
                                    Component[] smallComponents = tempPanel.getComponents();
                                    for (Component smallComponent : smallComponents) {
                                        if(smallComponent instanceof JTextField){
                                            JTextField textField = (JTextField) smallComponent;
                                            if(bllQuanLyDanhSach.xoaHangHoa(textField.getText())){
                                                textField.setText("");
                                                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Xóa thiết bị", JOptionPane.INFORMATION_MESSAGE);
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
                                        if(smallComponent instanceof JComboBox){
                                            @SuppressWarnings("rawtypes")
                                            JComboBox tempCB = (JComboBox) smallComponent;
                                            tempCB.setSelectedItem("Dụng cụ");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(tempBtn.getActionCommand().equals(cmtNut[2])){ //sửa thông tin hàng hóa
                        int i= dataTable.getSelectedRow();
                        ArrayList<String> thongTinMoi = new ArrayList<String>();
                        if (i>=0){
                        	String maGoc = hhList.getValueAt(i, 0).toString();
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
                                        if (smallComponent instanceof JComboBox) {
                                            @SuppressWarnings("rawtypes")
                                            JComboBox tempCB = (JComboBox) smallComponent;
                                            String text = (String) tempCB.getSelectedItem();
                                            thongTinMoi.add(text);
                                        }
                                    }
                                }
                            }
                            if(bllQuanLyDanhSach.kiemTraGiaNhapHangHoa(thongTinMoi.get(4)) == -1) {
                            	JOptionPane.showMessageDialog(null, "Giá nhập hàng hóa phải là số và lớn hơn 0", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                            	return;
                            }
                            if(!thongTinMoi.get(0).equals("") && thongTinMoi.get(0).equals(maGoc)) {
                            	hangHoa tempHH;
                            	tempHH = new hangHoa(thongTinMoi.get(0),
                            			thongTinMoi.get(1),
                            			thongTinMoi.get(2),
                            			thongTinMoi.get(3),
                            			Integer.parseInt(thongTinMoi.get(4)));
                            	if(bllQuanLyDanhSach.suaThongTinHH(tempHH)){
                            		JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
                            		hhList.setValueAt(thongTinMoi.get(0).toUpperCase(), i, 0);
                            		hhList.setValueAt(thongTinMoi.get(1), i, 1);
                            		hhList.setValueAt(thongTinMoi.get(2), i, 2);
                            		hhList.setValueAt(thongTinMoi.get(3), i, 3);
                            		hhList.setValueAt(thongTinMoi.get(4), i, 4);
                            	}
                            	else{
                            		JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công! Lưu ý: Không được sửa mã hàng hóa", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                            		return;
                            	}                            	
                            }
                            else {
                        		JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công! Lưu ý: Không được sửa hay để trống mã hàng hóa", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                            }
                        } 
                        else {
                            JOptionPane.showMessageDialog(null, "Thiếu thông tin vui lòng chọn 1 dòng để sửa", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    }
                    else if(tempBtn.getActionCommand().equals(cmtNut[3])){ //tìm kiếm hàng hóa theo mã tron danh sách
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
                                    else if(smallComponent instanceof JComboBox) {
                                    	JComboBox cbb = (JComboBox) smallComponent;
                                    	thongTin.add(cbb.getSelectedItem().toString());
                                    }
                                    
                                }
                            }
                        }
                        hangHoa tempHH = new hangHoa(thongTin.get(0),
                                                    thongTin.get(1),
                                                    thongTin.get(2),
                                                    "",
                                                    0);
                        if(bllQuanLyDanhSach.timKiemHH(tempHH).dsHangHoa.size() != 0 && bllQuanLyDanhSach.timKiemHH(tempHH).dsHangHoa.size() != dsHH.dsHangHoa.size()){
                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm thành công","Tìm kiếm hàng hóa", JOptionPane.INFORMATION_MESSAGE);
                            dsHangHoa dsHH2 = bllQuanLyDanhSach.timKiemHH(tempHH);
                            hhList.setRowCount(0);
                            
                            for (int i = 0; i < dsHH2.dsHangHoa.size(); i++) {
                                hhList.addRow(new Object[]{dsHH2.dsHangHoa.get(i).getMaHangHoa().trim(),
                                		dsHH2.dsHangHoa.get(i).getLoaiHangHoa().trim(),
                                		dsHH2.dsHangHoa.get(i).getTenLoaiHangHoa().trim(),
                                		dsHH.dsHangHoa.get(i).getHinhAnh().trim(),
                                		dsHH.dsHangHoa.get(i).getGiaNhap()});
                            }
                            for(Component component : components) {
                                if(component instanceof JPanel){
                                    JPanel panel = (JPanel) component;
                                    Component[] smallComponents = panel.getComponents();
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(bangChinhSua, "Vui lòng nhập thêm hoặc kiểm tra lại thông tin để có được kết quả tìm kiếm chính xác","Tìm kiếm hàng hóa", JOptionPane.ERROR_MESSAGE);
                            hhList.setRowCount(0);
                            for (int i = 0; i < dsHH.dsHangHoa.size(); i++) {
                                hhList.addRow(new Object[]{dsHH.dsHangHoa.get(i).getMaHangHoa(),
                            		dsHH.dsHangHoa.get(i).getLoaiHangHoa().trim(),
                            		dsHH.dsHangHoa.get(i).getTenLoaiHangHoa().trim(),
                            		dsHH.dsHangHoa.get(i).getHinhAnh().trim(),
                            		dsHH.dsHangHoa.get(i).getGiaNhap()});
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
                                    tempTF.setText(hhList.getValueAt(i, j).toString().trim());
                                    j++;
                                }
                                if(b instanceof JComboBox){
                                    @SuppressWarnings("rawtypes")
                                    JComboBox tempCB = (JComboBox) b;
                                    tempCB.setSelectedItem(hhList.getValueAt(i, j).toString().trim());
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
