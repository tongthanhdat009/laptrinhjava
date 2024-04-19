package DTO;
import java.sql.*;
public class HoaDon {
    private String maHoaDon;
    private String maHoiVien;
    private String maCoSo;
    private Date ngayXuatHoaDon;
    private int tongTien;
    private String trangThai;
    public HoaDon(String maHoaDon, Date ngayXuatHoaDon, int tongTien, String maHoiVien, String maCoSo, String trangThai)
    {
        setMaHoiVien(maHoiVien);
        setMaCoSo(maCoSo);
        setNgayXuatHoaDon(ngayXuatHoaDon);
        setTongTien(tongTien);
        setMaHoaDon(maHoaDon);
        setTrangThai(trangThai);
    }
    public String getMaCoSo() {
        return maCoSo;
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
    public int getTongTien() {
        return tongTien;
    }
    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }
    public void setMaHoiVien(String maHoiVien) {
        this.maHoiVien = maHoiVien;
    }
    public void setNgayXuatHoaDon(Date ngayXuatHoaDon) {
        this.ngayXuatHoaDon = ngayXuatHoaDon;
    }
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
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
