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
                    double giaMoi = (giaBanCu*soLuongCu + giaNhap * 1.10 *soLuongNhap) / tongSoLuongMoi;
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

    public boolean insertChiTietPhieuNhap(String maPhieuNhap, String maHangHoa, int soLuong, int giaNhap) {
        String truyVan = "INSERT INTO ChiTietPhieuNhap (MaPhieuNhap, MaHangHoa, SoLuong, GiaNhap) VALUES (?, ?, ?, ?);";

        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maPhieuNhap);
            pstmt.setString(2, maHangHoa);
            pstmt.setInt(3, soLuong);
            pstmt.setInt(4, giaNhap);
            
            // Thực hiện câu lệnh INSERT
            int rowsAffected = pstmt.executeUpdate();
            
            // Kiểm tra xem có bản ghi nào được chèn không
            return rowsAffected > 0; // Trả về true nếu thành công, false nếu không
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Trả về false nếu có lỗi
        } finally {
            // Đóng các tài nguyên
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String insertNewDonNhap(String taiKhoan) {
        String maNV = getMaNVFromTaiKhoan(taiKhoan); // Lấy mã nhân viên từ tài khoản
        if (maNV == null) {
            System.out.println("Không tìm thấy mã nhân viên cho tài khoản: " + taiKhoan);
            return null; // Trả về null nếu không tìm thấy mã nhân viên
        }
    
        String maPhieuNhap = generateNewMaPhieuNhap(); 
        if (maPhieuNhap == null) {
            maPhieuNhap = "PN001"; // Nếu không có phiếu nào, khởi tạo mã phiếu nhập
        }
    
        String truyVan = "INSERT INTO [main].[dbo].[PhieuNhap] ([MaPhieuNhap], [TrangThai], [MaNV], [NgayNhap]) VALUES (?, N'Chưa duyệt', ?, GETDATE());";
    
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maPhieuNhap);
            pstmt.setString(2, maNV);
            
            // Thực hiện câu lệnh INSERT
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Thêm phiếu nhập thành công! Mã phiếu nhập: " + maPhieuNhap);
                return maPhieuNhap; // Trả về mã phiếu nhập mới
            } else {
                System.out.println("Không có bản ghi nào được thêm.");
                return null; // Trả về null nếu không có bản ghi nào được thêm
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi
        } finally {
            // Đóng các tài nguyên
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private String generateNewMaPhieuNhap() {
        String truyVan = "SELECT TOP 1 MaPhieuNhap FROM [main].[dbo].[PhieuNhap] ORDER BY MaPhieuNhap DESC";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String lastMaPhieuNhap = rs.getString("MaPhieuNhap");
                // Tạo mã mới (giả sử mã phiếu nhập có định dạng "PN" + số)
                int newMa = Integer.parseInt(lastMaPhieuNhap.substring(2)) + 1; // Giả sử mã bắt đầu từ PN001
                return "PN" + String.format("%03d", newMa); // Đảm bảo định dạng 3 chữ số
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
        
        return null; // Trả về null nếu không thể tạo mã mới
    }

    private String getMaNVFromTaiKhoan(String maTaiKhoan) {
        String truyVan = "SELECT maNV FROM NhanVien WHERE IDTaiKhoan = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maTaiKhoan);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("maNV"); // Trả về mã nhân viên
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
        
        return null; // Trả về null nếu không tìm thấy mã nhân viên
    }
    
    public String getMaHHFromTenLoaiHangHoa(String tenLoaiHangHoa) {
        String maHangHoa = null;
        String truyVan = "SELECT MaHangHoa FROM [main].[dbo].[HangHoa] WHERE TenLoaiHangHoa = ?";
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, tenLoaiHangHoa);
            
            // Thực hiện truy vấn
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                maHangHoa = rs.getString("MaHangHoa");
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
        return maHangHoa;
    }

    public boolean deleteChiTietPhieuNhap(String maPhieuNhap, String maHangHoa) {
        String truyVan = "DELETE FROM [main].[dbo].[ChiTietPhieuNhap] WHERE MaPhieuNhap = ? AND MaHangHoa = ?";
    
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maPhieuNhap);
            pstmt.setString(2, maHangHoa);
            
            // Thực hiện câu lệnh DELETE
            int rowsAffected = pstmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean updateChiTietPhieuNhap(String maPhieuNhap, String maHangHoa, int soLuong, int giaNhap) {
        String truyVan = "UPDATE [main].[dbo].[ChiTietPhieuNhap] SET SoLuong = ?, GiaNhap = ? WHERE MaPhieuNhap = ? AND MaHangHoa = ?";
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            
            // Thiết lập các giá trị cho PreparedStatement
            pstmt.setInt(1, soLuong);
            pstmt.setInt(2, giaNhap);
            pstmt.setString(3, maPhieuNhap);
            pstmt.setString(4, maHangHoa);
            
            // Thực hiện câu lệnh UPDATE
            int rowsAffected = pstmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Boolean checkHangHoa(String maPhieuNhap,String maHangHoa) {
        String truyVan = "SELECT maPhieuNhap, maHangHoa from chitietphieunhap where maPhieuNhap=? and maHangHoa=? ";
    
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DriverManager.getConnection(dbUrl, userName, password);
            pstmt = con.prepareStatement(truyVan);
            pstmt.setString(1, maPhieuNhap);
            pstmt.setString(2, maHangHoa);
            // Thực hiện truy vấn
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return true;
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
        return false;
    }
}