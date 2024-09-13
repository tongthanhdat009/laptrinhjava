package DTO;

public class DTOPhanQuyen {
	private String IDQuyen;
	private String IDChucNang;
	public DTOPhanQuyen(String IDQuyen, String IDChucNang) {
		setIDChucNang(IDChucNang);
		setIDQuyen(IDQuyen);
	}
	public String getIDQuyen() {
		return IDQuyen;
	}
	public void setIDQuyen(String iDQuyen) {
		IDQuyen = iDQuyen;
	}
	public String getIDChucNang() {
		return IDChucNang;
	}
	public void setIDChucNang(String iDChucNang) {
		this.IDChucNang = iDChucNang;
	}
}
