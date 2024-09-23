package DAL;
import java.sql.*;
import java.util.ArrayList;

import DTO.ChiTietHoaDon;
import DTO.DTODuyetDonHang;
public class DataHoaDonChiTiet {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataHoaDonChiTiet()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    // public ArrayList<ChiTietHoaDon> layDSHoaDon()
    // {
    //     ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
    //     String truyVan = "SELECT * FROM ChiTietHoaDon";
    //     try {
    //         con = DriverManager.getConnection(dbUrl, userName, password);
    //         Statement stmt = con.createStatement();
    //         ResultSet rs = stmt.executeQuery(truyVan);
    //         while(rs.next()) ds.add(new ChiTietHoaDon(rs.getInt(1), rs.getString(2), rs.getString(3)));
    //     } catch (Exception e) {
    //         System.out.println(e);   
    //     }
    //     return ds;
    // }
    public boolean them(ChiTietHoaDon chiTietHoaDon)
    {
        System.out.println(chiTietHoaDon.getSoLuong());
        System.out.println(chiTietHoaDon.getMaHoaDon());
        System.out.println(chiTietHoaDon.getMaHangHoa());
        System.out.println(chiTietHoaDon.getGia());
        System.out.println(chiTietHoaDon.getMaCoSo());
        String truyVan = "INSERT INTO ChiTietHoaDon (SoLuongHang, MaHD, MaHH, Gia, MaCoSo, TrangThai) VALUES (?, ?, ? ,? ,?, ?)";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setInt(1, chiTietHoaDon.getSoLuong());
            stmt.setString(2,chiTietHoaDon.getMaHoaDon());
            stmt.setString(3,chiTietHoaDon.getMaHangHoa());
            stmt.setInt(4,chiTietHoaDon.getGia());
            stmt.setString(5,chiTietHoaDon.getMaCoSo());
            stmt.setString(6,chiTietHoaDon.getTrangThai());
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);   
        }
        return false;
    }
    public boolean xoa(String maHoaDon, String maHangHoa)
    {
        String truyVan = "DELETE FROM ChiTietHoaDon WHERE MaHD = ? AND MaHangHoa = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, maHoaDon);
            stmt.setString(2, maHangHoa);
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);   
            return false;
        }
        return false;
    }
    // public ArrayList<ChiTietHoaDon> timKiem(String maHoaDon, String maHangHoa)
    // {
    //     String truyVan = "SELECT * FROM ChiTietHoaDon WHERE ";
    //     ArrayList<String> s = new ArrayList<>();
    //     ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
    //     if(!maHoaDon.equals("NULL"))
    //     {
    //         truyVan+="MaHD = ? AND ";
    //         s.add(maHoaDon);
    //     }
    //     if(!maHangHoa.equals("NULL"))
    //     {
    //         truyVan+="MaHangHoa = ? ";
    //         s.add(maHangHoa);
    //     }
    //     if (truyVan.endsWith("AND ")) {
    //         truyVan = truyVan.substring(0, truyVan.length() - 4);
    //     }
    //     try {
    //         con = DriverManager.getConnection(dbUrl, userName, password);
    //         PreparedStatement stmt = con.prepareStatement(truyVan);
    //         for(int i=1;i<=s.size();i++)
    //         stmt.setString(i,s.get(i-1));
    //         ResultSet rs = stmt.executeQuery();
    //         while(rs.next())
    //         ds.add(new ChiTietHoaDon(rs.getInt(1), rs.getString(2), rs.getString(3)));
    //     } catch (Exception e) {
    //         System.out.println(e);   
    //     }
    //     return ds;
    // }
    public boolean sua(String maHoaDon, String maHangHoa, int soLuong)
    {
        String truyVan = "UPDATE ChiTietHoaDon SET SoLuongHang = ? WHERE MaHD = ? AND MaHangHoa = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setInt(1, soLuong);
            stmt.setString(2, maHoaDon);
            stmt.setString(3, maHangHoa);
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);   
        }
        return false;
    }
    public ArrayList<DTODuyetDonHang> timDSChiTietHoaDon(String maHoaDon)
    {
        ArrayList<DTODuyetDonHang> ds = new ArrayList<>();
        String truyVan = "SELECT TenLoaiHangHoa, SoLuongHang, (SoLuongHang * GiaNhap) AS Gia  FROM ChiTietHoaDon, HangHoa WHERE ChiTietHoaDon.MaHangHoa = HangHoa.MaHangHoa AND MaHD = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, maHoaDon);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            ds.add(new DTODuyetDonHang(rs.getString(1), rs.getInt(2), rs.getInt(3)));
        } catch (Exception e) {
            System.out.println(e);   
        }
        return ds;
    }
}
