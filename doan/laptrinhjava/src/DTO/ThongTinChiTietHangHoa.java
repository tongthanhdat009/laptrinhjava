package DTO;
public class ThongTinChiTietHangHoa
{
    public String maHangHoa;
    public String tenHang;
    public int giaBan;
    public String coSo;
    public String hinhAnh;
    public int soLuong;
    public ThongTinChiTietHangHoa(String maHangHoa, String tenHang, int giaBan, String coSo, String hinhAnh,int soLuong)
    {
        setCoSo(coSo);
        setGiaBan(giaBan);
        setMaHangHoa(maHangHoa);
        setTenHang(tenHang);
        setHinhAnh(hinhAnh);
        setSoLuong(soLuong);
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }
    public void setCoSo(String coSo) {
        this.coSo = coSo;
    }
    public String getMaHangHoa() {
        return maHangHoa;
    }
    public String getCoSo() {
        return coSo;
    }
    public int getGiaBan() {
        return giaBan;
    }
    public String getTenHang() {
        return tenHang;
    }
}