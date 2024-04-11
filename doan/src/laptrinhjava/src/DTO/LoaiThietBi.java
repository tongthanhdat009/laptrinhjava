package DTO;
public class LoaiThietBi {
    private String maThietBi;
    private String tenLoaiThietBi;
    private String giaThietBi;
    private int ngayBaoHanh;
    private String hinhAnh;
    
    public LoaiThietBi(String maThietBi,String tenThietBi,String giaThietBi, int ngayBaoHanh, String hinhAnh)
    {
        setMaThietBi(maThietBi);
        setTenLoaiThietBi(giaThietBi);
        setGiaThietBi(giaThietBi);
        setNgayBaoHanh(ngayBaoHanh);
        setHinhAnh(hinhAnh);
    }
    public String getMaThietBi() {
        return maThietBi;
    }
    public String getTenLoaiThietBi() {
        return tenLoaiThietBi;
    }
    public String getGiaThietBi() {
        return giaThietBi;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public int getNgayBaoHanh() {
        return ngayBaoHanh;
    }
    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }
    public void setTenLoaiThietBi(String tenLoaiThietBi) {
        this.tenLoaiThietBi = tenLoaiThietBi;
    }
    public void setGiaThietBi(String giaThietBi) {
        this.giaThietBi = giaThietBi;
    }
    public void setNgayBaoHanh(int ngayBaoHanh) {
        this.ngayBaoHanh = ngayBaoHanh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
