package DTO;

import java.sql.*;
public class HoiVienCoSo {
    private String maHoiVien;
    private String maCoSo;
    private Date hanTap;
    public HoiVienCoSo(Date hanTap, String maHoiVien, String maCoSo)
    {
        setMaHoiVien(maHoiVien);
        setMaCoSo(maCoSo);
        setHanTap(hanTap);   
    }
    public void setHanTap(Date hanTap) {
        this.hanTap = hanTap;
    }
    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }
    public void setMaHoiVien(String maHoiVien) {
        this.maHoiVien = maHoiVien;
    }
    public Date getHanTap() {
        return hanTap;
    }
    public String getMaCoSo() {
        return maCoSo;
    }
    public String getMaHoiVien() {
        return maHoiVien;
    }

}
