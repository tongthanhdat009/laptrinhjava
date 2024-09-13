package GUI.CONTROLLER;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;

import BLL.BLLQuanLyDanhSach;
import DTO.ChiTietHoaDon;
import DTO.DSCoSo;
import DTO.DSLoaiThietBi;
import DTO.HoaDon;
import DTO.HoiVien;
import DTO.HoiVienCoSo;
import DTO.ThietBiCoSo;
import DTO.dichVu;
import DTO.dsHangHoa;
import DTO.hangHoaCoSo;

public class xuLyDSCTR {
	private final int width = 1600;
    private final int height = 900;
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
    @SuppressWarnings("unchecked")
    public void xuLyDanhSach(JPanel rightPanel){
        rightPanel.setLayout(null);
        //giới thiệu chức năng xử lý danh sách
        JLabel param = new JLabel("<html>Giới thiệu chức năng quản lý danh sách <br> Bao gồm các tác vụ thêm, xóa, sửa thông tin các danh sách: <br>- Cơ sở <br>- Dịch vụ<br>- Hội viên<br>- Nhân viên<br>- Thiết bị<br>- Thiết bị cơ sở <br>- Hóa đơn <br>- Chi tiết hóa đơn <br>- Hàng hóa <br>- Hội viên cơ sở <br>- Hàng hóa cơ sở <br>Chọn danh sách để bắt đầu thao tác</html>"); 

        param.setFont(new Font("Times New Roman",1,30));
        JPanel textPN = new JPanel();
        textPN.setBounds(100,150,(int)(width*70/100 - 100), height-300);
        textPN.setBackground(new Color(119, 230, 163));
        textPN.add(param);
        rightPanel.add(textPN);
        //tiêu đề bên phải 
        JLabel rightTitle = new JLabel("Quản lý danh sách");
        rightTitle.setFont(new Font("Times New Roman", 1, 35));
        rightTitle.setBounds(450, 0, 1000,60);        
        
        //Chọn bảng cần quản lý
        String[] tenDanhSach = {"Cơ sở", "Dịch vụ", "Hội viên cơ sở", "Thiết bị", "Thiết bị cơ sở", "Hóa đơn","Chi tiết hóa đơn","Hàng hóa","Hàng hóa cơ sở"};
        @SuppressWarnings("rawtypes")
        JComboBox danhSachBox = new JComboBox<String>(tenDanhSach);
        danhSachBox.setBounds(680,50,130,30);
        JLabel chonDanhSachLabel = new JLabel("Chọn danh sách: ");
        chonDanhSachLabel.setFont(new Font("Times New Roman", 1, 30));
        chonDanhSachLabel.setBounds(430, 50, 300,35);
        danhSachBox.setRenderer(renderer);
        danhSachBox.setBackground(Color.white);
        danhSachBox.addActionListener(new ActionListener() {
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

                ArrayList<String> tenCotCS = new ArrayList<String>();
                tenCotCS.add("Mã cơ sở");
                tenCotCS.add("Tên cơ sở");
                tenCotCS.add("Địa chỉ");
                tenCotCS.add("Thời gian hoạt động");
                tenCotCS.add("Số điện thoại");
                tenCotCS.add("Doanh thu");
                DSCoSo dsCS =  bllQuanLyDanhSach.layDsCoSo();

                DSLoaiThietBi dsTB = bllQuanLyDanhSach.layDSLoaiThietBi();
                ArrayList<String> tenCotTB = new ArrayList<String>();
                tenCotTB.add("Mã thiết bị");
                tenCotTB.add("Tên loại thiết bị");
                tenCotTB.add("Hình ảnh");
                tenCotTB.add("Giá thiết bị");
                tenCotTB.add("Ngày bảo hành");
                
                dsHangHoa dsHH = bllQuanLyDanhSach.layDsHangHoa();
                ArrayList<String> tenCotHH = new ArrayList<String>();
                tenCotHH.add("Mã hàng hóa");
                tenCotHH.add("Loại hàng hóa");
                tenCotHH.add("Tên loại hàng hóa");
                tenCotHH.add("Hình ảnh");
                tenCotHH.add("Giá nhập");

                if (selectedOption.equals("Cơ sở")) {
                	coSoCTR csCTR = new coSoCTR(rightPanel,tenCotCS,dsCS,bangChinhSua,dataTable,scrollPane,bllQuanLyDanhSach);
                	csCTR.update();
                }
                else if(selectedOption.equals("Dịch vụ")){
                    ArrayList<dichVu> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.getDataDichvu();
                    QuanLyBangDichVuCTR qlbdvCTR = new QuanLyBangDichVuCTR();
                    qlbdvCTR.QuanLyBangDichVu(ds, rightPanel);
                }
                else if (selectedOption.equals("Hội viên cơ sở")) {
            		bllQuanLyDanhSach = new BLLQuanLyDanhSach();
            		ArrayList<HoiVienCoSo> ds = new ArrayList<>();
                    Vector<String> dsCoSo = new Vector<>();
                    dsCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    ds = bllQuanLyDanhSach.layDSHoiVienCoSo();
                    QuanLyHoiVienCoSoCTR qlhvcsCTR = new QuanLyHoiVienCoSoCTR();
                    qlhvcsCTR.QuanLyHoiVienCoSo(ds,dsCoSo,rightPanel);
              
                }
//                else if (selectedOption.equals("Nhân viên")){
//                    ArrayList<NhanVien> ds = new ArrayList<>();
//                    ds = bllQuanLyDanhSach.getDataNhanVien();
//                    QuanLyBangNhanVienCTR qlbnvCTR = new QuanLyBangNhanVienCTR();
//                    qlbnvCTR.QuanLyBangNhanVien(ds, rightPanel, chonDanhSachLabel);
//                }
                else if(selectedOption.equals("Thiết bị")){
                    thietBiCTR tbCTR = new thietBiCTR(rightPanel, tenCotTB, dsTB, bangChinhSua, dataTable, scrollPane, bllQuanLyDanhSach);
                    tbCTR.update();
                }
                else if(selectedOption.equals("Thiết bị cơ sở")){
                    ArrayList<ThietBiCoSo> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDanhSachThietBiCoSo();
                    QuanLyBangThietBiCoSoCTR qlbtbcsCTR = new QuanLyBangThietBiCoSoCTR();
                    qlbtbcsCTR.QuanLyBangThietBiCoSo(ds,rightPanel);
                }
                else if(selectedOption.equals("Hóa đơn")){
                    ArrayList<HoaDon> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSHoaDon();
                    Vector<String> dsCoSo = new Vector<>();
                    dsCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    hoaDonCTR hdCTR = new hoaDonCTR();
                    hdCTR.QuanLyHoaDon(ds, dsCoSo, rightPanel);
                }
                else if(selectedOption.equals("Chi tiết hóa đơn")){
                    ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSChiTietHoaDon();
                    chiTietHDCTR cthdCTR = new chiTietHDCTR();
                    cthdCTR.QuanLyChiTietHoaDon(ds,rightPanel);
                }
                else if(selectedOption.equals("Hàng hóa cơ sở")){
                    ArrayList<hangHoaCoSo> ds = new ArrayList<>();
                    ds = bllQuanLyDanhSach.layDSHangHoaCoSo();
                    Vector<String> dsMaCoSo = new Vector<>();
                    dsMaCoSo = bllQuanLyDanhSach.layDSMaCoSo();
                    hangHoaCSCTR hhcsCTR = new hangHoaCSCTR();
                    hhcsCTR.QuanLyHangHoaCoSo(ds,dsMaCoSo,rightPanel);
                }
//                else if(selectedOption.equals("Hội viên cơ sở")){
//                    ArrayList<HoiVienCoSo> ds = new ArrayList<>();
//                    Vector<String> dsCoSo = new Vector<>();
//                    dsCoSo = bllQuanLyDanhSach.layDSMaCoSo();
//                    ds = bllQuanLyDanhSach.layDSHoiVienCoSo();
//                    QuanLyHoiVienCoSoCTR qlhvcsCTR = new QuanLyHoiVienCoSoCTR();
//                    qlhvcsCTR.QuanLyHoiVienCoSo(ds,dsCoSo,rightPanel);
//                }
                else if(selectedOption.equals("Hàng hóa")){
                	hangHoaCTR hhCTR = new hangHoaCTR(rightPanel, tenCotHH, dsHH, bangChinhSua, dataTable, scrollPane, bllQuanLyDanhSach);
                	hhCTR.update();
                }
            }
           
        });
        rightPanel.add(rightTitle);
        rightPanel.add(chonDanhSachLabel);
        rightPanel.add(danhSachBox);
    }
}
