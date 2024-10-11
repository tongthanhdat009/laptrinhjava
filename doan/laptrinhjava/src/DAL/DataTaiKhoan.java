package DAL;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CoSo;
import DTO.DSCoSo;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;
import DTO.NhanVien;

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
	
//	kiểm tra mã đã có chưa
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
	
	//lấy danh sách mã tài khoản hội viên
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
            	ds.add(new DTOTaiKhoan(rs.getString(1),rs.getString(2),rs.getString(3),"Q0001","OFF"));
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
            	ds.add(new DTOTaiKhoan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
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
            String sql = "INSERT INTO TaiKhoan (IDTaiKhoan, TaiKhoan, MatKhau, IDQuyen, Status) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, TK.getIDTaiKhoan());
            preparedStatement.setString(2, TK.getTaiKhoan());
            preparedStatement.setString(3, TK.getMatKhau());
            preparedStatement.setString(4, TK.getIDQuyen());
            preparedStatement.setString(5, TK.getStatus());
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
	
	//tìm kiếm tài khoản tài khoản hội viên
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
            	dsTK.add(new DTOTaiKhoan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return dsTK;
    }
	
	//tìm kiếm tài khoản nhân viên
	public ArrayList<DTOTaiKhoan> timKiemTKNV(NhanVien a)
    {
        ArrayList<String> ds = new ArrayList<String>();
        ArrayList<DTOTaiKhoan> dsTK = new ArrayList<DTOTaiKhoan>();
        String truyVan = "SELECT TK.IDTaiKhoan, TK.TaiKhoan, TK.MatKhau, TK.IDQuyen FROM TaiKhoan TK, NhanVien Where NhanVien.IDTaiKhoan = TK.IDTaiKhoan AND ";
        if(!a.getMaNhanVien().equals(""))
        {
            truyVan+= "NhanVien.MaNV = ? AND ";
            ds.add(a.getMaNhanVien());
        } 
        if(!a.getGioitinh().equals(""))
        {
            truyVan+="NhanVien.GioiTinh = ? AND ";
            ds.add(a.getGioitinh());
        }
        if(!a.getVaitro().equals(""))
        {
            truyVan+="NhanVien.VaiTro = ? AND ";
            ds.add(a.getVaitro());
        }
        if(!a.getSdt().equals(""))
        {
            truyVan+="NhanVien.SoDienThoai = ? AND ";
            ds.add(a.getSdt());
        }
        if(!a.getMacoso().equals(""))
        {
            truyVan+="NhanVien.MaCoSo = ?";
            ds.add(a.getMacoso());
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
            	dsTK.add(new DTOTaiKhoan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return dsTK;
    }
	
	//kiểm tra đăng nhập
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
    
    public DSCoSo layDSCoSo()
    {
        String truyVan = "SELECT * FROM CoSo";
        DSCoSo ds = new DSCoSo();
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            ds.them(new CoSo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    
    //kiểm tra tài khoản có thuộc cơ sở không
    public boolean kiemTraTaiKhoanCoSo(DTOTaiKhoan tk, String maCoSo) {
        String truyVan = "SELECT * FROM NhanVien nv, TaiKhoan tk WHERE nv.IDTaiKhoan = tk.IDTaiKhoan AND nv.MaCoSo = ? AND tk.IDTaiKhoan = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maCoSo.trim());
            statement.setString(2, tk.getIDTaiKhoan().trim());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true; // Có kết quả trả về, tài khoản tồn tại
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    //thông tin người dùng hiện tại theo mã quyền hội viên
    public HoiVien thongTinCaNhan(DTOTaiKhoan tk) {
    	   String truyVan = "SELECT hv.*, tk.TaiKhoan, tk.MatKhau From TaiKhoan tk, HoiVien hv WHERE hv.IDTaiKhoan = tk.IDTaiKhoan AND tk.IDTaiKhoan = '"+tk.getIDTaiKhoan()+"'";
    	   try {
               con = DriverManager.getConnection(dbUrl, userName, password);
               Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(truyVan);
               if (rs.next()) {
            	   return new HoiVien(rs.getString(1), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getDate(5), rs.getString(6),rs.getString(7),rs.getString(8));
               }
//               while(rs.next())
//               ds.them(new CoSo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
           } catch (Exception e) {
               System.out.println(e);
           }
           return null;
    }
    
    //đổi mật khẩu một tài khoản
	public boolean doiMatKhauTaiKhoan(DTOTaiKhoan a, String newPass) {
        //trả về 1 sửa thành công, 0 thất bại
        String truyVan = "UPDATE TaiKhoan SET MatKhau = ? FROM TaiKhoan Where IDTaiKhoan = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, newPass);
            statement.setString(2, a.getIDTaiKhoan());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
//	cập nhật ảnh cho tài khoản hội viên
	public boolean thayAnh(DTOTaiKhoan tk, Path anhMoi) {
		//trả về 1 sửa thành công, 0 thất bại
        String truyVan = "UPDATE HoiVien SET Anh = ? FROM HoiVien Where IDTaiKhoan = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, anhMoi.toString());
            statement.setString(2, tk.getIDTaiKhoan());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;	
    }

	//kiểm tra trùng lập tài khoản khi hội viên tự đăng ký hoặc khi sử dụng chức năng thêm hội viên hoặc nhân viên
	public boolean kiemTraTrungLapTK(String tenTK) {
		String truyVan ="SELECT COUNT(*) FROM TaiKhoan WHERE TaiKhoan = '"+tenTK+"';";
		int count = 0;
		try {
			con = DriverManager.getConnection(dbUrl,userName,password);
			Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);		
            while (rs.next()) {
            	count = rs.getInt(1);
			}
            if(count > 0) {
            	return false;
            }
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return true;
	}

	//kiểm tra trùng lập tài khoản khi sử dụng chức năng sửa thông tin hội viên hoặc nhân viên
	public boolean kiemTraTrungLapTKVoiTKDaTonTai(String tenTK, String iDTaiKhoan) {
		String truyVan ="SELECT COUNT(*) FROM TaiKhoan WHERE TaiKhoan = '"+tenTK+"' AND IDTaiKhoan = '"+iDTaiKhoan+"'";
		int count = 0;
		try {
			con = DriverManager.getConnection(dbUrl,userName,password);
			Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);		
            while (rs.next()) {
            	count = rs.getInt(1);
			}
            if(count > 1) {
            	return false;
            }
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return true;
	}

    public boolean phienDangNhapTK(DTOTaiKhoan taiKhoan){
        String truyVan = "SELECT * FROM TaiKhoan Where IDTaiKhoan = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, taiKhoan.getIDTaiKhoan());
            ResultSet rs = statement.executeQuery();
            if(rs.getString("Status").trim().equals("OFF")){
                return true; // có thể đăng nhập
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false; // tài khoản đã được đăng nhập ở một nơi khác
    }
}
