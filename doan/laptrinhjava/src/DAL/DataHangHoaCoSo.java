package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.hangHoaCoSo;

public class DataHangHoaCoSo{
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public ArrayList<String> tenCot = new ArrayList<String>();
    
    public DataHangHoaCoSo()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public ArrayList<hangHoaCoSo> layDanhSachHangHoaCoSo()
    {
        ArrayList<hangHoaCoSo> dsHHCS = new ArrayList<hangHoaCoSo>();
        String truyVan = "SELECT * FROM HangHoaOCoSo, HangHoa WHERE HangHoa.MaHangHoa = HangHoaOCoSo.MaHangHoa";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            dsHHCS.add(new hangHoaCoSo(rs.getString("MaCoSo"),
                                    rs.getString("MaHangHoa"),
                                    rs.getString("TrangThai"),
                                    rs.getInt("Soluong"),
                                    rs.getInt("GiaBan"),
                                    rs.getString("Loai"),
                                    rs.getString("TenLoaiHangHoa"),
                                    rs.getString("HinhAnh")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return dsHHCS;
    }

    public boolean sua(hangHoaCoSo a)
    {
        //trả về 1 sửa thành công, 0 thất bại
        String truyVan = "UPDATE HangHoaOCoSo SET MaCoSo = ?, SoLuong = ?, MaHangHoa = ? FROM HangHoaOCoSo Where MaCoSo = ? AND MaHangHoa = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, a.getMaCoSo());
            statement.setInt(2, a.getSoLuong());
            statement.setString(3, a.getMaHangHoa());
            statement.setString(4, a.getMaCoSo());
            statement.setString(5, a.getMaHangHoa());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean xoa(String maCoSo, String maHangHoa)
    {
        //trả về 1 xóa thành công, 0 xóa thất bại do dữ liệu nhập không có trong database
        String truyVan = "DELETE FROM hangHoaOCoSo Where MaCoSo = ? AND MaHangHoa = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maCoSo);
            statement.setString(2, maHangHoa);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<hangHoaCoSo> timKiem(String maCoSo, String maHangHoa, String trangThai)
    {	
        String truyVan = "SELECT * FROM HangHoa, HangHoaOCoSo WHERE HangHoa.MaHangHoa = HangHoaOCoSo.MaHangHoa AND";
        ArrayList<String> s = new ArrayList<>();
        ArrayList<hangHoaCoSo> ds = new ArrayList<>();
        if(!maCoSo.equals("NULL"))
        {
            truyVan+=" MaCoSo = ? AND";
            s.add(maCoSo);
        }
        if(!trangThai.equals("NULL")) {
        	truyVan+=" HangHoaOCoSo.TrangThai = N'"+trangThai+"' AND";
        }
        if(!maHangHoa.equals("NULL"))
        {
            truyVan+=" HangHoa.MaHangHoa = ? AND";
            s.add(maHangHoa);
        }
      	
        if(truyVan.endsWith(" AND")) truyVan = truyVan.substring(0, truyVan.length()-4);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            for(int i=1;i<=s.size();i++)
            stmt.setString(i,s.get(i-1));
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            	ds.add(new hangHoaCoSo(rs.getString("MaCoSo"),
                        rs.getString("MaHangHoa"),
                        rs.getString("TrangThai"),
                        rs.getInt("Soluong"),
                        rs.getInt("GiaBan"),
                        rs.getString("Loai"),
                        rs.getString("TenLoaiHangHoa"),
                        rs.getString("HinhAnh")));
        } catch (Exception e) {
            System.out.println(e);   
        }
        return ds;
    }
    public boolean them(hangHoaCoSo hhcs)
    {
        String truyVan = "INSERT INTO HangHoaOCoSo (MaCoSo, SoLuong, MaHangHoa) VALUES (?, ?, ?)";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, hhcs.getMaCoSo());
            stmt.setInt(2,hhcs.getSoLuong());
            stmt.setString(3,hhcs.getMaHangHoa());
            if(stmt.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);   
        }
        return false;
    }

}
