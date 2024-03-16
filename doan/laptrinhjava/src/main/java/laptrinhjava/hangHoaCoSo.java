package laptrinhjava;
public class hangHoaCoSo{
    private int soLuong;
    private String maHangHoa;
    private String maCoSo;

    //hàm khởi tạo
    hangHoaCoSo(){
        this.soLuong = 0;
        this.maHangHoa = "";
        this.maCoSo = "";
    }
    hangHoaCoSo(int soLuong, String maHangHoa, String maCoSo){
        setSoLuong(soLuong);
        setMaHangHoa(maHangHoa);
        setMaCoSo(maCoSo);
    }

    //hàm get&set
    public void setSoLuong(int soLuong){
        if(!(soLuong < 0))
            this.soLuong = soLuong;
        else
            throw new IllegalArgumentException("Số Lượng Phải Lớn Hơn Hoặc Bằng 0");
    }
    public void setMaHangHoa(String maHangHoa){
        if(!(maHangHoa.equals("")))
            this.maHangHoa = maHangHoa;
        else
            throw new IllegalArgumentException("Mã Hàng Hóa Không Hợp Lệ");
    }
    public void setMaCoSo(String maCoSo){
        if(!(maCoSo.equals("")))
            this.maCoSo = maCoSo;
        else throw new IllegalArgumentException("Mã Cơ Sở Không Hợp Lệ");
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

}