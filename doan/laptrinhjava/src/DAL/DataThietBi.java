//Chưa test
package DAL;

import java.sql.*;
import java.util.ArrayList;

import DTO.DSLoaiThietBi;
import DTO.LoaiThietBi;
public class DataThietBi {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    ArrayList<String> tenCot = new ArrayList<String>();
    public DataThietBi()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> layTenCotThietBi (){
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LoaiThietBi");
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i=1; i<=rsmd.getColumnCount();i++){
                this.tenCot.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this.tenCot; 
    }

    public DSLoaiThietBi layDanhSach()
    {
        DSLoaiThietBi a = new DSLoaiThietBi();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            String truyVan = "SELECT * FROM LoaiThietBi";
            PreparedStatement stmt = con.prepareStatement(truyVan);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                LoaiThietBi thietBi = new LoaiThietBi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                a.them(thietBi);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }
    // public int laySoLuong()
    // {
    //     try {
    //         con = DriverManager.getConnection(dbUrl, userName, password);
    //         Statement stmt = con.createStatement();
    //         ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS SL FROM LoaiThietBi");
    //         if(rs.next()) return rs.getInt("SL");
    //     }
    //     catch(Exception e){
    //         System.out.println(e);
    //     }
    //     return 0;
    // }
    public DSLoaiThietBi timKiem(String ten)
    {
        String truyVan = "SELECT * FROM LoaiThietBi WHERE TenLoaiThietBi = ?";
        DSLoaiThietBi ds = new DSLoaiThietBi();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                LoaiThietBi thietBi = new LoaiThietBi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                ds.them(thietBi);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
}
