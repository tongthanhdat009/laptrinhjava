package DAL;
import java.sql.*;


import DTO.DSHoaDon;
import DTO.HoaDon;
public class DataHoaDon {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataHoaDon()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public DSHoaDon layDSHoaDon()
    {
        String truyVan = "SELECT * FROM HoaDon";
        DSHoaDon ds = new DSHoaDon();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            ds.them(new HoaDon(rs.getString(1),rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
}
