package laptrinhjava;

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
            throw new IllegalArgumentException("Mã Dịch Vụ Không Hợp Lệ");
    }
    
    public void setTenDichVu(String tenDichVu){
        if(!(tenDichVu.equals("")))
            this.tenDichVu = tenDichVu;
        else
            throw new IllegalArgumentException("Tên Dịch Vụ Không Hợp Lệ");    
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
                throw new IllegalArgumentException("Loại Dịch Vụ Không Hợp Lệ");
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
}
