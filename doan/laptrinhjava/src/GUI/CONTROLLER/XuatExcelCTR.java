package GUI.CONTROLLER;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BLL.BLLQuanLyDanhSach;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
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
	                JPanel bangChinhSua = new JPanel();
	                
	                BLLQuanLyDanhSach bllQuanLyDanhSach = new BLLQuanLyDanhSach();
	                
	                
	                ArrayList<String> tenCotHV = new ArrayList<String>();
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
	                	// lấy danh sách mã tài khoản
	            		ArrayList<DTOTaiKhoan> dsTK = bllQuanLyDanhSach.layDSTKHV(); 
	            		
	                    // tạo model bảng
	                    DefaultTableModel hvList = new DefaultTableModel();
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
	                    scrollPane.setBounds(5,255,1200-20,610);
	                    add(scrollPane);
	                    revalidate();
	                    repaint();
	                	break;
	                	
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
			
			JButton acceptBTN = new JButton("Xác nhận");
			acceptBTN.setBounds(1015, 101, 130, 50);
			fileInforPN.add(acceptBTN);
			
			chosenPathTF = new JTextField();
			pathNameLB.setLabelFor(chosenPathTF);
			chosenPathTF.setEditable(false);
			chosenPathTF.setBounds(682, 55, 309, 30);
			fileInforPN.add(chosenPathTF);
			chosenPathTF.setColumns(10);
		}
}
