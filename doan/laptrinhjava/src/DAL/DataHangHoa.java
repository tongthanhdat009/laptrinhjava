package DAL;

import java.sql.*;
import java.util.ArrayList;
import DTO.ThongTinChiTietHangHoa;
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
            preparedStatement.setString(1, hh.getMaHangHoa().toUpperCase());
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
    
    public dsHangHoa timKiem(hangHoa a) //Chưa test
    {
        ArrayList<String> ds = new ArrayList<String>();
        dsHangHoa dsHH = new dsHangHoa();
        String truyVan = "SELECT * FROM HangHoa Where ";
        if(!a.getMaHangHoa().equals(""))
        {
            truyVan+= "MaHangHoa = ? AND ";
            ds.add(a.getMaHangHoa());
        } 
        if(!a.getLoaiHangHoa().equals(""))
        {
            truyVan+="LoaiHangHoa = ? AND ";
            ds.add(a.getLoaiHangHoa());
        } 
        if(!a.getTenLoaiHangHoa().equals(""))
        {
            truyVan+="TenLoaiHangHoa = ? AND ";
            ds.add(a.getTenLoaiHangHoa());
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
                dsHH.them(new hangHoa(rs.getString(1),rs.getString(2),rs.getString(3),"",0));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return dsHH;
    }
    public ArrayList<ThongTinChiTietHangHoa> layDSBanHang(String maCoSo)
    {
        ArrayList<ThongTinChiTietHangHoa> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HangHoaOCoSo, HangHoa WHERE HangHoaOCoSo.MaHangHoa = HangHoa.MaHangHoa AND TrangThai = 'Đang bán' AND MaCoSo = '"+maCoSo+"'";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            ds.add(new ThongTinChiTietHangHoa(rs.getString("MaHangHoa"), rs.getString("TenLoaiHangHoa"), rs.getInt("GiaBan"), rs.getString("MaCoSo"),rs.getString("HinhAnh"),rs.getInt("SoLuong")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public String timLoai(String maHangHoa)
    {
        String truyVan = "SELECT Loai FROM HangHoa WHERE MaHangHoa = '"+maHangHoa+"'";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            if(rs.next())
            return rs.getString(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "error";
    }
    public String timThongTinChiTietHangHoa(String maHangHoa, String maCoSo)
    {
        String maLoai = timLoai(maHangHoa);
        String thongTin="";
        String truyVan;
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            if(maLoai.equals("Ta"))
            truyVan = "SELECT * FROM "+maLoai+",HangHoa, HangHoaOCoSo, CoSo WHERE HangHoa.MaHangHoa = ? AND CoSo.MaCoSo = ? AND HangHoaOCoSo.MaCoSo = CoSo.MaCoSo";
            else truyVan = "SELECT * FROM HangHoa, HangHoaOCoSo, CoSo WHERE HangHoa.MaHangHoa = ? AND CoSo.MaCoSo = ? AND HangHoaOCoSo.MaCoSo = CoSo.MaCoSo";
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maHangHoa);
            statement.setString(2, maCoSo);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                thongTin+=rs.getString("TenLoaiHangHoa")+"\n";
                thongTin +="Tên cơ sở: "+rs.getString("TenCoSo")+"\n";
                if(maLoai.equals("Ta")) {
                    thongTin += "Loại: Tạ\n";
                    thongTin+="Còn: "+rs.getInt("SoLuong")+" quả\n";
                    thongTin+="Khối lượng: "+rs.getInt("KhoiLuong")+"kg\n";
                    thongTin+="Chất liệu: "+rs.getString("ChatLieu")+"\n";
                    thongTin+="Màu sắc: "+rs.getString("MauSac")+"\n";
                }
                else if(maLoai.equals("MayChay")){
                    thongTin += "Loại: Máy chạy";
                    thongTin+="Còn: "+rs.getInt("SoLuong")+" Máy\n";
                    thongTin+="Công suất: "+rs.getInt("CongSuat")+"w\n";
                    thongTin+="Tốc độ tối đa: "+rs.getInt("TocDoToiDa")+"km/h\n";
                    thongTin+="Nhà sản xuất: "+rs.getString("NhaSanXuat")+"\n";
                    thongTin+="Kích thước: "+rs.getString("KichThuoc")+"\n";
                }
                else if(maLoai.equals("Xa")) {
                    thongTin += "Loại: Xà";
                    thongTin+="Còn: "+rs.getInt("SoLuong")+" Thiết bị";
                    thongTin+="Kiểu: "+rs.getString("LoaiXa")+"\n";
                    thongTin+="Chất liệu: "+rs.getString("ChatLieu")+"\n";
                    thongTin+="Chiều dài: "+rs.getInt("ChieuDai")+"cm\n";
                    thongTin+="Đường kính: "+rs.getInt("DuongKinh")+"cm\n";
                    thongTin+="Chiều cao: "+rs.getInt("ChieuCao")+"cm\n";
                    thongTin+="Tải trọng: "+rs.getInt("KichThuoc")+"kg\n";
                }
                else thongTin+="Còn: "+rs.getInt("SoLuong")+" Thiết bị\n";
                thongTin+="Giá: "+rs.getString("GiaBan")+"";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return thongTin;
    }
    public ArrayList<ThongTinChiTietHangHoa> timDSHangBan(String ten, String maCoSo, String loai)
    {
        ArrayList<ThongTinChiTietHangHoa> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM HangHoaOCoSo, HangHoa WHERE HangHoaOCoSo.MaHangHoa = HangHoa.MaHangHoa AND TrangThai = 'Đang bán'";
        ArrayList<String> s = new ArrayList<>();
        if(!ten.equals("NULL")) {
            truyVan+=" AND TenLoaiHangHoa = ?";
            s.add(ten);
        }
        if(!maCoSo.equals("NULL")) {
            truyVan+=" AND MaCoSo = ?";
            s.add(maCoSo);
        }
        if(!loai.equals("NULL")) {
            truyVan+=" AND Loai = ?";
            s.add(loai);
        }
        System.out.print(truyVan);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            for(int i=0;i<s.size();i++)
            statement.setString(i+1,s.get(i));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            ds.add(new ThongTinChiTietHangHoa(rs.getString("MaHangHoa"), rs.getString("TenLoaiHangHoa"), rs.getInt("GiaBan"), rs.getString("MaCoSo"),rs.getString("HinhAnh"),rs.getInt("SoLuong")));
            System.out.println(ds.size());
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
}
