package DTO;

public class MayChay extends LoaiThietBi {
    private int congSuat;
    private int toDoToiDa;
    private String nhaSanXuat;
    private String kichThuoc;

    // Constructor của lớp MayChay
    public MayChay(String maThietBi, String tenThietBi, String hinhAnh, String giaThietBi, int ngayBaoHanh, String loai,
                   int congSuat, int toDoToiDa, String nhaSanXuat, String kichThuoc) {
        super(maThietBi, tenThietBi, hinhAnh, giaThietBi, ngayBaoHanh, loai); // Gọi constructor của lớp cha
        this.congSuat = congSuat;
        this.toDoToiDa = toDoToiDa;
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

    public int getToDoToiDa() {
        return toDoToiDa;
    }

    public void setToDoToiDa(int toDoToiDa) {
        this.toDoToiDa = toDoToiDa;
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
