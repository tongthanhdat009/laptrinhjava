package DTO;
// import java.util.Scanner;
public class dichVu {
    private String maDichVu;
    private String tenDichVu;
    private String loaiDichVu;
    private long giaDichVu;
    
    //hàm khởi tạo
    public dichVu(){
        maDichVu = "none";
        loaiDichVu = "none";
        tenDichVu = "none";
        giaDichVu = 0;
    }
    public dichVu(String maDichVu, String tenDichVu, String loaiDichVu, long giaDichVu){
        setLoaiDichVu(maDichVu);
        setTenDichVu(tenDichVu);
        setMaDichVu(loaiDichVu);
        setGiaDichVu(giaDichVu);
    }
    
    //hàm set&get
    public void setMaDichVu(String maDichVu){
        if(!(maDichVu.equals("")))
            this.maDichVu = maDichVu;
        else
            throw new IllegalArgumentException("Ma Dich Vu Khong Hop Le!");
    }
    
    public void setTenDichVu(String tenDichVu){
        if(!(tenDichVu.equals("")))
            this.tenDichVu = tenDichVu;
        else
            throw new IllegalArgumentException("Ten Dich Vu Khong Hop Le!");    
    }

    public void setLoaiDichVu(String loaiDichVu){
        String text = loaiDichVu.toLowerCase();
        switch (text) {
            case "vip":
                this.loaiDichVu = "VIP";
                break;
            case "normal":
                this.loaiDichVu = "Normal";
            break;
            case "svip":
                this.loaiDichVu = "SVIP";
            break;
        
            default:
                throw new IllegalArgumentException("Loai Dich Vu Khong Hop Le!");
        }
        
    }

    public void setGiaDichVu(long giaDichVu){
        this.giaDichVu = giaDichVu;
    }

    public String getMaDichVu(){
        return this.maDichVu;
    }
    public String getTenDichVu(){
        return this.tenDichVu;
    }
    public String getLoaiDichVu(){
        return this.loaiDichVu;
    }
    public long getGiaDichVu(){
        return this.giaDichVu;
    }
    public String toString(){
        return this.maDichVu + " " + this.tenDichVu + " " + this.loaiDichVu + " " + this.giaDichVu;  
    }
    // public void nhap(){ //test
    //     Scanner in = new Scanner(System.in);
    //     String newMaDichVu= new String();
    //     String newTenDichVu= new String();
    //     String newLoaiDichVu= new String();
    //     long newGiaDichVu;
    //     System.out.println("Nhap ma dich vu: ");
    //     newMaDichVu = in.nextLine();
    //     System.out.println("Nhap ten dich vu: ");
    //     newTenDichVu = in.nextLine();
    //     System.out.println("Nhap loai dich vu: ");
    //     newLoaiDichVu = in.nextLine();
    //     System.out.println("Nhap gia dich vu:");
    //     newGiaDichVu = in.nextLong();
    //     setMaDichVu(newMaDichVu);
    //     setTenDichVu(newLoaiDichVu);
    //     setLoaiDichVu(newLoaiDichVu);
    //     setGiaDichVu(newGiaDichVu);
    //     in.close();
    // }
    // public static void main(String[] args){
    //     dichVu a = new dichVu();
    //     a.nhap();
    //     System.out.println(a.toString());
    // }
}
