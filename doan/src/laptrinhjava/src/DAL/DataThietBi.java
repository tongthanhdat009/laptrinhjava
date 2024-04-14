//Chưa test
package DAL;

import java.sql.*;

import DTO.DSLoaiThietBi;
import DTO.LoaiThietBi;
public class DataThietBi {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataThietBi()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
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
}
