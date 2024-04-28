package DAL;

import java.sql.*;
import java.util.*;

import DTO.HoiVienCoSo;
public class DataHoiVienCoSo {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataHoiVienCoSo()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public ArrayList<HoiVienCoSo> layDanhSach()
    {
        String truyVan = "SELECT * FROM HoiVienOCoSo";
        ArrayList<HoiVienCoSo> ds = new ArrayList<>();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            ds.add(new HoiVienCoSo(rs.getDate(1),rs.getString(2), rs.getString(3)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public ArrayList<HoiVienCoSo> timKiem(String maHoiVien, String maCoSo)
    {
        ArrayList<HoiVienCoSo> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HoiVienOCoSo WHERE";
        if(!maHoiVien.equals("NULL")) truyVan+=" MaHV = ? AND";
        if(!maCoSo.equals("NULL")) truyVan +=" MaCoSo = ?";
        if (truyVan.endsWith("AND"))
        truyVan = truyVan.substring(0, truyVan.lastIndexOf("AND")).trim();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            int i = 1;
            if(!maHoiVien.equals("NULL"))
            {
                stmt.setString(i, maHoiVien);
                i++;
            } 
            if(!maCoSo.equals("NULL")) stmt.setString(i, maCoSo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            ds.add(new HoiVienCoSo(rs.getDate(1),rs.getString(2), rs.getString(3)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public boolean them(HoiVienCoSo a)
    {
        String truyVan = "INSERT INTO HoiVienOCoSo (ThoiGianKetThuc, MaHV, MaCoSO) VALUES (?, ?, ?)";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setDate(1, a.getHanTap());
            stmt.setString(2,a.getMaHoiVien());
            stmt.setString(3,a.getMaCoSo());
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean xoa(String maHoiVien, String maCoSO)
    {
        String truyVan = "DELETE HoiVienOCoSo WHERE MaHV = ? AND MaCoSo = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, maHoiVien);
            stmt.setString(2, maCoSO);
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean sua(HoiVienCoSo a)
    {
        String truyVan = "UPDATE HoiVienOCoSO SET ThoiGianKetThuc = ? WHERE MAHV = ? AND MACoSo = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setDate(1, a.getHanTap());
            stmt.setString(2, a.getMaHoiVien());
            stmt.setString(3,a.getMaCoSo());
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
