package DTO;
import java.sql.*;
public class HoaDon {
    private String maHoaDon;
    private String maHoiVien;
    private Date ngayXuatHoaDon;
    private String trangThai;
    public HoaDon(String maHoaDon, Date ngayXuatHoaDon, String maHoiVien, String trangThai)
    {
        setMaHoiVien(maHoiVien);
        setNgayXuatHoaDon(ngayXuatHoaDon);
        setMaHoaDon(maHoaDon);
        setTrangThai(trangThai);
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
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
}
