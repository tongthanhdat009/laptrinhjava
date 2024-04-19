package DAL;
import java.sql.*;
import java.util.ArrayList;

import DTO.ChiTietHoaDon;
public class DataHoaDonChiTiet {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataHoaDonChiTiet()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public ArrayList<ChiTietHoaDon> layDSHoaDon()
    {
        ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM ChiTietHoaDon";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next()) ds.add(new ChiTietHoaDon(rs.getInt(1), rs.getString(2), rs.getString(3)));
        } catch (Exception e) {
            System.out.println(e);   
        }
        return ds;
    }
}
