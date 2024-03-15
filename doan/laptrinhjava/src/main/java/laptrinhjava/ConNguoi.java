package laptrinhjava;

import java.sql.Date;
import java.util.Scanner;

public class ConNguoi {
	Scanner sc = new Scanner(System.in);
	private String hoten,gioitinh,diachi,socccd,sdt;
	private Date ngaysinh;
	
	public ConNguoi() {}
	
	public ConNguoi(String hoten,String gioitinh,Date ngaysinh,String diachi,String socccd,String sdt) {
		this.hoten = hoten;
		this.gioitinh  = gioitinh;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.socccd = socccd;
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

	public String getSocccd() {
		return socccd;
	}

	public void setSocccd(String socccd) {
		this.socccd = socccd;
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
	public void nhap() {
		System.out.println("nhap ho ten: ");
		hoten = sc.nextLine();
		System.out.println("nhap gioi tinh: ");
		gioitinh = sc.nextLine();
		System.out.println("Nhập ngày sinh (yyyy-MM-dd): ");
	    ngaysinh = Date.valueOf(sc.next());
		System.out.println("nhap dia chi: ");
		diachi = sc.nextLine();
		System.out.println("nhap so can cuoc cong dan: ");
		socccd = sc.nextLine();
		System.out.println("nhap so dien thoai: ");
		sdt = sc.nextLine();
	}
	public void xuat() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "ConNguoi [hoten=" + hoten + ", gioitinh=" + gioitinh + ", diachi=" + diachi + ", socccd=" + socccd
				+ ", sdt=" + sdt + ", ngaysinh=" + ngaysinh + "]";
	}
	
}
