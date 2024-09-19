package DTO;

public class chiTietPhieuNhap {
    private String maPhieuNhap;
    private String maHangHoa;
    private int soLuong;
    private int giaTien;
    public chiTietPhieuNhap(String maPhieuNhap,String maHangHoa,int soLuong,int giaTien){
        setMaPhieuNhap(maPhieuNhap);
        setMaHangHoa(maHangHoa);
        setSoLuong(soLuong);
        setGiaTien(giaTien);
    }
    //set
    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    //get
    public int getGiaTien() {
        return giaTien;
    }
    public String getMaHangHoa() {
        return maHangHoa;
    }
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }
    public int getSoLuong() {
        return soLuong;
    }
}
