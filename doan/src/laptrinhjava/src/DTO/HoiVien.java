package DTO;
import java.sql.Date;

public class HoiVien extends ConNguoi {
	private String maHoiVien;
	private String taiKhoanHoiVien,matKhauHoiVien, mail, maDV;
	public HoiVien() {
		super();
		setMaHoiVien("NULL");
		setTaiKhoanHoiVien("NULL");
		setMatKhauHoiVien("NULL");
		setMail("NULL");
		setMaDV("NULL");
	}
	public HoiVien(String hoten, String gioitinh, Date ngaysinh, String sdt,String maHoiVien,String taiKhoanHoiVien,String matKhauHoiVien, String mail, String maDV) {
		super(hoten, gioitinh, ngaysinh, sdt);
		this.maHoiVien = maHoiVien;
		this.taiKhoanHoiVien = taiKhoanHoiVien;
		this.matKhauHoiVien = matKhauHoiVien;
		this.mail = mail;
		this.maDV = maDV;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
}	
