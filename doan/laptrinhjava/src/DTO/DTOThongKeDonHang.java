package DTO;
public class DTOThongKeDonHang {
    private String tenHangHoa;
    private int doanhThu;
    private int soLuong;
    public DTOThongKeDonHang(String tenHangHoa, int doanhThu, int soLuong)
    {
        setDoanhThu(doanhThu);
        setTenHangHoa(tenHangHoa);
        setSoLuong(soLuong);
    }
    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }
    public int getDoanhThu() {
        return doanhThu;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public String getTenHangHoa() {
        return tenHangHoa;
    }
}
