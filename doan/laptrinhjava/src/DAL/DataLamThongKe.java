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
    public ArrayList<DTOThongKeDonHang> locLayDanhSach(String tenHangHoa, String tenCoSO, String tuNgay, String denNgay)
    {
        ArrayList<DTOThongKeDonHang> ds = new ArrayList<>();
        String truyVan;
        truyVan =   "SELECT TenLoaiHangHoa, SUM(SoLuongHang) AS SL, GiaNhap, GiaNhap * SUM(SoLuongHang) AS DoanhThu "+
                    "FROM HangHoa, ChiTietHoaDon, HoaDon "+
                    "WHERE HangHoa.MaHangHoa = ChiTietHoaDon.MaHangHoa AND ChiTietHoaDon.MaHD = HoaDon.MaHD AND";
        truyVan += " NgayXuatHD > ? AND NgayXuatHD < ? AND";
        if(!tenHangHoa.equals("NULL")) truyVan += " TenLoaiHangHoa = ? AND";
        if(!tenCoSO.equals("NULL")) truyVan += " MaCoSo = ?";
        if (truyVan.endsWith(" AND"))  truyVan = truyVan.substring(0, truyVan.length() - 3);
        truyVan += "GROUP BY TenLoaiHangHoa, GiaNhap";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement stmt = con.prepareStatement(truyVan);
            stmt.setString(1, tuNgay);
            stmt.setString(2, denNgay);
            int i = 3;
            if(!tenHangHoa.equals("NULL")) 
            {
                stmt.setString(i, tenHangHoa);
                i++;
            }
            if(!tenCoSO.equals("NULL")) stmt.setString(i, tenCoSO);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            ds.add(new DTOThongKeDonHang(rs.getString("TenLoaiHangHoa"), rs.getInt("DoanhThu"), rs.getInt("SL")));
        } catch (Exception e) {
            System.out.println(e);   
        }
        return ds;
    }
}