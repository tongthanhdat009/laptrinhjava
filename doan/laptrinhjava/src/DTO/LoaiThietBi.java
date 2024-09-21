package DTO;
public class LoaiThietBi {
    private String maThietBi;
    private String tenLoaiThietBi;
    private String hinhAnh;
    private String loai;
    public LoaiThietBi(String maThietBi,String tenThietBi, String hinhAnh, String loai)
    {
        setMaThietBi(maThietBi);
        setTenLoaiThietBi(tenThietBi);
        setHinhAnh(hinhAnh);
        setLoai(loai);
    }
    public void setLoai(String loai) {
        this.loai = loai;
    }
    public String getLoai() {
        return loai;
    }
    public String getMaThietBi() {
        return maThietBi;
    }
    public String getTenLoaiThietBi() {
        return tenLoaiThietBi;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }
    public void setTenLoaiThietBi(String tenLoaiThietBi) {
        this.tenLoaiThietBi = tenLoaiThietBi;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
