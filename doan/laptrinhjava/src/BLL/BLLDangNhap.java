package BLL;
import DAL.DataHoiVien;
import DAL.DataTaiKhoan;
import DTO.DTOTaiKhoan;

public class BLLDangNhap {
    private DataTaiKhoan data;
    public BLLDangNhap()
    {
        data = new DataTaiKhoan();
    }
    public String KiemTraDangNhap(String taiKhoan, String matKhau)
    {
        return data.KiemTraDangNhap(taiKhoan, matKhau);
    }
}
