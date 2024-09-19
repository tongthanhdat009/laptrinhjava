package BLL;

import DAL.DataHoiVien;
import DAL.DataTaiKhoan;
import DTO.DTOTaiKhoan;
import DTO.HoiVien;

public class BLLDangKy {
	private DataHoiVien datahoivien;
	private DataTaiKhoan dataTaiKhoan;
	public BLLDangKy() {
		datahoivien = new DataHoiVien();
		dataTaiKhoan = new DataTaiKhoan();
	}
	public String taoMaHoiVienMoi() {
		return datahoivien.taoMaHoiVienMoi();
	}
	public boolean KiemTraDangKy(HoiVien hv) {
		return datahoivien.dangkiHoiVien(hv);
	}
	public String kiemTraMaTK() {
    	return dataTaiKhoan.taoMaTaiKhoanMoi();
    }
	public boolean themTKhoan(DTOTaiKhoan tk) {
		return dataTaiKhoan.themTK(tk);
	}
	
	public boolean kiemTraTenTK(String tenTaiKhoan) {
		return dataTaiKhoan.kiemTraTrungLapTK(tenTaiKhoan);
	}
}
