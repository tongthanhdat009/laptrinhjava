package DTO;
import java.sql.Date;

public class ConNguoi {
	private String hoten,gioitinh,diachi,sdt;
	private Date ngaysinh;
	
	public ConNguoi() {}
	
	public ConNguoi(String hoten,String gioitinh,Date ngaysinh,String diachi,String sdt) {
		this.hoten = hoten;
		this.gioitinh  = gioitinh;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;

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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
}
