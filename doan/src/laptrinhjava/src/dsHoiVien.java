package doanJava;

import java.util.ArrayList;
import java.util.Scanner;

public class dsHoiVien {
	Scanner sc = new Scanner(System.in);
	private ArrayList<HoiVien> dshv;
	
	public dsHoiVien() {
		dshv = new ArrayList<HoiVien>();
	}

	public dsHoiVien(ArrayList<HoiVien> dshv) {
		this.dshv = dshv;
	}
	//thêm hội viên
	public void themHoiVien(HoiVien hv) {
		this.dshv.add(hv);
	}
	
	//xóa hội viên
	public boolean xoaHoiVien(HoiVien hv) {
		for (HoiVien hoiVien : dshv) {
			if(hoiVien.getMaHoiVien().equals(hv.getMaHoiVien())) {
				dshv.remove(hoiVien);
				return true;
			}
		}
		return false;
	}
	//sửa hội viên
	public void suaHoiVien(String mahv) {
		boolean timthay = false;
		for (HoiVien hv : dshv) {
			if(hv.getMaHoiVien().equals(mahv)) {
				System.out.println("nhập thông tin mới cho hội viên: ");
				hv.nhap();
				timthay = true;
				break;
			}
		}
		if (!timthay) {
	        System.out.println("Không tìm thấy hội viên với mã " + mahv);
	    }
	}
	public void xuatHoiVien() {
		for (HoiVien hv : dshv) {
			System.out.println(hv);
		}
	}
}
