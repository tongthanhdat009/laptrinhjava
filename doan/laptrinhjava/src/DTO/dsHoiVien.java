package DTO;
import java.util.ArrayList;
public class dsHoiVien {
	public ArrayList<HoiVien> dsHV;
	
	public dsHoiVien() {
		dsHV = new ArrayList<HoiVien>();
	}

	public dsHoiVien(ArrayList<HoiVien> dsHV) {
		this.dsHV = dsHV;
	}
	public ArrayList<HoiVien> getDSHoiVien()
	{
		return dsHV;
	}
	public void them(HoiVien a)
	{
		dsHV.add(a);
	}
}
