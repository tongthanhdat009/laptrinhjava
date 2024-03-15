package doanJava;

import java.sql.Date;

public abstract class NhanVien extends ConNguoi {
	private String maNhanVien;

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String hoten, String gioitinh, Date ngaysinh, String diachi, String socccd, String sdt,String maNhanVien) {
		super(hoten, gioitinh, ngaysinh, diachi, socccd, sdt);
		this.maNhanVien = maNhanVien;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public void nhap() {
		super.nhap();
		System.out.println("nhap ma nhan vien: ");
		maNhanVien = sc.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("ma nhan vien: " + maNhanVien);
	}
	public abstract double tinhTienLuong();
}
