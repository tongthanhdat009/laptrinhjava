package DTO;

import java.sql.Date;

public class DTOdonNhap {
    private String maPhieuNhap;
    private String hoTenNV;
    private String tenCoSo;
    private Date ngayNhap;
    private int tongTien;
    private String trangThai;
    
    public DTOdonNhap(String maPhieuNhap, String hoTenNV, String tenCoSo, Date ngayNhap, int tongTien, String trangThai){
        setMaPhieuNhap(maPhieuNhap);
        setHoTenNV(hoTenNV);
        setTenCoSo(tenCoSo);
        setNgayNhap(ngayNhap);
        setTongTien(tongTien);;
        setTrangThai(trangThai);
    }
    
    //set
    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    public void setTenCoSo(String tenCoSo) {
        this.tenCoSo = tenCoSo;
    }
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    //get
    public String getHoTenNV() {
        return hoTenNV;
    }
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }
    public Date getNgayNhap() {
        return ngayNhap;
    }
    public String getTenCoSo() {
        return tenCoSo;
    }
    public int getTongTien() {
        return tongTien;
    }
    public String getTrangThai() {
        return trangThai;
    }
}
