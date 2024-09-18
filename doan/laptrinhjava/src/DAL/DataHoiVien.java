package DAL;
import java.sql.*;
import java.util.ArrayList;

import DTO.DTOTaiKhoan;
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
        	con = DriverManager.getConnection(dbUrl, userName, password);
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
    
    public boolean them(HoiVien hoiVien) // test rồi
    {
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            String sql = "INSERT INTO HoiVien (MAHV, HoTenHV, GioiTinh, Gmail, NgaySinh, SoDienThoai, IDTaiKhoan, Anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, hoiVien.getMaHoiVien());
            preparedStatement.setString(2, hoiVien.getHoten());
            preparedStatement.setString(3, hoiVien.getGioitinh());
            preparedStatement.setString(4, hoiVien.getMail());
            preparedStatement.setString(5, hoiVien.getNgaysinh());
            preparedStatement.setString(6, hoiVien.getSdt());
            preparedStatement.setString(7, hoiVien.getIDTaiKhoan());
            preparedStatement.setString(8, "src/asset/img/avatar/user.png");
            
            if (preparedStatement.executeUpdate() > 0)  return true;
        } catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public dsHoiVien timKiem(HoiVien a) //Chưa test
    {
        ArrayList<String> ds = new ArrayList<String>();
        dsHoiVien dsHoiVien = new dsHoiVien();
        String truyVan = "SELECT *, TK.IDTaiKhoan FROM HoiVien, TaiKhoan TK Where HoiVien.IDTaiKhoan = TK.IDTaiKhoan AND ";
        if(!a.getMaHoiVien().equals(""))
        {
            truyVan+= "MaHV = ? AND ";
            ds.add(a.getMaHoiVien());
        } 
        if(!a.getGioitinh().equals(""))
        {
            truyVan+="GioiTinh = ? AND ";
            ds.add(a.getGioitinh());
        } 
        if(!a.getSdt().equals(""))
        {
            truyVan+="SoDienThoai = ? ";
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
                dsHoiVien.them(new HoiVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return dsHoiVien;
    }

    public boolean timKiemHV(String maHV) //test rồi
    {
        String truyVan = "SELECT * FROM HoiVien Where MaHV = ?";
        if(maHV.equals("")){
            return false;
        }
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maHV);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean xoa(String maHoiVien) //test thành công
    {
        //trả về 1 xóa thành công, 0 xóa thất bại do dữ liệu nhập không có trong database
        String truyVan = "DELETE FROM HoiVien Where MaHV = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            // PreparedStatement statement3 = con.prepareStatement(truyVan3);
            statement.setString(1, maHoiVien);
            // statement3.setString(1, maHoiVien);

            int rowsAffected = statement.executeUpdate();
            // int rowsAffected3 = statement2.executeUpdate();

            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean sua(HoiVien a) //test rồi
    {
        //trả về 1 sửa thành công, 0 thất bại
        String truyVan = "UPDATE HoiVien SET GioiTinh = ?, Gmail = ?, NgaySinh = ?, SoDienThoai = ? FROM HoiVien Where MaHV = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, a.getGioitinh());
            statement.setString(2, a.getMail());
            statement.setString(3, a.getNgaysinh());
            statement.setString(4, a.getSdt());
            statement.setString(5, a.getMaHoiVien());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
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
            dsHoiVien.add(new HoiVien(rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getDate(5),
                                    rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8)
            						));
        } catch (Exception e) {
            System.out.println(e);
        }
        return dsHoiVien;
    }
    
    // public String KiemTraDangNhap(String taiKhoan, String matKhau) //ĐÃ TEST
    // {
    //     // trả về -2 lỗi mở database, -1 TK 0 tồn tại, 0 sai pass, 1 đăng nhập user thành công
    //     try{
    //         con = DriverManager.getConnection(dbUrl, userName, password);
    //         Statement stmt = con.createStatement();
    //         ResultSet rs = stmt.executeQuery("SELECT * FROM HoiVien Where TaiKhoan ='"+ taiKhoan +"'");
    //         if(rs.next())
    //         {
    //             if(rs.getString("MatKhau").trim().equals(matKhau)) return rs.getString("IDQuyen");
    //             else return "Sai mật khẩu";
    //         }
    //         else return "Tài khoản không tồn tại"; 
    //     }
    //     catch(Exception e){
    //         System.out.println(e);
    //     }
    //     return "Lỗi mở database";
    // }
    
    public String taoMaHoiVienMoi() {
        try {
            // Tìm mã hội viên lớn nhất
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(MaHV) AS MaxMaHV FROM HoiVien");

            // Lấy mã lớn nhất
            String maxMaHV = "HV001";
            if (rs.next()) {
                String maxMaHVFromDB = rs.getString("MaxMaHV");
                if (maxMaHVFromDB != null) {
                    int nextMaHV = Integer.parseInt(maxMaHVFromDB.substring(2)) + 1;
                    String newMaHV;
                    boolean unique = false;
                    while (!unique) {
                        newMaHV = String.format("HV%03d", nextMaHV);
                        // Kiểm tra xem mã mới có duy nhất không
                        if (!kiemTraTonTaiMaHV(newMaHV)) {
                            maxMaHV = newMaHV;
                            unique = true;
                        }
                        nextMaHV++;
                    }
                }
            }
            return maxMaHV; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    private boolean kiemTraTonTaiMaHV(String maHV) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS Count FROM HoiVien WHERE MaHV = ?");
            ps.setString(1, maHV);
            ResultSet rsExist = ps.executeQuery();
            if (rsExist.next()) {
                int count = rsExist.getInt("Count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean dangkiHoiVien(HoiVien hv) {
    	String query = "INSERT INTO HoiVien (MaHV,HoTenHV,GioiTinh,Gmail,TaiKhoan,MatKhau,NgaySinh,SoDienThoai) VALUES(?,?,?,?,?,?,?,?)";
    	try {
    		String mahv = taoMaHoiVienMoi();
    		PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, mahv);
            ps.setString(2, hv.getHoten());
            ps.setString(3, hv.getGioitinh());
            ps.setString(4, hv.getMail());
            ps.setString(5, hv.getNgaysinh());
            ps.setString(6, hv.getSdt());
            ps.setString(7, hv.getIDTaiKhoan());
            int check = ps.executeUpdate();
            if(check > 0) {
            	return true;
            }
		} catch (Exception e) {
			System.out.println(e);
		}
    	return false;
    }
    
}