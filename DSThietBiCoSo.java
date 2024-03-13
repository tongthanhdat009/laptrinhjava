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
        ThietBiCoSo newThietBiCoSo = new ThietBiCoSo(maThietBi, maCoSo, ngayNhap);
        dsThietBiCoSo.add(newThietBiCoSo);
    }
    public void xoa(int index)
    {
        dsThietBiCoSo.remove(index);
    }
    public void sua(int index, String maThietBi, String maCoSo, LocalDate ngayNhap)
    {
        dsThietBiCoSo.get(index).setMaCoSo(maCoSo);
        dsThietBiCoSo.get(index).setMaThietBi(maThietBi);
        dsThietBiCoSo.get(index).setNgayNhap(ngayNhap);
    }
}