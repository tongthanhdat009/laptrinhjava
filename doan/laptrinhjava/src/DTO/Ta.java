package DTO;

public class Ta extends LoaiThietBi{
    private int khoiLuong;
    private String chatLieu;
    private String mauSac;
    public Ta(String maThietBi,String tenThietBi, String hinhAnh, String giaThietBi, int ngayBaoHanh, String loai, int khoiLuong, String chatLieu, String mauSac)
    {
        super(maThietBi,tenThietBi,hinhAnh,giaThietBi,ngayBaoHanh,loai);
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
