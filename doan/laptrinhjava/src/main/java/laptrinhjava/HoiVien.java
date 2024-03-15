package doanJava;

import java.sql.Date;

public class HoiVien extends ConNguoi {
	private String maHoiVien;
	private String taiKhoanHoiVien,matKhauHoiVien;
	public HoiVien() {
		
	}
	public HoiVien(String hoten, String gioitinh, Date ngaysinh, String diachi, String socccd, String sdt,String maHoiVien,String taiKhoanHoiVien,String matKhauHoiVien) {
		super(hoten, gioitinh, ngaysinh, diachi, socccd, sdt);
		this.maHoiVien = maHoiVien;
		this.taiKhoanHoiVien = taiKhoanHoiVien;
		this.matKhauHoiVien = matKhauHoiVien;
		
	}
	public String getMaHoiVien() {
		return maHoiVien;
	}
	public void setMaHoiVien(String maHoiVien) {
		this.maHoiVien = maHoiVien;
	}
	public String getTaiKhoanHoiVien() {
		return taiKhoanHoiVien;
	}
	public void setTaiKhoanHoiVien(String taiKhoanHoiVien) {
		this.taiKhoanHoiVien = taiKhoanHoiVien;
	}
	public String getMatKhauHoiVien() {
		return matKhauHoiVien;
	}
	public void setMatKhauHoiVien(String matKhauHoiVien) {
		this.matKhauHoiVien = matKhauHoiVien;
	}
	
	public void nhap() {
		super.nhap();
		System.out.println("nhập mã hội viên: ");
		maHoiVien = sc.nextLine();
		System.out.println("nhập tài khoản hội viên: ");
		taiKhoanHoiVien = sc.nextLine();
		System.out.println("nhập mật khẩu hội viên: ");
		matKhauHoiVien = sc.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("mã hội viên: " + maHoiVien);
		System.out.println("tài khoản hội viên: " + taiKhoanHoiVien);
		System.out.println("mật khẩu hội viên: " + matKhauHoiVien);
	}
	
	
}	
