package DAL;
import java.sql.*;
import java.util.ArrayList;
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
    public String layMa()
    {
        String truyVan = "SELECT * FROM HoaDon";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            int max = 0;
            while(rs.next())
            {
                String ma = rs.getString("MaHD");
                ma = ma.substring(2);
                if(max < Integer.parseInt(ma)) max = Integer.parseInt(ma);
            }
            return "HD"+max+1;
        } catch (Exception e) {
            System.out.println(e);   
        }
        return "Loi";
    }
    public ArrayList<HoaDon> layDSHoaDon()
    {
        ArrayList<HoaDon> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HoaDon";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            ds.add(new HoaDon(rs.getString(1),rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public boolean xoa(String maHoaDon)
    {
        String truyVan = "DELETE FROM HoaDon WHERE MaHD = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, maHoaDon);
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean them(HoaDon hoaDon)
    {
        String truyVan = "INSERT INTO HoaDon (MaHD, NgayXuatHD, TongTien, MaHoiVien, MaCoSo, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, hoaDon.getMaHoaDon());
            stmt.setDate(2, hoaDon.getNgayXuatHoaDon());
            stmt.setInt(3, hoaDon.getTongTien());
            stmt.setString(4, hoaDon.getMaHoiVien());
            stmt.setString(5, hoaDon.getMaCoSo());
            stmt.setString(6, hoaDon.getTrangThai());
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean sua(HoaDon hoaDon)
    {
        String truyVan = "UPDATE HoaDon SET NgayXuatHoaDon = ?, MaHoiVien = ?, MaCoSo = ?, TrangThai = ? WHERE MaHD = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setDate(1, hoaDon.getNgayXuatHoaDon());
            stmt.setString(2, hoaDon.getMaHoiVien());
            stmt.setString(3, hoaDon.getMaCoSo());
            stmt.setString(4, hoaDon.getTrangThai());
            stmt.setString(5, hoaDon.getMaHoaDon());
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
    return false;
    }
    public ArrayList<HoaDon> timKiem(String maHoaDon)
    {
        ArrayList<HoaDon> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HoaDon WHERE MaHD = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, maHoaDon);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            ds.add(new HoaDon(rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public boolean suaTongTien(String maHoaDon, int tongTien)
    {
        String truyVan = "UPDATE HoaDon SET TongTien = ? WHERE MaHoaDon = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setInt(1, tongTien);
            stmt.setString(2, maHoaDon);
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean kiemTraTonTai(String maHoaDon)
    {
        String truyVan = "SELECT * FROM HoaDon WHERE MaHD = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, maHoaDon);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
