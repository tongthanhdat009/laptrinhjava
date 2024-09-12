package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTOQuyen;
import DTO.DTOTaiKhoan;

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
}
	
