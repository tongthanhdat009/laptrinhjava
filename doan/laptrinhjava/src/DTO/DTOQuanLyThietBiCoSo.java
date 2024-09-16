package DTO;
import java.sql.*;
public class DTOQuanLyThietBiCoSo extends ThietBiCoSo {
    private String tenThietBi;
    private String loaiThietBi;
    public DTOQuanLyThietBiCoSo(String maThietBiCoSo, String maCoSo, String maThietBi, Date ngayNhap, Date hanBaoHanh, String tenThietBi,String loai)
    {
        super(maThietBiCoSo, maCoSo, maThietBi, ngayNhap, hanBaoHanh);
        setTenThietBi(tenThietBi);
        setLoaiThietBi(loai);
    }
    public void setLoaiThietBi(String loaiThietBi) {
        this.loaiThietBi = loaiThietBi;
    }
    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }
    public String getLoaiThietBi() {
        return loaiThietBi;
    }
    public String getTenThietBi() {
        return tenThietBi;
    }

}
