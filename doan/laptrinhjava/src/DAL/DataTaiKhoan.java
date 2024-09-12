package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTOTaiKhoan;
import DTO.HoiVien;
import DTO.NhanVien;
import DTO.dsHoiVien;

public class DataTaiKhoan {
	private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public ArrayList<String> tenCot = new ArrayList<String>();
	public String taoMaTaiKhoanMoi() {
        try {
            // Tìm mã tài khoản lớn nhất
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(IDTaiKhoan) AS MaxMaTK FROM TaiKhoan");

            // Lấy mã lớn nhất
            String maxMaTK = "TK001";
            if (rs.next()) {
                String maxMaTKFromDB = rs.getString("MaxMaTK");
                if (maxMaTKFromDB != null) {
                    int nextMaTK = Integer.parseInt(maxMaTKFromDB.substring(2)) + 1;
                    String newMaTK;
                    boolean unique = false;
                    while (!unique) {
                    	newMaTK = String.format("TK%03d", nextMaTK);
                        // Kiểm tra xem mã mới có duy nhất không
                        if (!kiemTraTonTaiMaTK(newMaTK)) {
                        	maxMaTK = newMaTK;
                            unique = true;
                        }
                        nextMaTK++;
                    }
                }
            }
            return maxMaTK;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
	private boolean kiemTraTonTaiMaTK(String maTK) {
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS Count FROM TaiKhoan WHERE IDTaiKhoan = ?");
            ps.setString(1, maTK);
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
	public ArrayList<String> layDanhSachMaTKHV() {
        ArrayList<String> ds = new ArrayList<>();
        String query = "SELECT IDTaiKhoan From TaiKhoan TK WHERE TK.TaiKhoan LIKE 'TKHV%'";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(rs.getString("IDTaiKhoan"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
	//lấy danh sách tài khoản hội viên
	public ArrayList<DTOTaiKhoan> layDanhSachTKHV() {
		ArrayList<DTOTaiKhoan> ds = new ArrayList<DTOTaiKhoan>();
        String query = "SELECT IDTaiKhoan, TaiKhoan, MatKhau From TaiKhoan TK WHERE TK.IDQuyen = 'Q0001'";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(new DTOTaiKhoan(rs.getString(1),rs.getString(2),rs.getString(3),"Q0001"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
	
	//lấy danh sách tài khoan nhân viên
	public ArrayList<DTOTaiKhoan> layDanhSachTKNV() {
		ArrayList<DTOTaiKhoan> ds = new ArrayList<DTOTaiKhoan>();
        String query = "SELECT IDTaiKhoan, TaiKhoan, MatKhau, Quyen.IDQuyen From TaiKhoan TK, Quyen WHERE TK.IDQuyen = Quyen.IDQuyen AND (Quyen.IDQuyen = 'Q0002' OR Quyen.IDQUYEN = 'Q0003')";
        try {
        	con = DriverManager.getConnection(dbUrl, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
            	ds.add(new DTOTaiKhoan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
	
	//thêm tài khoản
	public boolean themTK(DTOTaiKhoan TK) // test rồi
    {
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            String sql = "INSERT INTO TaiKhoan (IDTaiKhoan, TaiKhoan, MatKhau, IDQuyen) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, TK.getIDTaiKhoan());
            preparedStatement.setString(2, TK.getTaiKhoan());
            preparedStatement.setString(3, TK.getMatKhau());
            preparedStatement.setString(4, TK.getIDQuyen());
            if (preparedStatement.executeUpdate() > 0)  return true;
        } catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
	//xóa tài khoản
	public boolean xoa(String maTK) //test thành công
    {
        //trả về 1 xóa thành công, 0 xóa thất bại do dữ liệu nhập không có trong database
        String truyVan = "DELETE FROM TaiKhoan Where IDTaiKhoan = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maTK);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
	//sửa thông tin tài khoản
	public boolean sua(DTOTaiKhoan a) //test rồi
    {
        //trả về 1 sửa thành công, 0 thất bại
        String truyVan = "UPDATE TaiKhoan SET TaiKhoan = ?, MatKhau = ? FROM TaiKhoan Where IDTaiKhoan = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, a.getTaiKhoan());
            statement.setString(2, a.getMatKhau());
            statement.setString(3, a.getIDTaiKhoan());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
	//tìm kiếm tài khoản
	public ArrayList<DTOTaiKhoan> timKiemTKHV(HoiVien a)
    {
        ArrayList<String> ds = new ArrayList<String>();
        ArrayList<DTOTaiKhoan> dsTK = new ArrayList<DTOTaiKhoan>();
        String truyVan = "SELECT * FROM TaiKhoan TK, HoiVien Where HoiVien.IDTaiKhoan = TK.IDTaiKhoan AND ";
        if(!a.getMaHoiVien().equals(""))
        {
            truyVan+= "HoiVien.MaHV = ? AND ";
            ds.add(a.getMaHoiVien());
        } 
        if(!a.getGioitinh().equals(""))
        {
            truyVan+="HoiVien.GioiTinh = ? AND ";
            ds.add(a.getGioitinh());
        } 
        if(!a.getSdt().equals(""))
        {
            truyVan+="HoiVien.SoDienThoai = ? ";
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
            	dsTK.add(new DTOTaiKhoan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return dsTK;
    }
    public String KiemTraDangNhap(String taiKhoan, String matKhau) 
    {
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TaiKhoan Where TaiKhoan ='"+ taiKhoan +"'");
            if(rs.next())
            {
                if(rs.getString("MatKhau").trim().equals(matKhau)) 
                {
                    return rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
                }
                else return "Sai mật khẩu";
            }
            else return "Tài khoản không tồn tại"; 
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "Lỗi mở database";
    }
}
