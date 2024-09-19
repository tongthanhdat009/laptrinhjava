package DTO;

public class GioHang {
    private String IDTaiKhoan;
    private String maHangHoa;
    private int soLuong;
    private int gia;
    private String MaCoSo;
    private String HinhAnh;
    private String tenHangHoa;
    public GioHang(String IDTaiKhoan,String maHangHoa,int soLuong,int gia,String maCoSo,String HinhAnh, String tenHangHoa)
    {
        setMaCoSo(maCoSo);
        setGia(gia);
        setIDTaiKhoan(IDTaiKhoan);
        setMaHangHoa(maHangHoa);
        setSoLuong(soLuong);
        setHinhAnh(HinhAnh);
        setTenHangHoa(tenHangHoa);
    }
    public String getTenHangHoa() {
        return tenHangHoa;
    }
    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }
    public void setMaCoSo(String maCoSo) {
        MaCoSo = maCoSo;
    }
    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
    public String getHinhAnh() {
        return HinhAnh;
    }
    public String getMaCoSo() {
        return MaCoSo;
    }
    public void setGia(int gia) {
        this.gia = gia;
    }public void setIDTaiKhoan(String iDTaiKhoan) {
        IDTaiKhoan = iDTaiKhoan;
    }public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }public int getGia() {
        return gia;
    }public String getIDTaiKhoan() {
        return IDTaiKhoan;
    }public String getMaHangHoa() {
        return maHangHoa;
    }public int getSoLuong() {
        return soLuong;
    } 
}
