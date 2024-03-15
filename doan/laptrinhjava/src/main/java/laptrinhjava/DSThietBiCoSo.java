package laptrinhjava;

import java.time.LocalDate;
import java.util.ArrayList;
public class DSThietBiCoSo
{
    private ArrayList<ThietBiCoSo> dsThietBiCoSo;
    public DSThietBiCoSo()
    {
        dsThietBiCoSo = new ArrayList<>();
    }
    public DSThietBiCoSo(ArrayList<ThietBiCoSo> dsThietBiCoSo)
    {
        this.dsThietBiCoSo = dsThietBiCoSo;
    }
    public void them(String maThietBi, String maCoSo, LocalDate ngayNhap)
    {
        dsThietBiCoSo.add(new ThietBiCoSo(maThietBi, maCoSo, ngayNhap));
    }
    public void xoa(String maThietBi, String maCoSo)
    {
        for(ThietBiCoSo i:dsThietBiCoSo)
        if(i.getMaCoSo().equals(maCoSo)&&i.getMaThietBi().equals(maThietBi))
        dsThietBiCoSo.remove(i);
    }
}
