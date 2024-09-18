package DTO;
import java.sql.Date;

public class HoiVien extends ConNguoi {
	private String maHoiVien;
	private String mail;
	private String IDTaiKhoan;
	private String anh;
	public HoiVien() {
		super();
		setMaHoiVien("NULL");
		setMail("NULL");
		
	}
	public HoiVien(String maHoiVien, String hoten, String gioitinh, String mail,Date ngaysinh, String sdt, String IDTaiKhoan, String anh) {
		super(hoten, gioitinh, ngaysinh, sdt);
		this.maHoiVien = maHoiVien;
		this.mail = mail;
		this.IDTaiKhoan = IDTaiKhoan;
		this.anh = anh;
	}
	public String getMaHoiVien() {
		return maHoiVien;
	}
	public void setMaHoiVien(String maHoiVien) {
		this.maHoiVien = maHoiVien;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getIDTaiKhoan() {
		return IDTaiKhoan;
	}
	public void setIDTaiKhoan(String IDTaiKhoan) {
		this.IDTaiKhoan = IDTaiKhoan;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
}	
