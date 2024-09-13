package DTO;

public class DTOChucNang {
	private String iDChucNang;
	private String tenChucNang;
	public DTOChucNang(String idChucNang, String tenChucNang) {
		setiDChucNang(idChucNang);
		setTenChucNang(tenChucNang);
	}
	public String getTenChucNang() {
		return tenChucNang;
	}
	public void setTenChucNang(String tenChucNang) {
		this.tenChucNang = tenChucNang;
	}
	public String getiDChucNang() {
		return iDChucNang;
	}
	public void setiDChucNang(String iDChucNang) {
		this.iDChucNang = iDChucNang;
	}
}
