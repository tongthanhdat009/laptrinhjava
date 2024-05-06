package DTO;

public class hangHoaCoSo{
    private String maHangHoa;
    private int soLuong;
    private String maCoSo;
    private int giaBan;
    
    //hàm khởi tạo
    hangHoaCoSo(){
        this.soLuong = 0;
        this.giaBan = 0;
        this.maHangHoa = "";
        this.maCoSo = "";
    }
    public hangHoaCoSo(String maCoSo, int soLuong, String maHangHoa, int giaBan){
        setSoLuong(soLuong);
        setMaHangHoa(maHangHoa);
        setMaCoSo(maCoSo);
        setGiaBan(giaBan);
    }

    //hàm get&set
    public void setGiaBan(int giaBan){
        if(!(giaBan<0)){
            this.giaBan = giaBan;
        }
        else{
            throw new IllegalArgumentException("Gia Ban Phai >= 0");
        }
    }
    public void setSoLuong(int soLuong){
        if(!(soLuong < 0))
            this.soLuong = soLuong;
        else
            throw new IllegalArgumentException("So Luong Phai >= 0");
    }
    public void setMaHangHoa(String maHangHoa){
        if(!(maHangHoa.equals("")))
            this.maHangHoa = maHangHoa;
        else
            throw new IllegalArgumentException("Ma Hang Hoa Khong Hop Le!");
    }
    public void setMaCoSo(String maCoSo){
        if(!(maCoSo.equals("")))
            this.maCoSo = maCoSo;
        else throw new IllegalArgumentException("Ma Co So Khong Hop Le!");
    }

    public int getSoLuong(){
        return this.soLuong;
    }
    public String getMaHangHoa(){
        return this.maHangHoa;
    }
    public String getMaCoSo(){
        return this.maCoSo;
    }
    public String toString(){
        return this.maHangHoa + " " + this.maCoSo + " " + this.soLuong;  
    }
    public int getGiaBan() {
        return this.giaBan;
    }
}