package DTO;
import java.sql.Date;

public class NhanVien extends ConNguoi {
	private String socccd;
	private String maNhanVien;
	private String macoso;
	private String vaitro;
	private int luong;
	public NhanVien() {
		super();
		setSocccd("NULL");
		setMaNhanVien("NULL");
		setMacoso("NULL");
		setVaitro("NULL");
		setLuong(0);
	}

	public NhanVien(String manv,String hoten, String gioitinh, Date ngaysinh,String sdt, String socccd,String macoso,String vaitro,int luong) {
		super(hoten, gioitinh, ngaysinh,sdt);
		this.maNhanVien = manv;
		this.socccd = socccd;
		this.macoso = macoso;
		this.vaitro = vaitro;
		this.luong = luong;
	}
	
	public String getSocccd() {
		return socccd;
	}

	public void setSocccd(String socccd) {
		this.socccd = socccd;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMacoso() {
		return macoso;
	}

	public void setMacoso(String macoso) {
		this.macoso = macoso;
	}

	public String getVaitro() {
		return vaitro;
	}

	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}
		
}