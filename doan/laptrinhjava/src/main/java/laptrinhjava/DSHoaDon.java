package laptrinhjava;

import java.time.LocalDate;
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
    public void them(String maHoiVien,String maCoSo,int tongTien, LocalDate ngayXuatHoaDon)
    {
        dsHoaDon.add(new HoaDon(maHoiVien,maCoSo,tongTien,ngayXuatHoaDon));
    }
    public void xoa(String maHoaDon)
    {
        for(HoaDon i:dsHoaDon)
        if(i.getMaHoaDon().equals(maHoaDon)) dsHoaDon.remove(i);
    }
    public void sua(String maHoaDon,String maHoiVien,String maCoSo,int tongTien, LocalDate ngayXuatHoaDon)
    {
        for(HoaDon i:dsHoaDon)
        if(i.getMaHoaDon().equals(maHoaDon))
        {
            i.setMaHoiVien(maHoiVien);
            i.setMaCoSo(maCoSo);
            i.setTongTien(tongTien);
            i.setNgayXuatHoaDon(ngayXuatHoaDon);
        }
    }
}
