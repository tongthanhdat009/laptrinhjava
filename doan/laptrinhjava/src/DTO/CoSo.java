package DTO;
public class CoSo {
    private String maCoSo;
    private String diaChi;
    private String std;
    private String tenCoSo;
    private int doanhThu;
    private String thoiGianHoatDong;
    public CoSo(String maCoSo,String tenCoSo, String diaChi, String thoiGianHoatDong, String std,int doanhThu)
    {
        setStd(std);
        setDiaChi(diaChi);
        setMaCoSo(maCoSo);
        setDoanhThu(doanhThu);
        setTenCoSo(tenCoSo);
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
    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }
    public int getDoanhThu() {
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