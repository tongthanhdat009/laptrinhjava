package DTO;
import java.sql.Date;

public class DonNhap {
    private String maNhap;
    private String trangThai;
    private String maNV;
    private Date NgayNhap;
    public DonNhap(String maNhap,String trangThai,String maNV,Date NgayNhap){
        setMaNhap(maNhap);
        setTrangThai(trangThai);
        setMaNV(maNV);
        setNgayNhap(NgayNhap);
    }
    //set
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public void setMaNhap(String maNhap) {
        this.maNhap = maNhap;
    }
    public void setNgayNhap(Date ngayNhap) {
        NgayNhap = ngayNhap;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    //get
    public String getMaNV() {
        return maNV;
    }
    public String getMaNhap() {
        return maNhap;
    }
    public Date getNgayNhap() {
        return NgayNhap;
    }
    public String getTrangThai() {
        return trangThai;
    }
}
