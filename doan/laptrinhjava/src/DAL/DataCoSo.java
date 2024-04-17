package DAL;

import java.sql.*;

import DTO.CoSo;
import DTO.DSCoSo;
public class DataCoSo {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataCoSo()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public DSCoSo layDSCoSo()
    {
        String truyVan = "SELECT * FROM CoSo";
        DSCoSo ds = new DSCoSo();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            {
                CoSo coSo = new CoSo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
                ds.them(coSo);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
}
