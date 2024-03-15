package laptrinhjava;

public class ThietBi {
    private String maThietBi;
    private String tenThietBi;
    private int thoiGianBaoHanh; // Tinh bang thang
    private static int soLuongLoaiThietBi;
    public ThietBi()
    {
        maThietBi = String.valueOf(++soLuongLoaiThietBi);
        tenThietBi = "NULL";
        thoiGianBaoHanh = 0;
    }
    public ThietBi(String tenThietBi, int thoiGianBaoHanh)
    {
        setThoiGianBaoHanh(thoiGianBaoHanh);
        maThietBi = String.valueOf(++soLuongLoaiThietBi);
        setTenThietBi(tenThietBi);
    }
    public String getMaThietBi() {
        return maThietBi;
    }
    public static int getSoLuongLoaiThietBi() {
        return soLuongLoaiThietBi;
    }
    public String getTenThietBi() {
        return tenThietBi;
    }
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }
    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if(thoiGianBaoHanh>=0) this.thoiGianBaoHanh = thoiGianBaoHanh;
        else throw new  IllegalArgumentException("Thoi gian khong hop le");
    }
    public String toString()
    {
        return maThietBi+" "+tenThietBi+" "+thoiGianBaoHanh;
    }
}
