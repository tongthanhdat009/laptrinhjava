//package GUI.CONTROLLER;
//
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.border.Border;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//
//import BLL.BLLQuanLyDanhSach;
//import DTO.DSLoaiThietBi;
//import DTO.LoaiThietBi;
//import GUI.renderer;
//
//public class thietBiCTR {
//	private final int width = 1600;
//    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm
//    private JPanel rightPanel;
//    private ArrayList<String> tenCotTB;
//    private DSLoaiThietBi dsTB;
//    private JPanel bangChinhSua;
//    private JTable dataTable;
//    private JScrollPane scrollPane;
//    private BLLQuanLyDanhSach bllQuanLyDanhSach;
//
//    public thietBiCTR(JPanel rightPanel, ArrayList<String> tenCotTB, DSLoaiThietBi dsTB, JPanel bangChinhSua, JTable dataTable, JScrollPane scrollPane, BLLQuanLyDanhSach bllQuanLyDanhSach){
//    	this.rightPanel=rightPanel;
//	    this.tenCotTB=tenCotTB;
//	    this.dsTB=dsTB;
//	    this.bangChinhSua=bangChinhSua;
//	    this.dataTable=dataTable;
//	    this.scrollPane=scrollPane;
//	    this.bllQuanLyDanhSach=bllQuanLyDanhSach;
//    }
//    
//    public void xoaHienThi(JPanel rightPanel){
//        Component[] components = rightPanel.getComponents();
//        for(Component a : components){
//            if(!(a instanceof JLabel || a instanceof JComboBox)){
//                rightPanel.remove(a);
//            }
//        }
//        rightPanel.revalidate();
//        rightPanel.repaint();
//    }
//	
//    public void update() {
//		xoaHienThi(rightPanel);
//        // tạo model bảng
//        DefaultTableModel tbList = new DefaultTableModel();
////        for (int i = 0; i < tenCotTB.size(); i++) {
////            tbList.addColumn(tenCotTB.get(i));
////        }
//        tbList.addColumn("Mã cơ sở");
//        tbList.addColumn("Tên loại thiết bị");
//        tbList.addColumn("Hình ảnh");
//        tbList.addColumn("Giá thiết bị");
//        tbList.addColumn("Ngày bảo hành");
//        // Thêm dữ liệu vào bảng
//        for (int i = 0; i < dsTB.dsThietBi.size(); i++) {
//            tbList.addRow(new Object[]{
//                dsTB.dsThietBi.get(i).getMaThietBi().trim(),
//                dsTB.dsThietBi.get(i).getTenLoaiThietBi().trim(),
//                dsTB.dsThietBi.get(i).getHinhAnh().trim(),
//                dsTB.dsThietBi.get(i).getGiaThietBi().trim(),
//                dsTB.dsThietBi.get(i).getNgayBaoHanh(),
//            });
//        }
//        
//        //bảng hiện dòng thông tin được chọn
//        bangChinhSua = new JPanel();
//        bangChinhSua.setBounds(5,175,(int)(width*0.75)-25,270);
//        bangChinhSua.setLayout(new GridLayout(3,3,10,10));
//        bangChinhSua.setBackground(new Color(119, 230, 163));
//        
//        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
//        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder,"Nhập liệu");
//        titledBorder.setTitleFont(italicBoldFont);
//        bangChinhSua.setBorder(titledBorder);
//
//        for(int i=0;i<tenCotTB.size();i++){
//            JPanel tempPanel = new JPanel();
//            TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackBorder,tenCotTB.get(i));
//            titledBorder1.setTitleFont(titledBorder.getTitleFont().deriveFont(18f));
//            tempPanel.setBorder(titledBorder1);
//            tempPanel.setBackground(Color.white);
//
//            JTextField tempTF = new JTextField();
//            tempTF.setPreferredSize(new Dimension(150,20));
//            tempTF.setBounds(0,20,120,20);
//            tempTF.setName(tenCotTB.get(i));
//
//            tempPanel.add(tempTF);
//            bangChinhSua.add(tempPanel);
//        }
//
//        rightPanel.add(bangChinhSua);
//        rightPanel.revalidate();
//        rightPanel.repaint();
//
//        dataTable = new JTable(tbList);
//        dataTable.getTableHeader().setReorderingAllowed(false);
//        // for (int i = 0; i < dataTable.getColumnCount(); i++) {
//        //     dataTable.getColumnModel().getColumn(i).setCellRenderer(rendererTable);
//        // }
//        scrollPane = new JScrollPane(dataTable);
//        scrollPane.setBounds(5,460,(int)(width*0.75)-20,400);
//        
//        //thêm nút chức năng
//        String[] cmtNut = {"add", "remove", "edit", "Search"};
//        String[] anhStrings = {
//            "src/asset/img/button/them-TB.png",
//            "src/asset/img/button/xoa-TB.png",
//            "src/asset/img/button/sua-TB.png",
//            "src/asset/img/button/tim-TB.png"
//        };
//        int a=335;
//        for(int i=0;i<cmtNut.length;i++){
//            JButton tempBtn = new JButton();
//            ImageIcon tempBtnImg = new ImageIcon(anhStrings[i]);
//            Image scaleTempBtnImg = tempBtnImg.getImage().getScaledInstance(130,35,Image.SCALE_DEFAULT);
//            tempBtn.setActionCommand(cmtNut[i]);
//            tempBtn.setBounds(a,110,130,35);
//            tempBtn.setIcon(new ImageIcon(scaleTempBtnImg));
//            tempBtn.setHorizontalAlignment(SwingConstants.CENTER);
//            tempBtn.setBorder(null);
//            tempBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if(tempBtn.getActionCommand().equals(cmtNut[0])){ //thêm thiết bị
//                        boolean flag = true; // cờ hiệu gán giá trị cho mã hội viên
//                        ArrayList<String> thongTinMoi = new ArrayList<String>(); 
//                        Component[] components = bangChinhSua.getComponents();
//                        for (int i=0; i<components.length;i++) {
//                            if (components[i] instanceof JPanel) {
//                                JPanel tempPanel = (JPanel) components[i];
//                                Component[] smallComponents = tempPanel.getComponents();
//                                for (int j=0;j<smallComponents.length;j++) {
//                                    if(smallComponents[j] instanceof JTextField){
//                                        JTextField textField = (JTextField) smallComponents[j];
//                                        String text = textField.getText().trim(); // Lấy text từ textField và loại bỏ khoảng trắng đầu cuối
//                                        if (flag && j == 0) {
//                                            int maxSTT = bllQuanLyDanhSach.kiemTraMaThietBi();
//                                            textField.setText(String.format("TB%03d", maxSTT));
//                                            thongTinMoi.add(textField.getText());
//                                            flag = false;
//                                        }
//                                        else if(!textField.getText().equals("") && bllQuanLyDanhSach.kiemTraGiaThietBi(text)==-1 && j==0 && i==3){
//                                            JOptionPane.showMessageDialog(bangChinhSua, "Giá thiết bị phải là số và lớn hơn hoặc bằng 0", "Thông tin không hợp lệ", JOptionPane.WARNING_MESSAGE);
//                                            textField.requestFocus();
//                                            return; // Kết thúc sự kiện nếu có thông tin bị thiếu
//                                        }
//                                        else if (text.equals("")) {
//                                            JOptionPane.showMessageDialog(bangChinhSua, "Không được để trống thông tin!", "Thiếu thông tin", JOptionPane.WARNING_MESSAGE);
//                                            textField.requestFocus();
//                                            return; // Kết thúc sự kiện nếu có thông tin bị thiếu
//                                        } 
//                                        else {
//                                            thongTinMoi.add(text);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                         // Kiểm tra xem thongTinMoi có đủ 8 phần tử không trước khi thêm vào hvList
//                        if (thongTinMoi.size() >= 5) {
//                            tbList.addRow(thongTinMoi.toArray());
//                            LoaiThietBi tempTB = new LoaiThietBi(thongTinMoi.get(0),
//                                                        thongTinMoi.get(1),
//                                                        thongTinMoi.get(2),
//                                                        thongTinMoi.get(3),
//                                                        Integer.parseInt(thongTinMoi.get(4)));
//                            if(Integer.parseInt(thongTinMoi.get(4))>0){
//                                if(bllQuanLyDanhSach.themTB(tempTB)){
//                                    JOptionPane.showMessageDialog(bangChinhSua, "Thêm thành công!");
//                                }
//                                else{
//                                    JOptionPane.showMessageDialog(bangChinhSua, "Thêm không thành công!");
//                                    return;
//                                }
//                            }
//                            else{
//                                JOptionPane.showMessageDialog(bangChinhSua, "Ngày bảo hành phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                                tbList.removeRow(dataTable.getRowCount()-1);
//                                return;
//                            }
//                        }
//                        else {
//                            JOptionPane.showMessageDialog(bangChinhSua, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                            return;
//                        }
//                    }
//                    else if(tempBtn.getActionCommand().equals(cmtNut[1])){ //xóa thiết bị
//                        int i=dataTable.getSelectedRow();
//                        if(i>=0){
//                            Component[] components = bangChinhSua.getComponents();
//                            tbList.removeRow(i);
//                            for (Component component : components) {
//                                if (component instanceof JPanel) {
//                                    JPanel tempPanel = (JPanel) component;
//                                    Component[] smallComponents = tempPanel.getComponents();
//                                    for (Component smallComponent : smallComponents) {
//                                        if(smallComponent instanceof JTextField){
//                                            JTextField textField = (JTextField) smallComponent;
//                                            if(bllQuanLyDanhSach.xoaTB(textField.getText())){
//                                                textField.setText("");
//                                                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Xóa thiết bị", JOptionPane.INFORMATION_MESSAGE);
//                                                break;
//                                            }
//                                        }
//                                    }
//                                }
//                                break;
//                            }
//                            for (Component component : components) {
//                                if (component instanceof JPanel) {
//                                    JPanel tempPanel = (JPanel) component;
//                                    Component[] smallComponents = tempPanel.getComponents();
//                                    for (Component smallComponent : smallComponents) {
//                                        if(smallComponent instanceof JTextField){
//                                            JTextField textField = (JTextField) smallComponent;
//                                                textField.setText("");
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    else if(tempBtn.getActionCommand().equals(cmtNut[2])){ //sửa thông tin thiết bị
//                        int i= dataTable.getSelectedRow();
//                        if (i>=0){
//                        	String maGoc = tbList.getValueAt(i, 0).toString();
//                            ArrayList<String> thongTinMoi = new ArrayList<String>();
//                            Component[] components = bangChinhSua.getComponents();
//                            for (Component component : components) {
//                                if (component instanceof JPanel) {
//                                    JPanel tempPanel = (JPanel) component;
//                                    Component[] smallComponents = tempPanel.getComponents();
//                                    for (Component smallComponent : smallComponents) {
//                                        if (smallComponent instanceof JTextField) {
//                                            JTextField textField = (JTextField) smallComponent;
//                                            String text = textField.getText();
//                                            if(component == components[3]) {
//                                            	if(bllQuanLyDanhSach.kiemTraGiaThietBi(text)==-1){
//                                                    JOptionPane.showMessageDialog(null, "Giá thiết bị phải lớn hơn hoặc bằng 0", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
//                                                    return;
//                                                }
//                                            	else {
//                                            		thongTinMoi.add(text);                                            		
//                                            	}
//                                            }
//                                            else if(component == components[4]) {
//                                            	if(bllQuanLyDanhSach.kiemNgayBaoHanh(Integer.parseInt(text))==-1){
//                                                    JOptionPane.showMessageDialog(null, "Giá thiết bị phải lớn hơn hoặc bằng 0", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
//                                                    return;
//                                                }
//                                            	else {
//                                            		thongTinMoi.add(text);                                            		
//                                            	}
//                                            }
//                                            else {
//                                        		thongTinMoi.add(text);                                            		
//                                            }
//                                        
//                                        }
//                                    }
//                                }
//                            }
////                        	System.out.println(thongTinMoi);
//                        	if(!thongTinMoi.get(0).equals("") && thongTinMoi.get(0).equals(maGoc)) {
//                        		LoaiThietBi tempTB = new LoaiThietBi(thongTinMoi.get(0),
//                        				thongTinMoi.get(1),
//                        				thongTinMoi.get(2),
//                        				thongTinMoi.get(3),
//                        				Integer.parseInt((String)thongTinMoi.get(4)));
//                        		if(bllQuanLyDanhSach.suaThongTinTB(tempTB)){
//                        			JOptionPane.showMessageDialog(null, "Sửa thông tin thành công", "Sửa thông tin",JOptionPane.DEFAULT_OPTION);
//                        			for(int j=0; j<thongTinMoi.size(); j++){
//                        				tbList.setValueAt(thongTinMoi.get(j), i, j);
//                        			}
//                        			return;
//                        		}
//                        		else{
//                        			JOptionPane.showMessageDialog(null, "Sửa thông tin không thành công", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
//                        			return;
//                        		}                        		
//                        	}
//                        	else {
//                    			JOptionPane.showMessageDialog(null, "Không được sửa mã thiết bị", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
//                        	}
//                        }
//                        else {
//                            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 hàng để bắt đầu chỉnh sửa", "Sửa thông tin",JOptionPane.ERROR_MESSAGE);
//                            return;
//                        }
//                        
//                    }
//                    else if(tempBtn.getActionCommand().equals(cmtNut[3])){ //tìm kiếm thiết bị theo mã tron danh sách
//                    	ArrayList<String> thongTin = new ArrayList<String>();
//                        Component[] components = bangChinhSua.getComponents();
//                        for(Component component : components) {
//                            if(component instanceof JPanel){
//                                JPanel panel = (JPanel) component;
//                                Component[] smallComponents = panel.getComponents();
//                                for(Component smallComponent : smallComponents){
//                                    if(smallComponent instanceof JTextField){
//                                        JTextField textField = (JTextField) smallComponent;
//                                        if(textField.getText().equals("")){
//                                            thongTin.add("");                                                    
//                                        }
//                                        else if(!textField.isEditable() && component == components[0]){
//                                            textField.setEditable(true);
//                                            thongTin.add(textField.getText());
//                                        }
//                                        else{
//                                            thongTin.add(textField.getText());
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                        LoaiThietBi tempTB = new LoaiThietBi(thongTin.get(0),
//                                                    thongTin.get(1),
//                                                    "",
//                                                    "",
//                                                    0);
////                        System.out.println(bllQuanLyDanhSach.timKiem(tempTB).dsThietBi.size());
//                        if(bllQuanLyDanhSach.timKiem(tempTB).dsThietBi.size() != 0 && bllQuanLyDanhSach.timKiem(tempTB).dsThietBi.size() != dsTB.dsThietBi.size()){
//                            JOptionPane.showMessageDialog(bangChinhSua, "Tìm kiếm thành công","Tìm kiếm cơ sở", JOptionPane.INFORMATION_MESSAGE);
//                            DSLoaiThietBi dsTB2 = bllQuanLyDanhSach.timKiem(tempTB);
//                            tbList.setRowCount(0);
//                            
//                            for (int i = 0; i < dsTB2.dsThietBi.size(); i++) {
//                                tbList.addRow(new Object[]{dsTB2.dsThietBi.get(i).getMaThietBi().trim(),
//                                		dsTB2.dsThietBi.get(i).getTenLoaiThietBi().trim(),
//                                		dsTB2.dsThietBi.get(i).getHinhAnh().trim(),
//                                		dsTB2.dsThietBi.get(i).getGiaThietBi().trim(),
//                                		dsTB2.dsThietBi.get(i).getNgayBaoHanh()});
//                            }
//                        }
//                        else{
//                            JOptionPane.showMessageDialog(bangChinhSua, "Vui lòng nhập thêm hoặc kiểm tra lại thông tin để có được kết quả tìm kiếm chính xác","Tìm kiếm thiết bị", JOptionPane.ERROR_MESSAGE);
//                            tbList.setRowCount(0);
//                            for (int i = 0; i < dsTB.dsThietBi.size(); i++) {
//                                tbList.addRow(new Object[]{dsTB.dsThietBi.get(i).getMaThietBi(),
//                            		dsTB.dsThietBi.get(i).getTenLoaiThietBi().trim(),
//                            		dsTB.dsThietBi.get(i).getHinhAnh().trim(),
//                            		dsTB.dsThietBi.get(i).getGiaThietBi().trim(),
//                            		dsTB.dsThietBi.get(i).getNgayBaoHanh()});
//                            }
//                            
//                        }
//                    }
//                }
//                
//            });
//            a+=175;
//            rightPanel.add(tempBtn);
//        }
//        rightPanel.add(scrollPane);
//
//        //xử lý sự kiện cho bảng
//        dataTable.addMouseListener(new MouseListener() {
//            
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int i = dataTable.getSelectedRow();
//                if(i>=0){
//                    Component[] components = bangChinhSua.getComponents();
//                    int j=0;
//                    for(Component a : components){
//                        if(a instanceof JPanel){
//                            JPanel tempPanel = (JPanel) a;
//                            Component[] smallComponents = tempPanel.getComponents();
//                            for(Component b : smallComponents){
//                                if(b instanceof JTextField){
//                                    JTextField tempTF = (JTextField) b;
//                                    tempTF.setText(tbList.getValueAt(i, j).toString().trim());
//                                    j++;
//                                }
//                            }
//                        }
//                    }
//                    bangChinhSua.revalidate();
//                    bangChinhSua.repaint();
//                }
//            }
//            @Override
//            public void mousePressed(MouseEvent e) {
//                // TODO Auto-generated method stub
//            }
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                // TODO Auto-generated method stub
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                // TODO Auto-generated method stub
//            }
//            @Override
//            public void mouseExited(MouseEvent e) {
//                // TODO Auto-generated method stub
//            }
//            
//        });
//        renderer rd = new renderer();
//        dataTable.getColumnModel().getColumn(2).setCellRenderer(rd);
//        dataTable.setRowHeight(100);
//	}
//}
