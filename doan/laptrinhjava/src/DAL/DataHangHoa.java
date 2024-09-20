package DAL;

import java.sql.*;
import java.util.ArrayList;

import DTO.GioHang;
import DTO.LoaiThietBi;
import DTO.MayChay;
import DTO.Ta;
import DTO.ThongTinChiTietHangHoa;
import DTO.Xa;
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
            String sql = "INSERT INTO HangHoa (MaHangHoa,Loai,TenLoaiHangHoa,HinhAnh) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,hh.getMaHangHoa());            
            preparedStatement.setString(2,hh.getLoaiHangHoa());            
            preparedStatement.setString(3,hh.getTenLoaiHangHoa());            
            preparedStatement.setString(4,hh.getHinhAnh());            
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
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE HangHoa SET MaHangHoa = ?, Loai = ?, TenLoaiHangHoa= ?, HinhAnh = ? WHERE MaHangHoa = ?");
            preparedStatement.setString(1, hh.getMaHangHoa().toUpperCase());
            preparedStatement.setString(2, hh.getLoaiHangHoa());
            preparedStatement.setString(3, hh.getTenLoaiHangHoa());
            preparedStatement.setString(4, hh.getHinhAnh());
            preparedStatement.setString(5, hh.getMaHangHoa());
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
                dsHH.them(new hangHoa(rs.getString(1),rs.getString(2),rs.getString(3),""));
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
        String truyVan = "SELECT * FROM HangHoaOCoSo, HangHoa WHERE HangHoaOCoSo.MaHangHoa = HangHoa.MaHangHoa AND TrangThai = N'Đang bán' AND MaCoSo = '"+maCoSo+"'";
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
            if(maLoai.equals("Ta")||maLoai.equals("MayChay")||maLoai.equals("Xa"))
            truyVan = "SELECT * FROM "+maLoai+",HangHoa, HangHoaOCoSo, CoSo WHERE HangHoa.MaHangHoa = ? AND CoSo.MaCoSo = ? AND HangHoaOCoSo.MaCoSo = CoSo.MaCoSo AND HangHoa.MaHangHoa = HangHoaOCoSo.MaHangHoa";
            else truyVan = "SELECT * FROM HangHoa, HangHoaOCoSo, CoSo WHERE HangHoa.MaHangHoa = ? AND CoSo.MaCoSo = ? AND HangHoaOCoSo.MaCoSo = CoSo.MaCoSo AND HangHoa.MaHangHoa = HangHoaOCoSo.MaHangHoa";
            System.out.println(truyVan);
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
        String truyVan = "SELECT * FROM HangHoaOCoSo, HangHoa WHERE HangHoaOCoSo.MaHangHoa = HangHoa.MaHangHoa AND TrangThai = N'Đang bán'";
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
        System.out.println(truyVan);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            for(int i=0;i<s.size();i++)
            statement.setString(i+1,s.get(i));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            ds.add(new ThongTinChiTietHangHoa(rs.getString("MaHangHoa"), rs.getString("TenLoaiHangHoa"), rs.getInt("GiaBan"), rs.getString("MaCoSo"),rs.getString("HinhAnh"),rs.getInt("SoLuong")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public int kiemTraTonTaiGioHang(String IDTaiKhoan, String maHangHoa, String MaCoSo)
    {
        String truyVan = "SELECT * FROM GioHang WHERE IDTaiKhoan = '"+IDTaiKhoan+"' AND MaHangHoa = '"+maHangHoa+"' AND MaCoSo = '"+MaCoSo+"'";
        System.out.println(truyVan);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            if(rs.next()) return rs.getInt("SoLuongHangHoa");
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public boolean choVaoGioHang(String IDTaiKhoan, String maHangHoa,String maCoSo, int soLuong)
    {
        int soLuongHienTai = kiemTraTonTaiGioHang(IDTaiKhoan,maHangHoa,maCoSo);
        if(soLuongHienTai == 0) 
            return themVaoGioHang(IDTaiKhoan,maHangHoa,soLuong,maCoSo);
        else return suaSoLuongHangGioHang(IDTaiKhoan,maHangHoa,soLuong+soLuongHienTai,maCoSo);
    }
    public int timSoLuongHangHoaCoSo(String maHangHoa, String maCoSo)
    {
        String truyVan = "SELECT * FROM HangHoaOCoSo WHERE MaHangHoa = ? AND MaCoSo = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maHangHoa);
            statement.setString(2, maCoSo);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) return rs.getInt("SoLuong");
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    public boolean suaSoLuongHangHoaOCoSo(String maHangHoa, String maCoSo, int soLuong)
    {
        String truyVan = "UPDATE HangHoaOCoSo SET SoLuong = ? WHERE MaHangHoa = ? AND MaCoSo = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setInt(1, soLuong);
            statement.setString(2, maHangHoa);
            statement.setString(3,maCoSo);
            if(statement.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean suaSoLuongHangGioHang(String IDTaiKhoan, String maHangHoa, int soLuong, String maCoSo)
    {
        String truyVan = "UPDATE GioHang SET SoLuongHangHoa = ? WHERE IDTaiKhoan = ? AND MaHangHoa = ? AND MaCoSo = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setInt(1, soLuong);
            statement.setString(2, IDTaiKhoan);
            statement.setString(3, maHangHoa);
            statement.setString(4, maCoSo);
            if(statement.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public int timGia(String maCoSo, String maHangHoa)
    {
        String truyVan = "Select * From HangHoaOCoSo WHERE MaCoSo = ? AND MaHangHoa = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maCoSo);
            statement.setString(2, maHangHoa);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) return rs.getInt("Gia");
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public boolean themVaoGioHang(String IDTaiKhoan, String maHangHoa, int soLuong, String maCoSo)
    {
        String truyVan = "INSERT INTO GioHang(IDTaiKhoan, MaHangHoa, MaCoSo, SoLuongHangHoa) VALUES (?,?,?,?)";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, IDTaiKhoan);
            statement.setString(2, maHangHoa);
            statement.setString(3, maCoSo);
            statement.setInt(4, soLuong);
            if(statement.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public ArrayList<GioHang> layDSGioHang(String IDTaiKhoan)
    {
        ArrayList<GioHang> ds = new ArrayList<>();
        String truyVan = "SELECT * FROM GioHang, HangHoa, HangHoaOCoSo WHERE IDTaiKhoan = '"+IDTaiKhoan+"' AND HangHoa.MaHangHoa = GioHang.MaHangHoa AND HangHoaOCoSo.MaHangHoa = GioHang.MaHangHoa AND HangHoaOCoSo.MaCoSo = GioHang.MaCoSo";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(truyVan);
            while(rs.next())
            ds.add(new GioHang(rs.getString("IDTaiKhoan"), rs.getString("MaHangHoa"), rs.getInt("SoLuongHangHoa"), rs.getInt("GiaBan"), rs.getString("MaCoSo"), rs.getString("HinhAnh"), rs.getString("TenLoaiHangHoa")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ds;
    }
    public boolean xoaGioHang(String maHangHoa, String IDTaiKhoan, String maCoSo)
    {
        System.out.println(maHangHoa+":"+IDTaiKhoan+":"+maCoSo);
        String truyVan = "DELETE FROM GioHang WHERE MaHangHoa = ? AND IDTaiKhoan = ? AND MaCoSo = ?";
        System.out.println(truyVan);
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, maHangHoa);
            statement.setString(2, IDTaiKhoan);
            statement.setString(3, maCoSo);
            if(statement.executeUpdate() > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    //sửa thông tin hàng hóa loại tạ
    public boolean SuaTa(Ta ta)
    {
        String truyVan = "UPDATE Ta SET KhoiLuong = ?, ChatLieu = ?, MauSac = ? FROM Ta Where MaHangHoa = ? ";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setInt(1, ta.getKhoiLuong());
            statement.setString(2, ta.getChatLieu());
            statement.setString(3, ta.getMauSac());
            statement.setString(4, ta.getMaHangHoa());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean SuaThietBiTa(Ta ta)
    {
       if (suaHangHoa(new hangHoa(ta.getMaHangHoa(), ta.getLoaiHangHoa(), ta.getTenLoaiHangHoa(),ta.getHinhAnh())))
       if (SuaTa(ta)) return true;
       return false;
    }

    //sửa thông tin hàng hóa loại máy chạy
    public boolean SuaMayChay(MayChay mayChay) {
        String truyVan = "UPDATE MayChay SET CongSuat = ?, TocDoToiDa = ?, NhaSanXuat = ?, KichThuoc = ? FROM MayChay WHERE MaHangHoa = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setInt(1, mayChay.getCongSuat());
            statement.setInt(2, mayChay.getTocDoToiDa());
            statement.setString(3, mayChay.getNhaSanXuat());
            statement.setString(4, mayChay.getKichThuoc());
            statement.setString(5, mayChay.getMaHangHoa());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean SuaThietBiMayChay(MayChay mayChay) {
        if (suaHangHoa(new hangHoa(mayChay.getMaHangHoa(), mayChay.getLoaiHangHoa(), mayChay.getTenLoaiHangHoa(),mayChay.getHinhAnh()))) 
            if (SuaMayChay(mayChay)) return true;
        return false;
    }
    
    //sửa thông tin hàng hóa loại xà
    public boolean SuaXa(Xa xa) {
        String truyVan = "UPDATE Xa SET LoaiXa = ?, ChatLieu = ?, ChieuDai = ?, DuongKinh = ?, ChieuCao = ?, TaiTrong = ? FROM Xa WHERE MaHangHoa = ?";
        try {
            con = DriverManager.getConnection(dbUrl, userName, password);
            PreparedStatement statement = con.prepareStatement(truyVan);
            statement.setString(1, xa.getLoaiXa());
            statement.setString(2, xa.getChatLieu());
            statement.setFloat(3, xa.getChieuDai());
            statement.setFloat(4, xa.getDuongKinh());
            statement.setFloat(5, xa.getChieuCao());
            statement.setFloat(6, xa.getTaiTrong());
            statement.setString(7, xa.getMaHangHoa());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean SuaThietBiXa(Xa xa) {
            if (suaHangHoa(new hangHoa(xa.getMaHangHoa(), xa.getLoaiHangHoa(), xa.getTenLoaiHangHoa(),xa.getHinhAnh()))) 
                if (SuaXa(xa)) return true;
            return false;
        }
}
