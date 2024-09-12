package DTO;

public class DTOQuyen {
	private String IDQuyen;
	private String TenQuyen;
	
	public DTOQuyen(String IDQuyen, String TenQuyen) {
		this.setIDQuyen(IDQuyen);
		this.setTenQuyen(TenQuyen);
	}
	public String getIDQuyen() {
		return IDQuyen;
	}
	public void setIDQuyen(String iDQuyen) {
		IDQuyen = iDQuyen;
	}
	public String getTenQuyen() {
		return TenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		TenQuyen = tenQuyen;
	}
	
}
