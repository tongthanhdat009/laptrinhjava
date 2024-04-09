import java.sql.Date;

public abstract class NhanVien extends ConNguoi {
	private String maNhanVien;

	public NhanVien(String hoten, String gioitinh, Date ngaysinh, String diachi, String socccd, String sdt,String maNhanVien) {
		super(hoten, gioitinh, ngaysinh, diachi,sdt);
		this.maNhanVien = maNhanVien;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
}
