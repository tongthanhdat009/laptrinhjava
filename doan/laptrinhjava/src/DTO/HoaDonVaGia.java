package DTO;

import java.sql.Date;

public class HoaDonVaGia extends HoaDon {
    private int tongTien;
    public HoaDonVaGia(String maHoaDon, Date ngayXuatHoaDon, String maHoiVien, String trangThai, int tongTien)
    {
        super(maHoaDon, ngayXuatHoaDon, maHoiVien, trangThai);
        setTongTien(tongTien);
    }
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    public int getTongTien() {
        return tongTien;
    }
}
