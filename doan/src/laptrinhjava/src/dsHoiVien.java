import java.util.ArrayList;
public class dsHoiVien {
	private ArrayList<HoiVien> dshv;
	
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
}
