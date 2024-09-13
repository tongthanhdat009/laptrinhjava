package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTOQuyen;

public class DataQuyen {
	private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
	public ArrayList<DTOQuyen> layQuyenNV() {
		ArrayList<DTOQuyen> ds = new ArrayList<DTOQuyen>();
        String query = "  SELECT Q.IDQuyen, TenQuyen From TaiKhoan tk, Quyen Q, NhanVien nv WHERE nv.IDTaiKhoan = tk.IDTaiKhoan and tk.IDQuyen = Q.IDQuyen ";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(new DTOQuyen(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
	public ArrayList<String> layDSTenQuyenNV() {
		ArrayList<String> ds = new ArrayList<String>();
        String query = "  SELECT DISTINCT TenQuyen From TaiKhoan tk, Quyen Q, NhanVien nv WHERE nv.IDTaiKhoan = tk.IDTaiKhoan and tk.IDQuyen = Q.IDQuyen ";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
	public boolean ganLaiQuyenTK(String maTK, String IDQuyen) {
		String query = "UPDATE TaiKhoan SET IDQuyen = ? WHERE IDTaiKhoan = ?";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, IDQuyen);
            ps.setString(2, maTK);
            int check = ps.executeUpdate();
            if (check > 0)
                return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
	}
}
	
