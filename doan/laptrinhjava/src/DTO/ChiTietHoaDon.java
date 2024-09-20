package DTO;

public class ChiTietHoaDon {
    private int soLuong;
    private String maHoaDon;
    private String maHangHoa;
    private int gia;
    private String maCoSo;
    private String trangThai;
    public ChiTietHoaDon(int soLuong, String maHoaDon, String maHangHoa, int gia, String maCoSo,String trangThai)
    {
        setTrangThai(trangThai);
        setMaHangHoa(maHangHoa);
        setMaHoaDon(maHoaDon);
        setSoLuong(soLuong);
        setGia(gia);
        setMaCoSo(maCoSo);
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public void setGia(int gia) {
        this.gia = gia;
    }
    public int getGia() {
        return gia;
    }
    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }
    public String getMaCoSo() {
        return maCoSo;
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
