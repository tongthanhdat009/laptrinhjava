package laptrinhjava;

public class hangHoa {
    private String maHangHoa;
    private String loaiHangHoa;
    private String tenHangHoa;
    //hàm khởi tạo
    hangHoa(){}
    //hàm get&set
    void setMaHangHoa(String maHangHoa){
        this.maHangHoa = maHangHoa;
    }
    void setLoaiHangHoa(String loaiHangHoa){
        this.loaiHangHoa = loaiHangHoa;
    }
    void setTenHangHoa(String tenHangHoa){
        this.tenHangHoa = tenHangHoa;
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
}
