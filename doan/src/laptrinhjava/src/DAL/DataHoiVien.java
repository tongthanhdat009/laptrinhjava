package DAL;
import java.sql.*;

import DTO.HoiVien;
public class DataHoiVien {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataHoiVien()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public int layMaHoiVienChuaTonTai()
    {
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TOP 1 MAHV FROM HoiVien ORDER BY MAHV DESC");
            if(rs.next()) return rs.getInt("MAHV") + 1;
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public boolean them(HoiVien hoiVien) // CHƯA TEST
    {
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            int maHoiVienMoi = layMaHoiVienChuaTonTai();
            String sql = "INSERT INTO HoiVien (MAHV, HoTenHV, GioiTinh, Gmail, TaiKhoan, MatKhau, MADV, NgaySinh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, maHoiVienMoi);
            preparedStatement.setString(2, hoiVien.getHoten());
            preparedStatement.setString(3, hoiVien.getMail());
            preparedStatement.setString(4, hoiVien.getGioitinh());
            preparedStatement.setString(5, hoiVien.getMail());
            preparedStatement.setString(6, hoiVien.getTaiKhoanHoiVien());
            preparedStatement.setString(7, hoiVien.getMatKhauHoiVien());
            preparedStatement.setDate(4, hoiVien.getNgaysinh());
            if (preparedStatement.executeUpdate() > 0)  return true;
        } catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public int KiemTraDangNhap(String taiKhoan, String matKhau) //ĐÃ TEST
    {
        // trả về -2 lỗi mở database, -1 TK 0 tồn tại, 0 sai pass, 1 đăng nhập user thành công, 2 đăng nhập admin thành công
        if(taiKhoan.equals("admin")&&matKhau.equals("admin")) return 2;
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HoiVien Where TaiKhoan ='"+ taiKhoan +"'");
            if(rs.next())
            {
                if(rs.getString("MatKhau").trim().equals(matKhau)) return 1;
                else return 0;
            }
            else return -1; 
        }
        catch(Exception e){
            System.out.println(e);
        }
        return -2;
    }
}