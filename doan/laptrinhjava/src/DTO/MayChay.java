package DTO;

public class MayChay extends hangHoa {
    private int congSuat;
    private int tocDoToiDa;
    private String nhaSanXuat;
    private String kichThuoc;

    // Constructor của lớp MayChay
    public MayChay(String maHangHoa, String loaiHangHoa, String tenLoaiHangHoa, String hinhAnh,
                   int congSuat, int tocDoToiDa, String nhaSanXuat, String kichThuoc) {
        super(maHangHoa,  loaiHangHoa,  tenLoaiHangHoa,  hinhAnh); // Gọi constructor của lớp cha
        this.congSuat = congSuat;
        this.tocDoToiDa = tocDoToiDa;
        this.nhaSanXuat = nhaSanXuat;
        this.kichThuoc = kichThuoc;
    }

    // Getter và Setter cho các thuộc tính
    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public int getTocDoToiDa() {
        return tocDoToiDa;
    }

    public void setTocDoToiDa(int tocDoToiDa) {
        this.tocDoToiDa = tocDoToiDa;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }
}
