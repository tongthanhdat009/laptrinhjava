//Chưa test
package DAL;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.ThietBiCoSo;
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
            return maxMa + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    public int nhapThietBi(String maLoaiThietBi,String maCoSo, int soLuong, int soNgayBaoHanh)
    {

        //soNgayBaoHanh từ bảng LoaiThietBi
        int maChuaCo = layMaThietBiCuoi();
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
    public ArrayList<ThietBiCoSo> layDSLoaiThietBiCoSo()
    {
        String truyVan = "SELECT * FROM ThietBiOMotCoSo";
        ArrayList<ThietBiCoSo> ds = new ArrayList<>();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            {
                ds.add(new ThietBiCoSo(rs.getString("MaThietBiOCoSo"), rs.getString("MaCoSo"),rs.getString("MaThietBi"),rs.getDate("NgayNhap"),rs.getDate("HanBaoHanh")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public ArrayList<ThietBiCoSo> timKiem(String maThietBiCoSo)
    {
        String truyVan = "SELECT * FROM ThietBiOMotCoSo, LoaiThietBi WHERE LoaiThietBi.MaThietBi = ThietBiOMotCoSo.MaThietBi AND MaThietBiOCoSo = '" + maThietBiCoSo + "'";
        ArrayList<ThietBiCoSo> ds = new ArrayList<>();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            {
                LocalDate date =rs.getDate("NgayNhap").toLocalDate();
                date = date.plusDays(rs.getInt("NgayBaoHanh"));
                Date ngayHetBaoHanhSQL = Date.valueOf(date);
                ds.add(new ThietBiCoSo(rs.getString("MaThietBiOCoSo"), rs.getString("MaCoSo"),rs.getString("MaThietBi"),rs.getDate("NgayNhap"),ngayHetBaoHanhSQL));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public boolean xoa(String maThietBiCoSo)
    {
        String truyVan = "DELETE FROM ThietBiOMotCoSo WHERE MaThietBiOCoSo = '" + maThietBiCoSo + "'";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            if(stmt.executeUpdate(truyVan) > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean kiemTraMaLoaiThietBi(String ma)
    {
        String truyVan = "SELECT * FROM ThietBiOMotCoSo WHERE '"+ ma +"'";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            if(rs.next()) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean them(ThietBiCoSo a)
    {
        String truyVan ="INSERT INTO ThietBiOMotCoSo (MaThietBiOCoSo, MaCoSo, MaThietBi, NgayNhap, HanBaoHanh) VALUES (?, ?, ?, ?, ?)";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1,a.getMaThietBiCoSo());
            stmt.setString(2, a.getMaCoSo());
            stmt.setString(3, a.getMaThietBi());
            stmt.setDate(4, a.getNgayNhap());
            stmt.setDate(5, a.getHanBaoHanh());
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean sua(ThietBiCoSo a)
    {
        String truyVan = "UPDATE ThietBiOMotCoSo SET MaCoSo = ?, MaThietBi = ?, NgayNhap = ?, HanBaoHanh = ? WHERE MaThietBiOCoSo = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, a.getMaCoSo());
            stmt.setString(2, a.getMaThietBi());
            stmt.setDate(3, a.getNgayNhap());
            stmt.setDate(4, a.getHanBaoHanh());
            System.out.println(a.getHanBaoHanh());
            stmt.setString(5, a.getMaThietBiCoSo());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected);
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
