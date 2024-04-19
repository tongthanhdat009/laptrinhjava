package DTO;

public class ChiTietHoaDon {
    private int soLuong;
    private String maHoaDon;
    private String maHangHoa;
    public ChiTietHoaDon(int soLuong, String maHoaDon, String maHangHoa)
    {
        setMaHangHoa(maHangHoa);
        setMaHoaDon(maHoaDon);
        setSoLuong(soLuong);
    }
    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public String getMaHangHoa() {
        return maHangHoa;
    }
    public String getMaHoaDon() {
        return maHoaDon;
    }
    public int getSoLuong() {
        return soLuong;
    }
}
