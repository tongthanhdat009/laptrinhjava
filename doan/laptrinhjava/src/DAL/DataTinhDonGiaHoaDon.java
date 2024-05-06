package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DataTinhDonGiaHoaDon {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataTinhDonGiaHoaDon()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public int tinhDonGia(String maHoaDon)
    {
        int tong = 0;
        String truyVan = "SELECT (SoLuongHang * GiaNhap) AS TONG FROM ChiTietHoaDon, HangHoa WHERE MaHD = ? AND ChiTietHoaDon.MaHangHoa = HangHoa.MaHangHoa";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, maHoaDon);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            tong+=rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e);   
        }
        return tong;
    }
}
