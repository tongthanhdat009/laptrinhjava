package DTO;
// import java.util.Scanner;
public class dichVu {
    private String maDichVu;
    private String tenDichVu;
    private String moTa;
    private String hinhAnh;
    private long giaDichVu;
    private int thoiGian;
    //hàm khởi tạo
    public dichVu(){
        maDichVu = "none";
        tenDichVu = "none";
        moTa = "";
        giaDichVu = 0;
        thoiGian = 0;
    }
    public dichVu(String maDichVu, String tenDichVu, long giaDichVu, int thoiGian, String moTa, String hinhAnh){
        setMaDichVu(maDichVu);
        setTenDichVu(tenDichVu);
        setMoTa(moTa);
        setGiaDichVu(giaDichVu);
        setThoiGian(thoiGian);
        setHinhAnh(hinhAnh);
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
    
    public void setHinhAnh(String hinhAnh){
        this.hinhAnh = hinhAnh;
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

    public void setGiaDichVu(long giaDichVu){
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
    public String getMoTa(){
        return this.moTa;
    }
    public String getHinhAnh(){
        return this.hinhAnh;
    }
    public int getThoiGian(){
        return this.thoiGian;
    }
}
