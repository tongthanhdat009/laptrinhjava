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
    public boolean kiemTraDaDuyetChua(String maHoaDon)
    {
        String truyVan ="SELECT * FROM ChiTietHoaDon WHERE MaHD = '"+maHoaDon+"' AND TrangThai = N'Chưa duyệt'";
        System.out.println(truyVan);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            if(rs.next()) return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;      
    }
    public ArrayList<HoaDonVaGia> layDSHoaDonVaGiaCua(String IDTaiKhoan)
    {
        ArrayList<HoaDonVaGia> ds = new ArrayList<>();
        String truyVan ="  SELECT HoaDon.MaHD, HoaDon.NgayXuatHD,IDTaiKhoan ,SUM(Gia) AS Tong" + 
                        "  FROM HoaDon, ChiTietHoaDon" + 
                        "  WHERE HoaDon.MaHD = ChiTietHoaDon.MaHD AND IDTaiKhoan = '"+IDTaiKhoan+"'" + 
                        "  Group by HoaDon.MaHD, NgayXuatHD, TrangThai, IDTaiKhoan";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            {
                String maHD = rs.getString("MaHD").trim();
                Date ngay = rs.getDate("NgayXuatHD");
                String id = rs.getString("IDTaiKhoan");
                int tong = rs.getInt("Tong");
                if(kiemTraDaDuyetChua(maHD))
                ds.add(new HoaDonVaGia(maHD,ngay,id,"Đã duyệt",tong));
                else 
                ds.add(new HoaDonVaGia(maHD,ngay,id,"Chưa duyệt",tong));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;      
    }
    public boolean them(HoaDon hoaDon)
    {
        String truyVan = "INSERT INTO HoaDon (MaHD, NgayXuatHD, IDTaiKhoan) VALUES (?, ?, ?)";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, hoaDon.getMaHoaDon());
            stmt.setDate(2, hoaDon.getNgayXuatHoaDon());
            stmt.setString(3, hoaDon.getMaHoiVien());
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
    public ArrayList<ChiTietChiTietHoaDon> chiTietHoaDon(String IDTaiKhoan, String MaHoaDon)
    {

        ArrayList<ChiTietChiTietHoaDon> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HoaDon HD, ChiTietHoaDon CTHD, HoiVien HV, HangHoa HH WHERE HD.MaHD = CTHD.MaHD AND HD.IDTaiKhoan = '"+IDTaiKhoan+"' AND HV.IDTaiKhoan = '"+IDTaiKhoan+"' AND CTHD.MaHH = HH.MaHangHoa AND HD.MaHD = '"+MaHoaDon+"'";
        System.out.println(truyVan);
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
                    rs.getInt("Gia"),
                    rs.getString("TrangThai")
                ));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public ArrayList<ChiTietChiTietHoaDon> chiTietHoaDonCuaCoSo(String IDTaiKhoan, String MaHoaDon, String maCoSo)
    {

        ArrayList<ChiTietChiTietHoaDon> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HoaDon HD, ChiTietHoaDon CTHD, HoiVien HV, HangHoa HH WHERE CTHD.MaCoSo = '"+maCoSo+"' AND HD.MaHD = CTHD.MaHD AND HD.IDTaiKhoan = '"+IDTaiKhoan+"' AND HV.IDTaiKhoan = '"+IDTaiKhoan+"' AND CTHD.MaHH = HH.MaHangHoa AND HD.MaHD = '"+MaHoaDon+"'";
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
                    rs.getInt("Gia"),
                    rs.getString("TrangThai")
                ));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public ArrayList<HoaDonVaGia> layDSHoaDon(String trangThai)
    {
        ArrayList<HoaDonVaGia> ds = new ArrayList<>();
        String truyVan = "  SELECT HoaDon.MaHD, HoaDon.NgayXuatHD,IDTaiKhoan, TrangThai, SUM(Gia) AS Tong" + 
                        "  FROM HoaDon, ChiTietHoaDon" + 
                        "  WHERE HoaDon.MaHD = ChiTietHoaDon.MaHD" + 
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
    public ArrayList<HoaDonVaGia> layDSHoaDonCuaCoSo(String maCoSo,String trangThai)
    {
        ArrayList<HoaDonVaGia> ds = new ArrayList<>();
        String truyVan = " SELECT HoaDon.MaHD, HoaDon.NgayXuatHD, IDTaiKhoan, SUM(Gia) AS Tong" + 
                        "  FROM HoaDon, ChiTietHoaDon" + 
                        "  WHERE HoaDon.MaHD = ChiTietHoaDon.MaHD AND MaCoSo = '"+maCoSo+"'" + 
                        "  Group by HoaDon.MaHD, NgayXuatHD, TrangThai, IDTaiKhoan";
                        System.out.println(truyVan);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            {
                String maHD = rs.getString("MaHD").trim();
                Date ngay = rs.getDate("NgayXuatHD");
                String id = rs.getString("IDTaiKhoan");
                int tong = rs.getInt("Tong");
                if(kiemTraDaDuyetOCoSoChua(maHD,maCoSo))
                ds.add(new HoaDonVaGia(maHD,ngay,id,"Đã duyệt",tong));
                else 
                ds.add(new HoaDonVaGia(maHD,ngay,id,"Chưa duyệt",tong));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;  
    }
    public boolean kiemTraDaDuyetOCoSoChua(String maHoaDon, String maCoSo)
    {
        String truyVan ="SELECT * FROM ChiTietHoaDon WHERE MaHD = '"+maHoaDon+"' AND MaCoSo = '"+maCoSo+"' AND TrangThai = N'Chưa duyệt'";
        System.out.println(truyVan);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            if(rs.next()) return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;      
    }
    public boolean duyetHoaDonCuaCoSo(String maHoaDon, String maCoSo)
    {
        String truyVan = "UPDATE ChiTietHoaDon SET TrangThai = N'Đã duyệt' WHERE MaCoSo = '" + maCoSo+"' AND MaHD = '"+maHoaDon+"'";
        System.out.println(truyVan);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement statement = con.createStatement();
            if(statement.executeUpdate(truyVan) > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
