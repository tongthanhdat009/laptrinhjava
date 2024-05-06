package DAL;

import java.sql.*;
import java.util.ArrayList;

import DTO.dsHangHoa;
import DTO.hangHoa;

public class DataHangHoa {
    private Connection con;
    private String dbUrl ="jdbc:sqlserver://localhost:1433;databaseName=main;encrypt=true;trustServerCertificate=true;";
    private String userName = "sa"; String password= "123456";
    public ArrayList<String> tenCot = new ArrayList<String>();
    public dsHangHoa ds = new dsHangHoa();
    public DataHangHoa()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println(e);   
        }
    }

    // lấy danh sách hàng hóa
    public dsHangHoa layDanhSachHangHoa(){
        try{
            Connection con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt= con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HangHoa");
            while(rs.next()){
                hangHoa hh = new hangHoa();
                hh.setMaHangHoa(rs.getString("MaHangHoa"));
                hh.setLoaiHangHoa(rs.getString("LoaiHangHoa"));
                hh.setTenLoaiHangHoa(rs.getString("TenLoaiHangHoa"));
                hh.setHinhAnh(rs.getString("HinhAnh"));
                hh.setGiaNhap(rs.getLong("GiaNhap"));
                ds.them(hh);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ds;
    }
    
    public ArrayList<String> getTenCot(){
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HangHoa");
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i=1; i<=rsmd.getColumnCount();i++){
                this.tenCot.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this.tenCot; 
    }

    //xóa hàng hóa
    public boolean xoaHangHoa(String maHH) //test thành công
    {
        String truyVan = "DELETE FROM HangHoa Where MaHangHoa = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maHH);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //thêm hàng hóa
    public boolean themHangHoa(hangHoa hh){
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            String sql = "INSERT INTO HangHoa (MaHangHoa,LoaiHangHoa,TenLoaiHangHoa,HinhAnh,GiaNhap) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,hh.getMaHangHoa());            
            preparedStatement.setString(2,hh.getLoaiHangHoa());            
            preparedStatement.setString(3,hh.getTenLoaiHangHoa());            
            preparedStatement.setString(4,hh.getHinhAnh());            
            preparedStatement.setLong(5,hh.getGiaNhap());            
            if (preparedStatement.executeUpdate() > 0)  return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public int layMaHangHoaMoi(){
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MaHangHoa FROM HangHoa");
            int max = 0;
            while(rs.next()){
                String maHH = rs.getString("MaHangHoa");
                maHH = maHH.substring(2);
                if(Integer.parseInt(maHH) > max){
                    max = Integer.parseInt(maHH);
                }
            }
            return max;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }


    //sửa hàng hóa
    public boolean suaHangHoa(hangHoa hh){

        try (Connection con = DriverManager.getConnection(dbUrl, userName, password)) {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE HangHoa SET MaHangHoa = ?, LoaiHangHoa = ?, TenLoaiHangHoa= ?, HinhAnh = ?, GiaNhap = ? WHERE MaHangHoa = ?");
            preparedStatement.setString(1, hh.getMaHangHoa());
            preparedStatement.setString(2, hh.getLoaiHangHoa());
            preparedStatement.setString(3, hh.getTenLoaiHangHoa());
            preparedStatement.setString(4, hh.getHinhAnh());
            preparedStatement.setLong(5, hh.getGiaNhap());
            preparedStatement.setString(6, hh.getMaHangHoa());
            if(preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }   
    public boolean timKiemHH(String maHH) //test rồi
    {
        String truyVan = "SELECT * FROM HangHoa Where MaHangHoa = ?";
        if(maHH.equals("")){
            return false;
        }
        try{
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maHH);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }    
    //tìm kiếm hàng hóa

}
