//Chưa test
package DAL;

import java.sql.*;
import java.time.LocalDate;
public class DataThietBiCoSo {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataThietBiCoSo()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public int layMaThietBiCuoi()
    {
        String ma;
        String truyVan = "SELECT TOP 1 FORM ThietBiOMotCoSo";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            if(rs.last()) 
            {
                ma = rs.getString("MaThietBiCoSo");
                ma = ma.substring(2);
                return Integer.parseInt(ma);
            }
            else return 1;

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public int nhapThietBi(String maLoaiThietBi,String maCoSo, int soLuong, int soNgayBaoHanh)
    {

        //soNgayBaoHanh từ bảng LoaiThietBi
        int maChuaCo = layMaThietBiCuoi() + 1;
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            String truyVan = "INSERT INTO ThietBiOMotCoSo (MaThietBiOCoSo, MaCoSo, MaThietBi, NgayNhap, HanBaoHanh) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt;
            stmt = con.prepareStatement(truyVan);
            for(int i=0;i<soLuong;i++)
            {
                stmt.setString(1, "TB"+maChuaCo);  
                stmt.setString(2, maCoSo);
                stmt.setString(3, maLoaiThietBi);
                LocalDate ngayHetHan = LocalDate.now();
                stmt.setDate(4, java.sql.Date.valueOf(ngayHetHan));
                stmt.setDate(5, java.sql.Date.valueOf(ngayHetHan.plusDays(soNgayBaoHanh)));
                maChuaCo++;
            }  
            if(stmt.executeUpdate()>0) return 1; 
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
