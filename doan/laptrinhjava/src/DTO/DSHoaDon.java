package DTO;
import java.util.ArrayList;

public class DSHoaDon {
    private ArrayList<HoaDon> dsHoaDon;
    public DSHoaDon()
    {
        dsHoaDon = new ArrayList<>();
    }
    public DSHoaDon(ArrayList<HoaDon> dsHoaDon)
    {
        this.dsHoaDon = dsHoaDon;
    }
    public void them(HoaDon hoaDon)
    {
        dsHoaDon.add(hoaDon);
    }
}
