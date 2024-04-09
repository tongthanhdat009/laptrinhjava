public class TrungGianDangNhapSuaTenSau {
    private DataHoiVien data;
    public TrungGianDangNhapSuaTenSau()
    {
        data = new DataHoiVien();
    }
    public int KiemTraDangNhap(String taiKhoan, String matKhau)
    {
        return data.KiemTraDangNhap(taiKhoan, matKhau);
    }
}
