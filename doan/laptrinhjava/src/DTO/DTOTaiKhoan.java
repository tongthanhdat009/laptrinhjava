package DTO;

public class DTOTaiKhoan {
	private String IDTaiKhoan;
	private String taiKhoan;
	private String matKhau;
	private String IDQuyen;
	private String Status;//trạng thái hoạt động
	
	public DTOTaiKhoan(String IDTaiKhoan, String taiKhoan, String matKhau, String IDQuyen, String Status) {
		setIDTaiKhoan(IDTaiKhoan);
		setTaiKhoan(taiKhoan);
		setMatKhau(matKhau);
		setIDQuyen(IDQuyen);
		setStatus("OFF");
		
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getIDTaiKhoan() {
		return IDTaiKhoan;
	}
	public void setIDTaiKhoan(String iDTaiKhoan) {
		IDTaiKhoan = iDTaiKhoan;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void AutoSetTaiKhoan(String taiKhoan) {
		switch(this.IDQuyen) {
			case "Q0001":
				this.taiKhoan = String.format("TKHV%03d",this.IDTaiKhoan.substring(2)); 
				break;
			case "Q0002":
				this.taiKhoan = String.format("TKNV%03d",this.IDTaiKhoan.substring(2));
				break;
			case "Q0003":
				this.taiKhoan = String.format("TKQL%03d",this.IDTaiKhoan.substring(2));
				break;
			default:
				this.taiKhoan = taiKhoan;
				break;
		}
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public void autoSetMatKhau(String matKhau) {
		switch(this.IDQuyen) {
		case "Q0001":
			this.matKhau = String.format("MKHV%03d",this.IDTaiKhoan.substring(2)); 
			break;
		case "Q0002":
			this.matKhau = String.format("MKNV%03d",this.IDTaiKhoan.substring(2));
			break;
		case "Q0003":
			this.matKhau = String.format("MKQL%03d",this.IDTaiKhoan.substring(2));
			break;
		default:
			this.matKhau = matKhau;
			break;
	}
		this.matKhau = matKhau;
	}
	public String getIDQuyen() {
		return IDQuyen;
	}
	public void setIDQuyen(String iDQuyen) {
		IDQuyen = iDQuyen;
	}
}
