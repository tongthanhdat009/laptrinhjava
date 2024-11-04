package DTO;
import java.sql.Date;
import java.time.LocalDate;

public class ConNguoi {
	private String hoten,gioitinh,sdt;
	private Date ngaysinh;
	
	public ConNguoi() {
		setHoten("NULL");
		setGioitinh("NULL");
		setSdt("NULL");
		setNgaysinh(Date.valueOf("2000-01-01"));
	}
	
	public ConNguoi(String hoten,String gioitinh,Date ngaysinh,String sdt) {
		this.hoten = hoten;
		this.gioitinh  = gioitinh;
		this.ngaysinh = ngaysinh;
		this.sdt =sdt;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getNgaysinh() {
		LocalDate a = ngaysinh.toLocalDate();
		return a.toString();
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
}
