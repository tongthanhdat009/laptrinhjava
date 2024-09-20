package DTO;

import java.sql.Date;

public class HoaDonVaGia extends HoaDon {
    private int tongTien;
    private String trangThai;
    public HoaDonVaGia(String maHoaDon, Date ngayXuatHoaDon, String maHoiVien, String trangThai, int tongTien)
    {
        super(maHoaDon, ngayXuatHoaDon, maHoiVien);
        setTongTien(tongTien);
        setTrangThai(trangThai);
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    public int getTongTien() {
        return tongTien;
    }
}
