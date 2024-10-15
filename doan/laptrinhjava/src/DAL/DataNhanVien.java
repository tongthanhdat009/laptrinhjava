package DAL;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import DTO.DTOQuyen;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;
import DTO.NhanVien;
import DTO.dsHoiVien;
import GUI.CONTROLLER.nhapHang;

public class DataNhanVien {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa";
    private String password= "123456";
    public ArrayList<String> tenCot = new ArrayList<String>();
	private Component GUIAdmin;

    public DataNhanVien() {
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> getTenCot() {
        String query = "SELECT * FROM NhanVien";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            ResultSetMetaData rsm = rs.getMetaData();
            for (int i = 1; i <= rsm.getColumnCount(); i++) {
                this.tenCot.add(rsm.getColumnName(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.tenCot;
    }

    public int layMaNhanVienChuaTonTai() {
        String ma;
        String query = "SELECT * FROM NhanVien";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int maxMa = 0;
            while (rs.next()) {
                ma = rs.getString("MaNV");
                ma = ma.substring(2);
                ma = ma.trim();
                if (Integer.parseInt(ma) > maxMa) {
                    maxMa = Integer.parseInt(ma);
                }
            }
            return maxMa + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public boolean them(NhanVien nhanvien) {
    	String check_manv = "SELECT * FROM NhanVien WHERE MaNV = ?";
        String query = "INSERT INTO NhanVien (MaNV, HoTenNV, GioiTinh, NgaySinh, SoDienThoai,SoCCCD, MaCoSo, VaiTro, Luong, IDTaiKhoan ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
        	PreparedStatement ps_check = con.prepareStatement(check_manv);
        	ps_check.setString(1, nhanvien.getMaNhanVien());
        	ResultSet rs = ps_check.executeQuery();
        	while(rs.next()) {
        		JOptionPane.showMessageDialog(GUIAdmin, "Mã nhân viên đã tồn tại","Error",JOptionPane.ERROR_MESSAGE);
        		return false;
        	}
        	
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nhanvien.getMaNhanVien());
            ps.setString(2, nhanvien.getHoten());
            ps.setString(3, nhanvien.getGioitinh());
            ps.setString(4, nhanvien.getNgaysinh());
            ps.setString(5, nhanvien.getSdt());
            ps.setString(6, nhanvien.getSocccd());
            ps.setString(7, nhanvien.getMacoso());
            ps.setString(8, nhanvien.getVaitro());
            ps.setDouble(9, nhanvien.getLuong());
            ps.setString(10, nhanvien.getIDTaiKhoan());
            int n = ps.executeUpdate();
            if (n != 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

//    public ArrayList<NhanVien> timkiemnhanvien(String manv) {
//        ArrayList<NhanVien> result = new ArrayList<>();
//        String query = "SELECT * FROM NhanVien WHERE MANV = ?";
//        if(manv.equals("")) {
//        	return result;
//        }
//        try {
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, manv);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				NhanVien nv = new NhanVien(
//						rs.getString("MaNV"),
//		                rs.getString("HoTenNV"),
//		                rs.getString("GioiTinh"),
//		                rs.getDate("NgaySinh"),
//		                rs.getString("SoDienThoai"),
//		                rs.getString("SoCCCD"),
//		                rs.getString("MaCoSo"),
//		                rs.getString("VaiTro"),
//		                rs.getString("IDTaiKhoan"),
//		                rs.getInt("Luong")
//						);
//				result.add(nv);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//        return result;
//    }

    public Map<String, ArrayList<?>> timkiemnhanvien(NhanVien nv,DTOTaiKhoan tk){
    	ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
    	ArrayList<DTOTaiKhoan> dsTK = new ArrayList<DTOTaiKhoan>();
    	ArrayList<String> dsQUYEN = new ArrayList<String>();
    	Map<String, ArrayList<?>> resultMap = new HashMap<>();
    	String truyVan = "SELECT DISTINCT * FROM NhanVien JOIN TaiKhoan ON NhanVien.IDTaiKhoan = TaiKhoan.IDTaiKhoan JOIN Quyen ON Quyen.IDQuyen = TaiKhoan.IDQuyen WHERE ";
    	if(!nv.getMaNhanVien().equals("")) {
    		String maNV = "MaNV LIKE '%"+nv.getMaNhanVien().trim()+"%' COLLATE SQL_Latin1_General_CP1_CI_AI AND ";
    		truyVan += maNV;
    	}
    	if(!nv.getHoten().trim().equals("")) {
    		String hoTen = "HoTenNV LIKE N'%"+nv.getHoten().trim()+"%' COLLATE SQL_Latin1_General_CP1_CI_AI AND ";
    		truyVan += hoTen;
    	}
    	if(!nv.getGioitinh().trim().equals("")) {
    		String gioiTinh = "GioiTinh = N'"+nv.getGioitinh().trim()+"' AND ";
    		truyVan += gioiTinh;
    	}
    	if(!nv.getNgaysinh().trim().equals("2024-1-1")) {
    		String ngaySinh = "NgaySinh = '"+nv.getNgaysinh().trim()+"' AND ";
    		truyVan +=ngaySinh;
    	}
    	if(!nv.getSdt().trim().equals("")) {
    		String sdt = "SoDienThoai LIKE '%"+nv.getSdt().trim()+"%' AND ";
    		truyVan +=sdt;
    	}
    	if(!nv.getSocccd().trim().equals("")) {
    		String socccd = "SoCCCD LIKE '%"+nv.getSocccd().trim()+"%' AND ";
    		truyVan += socccd;
    	}
    	if(!nv.getMacoso().trim().equals("Cơ sở")){
    		String taiKhoan = "MaCoSo LIKE '"+nv.getMacoso().trim()+"' AND ";
    		truyVan += taiKhoan;
    	}
    	if(!nv.getVaitro().trim().equals("Vai trò")) {
    		String matKhau = "VaiTro = N'"+nv.getVaitro().trim()+"' AND ";
    		truyVan += matKhau;
    	}
    	if(nv.getLuong()>0) {
    		String luong = "Luong = "+nv.getLuong()+" AND ";
    		truyVan += luong;
    	}
    	if(!tk.getTaiKhoan().trim().equals("")) {
    		String taiKhoan = "TaiKhoan LIKE '%"+tk.getTaiKhoan().trim()+"%' COLLATE SQL_Latin1_General_CP1_CI_AI AND ";
    		truyVan += taiKhoan;
    	}
    	if(!tk.getMatKhau().trim().equals("")) {
    		String matKhau = "MatKhau LIKE '%"+tk.getMatKhau().trim()+"%' COLLATE SQL_Latin1_General_CP1_CI_AI";
    		truyVan += matKhau;
    	}
    	if (truyVan.endsWith(" AND ")) {
    	    truyVan = truyVan.substring(0, truyVan.length() - 5); // Cắt 5 ký tự cuối (AND)
    	}
    	if (truyVan.endsWith(" WHERE ")) {
    		return null;
    	}
    	try {
    		PreparedStatement stmt = con.prepareStatement(truyVan);
    		ResultSet rs = stmt.executeQuery();
    		while (rs.next()) {
    			dsNV.add(new NhanVien(rs.getString("MaNV"),
    					rs.getString("HoTenNV"),
    					rs.getString("GioiTinh"),
    					rs.getDate("NgaySinh"),
    					rs.getString("SoDienThoai"),
    					rs.getString("SoCCCD"),
    					rs.getString("MaCoSo"),
    					rs.getString("VaiTro"),
    					rs.getString("IDTaiKhoan"),
    					rs.getInt("Luong")));
                
                DTOTaiKhoan tKhoan = new DTOTaiKhoan(rs.getString("IDTaiKhoan"),
                					rs.getString("TaiKhoan"),
                					rs.getString("MatKhau"),
                					rs.getString("IDQuyen"),
                					rs.getString("Status"));
				dsTK.add(tKhoan);
				
				dsQUYEN.add(rs.getString("TenQuyen"));
    		}
    	}
    	catch (Exception e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
    	System.out.println(truyVan);
    	resultMap.put("NhanVien", dsNV);
    	resultMap.put("TaiKhoan", dsTK);
    	resultMap.put("TenQuyen", dsQUYEN);
    	return resultMap;
    }
    
    public boolean xoanv(String manv) {
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(manv);
        String query = "DELETE FROM NhanVien WHERE MaNV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, manv);
            int check = ps.executeUpdate();
            if (check > 0)
                return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean suanv(NhanVien nhanvien) {
        String query = "UPDATE NhanVien SET HoTenNV = ?, GioiTinh = ?,NgaySinh = ?,SoDienThoai = ?,SoCCCD = ?,MaCoSo = ?,VaiTro = ?,Luong = ? WHERE MaNV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nhanvien.getHoten());
            ps.setString(2, nhanvien.getGioitinh());
            ps.setString(3, nhanvien.getNgaysinh());
            ps.setString(4, nhanvien.getSdt());
            ps.setString(5, nhanvien.getSocccd());
            ps.setString(6, nhanvien.getMacoso());
            ps.setString(7, nhanvien.getVaitro());
            ps.setDouble(8, nhanvien.getLuong());
            ps.setString(9, nhanvien.getMaNhanVien());
            int check = ps.executeUpdate();
            if (check > 0)
                return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<NhanVien> layDanhSachNhanVien() {
        ArrayList<NhanVien> ds = new ArrayList<>();
        String query = "SELECT * FROM NhanVien";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ds.add(new NhanVien(rs.getString("MaNV"), rs.getString("HoTenNV"), rs.getString("GioiTinh"), rs.getDate("NgaySinh"), rs.getString("SoDienThoai"), rs.getString("SoCCCD"), rs.getString("MaCoSo"), rs.getString("VaiTro"), rs.getString("IDTaiKhoan"), rs.getInt("Luong")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }

    private boolean kiemTraTonTaiMaNV(String maNV) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS Count FROM NhanVien WHERE MaNV = ?");
            ps.setString(1, maNV);
            ResultSet rsExist = ps.executeQuery();
            if (rsExist.next()) {
                int count = rsExist.getInt("Count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String taoMaNhanVienMoi() {
        try {
            // Tìm mã hội viên lớn nhất
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(MaNV) AS MaxMaNV FROM NhanVien");

            // Lấy mã lớn nhất
            String maxMaNV = "NV001";
            if (rs.next()) {
                String maxMaNVFromDB = rs.getString("MaxMaNV");
                if (maxMaNVFromDB != null) {
                    int nextMaHV = Integer.parseInt(maxMaNVFromDB.substring(2)) + 1;
                    String newMaNV;
                    boolean flag = false;
                    while (!flag) {
                    	newMaNV = String.format("NV%03d", nextMaHV);
                        // Kiểm tra xem mã mới có duy nhất không
                        if (!kiemTraTonTaiMaNV(newMaNV)) {
                        	maxMaNV = newMaNV;
                        	flag = true;
                        }
                        nextMaHV++;
                    }
                }
            }
            return maxMaNV; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public String getTenNhanVien(String maNV) {
        String tenNV = null;
        try {
            // Tạo câu lệnh SQL để lấy tên nhân viên từ mã nhân viên
            String query = "SELECT HoTenNV FROM NhanVien WHERE MaNV = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, maNV);
    
            // Thực hiện truy vấn
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tenNV = rs.getString("HoTenNV");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenNV;
    }
}
