package BLL;
import DAL.DataHoiVien;

public class BLLDangNhap {
    private DataHoiVien data;
    public BLLDangNhap()
    {
        data = new DataHoiVien();
    }
    public int KiemTraDangNhap(String taiKhoan, String matKhau)
    {
        return data.KiemTraDangNhap(taiKhoan, matKhau);
    }
}
