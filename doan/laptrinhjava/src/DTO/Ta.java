package DTO;

public class Ta extends hangHoa{
    private int khoiLuong;
    private String chatLieu;
    private String mauSac;
    public Ta(String maHangHoa, String loaiHangHoa, String tenLoaiHangHoa, String hinhAnh, int khoiLuong, String chatLieu, String mauSac)
    {
        super(maHangHoa, loaiHangHoa, tenLoaiHangHoa, hinhAnh);
        setChatLieu(chatLieu);
        setMauSac(mauSac);
        setKhoiLuong(khoiLuong);
    }
    public void setKhoiLuong(int khoiLuong) {
        this.khoiLuong = khoiLuong;
    }
    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    public int getKhoiLuong() {
        return khoiLuong;
    }
    public String getChatLieu() {
        return chatLieu;
    }
    public String getMauSac() {
        return mauSac;
    }
}
