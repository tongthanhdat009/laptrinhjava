package DTO;

public class DTODuyetDonHang {
    private String TenHangHoa;
    private int SoLuong;
    private int GiaTien;
    public DTODuyetDonHang(String TenHangHoa, int SoLuong, int GiaTien)
    {
        setTenHangHoa(TenHangHoa);
        setGiaTien(GiaTien);
        setSoLuong(SoLuong);
    }
    public void setGiaTien(int giaTien) {
        GiaTien = giaTien;
    }
    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
    public void setTenHangHoa(String tenHangHoa) {
        TenHangHoa = tenHangHoa;
    }
    public int getGiaTien() {
        return GiaTien;
    }
    public int getSoLuong() {
        return SoLuong;
    }
    public String getTenHangHoa() {
        return TenHangHoa;
    }
}
