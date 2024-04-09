public class CoSo {
    private String maCoSo;
    private String diaChi;
    private String std;
    private String tenCoSo;
    private String doanhThu;
    private String thoiGianHoatDong;
    public CoSo(String maCoSo,String diaChi, String std,String doanhThu,String thoiGianHoatDong)
    {
        setStd(std);
        setDiaChi(diaChi);
        setMaCoSo(maCoSo);
        setDoanhThu(doanhThu);
        setTenCoSo(maCoSo);
        setThoiGianHoatDong(thoiGianHoatDong);
    }
    public String getDiaChi() {
        return diaChi;
    }
    public String getMaCoSo() {
        return maCoSo;
    }
    public String getStd() {
        return std;
    }
    public String getTenCoSo() {
        return tenCoSo;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public void setStd(String std) {
        this.std = std;
    }
    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }
    public void setDoanhThu(String doanhThu) {
        this.doanhThu = doanhThu;
    }
    public String getDoanhThu() {
        return doanhThu;
    }
    public void setTenCoSo(String tenCoSo) {
        this.tenCoSo = tenCoSo;
    }
    public void setThoiGianHoatDong(String thoiGianHoatDong) {
        this.thoiGianHoatDong = thoiGianHoatDong;
    }
    public String getThoiGianHoatDong() {
        return thoiGianHoatDong;
    }
}