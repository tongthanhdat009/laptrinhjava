package laptrinhjava;

import java.time.LocalDate;

public class HoaDon {
    private String maHoaDon;
    private String maHoiVien;
    private String maCoSo;
    private LocalDate ngayXuatHoaDon;
    private int tongTien;
    private static int soLuongHoaDon=0;
    public HoaDon(String maHoiVien,String maCoSo,int tongTien,LocalDate ngayXuatHoaDon)
    {
        setMaHoiVien(maHoiVien);
        setMaCoSo(maCoSo);
        setNgayXuatHoaDon(ngayXuatHoaDon);
        setTongTien(tongTien);
        maHoiVien = maHoiVien+"x"+maCoSo+"x"+String.valueOf(++soLuongHoaDon);
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
    public LocalDate getNgayXuatHoaDon() {
        return ngayXuatHoaDon;
    }
    public static int getSoLuongHoaDon() {
        return soLuongHoaDon;
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
    public void setNgayXuatHoaDon(LocalDate ngayXuatHoaDon) {
        this.ngayXuatHoaDon = ngayXuatHoaDon;
    }
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}
