package DAL;

import java.sql.*;

import javax.swing.JOptionPane;

import DTO.dsHangHoa;
import DTO.hangHoa;

public class DataHangHoa {
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public DataHangHoa()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }

    //xóa hàng hóa
    public boolean xoaHangHoa(String MaHangHoa) throws SQLException{
        Connection con = DriverManager.getConnection(dbUrl, userName, password);
        Statement stmt= con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MaHangHoa FROM HangHoa");
        while(rs.next()){
            if(MaHangHoa.equals(rs.getString("MaHangHoa"))){
                stmt.executeUpdate("DELETE FROM HangHoa WHERE MaHangHoa = '"+MaHangHoa+"'");
                return true;
            }
            else 
                return false;

        }
        return false;
    }

    //thêm hàng hóa
    public boolean themHangHoa(String LoaiHangHoa, String TenLoaiHangHoa, String HinhAnh, int GiaNhap) throws SQLException{
        Connection con = DriverManager.getConnection(dbUrl, userName, password);
        Statement stmt= con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MaHangHoa FROM HangHoa");
        String MaHangHoa;
        int max = 0;
        while(rs.next()){
            String ma = rs.getString("MaHangHoa");
            String maMoi = ma.substring(2, 5);
            int maMoiInt = Integer.parseInt(maMoi);
            if(maMoiInt > max){
                max = maMoiInt;
            }
        }
        max++;
        MaHangHoa = "HH" + max;
        if(LoaiHangHoa.equals("")){
            LoaiHangHoa = null;
        }
        if(TenLoaiHangHoa.equals("")){
            TenLoaiHangHoa = null;
        }
        if(HinhAnh.equals("")) {
            HinhAnh = "doan/src/laptrinhjava/src/asset/img/hanghoa/default-product.jpg";
        }
        if(GiaNhap == 0){
            GiaNhap = 0;
        }
        stmt.executeUpdate("INSERT INTO HangHoa VALUES ('"+MaHangHoa+"', N'"+LoaiHangHoa+"', N'"+TenLoaiHangHoa+"', '"+HinhAnh+"', "+GiaNhap+")");
        return true;
    }
    
    //sửa hàng hóa
    public boolean suaHangHoa(String MaHangHoa, String LoaiHangHoa, String TenLoaiHangHoa, String HinhAnh, int GiaNhap) throws SQLException{
        Connection con = DriverManager.getConnection(dbUrl, userName, password);
        PreparedStatement preparedStatement = con.prepareStatement("UPDATE HangHoa SET LoaiHangHoa = ?, TenLoaiHangHoa = ?, HinhAnh = ?, GiaNhap = ? WHERE MaHangHoa = ?");
        preparedStatement.setString(1, LoaiHangHoa);
        preparedStatement.setString(2, TenLoaiHangHoa);
        preparedStatement.setString(3, HinhAnh);
        preparedStatement.setInt(4, GiaNhap);
        preparedStatement.setString(5, MaHangHoa);
        if(preparedStatement.executeUpdate() > 0) return true;
        return false;
    }   

    // lấy danh sách hàng hóa
    public dsHangHoa layDanhSachHangHoa() throws SQLException{
        Connection con = DriverManager.getConnection(dbUrl, userName, password);
        Statement stmt= con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM HangHoa");
        dsHangHoa ds = new dsHangHoa();
        while(rs.next()){
            hangHoa hh = new hangHoa();
            hh.setMaHangHoa(rs.getString("MaHangHoa"));
            hh.setLoaiHangHoa(rs.getString("LoaiHangHoa"));
            hh.setTenHangHoa(rs.getString("TenLoaiHangHoa"));
            hh.setHinhAnh(rs.getString("HinhAnh"));
            hh.setGiaNhap(rs.getInt("GiaNhap"));
            ds.them(hh);
        }
        return ds;
    }
    //tìm kiếm hàng hóa
    public timKiemHangHoa(hangHoa hh){
        Connection con = DriverManager.getConnection(dbUrl, userName, password);
        Statement stmt= con.createStatement();
        String sql = "SELECT * FROM HangHoa WHERE ";
        ResultSet rs = stmt.executeQuery(sql);

        if(!(hh.getMaHangHoa().equals("NULL"))){
            sql += "MaHangHoa = ? AND ";
        }
        if(!(hh.getLoaiHangHoa().equals("NULL"))){
            sql += "LoaiHangHoa = ? AND ";
        }
        if (!(hh.getTenHangHoa().equals("NULL"))){
            sql += "TenLoaiHangHoa = ? AND ";{
        }
        if(!(hh.get))

        
    }
    public static void main(String[] args){
        DataHangHoa dataHangHoa = new DataHangHoa();
        try {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
