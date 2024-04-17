package DTO;
import java.time.LocalDate;

public class ThietBiCoSo
{
    private String maThietBi;
    private String maCoSo;
    private LocalDate ngayNhap;
    public ThietBiCoSo(String maThietBi, String maCoSo, LocalDate ngayNhap)
    {
        setMaThietBi(maThietBi);
        setMaCoSo(maCoSo);
        setNgayNhap(ngayNhap);
    }
    public String getMaCoSo() {
        return maCoSo;
    }
    public String getMaThietBi() {
        return maThietBi;
    }
    public LocalDate getNgayNhap() {
        return ngayNhap;
    }
    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }
    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }
    public String toString()
    {
        return maThietBi+" "+maCoSo+" "+ngayNhap;
    }
}