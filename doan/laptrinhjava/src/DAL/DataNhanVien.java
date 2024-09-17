package DAL;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTOTaiKhoan;
import DTO.NhanVien;

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

    public ArrayList<NhanVien> timkiemnhanvien(NhanVien a){
    	ArrayList<String> ds = new ArrayList<String>();
        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        String truyVan = "SELECT nv.MaNV, nv.HoTenNV, nv.GioiTinh, nv.NgaySinh, nv.SoDienThoai, nv.SoCCCD, nv.MaCoSo, q.TenQuyen, nv.Luong, nv.IDTaiKhoan\r\n"
        		+ "FROM  NhanVien nv,\r\n"
        		+ "	TaiKhoan tk,\r\n"
        		+ "	Quyen q\r\n"
        		+ "	Where nv.IDTaiKhoan = tk.IDTaiKhoan\r\n"
        		+ "		And tk.IDQuyen = q.IDQuyen AND ";
        if(!a.getMaNhanVien().equals(""))
        {
            truyVan+= "nv.MaNV = ? AND ";
            ds.add(a.getMaNhanVien());
        } 
        if(!a.getGioitinh().equals(""))
        {
            truyVan+="nv.GioiTinh = ? AND ";
            ds.add(a.getGioitinh());
        } 
        if(!a.getSdt().equals(""))
        {
            truyVan+="nv.SoDienThoai = ? AND ";
            ds.add(a.getSdt());
        }
        if(!a.getVaitro().equals("Vai Trò")) {
        	truyVan+="q.TenQuyen = ? AND ";
        	ds.add(a.getVaitro());
        }
        if(!a.getMacoso().equals("Cơ Sở")) {
        	truyVan+="nv.MaCoSo = ? AND ";
        	ds.add(a.getMacoso());
        }
        
        truyVan = truyVan.trim();
        if (truyVan.endsWith("AND")) {
            // Xóa "AND" cuối cùng bằng cách cắt chuỗi từ đầu đến vị trí cuối cùng của "AND"
            truyVan = truyVan.substring(0, truyVan.lastIndexOf("AND")).trim();
        }
        try
        {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            for(int i=0;i<ds.size();i++)
                statement.setString(i+1, ds.get(i));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                dsNV.add(new NhanVien(rs.getString("MaNV"), rs.getString("HoTenNV"), rs.getString("GioiTinh"), rs.getDate("NgaySinh"), rs.getString("SoDienThoai"), rs.getString("SoCCCD"), rs.getString("MaCoSo"), rs.getString("TenQuyen"), rs.getString("IDTaiKhoan"), rs.getInt("Luong")));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return dsNV;
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
	
}
