package GUI.CONTROLLER;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.css.Counter;

import BLL.BLLQuanLyDanhSach;
import BLL.BLLXuatFileExcel;
import DTO.DTOQuyen;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;
import DTO.NhanVien;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
public class XuatExcelCTR extends JPanel{
	private JTextField fileNameTF;
	private JTextField firstSheetNameTF;
	private JTextField chosenPathTF;
    private Font italicBoldFont = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 30); //vừa nghiêng vừa in đậm

    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel hvList = new DefaultTableModel();
    private ArrayList<String> tenCotHV = new ArrayList<String>();

    
	ListCellRenderer<? super String> renderer = new DefaultListCellRenderer() {
		private static final long serialVersionUID = 1L;

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
		public XuatExcelCTR() {
			setBackground(new Color(241, 255, 250));
			this.setSize(1200,900);
			this.setLayout(null);
			
			JLabel title = new JLabel("Xuất file danh sách");
			title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
			title.setBounds(416, 0, 428, 78);
			add(title);
			
			JPanel fileInforPN = new JPanel();
			fileInforPN.setBounds(0, 68, 1200, 175);
			add(fileInforPN);
			fileInforPN.setLayout(null);
			
			fileNameTF = new JTextField();
			fileNameTF.setBounds(233, 59, 150, 30);
			fileInforPN.add(fileNameTF);
			fileNameTF.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Thông tin lưu file");
			lblNewLabel.setBounds(461, 0, 292, 47);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
			fileInforPN.add(lblNewLabel);
			
			JLabel fileNameLB = new JLabel("Tên file:");
			fileNameLB.setLabelFor(fileNameTF);
			fileNameLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
			fileNameLB.setBounds(143, 55, 80, 30);
			fileInforPN.add(fileNameLB);
			
			firstSheetNameTF = new JTextField();
			firstSheetNameTF.setBounds(233, 111, 150, 30);
			fileInforPN.add(firstSheetNameTF);
			firstSheetNameTF.setColumns(10);
			
			JLabel firstSheetNameLB = new JLabel("Tên sheet đầu tiên:");
			firstSheetNameLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
			firstSheetNameLB.setLabelFor(firstSheetNameTF);
			firstSheetNameLB.setBounds(35, 108, 188, 29);
			fileInforPN.add(firstSheetNameLB);
			
			JLabel pathNameLB = new JLabel("Đường dẫn đã chọn:");
			pathNameLB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
			pathNameLB.setBounds(471, 53, 202, 30);
			fileInforPN.add(pathNameLB);
			
			JPanel dataPanel = new JPanel();
			dataPanel.setBounds(0, 250, 1200, 650);
			add(dataPanel);
			dataPanel.setLayout(null);
			
			JButton acceptBTN = new JButton("Xác nhận");
			acceptBTN.setBounds(1015, 101, 130, 50);
			fileInforPN.add(acceptBTN);
			
			@SuppressWarnings("rawtypes")
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Times New Roman", Font.BOLD, 25));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Danh sách", "Hội viên", "Nhân viên"}));
			comboBox.setBounds(471, 108, 202, 33);
			comboBox.setBackground(Color.white);
			comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> comboBox = (JComboBox<String>) e.getSource(); // Lấy ra JComboBox đã được kích hoạt
	                String selectedOption = (String) comboBox.getSelectedItem(); // Lấy ra mục đã chọn trong JComboBox
	                JTable dataTable = new JTable();
	                JScrollPane scrollPane = new JScrollPane();
	                
	                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
	                
	                
	                ArrayList<HoiVien> dsHV = bllQuanLyDanhSach.getDataHoiVien();
	                tenCotHV.add("Mã hội viên");
	                tenCotHV.add("Họ tên hội viên");
	                tenCotHV.add("Giới tính");
	                tenCotHV.add("Gmail");
	                tenCotHV.add("Mã Tài khoản");
	                tenCotHV.add("Số điện thoại");
	                tenCotHV.add("Ngày sinh");
	                tenCotHV.add("Tài khoản");
	                tenCotHV.add("Mật khẩu");
	                
	                switch (selectedOption) {
	                case "Hội viên":
	                	dataPanel.removeAll();
	                	dataPanel.revalidate();
	                    dataPanel.repaint();
	                	// lấy danh sách mã tài khoản
	            		ArrayList<DTOTaiKhoan> dsTK = bllQuanLyDanhSach.layDSTKHV(); 
	            		
	                    // tạo model bảng
	                    for (int i = 0; i < tenCotHV.size(); i++) {
	                        hvList.addColumn(tenCotHV.get(i));
	                    }
	                    System.out.println(dsTK.size() +" "+dsHV.size() );
	                    // Thêm dữ liệu vào bảng
	                    for (int i = 0; i < dsHV.size(); i++) {
	                        hvList.addRow(new Object[]{dsHV.get(i).getMaHoiVien(),
	                            dsHV.get(i).getHoten().trim(),
	                            dsHV.get(i).getGioitinh().trim(),
	                            dsHV.get(i).getMail().trim(),
	                            dsTK.get(i).getIDTaiKhoan().trim(),
	                            dsHV.get(i).getSdt().trim(),
	                            dsHV.get(i).getNgaysinh().trim(),
	                            dsTK.get(i).getTaiKhoan().trim(),
	                            dsTK.get(i).getMatKhau().trim(),
	                            });
	                    }
	                    
	                    dataTable = new JTable(hvList);
	                    dataTable.getTableHeader().setReorderingAllowed(false);
	                    dataTable.setFont(new Font("Times New Roman", 1, 15));
	                    dataTable.setRowHeight(20);
	                    scrollPane = new JScrollPane(dataTable);
	                    scrollPane.setBounds(3, 0, 1200-20, 900-250);
	                    dataPanel.add(scrollPane);
	                    
	                    //sự kiện cho nút xác nhận
	                	break;
	                case "Nhân viên":
	                	dataPanel.removeAll();
	                	dataPanel.revalidate();
	                    dataPanel.repaint();
		        		ArrayList<NhanVien> dsNV = new ArrayList<>();
		        		ArrayList<DTOQuyen> dsQuyen = bllQuanLyDanhSach.layDSQuyenNV();
		                dsNV = bllQuanLyDanhSach.getDataNhanVien();
		                ArrayList<DTOTaiKhoan>dsTKNV = bllQuanLyDanhSach.layDSTKNV();
	                	DefaultTableModel model = new DefaultTableModel();
	                    JTable bang = new JTable();
	                    bang.setRowHeight(30);
	                    model.addColumn("Mã nhân viên");
	                    model.addColumn("Họ và tên");
	                    model.addColumn("Giới tính");
	                    model.addColumn("Ngày sinh");
	                    model.addColumn("Số điện thoại");
	                    model.addColumn("Số căn cước");
	                    model.addColumn("Mã cơ sở");
	                    model.addColumn("Vai trò");
	                    model.addColumn("Lương");
	                    model.addColumn("Tài khoản");
	                    model.addColumn("Mật khẩu");
	                    model.addColumn("ID Tài Khoản");
	                    
	                    model.setRowCount(0);
	                    System.out.println(dsNV.size() +" "+ dsQuyen.size());
	                    
	                    for(int i = 0; i < dsNV.size();i++) {
	                    	model.addRow(new Object[] {
	                			dsNV.get(i).getMaNhanVien(),dsNV.get(i).getHoten().trim(),dsNV.get(i).getGioitinh(),dsNV.get(i).getNgaysinh(),
	                			dsNV.get(i).getSdt(),dsNV.get(i).getSocccd(),dsNV.get(i).getMacoso(),dsQuyen.get(i).getTenQuyen().trim(),
	                			dsNV.get(i).getLuong(),dsTKNV.get(i).getTaiKhoan().trim(), dsTKNV.get(i).getMatKhau().trim(),dsNV.get(i).getIDTaiKhoan()
	                    	});
	                    }
	                    bang.setModel(model);
	                    bang.getTableHeader().setReorderingAllowed(false);
	                    bang.setFont(new Font("Times New Roman", 1, 15));
	                    bang.setRowHeight(20);
	                    JScrollPane scrollPane1 = new JScrollPane(bang);
	                    scrollPane1.setBounds(3, 0, 1200-20, 900-250);
	                    dataPanel.add(scrollPane1);
	                    
	                default:
	                	break;
	                }
				}
			});
			
			
			
			fileInforPN.add(comboBox);
			
			JButton chooseFileBTN = new JButton("Chọn file:");
			chooseFileBTN.setBounds(1015, 39, 130, 50);
			chooseFileBTN.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Tạo JFileChooser
					JFileChooser fileChooser = new JFileChooser();

			        // Chỉ cho phép chọn thư mục
			        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			        // Hiển thị hộp thoại chọn đường dẫn
			        int result = fileChooser.showOpenDialog(fileInforPN);

			        // Kiểm tra nếu người dùng chọn thư mục
			        if (result == JFileChooser.APPROVE_OPTION) {
			            // Lấy đường dẫn của thư mục được chọn
			            File selectedDirectory = fileChooser.getSelectedFile();
			            chosenPathTF.setText(selectedDirectory.toString());
			            
			        } else {
			            System.out.println("Không có thư mục nào được chọn");
			        }					
				}
			});
			fileInforPN.add(chooseFileBTN);
			
			//sự kiện cho nút xác nhận
            acceptBTN.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ArrayList<String> thongTinMoi = new ArrayList<String>();
					BLLXuatFileExcel bllXuatFileExcel = new BLLXuatFileExcel();
					if(firstSheetNameTF.getText().equals("") || chosenPathTF.getText().equals("") || comboBox.getSelectedItem().equals("Danh sách")) {
                    	JOptionPane.showMessageDialog(null, "Thiếu thông tin vui lòng nhập đầy đủ thông tin!","Error",JOptionPane.ERROR_MESSAGE);
                    	return;
					}
					else {						
						if(bllXuatFileExcel.kiemTraTenFile(fileNameTF.getText().trim()) && bllXuatFileExcel.kiemTraSheetName(firstSheetNameTF.getText().trim())) {
							int counter = 0;
							String fileExtension = ".xlsx";
							File file = new File(chosenPathTF.getText().trim() + fileNameTF.getText().trim() + fileExtension);
							while (file.exists()) {
								file = new File(chosenPathTF.getText().trim()  + fileNameTF.getText().trim() + "(" + counter + ")" + fileExtension);
							    counter++;
							}
							if(comboBox.getSelectedItem().equals("Hội viên")) {
								exportToExcel(model, chosenPathTF.getText().trim());
						        JOptionPane.showMessageDialog(null, "Xuất file Excel thành công!");
							}
							else if(comboBox.getSelectedItem().equals("Nhân viên")) {
								exportToExcel(model, chosenPathTF.getText().trim());
						        JOptionPane.showMessageDialog(null, "Xuất file Excel thành công!");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Tên tập tin hoặc tên sheet không hợp lệ!","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
			});
			
			chosenPathTF = new JTextField();
			pathNameLB.setLabelFor(chosenPathTF);
			chosenPathTF.setEditable(false);
			chosenPathTF.setBounds(682, 55, 309, 30);
			fileInforPN.add(chosenPathTF);
			chosenPathTF.setColumns(10);
		}
		
		public void exportToExcel(TableModel model, String filePath) {
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Sheet1");

	        // Ghi header của bảng
	        Row headerRow = sheet.createRow(0);
	        for (int i = 0; i < model.getColumnCount(); i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(model.getColumnName(i));
	        }

	        // Ghi dữ liệu của bảng
	        for (int i = 0; i < model.getRowCount(); i++) {
	            Row row = sheet.createRow(i + 1);
	            for (int j = 0; j < model.getColumnCount(); j++) {
	                Cell cell = row.createCell(j);
	                Object value = model.getValueAt(i, j);
	                if (value != null) {
	                    cell.setCellValue(value.toString());
	                }
	            }
	        }

	        // Ghi file ra đường dẫn đã chọn
	        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
	            workbook.write(fileOut);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Đóng workbook
	        try {
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
