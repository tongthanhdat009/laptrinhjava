package DTO;
// import java.util.Scanner;

public class hangHoa {
    
    private String maHangHoa;
    private String loaiHangHoa;
    private String tenHangHoa;
    private String hinhAnh;
    private long giaNhap;
    //hàm khởi tạo
    public hangHoa(String maHangHoa, String loaiHangHoa, String tenHangHoa, String hinhAnh, long giaNhap){
        setMaHangHoa(maHangHoa);
        setLoaiHangHoa(loaiHangHoa);
        setTenHangHoa(tenHangHoa);
        setHinhAnh(hinhAnh);
        setGiaNhap(giaNhap);
    }
    
    public hangHoa(){
        this.maHangHoa = "none";
        this.loaiHangHoa = "none";
        this.tenHangHoa = "none";
        this.hinhAnh = "doan/src/laptrinhjava/src/asset/img/hanghoa/default-product.jpg";
        this.giaNhap = 0;
    }

    //hàm get&set
    public void setMaHangHoa(String maHangHoa){
        if(!(maHangHoa.equals("")))
            this.maHangHoa = maHangHoa;
        else 
            throw new IllegalArgumentException("Ma Hang Hoa Khong Hop Le!");
    }
    
    public void setLoaiHangHoa(String loaiHangHoa){
        if(!(loaiHangHoa.equals("")))
            this.loaiHangHoa = loaiHangHoa;
        else
            throw new IllegalArgumentException("Loai Hang Hoa Khong Hop Le!");
    }

    public void setTenHangHoa(String tenHangHoa){
        if(!(tenHangHoa.equals("") && tenHangHoa.length()<=0))
            this.tenHangHoa = tenHangHoa;
        else
            throw new IllegalArgumentException("Ten Hang Hoa Khong Hop Le!");
    }

    public void setHinhAnh(String hinhAnh){
        if(hinhAnh.equals(""))
            this.hinhAnh = "doan/src/laptrinhjava/src/asset/img/hanghoa/default-product.jpg";
        else
            this.hinhAnh = hinhAnh;
    }

    public void setGiaNhap(long giaNhap){
        if(giaNhap >= 0)
            this.giaNhap = giaNhap;
        else
            throw new IllegalArgumentException("Gia Nhap Khong Hop Le!");
    }

    public String getMaHangHoa(){
        return this.maHangHoa;        
    }
    public String getLoaiHangHoa(){
        return this.loaiHangHoa;
    }
    public String getTenHangHoa(){
        return this.tenHangHoa;
    }
    public String getHinhAnh(){
        return this.hinhAnh;
    }
    
    public String toString(){
        return this.maHangHoa + " " + this.loaiHangHoa +" " + this.tenHangHoa + " " + hinhAnh + " " + giaNhap;  
    }
    // public void nhap(){ //test
    //     Scanner in = new Scanner(System.in);
    //     String newMaHangHoa = new String();
    //     String newLoaiHangHoa = new String();
    //     String newTenHangHoa = new String();
    //     System.out.println("Nhap ma hang hoa: ");
    //     newMaHangHoa = in.nextLine();
    //     System.out.println("Nhap loai hang hoa: ");
    //     newLoaiHangHoa = in.nextLine();
    //     System.out.println("Nhap ten hang hoa: ");
    //     newTenHangHoa = in.nextLine();
    //     setLoaiHangHoa(newLoaiHangHoa);
    //     setMaHangHoa(newMaHangHoa);
    //     setTenHangHoa(newTenHangHoa);
    //     System.out.print(newLoaiHangHoa + " " + newMaHangHoa + " " + newTenHangHoa);
    //     in.close();
    // }
    // public static void main(String[] args){
    //     hangHoa a = new hangHoa();
    //     a.nhap();
    // }
    
}
