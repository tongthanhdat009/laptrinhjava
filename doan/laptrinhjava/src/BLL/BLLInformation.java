package BLL;

import DAL.DataTaiKhoan;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;

public class BLLInformation {
	DataTaiKhoan data;
	public BLLInformation() {
		data = new DataTaiKhoan();
	}
	public HoiVien layThongTinNguoiDung(DTOTaiKhoan tk) {
		return data.thongTinCaNhan(tk);
	}
	public boolean doiMatKhauHoiVien(DTOTaiKhoan tk, String pass) {
		return data.doiMatKhauTaiKhoan(tk,pass);
	}
}
