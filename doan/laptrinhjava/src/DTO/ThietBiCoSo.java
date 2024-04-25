package DTO;
import java.sql.*;

public class ThietBiCoSo
{
    private String maThietBiCoSo;
    private String maCoSo;
    private String maThietBi;
    private Date ngayNhap;
    private Date hanBaoHanh;
    public ThietBiCoSo(String maThietBiCoSo, String maCoSo, String maThietBi, Date ngayNhap, Date hanBaoHanh)
    {
        setMaThietBiCoSo(maThietBiCoSo);
        setMaThietBi(maThietBi);
        setMaCoSo(maCoSo);
        setNgayNhap(ngayNhap);
        setHanBaoHanh(hanBaoHanh);
    }
    public void setHanBaoHanh(Date hanBaoHanh) {
        this.hanBaoHanh = hanBaoHanh;
    }
    public Date getHanBaoHanh() {
        return hanBaoHanh;
    }
    public String getMaCoSo() {
        return maCoSo;
    }
    public String getMaThietBi() {
        return maThietBi;
    }
    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }
    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }
    public void setMaThietBiCoSo(String maThietBiCoSo) {
        this.maThietBiCoSo = maThietBiCoSo;
    }
    public String getMaThietBiCoSo() {
        return maThietBiCoSo;
    }
    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    public Date getNgayNhap() {
        return ngayNhap;
    }
}