package DTO;
import java.util.ArrayList;
public class dsHoiVien {
	public ArrayList<HoiVien> dshv;
	
	public dsHoiVien() {
		dshv = new ArrayList<HoiVien>();
	}

	public dsHoiVien(ArrayList<HoiVien> dshv) {
		this.dshv = dshv;
	}
	public ArrayList<HoiVien> getDSHoiVien()
	{
		return dshv;
	}
	public void them(HoiVien a)
	{
		dshv.add(a);
	}
}
