package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTOdonNhap;

public class dataNhapHang {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public ArrayList<String> tenCot = new ArrayList<String>();
    
    public dataNhapHang(){
        try{
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }

    public ArrayList<DTOdonNhap> getDsDonNhapTheoTK(String maTK,String maCoSo) {
        ArrayList<DTOdonNhap> ds = new ArrayList<>();
        String truyVan = "select ct.MaPhieuNhap as MaPhieuNhap, RTRIM(HoTenNV) as HoTenNV, TenCoSo, NgayNhap, SUM(SoLuong * GiaNhap) as tongTien, TrangThai "+
                        "from PhieuNhap pn join NhanVien nv on pn.MaNV=nv.MaNV join ChiTietPhieuNhap ct on pn.MaPhieuNhap=ct.MaPhieuNhap join CoSo cs on nv.MaCoSo=cs.MaCoSo "+
                        "where IDTaiKhoan=? and cs.MaCoSo=? and TrangThai=N'Chưa duyệt'"+
                        "GROUP BY ct.MaPhieuNhap, HoTenNV, TenCoSo, NgayNhap, TrangThai;";
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maTK);
            pstmt.setString(2, maCoSo);
            ResultSet rs = pstmt.executeQuery();
            
            // Lấy dữ liệu từ ResultSet và thêm vào danh sách
            while (rs.next()) {
                ds.add(new DTOdonNhap(rs.getString("MaPhieuNhap"), 
                                    rs.getString("HoTenNV"),
                                    rs.getString("TenCoSo"),
                                   rs.getDate("NgayNhap"), 
                                   rs.getInt("tongTien"), 
                                   rs.getString("trangThai")));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Sử dụng e.printStackTrace() để in chi tiết lỗi
        }
        return ds;
    }

    public String getTenNVbyMaTK(String maTaiKhoan) {
        String hoTenNV = null;
        String query = "SELECT RTRIM(HoTenNV) as HoTenNV FROM nhanvien WHERE IDTaiKhoan = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { 
                hoTenNV = rs.getString("HoTenNV");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return hoTenNV;
    }

    public boolean xoaPhieuNhap(String maPhieuNhap) {
        PreparedStatement psDeleteChiTiet = null;
        PreparedStatement psDeletePhieuNhap = null;
    
        try {
            // Bắt đầu giao dịch
            con.setAutoCommit(false);
    
            // 1. Xóa chi tiết phiếu nhập liên quan
            String sqlDeleteChiTiet = "DELETE FROM ChiTietPhieuNhap WHERE MaPhieuNhap = ?";
            psDeleteChiTiet = con.prepareStatement(sqlDeleteChiTiet);
            psDeleteChiTiet.setString(1, maPhieuNhap);
            psDeleteChiTiet.executeUpdate();
    
            // 2. Xóa phiếu nhập
            String sqlDeletePhieuNhap = "DELETE FROM PhieuNhap WHERE MaPhieuNhap = ?";
            psDeletePhieuNhap = con.prepareStatement(sqlDeletePhieuNhap);
            psDeletePhieuNhap.setString(1, maPhieuNhap);
            psDeletePhieuNhap.executeUpdate();
    
            // Commit giao dịch nếu cả hai lệnh thành công
            con.commit();
            System.out.println("Phiếu nhập và chi tiết phiếu nhập đã được xóa thành công!");
            return true;  // Trả về true khi xóa thành công
    
        } catch (SQLException e) {
            // Rollback nếu có lỗi xảy ra
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;  // Trả về false nếu có lỗi xảy ra
        } finally {
            // Đóng PreparedStatement
            try {
                if (psDeleteChiTiet != null) psDeleteChiTiet.close();
                if (psDeletePhieuNhap != null) psDeletePhieuNhap.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<String> getDsHH() {
        ArrayList<String> ds = new ArrayList<>();
        String truyVan = "select TenLoaiHangHoa from hanghoa";
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement pstmt = con.prepareStatement(truyVan);
            ResultSet rs = pstmt.executeQuery();
            
            // Lấy dữ liệu từ ResultSet và thêm vào danh sách
            while (rs.next()) {
                ds.add(rs.getString("TenLoaiHangHoa"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Sử dụng e.printStackTrace() để in chi tiết lỗi
        }
        return ds;
    }
}
