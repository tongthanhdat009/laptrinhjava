//Chưa test
package DAL;

import java.sql.*;
import java.util.ArrayList;

import DTO.DSLoaiThietBi;
import DTO.LoaiThietBi;
import DTO.MayChay;
import DTO.Ta;
import DTO.Xa;
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

    public int timSoNgayBaoHanh(String maThietBi)
    {
        String truyVan = "SELECT NgayBaoHanh FROM LoaiThietBi WHERE MaThietBi = '"+maThietBi+"'";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            if(rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public boolean kiemTraMa(String ma)
    {
        String truyVan = "SELECT * FROM LoaiThietBi WHERE MaThietBi = '"+ ma +"'";
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
                LoaiThietBi thietBi = new LoaiThietBi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getString(6));
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
    // public DSLoaiThietBi timKiem(String ten)
    // {
    //     String truyVan = "SELECT * FROM LoaiThietBi WHERE TenLoaiThietBi = ?";
    //     DSLoaiThietBi ds = new DSLoaiThietBi();
    //     try {
    //         con = DriverManager.getConnection(dbUrl, userName, password);
    //         PreparedStatement stmt = con.prepareStatement(truyVan);
    //         stmt.setString(1, ten);
    //         ResultSet rs = stmt.executeQuery();
    //         while(rs.next())
    //         {
    //             LoaiThietBi thietBi = new LoaiThietBi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
    //             ds.them(thietBi);
    //         }
    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }
    //     return ds;
    // }

    // public DSLoaiThietBi timKiemTB(LoaiThietBi a) //Chưa test
    // {
    //     ArrayList<String> ds = new ArrayList<String>();
    //     DSLoaiThietBi dsTB = new DSLoaiThietBi();
    //     String truyVan = "SELECT * FROM LoaiThietBi Where ";
    //     if(!a.getMaThietBi().equals(""))
    //     {
    //         truyVan+= "MaThietBi = ? AND ";
    //         ds.add(a.getMaThietBi());
    //     } 
    //     if(!a.getTenLoaiThietBi().equals(""))
    //     {
    //         truyVan+="TenLoaiThietBi = ? AND ";
    //         ds.add(a.getTenLoaiThietBi());
    //     } 
    //     truyVan = truyVan.trim();
    //     if (truyVan.endsWith("AND")) {
    //         // Xóa "AND" cuối cùng bằng cách cắt chuỗi từ đầu đến vị trí cuối cùng của "AND"
    //         truyVan = truyVan.substring(0, truyVan.lastIndexOf("AND")).trim();
    //     }
    //     if (truyVan.endsWith("Where")) {
    //         // Xóa "AND" cuối cùng bằng cách cắt chuỗi từ đầu đến vị trí cuối cùng của "AND"
    //         truyVan = truyVan.substring(0, truyVan.lastIndexOf("Where")).trim();
    //     }
    //     try
    //     {
    //         con = DriverManager.getConnection(dbUrl, userName, password);
    //         PreparedStatement statement = con.prepareStatement(truyVan);
    //         for(int i=0;i<ds.size();i++)
    //             statement.setString(i+1, ds.get(i));
    //         ResultSet rs = statement.executeQuery();
    //         while(rs.next())
    //         {
    //         	dsTB.them(new LoaiThietBi(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
    //         }
    //     }catch(Exception e)
    //     {
    //         System.out.println(e);
    //     }
    //     return dsTB;
    // }
    
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
            String sql = "INSERT INTO LoaiThietBi (MaThietBi, TenLoaiThietBi, HinhAnh, GiaThietBi, NgayBaoHanh, Loai) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,tb.getMaThietBi());            
            preparedStatement.setString(2,tb.getTenLoaiThietBi());            
            preparedStatement.setString(3,tb.getHinhAnh());            
            preparedStatement.setInt(4,Integer.parseInt(tb.getGiaThietBi()));            
            preparedStatement.setInt(5,tb.getNgayBaoHanh());            
            preparedStatement.setString(6, tb.getLoai());
            System.out.println(tb.getLoai());
            if (preparedStatement.executeUpdate() > 0)  return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean themTa(String MaThietBi, int khoiLuong, String chatLieu, String mauSac)
    {
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            String sql = "INSERT INTO LoaiThietBi (MaThietBi, TenLoaiThietBi, HinhAnh, GiaThietBi, NgayBaoHanh, Loai) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,MaThietBi);            
            preparedStatement.setInt(2,khoiLuong);            
            preparedStatement.setString(3,chatLieu);            
            preparedStatement.setString(4,mauSac);
            if (preparedStatement.executeUpdate() > 0)  return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean themMayChay(String MaThietBi, int congSuat, int tocDoToiDa, String nhaSanXuat, String kichThuoc) {
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            String sql = "INSERT INTO MayChay (MaThietBi, CongSuat, TocDoToiDa, NhaSanXuat, KichThuoc) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,MaThietBi);            
            preparedStatement.setInt(2,congSuat);            
            preparedStatement.setInt(3,tocDoToiDa);            
            preparedStatement.setString(4,nhaSanXuat);
            preparedStatement.setString(5,kichThuoc);
            if (preparedStatement.executeUpdate() > 0)  return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean themXa(String MaThietBi, String loaiXa, String chatLieu, float chieuDai, float duongKinh, float chieuCao, float taiTrong)
    {
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            String sql = "INSERT INTO Xa (MaThietBi, LoaiXa, ChatLieu, ChieuDai, DuongKinh, ChieuCao, TaiTrong) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,MaThietBi);            
            preparedStatement.setString(2,loaiXa);            
            preparedStatement.setString(3,chatLieu);            
            preparedStatement.setFloat(4,chieuDai);
            preparedStatement.setFloat(5,duongKinh);
            preparedStatement.setFloat(6,chieuCao);
            preparedStatement.setFloat(7,taiTrong);
            if (preparedStatement.executeUpdate() > 0)  return true;
        } catch (Exception e) {
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
        String truyVan = "UPDATE LoaiThietBi SET TenLoaiThietBi = ?, HinhAnh = ?, GiaThietBi = ?, NgayBaoHanh = ?, Loai = ? FROM LoaiThietBi Where MaThietBi = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, tb.getTenLoaiThietBi());
            statement.setString(2, tb.getHinhAnh());
            statement.setString(3, tb.getGiaThietBi());
            statement.setInt(4, tb.getNgayBaoHanh());
            statement.setString(5, tb.getLoai());
            statement.setString(6, tb.getMaThietBi());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public String layMaChuaTonTai() {
        String truyVan = "SELECT MaThietBi FROM LoaiThietBi";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
    
            int so = 0; // Khởi tạo biến so để lưu trữ giá trị lớn nhất của mã
            String ma;
    
            // Duyệt qua tất cả các mã thiết bị hiện có trong bảng
            while (rs.next()) {
                ma = rs.getString(1); // Lấy mã thiết bị
                ma = ma.substring(2); // Lấy phần số sau "TB"
                
                // Kiểm tra và cập nhật giá trị lớn nhất cho biến so
                int soHienTai = Integer.parseInt(ma); // Chuyển đổi chuỗi thành số
                if (so < soHienTai) {
                    so = soHienTai; // Cập nhật số lớn nhất
                }
            }
    
            // Tạo mã mới bằng cách tăng số lớn nhất lên 1
            so = so + 1;
            return String.format("TB%03d", so);
    
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Loi";
    }
    
    public boolean SuaTa(Ta ta)
    {
        String truyVan = "UPDATE Ta SET KhoiLuong = ?, ChatLieu = ?, MauSac = ? FROM Ta Where MaThietBi = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, ta.getTenLoaiThietBi());
            statement.setString(2, ta.getHinhAnh());
            statement.setString(3, ta.getGiaThietBi());
            statement.setString(4, ta.getMaThietBi());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean SuaThietBiTa(Ta ta)
    {
       if (suaThongTinTB(new LoaiThietBi(ta.getMaThietBi(), ta.getTenLoaiThietBi(), ta.getHinhAnh(), ta.getGiaThietBi(), ta.getNgayBaoHanh(), ta.getLoai())))
       if (SuaTa(ta)) return true;
       return false;
    }
    public boolean SuaMayChay(MayChay mayChay) {
    String truyVan = "UPDATE MayChay SET CongSuat = ?, TocDoToiDa = ?, NhaSanXuat = ?, KichThuoc = ? FROM MayChay WHERE MaThietBi = ?";
    try {
        con = DriverManager.getConnection(dbUrl, userName, password);
        PreparedStatement statement = con.prepareStatement(truyVan);
        statement.setInt(1, mayChay.getCongSuat());
        statement.setInt(2, mayChay.getTocDoToiDa());
        statement.setString(3, mayChay.getNhaSanXuat());
        statement.setString(4, mayChay.getKichThuoc());
        statement.setString(5, mayChay.getMaThietBi());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) return true;
    } catch (Exception e) {
        System.out.println(e);
    }
    return false;
}

public boolean SuaThietBiMayChay(MayChay mayChay) {
    if (suaThongTinTB(new LoaiThietBi(mayChay.getMaThietBi(), mayChay.getTenLoaiThietBi(), mayChay.getHinhAnh(), mayChay.getGiaThietBi(), mayChay.getNgayBaoHanh(), mayChay.getLoai()))) 
        if (SuaMayChay(mayChay)) return true;
    return false;
}
public boolean SuaXa(Xa xa) {
    String truyVan = "UPDATE Xa SET LoaiXa = ?, ChatLieu = ?, ChieuDai = ?, DuongKinh = ?, ChieuCao = ?, TaiTrong = ? FROM Xa WHERE MaThietBi = ?";
    try {
        con = DriverManager.getConnection(dbUrl, userName, password);
        PreparedStatement statement = con.prepareStatement(truyVan);
        statement.setString(1, xa.getLoaiXa());
        statement.setString(2, xa.getChatLieu());
        statement.setFloat(3, xa.getChieuDai());
        statement.setFloat(4, xa.getDuongKinh());
        statement.setFloat(5, xa.getChieuCao());
        statement.setFloat(6, xa.getTaiTrong());
        statement.setString(7, xa.getMaThietBi());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) return true;
    } catch (Exception e) {
        System.out.println(e);
    }
    return false;
}

public boolean SuaThietBiXa(Xa xa) {
        if (suaThongTinTB(new LoaiThietBi(xa.getMaThietBi(), xa.getTenLoaiThietBi(), xa.getHinhAnh(), xa.getGiaThietBi(), xa.getNgayBaoHanh(), xa.getLoai()))) 
            if (SuaXa(xa)) return true;
        return false;
    }
    public ArrayList<Ta> layDanhSachTa(){
        ArrayList<Ta> a = new ArrayList<>();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            String truyVan = "SELECT * FROM Ta, LoaiThietBi WHERE LoaiThietBi.MaThietBi = Ta.MaThietBi";
            PreparedStatement stmt = con.prepareStatement(truyVan);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Ta hello = new Ta(rs.getString("MaThietBi"), rs.getString("TenLoaiThietBi"),
                rs.getString("HinhAnh"), rs.getString("GiaThietBi"), 
                rs.getInt("NgayBaoHanh"),rs.getString("Loai"),
                rs.getInt("KhoiLuong"),rs.getString("ChatLieu"),rs.getString("MauSac"));
                System.out.println(hello.getKhoiLuong());
                a.add(hello);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }
    public ArrayList<Xa> layDanhSachXa() {
        ArrayList<Xa> a = new ArrayList<>();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            String truyVan = "SELECT * FROM Xa, LoaiThietBi WHERE LoaiThietBi.MaThietBi = Xa.MaThietBi";
            PreparedStatement stmt = con.prepareStatement(truyVan);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a.add(new Xa(rs.getString("MaThietBi"), rs.getString("TenLoaiThietBi"),
                        rs.getString("HinhAnh"), rs.getString("GiaThietBi"), 
                        rs.getInt("NgayBaoHanh"), rs.getString("Loai"),
                        rs.getString("LoaiXa"), rs.getString("ChatLieu"), 
                        rs.getFloat("ChieuDai"), rs.getFloat("DuongKinh"), 
                        rs.getFloat("ChieuCao"), rs.getFloat("TaiTrong")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }
    public ArrayList<MayChay> layDanhSachMayChay() {
        ArrayList<MayChay> a = new ArrayList<>();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            String truyVan = "SELECT * FROM MayChay, LoaiThietBi WHERE LoaiThietBi.MaThietBi = MayChay.MaThietBi";
            PreparedStatement stmt = con.prepareStatement(truyVan);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a.add(new MayChay(rs.getString("MaThietBi"), rs.getString("TenLoaiThietBi"),
                        rs.getString("HinhAnh"), rs.getString("GiaThietBi"), 
                        rs.getInt("NgayBaoHanh"), rs.getString("Loai"),
                        rs.getInt("CongSuat"), rs.getInt("TocDoToiDa"), 
                        rs.getString("NhaSanXuat"), rs.getString("KichThuoc")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }
        
}
