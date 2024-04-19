package DAL;
import java.sql.*;
import java.util.ArrayList;
import DTO.HoiVien;
import DTO.dsHoiVien;
public class DataHoiVien {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public ArrayList<String> tenCot = new ArrayList<String>();
    
    public DataHoiVien()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public ArrayList<String> getTenCot(){
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HoiVien");
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
    public int layMaHoiVienChuaTonTai()
    {
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HoiVien");
            int max = 0;
            while(rs.next())
            {
                String ma = rs.getString("MaHV");
                ma = ma.substring(2);
                if(max < Integer.parseInt(ma)) max = Integer.parseInt(ma);
            }
            return max;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public boolean them(HoiVien hoiVien) // CHƯA TEST
    {
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            String maHoiVienMoi = "HV"+layMaHoiVienChuaTonTai();
            String sql = "INSERT INTO HoiVien (MAHV, HoTenHV, GioiTinh, Gmail, TaiKhoan, MatKhau, MADV, NgaySinh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maHoiVienMoi);
            preparedStatement.setString(2, hoiVien.getHoten());
            preparedStatement.setString(3, hoiVien.getMail());
            preparedStatement.setString(4, hoiVien.getGioitinh());
            preparedStatement.setString(5, hoiVien.getMail());
            preparedStatement.setString(6, hoiVien.getTaiKhoanHoiVien());
            preparedStatement.setString(7, hoiVien.getMatKhauHoiVien());
            preparedStatement.setString(4, hoiVien.getNgaysinh());
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
    public dsHoiVien timKiem(HoiVien a) //Chưa test
    {
        ArrayList<String> ds = new ArrayList<String>();
        dsHoiVien dsHoiVien = new dsHoiVien();
        String truyVan = "SELECT * FROM HoiVien Where ";
        if(!a.getMaHoiVien().equals("NULL"))
        {
            truyVan+= "MaHV = ? AND ";
            ds.add(a.getMaHoiVien());
        } 
        if(!a.getHoten().equals("NULL"))
        {
            truyVan+="HoTenHV = ? AND ";
            ds.add(a.getHoten());
        } 
        if(!a.getGioitinh().equals("NULL"))
        {
            truyVan+="GioiTinh = ? AND ";
            ds.add(a.getGioitinh());
        } 
        if(!a.getMail().equals("NULL"))
        {
            truyVan+="Gmail = ? AND ";
            ds.add(a.getMail());
        } 
        if(!a.getTaiKhoanHoiVien().equals("NULL"))
        {
            truyVan+="TaiKhoan = ? AND ";
            ds.add(a.getTaiKhoanHoiVien());
        } 
        if(!a.getMatKhauHoiVien().equals("NULL"))
        {
            truyVan+="MatKhau = ? AND ";
            ds.add(a.getMatKhauHoiVien());
        } 
        if(!a.getMaDV().equals("NULL"))
        {
            truyVan+="MaDV = ? AND ";
            ds.add(a.getMaDV());
        } 
        if(!a.getNgaysinh().equals("2000-01-01"))
        {
            truyVan+="NgaySinh = ? AND";
            ds.add(a.getNgaysinh());
        } 
        if(!a.getSdt().equals("NULL"))
        {
            truyVan+="SDT = ? ";
            ds.add(a.getSdt());
        }
        truyVan = truyVan.trim();
        if (truyVan.endsWith("AND")) {
            // Xóa "AND" cuối cùng bằng cách cắt chuỗi từ đầu đến vị trí cuối cùng của "AND"
            truyVan = truyVan.substring(0, truyVan.lastIndexOf("AND")).trim();
        }

        try
        {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            for(int i=0;i<ds.size();i++)
            statement.setString(i+1, ds.get(i));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                dsHoiVien.them(new HoiVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getString(9)));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return dsHoiVien;
    }
    public boolean xoa(String maHoiVien) //test thành công
    {
        //trả về 1 xóa thành công, 0 xóa thất bại do dữ liệu nhập không có trong database
        String truyVan = "DELETE FROM HoiVien Where MaHV = ? ";
        String truyVan2 = "DELETE FROM HoaDon Where MaHV = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            PreparedStatement statement2 = con.prepareStatement(truyVan2);
            statement.setString(1, maHoiVien);
            statement2.setString(1, maHoiVien);
            int rowsAffected2 = statement2.executeUpdate();
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0 && rowsAffected2>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public int sua(HoiVien a) //Chưa test
    {
        //trả về 1 sửa thành công, 0 thất bại
        String truyVan = "UPDATE HoiVien SET HoTenHV = ?, GioiTinh = ?, Gmail = ?, TaiKhoan = ?, MatKhau = ?, MaDV = ?, NgaySinh = ?, SDT = ? FROM HoiVien Where MaHV = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(0, a.getHoten());
            statement.setString(1, a.getGioitinh());
            statement.setString(2, a.getMail());
            statement.setString(3, a.getTaiKhoanHoiVien());
            statement.setString(4, a.getMatKhauHoiVien());
            statement.setString(5, a.getMaDV());
            statement.setString(6, a.getNgaysinh());
            statement.setString(7, a.getSdt());
            statement.setString(8, a.getMaDV());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public ArrayList<HoiVien> layDanhSachHoiVien()
    {
        ArrayList<HoiVien> dsHoiVien = new ArrayList<>();
        String truyVan = "SELECT * FROM HoiVien";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            dsHoiVien.add(new HoiVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getString(9)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return dsHoiVien;
    }
}