package DAL;

import java.sql.*;
import java.util.ArrayList;
import DTO.dichVu;

public class DataDichVu {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public ArrayList<String> tenCot = new ArrayList<String>();
    
    public DataDichVu()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public ArrayList<String> getTenCot(){
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DichVu");
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
    public ArrayList<dichVu> layDanhSachDichVu()
    {
        ArrayList<dichVu> dsDichVu = new ArrayList<>();
        String truyVan = "SELECT * FROM DichVu";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            dsDichVu.add(new dichVu(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),rs.getString(5)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return dsDichVu;
    }
}
