package DTO;
// import java.util.Scanner;

public class hangHoa {
    
    private String maHangHoa;
    private String loaiHangHoa;
    private String tenLoaiHangHoa;
    private String hinhAnh;
    private long giaNhap;
    //hàm khởi tạo
    public hangHoa(String maHangHoa, String loaiHangHoa, String tenLoaiHangHoa, String hinhAnh, long giaNhap){
        setMaHangHoa(maHangHoa);
        setLoaiHangHoa(loaiHangHoa);
        setTenLoaiHangHoa(tenLoaiHangHoa);
        setHinhAnh(hinhAnh);
        setGiaNhap(giaNhap);
    }
    
    public hangHoa(){
        this.maHangHoa = "none";
        this.loaiHangHoa = "none";
        this.tenLoaiHangHoa = "none";
        this.hinhAnh = "src/asset/img/hanghoa/default-product.png";
        this.giaNhap = 0;
    }

    //hàm get&set
    public void setMaHangHoa(String maHangHoa){
        if(!(maHangHoa.equals("")))
            this.maHangHoa = maHangHoa;
        else 
            throw new IllegalArgumentException("Mã hàng hóa không hợp lệ!");
    }
    
    public void setLoaiHangHoa(String loaiHangHoa){
        if(!(loaiHangHoa.equals("")))
            this.loaiHangHoa = loaiHangHoa;
        else
            throw new IllegalArgumentException("Loại hàng hóa không hợp lệ!");
    }

    public void setTenLoaiHangHoa(String tenLoaiHangHoa){
        if(!(tenLoaiHangHoa.equals("") && tenLoaiHangHoa.length()<=0))
            this.tenLoaiHangHoa = tenLoaiHangHoa;
        else
            throw new IllegalArgumentException("Tên loại hàng hóa không hợp lệ!");
    }

    public void setHinhAnh(String hinhAnh){
        if(hinhAnh.equals(""))
            this.hinhAnh = "src/asset/img/hanghoa/default-product.png";
        else
            this.hinhAnh = hinhAnh;
    }

    public void setGiaNhap(long giaNhap){
        if(giaNhap >= 0)
            this.giaNhap = giaNhap;
        else
            throw new IllegalArgumentException("Giá nhập hàng hóa không hợp lệ!");
    }

    public String getMaHangHoa(){
        return this.maHangHoa;        
    }
    public String getLoaiHangHoa(){
        return this.loaiHangHoa;
    }
    public String getTenLoaiHangHoa(){
        return this.tenLoaiHangHoa;
    }
    public String getHinhAnh(){
        return this.hinhAnh;
    }
    public long getGiaNhap(){
        return this.giaNhap;
    }
    public String toString(){
        return this.maHangHoa + " " + this.loaiHangHoa +" " + this.tenLoaiHangHoa + " " + hinhAnh + " " + giaNhap;  
    }
}
