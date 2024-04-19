package DAL;
import java.sql.*;
import java.util.ArrayList;

import DTO.DTOThongKeDonHang;
public class DataLamThongKe{
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataLamThongKe()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }
    public ArrayList<DTOThongKeDonHang> locLayDanhSach(String tenHangHoa, String tenCoSO, Date tuNgay, Date denNgay)
    {
        ArrayList<DTOThongKeDonHang> ds = new ArrayList<>();
        String truyVan;
        truyVan =   "SELECT TenLoaiHangHoa, COUNT(SoLuongHang), GiaNhap, GiaNhap * COUNT(SoLuongHang) AS DoanhThu "+
                    "FROM HangHoa, ChiTietHoaDon, HoaDon "+
                    "WHERE HangHoa.MaHangHoa = ChiTietHoaDon.MaHangHoa AND ChiTietHoaDon.MaHD = HoaDon.MaHD AND";
        truyVan += " NgayXuatHD > ? AND NgayXuatHD < ? AND";
        if(!tenHangHoa.equals("NULL")) truyVan += " TenLoaiHangHoa = ?";
        if(!tenCoSO.equals("NULL")) truyVan += " TenCoSo = ?";
        if (truyVan.endsWith(" AND"))  truyVan = truyVan.substring(0, truyVan.length() - 4);
        truyVan += " GROUP BY TenLoaiHangHoa, GiaNhap";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setDate(1, tuNgay);
            stmt.setDate(2, denNgay);
            int i = 3;
            if(!tenHangHoa.equals("NULL")) 
            {
                stmt.setString(i, tenHangHoa);
                i++;
            }
            if(!tenCoSO.equals("NULL")) stmt.setString(i, tenCoSO);
            ResultSet rs =stmt.executeQuery();
            while(rs.next())
            ds.add(new DTOThongKeDonHang(rs.getString("TenLoaiHangHoa"), rs.getInt("DoanhThu"), rs.getInt("COUNT(SoLuongHang)")));
        } catch (Exception e) {
            System.out.println(e);   
        }
        return ds;
    }
}