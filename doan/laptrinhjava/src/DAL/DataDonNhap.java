package DAL;
import java.sql.*;
import java.util.ArrayList;

import DTO.DonNhap;

public class DataDonNhap {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataDonNhap(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }

    public ArrayList<DonNhap> layDSDonNhapTheoCoSo(String maCoSo) {
        ArrayList<DonNhap> ds = new ArrayList<>();
        // Câu lệnh SQL với điều kiện sắp xếp
        String truyVan = "SELECT pn.MaPhieuNhap, " +
                         "       RTRIM(pn.TrangThai) AS TrangThai, " +
                         "       pn.MaNV, " +
                         "       pn.NgayNhap " +
                         "FROM PhieuNhap pn " +
                         "JOIN NhanVien nv ON pn.MaNV = nv.MaNV " +
                         "JOIN CoSo cs ON cs.MaCoSo = nv.MaCoSo " +
                         "WHERE cs.MaCoSo = ? " +
                         "ORDER BY CASE " +
                         "             WHEN RTRIM(pn.TrangThai) = N'Chưa Duyệt' THEN 1 " +
                         "             ELSE 2 " +
                         "           END, " +
                         "         pn.NgayNhap DESC";
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maCoSo);
            ResultSet rs = pstmt.executeQuery();
            
            // Lấy dữ liệu từ ResultSet và thêm vào danh sách
            while (rs.next()) {
                ds.add(new DonNhap(rs.getString("MaPhieuNhap"), 
                                   rs.getString("TrangThai"), 
                                   rs.getString("MaNV"), 
                                   rs.getDate("NgayNhap")));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Sử dụng e.printStackTrace() để in chi tiết lỗi
        }
        return ds;
    }

    public ArrayList<DonNhap> searchTheoTen(String maCoSo, String tenNhanVien) {
        ArrayList<DonNhap> ds = new ArrayList<>();
        String query = "SELECT pn.MaPhieuNhap, RTRIM(pn.TrangThai) AS TrangThai, pn.MaNV, pn.NgayNhap " +
                       "FROM PhieuNhap pn " +
                       "JOIN NhanVien nv ON pn.MaNV = nv.MaNV " +
                       "JOIN CoSo cs ON cs.MaCoSo = nv.MaCoSo " +
                       "WHERE cs.MaCoSo = ? AND nv.HoTenNV LIKE ? " +
                       "ORDER BY CASE " +
                       "             WHEN RTRIM(pn.TrangThai) = N'Chưa Duyệt' THEN 1 " +
                       "             ELSE 2 " +
                       "           END, " +
                       "         pn.NgayNhap DESC";
        try (Connection con = DriverManager.getConnection(dbUrl, userName, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
    
            pstmt.setString(1, maCoSo);
            pstmt.setString(2, "%" + tenNhanVien + "%");
    
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ds.add(new DonNhap(rs.getString("MaPhieuNhap"), 
                                       rs.getString("TrangThai"), 
                                       rs.getString("MaNV"), 
                                       rs.getDate("NgayNhap")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public void capNhatTrangThai(String maPhieuNhap, String trangThaiMoi) {
        String truyVan = "UPDATE PhieuNhap SET TrangThai = ? WHERE MaPhieuNhap = ?";
        try (Connection con = DriverManager.getConnection(dbUrl, userName, password);
             PreparedStatement pstmt = con.prepareStatement(truyVan)) {
            pstmt.setString(1, trangThaiMoi);
            pstmt.setString(2, maPhieuNhap);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DonNhap> searchTheoTenVaTrangThai(String maCoSo, String tenNhanVien, String trangThai) {
        ArrayList<DonNhap> ds = new ArrayList<>();
        String query = "SELECT pn.MaPhieuNhap, RTRIM(pn.TrangThai) AS TrangThai, pn.MaNV, pn.NgayNhap " +
                       "FROM PhieuNhap pn " +
                       "JOIN NhanVien nv ON pn.MaNV = nv.MaNV " +
                       "JOIN CoSo cs ON cs.MaCoSo = nv.MaCoSo " +
                       "WHERE cs.MaCoSo = ? AND nv.HoTenNV LIKE ? AND pn.TrangThai = ? " +
                       "ORDER BY CASE " +
                       "             WHEN RTRIM(pn.TrangThai) = N'Chưa Duyệt' THEN 1 " +
                       "             ELSE 2 " +
                       "           END, " +
                       "         pn.NgayNhap DESC";
        try (Connection con = DriverManager.getConnection(dbUrl, userName, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {
    
            pstmt.setString(1, maCoSo);
            pstmt.setString(2, "%" + tenNhanVien + "%");
            pstmt.setString(3, trangThai);
    
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ds.add(new DonNhap(rs.getString("MaPhieuNhap"), 
                                       rs.getString("TrangThai"), 
                                       rs.getString("MaNV"), 
                                       rs.getDate("NgayNhap")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}
