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
        String truyVan = "SELECT * FROM ThietBiOMotCoSo";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            int maxMa = 0;
            while(rs.next()) 
            {
                ma = rs.getString("MaThietBiOCoSo");
                ma = ma.substring(4);
                ma = ma.trim();
                if(Integer.parseInt(ma) > maxMa) maxMa = Integer.parseInt(ma);
            }
            return maxMa;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    public int nhapThietBi(String maLoaiThietBi,String maCoSo, int soLuong, int soNgayBaoHanh)
    {

        //soNgayBaoHanh từ bảng LoaiThietBi
        int maChuaCo = layMaThietBiCuoi() + 1;
        if(maChuaCo == 0) 
        {
            System.out.println("helo");
            return 0;
        }
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            String truyVan = "INSERT INTO ThietBiOMotCoSo (MaThietBiOCoSo, MaCoSo, MaThietBi, NgayNhap, HanBaoHanh) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt;
            stmt = con.prepareStatement(truyVan);
            int soHangUpdate = 0;
            for(int i=0;i<soLuong;i++)
            {
                stmt.setString(1, "TBCS"+maChuaCo);  
                stmt.setString(2, maCoSo);
                stmt.setString(3, maLoaiThietBi);
                LocalDate ngayHetHan = LocalDate.now();
                stmt.setDate(4, java.sql.Date.valueOf(ngayHetHan));
                stmt.setDate(5, java.sql.Date.valueOf(ngayHetHan.plusDays(soNgayBaoHanh)));
                soHangUpdate += stmt.executeUpdate();
                maChuaCo++;
            }  
            if(soHangUpdate == soLuong) return 1; 
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
