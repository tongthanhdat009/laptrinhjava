package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataPhanQuyen {
	private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public ArrayList<String> layDSPhanQuyenNV() {
		ArrayList<String> ds = new ArrayList<String>();
        String query = "SELECT DISTINCT q.TenQuyen From PhanQuyen pq, Quyen q, ChucNang cn WHERE pq.IDQuyen = q.IDQuyen AND pq.IDChucNang = cn.IDChucNang";
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
	
}
