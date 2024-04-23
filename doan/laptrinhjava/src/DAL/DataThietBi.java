//Chưa test
package DAL;

import java.sql.*;
import java.util.ArrayList;

import DTO.CoSo;
import DTO.DSLoaiThietBi;
import DTO.LoaiThietBi;
public class DataThietBi {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    ArrayList<String> tenCot = new ArrayList<String>();
    public DataThietBi()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> layTenCotThietBi (){
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LoaiThietBi");
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i=1; i<=rsmd.getColumnCount();i++){
                this.tenCot.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this.tenCot; 
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
    // public int laySoLuong()
    // {
    //     try {
    //         con = DriverManager.getConnection(dbUrl, userName, password);
    //         Statement stmt = con.createStatement();
    //         ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS SL FROM LoaiThietBi");
    //         if(rs.next()) return rs.getInt("SL");
    //     }
    //     catch(Exception e){
    //         System.out.println(e);
    //     }
    //     return 0;
    // }
    public DSLoaiThietBi timKiem(String ten)
    {
        String truyVan = "SELECT * FROM LoaiThietBi WHERE TenLoaiThietBi = ?";
        DSLoaiThietBi ds = new DSLoaiThietBi();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                LoaiThietBi thietBi = new LoaiThietBi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                ds.them(thietBi);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public boolean timKiemTheoMaTB(String maTB)
    {
        String truyVan = "SELECT MaThietBi FROM LoaiThietBi Where MaThietBi = ?";
        if(maTB.equals("")){
            return false;
        }
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maTB);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean xoaTB(String maTB){
        String truyVan = "DELETE FROM LoaiThietBi WHERE MaThietBi = ?";
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement preparedStatement = con.prepareStatement(truyVan);
            preparedStatement.setString(1, maTB);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0)return true;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean themTB(LoaiThietBi tb){
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            String sql = "INSERT INTO LoaiThietBi (MaThietBi, TenLoaiThietBi, HinhAnh, GiaThietBi, NgayBaoHanh) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,tb.getMaThietBi());            
            preparedStatement.setString(2,tb.getTenLoaiThietBi());            
            preparedStatement.setString(3,tb.getHinhAnh());            
            preparedStatement.setInt(4,Integer.parseInt(tb.getGiaThietBi()));            
            preparedStatement.setInt(5,tb.getNgayBaoHanh());            
            if (preparedStatement.executeUpdate() > 0)  return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public int layMaThietBiMoi(){
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MaThietBi FROM LoaiThietBi");
            int max = 0;
            while(rs.next()){
                String maTB = rs.getString("MaThietBi");
                maTB=maTB.substring(2);
                if(Integer.parseInt(maTB) > max){
                    max = Integer.parseInt(maTB);
                }
            }
            return max;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
    public boolean suaThongTinTB(LoaiThietBi tb){
        //trả về 1 sửa thành công, 0 thất bại
        String truyVan = "UPDATE LoaiThietBi SET MaThietBi = ?, TenLoaiThietBi = ?, HinhAnh = ?, GiaThietBi = ?, NgayBaoHanh = ? FROM LoaiThietBi Where MaThietBi = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, tb.getMaThietBi());
            statement.setString(2, tb.getTenLoaiThietBi());
            statement.setString(3, tb.getHinhAnh());
            statement.setString(4, tb.getGiaThietBi());
            statement.setInt(5, tb.getNgayBaoHanh());
            statement.setString(6, tb.getMaThietBi());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
