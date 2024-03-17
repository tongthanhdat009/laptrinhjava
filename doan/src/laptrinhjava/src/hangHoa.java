// import java.util.Scanner;

public class hangHoa {
    
    private String maHangHoa;
    private String loaiHangHoa;
    private String tenHangHoa;
    //hàm khởi tạo
    public hangHoa(String maHangHoa, String loaiHangHoa, String tenHangHoa){
        setMaHangHoa(maHangHoa);
        setLoaiHangHoa(loaiHangHoa);
        setTenHangHoa(tenHangHoa);
    }
    
    public hangHoa(){
        this.maHangHoa = "none";
        this.loaiHangHoa = "none";
        this.tenHangHoa = "none";
    }

    //hàm get&set
    void setMaHangHoa(String maHangHoa){
        if(!(maHangHoa.equals("")))
            this.maHangHoa = maHangHoa;
        else 
            throw new IllegalArgumentException("Ma Hang Hoa Khong Hop Le!");
    }
    
    void setLoaiHangHoa(String loaiHangHoa){
        if(!(loaiHangHoa.equals("")))
            this.loaiHangHoa = loaiHangHoa;
        else
            throw new IllegalArgumentException("Loai Hang Hoa Khong Hop Le!");
    }

    void setTenHangHoa(String tenHangHoa){
        if(!(tenHangHoa.equals("") && tenHangHoa.length()<=0))
            this.tenHangHoa = tenHangHoa;
        else
            throw new IllegalArgumentException("Ten Hang Hoa Khong Hop Le!");
    }

    String getMaHangHoa(){
        return this.maHangHoa;        
    }
    String getLoaiHangHoa(){
        return this.loaiHangHoa;
    }
    String getTenHangHoa(){
        return this.tenHangHoa;
    }
    
    public String toString(){
        return this.maHangHoa + " " + this.tenHangHoa + " " + this.loaiHangHoa;  
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
