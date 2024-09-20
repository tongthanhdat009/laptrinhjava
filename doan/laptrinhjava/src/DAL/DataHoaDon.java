package DAL;
import java.sql.*;
import java.util.ArrayList;

import org.apache.poi.hpsf.Array;

import DTO.ChiTietChiTietHoaDon;
import DTO.HoaDon;
import DTO.HoaDonVaGia;
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
                ma=ma.trim();
                ma = ma.substring(2);
                if(max < Integer.parseInt(ma)) max = Integer.parseInt(ma);
            }
            max+=1;
            return "HD"+max;
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
    public ArrayList<HoaDonVaGia> layDSHoaDonVaGiaCua(String IDTaiKhoan)
    {
        ArrayList<HoaDonVaGia> ds = new ArrayList<>();
        String truyVan = "  SELECT HoaDon.MaHD, HoaDon.NgayXuatHD,IDTaiKhoan, TrangThai,SUM(Gia) AS Tong" + 
                        "  FROM HoaDon, ChiTietHoaDon" + 
                        "  WHERE HoaDon.MaHD = ChiTietHoaDon.MaHD AND IDTaiKhoan = '"+IDTaiKhoan+"'" + 
                        "  Group by HoaDon.MaHD, NgayXuatHD, TrangThai, IDTaiKhoan";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            ds.add(new HoaDonVaGia(rs.getString("MaHD"),rs.getDate("NgayXuatHD"), rs.getString("IDTaiKhoan"), rs.getString("TrangThai"),rs.getInt("Tong")));
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
        String truyVan = "INSERT INTO HoaDon (MaHD, NgayXuatHD, IDTaiKhoan, TrangThai) VALUES (?, ?, ?, ?)";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, hoaDon.getMaHoaDon());
            stmt.setDate(2, hoaDon.getNgayXuatHoaDon());
            stmt.setString(3, hoaDon.getMaHoiVien());
            stmt.setString(4, hoaDon.getTrangThai());
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean sua(HoaDon hoaDon)
    {
        String truyVan = "UPDATE HoaDon SET NgayXuatHD = ?, MaHV = ?, TrangThai = ? WHERE MaHD = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setDate(1, hoaDon.getNgayXuatHoaDon());
            stmt.setString(2, hoaDon.getMaHoiVien());
            stmt.setString(3, hoaDon.getTrangThai());
            stmt.setString(4, hoaDon.getMaHoaDon());
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
        String truyVan = "UPDATE HoaDon SET TongTien = ? WHERE MaHD = ?";
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
    public ArrayList<HoaDon> layHoaDonChuaDuyet()
    {
        ArrayList<HoaDon> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HoaDon WHERE TrangThai = 0";
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
    public boolean duyetHoaDon(String maHoaDon)
    {
        String truyVan = "UPDATE HoaDon SET TrangThai = 1 WHERE MaHD = ?";
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
    public ArrayList<HoaDon> timKiem2(String maHoaDon, String maCoSo, String maHV)
    {
        String truyVan = "SELECT * FROM HoaDon WHERE TrangThai = 0 AND";
        ArrayList<String> s = new ArrayList<>();
        ArrayList<HoaDon> ds = new ArrayList<>();
        if(!maHoaDon.equals("NULL"))
        {
            truyVan+=" MaHD = ? AND";
            s.add(maHoaDon);
        }
        if(!maCoSo.equals("NULL"))
        {
            truyVan+=" MaCoSo = ? AND";
            s.add(maCoSo);
        }
        if(!maHV.equals("NULL"))
        {
            truyVan+=" MaHV = ?";
            s.add(maHV);
        }
        if(truyVan.endsWith(" AND")) truyVan = truyVan.substring(0, truyVan.length() - 4);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            for(int i=0;i<s.size();i++)
            stmt.setString(i+1,s.get(i));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) 
            ds.add(new HoaDon(rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public ArrayList<ChiTietChiTietHoaDon> chiTietHoaDon(String IDTaiKhoan, String MaHoaDon)
    {

        ArrayList<ChiTietChiTietHoaDon> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HoaDon HD, ChiTietHoaDon CTHD, HoiVien HV, HangHoa HH WHERE HD.MaHD = CTHD.MaHD AND HD.IDTaiKhoan = '"+IDTaiKhoan+"' AND HV.IDTaiKhoan = '"+IDTaiKhoan+"' AND CTHD.MaHH = HH.MaHangHoa AND HD.MaHD = '"+MaHoaDon+"'";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            ds.add(new ChiTietChiTietHoaDon(
                    rs.getString("MaCoSo"),
                    rs.getDate("NgayXuatHD"), // Sử dụng java.sql.Date
                    rs.getString("MaHV"),
                    rs.getString("HoTenHV"),
                    rs.getString("TenLoaiHangHoa"),
                    rs.getInt("SoLuongHang"),
                    rs.getInt("Gia")
                ));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
}
