package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.chiTietPhieuNhap;

public class dataChiTietDonNhap {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public dataChiTietDonNhap(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public ArrayList<chiTietPhieuNhap> getChiTietDonNhap(String maDonNhap) {
        ArrayList<chiTietPhieuNhap> ds = new ArrayList<>();
        String truyVan = "select maphieunhap,MaHangHoa,soluong,gianhap from ChiTietPhieuNhap where MaPhieuNhap=?;";
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maDonNhap);
            ResultSet rs = pstmt.executeQuery();
            // Lấy dữ liệu từ ResultSet và thêm vào danh sách
            while (rs.next()) {
                ds.add(new chiTietPhieuNhap(rs.getString("maphieunhap"), 
                                   rs.getString("mahanghoa"), 
                                   rs.getInt("soluong"), 
                                   rs.getInt("gianhap")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public String getTenHH(String maHangHoa) {
        String tenHangHoa = "";
        String truyVan = "SELECT TenLoaiHangHoa FROM HangHoa WHERE MaHangHoa = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maHangHoa);
            rs = pstmt.executeQuery();
            
            // Lấy dữ liệu từ ResultSet
            if (rs.next()) {
                tenHangHoa = rs.getString("TenLoaiHangHoa");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tenHangHoa;
    }    
    public String getLoaiHH(String maHangHoa) {
        String tenHangHoa = "";
        String truyVan = "SELECT Loai FROM HangHoa WHERE MaHangHoa = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maHangHoa);
            rs = pstmt.executeQuery();
            
            // Lấy dữ liệu từ ResultSet
            if (rs.next()) {
                tenHangHoa = rs.getString("Loai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tenHangHoa;
    }
    public int getTongTien(String maDonNhap) {
        int tongTien = 0;
        String truyVan = "SELECT SUM(SoLuong * GiaNhap) AS TongTien FROM ChiTietPhieuNhap where maphieunhap= ? GROUP BY MaPhieuNhap;";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maDonNhap);
            rs = pstmt.executeQuery();
            
            // Lấy dữ liệu từ ResultSet
            if (rs.next()) {
                tongTien = rs.getInt("TongTien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tongTien;
    }

    public void themHoacCapNhatHangHoa(String maCoSo, String maHangHoa, int soLuongNhap, double giaNhap) {
        String checkQuery = "SELECT SoLuong, GiaBan FROM HangHoaOCoSo WHERE MaHangHoa = ? AND MaCoSo = ?";
        String updateQuery = "UPDATE HangHoaOCoSo SET SoLuong = ?, GiaBan = ? WHERE MaHangHoa = ? AND MaCoSo = ?";
        String insertQuery = "INSERT INTO HangHoaOCoSo (MaCoSo, MaHangHoa, TrangThai, SoLuong, GiaBan) VALUES (?, ?, 'Khóa', ?, ?)";

        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);

            // Kiểm tra xem hàng hóa có tồn tại không
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setString(1, maHangHoa);
            checkStmt.setString(2, maCoSo);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                // Hàng hóa đã tồn tại, lấy thông tin cũ
                int soLuongCu = rs.getInt("SoLuong");
                double giaBanCu = rs.getDouble("GiaBan");

                if (soLuongCu == 0) {
                    // Nếu số lượng cũ bằng 0, cập nhật số lượng và giá mới
                    double giaMoi = giaNhap * 1.10;
                    PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                    updateStmt.setInt(1, soLuongNhap);
                    updateStmt.setDouble(2, giaMoi);
                    updateStmt.setString(3, maHangHoa);
                    updateStmt.setString(4, maCoSo);
                    updateStmt.executeUpdate();
                } else {
                    // Nếu số lượng cũ khác 0, cộng thêm số lượng và tính giá mới
                    int tongSoLuongMoi = soLuongCu + soLuongNhap;
                    double giaMoi = (giaBanCu + giaNhap * 1.10) / 2;
                    PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                    updateStmt.setInt(1, tongSoLuongMoi);
                    updateStmt.setDouble(2, giaMoi);
                    updateStmt.setString(3, maHangHoa);
                    updateStmt.setString(4, maCoSo);
                    updateStmt.executeUpdate();
                }
            } else {
                double giaMoi = giaNhap * 1.10;
                PreparedStatement insertStmt = con.prepareStatement(insertQuery);
                insertStmt.setString(1, maCoSo);
                insertStmt.setString(2, maHangHoa);
                insertStmt.setInt(3, soLuongNhap);
                insertStmt.setDouble(4, giaMoi);
                insertStmt.executeUpdate();
            }

            // Đóng tài nguyên
            rs.close();
            checkStmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}