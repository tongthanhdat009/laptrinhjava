package laptrinhjava;


import java.util.Scanner;

public class dsHoiVien {
	Scanner sc = new Scanner(System.in);
	private HoiVien dshv[];
	private int soluong;
	
	public dsHoiVien() {
		System.out.println("nhập số lượng hội viên: ");
		soluong = sc.nextInt();
		dshv = new HoiVien[soluong];
		soluong = 0;
	}
	public void themHoiVien() {
		HoiVien hv = new HoiVien();
		hv.nhap();
		dshv[soluong++] = hv;
	}
	public void xoaHoivien() {
		if(soluong == 0) {
			System.out.println("không có hội viên để xóa");
			return;
		}
		System.out.println("nhập mã hội viên cần xóa: ");
		String maXoa = sc.nextLine();
		boolean daXoa = false;
		for(int i = 0; i < soluong; i++) {
			if(dshv[i].getMaHoiVien().equals(maXoa)) {
				for(int j = i; j < soluong - 1; j++) {
					dshv[j] = dshv[j + 1];
				}
				soluong--;
				daXoa = true;
				break;
			}
		}
	}
	public void suaHoiVien() {
		if(soluong == 0) {
			System.out.println("Không có họi viên để sửa");
			return;
		}
		System.out.println("nhập mã hội viên để sửa thông tin: ");
		String maSua = sc.nextLine();
		boolean daSua = false;
		for(int i = 0; i < soluong;i++) {
			if(dshv[i].getMaHoiVien().equals(maSua)) {
				System.out.println("nhập thông tin mới cho hội viên: ");
				dshv[i].nhap();
				daSua = true;
				break;
			}
		}
	}
}
