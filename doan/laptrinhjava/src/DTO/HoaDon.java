package DTO;
import java.sql.*;
public class HoaDon {
    private String maHoaDon;
    private String maHoiVien;
    private Date ngayXuatHoaDon;
    public HoaDon(String maHoaDon, Date ngayXuatHoaDon, String maHoiVien)
    {
        setMaHoiVien(maHoiVien);
        setNgayXuatHoaDon(ngayXuatHoaDon);
        setMaHoaDon(maHoaDon);
    }
    public String getMaHoaDon() {
        return maHoaDon;
    }
    public String getMaHoiVien() {
        return maHoiVien;
    }
    public Date getNgayXuatHoaDon() {
        return ngayXuatHoaDon;
    }
    public void setMaHoiVien(String maHoiVien) {
        this.maHoiVien = maHoiVien;
    }
    public void setNgayXuatHoaDon(Date ngayXuatHoaDon) {
        this.ngayXuatHoaDon = ngayXuatHoaDon;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
}
