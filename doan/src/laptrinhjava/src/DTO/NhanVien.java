package DTO;
import java.sql.Date;

public abstract class NhanVien extends ConNguoi {
	private String maNhanVien;

	public NhanVien(String hoten, String gioitinh, Date ngaysinh, String socccd, String sdt,String maNhanVien) {
		super(hoten, gioitinh, ngaysinh,sdt);
		this.maNhanVien = maNhanVien;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
}
