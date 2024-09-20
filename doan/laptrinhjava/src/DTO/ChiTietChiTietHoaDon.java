package DTO;

import java.sql.Date;

public class ChiTietChiTietHoaDon {
    private String maCoSo;
    private Date ngayMua;
    private String maHoiVien;
    private String tenHoiVien;
    private String tenHangHoa;
    private int soLuong;
    private int gia;
    private String trangThai;

    public ChiTietChiTietHoaDon(String maCoSo, Date ngayMua, String maHoiVien, String tenHoiVien, String tenHangHoa, int soLuong, int gia, String trangThai) {
        this.setMaCoSo(maCoSo);
        this.setNgayMua(ngayMua);
        this.setMaHoiVien(maHoiVien);
        this.setTenHoiVien(tenHoiVien);
        this.setTenHangHoa(tenHangHoa);
        this.setSoLuong(soLuong);
        this.setGia(gia);
        setTrangThai(trangThai);
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    // Getter and Setter for maCoSo
    public String getMaCoSo() {
        return maCoSo;
    }

    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }

    // Getter and Setter for ngayMua
    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    // Getter and Setter for maHoiVien
    public String getMaHoiVien() {
        return maHoiVien;
    }

    public void setMaHoiVien(String maHoiVien) {
        this.maHoiVien = maHoiVien;
    }

    // Getter and Setter for tenHoiVien
    public String getTenHoiVien() {
        return tenHoiVien;
    }

    public void setTenHoiVien(String tenHoiVien) {
        this.tenHoiVien = tenHoiVien;
    }

    // Getter and Setter for tenHangHoa
    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    // Getter and Setter for soLuong
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Getter and Setter for gia
    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
