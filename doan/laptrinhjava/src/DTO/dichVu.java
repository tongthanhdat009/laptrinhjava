package DTO;
// import java.util.Scanner;
public class dichVu {
    private String maDichVu;
    private String tenDichVu;
    private String moTa;
    private int giaDichVu;
    private int thoiGian;
    //hàm khởi tạo
    public dichVu(){
        maDichVu = "none";
        tenDichVu = "none";
        moTa = "";
        giaDichVu = 0;
        thoiGian = 0;
    }
    public dichVu(String maDichVu, String tenDichVu, int giaDichVu, int thoiGian, String moTa){
        setMaDichVu(maDichVu);
        setTenDichVu(tenDichVu);
        setMoTa(moTa);
        setGiaDichVu(giaDichVu);
        setThoiGian(thoiGian);
    }
    
    //hàm set&get
    public void setThoiGian(int thoiGian){
        if(!(thoiGian < 0))
            this.thoiGian = thoiGian;
        else
            throw new IllegalArgumentException("Thoi Gian Dich Vu Khong Hop Le!");
    }

    public void setMoTa(String moTa){
        this.moTa = moTa;
    }
    
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

    public void setGiaDichVu(int giaDichVu){
        if(!(giaDichVu < 0))
            this.giaDichVu = giaDichVu;
        else
            throw new IllegalArgumentException("Gia Dich Vu Khong Hop Le!");
    }

    public String getMaDichVu(){
        return this.maDichVu;
    }
    public String getTenDichVu(){
        return this.tenDichVu;
    }
    public long getGiaDichVu(){
        return this.giaDichVu;
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
