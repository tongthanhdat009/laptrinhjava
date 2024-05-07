package BLL;

import DAL.DataHoiVien;
import DTO.HoiVien;

public class BLLDangKy {
	private DataHoiVien datahoivien;
	public BLLDangKy() {
		datahoivien = new DataHoiVien();
	}
	public String taoMaHoiVienMoi() {
		return datahoivien.taoMaHoiVienMoi();
	}
	public boolean KiemTraDangKy(HoiVien hv) {
		return datahoivien.dangkiHoiVien(hv);
	}
}
