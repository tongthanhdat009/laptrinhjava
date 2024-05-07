package DTO;

public class hangHoaCoSo{
    private String maHangHoa;
    private int soLuong;
    private String maCoSo;
    
    //hàm khởi tạo
    hangHoaCoSo(){
        this.soLuong = 0;
        this.maHangHoa = "";
        this.maCoSo = "";
    }
    public hangHoaCoSo(String maCoSo, int soLuong, String maHangHoa){
        setSoLuong(soLuong);
        setMaHangHoa(maHangHoa);
        setMaCoSo(maCoSo);
    }

    //hàm get&set
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
}