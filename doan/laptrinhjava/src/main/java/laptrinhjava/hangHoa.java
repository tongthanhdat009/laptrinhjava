package laptrinhjava;

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
            throw new IllegalArgumentException("Mã Hàng Hóa Không Hợp Lệ");
    }
    
    void setLoaiHangHoa(String loaiHangHoa){
        if(!(loaiHangHoa.equals("")))
            this.loaiHangHoa = loaiHangHoa;
        else
            throw new IllegalArgumentException("Loại Hàng Hóa Không Hợp Lệ");
    }

    void setTenHangHoa(String tenHangHoa){
        if(!(tenHangHoa.equals("") && tenHangHoa.length()<=0))
            this.tenHangHoa = tenHangHoa;
        else
            throw new IllegalArgumentException("Tên Hàng Hóa Không Hợp");
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
